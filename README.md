# spring-less5
Note:
## Bean Life Cycle
![image](https://github.com/AyaElsayed1221/spring-less5/assets/101202928/a14a5f1a-90d2-41fb-9656-bb36a41a8fdf)
<Br></br>

## In Standalone application
//Creating container object manually<br>
ApplicationContext context = new ClassPathXmlApplicationContext();<BR>
//destroy container object manually<br>
context.close();

In the <B>standalone spring app<\b>, we can <b>destroy/stop<\b> the ApplicationContext by calling the <B>close()</B> or <B>registerShutdownHook</B>.

## In WEB application
You don't need to create and destroy the container object. This will be automatically done. We will explore more while studying Spring MVC.

![image](https://github.com/AyaElsayed1221/spring-less5/assets/101202928/534fa8ed-0947-417e-a996-8c07b70d50ff)

Our current program is a standalone program because we don't have any URLs to deal with. So let's close the container manually here.