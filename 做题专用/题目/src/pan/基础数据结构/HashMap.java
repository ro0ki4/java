package pan.基础数据结构;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ro0ki4
 * @data 2020/10/8 15:31
 * version 1.0
 *
 * 需要一个map接口，包含了put(key,value)  get(key)方法
 * map接口需要一个内部接口Entry，包含了getValue（）和 getkey（）方法
 *
 * 定义一个自己的hashmap类实现map接口，首先定义一个内部类Node实现Entry接口，额外添加
 * hash属性保存Node对象的hash值，然后实现getValue（）和 getKey（）方法，我们需要额实现Node的equals方法和
 * hashcode方法，只关注 key 属性
 *
 * hashmap类需要有的属性为默认的散列的初始长度DEFAULTLEN
 * 定义hashmap的长度size，散列长度len，扩容因子factory
 *
 * 实现put方法，实现resize（）方法，实现get（）方法
 * put（）{
 *     1 如果对应下标为null，那么直接填充
 *     2 如果下标不为空，但是发现链表中包含重复的key值，直接取代
 *     3 如果链表中不包含重复的key值，且没有大于阈值，直接添加
 *     4 如果大于阈值，那么需要resize，将散列长度变为原长度两倍
 * }
 *
 * resize(){
 *     1 首先新建一个长度为原数组长度两倍的数组
 *     2 依次遍历原散列中的元素，必须在遍历的时候将链表断开
 * }
 */
public class HashMap<K,V> {
    
    public static void main(String[] args) {
        int a = 1;
        int b =2;
        System.out.println(a > b ? 1 : 2);
        
        ConcurrentHashMap<Integer,Integer> map1 = new ConcurrentHashMap<>();
        
//        int a = -1;
//        System.out.println(a>>1);
//        System.out.println(a>>>1);
//        System.out.println(Math.pow(2,31)-1);
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < 16; i++){
            map.put(i,i);
        }
        map.put(4, 5);
        map.put(19, 6);
        System.out.println("结束");
        System.out.println(map.get(4)+"  "+map.get(19));
        
    }
    
    /*******************************************************************/
    static class Node<K,V> implements Map.Entry{
        
        final int hash;
        Node<K,V> next;
        K key;
        V value;
        
        public Node(K key, V value, Node<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = key.hashCode();
        }
        
        
        @Override
        public int hashCode(){
            return Objects.hashCode(this.key);
        }
        
        public boolean equals(Object o){
            if(o == this)
                return true;
            if(o instanceof Map.Entry){
                Map.Entry obj = (Map.Entry) o;
                return Objects.equals(key,obj.getKey());
            }else
                return false;
        }
        
        public final int hash(){
            return hash;
        }
        
        @Override
        public K getKey() {
            return key;
        }
    
        @Override
        public V getValue() {
            return value;
        }

    }
    /********************************************************************************/
    
    private final int DEAFULTLEN = 1 << 4;
    
    private int len = DEAFULTLEN;
    
    private double factory = 0.75;
    
    private int size;
    
    private Node<K,V>[] table;

    
    public HashMap(){
        table = (Node<K,V>[])new Node[16];
        size = 0;
    }
    
    public int size(){
        return size;
    }
    
    private int getIndex(K k){
        int index = k.hashCode()&(len-1);
        return Math.abs(index);
    }
    
    private int getIndex(int hashcode){
        int index = hashcode&(len-1);
        return Math.abs(index);
    }
    
    private void resize(){
        int oldLen = len;
        int newLen = len << 1;
        len = newLen;
        Node<K,V>[] oldTable = table;
        table = new Node[len];
        int sum = 0;
        for(int i = 0; i < oldLen; i++){
            Node<K,V> cur = oldTable[i];
            while(cur != null){
                Node<K,V> nextNode = cur.next;
                cur.next = null;
                put(cur);
                cur = nextNode;
            }
            System.out.println(sum++);
        }
        return;
    }
    
    private void put(Map.Entry<K,V> o){
        Node<K,V> addtion = (Node<K,V>) o;
        int index = getIndex(addtion.hash);
        Node<K,V> cur = table[index];
        if(cur == null)
            table[index] = addtion;
        else{
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = addtion;
        }
    }
    
    public V get(K key){
        int index = getIndex(key.hashCode());
        Node<K,V> cur = table[index];
        while(cur != null){
            if(key.equals(cur.getKey()))
                return cur.getValue();
            else{
                cur = cur.next;
            }
        }
        return null;
    }
    
    public Node<K,V> put(K key, V value){
        Node<K,V> addtion = new Node<>(key,value,null);
        this.size ++;
        int index = getIndex(addtion.hash());
        if(table[index] != null){
            Node<K,V> cur = table[index];
            
            if(cur.equals(addtion)){
                Node<K,V> rtn = cur;
                size --;
                table[index] = addtion;
                return rtn;
            }else{
                while(cur.next != null && !cur.equals(addtion)){
                    cur = cur.next;
                }
                if(cur.next == null){
                    cur.next = addtion;
                    if(len < size/factory){
                        resize();
                        System.out.println("hello");
                    }
                    return null;
                }else{
                    size --;
                    Node<K,V> rtn = cur.next;
                    addtion.next = rtn.next;
                    cur.next = addtion;
                    return rtn;
                }
            }
        }else{
            table[index] = addtion;
            return null;
        }
    }
    
}
