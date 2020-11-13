package pan.xu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 这个自己实现的list只支持一个方法，即foreach的魔改版。并且只支持string类型。。。。。。。
 * 失败了.......
 * @param <Y>
 */
public interface My_list<Y extends My_list> extends List{
    public static <Y> void myforeach(Y a){
        if(a instanceof ArrayList) {
            Iterator iterator = ((ArrayList) a).iterator();
            while(iterator.hasNext()){
                Object o=iterator.next();
                System.out.println(o);
            }
        }
    }
    public static <Y> void myforeach_2(Y a){

    }
    public abstract void show();
}


