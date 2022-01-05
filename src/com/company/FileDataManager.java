package com.company;
<<<<<<< HEAD
import java.beans.XMLDecoder;
import java.io.*;
=======
import java.io.BufferedReader;
import java.io.FileReader;
>>>>>>> main
import java.util.*;
import java.util.Random;

public class FileDataManager implements IDataLoader {

<<<<<<< HEAD
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
=======
    public ManagerCursuri manager = new ManagerCursuri();
    // Obiectul rand genereaza numere aleatorii. Folosit in programul de testare
    public Random rand = new Random();
    public int minimumRequiredStudents = 5;
    public Student[] dataSetOfStudent = createStudentsData();
    public Profesor[] dataSetOfProfesor = createProfesorData();

    @Override
    public Student[] createStudentsData() {
        String line=new String();
        int i=0;
        Set<Student> students=new HashSet<Student>();
        try(BufferedReader br=new BufferedReader(new FileReader(Settings.STUDENTS_PATH))){
            while((line=br.readLine())!=null){
                String[] row=line.split(",");
                Student st=new Student(row[0],row[1],Integer.parseInt(row[2]));
                students.add(st);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Student[] studenti=new Student[students.size()];
        for(Student student:students){
            studenti[i]=student;
            i++;
        }

        return studenti;
>>>>>>> main
    }

    @Override
    public Profesor[] createProfesorData() {
<<<<<<< HEAD
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
=======
        String line=new String();
        int i=0;
        Set<Profesor> profesors=new HashSet<Profesor>();
        try(BufferedReader br=new BufferedReader(new FileReader(Settings.TEACHERS_PATH))){
            while((line=br.readLine())!=null){
                String[] row=line.split(",");
                Profesor st=new Profesor(row[0],row[1]);
                profesors.add(st);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Profesor[] profesori=new Profesor[profesors.size()];
        for(Profesor student:profesors){
            profesori[i]=student;
            i++;
        }

        return profesori;
>>>>>>> main

    }

    @Override
    public Curs[] createCoursesData() {
<<<<<<< HEAD
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
=======
        
>>>>>>> main
        return new Curs[0];
    }
}
