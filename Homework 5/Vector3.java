package Default;

public class Vector3 {
    private double x;
    private double y;
    private double z;

    public Vector3(double _x,double _y, double _z ){
    x=_x;
    y=_y;
    z=_z;
        
    }

    public Vector3  crossProduct(Vector3 vec) {
        double I= (y*vec.z) - (z*vec.y);
        double J= (z*vec.x) - (x*vec.z);
        double K= (x*vec.y) - (y*vec.x);

        return new Vector3(I,J,K);

    }

    public static void main(String args[]) {
        Vector3 v1= new Vector3(5,5,5);
        Vector3 v2 = new Vector3(3,2,1);
        v1.crossProduct(v2);
        if ( v1.crossProduct(v2).x> 0){
            System.out.println("+");
        } else if( v1.crossProduct(v2).x< 0){
            System.out.println("-");
        } else {
            System.out.println("Given vector is neither positive nor negative integer");
        }
        if ( v1.crossProduct(v2).y> 0){
            System.out.println("+");
        } else if( v1.crossProduct(v2).y< 0){
            System.out.println("-");
        } else {
            System.out.println("Given vector is neither positive nor negative integer");
        }
        if ( v1.crossProduct(v2).z> 0){
            System.out.println("+");
        } else if( v1.crossProduct(v2).z< 0){
            System.out.println("-");
        } else {
            System.out.println("Given vector is neither positive nor negative integer");
        }
        System.out.print(v1.crossProduct(v2).x +"i");
        if ( v1.crossProduct(v2).x> 0){
            System.out.print("+");}
        if ( v1.crossProduct(v2).y> 0){
            System.out.print("+");}
        if ( v1.crossProduct(v2).z> 0){
            System.out.print("+");}
        System.out.print(v1.crossProduct(v2).y+"j");

        System.out.print(v1.crossProduct(v2).z+"k");


    }

}
