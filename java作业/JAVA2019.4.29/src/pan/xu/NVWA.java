package pan.xu;

public class NVWA {
    public static void main(String[]args){
        Man M=new Man();
        Women W=new Women();
        Robot R=new Robot();
        try {
            Nvwaa somebody = Nvwaa.zaoren(M);
            show(somebody);
            somebody = Nvwaa.zaoren(W);
            show(somebody);
            somebody = Nvwaa.zaoren(R);
            show(somebody);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private static void show(Nvwaa some){
        System.out.println(some.getClass().getName());
    }
}
class Nvwaa{
    static Nvwaa zaoren(Nvwaa some)throws Exception{
        if(some instanceof Man)
            return new Man();
        else if(some instanceof Women)
            return new Women();
        else if(some instanceof Robot)
            return new Robot();
        else throw new Exception("你的输入有问题");
    }
}
class Man extends Nvwaa{
}
class Women extends Nvwaa{
}
class Robot extends Nvwaa{
}