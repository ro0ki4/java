package pan.xu;
import java.util.Arrays;
/**
 * 一般的类型都已经实现的comparable<>接口，
 * 可以使用Array.sort()方法进行排序
 *
 *
 * 类似Object中的equals方法，
 * 可以用来比较两个对象是否某些方面相同。

 */
public class B {
    public  static void main(String[]args){
        B1[] c={new B1(1,1),new B1(1,2),new B1(2,2),new B1(2,3)};
        Arrays.sort(c);
        for(B1 a:c){
            System.out.println(a.show());
        }
    }
}


class B1 implements Comparable<B1>{
    int x;
    int y;
    public B1(int x,int y){
        this.x=x;
        this.y=y;
    }

    int show(){
        return x*y;
    }
    public int compareTo(B1 a) {
        if (x * y > a.x * a.y)
            return 1;
        else if (x * y == a.x * a.y)
            return 0;
        else return -1;
    }
}