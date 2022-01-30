package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;

import com.opencsv.CSVWriter;

public class RegisterForm extends JFrame {
    private JPanel mainPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JLabel logoIcon;
    private JRadioButton profesorRadioButton;
    private JRadioButton studentRadioButton;
    private JTextField grupaField;

    RegisterForm (String title){
        super(title);
        this.setContentPane(mainPanel);
        this.setPreferredSize(new Dimension(500,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();


        usernameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                usernameField.setText("");
                String str=passwordField.getText();
                String str2=grupaField.getText();
                if((str.equals(""))||(str2.equals(""))){
                    passwordField.setEchoChar((char)0);
                    passwordField.setText("Password");
                    grupaField.setText("Grupa");
                }
            }
        });
        passwordField.setEchoChar((char)0);

        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                passwordField.setEchoChar('*');
                passwordField.setText("");
                String str=usernameField.getText();
                String str2=grupaField.getText();
                if((str.equals(""))||(str2.equals(""))){
                    usernameField.setText("Username");
                    grupaField.setText("Grupa");
                }
            }
        });
        //REGISTER
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(profesorRadioButton.isSelected()){
                    try{
                        Application.getInstance().Register(new User(usernameField.getText(),new String(passwordField.getPassword())));
                        FileWriter outputfile=new FileWriter("profesor.csv",true);
                        CSVWriter write=new CSVWriter(outputfile);
                       String[] data={usernameField.getText(),new String(passwordField.getPassword())};

                        write.writeNext(data);
                        write.close();
                        JOptionPane.showMessageDialog(null,"Register successfully");
                        JFrame login=new LoginForm("Login");
                        dispose();

                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }


                }else if(studentRadioButton.isSelected()){
                    try{
                        Application.getInstance().Register(new User(usernameField.getText(),new String(passwordField.getPassword())));
                        FileWriter outputfile=new FileWriter("studenti.csv",true);
                        CSVWriter write=new CSVWriter(outputfile);
                        Integer grup=Integer.parseInt(grupaField.getText());
                        String[] data={usernameField.getText(),new String(passwordField.getPassword()),grup.toString()};


                        write.writeNext(data);
                        write.close();
                        JOptionPane.showMessageDialog(null,"Register successfully");
                        JFrame login=new LoginForm("Login");
                        dispose();

                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }


                }else{
                    JOptionPane.showMessageDialog(null,"Te rog sa selectezi daca esti profesor sau student");

                }


            }
        });
        //RADIO BUTTONS
        studentRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grupaField.setVisible(true);
            }
        });
        profesorRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grupaField.setVisible(false);
            }
        });
        grupaField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                grupaField.setText("");
                String str=passwordField.getText();
                String str2=usernameField.getText();
                if((str.equals(""))||(str2.equals(""))){
                    passwordField.setEchoChar((char)0);
                    passwordField.setText("Password");
                    usernameField.setText("Username");
                }
            }
        });
    }

    private void createUIComponents() {
        logoIcon =new JLabel();
        ImageIcon logoIcon=new ImageIcon(new ImageIcon("C:\\Users\\rome_\\OneDrive\\Desktop\\logo2.png").getImage().getScaledInstance(300,150, Image.SCALE_SMOOTH));
        this.logoIcon.setIcon(logoIcon);
    }
}
