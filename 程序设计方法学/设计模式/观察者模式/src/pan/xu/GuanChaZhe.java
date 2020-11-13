package pan.xu;

import java.util.ArrayList;

/**
 * 即所谓的MVC模式
 * 猫是目标 model
 * 狗和老鼠是观察者 view
 * 中介 controller
 */
public class GuanChaZhe {
    public static void main(String[]args){
        AniSubject one=new cat();
        one.addele(new dog());
        one.addele(new mouse());
        one.addele(new dog());
        one.action();
    }
}
interface AniSubject{//抽象目标类
    public static final ArrayList observes=new ArrayList();
    public default void addele(ObjSubject obj){
        observes.add(obj);
    }
    public default void minusele(ObjSubject obj){
        observes.remove(obj);
    }
    public abstract void action();
}

class cat implements AniSubject{
    @Override
    public void action() {
        System.out.println("猫叫");
        for(Object obj:observes){
            ((ObjSubject)obj).respond();
        }
    }
}
interface ObjSubject{//抽象观察者类
    public abstract void respond();
}

class dog implements ObjSubject{

    @Override
    public void respond() {
        System.out.println("赶快跑");
    }
}

class mouse implements ObjSubject{

    @Override
    public void respond() {
        System.out.println("赶紧追");
    }
}