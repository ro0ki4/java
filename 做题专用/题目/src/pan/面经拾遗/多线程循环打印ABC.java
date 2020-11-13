package pan.面经拾遗;

/**
 * @author ro0ki4
 * @data 2020/10/7 16:36
 * version 1.0
 */
public class 多线程循环打印ABC {
    static final Object lock = new Object();
    static volatile int num = 0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while(true){
                        try {
                            Thread.sleep(100);
                            if( num%3 == 0) {
                                System.out.println("A");
                                num++;
                                lock.notifyAll();
                            }else{
                                lock.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while(true){
                        try {
                            Thread.sleep(100);
                            if(num%3 == 1) {
                                System.out.println("B");
                                num++;
                                lock.notifyAll();
                            }else{
                                lock.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        
            }
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while(true){
                        try {
                            Thread.sleep(100);
                            if(num%3 == 2) {
                                System.out.println("C");
                                num++;
                                lock.notifyAll();
                            }else{
                                lock.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        
            }
        }).start();
    }
}
