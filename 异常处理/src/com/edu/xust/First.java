package com.edu.xust;

public class First {
	public static void main(String[] args) {
		try {
			int c=devide(56, 0);
			System.out.println(c);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}
	static int devide(int a,int b)throws Exception{
		if(b==0){
			throw new Exception("除数不能为0");
		}
		else{
			int c=a/b;
			return c;
		}
	}
}


class myexception extends Exception{
	public myexception(){
		super();
	}
	public myexception(String s){
		super(s);
	}
}