package pan.面试题;

import java.util.ArrayList;

/**
 * @author ro0ki4
 * @data 2020/8/12 0:19
 * version 1.0
 */
public class 百词斩 {
    static int res  = 0;
    public static void main(String[] args) {
        Integer num2 = 1;
        int num1 = 1;
        
        Integer num3 = new Integer(1);
        
        System.out.println(num1==num2);
        System.out.println(num2==num3);
        System.out.println(num3==num1);

//        show("1,2#3,4");
//
//        System.out.println(10/Math.pow(10,0) >= 10);
//        dfs(12258,5);
//        System.out.println(res);
    }

    public static void dfs(int num,int len){
        if(len <= 1){
            res++;
            return;
        }
        //one
        dfs((int)(num%Math.pow(10,len-1)),len-1);
        //two
        if(len >= 2 && (int)(num/Math.pow(10,len-2)) <= 25){
            dfs((int)(num%Math.pow(10,len-2)), len-2);
        }
    }

    static void one(int num){
        if(num == 2)
            System.out.println(true);
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num%i == 0){
                System.out.println(true);
                break;
            }
        }
        System.out.println(false);
    }

    static void two(String s){
        StringBuilder res = new StringBuilder();
        int i = 0;
        int j = 0;
        for(int k = 1; k < s.length(); k++){
            if(Integer.parseInt(s.charAt(k)+"") == Integer.parseInt(s.charAt(k-1)+"")+1){
                j++;
                if(k == s.length()-1){
                    if(j - i >= 3){
                        res.append(s.charAt(i)+"-"+s.charAt(j));
                    }else{
                        res.append(s.substring(i,j+1));
                    }
                }
            }else{
                if(j - i >= 3){
                    res.append(s.charAt(i)+"-"+s.charAt(j));
                }else{
                    res.append(s.substring(i,j+1));
                }
                i = k;
                j = k;
            }
        }
        if(res.length() == 0){
            System.out.println(s.charAt(0)+"-"+s.charAt(s.length()-1));
        }
        System.out.println(res.toString());
    }

    static String three(String a,String b){
        int len1 = a.length();
        int len2 = b.length();
        int i = 0;
        int jin = 0;
        StringBuilder res = new StringBuilder();
        while(i <= Math.max(len1,len2)){
            i++;
            //int jin = 0;
            int ben = 0;
            int a1 = len1-i >= 0 ? a.charAt(len1-i)-97 : 0;
            int a2 = len2-i >=0 ? b.charAt(len2-i)-97 : 0;
            int mid = a1+a2+jin;
            jin = mid/26;
            ben = mid%26;
            res.append((char)(ben+97));
        }
        //res.append()
        System.out.println(res);
        String dd = res.reverse().toString();
        if(dd.charAt(0) == 'a')
            return dd.substring(1);
        return res.toString();
    }



    public static void show(String s){
        String[] str = s.split("#");
        int len1 = str.length;
        int len2 = str[0].split(",").length;
        String[][] mat = new String[len1][len2];
        for(int i = 0; i < len1; i++){
            String tem = str[i];
            mat[i] = tem.split(",");
        }

        int left = 0;
        int right = len2-1;
        int top = 0;
        int down = len1-1;
        int x = 0;
        int y = 0;

        while(true){
            if(left >= right || top >= down)
                return;
            for(int i = left; i <= right; i++){
                System.out.print(mat[top][i]);
            }
            top++;
            for(int i = top; i <= down; i++){
                System.out.print(mat[i][right]);
            }
            right--;
            for(int i = right; i >= left; i--){
                System.out.print(mat[down][i]);
            }
            down--;
            for(int i = down; i >= top; i--){
                System.out.print(mat[i][left]);
            }
            left++;
        }
    }
}


interface test{
    
    int a = 0;
    
    default void hh(){
        return;
    }
    
    public void show();
    
}

class hhh implements test{
    
    @Override
    public void show() {
        return;
    }
    
    public void hh(){
        return;
    }
}