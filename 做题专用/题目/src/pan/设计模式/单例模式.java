package pan.设计模式;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ro0ki4
 * @data 2020/10/3 23:37
 * version 1.0
 */
public class 单例模式 {
    
    public static void main(String[] args) {
//        ExecutorService tem = new ThreadPoolExecutor(4,10,10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>());
    }
    
    private static volatile 单例模式 instance = null;
    //私有化构造方法
    private 单例模式(){};
    
    public static synchronized 单例模式 getInstance(){
        if(instance == null)
            instance = new 单例模式();
        return instance;
    }
    
    //可以通过反射调用私有构造方法破坏单例模式
    public static 单例模式 getInstance1(){
        if(instance == null){
            synchronized (单例模式.class){
                if(instance == null){
                    instance = new 单例模式();
                }
            }
        }
        return instance;
    }
    
}


