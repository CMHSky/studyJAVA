package net.spring.study;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// 通过XML配置实现
// 通过 <bean> 元素中的 init-method 和 destroy-method 属性，指定Bean的生命周期回调方法
public class XMLLifeCycleBean {
    private static final Log LOGGER = LogFactory.getLog(XMLLifeCycleBean.class);
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "XMLLifeCycleBean{" +
                "name='" + name + '\'' +
                '}';
    }

    public void init() {
        LOGGER.info("在 XML 配置中通过 init-method 属性指定初始化方法：init() 方法");
    }

    public void destroy() {
        LOGGER.info("在 XML 配置中通过 destroy-method 属性指定回调方法：destroy() 方法");
    }
}
