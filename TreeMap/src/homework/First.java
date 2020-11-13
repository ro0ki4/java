package homework;

import jdk.internal.org.objectweb.asm.ClassVisitor;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class First {
    public static void main(String[] args) {
        TreeMap<String,String> map=new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                o1=o1.toLowerCase();
                o2=o2.toLowerCase();
                for(int i=0;i<o1.length()+1&&i<o2.length()+1;i++){

                    if(i>=o1.length()||i>=o2.length()){
                        if (o1.length() > o2.length())
                            return 1;
                        else if(o1.length()==o2.length()){
                            return 0;
                            //throw new RuntimeException("不要存入两个一样的单词");
                        }
                        else return -1;
                    }

                    if (o1.charAt(i) > o2.charAt(i))
                        return 1;
                    else if((int)o1.charAt(i)==(int)o2.charAt(i))
                        ;
                    else if(o1.charAt(i)<o2.charAt(i))
                        return -1;
                }
                return 1;
            }
        });

        map.put("b", "bbb");
        map.put("a", "aaa");
        map.put("cbe", "bbbbbb");
        map.put("c", "cccc");
        map.put("d", "dddd");
        map.put("cbe", "eee");
//        for(String i:map.keySet()){
//            System.out.println(i);
//        }
        Scanner scan = new Scanner(System.in);
        String str=null;
        Iterator iterator=map.keySet().iterator();

        while (iterator.hasNext()) {
            str=scan.nextLine();
            if((str.equals("Q") || str.equals("q"))){
                System.out.println("退出");
                break;
            }
            Object key=iterator.next();
            System.out.println(map.get(key));

        }
    }
}

class A extends ClassVisitor{

    public A(int i) {
        super(i);
    }

    public A(int i, ClassVisitor classVisitor) {
        super(i, classVisitor);
    }
}