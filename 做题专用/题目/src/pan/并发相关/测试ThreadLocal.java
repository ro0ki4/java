package pan.并发相关;

/**
 * @author ro0ki4
 * @data 2020/10/19 0:56
 * version 1.0
 */
public class 测试ThreadLocal {
    ThreadLocal<String> local = new ThreadLocal<>();
    
    /**
     * 可以很容易发现，再set的时候，首先获得thread对象，然后通过thread对象获得线程对象中的threadlocals属性，该属性的类型
     * 为 Theadlcoal.ThreadLocalMap类型，将threadlocal作为key，set的值作为value存入这个threadlocalmap中。
     * @param args
     */
    
    public static void main(String[] args) {
        
        new Thread();
    }
}
