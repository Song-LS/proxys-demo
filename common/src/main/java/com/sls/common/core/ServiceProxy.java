package com.sls.common.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sls
 **/
public class ServiceProxy<T> implements InvocationHandler {

    private Class<T> interfaces;

    ServiceProxy(Class<T> interfaces) {
        this.interfaces = interfaces;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().equals(interfaces)) {
            System.out.println("执行您的方法：" + method.getName());
            return method.getName();
        } else {
            return method.invoke(new DefaultService(), args);
        }
    }
}
