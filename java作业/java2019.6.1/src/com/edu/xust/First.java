package com.edu.xust;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class First {
	public static void main(String[] args) {
		/*
		ArrayList<Integer> list=new ArrayList<>();
		Scanner scan=new Scanner(System.in);
		System.out.println("输入一个非负数");
		int input=scan.nextInt();
		System.out.println("输入进制");
		int output=scan.nextInt();
		System.out.println("输入一个数");
		int flag=scan.nextInt();
		transform_feidigui(input,output,list);
		show(list);
		System.out.println();
		System.out.println("_____________________________________\n"+
				"_____________________________________\n");
		transform_primary(flag,0);

		 */
		transform_primary_feidigui(5,0);
		System.out.println();
		transform_primary(5,0);
	}
	static void transform_feidigui(int a, int b, ArrayList<Integer> c){
		int i=0;
		while(true){
			c.add(a%b);
			a=a/b;
			if(a==0)
				break;
		}
	}
	static void show(ArrayList<Integer> c){
		for(int i=c.size()-1;i>=0;i--){
			if(c.get(i)>9)
				System.out.print((char) (c.get(i) + 55)+" ");
			else
				System.out.print(c.get(i)+" ");
		}
	}
	static void transform_digui(int a,int b,ArrayList<Integer> c){
		if(a==0)
			return;
		else{
			c.add(a%b);
			a=a/b;
			transform_digui(a,b,c);
		}
	}
	static void transform_primary(int a,int b){
		if(a==0) {
			System.out.print("0");
			return;
		}
		else{
			if(b==1)
				System.out.print("+2(");
			else
				System.out.print("2(");
			int i=0;
			while(true){
				if(a<Math.pow(2,i))
					break;
				else
					i++;
			}
			transform_primary(i-1,0);
			System.out.print(")");
			if(a-(int)Math.pow(2,i-1)>0)
				transform_primary(a - (int)Math.pow(2, i - 1),1);
		}
	}


	static void transform_primary_feidigui(int a,int b){
		Stack<mynode> node=new Stack<>();
		int state=0;
		while(true){
			//System.out.println("------"+state);
			if(a==0){//返回上一级
				System.out.print("0");
				if(node.empty())
					break;
				else{//如果不是空
					a=node.peek().a;
					state=node.peek().state;
					b=node.peek().b;
					node.pop();
				}
			}
			else{
				int i=0;
				while(true){
					if(a<Math.pow(2,i))
						break;
					else
						i++;
				}
				if(state==0) {
					if (b == 1)
						System.out.print("+2(");
					else
						System.out.print("2(");
						node.push(new mynode(a, 1, b));
						a = i - 1;
						state = 0;
						b = 0;
				}
				else if(state==1){
					System.out.print(")");
					//node.push(new mynode(a, 2, b));
					if(a-(int)Math.pow(2,i-1)>0){
						node.push(new mynode(a, 2, b));
						a=a-(int)Math.pow(2,i-1);
						state=0;
						b=1;
						continue;/////////理解递归的转化
					}
						if(node.empty())
							break;
						else{
							a=node.peek().a;
							state=node.peek().state;
							b=node.peek().b;
							node.pop();
						}
				}
				else if(state==2){
					if(node.empty())
						break;
					else{
						a=node.peek().a;
						state=node.peek().state;
						b=node.peek().b;
						node.pop();
					}
				}
			}
		}
	}
}

class mynode{
	int a=0;
	int state=0;
	int b=0;
	public mynode(int a,int state,int b){
		this.a=a;
		this.b=b;
		this.state=state;
	}
	public mynode(){}
}
