package pan.xu;

public class Lamdal {
    static void run(A a,int i){
        a.Run(i);
    }

    public static void main(String[] args){
        run((b)->System.out.println(b),3);
        System.out.println("\n");
        A a=(b)->System.out.println("2");
        a.Run(6);
    }
}

interface A{
    void Run(int b);
}