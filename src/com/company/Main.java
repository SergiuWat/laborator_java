package com.company;
<<<<<<< HEAD
import javax.swing.*;
=======
>>>>>>> main
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
enum LOAD_TYPE{
    HARDCODAT,KEYBOARD,FILE
}

enum DISPLAY_TYPE{
    CONSOLA,FISIER,GUI
}

public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD
        //IDisplayManager displayManager = Settings.displayHashMap.get(Settings.displayType);
       // IDataLoader dataManager = Settings.dataLoaderHashMap.get(Settings.loadType);
       // displayManager.displayStudents(dataManager.createStudentsData());

        /*FileDataManager fileDataManager=new FileDataManager();
        for(int i=0;i<fileDataManager.createStudentsData().length;i++){
            System.out.println(fileDataManager.createStudentsData()[i]);
        }

         */

        JFrame frame=new LoginForm("Login");
=======
        IDisplayManager displayManager = Settings.displayHashMap.get(Settings.displayType);
        IDataLoader dataManager = Settings.dataLoaderHashMap.get(Settings.loadType);
        displayManager.displayStudents(dataManager.createStudentsData());

        FileDataManager fileDataManager=new FileDataManager();
        for(int i=0;i<fileDataManager.createStudentsData().length;i++){
            System.out.println(fileDataManager.createStudentsData()[i]);
        }
>>>>>>> main

    }

}
