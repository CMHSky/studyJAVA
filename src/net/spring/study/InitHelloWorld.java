package net.spring.study;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class InitHelloWorld implements BeanPostProcessor, Ordered {

    // 当需要添加多个后置处理器实现类时，默认情况下Spring容器会根据后置处理器的定义顺序来依次执行
    // 也可以通过实现 Ordered 接口的 getOrder() 方法指定后置处理器的执行顺序
    // 该方法返回值为整数，默认值为0，取值越大优先级越低
    @Override
    public int getOrder() {
        return 5;
    }

    // postProcessBeforeInitialization() 方法：在Bean实例化、属性注入后、初始化前调用
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("A Before : " + beanName);
        return bean;
    }

    // postProcessAfterInitialization() 方法：在Bean实例化、属性注入、初始化都完成后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("A After : " + beanName);
        return bean;
    }
}
