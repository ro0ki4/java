package com.xustedu;
import java.util.*;
public class string_operation {
  public static void main(String[] args) {
  	String string;
  	Scanner scanner=new Scanner(System.in);
  	System.out.println("请输入目标字符串");
  	string=scanner.nextLine();//目标字符串
  	System.out.println("请输入目标字符1");
  	char character=scanner.nextLine().charAt(0);//目标字符1
	System.out.println("请输入目标字符2");
  	char character1=scanner.nextLine().charAt(0);//目标字符2
	double[][] purpose=new double[string.split(character+"").length][];//二维表
	String[] var=string.split(character+"");//被分成的数组
	for(int i=0;i<string.split(character+"").length;i++){
		int mylength=var[i].split(character1+"").length;
		purpose[i]=new double[mylength];
		for(int j=0;j<mylength;j++)
			purpose[i][j]=Double.parseDouble(var[i].split(character1+"")[j]);
	}
	show(purpose);
  }
  static void show(double[][]a){
  	System.out.println("结果是");
  	for(int i=0;i<a.length;i++){
  		for(int j=0;j<a[i].length;j++){
  			System.out.print(a[i][j]+"    ");
	    }
  		System.out.println();
    }
  }
}
