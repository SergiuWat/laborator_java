package com.company;

import com.opencsv.CSVWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeacherForm extends JFrame {
    private JPanel mainPanel;
    private JLabel iconLabel;
    private JButton cursButton;
    private JButton studentiButton;
    private JButton notareButton;
    private JPanel cardPanel;
    private JButton button4;
    private JPanel cursPanel;
    private JPanel studentiPanel;
    private JPanel notarePanel;
    private JTextArea cursArea;
    private JTextArea studentiArea;
    private JTextField numeField;
    private JTextField prenumeField;
    private JTextField notaField;
    private JButton putGrade;

    TeacherForm(String Title,String nume,String prenume){
        super(Title);
        this.setContentPane(mainPanel);
        this.setPreferredSize(new Dimension(500,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        cardPanel.setVisible(false);
        String name="Buna ziua, "+nume+" "+ prenume;
        iconLabel.setText(name);
        Profesor profesor=new Profesor(nume,prenume);


        cursButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cursArea.setText("");
                cardPanel.setVisible(true);
                cardPanel.removeAll();
                cardPanel.add(cursPanel);
                cardPanel.repaint();
                cardPanel.revalidate();


                FileDataManager fileDataManager=new FileDataManager();
                List<Curs> cursuri= new ArrayList<>();
                cursuri= Arrays.asList(fileDataManager.dataSetOfCurs);
                String line=new String();
                try(BufferedReader br=new BufferedReader(new FileReader("cursuri.csv"))){
                    while ((line=br.readLine())!=null){
                        String[] row=line.split(",");
                        if((nume.equals(row[2]))&&(prenume.equals(row[3]))){
                            String str=row[0]+"\n";
                            cursArea.append(str);
                        }
                    }
                }catch (Exception ex){
                    ex.getMessage();
                }
            }
        });
        studentiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentiArea.setText("");
                cardPanel.setVisible(true);
                cardPanel.removeAll();
                cardPanel.add(studentiPanel);
                cardPanel.repaint();
                cardPanel.revalidate();


                FileDataManager fileDataManager=new FileDataManager();
                List<Curs> cursuri= new ArrayList<>();
                cursuri= Arrays.asList(fileDataManager.dataSetOfCurs);
                String line=new String();
                try(BufferedReader br=new BufferedReader(new FileReader("cursuri.csv"))){
                    while ((line=br.readLine())!=null){
                        String[] row=line.split(",");
                        if((nume.equals(row[2]))&&(prenume.equals(row[3]))){
                            for(int i=4;i< row.length;i+=3){
                                String str=row[i]+" "+row[i+1]+" Grupa: "+row[i+2]+"\n";
                                studentiArea.append(str);
                            }
                        }
                    }
                }catch (Exception ex){
                    ex.getMessage();
                }
            }
        });
        notareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardPanel.setVisible(true);
                cardPanel.removeAll();
                cardPanel.add(notarePanel);
                cardPanel.repaint();
                cardPanel.revalidate();
                numeField.setText("");
                prenumeField.setText("");
                notaField.setText("");

            }
        });
        putGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    FileWriter outputfile=new FileWriter("note.csv",true);
                    CSVWriter write=new CSVWriter(outputfile);
                    Integer nota=Integer.parseInt(notaField.getText());
                    String curs=new String();
                    String line=new String();
                    try(BufferedReader br=new BufferedReader(new FileReader("cursuri.csv"))){
                        while ((line=br.readLine())!=null){
                            String[] row=line.split(",");
                            if((nume.equals(row[2]))&&(prenume.equals(row[3]))){
                                curs=row[0];
                            }
                        }
                    }catch (Exception ex){
                        ex.getMessage();
                    }
                    String[] data={numeField.getText(),prenumeField.getText(),curs,nota.toString()};

                    write.writeNext(data);
                    write.close();


                }catch (Exception ex){

                }
                numeField.setText("");
                prenumeField.setText("");
                notaField.setText("");
            }
        });
    }
    private void createUIComponents() {
        iconLabel =new JLabel();
        ImageIcon logoIcon=new ImageIcon(new ImageIcon("C:\\Users\\rome_\\OneDrive\\Desktop\\monster2.png").getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH));
        this.iconLabel.setIcon(logoIcon);
    }
}
