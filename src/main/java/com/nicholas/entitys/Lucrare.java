package com.nicholas.entitys;

import java.time.LocalDate;

public class Lucrare {
	
	private String nrLucrare; 
	private LocalDate dataLucrare;
	
	
	public Lucrare() {
		super();
	}


	public Lucrare(String nrLucrare, LocalDate dataLucrare) {
		super();
		this.nrLucrare = nrLucrare;
		this.dataLucrare = dataLucrare;
	}


	public String getNrLucrare() {
		return nrLucrare;
	}


	public void setNrLucrare(String nrLucrare) {
		this.nrLucrare = nrLucrare;
	}


	public LocalDate getDataLucrare() {
		return dataLucrare;
	}


	public void setDataLucrare(LocalDate dataLucrare) {
		this.dataLucrare = dataLucrare;
	}


	@Override
	public String toString() {
		return "Lucrare [nrLucrare=" + nrLucrare + ", dataLucrare=" + dataLucrare + "]";
	}
	
	

}
