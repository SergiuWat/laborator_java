package com.company;
import java.lang.*;

import java.util.Comparator;

public class Sortbyname implements Comparator<Curs>  {
    @Override
    public int compare(Curs  a, Curs b)
    {

        return a.getNume().compareTo(b.getNume());
    }
}
