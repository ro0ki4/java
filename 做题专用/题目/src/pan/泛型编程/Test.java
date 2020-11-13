package pan.泛型编程;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ro0ki4
 * @data 2020/10/8 20:23
 * version 1.0
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = test1();
        list.add(new Integer(2));
        
    }
    
    static List<Integer> test1(){
        return new ArrayList<Integer>();
    }
}


