package edu.xust;

import java.util.*;

public class First {
	public static void main(String[] args) {
		/*
		HashSet<Person> people=new HashSet<>();
		people.add(new Person("xupan", 11));
		people.add(new Person("xu", 23));
		people.add(new Person("pan", 13));
		people.add(new Person("xupan", 13));
		System.out.println(people);

		 */
		Map map=new TreeMap(new example());
		map.put("2", "x");
		map.put("1", "u");
		map.put("3", "p");
		map.put("4", "a");
		map.put("5", "n");
		System.out.println(map);
		Iterator it = (map.keySet()).iterator();
		while(it.hasNext()){
			Object valuekey=it.next();
			Object value=map.get(valuekey);
			System.out.println(value);
		}

	}
}

class Person{
	String name;
	int age;
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	@Override
	public boolean equals( Object object){
		if(!(object instanceof Person))
			return false;
		else
			return name.equals(((Person)object).name);
	}
	@Override
	public int hashCode(){
		return name.hashCode();
	}
	@Override
	public String toString(){
		return(name+"  "+age);
	}
}
class example implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		return ((String)o1).compareTo((String)o2);
	}
}