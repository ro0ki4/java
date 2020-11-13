package pan.xu.动态规划;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ro0ki4
 * @data 2020/10/3 1:26
 * version 1.0
 */
public class 戳气球 {
    static Map<Integer,Integer> map = new HashMap<>();
    static long sum  = 0;
    public static void main(String[] args) {
        int[] nums = new int[]{8, 3, 4, 3, 5, 0, 5, 6, 6, 2, 8, 5, 6, 2, 3, 8, 3, 5, 1, 0, 2};
        List<Integer> list = new ArrayList();
        list.add(1);
        for(int i = 0; i < nums.length; i++){
            list.add(nums[i]);
        }
        list.add(1);
        System.out.println(tool(list));
        System.out.println(sum);
    }
    
    static int tool(List<Integer> list){
        
        if(map.containsKey(list.hashCode()))
            return map.get(list.hashCode());
        
        int size = list.size();
        if(size == 3){
            map.put(list.hashCode(),list.get(1));
            return list.get(1);
        }
        
        int max = 0;
        for(int i = 1; i < size-1; i++){
            sum++;
            int tem = list.get(i);
            int cur = list.get(i-1) * tem * list.get(i+1);
            list.remove(i);
            
            int val = tool(list)+cur;
            //map.put(new List<Integer>(List),val);
            
            list.add(i,tem);
            max = Math.max(max,val);
        }
        map.put(list.hashCode(),max);
        return max;
    }
}
