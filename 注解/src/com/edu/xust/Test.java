package com.edu.xust;

import java.lang.reflect.Field;

/**
 * 说明可以使用别的构造方法来传递构造方法。
 */

public class Test {
    public static void main(String[] args) throws Exception{
        Class<Demo> clazz= Demo.class;
        GirlFriendNotFound one = clazz.getAnnotation(GirlFriendNotFound.class);
        System.out.println(one.value());
        Field two = clazz.getField("A");
        GirlFriendNotFound tt = two.getAnnotation(GirlFriendNotFound.class);
        System.out.println(tt.value());
        System.out.println(tt.property());

    }

}


class A {
    private int num;
    public A(int num){
        this.num = num;
    }
    public A(){
        this(5);
    }
    public void B(){}
}

class AA extends A{
    @Override
    public void B(){
        System.out.println(" ");
    }
}