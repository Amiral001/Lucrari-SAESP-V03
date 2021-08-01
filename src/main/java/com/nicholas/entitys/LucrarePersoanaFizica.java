package com.nicholas.entitys;

import java.time.LocalDate;

public class LucrarePersoanaFizica extends Lucrare {

    private String  letalaNeletala, lungaScurta, destinatieArma, regimCerere, armaLaDomiciliu, lucratorSAESP;

    private PersoanaFizica persoanaFizica;

    public LucrarePersoanaFizica() {
    }

    public LucrarePersoanaFizica(String nrLucrare, String tipLucrare, LocalDate dataLucrare, String letalaNeletala, String lungaScurta, String destinatieArma, String regimCerere, String domiciliulAltJudet, String resedintaAltJudet, String armaLaDomiciliu, String lucratorSAESP, PersoanaFizica persoanaFizica) {
        super(nrLucrare, tipLucrare, dataLucrare);
        this.letalaNeletala = letalaNeletala;
        this.lungaScurta = lungaScurta;
        this.destinatieArma = destinatieArma;
        this.regimCerere = regimCerere;
        this.armaLaDomiciliu = armaLaDomiciliu;
        this.lucratorSAESP = lucratorSAESP;
        this.persoanaFizica = persoanaFizica;
    }

    public PersoanaFizica getPersoanaFizica() {
        return persoanaFizica;
    }


    public void setPersoanaFizica(PersoanaFizica persoanaFizica) {
        this.persoanaFizica = persoanaFizica;
    }

    public String getLetalaNeletala() {
        return letalaNeletala;
    }

    public void setLetalaNeletala(String letalaNeletala) {
        this.letalaNeletala = letalaNeletala;
    }

    public String getLungaScurta() {
        return lungaScurta;
    }

    public void setLungaScurta(String lungaScurta) {
        this.lungaScurta = lungaScurta;
    }

    public String getDestinatieArma() {
        return destinatieArma;
    }

    public void setDestinatieArma(String destinatieArma) {
        this.destinatieArma = destinatieArma;
    }

    public String getRegimCerere() {
        return regimCerere;
    }

    public void setRegimCerere(String regimCerere) {
        this.regimCerere = regimCerere;
    }

    public String getArmaLaDomiciliu() {
        return armaLaDomiciliu;
    }

    public void setArmaLaDomiciliu(String armaLaDomiciliu) {
        this.armaLaDomiciliu = armaLaDomiciliu;
    }

    public String getLucratorSAESP() {
        return lucratorSAESP;
    }

    public void setLucratorSAESP(String lucratorSAESP) {
        this.lucratorSAESP = lucratorSAESP;
    }

    @Override
    public String toString() {
        return "LucrarePersoanaFizica{" +
                "letalaNeletala='" + letalaNeletala + '\'' +
                ", lungaScurta='" + lungaScurta + '\'' +
                ", destinatieArma='" + destinatieArma + '\'' +
                ", regimCerere='" + regimCerere + '\'' +
                ", armaLaDomiciliu='" + armaLaDomiciliu + '\'' +
                ", lucratorSAESP='" + lucratorSAESP + '\'' +
                ", persoanaFizica=" + persoanaFizica +
                '}';
    }
}
