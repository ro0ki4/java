package pan.xu;

public class shuimianpaixu {
    public static void main(String[] args) {
        my_thread ee = new my_thread();
        for (int i = 0; i < 10; i++) {
            new Thread(ee, "线程" + i).start();

        }
    }
}

class my_thread implements Runnable {
    @Override
    public void run() {
        System.out.println("已启动" + Thread.currentThread().getName());
    }
}
