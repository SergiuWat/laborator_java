package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.desktop.AppForegroundListener;
import java.awt.event.*;

public class LoginForm extends JFrame {
    private JPanel mainPanel;
    private JLabel logoLabel;
    private JPanel topPanel_login;
    private JPanel bottomPanel_login;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton logInButton;
    private JButton registerButton;
    private JRadioButton profesorButton;
    private JRadioButton studentButton;

    public LoginForm(String Title){
        super(Title);
        this.setContentPane(mainPanel);
        this.setPreferredSize(new Dimension(500,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        //USERNAME FIELD
        usernameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                usernameField.setText("");
                String str=passwordField.getText();
                if(str.equals("")){
                    passwordField.setEchoChar((char)0);
                    passwordField.setText("Password");
                }
            }
        });

        //PASSWORD FIELD
        passwordField.setEchoChar((char)0);

        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                passwordField.setEchoChar('*');
                passwordField.setText("");
                String str=usernameField.getText();
                if(str.equals("")){
                    usernameField.setText("Username");
                }
            }
        });

        //LOG IN BUTTON
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(studentButton.isSelected()){
                    try{

                        Application.getInstance().login(new User(usernameField.getText(),new String(passwordField.getPassword())));
                        JOptionPane.showMessageDialog(null,"Login successfully");
                        //LoginForm.super.setContentPane(new TecherForm());
                        JFrame Student=new StudentForm("Student",usernameField.getText(),new String(passwordField.getPassword()));
                        dispose();

                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }else if(profesorButton.isSelected()){
                    try{

                        Application.getInstance().login(new User(usernameField.getText(),new String(passwordField.getPassword())));
                        JOptionPane.showMessageDialog(null,"Login successfully");
                        //LoginForm.super.setContentPane(new TecherForm());
                        JFrame teacher=new TeacherForm("Teacher",usernameField.getText(),new String(passwordField.getPassword()));
                        dispose();

                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }else{

                }

            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame Register=new RegisterForm("Register");
                dispose();

            }
        });
    }

    private void createUIComponents() {
        logoLabel=new JLabel();
        ImageIcon logoIcon=new ImageIcon(new ImageIcon("C:\\Users\\rome_\\OneDrive\\Desktop\\logo2.png").getImage().getScaledInstance(300,150, Image.SCALE_SMOOTH));

        logoLabel.setIcon(logoIcon);

    }
}
