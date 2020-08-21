package Basic;

public class CharCount {
    static int charCount(String s, char c)
    {
        int count = 0;

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == c)
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[])
    {
        String s = "aaaaaaaaa";
        char c = 'a';
        System.out.println(charCount(s, c));


    }
}
