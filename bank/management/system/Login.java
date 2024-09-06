package bank.management.system;

import javax.swing.*;  //Swing comes from the extended version of Java, hence we use impot javax and not import java
import java.awt.*;
import java.awt.event.*; //ActionListener is in awt.event package
import java.sql.*;

public class Login extends JFrame implements ActionListener{//We can built different frames on application using JFrame
                                //We can make our button functionable by implementing ActionListener

    JLabel l1,l2,l3;   // We declare the buttons as global variable so we can access and give functionality to them individualy
    JTextField tf1;    // We also need to access these text fields to edit and save them
    JPasswordField pf2;  // We need to hide the PIN
    JButton b1,b2,b3;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE"); // This will give title for our frame
        setLayout(null); // this will stop swing from using its default layout for labeles and we can customize our labels location and siz
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        //We can't directly use this image on our frame, for that we need to use JLabel
        //JLabel label = new JLabel(i1);
        //add(label); //we add the object of JLabel class
        //Now we customize the dimensions of the icon using Image object
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);  // Image class is imported from awt package
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(70, 10, 100, 100);//Now we give the location where we want our label to show in the frame
        //And give the dimensions of the label itself as 100 and 100
        add(l11); //Since we can't add Image object in JLabel class we store Image object in ImageIcon obejct and then store it in JLabel object


        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200,40,450,40);
        add(l1);

        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125,150,375,30);
        add(l2);

        //JTextField cardTextField = new JTextField();  // This is to add the box where the user will give his card number
        //   Now we can access them globally
        tf1 = new JTextField(15);
        tf1.setBounds(300,150,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);

        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,220,375,30);
        add(l3);

        //JTextField pinTextField = new JTextField();  // This is to add the box where the user will give his PIN number
        // Now we can access them globally
        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,220,230,30);
        add(pf2);

        //JButton login = new JButton("SIGN IN");    //This is to make locally scoped SIGN IN button
        //Now we can access the Button in other methods
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);// This is to add functionality to the sign in button

        //JButton clear = new JButton("CLEAR");     // This is to make CLEAR Button
        b2 = new JButton("CLEAR");                  //Now we can access the Button in other methods
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);    // This is to add functionality to the clear button

        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);

        setLayout(null);

        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,300,100,30);
        add(b1);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,300,100,30);
        add(b2);

        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300,350,230,30);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);  // To change the colour of frame to WHITE

        setSize(800,480);   //sets the length and breadth of the frame in pixels
        setLocation(550,200);  // Now the user can see the frame
        setVisible(true);  // now the frame will open 350 pixels to the right and 200 pixels downwards instead of on the eft corner

    }
    public void actionPerformed(ActionEvent ae){   // We have to override the implemented interface's methods
        try{
            if(ae.getSource()==b1){
                Conn c1 = new Conn();
                String cardno  = tf1.getText();
                String pin  = pf2.getText();
                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource()==b3){
                setVisible(false);
                new SignupOne().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Login().setVisible(true);  // We want our frame to run as soon as the program is running hence we call constructor of the public class
    }
    }




