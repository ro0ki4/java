package pan.并发相关;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ro0ki4
 * @data 2020/10/17 23:30
 * version 1.0
 * 使用LockSupport.park()来显示阻塞一个线程
 * 使用LockSupport.unpark()结束阻塞线程
 */
public class 使线程立即阻塞的方法 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始运行  " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LockSupport.park();
                System.out.println("结束阻塞了 " + Thread.currentThread().getName());
            }
        },"thread-1");
        thread1.start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始运行  " + thread1.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LockSupport.unpark(thread1);
                System.out.println("运行结束  "+ Thread.currentThread().getName());
                
            }
        },"thread-2").start();
        
        
    }
}
