package pan.xu;

import java.util.ArrayList;

public class TONGXING {
    public static void main(String[]args){
        ArrayList<Object> good=new ArrayList<>();
        long start=System.currentTimeMillis();
        //int fuck=0;
        Thread thread1=new Thread(()->{
            int num1=0;
            while(System.currentTimeMillis()-start<100){
            good.add(num1+"");
            System.out.println(Thread.currentThread().getName()+"制造商品"+num1+++"号");
            try{
                Thread.sleep(0);
            }catch(Exception e){

                }
            }
            /**
             * 之所以不行是因为改变了fuck变量的值，传值是无法改变的，本质还是一个方法的调用，而方法的调用也
             * 不应该改变一个变量的值，但是可以改变一个引用变量的值。
             */
        },"THREAD1");

        Thread thread2=new Thread(()->{
            int num=0;
            while(System.currentTimeMillis()-start<100){
                try{
                good.remove(num+"");//需要的是一个object对象，不是
                }
                catch(Exception e){
                    System.out.println("数组越界");
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"出售商品"+num+++"号");
                try{
                    Thread.sleep(0);
                }catch(Exception e){

                }
            }
        },"THREAD2");thread2.start();
        thread1.start();


    }
}
