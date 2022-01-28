package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterForm extends JFrame {
    private JPanel mainPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JLabel logoIcon;
    private JRadioButton profesorRadioButton;
    private JRadioButton studentRadioButton;

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
                if(str.equals("")){
                    passwordField.setEchoChar((char)0);
                    passwordField.setText("Password");
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
                if(str.equals("")){
                    usernameField.setText("Username");
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame login=new LoginForm("Login");

                if(profesorRadioButton.isSelected()){

                }else if(studentRadioButton.isSelected()){

                }else{
                    JOptionPane.showMessageDialog(null,"Te rog sa selectezi daca esti profesor sau student");

                }
                dispose();

            }
        });
    }

    private void createUIComponents() {
        logoIcon =new JLabel();
        ImageIcon logoIcon=new ImageIcon(new ImageIcon("C:\\Users\\rome_\\OneDrive\\Desktop\\logo2.png").getImage().getScaledInstance(300,150, Image.SCALE_SMOOTH));
        this.logoIcon.setIcon(logoIcon);
    }
}
