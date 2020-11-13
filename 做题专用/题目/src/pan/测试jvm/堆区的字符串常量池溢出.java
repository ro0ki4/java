package pan.测试jvm;

/**
 * @author ro0ki4
 * @data 2020/9/29 23:59
 * version 1.0
 */
public class 堆区的字符串常量池溢出 {
    public static void main(String[] args) {
        String str1 = "jisuanjiruanjian";
        String str2 = "jisuanjiruanjian";
        String str3 = new String(str1);
        System.out.println(str1==str3);
        System.out.println(str1==str2);
        System.out.println(str3.intern() == str3);
        System.out.println(str1.intern() == str2);
        String str4 = new StringBuilder("jisuanjiruanjia").append("n").toString();
        System.out.println(str4.intern()==str4);
        
        
//        Integer a = 1;
//        while(true) {
//            s = s + "1";
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}


abstract class hh{
    abstract void te();
    
    int solu(int n){
        if(n == 5){
            return 1;
        }
        int val = solu(n-1);
        return 0;
    }
}