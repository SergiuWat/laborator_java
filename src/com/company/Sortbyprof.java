package com.company;
import java.util.Comparator;

public class Sortbyprof implements Comparator<Curs> {
    @Override
    public int compare(Curs  a, Curs b)
    {
        String nume_prof_a=a.profu.nume+" "+a.profu.prenume;
        String nume_prof_b=b.profu.nume+" "+b.profu.prenume;
        return nume_prof_a.compareTo(nume_prof_b);
    }
}
