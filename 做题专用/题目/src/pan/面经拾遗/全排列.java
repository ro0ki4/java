package pan.面经拾遗;

import java.util.*;

/**
 * @author ro0ki4
 * @data 2020/10/7 14:58
 * version 1.0
 */
public class 全排列 {
    public static void main(String[] args) {
        
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.entrySet();
        
        List<Character> list = new LinkedList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        Test test = new Test();
//        test.recursion(list,"");
        System.out.println(test.resString);
        
        char[] hh = new char[]{'a','b','c'};
        System.out.println(test.tool(hh));
        test.nonrecursive(hh);
        System.out.println(test.resString+"  "+test.resString.size());
    }
    static class Test{
        List<String> resString = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        
        public void recursion(List<Character> list,String s){
            if(list.size() == 0){
                resString.add(s);
                
                return;
            }
            
            for(int i = 0; i < list.size(); i++){
                Character c = list.get(i);
                list.remove(i);
                recursion(list,s+c);
                list.add(i,c);
            }
            return;
        }
        

        
    
        /**
         * 需要一个辅助函数，寻找字典序仅大于当前的排序的序列
         * 该函数定义为tool(char[] nums)
         * @param nums
         */
        public void nonrecursive(char[] nums){
            Arrays.sort(nums);
            resString.add(Arrays.toString(nums));
            for(int i = 1; i < factorial(nums.length); i++){
                tool(nums);
                resString.add(Arrays.toString(nums));
            }
            
        }
    
        /**
         * 寻找大于当前字典序的最小序列
         * 力扣--31--下一个排列
         * @param nums
         * @return
         */
        public char[] tool(char[] nums){
            int len = nums.length;
            for(int i = len-2; i >= 0; i--){
                if(nums[i] < nums[i+1]){
                    int j = len-1;
                    for(; j >= i+1; j--){
                        if(nums[j] > nums[i]){
                            break;
                        }
                    }
                    swap(nums,i,j);
                    for(j = 0; j < len-1-((len+i)>>1) ; i++){
                        swap(nums,len-j-1,i+1+j);
                    }
                    break;
                }
                
                
            }
            return nums;
        }
        
        public <T> void  swap(T[] nums,int i,int j){
            T tem = nums[i];
            nums[i] = nums[j];
            nums[j] = tem;
        }
        public void swap(char[] nums, int i, int j){
            char tem = nums[i];
            nums[i] = nums[j];
            nums[j] = tem;
        }
        
        public int factorial(int len){
            int res = 1;
            for(int i = 1; i <= len; i++){
                res *= i;
            }
            return res;
        }
    }
}


