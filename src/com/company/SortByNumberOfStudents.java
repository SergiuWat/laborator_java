package com.company;
import java.util.Comparator;

public class SortByNumberOfStudents implements Comparator<Curs> {
    @Override
    public int compare(Curs  a, Curs b)
    {

        int a1=a.studenti.size();
        int b1=b.studenti.size();
        return Integer.compare(a1,b1);
    }
}
