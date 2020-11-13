package edu.xust;

public class Digui {
	static int flag=1;
	public static void main(String[] args) {
		System.out.println(function1_1(2));
		function1_2(2);
		flag=0;
		System.out.println(function2_1(22));
	}
	static int function1_1(int n){
		if(flag==8)
			return 1;
		else{
			System.out.println("第" + flag + "次鸭子还剩" + n + "只");
			flag++;
			return(function1_1((2*(n+1))));
		}
	}
	static void function1_2(int n){//非递归
		flag=7;
		int num=n;
		for (int i = 0; i < flag; i++) {
			System.out.println("第" + (i+1) + "次鸭子还剩" + num + "只");
			num=(num+1)*2;
		}
	}
	static int function2_1(int n){//角谷定理
		System.out.println(n);
		if(n==1)
			return 1;
		else{
			flag++;
			if(n%2==0){
				return function2_1(n/2);
			}
			else{
				return function2_1(3 * n+1);
			}
		}
	}
	static void function2_2(int n){
		int flag=0;
		int num=n;
		while(n!=1){
			flag++;
			if(n%2==0)
				n/=2;
			else
				n=n*3+1;
		}
	}
}
