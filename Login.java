package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1,b2;
    Login(){
        JLabel label1=new JLabel("Username");
        label1.setBounds(40,20,100,30);
        label1.setFont(new Font("Tahoma", Font.BOLD,16));
        label1.setForeground(Color.WHITE);
        add(label1);

        JLabel label2=new JLabel("Username");
        label2.setBounds(40,70,100,30);
        label2.setFont(new Font("Tahoma", Font.BOLD,16));
        label2.setForeground(Color.WHITE);
        add(label2);

        textField1=new JTextField();
        textField1.setBounds(150,20,150,30);
        textField1.setForeground(Color.WHITE);
        setFont(new Font("Tahoma",Font.PLAIN,15));
        textField1.setBackground(new Color(26,104,110));
        add(textField1);

        passwordField1=new JPasswordField();
        passwordField1.setBounds(150,70,150,30);
        passwordField1.setForeground(Color.WHITE);
        passwordField1.setBackground(new Color(26,104,110));
        add(passwordField1);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/Rlogo.gif"));
        Image i1=imageIcon.getImage().getScaledInstance(450,400, Image.SCALE_DEFAULT);
        JLabel label=new JLabel(imageIcon);
        label.setBounds(400,-10,450,400);
        add(label);

        b1=new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);


        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);


        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setLocation(400,100);
        setSize(900,450);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
           try{
               con c=new con();
               String user=textField1.getText();
               String pass=passwordField1.getText();

               String Q="select * from login where username='"+user+"' and password='"+pass+"'";
               ResultSet resultSet= c.statement.executeQuery(Q);
               if(resultSet.next()){
                   new Dashboard();
                   setVisible(false);
               }
               else{
                   JOptionPane.showMessageDialog(null,"invalid");
               }

           }catch(Exception E){
               E.printStackTrace();
           }
        }else{
            System.exit(102);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
