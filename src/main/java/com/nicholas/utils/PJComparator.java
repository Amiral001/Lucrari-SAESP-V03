package com.nicholas.utils;

import com.nicholas.entitys.PersoanaFizica;
import com.nicholas.entitys.PersoanaJuridica;

import java.util.Comparator;

public class PJComparator implements Comparator<PersoanaJuridica> {

    @Override
    public int compare(PersoanaJuridica pj1, PersoanaJuridica pj2) {

        return pj1.getDenumire().compareTo(pj2.getDenumire());
    }
}
