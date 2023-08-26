# Introduction 
After studying Netty, I decided to write a lightweight RPC framework based on Netty, Zookeeper, and Spring. The gains have been quite fruitful. However, I have limited knowledge and abilities, so there may be some oversights. If you have any criticisms or suggestions, please send them to my email at sli964@wisc.edu


# Features
- Supports long connections
- Supports asynchronous invocation
- Supports heartbeat detection
- Supports Hessian2 and Kyro serialization
- Implements service registry center based on Zookeeper
- Supports dynamic management of client connections
- Supports client service monitoring and discovery function
- Supports server-side service registration function

# Scanning of core annotations
Before developing the scanning logic for the `@RpcService` and `@RpcReference` annotations, 
we can first implement logic to scan all classes in a specified package. 
The specific requirements are as follows:

- Scan all classes in the specified package, whether these classes are in the current project or in referenced Jar files. They all need to be scanned.
- The file extension of the classes that truly need to be scanned must be `.class`, 
as only `.class` files are compiled Java class files.
- Return a collection of the fully-qualified class names for all classes within the specified package.