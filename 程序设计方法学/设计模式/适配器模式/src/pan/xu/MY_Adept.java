package pan.xu;

/**
 * 适配器将两个没有联系的类相联系起来
 * 当然，它需要继承那两个类
 * 面向接口编程————————！！！！！！！！
 */
public class MY_Adept extends dog implements robot{
    @Override
    public void move() {
        super.run();
        super.shout();
        System.out.println("移动");
    }
    public static void main(String[]args){
        robot one=new MY_Adept();
        one.move();
    }
}

class dog{
    public void shout(){
        System.out.println("汪汪叫");
    }
    public void run(){
        System.out.println("狗跑");
    }
}

interface robot{
    public void move();
}