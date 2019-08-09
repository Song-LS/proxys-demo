package com.sls.common.core;

import cn.gjing.ParamUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author sls
 * BeanDefinitionRegistryPostProcessor 可以使我们动态注入bean
 **/
public class ProxyRegister implements BeanDefinitionRegistryPostProcessor {

    private String basePackage;

    public ProxyRegister(String basePackage) {
        this.basePackage = basePackage;
    }

    /*
     * 扫描指定包及其子包下面的所有非接口和非抽象类
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        if (ParamUtil.isEmpty(basePackage)) {
            return;
        }
        ServiceInterfacesScanner serviceInterfacesScanner = new ServiceInterfacesScanner(registry);
        serviceInterfacesScanner.doScan(basePackage);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
