package pan.并发相关.测试volatile关键字;

/**
 * @author ro0ki4
 * @data 2020/10/18 14:42
 * version 1.0
 *
 * volatile关键字只保证了它所修饰的引用的内存可见性。
 */
public class 修饰对象能否保证对象属性的内存可见性 {
    
    volatile static Test test = new Test(0, "a");
    
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 start "/* + Instant.now()*/);
                while (true) {
                    if (test.getAge() == 5000) {
                        break;
                    }
                }
                System.out.println("t1 end "/* + Instant.now()*/);
            }
        },"t1").start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 start "/* + Instant.now()*/);
                for(int i = 0; i < 10000; i ++){
                    test.setAge(test.getAge()+1);
                }
                System.out.println("t2 end "/* + Instant.now()*/);
            }
        },"t2").start();
    }
}

class Test{
    int age;
    String name;
    
    public Test(){}
    
    public Test(int age, String name){
        this.age = age;
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
