# Introduction 
After studying Netty, I decided to write a lightweight RPC framework based on Netty, Zookeeper, and Spring. The gains have been quite fruitful. However, I have limited knowledge and abilities, so there may be some oversights. If you have any criticisms or suggestions, please send them to my email at sli964@wisc.edu


# Features
- **Supports long connections**
- **Supports asynchronous invocation**
- **Supports heartbeat detection**
- **Supports JSON serialization**
- **Close to zero configuration, based on annotation for invocation**
- **Implemented service registry center based on Zookeeper**
- **Supports dynamic management of client connections**
- **Supports client service monitoring and discovery function**
- **Supports server-side service registration function**
- **Implemented based on Netty4.X version**

# Quick Start
### Server-side Development
- **Add your own Service under the server's Service, and add the @Service annotation**
	<pre>
	@Service
	public class TestService {
		public void test(User user){
			System.out.println("Called TestService.test");
		}
	}
	</pre>

- **Create a service interface and generate a class implements this interface**
	###### Interface as following
	<pre>
	public interface TestRemote {
		public Response testUser(User user);  
	}
	</pre>
	###### The implementation class is as follows. Add the @Remote annotation to your implementation class. This class is where you truly invoke the service. You can generate any form of Response you want to return to the client
	<pre> 
	@Remote
	public class TestRemoteImpl implements TestRemote{
		@Resource
		private TestService service;
		public Response testUser(User user){
			service.test(user);
			Response response = ResponseUtil.createSuccessResponse(user);
			return response;
		}
	}	
	</pre>


### Client-side Development
- **Create an interface on the client side, which is the interface you want to call**
```Java
	public interface TestRemote {
		public Response testUser(User user);
	}
```

### Usage
- **Generate an interface form of attribute at the place where you want to make the call, and add the @RemoteInvoke annotation to this attribute**
  ```Java
	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(classes=RemoteInvokeTest.class)
	@ComponentScan("\\")
	public class RemoteInvokeTest {
		@RemoteInvoke
		public static TestRemote userremote;
		public static User user;
		@Test
		public void testSaveUser(){
			User user = new User();
			user.setId(1000);
			user.setName("Jason Lee");
			userremote.testUser(user);
		}
	}
  ```

### Result
- **Result of ten thousand calls**
![Markdown](https://s1.ax1x.com/2018/07/06/PZMMBF.png)

- **Result of one hundred thousand calls**
![Markdown](https://s1.ax1x.com/2018/07/06/PZM3N9.png)

- **Result of one million calls**
![Markdown](https://s1.ax1x.com/2018/07/06/PZMY1x.png)



# Overview

![Markdown](https://s1.ax1x.com/2018/07/06/PZK3SP.png)
