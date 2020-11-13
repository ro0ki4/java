package pan.xu;

public class DIANQI {
    public static void main(String[]args){
        try {
            TV paizi = factory.create("xiaomi");
            paizi.play();
            paizi.play1();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

interface TV{
    public void play();
    public default void play1(){
        System.out.println(this.getClass().getName()+"播放中");
    }
}

class XiaoMI implements TV{

    @Override
    public void play() {
        System.out.println(this.getClass().getName()+"播放中");
    }
}

class HaiXin implements TV{

    @Override
    public void play() {
        System.out.println(this.getClass().getName()+"播放中");
    }
}

class factory{
    public static TV create(String brand)throws Exception{
        System.out.println(brand+"生产中");
        if(brand.equals("xiaomi"))
            return new XiaoMI();
        else if(brand.equals("haixin"))
            return new HaiXin();
        else throw new Exception("沙雕你输错了名字");
    }
}