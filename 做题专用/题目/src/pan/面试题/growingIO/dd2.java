package pan.面试题.growingIO;

import java.util.Scanner;

/**
 * @author ro0ki4
 * @data 2020/9/27 19:14
 * version 1.0
 */
public class dd2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        char[] tem1 = s1.toCharArray();
        char[] tem2 = s2.toCharArray();
        int len1 = tem1.length;
        int len2 = tem2.length;
        int[][] dp = new int[len1+1][len2+1];
        
        for(int i = 1; i < len1+1; i++){
            for(int j = 1; j < len2+1; j++){
                if(tem1[i-1] == tem2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.print(dp[len1][len2]);
    }
}
