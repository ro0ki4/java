package pan.面试题.其他;

import java.util.Arrays;

/**
 * @author ro0ki4
 * @data 2020/10/29 17:41
 * version 1.0
 */
public class Test2 {
    
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,4,5,6,8};
        int method = method(arr, -39);
        System.out.println(method);
    }
    
    
    public static int method(int[] arr,int target){
        if (arr.length == 0 || arr[arr.length-1] < target || target < arr[0]){
            return -1;
        }
        int left = 0;
        int right = arr.length;
        while (left < right){
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                right = mid;
            }else if (arr[mid] < target){
                left = mid + 1;
            }else if(arr[mid] > target){
                right = mid;
            }
        }
        if (arr[left] != target){
            return -1;
        }
        return left;
    }
    
}
