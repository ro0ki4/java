package pan.xu;

public class GONGCHANG {
    public static void main(String[]args){
        mygongchang one=new meide();
        mygongchang two=new haier();
        one.create();
        two.create();
    }
}

interface mygongchang{
    public void create();
}

class haier implements mygongchang{

    @Override
    public void create() {
        System.out.println(this.getClass().getName()+"生产");
    }
}

class meide implements mygongchang{
    @Override
    public void create() {
        System.out.println(this.getClass().getName()+"生产");
    }


}
