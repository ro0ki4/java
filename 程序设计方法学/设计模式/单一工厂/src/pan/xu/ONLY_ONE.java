package pan.xu;

/**
 * 解决了自高并发情况下的创建单一对象出错的问题
 * 还需要解决对象的残缺性问题
 * java在创建一个对象时，有三个步骤
 * 1—给对象分配内存空间
 * 2—对象初始化
 * 3—将对象指向为其分配的内存位置
 */
public class ONLY_ONE{
    public static void main(String[]args){
        DianNao.create();
    }
}
class DianNao{
    public static DianNao brand=null;
    private static Object object=new Object();
    private DianNao(){};

    public  static DianNao create(){
        synchronized(object){
            if(brand==null)
                brand=new DianNao();
            return brand;
        }
    }

}