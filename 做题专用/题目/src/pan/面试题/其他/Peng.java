package pan.面试题.其他;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author ro0ki4
 * @data 2020/10/29 16:39
 * version 1.0
 */
public class Peng {
    public static void main(String[] args) {
        
        int[] arr = new int[]{9,3,2,4,5,6};
        quickSort(arr,0,arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);
        
    }
    
    public static void quickSort(int[] arr,int start,int end){
        if (start >= end){
            return;
        }
        int i = start;
        int j = end;
        int key = arr[i];
        
        while (i < j){
            while (i < j && arr[j] >= key){
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= key){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = key;
        quickSort(arr,start,i - 1);
        quickSort(arr,i + 1,end);
        
    }
    
    
}
