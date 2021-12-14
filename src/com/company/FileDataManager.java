package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.Random;

public class FileDataManager implements IDataLoader {

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
    }

    @Override
    public Profesor[] createProfesorData() {
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

    }

    @Override
    public Curs[] createCoursesData() {
        
        return new Curs[0];
    }
}
