package Basic;

public class Point2D {
//Q1
   private  double x;
   private double y;

   public Point2D(double _x, double _y) {
       x = _x;
       y = _y;
   }
        public  Point2D midPoint(Point2D p){
            return new Point2D((x + p.x)/2, (y + p.y)/2);
       }

    @Override
    public String toString() {
       System.out.print("Midpoint is ");
        return "(" + x + ", " + y + ")";
    }
//Q2

    //In Java, a static method is a method that belongs to a class rather than an instance of a class.
    // The method is accessible to every instance of a class,
    // but methods defined in an instance are only able to be accessed by that member of a class
public static Point2D furthestFromOrigin(Point2D[] points) {
    Point2D furthest = points[0];
    for (int i = 0; i < points.length; i++) {
        if (Math.pow(points[i].x, 2) + Math.pow(points[i].y, 2) > Math.pow(furthest.x, 2) + Math.pow(furthest.y, 2)) {
            furthest = points[i];
        }
    }
    return furthest;
}







    public static void main(String args[]) {

        Point2D p1 = new Point2D(1,1);
        Point2D p2 = new Point2D(6,3);
        System.out.println(p1.midPoint(p2));
       Point2D[] points=new Point2D[4];
        points[0]= new Point2D(1,1);
        points[1]= new Point2D(2,5);
        points[2]= new Point2D(3,4);
        points[3]= new Point2D(4,3);

        System.out.println(furthestFromOrigin(points));
    }
}
