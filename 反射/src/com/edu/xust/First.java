package com.edu.xust;

import java.lang.reflect.Method;

/**
 * 反射的三种方式
 * 1.通过实例对象的getclass方法
 * 2.通过类名来获取
 * 3.通过相对路径来获取使用forname方法
 *
 * 在反射中构造器constructor
 *              method--方法
 *              field--属性
 *              accessible--设置或者取消访问检查，用于私有属性或方法的访问
 */
public class First {
    private String xupan = "hehe";

    public static void main(String[] args) throws Exception{

        A one=new A(1,2);
        System.out.println(one.getClass().getDeclaredFields()[2].get(one));

        System.out.println(Class.forName("com.edu.xust.A").getField("a3").get(one));

        System.out.println(A.class.getField("a3").get(one));

        one.getClass().getMethod("function_B").invoke(one);
        A.class.getMethod("function_B").invoke(one);

        //A.class.getMethod("function_C").setAccessible(true);
        Method[] methods=A.class.getDeclaredMethods();
        for(Method method:methods){
            method.setAccessible(true);
            method.invoke(one);
        }
        //one.getClass().getMethod("function_C").setAccessible(true);
        A.class.getDeclaredMethods()[1].setAccessible(true);
        A.class.getDeclaredMethods()[1].invoke(one);
        System.out.println("结束了");
    }
}

class A{
    private static int a1;
    private int a2;
    public int a3=88;

    public A(int a1,int a2){
        this.a1=a1;
        this.a2=a2;
    }
    public void function_B(){
        System.out.println("B");
    }
    private void function_C(){
        System.out.println("C");
    }
}
