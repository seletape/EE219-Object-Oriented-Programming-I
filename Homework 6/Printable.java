package Printable;

public interface Printable {
    void print();
}


class Square implements Printable {
    private double x;
    private double y;

    public Square(double _x,double _y) {
        x=_x;
        y=_y;
    }

    @Override
    public void print(){


        System.out.println("The perimeter is " + (2*x+2*y) );

    }
}

class Triangle implements Printable {
    private double height;
    private double base;


    public Triangle(double b, double h) {
        base = b;
        height = h;

    }

    @Override
    public void print() {


        System.out.println("The area of the triangle is " + (0.5 * base * height));

    }



}
class TestPrintable {

    public static void main(String[] args) {
        Printable[] printables = {new Square(2,4), new Triangle(9,4), new Square(10,2), new Triangle(5,4), new Square(2,4)};
        for (int i = 0; i < printables.length; i++) {
            printables[i].print();
        }
    }
}


