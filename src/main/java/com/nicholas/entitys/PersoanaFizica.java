package com.nicholas.entitys;

public class PersoanaFizica {

    private String nume, prenume, cnp, adresaDomiciliu, adresaResedinta, serieCI, nrCI, numarTelefon, unitate01, unitate02, subunitate01, subunitate02, emitentAtestat, serieNrAtestat, dataAtestat, emitentCurs, dataCurs, domAltJud, resAltJud;

    public PersoanaFizica() {
    }

    public PersoanaFizica(String nume, String prenume, String cnp, String adresaDomiciliu, String adresaResedinta, String serieCI, String nrCI, String numarTelefon, String unitate01, String unitate02, String subunitate01, String subunitate02, String emitentAtestat, String serieNrAtestat, String dataAtestat, String emitentCurs, String dataCurs, String domAltJud, String resAltJud) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.adresaDomiciliu = adresaDomiciliu;
        this.adresaResedinta = adresaResedinta;
        this.serieCI = serieCI;
        this.nrCI = nrCI;
        this.numarTelefon = numarTelefon;
        this.unitate01 = unitate01;
        this.unitate02 = unitate02;
        this.subunitate01 = subunitate01;
        this.subunitate02 = subunitate02;
        this.emitentAtestat = emitentAtestat;
        this.serieNrAtestat = serieNrAtestat;
        this.dataAtestat = dataAtestat;
        this.emitentCurs = emitentCurs;
        this.dataCurs = dataCurs;
        this.domAltJud = domAltJud;
        this.resAltJud = resAltJud;
    }

    public String getDomAltJud() {
        return domAltJud;
    }

    public void setDomAltJud(String domAltJud) {
        this.domAltJud = domAltJud;
    }

    public String getResAltJud() {
        return resAltJud;
    }

    public void setResAltJud(String resAltJud) {
        this.resAltJud = resAltJud;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getAdresaDomiciliu() {
        return adresaDomiciliu;
    }

    public void setAdresaDomiciliu(String adresaDomiciliu) {
        this.adresaDomiciliu = adresaDomiciliu;
    }

    public String getAdresaResedinta() {
        return adresaResedinta;
    }

    public void setAdresaResedinta(String adresaResedinta) {
        this.adresaResedinta = adresaResedinta;
    }

    public String getSerieCI() {
        return serieCI;
    }

    public void setSerieCI(String serieCI) {
        this.serieCI = serieCI;
    }

    public String getNrCI() {
        return nrCI;
    }

    public void setNrCI(String nrCI) {
        this.nrCI = nrCI;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public String getUnitate01() {
        return unitate01;
    }

    public void setUnitate01(String unitate01) {
        this.unitate01 = unitate01;
    }

    public String getUnitate02() {
        return unitate02;
    }

    public void setUnitate02(String unitate02) {
        this.unitate02 = unitate02;
    }

    public String getSubunitate01() {
        return subunitate01;
    }

    public void setSubunitate01(String subunitate01) {
        this.subunitate01 = subunitate01;
    }

    public String getSubunitate02() {
        return subunitate02;
    }

    public void setSubunitate02(String subunitate02) {
        this.subunitate02 = subunitate02;
    }

    public String getEmitentAtestat() {
        return emitentAtestat;
    }

    public void setEmitentAtestat(String emitentAtestat) {
        this.emitentAtestat = emitentAtestat;
    }

    public String getSerieNrAtestat() {
        return serieNrAtestat;
    }

    public void setSerieNrAtestat(String serieNrAtestat) {
        this.serieNrAtestat = serieNrAtestat;
    }

    public String getDataAtestat() {
        return dataAtestat;
    }

    public void setDataAtestat(String dataAtestat) {
        this.dataAtestat = dataAtestat;
    }

    public String getEmitentCurs() {
        return emitentCurs;
    }

    public void setEmitentCurs(String emitentCurs) {
        this.emitentCurs = emitentCurs;
    }

    public String getDataCurs() {
        return dataCurs;
    }

    public void setDataCurs(String dataCurs) {
        this.dataCurs = dataCurs;
    }

    @Override
    public String toString() {
        return "PersoanaFizica{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", cnp='" + cnp + '\'' +
                ", adresaDomiciliu='" + adresaDomiciliu + '\'' +
                ", adresaResedinta='" + adresaResedinta + '\'' +
                ", serieCI='" + serieCI + '\'' +
                ", nrCI='" + nrCI + '\'' +
                ", numarTelefon='" + numarTelefon + '\'' +
                ", unitate01='" + unitate01 + '\'' +
                ", unitate02='" + unitate02 + '\'' +
                ", subunitate01='" + subunitate01 + '\'' +
                ", subunitate02='" + subunitate02 + '\'' +
                ", emitentAtestat='" + emitentAtestat + '\'' +
                ", serieNrAtestat='" + serieNrAtestat + '\'' +
                ", dataAtestat='" + dataAtestat + '\'' +
                ", emitentCurs='" + emitentCurs + '\'' +
                ", dataCurs='" + dataCurs + '\'' +
                '}';
    }
}
