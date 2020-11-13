package pan.基础数据结构;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ro0ki4
 * @data 2020/10/4 16:05
 * version 1.0
 */
public class Trie {
    
    Trie[] next;
    private final int size = 26;
    int end;
    
    public static void main(String[] args) {
    
        
    }
    
    
    public Trie() {
        this.next = new Trie[size];
        end = 0;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        char[] tem = word.toCharArray();
        int index;
        int sum = 0;
        while(sum < tem.length){
            index = tem[sum]-'a';
            sum++;
            if(root.next[index] == null){
                root.next[index] = new Trie();
                root = root.next[index];
            }else{
                root = root.next[index];
            }
        }
        root.end++;
    }
    
    /** Returns if the word is in the trie. */
    public int searchNum(String word) {
        char[] tem = word.toCharArray();
        Trie root = this;
        int index;
        int sum = 0;
        while(sum < tem.length){
            index = tem[sum]-'a';
            sum++;
            if(root.next[index] == null){
                return 0;
            }else{
                root = root.next[index];
            }
        }
        return root.end;
    }
    
    public boolean search(String word){
        return searchNum(word) > 0;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] tem = prefix.toCharArray();
        Trie root = this;
        int index;
        int sum = 0;
        while(sum < tem.length){
            index = tem[sum]-'a';
            sum ++;
            if(root.next[index] == null){
                return false;
            }else{
                root = root.next[index];
            }
        }
        return true;
    }
    
}
