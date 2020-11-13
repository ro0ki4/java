public class Example{
    public static void main(String[] args) {
        
    }
}

class A{
    private static volatile A ins = null;
    private A(){}
    public static synchronized A getInstance(){
        if(ins == null){
            ins = new A();
        }
        return ins;
    }
}