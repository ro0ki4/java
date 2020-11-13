package pan.面试题.其他;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ro0ki4
 * @data 2020/10/27 20:25
 * version 1.0
 */
public class dd3 {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int x = scan.nextInt();
//        int y = scan.nextInt();
//        int z = scan.nextInt();
//        int time = scan.nextInt();
//
//        int time2 = time/2;
        int[] res = new int[]{1};
        yang(7,res);
        System.out.println(res[0]);
        System.out.println(yang2(15));
//        ConcurrentHashMap;
        
        System.out.println(solu("10+3*2"));
        
        
    }
    
    public static int solu(String s){
        char[] tem = s.toCharArray();
        Deque<Character> sym = new LinkedList<>();
        Deque<Integer> list = new LinkedList<>();
        int[] pre = new int[128];
        Set<Character> set = new HashSet<>();
        set.add('+');
        set.add('-');
        set.add('*');
        set.add('/');
        pre['+'] = 1;
        pre['-'] = 1;
        pre['*'] = 2;
        pre['/'] = 2;
        
        for(int i = 0; i < tem.length; i++){
            if(set.contains(tem[i]) ){
                if(sym.size() == 0 || pre[i] < pre[sym.peek()]){
                    sym.push(tem[i]);
                }else{
                    int two = list.pop();
                    int one = list.pop();
                    char symbol = sym.pop();
                    int res = com(one,two,symbol);
                    list.push(res);
                }
            }else{
                list.push(Integer.valueOf(tem[i]));
            }
        }
        
        
        return list.pop();
    }
    
    public static int com(int one, int two,Character symbol){
        int res = 0;
        switch (symbol){
            case '+':
                res =  one+two;
                break;
            case '-':
                res =  one-two;
                break;
            case '*':
                res =  one*two;
                break;
            case '/':
                res =  one/two;
                break;
        }
        return res;
    }
    
    
    public static void yang(int year,int[] res){
//         int a = 1;
        if(year == 1){
            return;
        }
        for(int i = 0; i <= year; i++){
            if(i == 2 || i == 4){
                yang(year - i,res);
                res[0]++;
            }
            if(i == 5){
                res[0]--;
                break;
            }
        }
        
    }
    
    public static int yang2(int year){
        if(year <= 1){
            return 1;
        }
        int res = 0;
        for(int i = 0; i <= year; i++){
            if(i == 2 || i ==4) {
                int tem = yang2(year - 2);
                res += tem;
                res++;
            }
            if(i == 5){
                res --;
                break;
            }
        }
        return res;
    }
    
    public static int yang3(int year){
        int[][] dp = new int[5][year+1];
        dp[0][0] = 1;
        dp[1][1] = 1;
        dp[0][2] = 1;
        dp[2][2] = 1;
        
        for(int i = 3; i < year+1; i++){
            for(int j = 0; j < 5; j++){
                if(j == 0){
                    dp[1][i] += dp[0][i];
                }else{
                    if(j == 2){
                        dp[0][i]++;
                    }
                }
            }
        }
        return 0;
    }

    
}
