public class First {
    public static void main(String[] args){
        Square square1=new Square();
        System.out.println(square1.area(2));
        Circle circle=new Circle();
        System.out.println(circle.area(2));

    }
}

interface Shape{
    public double area(double a);
}

class Square implements Shape{
    public double area(double a){
        return(a*a);
    }
}


class Circle implements Shape{
    public double area(double a){
        return(a*a*3.14);
    }
}