package pan.面试题.growingIO;

import pan.泛型编程.Test;

import java.util.*;

/**
 * @author ro0ki4
 * @data 2020/9/27 19:19
 * version 1.0
 */
public class dd1 {
    public static void main(String[] args) {
        
        //test('1','2',"33",new Object(),2);
//        Test test = new Te();
        Tset tset = new Tset();
        System.out.println(tset.solu("1234567"));
        int[] arr = new int[]{1,3,4,2,6,8};
        tset.solu2(arr,0,5);
        for(int i : arr){
            System.out.print(i);
        }
        
        
        List<Integer> tem = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            tem.add(scan.nextInt());
        }
        int len = tem.size();
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(tem.get(i) > tem.get(j))
                    dp[i] = Math.max(dp[i],dp[j])+1;
            }
        }
        System.out.print(dp[len]);
    }
    
    
    static void test(Object... s){
        Object[] h = s;
        System.out.println(h.length);
    }
    
    static void solu2(int[] nums){
        int n = nums.length;
//        for(int i = 0; i < n;  i++){
//            for(int j = i+1; j < n; j++){
//                if(nums[i] > nums[j]){
//                    int tem = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = tem;
//                }
//            }
//        }
        
        for(int i = 0; i < n ; i++){
            for(int j = n-1; j > i; j--){
                if(nums[j] < nums[j-1]){
                    int tem = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tem;
                }
            }
        }
    }
}

class Tset implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
    
    public String solu(String s){
        char[] tem = s.toCharArray();
        int len = tem.length;
        StringBuilder res = new StringBuilder();
        for(int i = len-1; i >= 0; i--){
            res.append(tem[i]);
        }
        return res.toString();
    }
    
    public void solu2(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int left = l;
        int right = r;
        int flag = arr[left];
        
        while(left < right){
            while(right > left && arr[right] >= flag){
                right--;
            }
            arr[left] = arr[right];
            while(right> left && arr[left] <= flag){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = flag;
        solu2(arr,l,left-1);
        solu2(arr,left+1,r);
    }
    
    
    
}


