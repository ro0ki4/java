package pan.面试题.其他;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ro0ki4
 * @data 2020/10/29 17:27
 * version 1.0
 */
public class Test {
    
    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(6);
        Node node4 = new Node(2);
        
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
    
        List<Integer> method = method(node1);
    
        for (Integer integer : method) {
            System.out.println(integer);
        }
    }
    
    
    public static List<Integer> method(Node node){
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (node == null){
            return list;
        }
        while (!stack.isEmpty() || node != null){
            
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            Node temp  = stack.pop();
            list.add(temp.val);
            node = temp.right;
            
        }
        return list;
    }
    
    
    
    static class Node{
        int val;
        
        Node left;
        
        Node right;
    
        public Node(int val) {
            this.val = val;
        }
    }
    
}
