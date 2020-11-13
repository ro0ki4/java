package pan.面试题.携程;

import java.util.*;

/**
 * @author ro0ki4
 * @data 2020/10/13 9:59
 * version 1.0
 */
public class dd1 {
    public static void main(String[] args) {
        Scanner scan  =new Scanner(System.in);
        
    }
    
    static int solu(int m, int a, int b, int c ,int x){
//        Map<Integer,Integer> map = new HashMap<>();
//        map.put(10,a);
//        map.put(50,b);
//        map.put(100,c);
        int[] money = new int[3];
        money[0] = a;
        money[1] = b;
        money[2] = c;
        int res = 0;
        for(int i = 0; i < m; i++){
            if(money[2]*100 >= x){
                if(x%100 != 0){
                    res += x/100 + 1;
                    money[2] -= x/100 + 1;
                    money[1] += (x%100)/50;
                    money[0] += (x%100)%50 / 10;
                }else{
                    res += x/100;
                    money[2] -= x/100;
                }
            }else if(money[2]*100+money[1]*50 >= x){
                res += money[2];
                
                int num = 0;
                num = (x-money[2]*100)/50;
                if((x-money[2]*100)%50 != 0){
                    res += num+1;
                    money[1] -= num+1;
                    money[0] += (x-money[2]*100)%50 /10;
                }else{
                    res += num;
                    money[1] -= num;
                }
                money[2] = 0;
            }else if(money[2]*100 + money[1]*50 + money[0]*10 >= x){
                res += money[2];
                res += money[1];
                res += (x-money[2]*100 - money[1]*50)/10;
                money[0] -= (x-money[2]*100 - money[1]*50)/10;
                money[2] = 0;
                money[1] = 0;
            }else
                break;
        }
        return res;
    }
    
    static int solu2(String[] lines){
//        int len = lines.length;
//        Map<String,Integer> map = new HashMap<>();
//        for(int i = 0; i < len; i++){
//            if(!lines[i].contains("=")) {
//                int index = lines[i].indexOf("[");
//                int index2 = lines[i].indexOf("]");
//                String cur = lines[i].substring(0,index);
//                Integer value = Integer.parseInt(lines[i].substring(index+1,index2));
//                map.put(cur,value);
//                continue;
//            }
//            else{
//                String[] cur = lines[i].split("=");
//                if(cur[1].indexOf("[") == -1){
//                    int index1 = cur[0].indexOf("[");
//                    int index2 = cur[0].indexOf("]");
//                    String tem = cur[0].substring(0,index1);
//                    Integer val = Integer.parseInt(cur[0].substring(index1+1,index2));
//                    if(!map.keySet().contains(tem))
//                        return i;
//                    if(map.get(tem) < val){
//                        return i;
//                    }
//                }else {
//                    int index1 = cur[0].indexOf("[");
//                    int index2 = cur[0].indexOf("]");
//                    String tem1 = cur[0].substring(0,index1);
//                    Integer val1 = Integer.parseInt(cur[0].substring(index1+1,index2));
//                    if(!map.keySet().contains(tem1)){
//                        return i;
//                    }
//                    if(val1 > map.get(tem1)){
//                        return i;
//                    }
//                    int flag = lines[i].indexOf("=");
//                    int index3 = cur[1].indexOf("[");
//                    int index4 = cur[1].indexOf("]");
//                    String tem2 = cur[1].substring(flag+1,index3);
//                    Integer val2 = Integer.parseInt(cur[1].substring(index3+1,index4));
//                    if(!map.keySet().contains(tem2))
//                        return i;
//                    if(map.get(tem2) < val2){
//                        return i;
//                    }
//
//                }
//            }
//        }
//        return 0;
        return 0;
    }
    
    static void solu3(){
        List<Integer> list = new ArrayList<>();
        int size = list.size()/2;
        int[] value = new int[size];
        int[] flag = new int[size];
        for(int i = 0; i < size; i++){
            flag[i] = i;
        }
        int index = 0;
        for(int i = 0; i < size; i++){
            value[i] = list.get(index)-list.get(index+1);
            index += 2;
        }
    
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size-i-1; j++){
                if(value[j]>value[j+1]){
                    int tema = value[j];
                    value[j] = value[j+1];
                    value[j+1] = tema;
                    int temb = flag[j];
                    flag[j] = flag[j+1];
                    flag[j+1] = temb;
                }
            }
        }
    
        int shu = size/2;
        int res = 0;
        for(int i = size-1; i >= shu; i--){
            res += list.get(flag[i]*2);
        }
        for(int i = 0; i < shu; i++){
            res += list.get(flag[i]*2+1);
        }
        System.out.print(res);
    
    
        //Start coding
    }
}
