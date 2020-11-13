package pan.xu;

public class Three_varieties_thread{
    public static void main(String [] args) {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread1();
        thread1.setPriority(1);
        thread2.setPriority(1);
        thread1.start();
        thread2.start();
        Thread2 thread3 = new Thread2();
        Thread thread3_1 = new Thread(thread3,"xu");
        Thread thread3_2 = new Thread(thread3,"pan");
        thread3_1.setPriority(10);
        thread3_2.setPriority(1);

        thread3_1.start();
        thread3_2.start();


    }
}
class Thread1 extends Thread {
    int[] a={100,200};
    public void run(){
        for(int i=0;i<=4;i++){
            System.out.println(Thread.currentThread().getName()+"*****"+i);
        }
    }
}

class Thread2 implements Runnable{
    int[] a={100,200};
    public void run(){
        for(int i=0;i<5;i++){
            if(i==1)
                Thread.yield();
            System.out.println(Thread.currentThread().getName()+"*****"+i);
        }
    }
}