package com.company;

import com.opencsv.CSVReader;
import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Application {
    private static Application single_instance = null;
    private List<User> userList = new ArrayList<>();
    private List<Curs> cursList=new ArrayList<>();

    public User currentUser = null;

    static Application getInstance() {
        if ( single_instance == null) {
            single_instance = new Application();
        }
        return  single_instance;
    }

    private Application() {
         /* HardcodatDataManager dataManager = new HardcodatDataManager();
        Random r = new Random();
        var studenti = dataManager.dataSetOfStudent;
        var profesori = dataManager.dataSetOfProfesor;
        this.userList.add(new User("aaa", "aaa", new StudentStrategy( studenti[r.nextInt(studenti.length)])));
        this.userList.add(new User("bbb", "aaa", new TeacherStrategy( profesori[r.nextInt(profesori.length)])));
        this.userList.add(new User("ccc", "ccc", new StudentStrategy( studenti[r.nextInt(studenti.length)])));
        this.userList.add(new User("ddd", "ddd", new TeacherStrategy( profesori[r.nextInt(profesori.length)])));
        this.userList.add(new User("eee", "eee", new StudentStrategy( studenti[r.nextInt(studenti.length)])));
        try {
            FileOutputStream fos = new FileOutputStream("users.xml");
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.setExceptionListener(new ExceptionListener() {
                @Override
                public void exceptionThrown(Exception e) {
                    System.out.println("Exception:" + e.toString());
                }
            });
            encoder.writeObject(userList);
            encoder.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } */
        this.initUsers();
        this.initCursuri();
    }

    private void initCursuri(){
        FileDataManager fdm=new FileDataManager();
        cursList= Arrays.asList(fdm.dataSetOfCurs);
    }
   public void Register(User user) throws  Exception{

       int index = userList.indexOf(user);
       if ( index != -1 ) {
           Application.getInstance().currentUser = userList.get(index);
       } else {
           throw new Exception("Utilizatorul nu exista in sistem!");
       }
   }

    private void initUsers() {
        String line=new String();
        int i=0;
        try(BufferedReader br=new BufferedReader(new FileReader("users.csv"))){
            while((line=br.readLine())!=null){
                String[] row=line.split(",");
                User us=new User(row[0],row[1]);
                userList.add(us);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void login(User user) throws Exception {

        int index = userList.indexOf(user);
        if ( index != -1 ) {
            Application.getInstance().currentUser = userList.get(index);
        } else {
            throw new Exception("Username sau parola este gresita!");
        }
    }
}

