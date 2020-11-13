package com.edu.xust;

public class Unit_thread {
    public static void main(String[] args) {
        mythread pussy=new mythread();
        Thread thread1=new Thread(pussy, "thread1");
        Thread thread2=new Thread(pussy,"thread2");
        Thread thread3=new Thread(pussy,"thread3");
        thread2.start();
        thread1.start();
        thread3.start();
    }
}

class mythread implements Runnable{
    private static int note=80;
    @Override
    public void run(){
        while(true) {
            synchronized (this) {
                if (note > 0) {
                    System.out.println(Thread.currentThread().getName() + "分发第" + note + "本笔记");
                    note--;
                } else {
                    break;
                }
            }
        }
        synchronized(this) {
            System.out.print("本子发完了");
            System.exit(1);
        }
    }
}
