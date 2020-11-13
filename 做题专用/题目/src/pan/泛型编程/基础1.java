package pan.泛型编程;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ro0ki4
 * @data 2020/10/1 20:18
 * version 1.0
 */
public class 基础1 {
    static List<? extends Test1> extendTest = new ArrayList<Test2>();
    static List<? super Test2> superTest = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(test1(new Test2()));
        //List<Test1> aa = test2(new Test2());//会报错
    }
    
    public static <T extends ArrayList> T min(List<Integer> test){
        return ((T) test);
    }
    
    public static <T extends Test1> T test1(Test2 t1){
        return (T) t1;
    }
    
    public static List<Test2> test2(Test2 t2){
        List<Test2> list = new ArrayList<>();
        list.add(t2);
        return list;
    }
    
}

class A<T>{
    T name;
    public A(){}
    public A(T t){
        this.name = t;
    }
    
    @Override
    public String toString() {
        return "A{" + "name=" + name + '}';
    }
}

class B<T,V> extends A<T>{
    T tname;
    V vname;
    
    public B(){}
    public B(T t,V v){
        this.tname = t;
        this.vname = v;
    }
    
    @Override
    public String toString() {
        return "B{" + "name=" + name + ", tname=" + tname + ", vname=" + vname + this.getClass().getName() + '}';
    }
}

class Test1{
    
    @Override
    public String toString() {
        return "Test1{}";
    }
}

class Test2 extends Test1{
    @Override
    public String toString() {
        return "Test2{}";
    }
}
