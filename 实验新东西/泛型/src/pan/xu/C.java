package pan.xu;

/**
 * 比较泛型的各种特性
 *
 */

public class C {

    public static void main(String[]args){
        CC<String> aa=new CC("xupan");
        CC<Integer> bb=new CC(22);
        CC<Integer> cc=new CC2<Integer>(11);
        CC2<Integer> cc2=(CC2)cc;
        CC3<CC> cc3=new CC3(cc2);
        CC3<CC> cc4=new CC3(cc2);

        Xumouren cc5=new Xumouren("xupan","xumouren");
        //cc4.show(new Xumouren<Integer>());
        cc4.show(cc2);
        cc4.show(cc5);
        //CC3<CC<Integer>> cc3=new CC3(22);

        System.out.println(aa.a);
        System.out.println(bb.a);
        System.out.println(cc2.a);
        System.out.println(cc.a);
        System.out.println(cc3.a.a);
        //System.out.println(cc3.a.a.a);
    }
}

class CC<E>{
    E a;
    public CC(){

    }
    public CC(E b){
        a=b;
    }
}

class CC2<e> extends CC<e>{
    //e a;
    public CC2(e b){
        super(b);
        a=b;
    }
}

class CC3<e extends CC>{
    e a;
    public CC3(e b){
        a=b;
    }
    <some extends CC> void show(some some1){
        System.out.println(some1.getClass().getName()+"\n"+some1.a.getClass().getName());
        //if(some1.a.getClass().getName().equals("Integer"))
           // System.out.println("真好");
    }
    <some extends CC> void show1(some some1){
        System.out.println(some1.getClass().getName());
    }
}

class CC4<t> extends CC<t>{

}

class CC5<t extends CC<t>> extends CC<t>{

}
class Xumouren<e> extends CC<e>{
    e fuck;
    public Xumouren(e s,e ss){
        fuck=s;
        a=ss;
    }

}
