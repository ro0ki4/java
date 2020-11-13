package pan.xu;
import java.util.*;
public class List_set_treeset {
    public static void main(String[]args){
        Set<student> xupan=new TreeSet<>();
        xupan.add(new student("yb",18));
        xupan.add(new student("xp",19));
        xupan.add(new student("wjz",20));
        xupan.add(new student("ztx",19));
        xupan.add(new student("zp",20));
        xupan.add(new student("ljh",19));
        System.out.println(xupan);//调用了treeset中的toString方法
    }
}
class student implements Comparable{
    String name;
    int age;
    public student(String name,int age){
        this.name=name;
        this.age=age;
    }
    @Override
    public int compareTo(Object o) {
        student stu=(student)o;
        if(stu.age>this.age)
            return 1;
        else if(stu.age<this.age)
            return -1;
        else if(stu.name.length() > this.name.length())
            return 1;
        else if(stu.name.length()<this.name.length())
            return -1;
        else if(stu.name.charAt(0) > this.name.charAt(0))
            return 1;
        else if(stu.name.charAt(0)<this.name.charAt(0))
            return -1;
        else if(stu.name.equals(this.name))
            return 0;
        else return 0;
    }
    @Override
    public String toString(){
        return this.name+this.age;
    }
}
/*
class teacher implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {//Object应转化为add()的参数的类型
        student s1=(student)o1;
        student s2=(student)o2;
        return s1.age-s2.age;
        return 0;
    }
}

 */