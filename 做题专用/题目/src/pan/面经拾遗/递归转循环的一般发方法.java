package pan.面经拾遗;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ro0ki4
 * @data 2020/11/7 15:07
 * version 1.0
 */
public class 递归转循环的一般发方法 {
    
    static class Node{
        Node left;
        Node right;
        int val;
        public Node(){}
        public Node(int val){this.val = val;}
    }
    
    static class Record{
        Node node;
        int status;
        public Record(){}
        public Record(Node cur, int status){this.node = cur;this.status = status;}
        public Record(int status){this.status = status;}
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.left = new Node(7);
        
        preVis(root);
        System.out.println("============================");
        nonPre(root);
        System.out.println("+++++++++++++++++++++++++++++++");
        midVis(root);
        System.out.println("========================");
        nonMid(root);
    }
    
    public static void preVis(Node root){
        if(root == null)
            return;
        System.out.println(root.val);
        preVis(root.left);
        preVis(root.right);
    }
    
    public static void nonPre(Node root){
        Deque<Record> stack = new LinkedList<>();
        Node curnode = root;
        int curstatus = 0;
        boolean flag = true;
        while(true){
            if(!flag)
                break;
            if(curnode == null){
                if(stack.size() <= 0)
                    break;
                Record cur = stack.pop();
                curnode = cur.node;
                curstatus = cur.status;
            }
            switch (curstatus){
                case 0:{
                    System.out.println(curnode.val);
                    stack.push(new Record(curnode, 1));
                    curnode = curnode.left;
                    curstatus = 0;
                    break;
                }
                case 1:{
                    stack.push(new Record(curnode, 2));
                    curnode = curnode.right;
                    curstatus = 0;
                    break;
                }
                case 2:{
                    if(stack.size() <= 0){
                        flag = false;
                        break;
                    }
                    Record cur = stack.pop();
                    curnode = cur.node;
                    curstatus = cur.status;
                    break;
                    
                }
            }
        }
    }
    
    public static void midVis(Node root){
        if(root == null)
            return;
        midVis(root.left);
        System.out.println(root.val);
        midVis(root.right);
    }
    
    public static void nonMid(Node root){
        Deque<Record> stack = new LinkedList<>();
        Node curnode = root;
        int curstatus = 0;
        boolean flag = true;
        while(true){
            if(!flag)break;
            if(curnode == null){
                if(stack.size() <= 0)break;
                Record cur = stack.pop();
                curnode = cur.node;
                curstatus = cur.status;
                
            }
            switch (curstatus){
                case 0:{
                    stack.push(new Record(curnode,1));
                    curnode = curnode.left;
                    curstatus = 0;
                    break;
                }
                case 1:{
                    System.out.println(curnode.val);
                    stack.push(new Record(curnode,2));
                    curnode = curnode.right;
                    curstatus = 0;
                    break;
                }
                case 2:{
                    if(stack.size() <= 0) {
                        flag = false;
                        break;
                    }
                    Record cur = stack.pop();
                    curnode = cur.node;
                    curstatus = cur.status;
                    break;
                }
            }
        }
    }
    

}
