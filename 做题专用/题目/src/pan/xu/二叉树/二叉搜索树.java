package pan.xu.二叉树;

import java.util.*;

/**
 * @author ro0ki4
 * @data 2020/9/29 0:50
 * version 1.0
 */
public class 二叉搜索树 {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        Integer[] nums = new Integer[]{5,2,6,1};
        int len = nums.length;
        Integer[] res = new Integer[len];
        Arrays.fill(res,0);
        TreeNode root = new TreeNode(0);
        for(int i = len-2; i >= 0; i--){
            addAndCount(root,new TreeNode(nums[i]),res,i);
        }
        for(int i : res){
            System.out.print(i+"  ");
        }
    }
    
    public void addNode(TreeNode tree, TreeNode node){};
    
    public static void addAndCount(TreeNode root, TreeNode node,Integer[] res, int index){
        if(node.val > root.val){
            node.count += root.leftval+1;
            if(root.right == null){
                root.right = node;
                res[index] = node.count;
                return;
            }
            addAndCount(root.right,node,res,index);
        }else{
            root.leftval ++;
            if(root.left == null){
                res[index] = node.count;
                root.left = node;
                return;
            }
            addAndCount(root.left,node,res,index);
        }
    }
    
    private static class TreeNode{
        int count;
        TreeNode left;
        TreeNode right;
        int val;
        int leftval = 0;
        public TreeNode(int val){
            this.count = 0;
            this.left = null;
            this.right = null;
            this.val = val;
        }
    }
}
