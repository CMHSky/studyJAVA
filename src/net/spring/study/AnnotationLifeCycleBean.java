package net.spring.study;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// 通过注解实现
// 可以通过 JSR-250 的 @PostConstruct 和 @PreDestroy 注解，指定Bean的生命周期回调方法
public class AnnotationLifeCycleBean {
    private static final Log LOGGER = LogFactory.getLog(XMLLifeCycleBean.class);
    private String name;

    public AnnotationLifeCycleBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AnnotationLifeCycleBean{" +
                "name='" + name + '\'' +
                '}';
    }

    @PostConstruct
    public void init() {
        LOGGER.info("通过 @PostConstruct 注解，指定初始化方法：init() 方法");
    }

    @PreDestroy
    public void destroy() {
        LOGGER.info("通过 @PreDestroy 注解，指定初始化方法：destroy() 方法");
    }
}
