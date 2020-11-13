package com.edu.xust;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Unit_IO {
    public static void main(String[] args) throws Exception{
        show();
    }
    static void show()throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<5;i++){
            if (reader.readLine().equals("123456")) {
                System.out.println("正在进入游戏");
                break;
            }
            else{
                System.out.println("你已经输错了" + (i + 1) + "次密码");
            }
            if(i==4) System.out.println("你已经输错了五次了");
        }
    }
}
