package com.nicholas.utils;


import com.nicholas.screens.PanelDatePersoanaFizica;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Service {

	public static String getPath(String fileName) {
//		return Thread.currentThread().getStackTrace()[2].getClassName().getClass().getResourceAsStream("/" + fileName).;
	return StringsValue.currentFolder+"/docx/"+fileName;
	}

	public static ImageIcon changeIconSize(ImageIcon icon, int h, int w) {
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(h, w, Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		return icon;
	}

	public static LocalDate stringToDate(String string) {
		LocalDate ld = null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
					"[dd/MM/yyyy]" + "[dd.MM.yyyy]" + "[dd-MM-yyyy]" + "[d/M/yyyy]" + "[d.M.yyyy]" + "[d-M-yyyy]");
			ld = LocalDate.parse(string, formatter);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Nu a fost completata data corect!");
		}
		return ld;
	}

	public static String dateToString(LocalDate localDate) {
		String ld = null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			ld = localDate.format(formatter);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		}
		return ld;
	}

	public static String currentDateValue() {
		return dateToString(LocalDate.now());
	}

	public static String currentYearValue() {
		return String.valueOf(LocalDate.now().getYear());
	}

	public static String currentMounthValue() {
		String mounthName = "";
		switch (LocalDate.now().getMonthValue()) {
			case 1:
				mounthName = "Ianuarie";
				break;
			case 2:
				mounthName = "Februarie";
				break;
			case 3:
				mounthName = "Martie";
				break;
			case 4:
				mounthName = "Aprilie";
				break;
			case 5:
				mounthName = "Mai";
				break;
			case 6:
				mounthName = "Iunie";
				break;
			case 7:
				mounthName = "Iulie";
				break;
			case 8:
				mounthName = "August";
				break;
			case 9:
				mounthName = "Septembrie";
				break;
			case 10:
				mounthName = "Octombrie";
				break;
			case 11:
				mounthName = "Noiembrie";
				break;
			case 12:
				mounthName = "Decembrie";
				break;
		}
		return mounthName;
	}

	public static String currentDayValue() {
		return String.valueOf(LocalDate.now().getDayOfMonth());
	}

    public static String getLimitDate() {
		return dateToString(LocalDate.now().plusDays(14));
    }

	public static void update(JFrame frame) {
		frame.pack();
		frame.setVisible(true);
		frame.setSize(1200, 900);
	}

	public static LocalDate add90Days(LocalDate localDate) {
		return localDate.plusDays(180);
	}

	public static LocalDate add28Days(LocalDate localDate) {
		return localDate.plusDays(28);
	}


	public static String capitalizeFirstLetter(String string) {
		if (string.contains("-")) {
			int x = string.indexOf("-");
			return WordUtils.capitalizeFully(StringUtils.deleteWhitespace(string.substring(0, x))) + " "
					+ WordUtils.capitalizeFully(StringUtils.deleteWhitespace(string.substring(x + 1)));
		} else {
			return WordUtils.capitalizeFully(string);
		}
	}

	public static String getBirthday(String cnp) {
		String day = cnp.substring(5, 7);
		String mounth = cnp.substring(3, 5);
		String year = null;
		String yearFromCNP = cnp.substring(1, 3);
		int yearNumber = Integer.parseInt(yearFromCNP);
		if (yearNumber < 10 && yearNumber >= 0) {
			year = "200" + yearNumber;
		} else if (yearNumber < 20 && yearNumber >= 10) {
			year = "20" + yearNumber;
		} else {
			year = "19" + yearNumber;
		}
		return day + "/" + mounth + "/" + year;
	}

}
