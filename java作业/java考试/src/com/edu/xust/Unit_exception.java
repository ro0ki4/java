package com.edu.xust;

public class Unit_exception {
    public static void main(String[] args) {
        try{
            show(0);
        }catch(Myexception e){
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
    }
    static void show(int i)throws Myexception{
        if(i==0)
            throw new Myexception("传入的参数是0");
        else
            return;
    }
}

class Myexception extends Exception{
    public Myexception(String str){
        super(str);
    }
    public Myexception(){
        super();
    }
}
