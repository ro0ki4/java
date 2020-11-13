package pan.xu.Util;

import java.util.Scanner;

public class CreateTree {
    private static int i;
    public CreateTree(){
        i = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            scanner.close();
            System.out.println(str);
//            TreeNode treeNode = new TreeNode();
//            initTree(treeNode, str);
//            System.out.println(treeNode.node.val);
//            showTree(treeNode.node);
            Node node = createTree(str);
            showTree(node);

        } catch (Exception e) {
            System.err.println(this.getClass().getName()+"出现问题");
            e.printStackTrace();
        }
    }

    private void addNode(Node head, String str){//先序遍历初始化二叉树
        if (str.charAt(i) == '#' || ++i >= str.length())
            return;
        head = new Node(str.charAt(i));
        head.left = new Node(str.charAt(i++-1));
        addNode(head.left, str);
        head.right = new Node(str.charAt(i-1));
        addNode(head.right, str);

    }
    void initTree(TreeNode head,String str){
        if(str.length()<=i||str.charAt(i++)=='#')
            return;
        head.node = new Node(str.charAt(i-1));
        initTree(head, str);

    }


    Node createTree(String str){//递归构建二叉树

        if(str.charAt(i++)=='#')
            return null;
        char val = str.charAt(i-1);
        Node node = new Node(val, createTree(str), createTree(str));
        return node;
    }



    private void showTree(Node head){
        if(head==null||head.val=='#')
            return;
        System.out.print(head.val+"-");
        showTree(head.left);
        showTree(head.right);
    }
}
