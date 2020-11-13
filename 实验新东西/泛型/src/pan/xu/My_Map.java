package pan.xu;
import java.util.*;
/**
 * 通过实现comparable接口的comparaTo()方法来实现排序
 * 也可以通过comparator接口的compare（）方法来实现排序
 */
public class My_Map {
  public static void main(String[] args) {
	  Set<bitch> you=new TreeSet<>();
	  you.add(new bitch("xiaohong",10));
	  you.add(new bitch("xiaoliang",5));
	  you.add(new bitch("xiaohai",10));
	  you.add(new bitch("xiaopengg",6));
	  you.forEach((name)->System.out.println(name));
	  System.out.println("\n");
	  Map map=new HashMap();
	  map.put("1",new bitch("xx",1));
	  String xupan=new String("shigeshabi");
	  String[] xumouren= xupan.split("h");
	  System.out.println(xumouren);
  }
}
class bitch implements Comparable{
	String name;
	int age;
	public bitch(String name,int age){
		this.age=age;
		this.name=name;
	}
	public bitch(){}
	@Override
	public int compareTo(Object o) {
		bitch o1=(bitch)o;
		if(o1.age>this.age)
			return -1;
		else if(o1.age<this.age)
			return 1;
		else if(this.name.length()>o1.name.length())
			return 1;
		else if(this.name.length()<o1.name.length())
			return -1;
		else
			return 0;
	}
	@Override
	public String toString(){
		return this.name+"--"+this.age;
	}
}
