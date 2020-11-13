package pan.测试jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ro0ki4
 * @data 2020/10/2 12:49
 * version 1.0
 */
public class 类加载器 {
    static StringBuilder sb = new StringBuilder("1");
    static final ThreadLocal<StringBuilder> local = new ThreadLocal<>();
    public static void main(String[] args) {
        //Map map = new HashMap();
        
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder("1");
                local.set(sb);
                while(true) {
                    System.out.println(Thread.currentThread().getName() + "   " + local.get());
                    local.set(local.get().append("1"));
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder("1");
                local.set(sb);
                while(true) {
                    System.out.println(Thread.currentThread().getName() + "   " + local.get());
                    local.set(local.get().append("1"));
                }
            };
        });
        thread1.start();
        thread2.start();
        System.out.println("结束");
    }
    
    
}

class test extends ClassLoader{
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
    
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
        //双亲委派模型就是通过该方法实现的。
//        protected Class<?> loadClass(String name, boolean resolve)
//        throws ClassNotFoundException
//        {
//            synchronized (getClassLoadingLock(name)) {
//                // First, check if the class has already been loaded
//                Class<?> c = findLoadedClass(name);
//                if (c == null) {
//                    long t0 = System.nanoTime();
//                    try {
//                        if (parent != null) {
//                            c = parent.loadClass(name, false);
//                        } else {
//                            c = findBootstrapClassOrNull(name);
//                        }
//                    } catch (ClassNotFoundException e) {
//                        // ClassNotFoundException thrown if class not found
//                        // from the non-null parent class loader
//                    }
//
//                    if (c == null) {
//                        // If still not found, then invoke findClass in order
//                        // to find the class.
//                        long t1 = System.nanoTime();
//                        c = findClass(name);
//
//                        // this is the defining class loader; record the stats
//                        sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
//                        sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
//                        sun.misc.PerfCounter.getFindClasses().increment();
//                    }
//                }
//                if (resolve) {
//                    resolveClass(c);
//                }
//                return c;
//            }
//        }
    }
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
