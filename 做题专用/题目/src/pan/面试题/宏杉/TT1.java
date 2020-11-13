package pan.面试题.宏杉;

/**
 * @author ro0ki4
 * @data 2020/11/4 10:23
 * version 1.0
 */
public class TT1 {
    
    
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,2,4,5,6,8,9};
        quickSort(arr,0,arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
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
            while (i > j && arr[i] <= key){
                i++;
            }
            arr[j] = arr[i];
        }
        
        arr[i] = key;
        quickSort(arr,start,i - 1);
        quickSort(arr,i + 1,end);
        
    }
    
    
}
