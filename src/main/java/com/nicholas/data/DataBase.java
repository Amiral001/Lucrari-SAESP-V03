package com.nicholas.data;

import com.nicholas.entitys.Lucrare;
import com.nicholas.entitys.PersoanaFizica;
import com.nicholas.entitys.PersoanaJuridica;
import com.nicholas.utils.LucrariComparator;
import com.nicholas.utils.PFComparator;
import com.nicholas.utils.PJComparator;
import com.nicholas.utils.StringsValue;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataBase {

	private static  ArrayList<PersoanaFizica> persoaneFizice = new ArrayList<>();
	private static  ArrayList<PersoanaJuridica> persoaneJuridice = new ArrayList<>();
	private static  ArrayList<Lucrare> lucrari = new ArrayList<>();

	public static ArrayList<Lucrare> getLucrari() {
		return lucrari;
	}

	public static ArrayList<PersoanaFizica> getPersoaneFizice() {
		return persoaneFizice;
	}

	public static void addPersoanaFizica(PersoanaFizica persoanaFizica) {
		persoaneFizice.removeIf(persoanaFizica1 -> persoanaFizica1.getCnp().equals(persoanaFizica.getCnp()));
		persoaneFizice.add(persoanaFizica);
	}

	public static void addPersoanaJuridica(PersoanaJuridica pj) {
		persoaneJuridice.removeIf(persoanaJuridica -> persoanaJuridica.getDenumire().equals(pj.getDenumire()));
		persoaneJuridice.add(pj);
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

	public static void writeJson() {
		FileOutputStream fos1, fos2, fos3;
		try {
			fos1 = new FileOutputStream(StringsValue.currentFolder + "/docx/db/persoaneFizice.txt");
			fos2 = new FileOutputStream(StringsValue.currentFolder + "/docx/db/persoaneJuridice.txt");
			fos3 = new FileOutputStream(StringsValue.currentFolder + "/docx/db/Lucrari.txt");

			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);oos1.writeObject(persoaneFizice);oos1.close();
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);oos2.writeObject(persoaneJuridice);oos2.close();
			ObjectOutputStream oos3 = new ObjectOutputStream(fos3);oos3.writeObject(lucrari);oos3.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readJson() {
		try {
			FileInputStream fis1 = new FileInputStream(StringsValue.currentFolder + "/docx/db/persoaneFizice.txt");
			ObjectInputStream ois1 = new ObjectInputStream(fis1);persoaneFizice = (ArrayList<PersoanaFizica>) ois1.readObject();ois1.close();
			Collections.sort(persoaneFizice, new PFComparator());

			FileInputStream fis2 = new FileInputStream(StringsValue.currentFolder + "/docx/db/persoaneJuridice.txt");
			ObjectInputStream ois2 = new ObjectInputStream(fis2);persoaneJuridice = (ArrayList<PersoanaJuridica>) ois2.readObject();ois2.close();
			Collections.sort(persoaneJuridice, new PJComparator());

			FileInputStream fis3 = new FileInputStream(StringsValue.currentFolder + "/docx/db/Lucrari.txt");
			ObjectInputStream ois3 = new ObjectInputStream(fis3);lucrari = (ArrayList<Lucrare>) ois3.readObject();ois3.close();
			Collections.sort(lucrari, new LucrariComparator());

		} catch (IOException | ClassNotFoundException exception) {
			exception.printStackTrace();
		}
	}
}