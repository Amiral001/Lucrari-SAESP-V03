package com.nicholas.entitys;

import java.io.Serializable;

public class LucrarePersoanaJuridica extends Lucrare implements Serializable {

	private PersoanaFizica pf;
	private PersoanaJuridica pj;

	public LucrarePersoanaJuridica() {
	}

	public PersoanaFizica getPf() {
		return pf;
	}

	public void setPf(PersoanaFizica pf) {
		this.pf = pf;
	}

	public PersoanaJuridica getPj() {
		return pj;
	}

	public void setPj(PersoanaJuridica pj) {
		this.pj = pj;
	}

	@Override
	public String toString() {
		return "LucrarePersoanaJuridica{" +
				"pf=" + pf +
				", pj=" + pj +
				'}';
	}
}
