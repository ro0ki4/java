package com.edu.xust.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理特点：
 *      字节码随用随加载，
 *      直接修改字节码
 *      源码不动
 *
 * 1.jdk提供的代理是通过使用Proxy.newProxyInstance(类加载器，被代理类的父接口的字节码数组，
 * invacationhandler(提供增强的代码））
 * 他只能代理实现了父接口的类
 *
 * 2.使用第三方提供的jar包来实现动态代理
 *
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer=new Producer();
        //final Producer producer1 = new Producer();
        //必须要强制转换为被代理类的父接口类型
        IProduce proxyProduce= (IProduce)Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(), new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //System.out.println("proxy" + proxy.toString()+"\n");
                /**
                 * proxy:被代理类
                 * method：代理的方法
                 * args：代理方法的参数
                 *
                 */
                Float money=(Float)args[0];
                if (method.getName().equals("saleProduce")) {
                    method.setAccessible(true);

                    System.out.println("你在售出产品");
                    return null;
                }
                else return method.invoke(producer, money*0.001f);
            }
        });
        proxyProduce.afterService(8888f);
        proxyProduce.saleProduce(9999f);
        System.out.println("eeeeeeeeeeeeeeeeeeee");
        //producer1.saleProduce(1000f);

    }
}
