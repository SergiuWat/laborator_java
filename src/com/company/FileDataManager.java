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
    public Curs[] dataSetOfCurs=createCoursesData();

    @Override
    public Student[] createStudentsData() {
        String line=new String();
        int i=0;
        Set<Student> students=new HashSet<Student>();
        try(BufferedReader br=new BufferedReader(new FileReader("studenti.csv"))){
            while((line=br.readLine())!=null){
                String[] row=line.split(",");
                String result = row[2].replaceAll("\"","");
                Student st=new Student(row[0],row[1],Integer.parseInt(result));
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
        try(BufferedReader br=new BufferedReader(new FileReader("profesor.csv"))){
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

        String line=new String();
        int i=0;
        List<Curs> curss=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader("cursuri.csv"))){
            while((line=br.readLine())!=null){
                String[] row=line.split(",");
                Profesor prof=new Profesor(row[2],row[3]);
                Set<Student> students=new HashSet<>();
                for(int j=4;j< row.length;j+=3){
                    Student st=new Student(row[j],row[j+1],Integer.parseInt(row[j+2]));
                    students.add(st);
                }
                Curs st=new Curs(row[0],row[1],prof,students);
                curss.add(st);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Curs[] cursuri=new Curs[curss.size()];
        for(Curs student:curss){
            cursuri[i]=student;
            i++;
        }
        return cursuri;
    }
}