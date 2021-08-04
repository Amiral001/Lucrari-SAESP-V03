package com.nicholas.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nicholas.entitys.Lucrare;
import com.nicholas.entitys.PersoanaFizica;
import com.nicholas.entitys.PersoanaJuridica;
import com.nicholas.utils.StringsValue;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataBase {

	private static FileWriter file1, file2, file3;

	private static final ArrayList<PersoanaFizica> persoaneFizice = new ArrayList<>();
	private static final ArrayList<PersoanaJuridica> persoaneJuridice = new ArrayList<>();
	private static final ArrayList<Lucrare> lucrari = new ArrayList<>();



	public static ArrayList<Lucrare> getLucrari() {
		return lucrari;
	}

	public static ArrayList<PersoanaFizica> getPersoaneFizice() {
		return persoaneFizice;
	}

	public static void addPersoanaFizica(PersoanaFizica persoanaFizica) {
		Iterator<PersoanaFizica> iterator = persoaneFizice.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getCnp().equals(persoanaFizica.getCnp())) {
				iterator.remove();
			}
		}
		persoaneFizice.add(persoanaFizica);
	}

	public static void addLucrare(Lucrare lucrare) {
		if (lucrari.size() == 0) {
			lucrari.add(lucrare);
			JOptionPane.showMessageDialog(null, "Datele au fost salvate cu succes!");
		} else {
			boolean existaLucrare = false;
			for (Lucrare lucrareDeComparat : lucrari) {
				if (lucrareDeComparat.getNrLucrare().equals(lucrare.getNrLucrare())) {
					existaLucrare = true;
				} 
			}
			if(!existaLucrare) {
				lucrari.add(lucrare);
				JOptionPane.showMessageDialog(null, "Datele au fost salvate cu succes!");
			} else {
				JOptionPane.showMessageDialog(null, "Lucrarea nu a fost adaugata in baza de date. Exista deja o lucrare cu acest numar !");
			}
		}
	}

	public static void arataToatePersoaneleFizice() {
		for (PersoanaFizica pf : persoaneFizice) {
			System.out.println(pf.toString());
		}
	}

	public static void arataToateLucrarile() {
		for (Lucrare lucrare : lucrari) {
			System.out.println(lucrare.toString());
		}
	}

    public static void addPersoanaJuridica(PersoanaJuridica pj) {
		Iterator<PersoanaJuridica> iterator = persoaneJuridice.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getDenumire().equals(pj.getDenumire())) {
				iterator.remove();
			}
		}
		persoaneJuridice.add(pj);
    }

	public static void writeJson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		String JSONObjectPersoaneFizice = gson.toJson(persoaneFizice);
		String JSONObjectPersoaneJuridice = gson.toJson(persoaneJuridice);
		String JSONObjectLucrari = gson.toJson(lucrari);
		try {
			file1 = new FileWriter(StringsValue.currentFolder + "/docx/persoaneFizice.txt");
			file1.write(JSONObjectPersoaneFizice);
			file1.close();

			file2 = new FileWriter(StringsValue.currentFolder + "/docx/persoaneJuridice.txt");
			file2.write(JSONObjectPersoaneJuridice);
			file2.close();

			file3 = new FileWriter(StringsValue.currentFolder + "/docx/lucrari.txt");
			file3.write(JSONObjectLucrari);
			file3.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readJson() {
		//logica care repopuleaza arraylist-urile


//		GsonBuilder gsonBuilder = new GsonBuilder();
//		Gson gson = gsonBuilder.create();
//		String JSONObjectPersoaneFizice = gson.toJson(persoaneFizice);
//		String JSONObjectPersoaneJuridice = gson.toJson(persoaneJuridice);
//		String JSONObjectLucrari = gson.toJson(lucrari);
//		try {
//			file1 = new FileWriter(StringsValue.currentFolder + "/docx/persoaneFizice.txt");
//persoaneFizice = file1.
//			file1.close();
//
//			file2 = new FileWriter(StringsValue.currentFolder + "/docx/persoaneJuridice.txt");
//
//			file2.close();
//
//			file3 = new FileWriter(StringsValue.currentFolder + "/docx/lucrari.txt");
//
//			file3.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}
}
