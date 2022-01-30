package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentForm extends JFrame {
    private JPanel mainPanel;
    private JLabel iconLabel;
    private JTable cursuriTable;

    public StudentForm(String Title,String nume,String prenume){
       super(Title);
       this.setContentPane(mainPanel);
       this.setPreferredSize(new Dimension(500,500));
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.pack();

        String[] columnNames={"Nume,Descriere,Profesor"};
        FileDataManager fileDataManager=new FileDataManager();
        List<Curs> cursuri= new ArrayList<>();
        cursuri=Arrays.asList(fileDataManager.dataSetOfCurs);
        Object[][] data=new String[cursuri.size()][3];

        for(int i=0;i<cursuri.size();i++){
            data[i][0]=cursuri.get(i).getNume();
            data[i][1]=cursuri.get(i).descriere;
            String st=new String();
            st=cursuri.get(i).profu.nume+" "+cursuri.get(i).profu.prenume;
            data[i][2]=st;
        }
        DefaultTableModel model = (DefaultTableModel) cursuriTable.getModel();
        model.setColumnIdentifiers(columnNames);
        model.setRowCount(0);
        for(int i=0;i<data.length;i++){
            String row=data[i][0].toString()+","+data[i][1]+","+data[i][2];
            String[] rows=row.toString().split(",");
            model.addRow(rows);
        }


        cursuriTable=new JTable(model);
        cursuriTable.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(cursuriTable);
        this.add(sp);

    }

    private void createUIComponents() {
        iconLabel =new JLabel();
        ImageIcon logoIcon=new ImageIcon(new ImageIcon("C:\\Users\\rome_\\OneDrive\\Desktop\\monster1.png").getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH));
        this.iconLabel.setIcon(logoIcon);
    }
}
