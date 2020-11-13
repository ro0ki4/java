package pan.xu;

import pan.xu.Util.CreateTree;
import pan.xu.Util.Node;
import sun.reflect.generics.tree.Tree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new CreateTree();

//        Node head = new Node('0');
//        change(head);
//        System.out.println(head.val);

    }

    static void change(Node head){
        //head = new Node('5');
        head.val = '3';
    }
}

