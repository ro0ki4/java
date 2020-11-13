package pan.面试题.其他;


/**
 * @author ro0ki4
 * @data 2020/10/19 19:15
 * version 1.0
 */
public class 洗牌 {
    public static void main(String[] args) {
        char[] test = new char[]{'a','b','c','d','e','f'};
        xipai(test);
        
    }
    public static void xipai(char[] pai){
        for(int i = 0; i < pai.length; i++){
            int index = ((int)Math.random())%(pai.length-i);
            swap(pai,index,i);
        }
    }
    public static void swap(char[] pai, int i, int j){
        char tem = pai[i];
        pai[i] = pai[j];
        pai[j] = tem;
    }
}
