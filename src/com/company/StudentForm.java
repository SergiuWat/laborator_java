package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StudentForm extends JFrame {
    private JPanel mainPanel;
    private JLabel iconLabel;
    private JButton cursuriButton;
    private JButton calculareMedieButton;
    private JButton restanteButton;
    private JPanel cursuriPanel;
    private JPanel restantePanel;
    private JPanel calculMedie;
    private JPanel cardPanel;
    private JTextArea cursuriArea;
    private JButton noteCursuri;
    private JPanel noteCursuriPanel;
    private JTextArea noteCursuriArea;
    private JTextArea medieArea;
    private JTextArea restanteArea;
    private JTable cursuriTable;

    public StudentForm(String Title,String nume,String prenume){
       super(Title);
       this.setContentPane(mainPanel);
       this.setPreferredSize(new Dimension(500,500));
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.pack();
        cardPanel.setVisible(false);
        String name="Buna, "+nume+" "+prenume;
        iconLabel.setText(name);

       //DefaultTableModel model = (DefaultTableModel) cursuriTable.getModel();
        //model.setColumnIdentifiers(columnNames);
       // model.setRowCount(0);
      //  for(int i=0;i<data.length;i++){
         //   String row=data[i][0].toString()+","+data[i][1]+","+data[i][2];
         //   String[] rows=row.toString().split(",");
         //   model.addRow(rows);
      //  }


        //cursuriTable=new JTable(model);
       // cursuriTable.setBounds(30,40,200,300);
       // JScrollPane sp=new JScrollPane(cursuriTable);
       //this.add(sp);

        cursuriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               cursuriArea.setText("");
                cardPanel.setVisible(true);
                cardPanel.removeAll();
                cardPanel.add(cursuriPanel);
                cardPanel.repaint();
                cardPanel.revalidate();
                Student student=new Student();


                FileDataManager fileDataManager=new FileDataManager();
                List<Curs> cursuri= new ArrayList<>();
                cursuri=Arrays.asList(fileDataManager.dataSetOfCurs);
                String line=new String();
                try(BufferedReader br=new BufferedReader(new FileReader("studenti.csv"))){
                    while ((line=br.readLine())!=null){
                        String[] row=line.split(",");
                        if((nume.equals(row[0]))&&(prenume.equals(row[1]))){
                            student=new Student(nume,prenume,Integer.parseInt(row[2]));
                        }
                    }
                }catch (Exception ex){
                    ex.getMessage();
                }
                // Object[][] data=new String[cursuri.size()][3];
                String[][] text=new String[cursuri.size()][3];
                for(int i=0;i<cursuri.size();i++){
                    if(cursuri.get(i).studenti.contains(student)){
                        text[i][0]=cursuri.get(i).getNume();
                        text[i][1]=cursuri.get(i).descriere;
                        String st=new String();
                        st=cursuri.get(i).profu.nume+" "+cursuri.get(i).profu.prenume;
                        text[i][2]=st;
                    }

                }

                for(int i=0;i<cursuri.size();i++){
                    if(cursuri.get(i).studenti.contains(student)) {
                        String str = "Nume curs " + text[i][0] + " \nDescriere " + text[i][1] + " \nProfesor: " + text[i][2] + "\n";
                        cursuriArea.append(str);
                    }
                }
            }
        });
        noteCursuri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noteCursuriArea.setText("");
                cardPanel.setVisible(true);
                cardPanel.removeAll();
                cardPanel.add(noteCursuriPanel);
                cardPanel.repaint();
                cardPanel.revalidate();
                String line=new String();
                try(BufferedReader br=new BufferedReader(new FileReader("note.csv"))){
                    while ((line=br.readLine())!=null){
                        String[] row=line.split(",");
                        if((nume.equals(row[0]))&&(prenume.equals(row[1]))){

                            String str="Nume curs: "+row[2]+" Nota: "+row[3]+"\n";
                            noteCursuriArea.append(str);
                        }
                    }
                }catch (Exception ex){
                    ex.getMessage();
                }

            }
        });
        calculareMedieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medieArea.setText("");
                cardPanel.setVisible(true);
                cardPanel.removeAll();
                cardPanel.add(calculMedie);
                cardPanel.repaint();
                cardPanel.revalidate();
                String line=new String();
                int note=0;
                int sumNote=0;
                Double medie=0.0;
                try(BufferedReader br=new BufferedReader(new FileReader("note.csv"))){
                    while ((line=br.readLine())!=null){
                        String[] row=line.split(",");
                        if((nume.equals(row[0]))&&(prenume.equals(row[1]))){
                            note++;
                            sumNote+=Integer.parseInt(row[3]);

                        }
                    }
                }catch (Exception ex){
                    ex.getMessage();
                }
                medie=(double)sumNote/(double)note;
                medieArea.append("Media: "+medie.toString());
            }
        });
        restanteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              restanteArea.setText("");
                cardPanel.setVisible(true);
                cardPanel.removeAll();
                cardPanel.add(restantePanel);
                cardPanel.repaint();
                cardPanel.revalidate();
                String line=new String();
                try(BufferedReader br=new BufferedReader(new FileReader("note.csv"))){
                    while ((line=br.readLine())!=null){
                        String[] row=line.split(",");
                        if((nume.equals(row[0]))&&(prenume.equals(row[1]))&&(Integer.parseInt(row[3])<5)){

                            String str="Nume curs: "+row[2]+" Nota: "+row[3]+"\n";
                            restanteArea.append(str);
                        }
                    }
                }catch (Exception ex){
                    ex.getMessage();
                }

            }
        });
    }

    private void createUIComponents() {
        iconLabel =new JLabel();
        ImageIcon logoIcon=new ImageIcon(new ImageIcon("C:\\Users\\rome_\\OneDrive\\Desktop\\monster1.png").getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH));
        this.iconLabel.setIcon(logoIcon);
    }
}
