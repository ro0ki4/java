package pan.xu.树;

import java.util.Arrays;

/**
 * @author ro0ki4
 * @data 2020/10/2 1:14
 * version 1.0
 */
public class 重建二叉树 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        重建二叉树 test = new 重建二叉树();
        TreeNode root = new TreeNode(preorder[0]);
        test.build(preorder,inorder,root);
        System.out.println();
    }
    
    public TreeNode build(int[] preorder, int[] inorder, TreeNode root){
        if(preorder.length == 1){
            return root;
        }
        if(preorder.length < 1)
            return null;
        int index = getIndex(inorder,root.val);
        int[] leftpre = Arrays.copyOfRange(preorder,1,index+1);
        int[] leftin = Arrays.copyOfRange(inorder,0,index);
        TreeNode curleft = build(leftpre ,leftin , new TreeNode(leftpre[0]));
        root.left = curleft;
        int[] rightpre = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int[] rightin =Arrays.copyOfRange(inorder,index+1,inorder.length);
        TreeNode curright = build(rightpre, rightin, new TreeNode(rightpre[0]));
        root.right = curright;
        return root;
    }
    
    private int getIndex(int[] arr, int tar) {
        for(int i = 0; i < arr.length; i++){
            if(tar == arr[i])
                return i;
        }
        return -1;
    }
    
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    
}
