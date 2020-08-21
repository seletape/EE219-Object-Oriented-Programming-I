package Q1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.NumberFormatException;
//Q2
class PrimeFactorApp implements ActionListener{

    private JFrame frame;
    private JLabel label1;
    private JLabel label2;
    private JTextField textfield;
    private JButton button1;

    public PrimeFactorApp()
    {
        frame = new JFrame("Factoring App");

        label1 = new JLabel("Enter a number to factorize");
        frame.add(label1);

        textfield =  new JTextField("",40);
        frame.add(textfield);

        label2 = new JLabel(" ");
        frame.add(label2);

        button1 = new JButton("Find Prime Factorization");
        frame.add(button1);
        button1.addActionListener(this);

        frame.setSize(400,300);
        frame.setLayout(new GridLayout(5,1));
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(5,20,20,20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static boolean exception(String t)
    {
        boolean a = false;
        try {
            Long.parseLong(t);
            a = true;
        }
        catch(NumberFormatException et)
        {

        }

        return a;
    }


    public void actionPerformed(ActionEvent e) {

        boolean exep = exception(textfield.getText());

        if(exep && Long.parseLong(textfield.getText())>999999999999L)
        {
            label2.setText("Input number can be no longer than "+ 999999999999L );
        }

        else if(exep && Long.parseLong(textfield.getText())>0)
        {
            long num = Long.parseLong(textfield.getText());
            prime(num);
        }
        else
        {
            label2.setText("Input is invalid! ");
        }

    }

    public void prime(long number) {
        long input = Long.parseLong(textfield.getText());
        number = Long.parseLong(textfield.getText());
        String output="";
        while(number%2==0){
            number/=2;
        }
        for(int i = 3; i<=Math.sqrt(number); i++) {
            while(number%i == 0) {
                number = number/i;
                output+= (i+"x");

            }

        }
        label2.setText("The prime factorization of "+input+ " is "+output+number);
    }

    public static void main(String args[])
    {
        new PrimeFactorApp();
    }
}
