package pan.基础数据结构;

/**
 * @author ro0ki4
 * @data 2020/10/6 16:54
 * version 1.0
 */
public class UnionSet {
    private int lenght;
    private int[] parent;
    
    public static void main(String[] args) {
        UnionSet set = new UnionSet(10);
        set.union(0,1);
        set.union(1,2);
        set.union(2,9);
        
        set.union(3,4);
        set.union(3,5);
    
        System.out.println(set.getBroSize(0) + "   " + set.getBroSize(5));
        
        
    }
    
    public UnionSet(int length){
        this.lenght = lenght;
        parent = new int[length];
        for(int i = 0; i < length; i++){
            parent[i] = i;
        }
    }
    
    public int getBroSize(int index){
        int root = find(index);
        int sum  = 0;
        for(int i : parent){
            if(find(i) == root)
                sum++;
        }
        return sum;
    }
    
    public void union(int x, int y){
        int valx = find(x);
        int valy = find(y);
        parent[valx] = valy;
    }
    
    public int find(int x){
        while(x != parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
