package pan.xu;

/**
 * 死锁问题，但是让某个线程睡眠一段时间可以解除死锁
 * 当然，调用sleep方法时当前线程不会失去它获得的锁，但是wait会失去锁
 * yield是让所有的线程都重新进入同一起跑线重新竞争cpu的使用权
 */
public class LOCK {
    public static void main(String[]args){
        A a1=new A(true);
        A a2=new A(false);
        Thread thread1=new Thread(a1,"thread1");
        Thread thread2=new Thread(a2,"thread2");
        thread1.start();
        thread2.start();
    }
}

class A implements Runnable{
    static final Object lock1=new Object();
    static final Object lock2=new Object();
    boolean flag;
    public A(boolean flag){
        this.flag=flag;
    }
    public void run(){
        if(flag){
            synchronized (lock1){
                System.out.println("lock111"+"*************");
                synchronized (lock2){
                    System.out.println("lock2");
                    lock2.notify();
                }
            }
        }
        else{
            try{//**************************************************************************
                Thread.sleep(0);
            }
            catch(Exception e){

            }
            synchronized (lock2){
                try{//**************************************************************************
                    Thread.sleep(0);
                }
                catch(Exception e){

                }
                try{//**************************************************************************
                    lock2.wait();
                }
                catch(Exception e){

                }
                System.out.println("lock222*************************");
                synchronized (lock1){
                    System.out.println("lock1");
                }
            }
        }
    }

}
