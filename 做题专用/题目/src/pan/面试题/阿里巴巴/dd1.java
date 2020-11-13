package pan.面试题.阿里巴巴;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ro0ki4
 * @data 2020/10/13 19:01
 * version 1.0
 */
public class dd1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i < t; i++){
            String[] cur = scan.nextLine().split(" ");
            solu(cur[0],cur[1]);
        }
    }
    
    public static void solu(String a,String b){
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int index1 = 0;
        int index2 = 0;
        boolean bol = true;
        while(index1 < aa.length && index2 < bb.length){
            if(aa[index1] > bb[index2]){
                System.out.println(a);
                return;
            }else{
                //int flag1 = a.substring(index1+1).indexOf(bb[index2]+1);
                int flag1 = find(a.substring(index1+1),(char)(bb[index2]+1));
                if(flag1 != -1){
                    System.out.println(a.substring(0,index1)+(char)(bb[index2]+1) + a.substring(index1+1,index1+1+flag1)+a.substring(index1+1+flag1));
                    return;
                }else{
                    if(aa[index1] == bb[index2]){
                        index1++;
                        index2++;
                        continue;
                    }else{
                        if(!bol){
                            System.out.println(b);
                            return;
                        }
//                        int flag2 = a.substring(index1+1).indexOf(bb[index2]);
                        int flag2 = find(a.substring(index1+1),bb[index2]);
                        if(flag2 != -1){
                            bol = false;
                                //char tem = aa[index1+flag2+1];
                            aa[index1+flag2+1] = aa[index1];
                            aa[index1] = bb[index2];
                            index1++;
                            index2++;
                        }else{
                            System.out.println(b);
                        }
                    }
                }
            }
        }
        if(index2 < bb.length){
            System.out.println(b);
            return;
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < aa.length; i++){
                sb.append(aa[i]);
            }
            System.out.println(sb.toString());
            return;
        }
    }
    
    public static int find(String s,char a){
        int index = -1;
        
        int n = s.length();
        for(int i = n - 1;i >= 0;i--){
            if(s.charAt(i) == a){
                index = i;
                return i;
            }
        }
        
        return index;
    }
}
