package com.nicholas.utils;


import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Service {

	public static String getPath(String fileName) {
		return Thread.currentThread().getStackTrace()[2].getClassName().getClass().getResource("/" + fileName).getPath();
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
}
