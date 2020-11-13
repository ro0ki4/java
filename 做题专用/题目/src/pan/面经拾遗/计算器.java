package pan.面经拾遗;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ro0ki4
 * @data 2020/10/29 14:29
 * version 1.0
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 *
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
public class 计算器 {
    public static void main(String[] args) {
//        int[][] hh = new int[2][3];
        System.out.println(solu("4+5*4/2#"));
    }
    public static int solu(String s){
        String tem = s ;
        Deque<Integer> number = new LinkedList<>();
        Deque<Character> sym = new LinkedList<>();
        
        int[] arr = new int[128];
        arr['+'] = 2;
        arr['-'] = 2;
        arr['*']  = 3;
        arr['/'] = 3;
        arr['#']  = 1;
        int len = tem.length();
        for(int i = 0; i < len; i++){
            if(arr[tem.charAt(i)] == 0){
                number.push(Integer.valueOf(tem.charAt(i)-'0'));
            }else{
                if(sym == null){
                    sym.push(tem.charAt(i));
                }else{
//
                    Character two = sym.peek();
                    Character one = null;
                    sym.push(tem.charAt(i));
                    while(two != null &&  arr[two] >= arr[sym.peek()]){
                        int y = number.pop();
                        int x = number.pop();
                        int numTem = tool(x,y,two);
                        number.push(numTem);
                        one = sym.pop();
                        sym.pop();
                        two = sym.peek();
                        sym.push(one);
//                        two = one;
                    }
                }
            }
        }
        int res = number.peek();
        return res;
    }
    
    public static int tool(int x, int y, Character c){
        if(c=='+'){
            return x+y;
        }else if(c=='-'){
            return x-y;
        }else if(c=='*'){
            return x*y;
        }else{
            return x/y;
        }
    }
    
    public static int tool2(int x, int y , String c){
        switch (c){
            case "=" :
                break;
            
        }
        return 0;
    }
    
}

