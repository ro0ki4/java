package pan.设计模式;

/**
 * @author ro0ki4
 * @data 2020/10/3 23:07
 * version 1.0
 */
public class 工厂模式 {
    public static void main(String[] args) {
    
    }
    
}

interface TV{
    public void display();
}

class TV1 implements TV{
    @Override
    public void display() {
        System.out.println(this.getClass().getName());
    }
}

class TV2 implements TV{
    @Override
    public void display() {
        System.out.println(this.getClass().getName());
    }
}

class TVFactory{
    public TV produce(String TVname){
        if(TVname.equalsIgnoreCase("tv1")){
            return new TV1();
        }
        if(TVname.equalsIgnoreCase("tv2"))
            return new TV2();
        else
            return null;
    }
}