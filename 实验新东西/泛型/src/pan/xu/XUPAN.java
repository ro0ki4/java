package pan.xu;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class XUPAN {
public static void main(String[]args){
    ArrayList<String> arrayList=new ArrayList<>();
    arrayList.add("xu");
    arrayList.add("pan");
    arrayList.add("haha");
    ArrayList<Integer> arrayList1=new ArrayList<>();
    arrayList1.add(1);
    arrayList1.add(3);
    arrayList1.add(5);
    pan xupan=new pan();
    System.out.println(panduan(arrayList,xupan));
    //System.out.println(xupan.equals("haha"));
    //System.out.println(xupan.equals(arrayList.get(2)));

}
static <t> boolean panduan(ArrayList<t> arrayList,Object obj){
    //obj=(pan)obj;
    for(t i:arrayList){
        //System.out.println(i+"********\n");
        if(obj.equals(i)) {
            return true;
        }
    }
    return false;
}
}

class pan extends Object{
    String xu="haha";
    //@Override
    public boolean equals(Object string){
        String string1=(String)string;
        if(string1.length()!=this.xu.length())
            return false;
        else {
            for(int i=0;i<string1.length();i++){
                if(i==string1.length()-1&&xu.charAt(i)==string1.charAt(i)) {
                    System.out.println("成功了");
                    return true;
                    }
                }
        }
        return false;
    }
    /*
    @Override
    public boolean equals(Object object){
        //object=(String)object;
        return this.xu.equals(object);
    }

     */
}
