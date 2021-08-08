package com.nicholas.entitys;

import java.io.Serializable;
import java.time.LocalDate;

public class PersoanaJuridica implements Serializable {
	
	private String denumire, sediu, punctDeLucru;


	public PersoanaJuridica() {
	}

	public PersoanaJuridica(String nrLucrare, LocalDate dataLucrare, String denumire, String sediu, String punctDeLucru) {
		this.denumire = denumire;
		this.sediu = sediu;
		this.punctDeLucru = punctDeLucru;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getSediu() {
		return sediu;
	}

	public void setSediu(String sediu) {
		this.sediu = sediu;
	}

	public String getPunctDeLucru() {
		return punctDeLucru;
	}

	public void setPunctDeLucru(String punctDeLucru) {
		this.punctDeLucru = punctDeLucru;
	}
}
