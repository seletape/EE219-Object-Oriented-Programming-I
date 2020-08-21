package Default;
//Q5+6
public class Rectangle {
    private  double width;
    private double length;

    public Rectangle(double w, double l){
        width=w;
        length=l;
    }
    public Rectangle(double x1, double y1, double x2, double y2){
    length= x2 - x1;
    width = y2 - y1;


    }
    public double perimeter(){
         double perimeter=(2*width)+(2*length);
         return perimeter;
    }

    public void printInfo(){
        System.out.println("This is the length"+length);
        System.out.println("This is the width "+ width);
        System.out.println(perimeter());
    }
    public static void main(String args[]) {
        System.out.println("Hello World!");
        Rectangle R1=new Rectangle(4,3);
        R1.printInfo();

        Rectangle R2= new Rectangle(1,1,2,2);
        R2.printInfo();



    }

    }
