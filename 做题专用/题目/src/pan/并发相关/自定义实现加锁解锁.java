package pan.并发相关;

import sun.misc.Unsafe;

/**
 * @author ro0ki4
 * @data 2020/10/18 13:40
 * version 1.0
 *
 * 我们可以利用线程让步和unsafe提供的cas操作来实现类似于reentrantlock的无锁加锁技术
 */
public class 自定义实现加锁解锁 {
    public static void main(String[] args) {
    
    }
}

class CustomLock{
    /**
     * 0-----无锁
     * != 0 -----加锁
     */
    private volatile int flag;
    
    private Unsafe unsafe;
    
    public void lock(){
        while(!unsafe.compareAndSwapInt(this,flag,0,1))
            Thread.yield();
    }
    
    public void unlock(){
        while(!unsafe.compareAndSwapInt(this,flag,1,0))
            ;
    }
}
