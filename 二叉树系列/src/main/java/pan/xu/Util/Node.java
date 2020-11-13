package pan.xu.Util;

public class Node {
    public Node right;
    public Node left;
    public char val;
    public Node(){};
    public Node(char val){
        this.val = val;
    }

    public Node (char val, Node left, Node right){
        this.val=val;
        this.left=left;
        this.right=right;
    }


    @Override
    public String toString() {
        return "Node{" + "right=" + right + ", left=" + left + ", val='" + val + '\'' + '}';
    }
}

