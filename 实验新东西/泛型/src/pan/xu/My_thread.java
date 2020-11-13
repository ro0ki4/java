package pan.xu;

import java.util.ArrayList;

public class My_thread {
    public static void main(String[]args){
        ArrayList<String>[]xupan=new ArrayList[10];

        int one =1;
        String two=12+"";
        System.out.println(two);
        //Integer three=Integer.getInteger(two);
        //System.out.println(three.byteValue());
        xupan xumouren=()->{
            System.out.println(Thread.currentThread().getName()+"   "+xupan.class.getName());
        };
        xumouren.haha();
    }
}

interface xupan{
    public static final Object object=new Object();
    public void haha();
}