package pan.面试题.其他;

import java.util.*;

/**
 * @author ro0ki4
 * @data 2020/10/19 20:00
 * version 1.0
 */
public class dd2 {
    public static void main(String[] args) {
        String a = "fajsldf|fdajslfj|fdsaf|fdas|dda";
        solu(a);
    }
    
    public static int solu(String s){
        String[] tem = s.split("\\|");
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for(String i : tem){
//            if(set.contains(i.split(",")[0]))
            //if(set.contains())
            set.add(i);
        }
        tem = set.toArray(new String[0]);
        Arrays.sort(tem, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String oo1 = o1.split(",")[2];
                String oo2 = o2.split(",")[2];
                return oo1.compareTo(oo2);
//                return 0;
            }
        });
        List<String> res = new ArrayList<>();
        for(int i = 0; i < tem.length; i++){
            res.add(tem[i].split(",")[1]);
        }
        int result = 0;
        int max = 0;
        for(int i = 0; i < tem.length; i++){
            if(res.get(i).equals("in"))
                result++;
            else
                result--;
            if(result < 0)
                result = 0;
            max = Math.max(max,result);
        }
        return max;
    }
}
