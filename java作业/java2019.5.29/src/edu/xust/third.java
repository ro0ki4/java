package edu.xust;

import java.util.Scanner;

public class third {
	public static void main(String[] args) {
		int flag=0;
		while(true){
			Scanner scan=new Scanner(System.in);
			System.out.println("请输入你的密码");
			String data=scan.nextLine();
			if (data.equals("123456")) {
				System.out.println("密码正确，进入游戏");
				break;
			}
			else
				flag++;
			if(flag>=5){
				System.out.println("你已经输错了五次密码，游戏结束");
				break;
			}
		}

	}
}
