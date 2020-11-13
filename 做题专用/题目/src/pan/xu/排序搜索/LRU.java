package pan.xu.排序搜索;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ro0ki4
 * @data 2020/10/4 13:52
 * version 1.0
 */
public class LRU {
    
    int capacity;
    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> list = new LinkedList<>();
    
    public static void main(String[] args) {
        LRU hh = new LRU(1);
        hh.put(2,1);
        System.out.println(hh.get(2));
        hh.put(3,2);
        System.out.println(hh.get(2));
        System.out.println(hh.get(3));
    }
    public LRU(int capacity){
        this.capacity = capacity;
    }
    
    public int get(int key){
        if(!map.containsKey(key))
            return -1;
        else{
            //Integer index = list.indexOf(key);
            list.remove((Integer) key);
            list.add(0,key);
            return map.get(key);
        }
    }
    
    public void put(int key, int val){
        
        if(map.containsKey(key)){
            map.put(key,val);
            list.remove((Object)key);
            list.add(0,key);
            return;
        }
        
        if(map.size() < capacity){
            map.put(key,val);
            list.add(0,key);
        }else{
            Integer index = list.get(capacity-1);
            list.remove(capacity-1);
            map.remove(index);
            
            list.add(0,key);
            map.put(key,val);
        }
    }
}
