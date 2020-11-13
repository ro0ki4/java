package pan.测试jvm;


public class 字符串常量池相关 {
    static final String bb = "相关";
    static String bbb = "bbb";
    
    public static void main(String[] args) throws Exception {
    
//        字符串相关 字符串相关 = new 字符串相关();
//        Thread.sleep(100);
        String s = new StringBuilder("b").append("b").toString();
        
        s.intern();
        String ss = "bb";
        System.out.println(s == ss);
        String sss = new String("bb");
        
//        String bb = new StringBuilder("相").append("关").toString();
//        String c = new StringBuilder("b").append("b").toString();
//        System.out.println(s.intern() == s);
//        System.out.println(bb.intern()== bb);
//        System.out.println(c.intern()==c);
    }
}

class 字符串相关{
    static String bb = "";
}
