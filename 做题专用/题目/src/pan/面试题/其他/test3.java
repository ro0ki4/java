package pan.面试题.其他;

import java.util.*;

/**
 * @author ro0ki4
 * @data 2020/11/3 14:10
 * version 1.0
 */
public class test3 {
    public static void main(String[] args) {
    
        List<? extends a> list = new ArrayList<>();
        List<? extends a> gg = sss();
        List<? super b> list1 = new ArrayList<>();
        a dd = gg.get(0);
        list1.add((b)new a());
        
        
        
        Deque<Integer> q = new LinkedList<>();
        Comparator test = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
        q.add(1);
        q.add(2);
        q.add(3);
        q.push(4);
        System.out.println(q.poll()+"  "+q.poll()+"  "+q.poll()+"  "+q.poll());
//        System.out.println(q.pop()+"  "+q.pop()+"  "+q.pop());
    }
    
    public static List<? extends a> sss(){
        return new ArrayList<b>();
        
    }
    
    public int[] sortByBits(int[] arr) {
        int len = arr.length;
        MyInteger[] tem = new MyInteger[len];
        for(int i = 0; i < len; i++){
            tem[i] = new MyInteger();
            tem[i].setVal(arr[i]);
        }
        Arrays.sort(tem,new Comparator<MyInteger>(){
            @Override
            public int compare(MyInteger o11, MyInteger o22){
                MyInteger o1 = (MyInteger)o11;
                MyInteger o2 = (MyInteger)o22;
                if(o1.getTime() >= o2.getTime()){
                    if(o1.getTime() == o2.getTime()){
                        return o1.getVal() >= o2.getVal() ? 1 : -1;
                    }else{
                        return 1;
                    }
                }else{
                    return -1;
                }
            }
        });
        
        for(int i = 0; i < len; i++){
            arr[i] = tem[i].getVal();
        }
        return arr;
    }
    static class MyInteger{
        Integer val;
        Integer time;
        void setTime(int time){
            this.time = time;
        }
        void setVal(int val){
            this.val = val;
            int res = 0;
            for(int i = 0; i < 32; i++){
                if(((val>>i)&1) == 1)
                    res++;
            }
            setTime(res);
        }
        
        int getTime(){
            return time;
        }
        
        int getVal(){
            return val;
        }
    }
}


class a{

}

class b extends a{

}

class c extends a{

}