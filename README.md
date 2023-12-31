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

## Note: we can remove the <context annotation-config /> from the beans.xml and add instead add the following bean <bean class=" org.springframework.context.annotation.CommonAnnotationBeanPostProcessor"/>
this bean activates the @PostConstruct and the @PreDestry annotations without the use of the <context annotation-config/> tag
but notice that at that time u have to use the property tag instead of the @Value annotation because this bean activates only the init and destroy annotations and doesn't activate all annotations.

## Note: Instead of using the annotations @PostConstruct and @PreDestry u can configure where is the init method and the destroy method from the XML configuration
as declared in the following pic
![image](https://github.com/AyaElsayed1221/spring-less5/assets/101202928/5c4adf80-5e6f-4fce-9484-ab16052ea615)

## A common question in interviews 
### What is registerShutdownHook(); ?
- It is another way to close the container.
- There is no big difference between it and the close() method, It is an alternative to it.
- The only difference between them is: that registerShutdownHook() will execute once the main method ends no matter in which line it was called. (i.e. If I want to getBean after I call registerShutdownHook(), it will return the bean)
- But the close() will be executed once it was called. (i.e.  If I want to getBean after I call the close() method, it will throw Exception)

![image](https://github.com/AyaElsayed1221/spring-less5/assets/101202928/405e9ebb-d3f0-4cb3-95d8-efdf1c820a2b)

## IMP NOTE: A good habit to keep all the init and destroy method name the same to all your classes
then instead of duplication of code for each bean and write init-method ="" and destroy-method ="", we can write them only once in the top configuration as default-init-method ="", and default-destroy-method ="".

![image](https://github.com/AyaElsayed1221/spring-less5/assets/101202928/d3ff1af5-48e0-4e0a-97cc-0e9a837c71b3)

![image](https://github.com/AyaElsayed1221/spring-less5/assets/101202928/4c19c8d7-009a-4f0b-8f86-9bbb23a3d232)

![image](https://github.com/AyaElsayed1221/spring-less5/assets/101202928/e494e96a-9bb4-441d-b774-296efaaab401)

![image](https://github.com/AyaElsayed1221/spring-less5/assets/101202928/ef2cb8f8-ad63-47db-8fb3-33a15b1b7088)

![image](https://github.com/AyaElsayed1221/spring-less5/assets/101202928/a49ab8f1-76f9-48f2-946a-a34410b6d187)

![image](https://github.com/AyaElsayed1221/spring-less5/assets/101202928/d1986a1f-08f1-4f6d-be74-3527d2a838d4)

### No need for annotation or XML here to make the init and the destroy methods as follows:

![image](https://github.com/AyaElsayed1221/spring-less5/assets/101202928/37b03c7e-2d48-4758-bdfa-c51f48b7431a)









