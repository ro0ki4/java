package com.xustedu;

public class shiyandigui {
	static int a=0;
  public static void main(String[] args) {
  	ss();
  }
  static void ss(){
  	a++;
  	System.out.println(a);

  	if(a>=100)
  		return;
  	else{
  		ss();
    }
	System.out.println("--------------"+a);
  }
}
