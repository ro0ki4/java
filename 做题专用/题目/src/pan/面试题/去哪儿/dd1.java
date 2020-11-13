package pan.面试题.去哪儿;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author ro0ki4
 * @data 2020/9/23 19:14
 * version 1.0
 */
public class dd1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        //BigInteger tem = new BigInteger("1");
        BigInteger res = tool(m,n);
        System.out.print(res);
    }
    
    static BigInteger tool(int m,int n){
        //long res = 1;
        BigInteger res = new BigInteger("1");
//        BigInteger mm = new BigInteger(m+"");
//        BigInteger nn = new BigInteger(n + "");
        
        for(int i = 0; i < n; i++){
            //res *= m-i;
            res  = res.multiply(new BigInteger((m-i)+""));
        }
        for(int i = 0; i < n; i++){
//            res /= i+1;
            res = res.divide(new BigInteger((i+1)+""));
        }
        return res;
    }
}
