package com.company;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.*;
import java.util.Random;

public class FileDataManager implements IDataLoader {

   // public ManagerCursuri manager = new ManagerCursuri();
    // Obiectul rand genereaza numere aleatorii. Folosit in programul de testare
    //public Random rand = new Random();
   // public int minimumRequiredStudents = 5;
   // public Student[] dataSetOfStudent = createStudentsData();
   // public Profesor[] dataSetOfProfesor = createProfesorData();

    @Override
    public Student[] createStudentsData() {
        try(FileInputStream fis = new FileInputStream("studenti.xml")) {
            XMLDecoder decoder = new XMLDecoder(fis);
            Student[] students = (Student[]) decoder.readObject();
            decoder.close();
            fis.close();
            return students;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Student[0];
    }

    @Override
    public Profesor[] createProfesorData() {
        try(FileInputStream fis = new FileInputStream("profesori.xml")) {
            XMLDecoder decoder = new XMLDecoder(fis);
            Profesor[] students = (Profesor[])decoder.readObject();
            decoder.close();
            fis.close();
            return students;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profesor[0];

    }

    @Override
    public Curs[] createCoursesData() {
        try(FileInputStream fis = new FileInputStream("cursuri.xml")) {
            XMLDecoder decoder = new XMLDecoder(fis);
            Curs[] students = (Curs[]) decoder.readObject();
            decoder.close();
            fis.close();
            return students;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Curs[0];
    }
}
