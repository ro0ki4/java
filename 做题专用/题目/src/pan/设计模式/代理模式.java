package pan.设计模式;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author ro0ki4
 * @data 2020/10/9 23:11
 * version 1.0
 */

public class 代理模式 {
    public static void main(String[] args) {
    /*************静态代理*************/
        StaticProxy staticproxy = new StaticWork();
        StaticWorkProxy staticWorkProxy = new StaticWorkProxy();
        staticWorkProxy.setProxy(staticproxy);
        staticWorkProxy.action(new Object());
        
        /*********************************/
        /**
         * 使用JDK动态代理使用Proxy.newProxyInstance(classload,interface.class,InvocationHandler)方法
         *
         * 使用CGlib通过Enhancer.create(proxyclass.class,MethodInterceptor)方法
         */
        DynamicProxy dynamicWork = new DynamicWork();
        InvocationHandler dynamicWorkProxy = new DynamicWorkProxy(dynamicWork);
        DynamicProxy proxy = (DynamicProxy)Proxy.newProxyInstance(dynamicWork.getClass().getClassLoader(), dynamicWork.getClass().getInterfaces(), dynamicWorkProxy);
        proxy.action(new Object());
        //此处报错是缺少了asm依赖，CGlib依赖于asm.jar
        StaticProxy proxy2 =(StaticProxy) Enhancer.create(staticproxy.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                
                return method.invoke(dynamicWork,args);
            }
        });
        
        proxy2.action(new Object());
    }
}

interface StaticProxy {
    
    public void action(Object o);
    
}

class StaticWork implements StaticProxy {
    @Override
    public void action(Object o) {
        System.out.println(o.getClass().getName() + "开启");
    }
}

class StaticWorkProxy {
    
    private StaticProxy proxy;
    
    public void setProxy(StaticProxy proxy){
        this.proxy = proxy;
    }
    
    
    public void action(Object o) {
        System.out.println("代理类before");
        proxy.action(o);
        System.out.println("代理类after");
    }
}

/************************************************************/
/**  动态代理  **/

interface DynamicProxy{
    public void action(Object o);
}


class DynamicWork implements  DynamicProxy{
    
    @Override
    public void action(Object o){
        System.out.println(o.getClass().getName() + "开启");
    }
    
}

class DynamicWorkProxy implements InvocationHandler {
    
    Object o;
    
    public DynamicWorkProxy(Object o){
        this.o = o;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before" + method.getName());
        method.invoke(o,args);
        System.out.println("after" + method.getName());
        return null;
    }
}