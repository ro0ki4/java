package pan.xu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 注意t--的地方，如果分开写会出现两个10号票，线程的原理。。。。。。。。
 * 同步锁Lock();
 * new Lock().lock()
 * unlock()
 * 和synchronized()少部分不同。
 */
public class MAIPIAO implements Runnable{
    private static int sum=0;
    int t=10;
    Object lock=new Object();
    Object lock2=new Object();
    private final Lock locked=new ReentrantLock();
    public void run(){
        while(t>0){
            synchronized (lock){//******************************************
            if(t>0){
                //synchronized (lock){
                try{
                    Thread.sleep(10);
                }
                catch(Exception e){

                }
                //synchronized (lock){//可以看出，相同的原因是同时执行输出方法
                System.out.println(Thread.currentThread().getName()+"******"+t--+"       ");

                //synchronized(lock2){
                    sum++;
                    System.out.println("----------------------------------"+sum);}
                //}
            }
        }
    }

    public static void main(String[]args){
        MAIPIAO thread=new MAIPIAO();
        Thread thread1=new Thread(thread,"thread1");
        Thread thread2=new Thread(thread,"thread2");
        Thread thread3=new Thread(thread,"thread3");
        Thread thread4=new Thread(thread,"thread4");
        Thread thread5=new Thread(thread,"thread5");
        Thread thread6=new Thread(thread,"thread6");
        thread5.start();
        thread6.start();
        thread3.start();
        thread4.start();
        thread2.start();
        thread1.start();
    }

}
