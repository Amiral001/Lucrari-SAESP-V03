package com.nicholas.utils;

import com.nicholas.entitys.PersoanaFizica;

import java.util.Comparator;

public class PFComparator implements Comparator<PersoanaFizica> {

    @Override
    public int compare(PersoanaFizica pf1, PersoanaFizica pf2) {

        return pf1.getNume().compareTo(pf2.getNume());
    }
}
