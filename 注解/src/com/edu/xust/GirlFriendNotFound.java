package com.edu.xust;
/**
 * java中只有四个元注解
 * Document--生成文档可有可无
 * Target--用来指定注解的作用域，比如限定方法，或者限定只有属性等
 * Retention--指定注解的声明周期，三种枚举类型source，class，runtime--基本所有的自定义注解都需要使用该注解。
 * Inherited--使用了该注解的注解只要在某个类使用了，那么该类的所有的子类都相当于注解了使用了该注解的注解。
 *
 *
 *   @Target 表示该注解用于什么地方，可能的值在枚举类 ElemenetType 中，包括：
 *       ElemenetType.CONSTRUCTOR----------------------------构造器声明
 *       ElemenetType.FIELD --------------------------------------域声明（包括 enum 实例）
 *       ElemenetType.LOCAL_VARIABLE------------------------- 局部变量声明
 *       ElemenetType.METHOD ----------------------------------方法声明
 *       ElemenetType.PACKAGE --------------------------------- 包声明
 *       ElemenetType.PARAMETER ------------------------------参数声明
 *       ElemenetType.TYPE--------------------------------------- 类，接口（包括注解类型）或enum声明
 *  @Retention 表示在什么级别保存该注解信息。可选的参数值在枚举类型 RetentionPolicy 中，包括：
 *       RetentionPolicy.SOURCE ---------------------------------注解将被编译器丢弃
 *       RetentionPolicy.CLASS -----------------------------------注解在class文件中可用，但会被VM丢弃
 *       RetentionPolicy.RUNTIME VM-------将在运行期也保留注释，因此可以通过反射机制读取注解的信息。
 *   @Documented 将此注解包含在 javadoc 中 ，它代表着此注解会被javadoc工具提取成文档。在doc文档中的内容会因为此注解的信息内容不同而不同。相当与@see,@param 等。
 *
 *   @Inherited 允许子类继承父类中的注解。
 *
 *
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface GirlFriendNotFound{
    public String value() default "徐攀";

    public String property() default "无属性";
}

