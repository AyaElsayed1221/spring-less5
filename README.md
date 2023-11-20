# spring-less5
Note:
## In Standalone application
//Creating container object manually
ApplicationContext context = new ClassPathXmlApplicationContext();
//destroy container object manually
context.close();

## In WEB application
You don't need to create and destroy the container object. This will be automatically done. We will explore more while studying Spring MVC.
