package pan.面试题.去哪儿;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ro0ki4
 * @data 2020/9/23 20:08
 * version 1.0
 */
public class dd3 {
    
    static String[] res = new String[]{"HuangJiaTongHuaShun","TongHuaShun","SiTiao","HuLu","TongHua","ShunZi","SanTiao","LiangDui","YiDui","GaoPai"};
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] cur = scan.nextLine().split(" ");
        if(n <= 1){
            System.out.print(res[9]);
            return;
        }
        if(n == 2){
            if(cur[0].charAt(1) == cur[1].charAt(1))
                System.out.print(res[8]);
            else
                System.out.print(res[9]);
            return;
        }
        if(n >5){
            if(s1(cur)){
                System.out.print(res[0]);
                return;
            }
            if(s2(cur)){
                System.out.print(res[1]);
                return;
            }
            System.out.print(res[5]);
            return;
        }
        System.out.print(res[8]);
        return;
    }
    
    public static boolean s1(String[] cur){
        if(cur.length < 5)
            return false;
        StringBuilder tem = new StringBuilder();
        for(String i : cur){
            tem.append(i);
        }
        int index1 = tem.indexOf("A");
        int index2 = tem.indexOf("K");
        int index3 = tem.indexOf("Q");
        int index4 = tem.indexOf("J");
        int index5 = tem.indexOf("10");
        if(index1>-1&&index2>-1&&index3>-1&&index4>-1&&index5>-1){
            char h = tem.charAt(index1-1);
            if(h == tem.charAt(index2-1)&&h==tem.charAt(index3-1)&&h==tem.charAt(index4-1)&&h==tem.charAt(index5-1))
                return true;
        }
        return false;
    }
    
    public static boolean s2(String[] cur){
        if(cur.length < 5)
            return false;
        StringBuilder tem = new StringBuilder();
        for(String i : cur){
            tem.append(i.charAt(1));
        }
        char[] hh = tem.toString().toCharArray();
        Arrays.sort(hh);
        int len = hh.length;
        for(int i = 4; i < len; i++){
            if(hh[i]-hh[i-4]==4)
                return true;
        }
        int index1 = tem.indexOf("A");
        int index2 = tem.indexOf("K");
        int index3 = tem.indexOf("Q");
        int index4 = tem.indexOf("J");
        int index5 = tem.indexOf("10");
        return false;
    }
}
