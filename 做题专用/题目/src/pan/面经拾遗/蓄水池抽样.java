package pan.面经拾遗;

import java.util.Random;

/**
 * @author ro0ki4
 * @data 2020/11/12 21:44
 * version 1.0
 */
public class 蓄水池抽样 {
    public static void main(String[] args) {
        Integer a = 122;
        Integer b = new Integer(122);
        Integer c = 122;
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(b==122);
    }
    
    public void solu(int[] arr, int m ){
        int[] res = new int[m];
        for(int i = 0; i < m; i ++){
            res[i] = arr[i];
        }
        Random rand = new Random();
        for(int i = m; i < arr.length; i ++){
            int flag = rand.nextInt(i+1);
            if(flag > m){
                res[flag] = arr[i];
            }
        }
    }
}
