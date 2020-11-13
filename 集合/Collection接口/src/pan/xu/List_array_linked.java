package pan.xu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class List_array_linked {
    public static void main(String[] args) throws Exception{
        List<String> list=new ArrayList<>();
        list.add("x");
        list.add("u");
        list.add("p");
        list.add("a");
        list.add("n");
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            Object o=iterator.next();
            System.out.println(o);
        }
        for (String a : list) {
            System.out.println(a);
        }
        My_list.myforeach(list);

        list.forEach(a -> System.out.println(a));
    }
}

