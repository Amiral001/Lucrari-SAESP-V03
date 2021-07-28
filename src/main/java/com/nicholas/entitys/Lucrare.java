package com.nicholas.entitys;

import java.time.LocalDate;

public class Lucrare {
	
	private String nrLucrare, tipLucrare;
	private LocalDate dataLucrare;
	
	
	public Lucrare() {
		super();
	}


	public Lucrare(String nrLucrare, String tipLucrare, LocalDate dataLucrare) {
		this.nrLucrare = nrLucrare;
		this.tipLucrare = tipLucrare;
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

	public String getTipLucrare() {
		return tipLucrare;
	}

	public void setTipLucrare(String tipLucrare) {
		this.tipLucrare = tipLucrare;
	}

	@Override
	public String toString() {
		return "Lucrare{" +
				"nrLucrare='" + nrLucrare + '\'' +
				", tipLucrare='" + tipLucrare + '\'' +
				", dataLucrare=" + dataLucrare +
				'}';
	}
}
