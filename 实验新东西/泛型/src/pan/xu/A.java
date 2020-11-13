package pan.xu;

/**
 * 用来说明类的向上转型中的方法调用
 * 抽象类中的抽象方法设置为静态方法具体也不知道有什么作用。
 * 因为没有意义。
 */
public class A extends  A1{
    /*static void show(){
        System.out.println("A");
    }*/
    public static void main(String[]args){
        A xu=new A();
        xu.show();
        //A.show();
        //A1.show();
    }
}
class A1{
    static void show(){
        System.out.println("B");
    }
}