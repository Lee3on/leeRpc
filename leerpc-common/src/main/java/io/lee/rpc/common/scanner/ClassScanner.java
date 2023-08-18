package io.lee.rpc.common.scanner;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Class scanner
 * @author Shuaijie
 * @version 1.0.0
 */
public class ClassScanner {

    /**
     * File protocol
     */
    private static final String PROTOCOL_FILE = "file";
    /**
     * jar package protocol
     */
    private static final String PROTOCOL_JAR = "jar";
    /**
     * class file suffix
     */
    private static final String CLASS_FILE_SUFFIX = ".class";


    /**
     * Scan the specified package and get all the classes under the package
     * @param packageName package name
     * @param recursive Whether to scan recursively
     * @return List of all full class names under the specified package
     * @throws Exception Exception
     */
    public static List<String> getClassNameList(String packageName, boolean recursive) throws Exception{
        // List of all classes
        List<String> classNameList = new ArrayList<String>();
        // Get the name of the package and convert it to a valid path
        String packageDirName = packageName.replace('.', '/');
        // Define a collection of enumerations and loop to process things under this directory
        Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
        // Loop enumeration
        while (dirs.hasMoreElements()){
            // Get the next element
            URL url = dirs.nextElement();
            // Get the protocol name of the URL
            String protocol = url.getProtocol();
            // If it is a file protocol, it means that it is a normal file on the hard disk
            if (PROTOCOL_FILE.equals(protocol)) {
                // Get the physical address of the package
                String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                // Scan the classes under this package and add them to the collection
                findAndAddClassesInPackageByFile(packageName, filePath, recursive, classNameList);
            } else if (PROTOCOL_JAR.equals(protocol)){
                packageName = findAndAddClassesInPackageByJar(packageName, classNameList, recursive, packageDirName, url);
            }
        }
        return classNameList;
    }


    /**
     * Scan the jar package and add the class name to the collection
     * @param packageName package name
     * @param classNameList List of all full class names under the specified package
     * @param recursive Whether to scan recursively
     * @param packageDirName package directory name
     * @param url Url address of the package
     * @return Package name after processing for next call
     * @throws IOException IOException
     */
    private static String findAndAddClassesInPackageByJar(String packageName, List<String> classNameList, boolean recursive, String packageDirName, URL url) throws IOException {
        // If it is a jar package, define a JarFile
        JarFile jar = ((JarURLConnection) url.openConnection()).getJarFile();
        // Get an enumeration class from this jar package
        Enumeration<JarEntry> entries = jar.entries();

        // Loop iteration in the same way
        while (entries.hasMoreElements()) {
            // Get an entity in the jar, which can be a directory and some other files in the jar, such as META-INF
            JarEntry entry = entries.nextElement();
            String name = entry.getName();
            // If it starts with a "/", get the substring after the first "/"
            if (name.charAt(0) == '/') {
                name = name.substring(1);
            }
            // If the first half is the same as the defined package name
            if (name.startsWith(packageDirName)) {
                int idx = name.lastIndexOf('/');
                String currentPackageDir = "";
                // Get the package name if it ends with "/"
                if (idx != -1) {
                    currentPackageDir = name.substring(0, idx);
                    packageName = currentPackageDir.replace('/', '.');
                }
                // If it can be iterated and is a package
                if ((idx != -1 && currentPackageDir.equals(packageDirName)) || recursive){
                    // If it is a .class file and not a directory
                    if (name.endsWith(CLASS_FILE_SUFFIX) && !entry.isDirectory()) {
                        // Remove the ".class" at the end to get the real class name
                        String className = name.substring(packageName.length() + 1, name.length() - CLASS_FILE_SUFFIX.length());
                        classNameList.add(packageName + '.' + className);
                    }
                }
            }
        }
        return packageName;
    }


    /**
     * Scan all class information under the specified package in the current project
     * @param packageName package name
     * @param packagePath package path
     * @param recursive Whether to scan recursively
     * @param classNameList List of all full class names under the specified package
     */
    private static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, List<String> classNameList){
        // Get the directory and convert it to a file
        File dir = new File(packagePath);
        // If it does not exist or is not a directory, it returns
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        // If it exists, get the list of files under the directory
        File[] dirfiles = dir.listFiles(new FileFilter() {
            // Defines a filter rule:
            // If it can be looped (including subdirectories) or is a .class file
            public boolean accept(File file) {
                return (recursive && file.isDirectory()) || (file.getName().endsWith(CLASS_FILE_SUFFIX));
            }
        });
        // Loop all files
        for (File file : dirfiles) {
            // If it is a directory, continue to scan
            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "." + file.getName(),
                        file.getAbsolutePath(),
                        recursive,
                        classNameList);
            }else {
                // If it is a .class file, remove the .class suffix and add it to the collection
                String className = file.getName().substring(0, file.getName().length() - CLASS_FILE_SUFFIX.length());
                // Add to the collection
                classNameList.add(packageName + '.' + className);
            }
        }
    }
}
