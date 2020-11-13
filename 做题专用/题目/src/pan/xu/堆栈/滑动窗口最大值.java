package pan.xu.堆栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ro0ki4
 * @data 2020/11/3 18:43
 * version 1.0
 */
public class 滑动窗口最大值 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bc";
        System.out.println(s1.indexOf("bc"));
    }
    
    public static int[] solu(int[] nums, int k){
        int len = nums.length;
        int[] res = new int[len-k+1];
    
        Deque<Integer> que = new LinkedList<>();
        
        for(int i = 0; i < k; i++){
            while(que.size() > 0 && que.peekLast() < nums[i]){
                que.removeLast();
            }
            que.addLast(nums[i]);
        }
        
        res[0] = que.peekFirst();
        
        for(int i = k; i < len; i++){
            if(nums[i-k] == que.peekFirst())
                que.removeFirst();
            while(que.size() > 0 && que.peekLast() < nums[i])
                que.removeLast();
            que.addLast(nums[i]);
            res[i-k+1] = que.peekFirst();
        }
        return res;
    }
}
