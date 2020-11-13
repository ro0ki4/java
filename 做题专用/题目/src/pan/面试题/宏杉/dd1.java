package pan.面试题.宏杉;

import javafx.util.Builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ro0ki4
 * @data 2020/10/26 19:29
 * version 1.0
 */
public class dd1 {
    public static void main(String[] args) {
//        solu(27);
        System.out.println(solu3(27,26));
//        HashMap
       // System.out.println(solu(703));
        // System.out.println(strToBytes("000c29be-6c340000-5a0ec7f6-21ae8e6b"));
    }
    
    public static String strToBytes (String s) {
        // write code here
        String[] tem = s.split("-");
        List<String> res = new ArrayList<>();
        for(String i : tem){
            char[] ss = i.toCharArray();
            for(int j = 0; j < ss.length; j += 2){
                String tems = "";
                tems += ss[j];
                tems += ss[j+1];
                Integer val = Integer.valueOf(tems,16);
                
                if(val >= 128){
                    val = 128-(val-128);
                    val = -1*val;
                }
                res.add(val + "");
            }
        }
        return res.toString();
    }
    
    public static String solu(int n){
        StringBuilder tem = new StringBuilder();
        while(n > 0){
            int temp = n%26;
            n = n/26;
            if(temp == 0){
                temp = 26;
                n = n-1;
            }
            tem.append((char)('A'+temp-1));
        }
        String s = tem.toString();
        int len = s.length();
//        if(s.charAt(len-1) == 'A') {
//            String res = s.substring(0, len - 1);
//            res += (char) ((int) s.charAt(len - 1) + 1);
//            return res;
//        }
        return tem.toString();
    }
    
    public static String solu3(int n,int m){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int tem = n%m;
            sb.append((char)('A'+tem));
            n = n/m;
        }
        return sb.reverse() .toString();
    }
}
