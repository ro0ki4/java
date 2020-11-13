package com.edu.xust.cglib;

import com.edu.xust.proxy.IProduce;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 1.jdk提供的代理是通过使用Proxy.newProxyInstance(类加载器，被代理类的父接口的字节码数组，
 * invacationhandler(提供增强的代码））
 * 他只能代理实现了父接口的类
 * <p>
 * 2.使用第三方提供的jar包来实现动态代理
 * cglib的create方法
 * Enhance.create()
 * 被代理类不能是最终类(不能是final修饰的类)
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();
        Producer proxyProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("methodproxy" + methodProxy.toString());
                Float money = (Float) args[0];
                if (method.getName().equals("saleProduce")) {
                    method.setAccessible(true);
                    System.out.println("你在售出产品");
                    return null;
                } else return method.invoke(producer, money-1);
            }
        });
        proxyProducer.afterService(1000f);

    }
}
