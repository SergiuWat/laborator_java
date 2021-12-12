package com.company;
import java.util.Comparator;

public class Sortbygrupa implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b)
    {

        return a.grupa - b.grupa;
    }
}
