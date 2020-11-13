package pan.设计模式;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author ro0ki4
 * @data 2020/10/3 15:07
 * version 1.0
 */
public class 生产者消费者模式 {
    volatile static int sum = 0;
    public static void main(String[] args) {
        List<String> goods = new ArrayList<>();//仓库
        
        long current = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int num = 0;
                
                while (System.currentTimeMillis() - current < 100 || sum < 10) {
                    synchronized (goods) {
                    ///////////////////////////////////
                        sum++;
                        if (goods.size() < 1) {
                            System.out.println(Thread.currentThread().getName() + "生产" + num);
                            goods.add("" + num++);
                        } else {
                            try {
                                goods.wait();
                            } catch (InterruptedException e) {
                                ;
                            }
                        }
                    }
                    ////////////////////////////////////////
                }
            }
        }, "生产者");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                
                while (System.currentTimeMillis() - current < 100 || sum < 10) {
                    synchronized (goods) {
                        sum++;
                        if (goods.size() > 0) {
                            System.out.println(Thread.currentThread().getName() + "消费" + goods.remove(0));
                        } else {
                            goods.notifyAll();
                        }
                    }
                }
            }
        }, "消费者1");
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
            
                while (System.currentTimeMillis() - current < 100 || sum < 10) {
                    synchronized (goods) {
                        sum++;
                        if (goods.size() > 0) {
                            System.out.println(Thread.currentThread().getName() + "消费" + goods.remove(0));
                        } else {
                            goods.notifyAll();
                        }
                    }
                }
            }
        }, "消费者2");
        thread1.start();
        thread2.start();
        thread3.start();
        
    }
}


