package Default;
//Q7
public class Publication {
    private String author;
    private String title;
    private String year;

    public Publication(String a, String t, String y){
        author=a;
        title=t;
        year=y;

    }

    public void display(){
        System.out.println("The author is"+author);
        System.out.println("The title is"+ title);
        System.out.println("The year of publication"+ year);
    }


}
