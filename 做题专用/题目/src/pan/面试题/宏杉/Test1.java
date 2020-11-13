package pan.面试题.宏杉;

/**
 * @author ro0ki4
 * @data 2020/11/4 9:34
 * version 1.0
 */
public class Test1 {



}


class Data{
    
    Object object = new Object();
    Object object1 = new Object();
    
    
    public void method1(){
        
        synchronized (object){
            
            synchronized (object1){
            
            
            }
            
        }
        
    }
    
    public  void  method(){
        
        synchronized (object1){
            
            synchronized (object){
            
            
            
            }
            
        }
        
    }
    
}
