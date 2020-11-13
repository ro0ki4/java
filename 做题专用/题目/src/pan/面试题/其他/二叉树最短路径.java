package pan.面试题.其他;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ro0ki4
 * @data 2020/10/19 19:30
 * version 1.0
 */
public class 二叉树最短路径 {
    public static void main(String[] args) {
    
    }
    
    public static int getLength(int[][]tree,int start,int end){
        
        
        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i < tree.length; i++){
            if(start == tree[i][1])
                index1 = i;
            if(end == tree[i][1])
                index2 = i;
        }
        int res = 0;
        int maxi = (int)(Math.log(index1+2)/ Math.log(2));
        int maxj = (int)(Math.log(index2+2)/Math.log(2));
        for(int i = 0; i < maxi; i++){
            for(int j = 0; j < maxj;j++){
                int temi = index1;
                int temj = index2;
                int ii = i;
                int jj = j;
                while(ii >= 0){
                    temi = (temi-1)>>1;
                    ii--;
                }
                while(jj >= 0){
                    temj = (temj-1)>>1;
                }
                if(temi == temj){
                    res = i+j;
                    return res;
                }
            }
        }
        //return 0;
        
        Node root = new Node(tree[0][0]);
        Node tem = root;
        Deque<Node> que = new LinkedList<>();
        que.add(root);
        int index = 1;
        while(index < tree.length){
            Node curl = new Node(tree[index][1]);
            index++;
            if(index >= tree.length)
                break;
            Node curr = new Node(tree[index][1]);
            tem = que.poll();
            tem.left = curl;
            tem.right = curr;
            que.add(tem.left);
            que.add(tem.right);
        }
        
        return 0;
    }
    
    static void solu(Node root, int a,String s,String[] res){
        if(root == null)
            return;
        if(root.val == a){
            res[0] = s;
            return;
        }
        solu(root.left,a,s+root.left,res);
        solu(root.right,a,s+root.right,res);
    }
    
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
}


