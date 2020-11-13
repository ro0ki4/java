package com.edu.xust.function;

import com.edu.xust.MyMap;
import com.edu.xust.Node;

public class Base {

    public static int findLocation(MyMap map, char line){//查找节点line在图中的下标位置
        int i=-1;
        for(int j=0;j<map.line.length;j++){
            if(map.line[j]==line){
                i=j;
                break;
            }
        }
        return i;
    }

    public static int findFirstNode(MyMap map,char line){//查找节点line在图中的第一个邻接点
        //首先找到节点line在map图中的位置
        int location = findLocation(map, line);
        int location1=-1;
        //查找节点line在map图中的第一个邻接点
        for(int j=0;j<map.line.length;j++){
            if(map.arcs[location][j].val==1){
                location1 = j;//邻接点的位置
                break;
            }
        }
        return location1;
    }

    public static void show(Node[][] nodes){
        for(int i=0;i<nodes.length;i++){
            for(int j=0;j<nodes[i].length;j++){
                if(j==nodes[i].length-1)
                    System.out.print(nodes[i][j].val);
                else
                    System.out.print(nodes[i][j].val + "-");
            }
            System.out.println();
        }
    }


}
