package com.edu.xust;

import java.util.Vector;

public class Second {
    public static void main(String[] args){
        //String hehe = "xupan";
        // String haha = new String("xupan");
        // StringBuffer hehe = new StringBuffer("xupan");
        // System.out.println(hehe.hashCode());
        // hehe.append("fff");
        // System.out.println(hehe.hashCode());
        Vector<Integer> mm = new Vector<Integer>(1);
        mm.add(0,2);
        mm.add(1,2);
        mm.add(2,3);
        System.out.println(mm.size()+"  "+mm.toString());
        int xupan = 12;
        System.out.println(xupan+"  "+(xupan>>2));
        
    }   
    
}
