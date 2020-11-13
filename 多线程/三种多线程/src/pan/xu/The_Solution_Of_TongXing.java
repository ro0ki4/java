package pan.xu;
/**
 * 有时导入的包太多了也有可能出现类名冲突
 * 调用wait，notify等方法需要同步锁对象，同时synchronized(对象)
 * wait实在synchronized区使用
 */

import java.util.ArrayList;
import java.util.List;
public class The_Solution_Of_TongXing {
    static Object lock=new Object();
    public static void main(String[]args) {
        List<Object> goods = new ArrayList<>();
        long time = System.currentTimeMillis();
        Thread thread1 = new Thread(
                () -> {
            int num = 0;

                while (System.currentTimeMillis()-time<99) {
                    synchronized(lock){
                        if(System.currentTimeMillis()-time>=100)
                            break;
                    if(goods.size()>0){
                        try {
                            if (System.currentTimeMillis() - time >= 100) {
                                return;
                            }
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println("制造多了");
                        }
                    }
                    else{
                        goods.add(num+"");
                        System.out.println(Thread.currentThread().getName() +"_____"+ num++ + "制造");
                }
                    }
            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            int num1 = 0;
                while (System.currentTimeMillis()-time<100) {
                    synchronized(lock) {
                        if (System.currentTimeMillis() - time >= 100) {
                            lock.notify();
                            break;
                        }
                        if (goods.size() <= 0) {
                            lock.notify();
                        }else {
                            goods.remove(num1+"");
                            System.out.println(Thread.currentThread().getName() +"______"+ num1++ + "出售");
                            /*

                            try {
                                Thread.currentThread().sleep(10000000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                             */
                        }
                }
            }
        }, "thread2");
        thread1.start();
        thread2.start();
    }

    static void show(){
        Thread sjdafl = new Thread(new Runnable() {//匿名内部类的写法，上面的是lambda的写法
            @Override
            public void run() {

            }
        });
    }
}


