package pan.基础数据结构;


import java.util.Objects;

/**
 * @author ro0ki4
 * @data 2020/10/5 20:34
 * version 1.0
 */
public class SearchTree {
    
    public static void main(String[] args) {
        SearchTree searchTree = new SearchTree();
        Tree root = new Tree(10);
        searchTree.addTreeNode(root,7);
        searchTree.addTreeNode(root,15);
        searchTree.addTreeNode(root,1);
        searchTree.addTreeNode(root,9);
        searchTree.addTreeNode(root, 13);
        searchTree.addTreeNode(root,16);
        searchTree.addTreeNode(root,8);
        searchTree.addTreeNode(root,14);
        
        System.out.println();
        searchTree.deleteTreeNode(root,15);
        System.out.println(searchTree.findVal(root,8));
        
    }
    
    public Tree addTreeNode(Tree root, int val){
        if(root == null){
            return new Tree(val);
        }
        Tree real = root;
        while(root != null){
            if(val > root.val){
                if(root.right == null){
                    root.right = new Tree(val);
                    return real;
                }
                root = root.right;
            }else{
                if(root.left == null){
                    root.left = new Tree(val);
                    return real;
                }
                root = root.left;
            }
        }
        return real;
    }
    
    /**
     * @action 删除一个节点
     * 寻找到小于被删除节点的最大节点 来替代 被删除节点
     * @param root
     * @param val
     */
    public void deleteTreeNode(Tree root, int val){
        Tree parent = root;
        boolean direction = true;
        while(root != null){
            if(root.val == val){
                //寻找到需要删除的节点
                Tree targetNode = root;
                //寻找到仅仅小于被删除节点的节点
                Tree fake = root.left;
                //如果被删除节点没有左节点
                if(fake == null){
                    if(direction){//左边
                        parent.left = targetNode.right;
                        return;
                    }else{
                        parent.right = targetNode.right;
                        return;
                    }
                }else{
                    if(fake.right == null){
                        if(direction) {
                            fake.right = targetNode.right;
                            parent.left = fake;
                            return;
                        }else{
                            fake.right = targetNode.right;
                            parent.right = fake;
                            return;
                        }
                    }else{
                        while(fake.right.right != null){
                            fake = fake.right;
                        }
                        Tree tem = fake.right;
                        fake.right = tem.left;
                        fake = tem;
                        fake.left = targetNode.left;
                        fake.right = targetNode.right;
                        if(direction){
                            parent.left = fake;
                            return;
                        }else{
                            parent.right = fake;
                            return;
                        }
                    }
                }
                
            }else{
                if(root.val > val){
                    parent = root;
                    direction = true;
                    root = root.left;
                }else{
                    parent = root;
                    direction = false;
                    root = root.right;
                }
            }
        }
    }
    
    
    public boolean findVal(Tree root, int val){
        if(root == null){
            return false;
        }
        while(root != null){
            if(root.val == val){
                return true;
            }else{
                if(root.val > val){
                    root = root.left;
                }else{
                    root = root.right;
                }
            }
        }
        return false;
    }
    
    static class Tree{
        int val;
        Tree left;
        Tree right;
        
        public Tree(int val){
            this.val = val;
        }
        
        public boolean equals(Object o){
            if(this == o)
                return true;
            if(!(o instanceof Tree))
                return false;
            Tree tree = (Tree) o;
            return this.val == tree.val;
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}

