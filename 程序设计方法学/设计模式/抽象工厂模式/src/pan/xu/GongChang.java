package pan.xu;

/**
 * 工厂模式
 * 主要是利用了继承的向上转型机制
 *注意，类的名字不区分大小写，
 * 会发生找不到类。。。。。。。。
 * 代码量没有很大的变化，
 * 但是修改需求变得更简单了
 *
 * 简单工厂--一个工厂类，产品接口，实现的产品类，通过将参数传进工厂类中的某个方法返回不一样的产品
 * 工厂方法--一个工厂接口，一个或多个产品接口，通过不一样的工厂实现类生产不一样的产品
 * 抽象工厂--类似工厂方法，一个工厂可以生产多个产品，意味着有多个产品接口
 */
public class GongChang {
    public static void main(String[]args) {
        gongchang1 g = new haier();
        bingxiang b = g.createbingxiang();
        b.run();
        g=new meidi();
        b = g.createbingxiang();
        b.run();
    }
}

interface gongchang1{//工厂
    public bingxiang createbingxiang();//工厂需要生产的产品
    //public bingxiang createkongtiao();
}

interface bingxiang{
    public void run();//产品的功能
}

class pingpai implements bingxiang{//具体的产品功能
    @Override
    public void run(){
        System.out.println("这是111"+this.getClass().getName());
    }
}

class zhonglei implements bingxiang{
    @Override
    public void run(){
        System.out.println("这是222"+(this.getClass().getName()));
    }
}

class haier implements gongchang1{
    @Override
    public bingxiang createbingxiang(){
        return new pingpai();
    }
}

class meidi implements gongchang1{
    @Override
    public bingxiang createbingxiang(){
        return new zhonglei();
    }
}