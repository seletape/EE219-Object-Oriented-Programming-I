package Q1;

import javafx.scene.control.Labeled;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

//q1

public class SimpText implements ActionListener {

    private JTextField textfield;

    private JLabel result;

    private JLabel label;



    public SimpText() {

        JFrame frame = new JFrame("Simple Text App");

        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        frame.setResizable(false);

        textfield = new JTextField("Here is some TEST text with MIXED case");

        frame.add(textfield);
        result= new JLabel(textfield.getText());
        JButton button1 = new JButton("upper case");

        JButton button2 = new JButton("lower case");

        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        frame.add(button1);

        frame.add(button2);

        button1.addActionListener(this);

        button2.addActionListener(this);

        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }


    public void actionPerformed(ActionEvent event) {

        if (event.getActionCommand().equals("upper case")) {

            String s = textfield.getText().toUpperCase();
            //char ch = s.charAt(0);
            //Character.isUpperCase(ch);
            textfield.setText(s);

           // s = s.toUpperCase();

           result.setText(s);
        } else if (event.getActionCommand().equals("lower case")) {

            String s = textfield.getText().toLowerCase();
            textfield.setText(s);
           // s = s.toLowerCase();

            //label.setText(s);
        }

    }

    public static void main(String args[]) {


          new SimpText();

    }
}
