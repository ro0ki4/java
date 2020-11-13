public class FORTH {
    public static void main(String[] args){
        Pet someone;
        someone=new Worker();
        show(someone);
        someone=new Farmer();
        show(someone);
        someone=new Policy();
        show(someone);
    }
    private static void show(Pet someone){
        someone.feed();
        someone.play();
        System.out.println("\n");
    }
}
interface Pet{
    public abstract void feed();
    public abstract void play();
}
class Middle implements Pet{
    public void feed(){
        System.out.println(this.getClass().getName()+"喂宠物");
    }
    public void play(){
        System.out.println(this.getClass().getName()+"和宠物玩");
    }
}
class Farmer extends Middle{
}
class Policy extends Middle{
}
class Worker extends Middle{
}