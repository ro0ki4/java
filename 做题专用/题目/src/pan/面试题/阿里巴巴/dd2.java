package pan.面试题.阿里巴巴;

import java.util.Scanner;

/**
 * @author ro0ki4
 * @data 2020/10/13 19:43
 * version 1.0
 */
public class dd2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i < t; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int n = scan.nextInt();
            if(b == 1){
                System.out.println(a);
                return;
            }
            if(b == 2){
                System.out.println(Math.pow(a,2)-2*b);
                return;
            }
            if(b == 3){
                System.out.println(Math.pow(a,3)-3*b*a);
                return;
            }
            
        }
    }
}
