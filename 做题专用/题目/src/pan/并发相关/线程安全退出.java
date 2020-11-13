package pan.并发相关;

/**
 * @author ro0ki4
 * @data 2020/10/17 23:41
 * version 1.0
 */
public class 线程安全退出 {
    public static void main(String[] args) {
//        new TestVolatile();
        new TestInterupt();
    }
    
    
    
}


class TestVolatile {
    
    static volatile boolean isAlive = true;
    
    public TestVolatile(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(isAlive){
                    System.out.println("运行中 "+ Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("退出");
            }
        },"thread-1").start();
        
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isAlive = false;
                System.out.println("是否退出");
            }
        },"thread-2").start();
    }
}


class TestInterupt{
    public TestInterupt(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println("运行中 "+ Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        //使用了interrupt方法，如果被中断的线程是处于阻塞状态，会抛出一个异常，我们可以捕获这个异常
                        //然后直接break;
                        e.printStackTrace();
                        break;
                        
                    }
                }
                System.out.println("退出");
            }
        },"thread-1");
        thread1.start();
        
        new  Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                thread1.interrupt();
                System.out.println("是否退出");
            }
        },"thread-2").start();
    }
}
