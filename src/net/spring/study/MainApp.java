package net.spring.study;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    private static final Log LOGGER = LogFactory.getLog(MainApp.class);

    public static void main(String[] args) {
        // ClassPathXmlApplicationContext 这个类用于加载Spring配置文件、创建和初始化所有对象
        // IoC Inversion of Control 控制翻转 Spring通过IoC来管理所有Java对象的实例化和初始化
        // 我们可以把Spring IoC容器看作是一个大工厂，Bean相当于工厂的产品
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        // ApplicationContext.getBean() 方法用来获取Bean
//        HelloWorld obj = context.getBean("hello world", HelloWorld.class);
//        obj.getMessage();

        // Spring Bean 属性注入① 构造函数注入
        // 获取名为 student 的 Bean
//        Student student = context.getBean("student", Student.class);
//        LOGGER.info(student.toString());

        // Spring Bean 属性注入② setter注入
//        Student2 student2 = context.getBean("student2", Student2.class);
//        LOGGER.info(student2.toString());

        // 注入内部bean
//        Student2 student3 = context.getBean("student3", Student2.class);
//        LOGGER.info(student3.toString());

        // 注入集合属性
//        JavaCollection collection = context.getBean("javaCollection", JavaCollection.class);
//        LOGGER.info(collection.toString());

        // 注入其他属性
//        InjectNull injectNull = context.getBean("injectNull", InjectNull.class);
//        LOGGER.info(injectNull.toString());

        // Spring Bean作用域 单例(Singleton)
        // 默认值，单例模式，表示在Spring容器中只有一个 Bean 实例
        // 可以看出，两次获得的 Bean 实例地址完全一样，这说明IoC容器只创建了一个singletonBean实例
//        SingletonBean singletonBean = context.getBean("singletonBean", SingletonBean.class);
//        SingletonBean singletonBean2 = context.getBean("singletonBean", SingletonBean.class);
//        System.out.println(singletonBean);
//        System.out.println(singletonBean2);

        // Spring Bean作用域 原型(prototype)
        // 原型模式，表示每次通过 Spring 容器获取Bean时，容器都会创建一个新的 Bean 实例
        // 可以看出，两次输出的地址并不相同，这说明在 prototype 作用域下，Spring容器创建了两个不同的实例
//        SingletonBean prototypeBean = context.getBean("prototypeBean", SingletonBean.class);
//        SingletonBean prototypeBean2 = context.getBean("prototypeBean", SingletonBean.class);
//        System.out.println(prototypeBean);
//        System.out.println(prototypeBean2);

        // Spring Bean自定义生命周期的实现
        // 通过接口实现
//        LifeCycleBean l1 = context.getBean("lifeCycleBean", LifeCycleBean.class);
//        LOGGER.info(l1);
        // 通过XML配置实现
//        XMLLifeCycleBean l2 = context.getBean("xmlLifeCycleBean", XMLLifeCycleBean.class);
//        LOGGER.info(l2);
        // 通过注解实现
//        AnnotationLifeCycleBean l3 = context.getBean("annotationLifeCycleBean", AnnotationLifeCycleBean.class);
//        LOGGER.info(l3);

        // Spring Bean 指定Bean之间的继承关系
        Dog dog = context.getBean("dog", Dog.class);
        System.out.println(dog);

        context.close();
    }
}