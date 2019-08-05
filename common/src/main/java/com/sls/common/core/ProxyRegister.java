package com.sls.common.core;

import cn.gjing.ParamUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author sls
 **/
public class ProxyRegister implements BeanDefinitionRegistryPostProcessor {

    private String basePackage;

    public ProxyRegister(String basePackage) {
        this.basePackage = basePackage;
    }

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
