package com.company;
import java.util.*;

public class DataManager implements IDataLoader {
    public ManagerCursuri manager = new ManagerCursuri();
    // Obiectul rand genereaza numere aleatorii. Folosit in programul de testare
    public Random rand = new Random();
    public int minimumRequiredStudents = 5;
    public Student[] dataSetOfStudent = createStudentsData();
    public Profesor[] dataSetOfProfesor = createProfesorData();

    public DataManager() {
        this.createCoursesData();
    }


    @Override
    public Student[] createStudentsData() {
        String nume[] = { "Jarcau", "Oprea", "Solomon", "Patrascu", "Damian", "Cristea", "Visoiu", "Andrei", "Petreanu", "Dragomir", "Gavrila",	"Suciu", "Rotaru", "Grigorescu", "Dudulescu", "Stanculescu"
                , "Vajaiac", "Istudor",	"Bruma", "Neagu", "Popa", "Gribincea", "Cucu", "Milea",	"Coca",	"Iorga", "Budau", "Maracineanu", "Pascociu", "Ionita",	"Paltanea"
                , "Spunei", "Stoian", "Raulea",	"Trifan", "Visan", "Rusu", "Silitra", "Puia" };
        String prenume[] = { "Stefan", "Ionut", "Andrei" ,"Nicolae","Maria","Florinela","Andrei","Mihai","Marius","Sergiu","Iulian","Mihai","Daria","Stefan","Stefan","Daniel","Marius"
                ,"Cristian","Daniel","Elena","Ana-Maria","Valentina","Ioana","Daniel","Paul","Bianca","David","Constantin","Andreea","Cezar","Auras","Razvan","Emanuel","Andrei","Ioan","Marian","Victor","Florin","Madalina"};


        Student studenti[] = new Student[nume.length];
        for (int i = 0; i < nume.length;i++) {
            Student s = new Student(nume[i], prenume[i], 1 + rand.nextInt(4));
            studenti[i] = s;
        }

        return studenti;
    }


    @Override
    public Profesor[] createProfesorData() {
        String nume[] = { "URSUTIU", "PANA", "ALEXANDRU","CRETU ", "KRISTALY", "DANILA", "DEMETER",	"DIACONU", "ILEA", "POP", "BOER" };
        String prenume[] = {"DORU","GHEORGHE", "MARIAN","NICOLAE CONSTANTIN", "DOMINIC", "ADRIAN", "ROBERT", "LAURENTIU", "GELU","MIHAIL", "ATTILA"};
        Profesor profesori[] = new Profesor[nume.length];

        for (int i = 0; i < nume.length;i++) {
            profesori[i] = new Profesor(nume[i], prenume[i]);
        }
        Arrays.sort(profesori);
        return profesori;
    }

    public Set<Student> createRandomSetOfStudents() {
        int studentInscrisiLaCurs = minimumRequiredStudents + rand.nextInt(dataSetOfStudent.length - minimumRequiredStudents);
        Set<Student> setOfStudents = new HashSet<Student>();
        for (int i = 0; i < studentInscrisiLaCurs; i++) {
            int randomStudentIndex = rand.nextInt(dataSetOfStudent.length);
            setOfStudents.add(dataSetOfStudent[randomStudentIndex]);
        }
        return setOfStudents;
    }


    @Override
    public Curs[] createCoursesData() {
        String curs[] = { "Teoria sistemelor", "Masurari electronice", "Dispozitive electronice", "Structuri de date", "Procesarea semnalelor", "Limba engleza", "Limbaje formale", "PCLP 1", "PCLP 2" };
        String descriere = "descriere curs";
        Arrays.sort(curs);
        ArrayList<Curs> cursuri = new ArrayList<>();
        for (String numeCurs : curs) {
            Set<Student> studentsData = createRandomSetOfStudents();
            Profesor profesor = dataSetOfProfesor[rand.nextInt(dataSetOfProfesor.length)];
            Curs c = new Curs(numeCurs, descriere, profesor, studentsData);
            cursuri.add(c);
        }
        return cursuri.toArray(new Curs[cursuri.size()]);
    }

    public void gradeStudents() {
        for (Curs c: manager.cursuri) {
            for( Student s: c.studenti) {
                try {
                    c.noteazaStudent(s, 1 + rand.nextInt(10));
                } catch (Exception e) {

                }
            }
        }
    }
    public void GrupeStudenti(){
        Arrays.sort(dataSetOfStudent);
        for(Student s:dataSetOfStudent){
            System.out.println(s);
        }
    }
    public void AfiseazaCursuriSortate(){

        System.out.println("Dupa numele Cursului");
        for(Curs c:manager.cursuri){
            System.out.println(c.getNume()+": "+c.profu+ " Numar studenti: "+c.studenti.size());
        }

    }

    public void SortByNumberStudents(){
        Collections.sort(manager.getCursuri(),new SortByNumberOfStudents());
        System.out.println("Dupa numarul de studenti");
        for(Curs c:manager.cursuri){
            System.out.println(c.nume +"Studenti inscrisi la curs: "+c.studenti.size());
        }
    }

    public void SortByProfName(){
        Collections.sort(manager.getCursuri(),new Sortbyprof());
        System.out.println("Dupa numele profesorului");
        for(Curs c:manager.cursuri){
            System.out.println(c.nume +"nume profesor: "+c.profu.formatForDisplay());
        }
    }



}