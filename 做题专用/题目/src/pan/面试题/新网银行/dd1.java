package pan.面试题.新网银行;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ro0ki4
 * @data 2020/9/19 18:57
 * version 1.0
 */
public class dd1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t > 0){
            t--;
            int len = scan.nextInt();
            scan.nextLine();
            String s = scan.nextLine();
            char[] ss = s.toCharArray();
            int[] tem = new int[len];
            for(int i = 0; i < len; i++){
                tem[i] = Integer.parseInt(ss[i]+"");
            }
            int sum = 0;
            ///////////////////////////////////////////////

//            Map<String,Integer> map = new HashMap<>();
            int[][] dp = new int[len][len];
            for(int i = 0; i < len; i++){
                dp[i][i] = tem[i];
            }
            for(int i = 1; i < len; i++){
                dp[0][i] = dp[0][i-1] + tem[i];
            }
            for(int i = 1; i < len; i++){
                for(int j = i; j < len; j++){
                    dp[i][j] = dp[i-1][j] - tem[i-1];
                }
            }

            //////////////////////////////////////////////////
            for(int i = 0; i < len; i++){
                for(int j = i; j < len; j++){
                    if(dp[i][j] == j-i+1)
                        sum++;
                }
            }

            System.out.println(sum);
        }
    }
    static int tool(int left,int right,int[] tem){
        int sum = 0;
        for(int i = left; i <= right; i++){
            sum += tem[i];
        }
        return sum;
    }
}
