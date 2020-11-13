package pan.面试题.字节跳动;

import java.util.*;

/**
 * @author ro0ki4
 * @data 2020/10/11 18:21
 * version 1.0
 */
public class 第一题1011 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        Map<Integer,List<Integer>> map = new HashMap<>();
        Integer[] nums = new Integer[n];
        Integer[] log = new Integer[n];
        for(int i = 0; i < n; i++){
            log[i] = i;
        }
        for(int i = 0; i < n ; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            nums[x] += y;
        }
        
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i] + "   " + log[i]);
        }
        
        
    }
    
    public void sort(Integer[] nums, Integer[] log,int l, int r){
        if(l >= r){
            return;
        }
        int mid = (l+r) >> 1;
        sort(nums,log,l,mid);
        sort(nums,log,mid+1,r);
        merge(nums,l,mid,r,log);
    }
    
    public static void merge(Integer[] nums, int left, int mid, int right, Integer[] log){
        int l = left;
        int m = mid;
        int[] tem = new int[right-left+1];
        int[] temlog = new int[right-left+1];
        int index = 0;
        while(l < mid && m < right){
            if(nums[l] > nums[m]){
                tem[index] = nums[m];
                temlog[index] = log[m];
                index++;
                m++;
            }else{
                tem[index] = nums[l];
                temlog[index] = log[l];
                index++;
                l++;
            }
        }
        if(l < mid){
            while(index < tem.length){
                tem[index] = nums[m];
                temlog[index] = log[m];
                index++;
                m++;
            }
        }else{
            while(index < tem.length){
                tem[index] = nums[l];
                temlog[index] = log[l];
                index++;
                m++;
            }
        }
        for(int i = left; i <= right; i++){
            nums[i] = tem[i-left];
            log[i] = temlog[i-left];
        }
    }
}
