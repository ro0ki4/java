package com.edu.xust;

import com.edu.xust.function.Base;
import org.junit.Test;

public class Mytest2 {
    @Test
    public void test1(){
        Node[][] nodes = new Node[5][5];
        for(int i=0;i<nodes.length;i++){
            for(int j=0;j<nodes[i].length;j++){
                nodes[i][j] = new Node();
            }
        }
        //Base.show(nodes);

        for(int i=0;i<nodes.length;i++){
            for(int j=0;j<nodes[i].length;j++){
                if(i==0&&j==1) {
                    nodes[i][j].val=1;
                    nodes[j][i].val=1;
                }
                if(i==0&&j==3){
                    nodes[i][j].val=1;
                    nodes[j][i].val=1;
                }
                if(i==1&&j==2){
                    nodes[i][j].val=1;
                    nodes[j][i].val=1;
                }
                if(i==2&&j==3){
                    nodes[i][j].val=1;
                    nodes[j][i].val=1;
                }
                if(i==2&&j==4){
                    nodes[i][j].val=1;
                    nodes[j][i].val=1;
                }
                if(i==1&&j==4){
                    nodes[i][j].val=1;
                    nodes[j][i].val=1;
                }
            }
        }
        Base.show(nodes);
        char[] line = {'a', 'b', 'c', 'd', 'e'};
        MyMap map = new MyMap(line, nodes, 5, 6);
        System.out.println(Base.findLocation(map, 'e'));

        System.out.println(Base.findFirstNode(map, 'd'));
    }
}
