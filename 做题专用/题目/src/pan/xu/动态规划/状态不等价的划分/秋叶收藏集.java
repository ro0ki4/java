package pan.xu.动态规划.状态不等价的划分;

import java.util.Arrays;

/**
 * @author ro0ki4
 * @data 2020/10/1 13:07
 * version 1.0
 */
public class 秋叶收藏集 {
    public static void main(String[] args) {
        String leaves = "rrryyyrryyyrr";
        System.out.println(solu(leaves));
    }
    static int solu(String leaves){
        int len = leaves.length();
        char[] lea = leaves.toCharArray();
        int[][] dp = new int[len][3];
        for (int[] i : dp) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        if(lea[0] == 'y'){
            dp[0][0] = 1;
        }else{
            dp[0][0] = 0;
        }
        for(int i = 1; i < len; i++){
            int cur = lea[i] == 'y' ? 1 : 0;
            dp[i][0] = dp[i-1][0] + cur;
            cur = lea[i] == 'y' ? 0 : 1;
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]) + cur;
            cur = lea[i] == 'y' ? 1 : 0;
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][2]) + cur;
        }
        return dp[len-1][2];
    }
}
