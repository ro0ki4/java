public class First {
    public static void main(String[] args){
        Student student1=new Student("xumouren",20);
        student1.show();
        Undergraduate undergraduate1=new Undergraduate("xumourendezai",19,"doctor");
        undergraduate1.show();
    }
}

class Student{
    String name;
    int age;
    public Student(){

    }
    public Student(String name, int age){
        this.name=name;
        this.age=age;
    }
    public void show(){
        System.out.println("name:"+name+"\n"+"age:"+age+"\n");
    }
}


class Undergraduate extends Student{
    String degree;
    public Undergraduate(){
        super();
    }
    public Undergraduate(String name,int age,String degree){
        super(name,age);
        this.degree=degree;
    }
    public void show(){
        System.out.println("name:"+name+"\n"+"age:"+age+"\n"+"degree:"+degree);
    }

}