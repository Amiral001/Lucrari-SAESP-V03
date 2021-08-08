package com.nicholas.utils;

import com.nicholas.entitys.Lucrare;
import com.nicholas.entitys.PersoanaFizica;

import java.util.Comparator;

public class LucrariComparator implements Comparator<Lucrare> {

    @Override
    public int compare(Lucrare l1, Lucrare l2) {
        return l1.getNrLucrare().compareTo(l2.getNrLucrare());
    }
}
