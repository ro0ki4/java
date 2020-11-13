import java.util.Scanner;
public class RPG_game {
    public static void main(){
        Human_1 first=new Human_1();
        System.out.println("输入你的名字");
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        System.out.println("输入你的性别");
        String sex=sc.nextLine();
        System.out.println("选择你的游戏角色的种族，分别有人类，精灵,兽人，矮人，元素");
        String racial=sc.nextLine();
        boolean one=true;
        while(one){
            one=select(racial,sex,first);
        }
    }
    private static boolean select(String racial,String sex,Human_1 first){
        System.out.println("输入你想选择的职业,职业有\n狂战士  圣骑士   刺客   猎手   祭司   巫师\n");
        Scanner scanner=new Scanner(System.in);
        String zhiye=scanner.nextLine();
        Human_1 work=new Human_1();
        work.setsex(sex);
        if ("人类".equals(racial)) {
            work.setracial(zhiye);
            //输入人类可以选择的职业
        } else if ("精灵".equals(racial)) {
            if(!zhiye.equals("狂战士")||!zhiye.equals("圣骑士"))
                work.setracial(zhiye);
            else {
                System.out.println("你不可以选择该种职业，请重新选择");

            }
        } else if ("兽人".equals(racial)) {
            if(!zhiye.equals("圣骑士")||!zhiye.equals("刺客")||!zhiye.equals("巫师")){
                work.setracial(zhiye);
            }
            else {
                System.out.println("你不可以选择该种职业，请重新选择");

            }

        } else if ("矮人".equals(racial)) {
            if(!zhiye.equals("刺客")||!zhiye.equals("猎手")||!zhiye.equals("巫师")){
                work.setracial(zhiye);
            }
            else {
                System.out.println("你不可以选择该种职业，请重新选择");

            }

        } else if ("元素".equals(racial)) {
            if(zhiye.equals("祭司")||zhiye.equals("巫师")){
                work.setracial(zhiye);
            }
            else{
                System.out.println("你不可以选择该种职业，请重新选择");

            }
        }
        return work;
    }
}
class Human_1{
    String name;
    static String sex;
    String racial;
    String job;
    int strength;
    int spide;
    int power;//体力
    int wise;
    int blood_number;
    int magic;
    public Human_1(){

    }
    void setsex(String sex){
        this.sex=sex;

    }
    void setracial(String racial){
        this.racial=racial;
    }
    void show_data(){
        System.out.println("力量：   "+strength+"\n");
        System.out.println("速度：   "+spide+"\n");
        System.out.println("体力：   "+power+"\n");
        System.out.println("智慧：   "+wise+"\n");
        System.out.println("血量：   "+blood_number+"\n");
        System.out.println("蓝量：   "+magic+"\n");
    }
}
