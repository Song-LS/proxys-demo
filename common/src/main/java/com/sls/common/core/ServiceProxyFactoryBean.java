package com.sls.common.core;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author sls
 * 通过FactoryBean实现接口代理
 **/
public class ServiceProxyFactoryBean<T> implements FactoryBean<T> {

    private Class<T> interfaces;

    public ServiceProxyFactoryBean(Class<T> interfaces) {
        this.interfaces = interfaces;
    }

    /**
     * 得到代理对象
     * @return
     * @throws Exception
     */
    @Override
    @SuppressWarnings("unchecked")
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(interfaces.getClassLoader(), new Class[]{interfaces},
                new ServiceProxy<>(interfaces));
    }

    @Override
    public Class<?> getObjectType() {
        return interfaces;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
