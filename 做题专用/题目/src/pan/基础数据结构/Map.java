package pan.基础数据结构;

interface Map<K,V>{
    final public  int i = 1;
    
    void put(K key,V value);
    
    V get(K key);
    
    Integer size();
    
    static public abstract interface Entry<K,V>{
        
        K getKey();
        
        V getValue();
    }
    
    public static abstract class he{
        int a;
    }
    
}
