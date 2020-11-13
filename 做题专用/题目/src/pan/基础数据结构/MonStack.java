package pan.基础数据结构;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ro0ki4
 * @data 2020/10/4 16:28
 * version 1.0
 */
public class MonStack {
    public static void main(String[] args) {
    
    }
    
    public int[] lastBig(int[] nums){
        Deque<Integer> stack = new LinkedList();
        int[] res = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            while(stack.size() > 0 && nums[stack.peek()] < nums[i]){
                res[stack.pop()] = i;
            }
            stack.push(i);
        }
        return res;
    }
}
