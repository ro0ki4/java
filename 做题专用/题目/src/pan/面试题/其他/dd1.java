package pan.面试题.其他;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ro0ki4
 * @data 2020/10/19 19:21
 * version 1.0
 */
public class dd1 {
    public static void main(String[] args) {
        int c = 127;
        Integer a = new Integer(1);
        Integer b = 1;
        System.out.println(a==b);
    }
    
    
    public static int solu2(int[] arr){
        int count1 = 0;
        int count2 = 0;
        for(int i : arr){
            if(i==0)
                count1++;
            else
                count2++;
        }
        int res = 0;
        for(int i = 0; i < count1; i++){
            if(arr[i] != 0)
                res++;
        }
        return count1-res;
    }
    
    public static ArrayList<User> solu(ArrayList<User> a, ArrayList<User> b){
        
        ArrayList<User> res = new ArrayList();
        int index1 = 0;
        int index2 = 0;
        while(index1 < a.size() && index2 < b.size()){
            if(a.get(index1).id == b.get(index2).id){
                res.add(b.get(index2));
                index1++;
                index2++;
            }else{
                if(a.get(index1).id > b.get(index2).id){
                    res.add(b.get(index2));
                    index2++;
                }else{
                    res.add(a.get(index1));
                    index1++;
                }
            }
        }
        if(index1 >= a.size()){
            while(index2 < b.size()){
                res.add(b.get(index2));
                index2++;
            }
        }else{
            while(index1 < a.size()){
                res.add(a.get(index1));
                index1++;
            }
        }
        return res;
    }
}

class User{
    int id;
}