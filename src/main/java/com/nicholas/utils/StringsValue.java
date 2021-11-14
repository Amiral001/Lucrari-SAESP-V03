package com.nicholas.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class StringsValue {

	public static String cadruLegalGestionar = "art. 70-71 din Legea nr. 295/2004 şi art. 109-110 din HG nr. 11/2018";

	public static String cadruLegalDotare = "art. 69-70 din Legea nr. 295/2004 şi art. 109 din HG nr. 11/2018";

	public static String mentiuneAtestat = "atestat pentru exercitarea profesiei de agent de securitate, eliberat de , la data de , cu seria/nr.  și ";

	public static String cadruSuspendareLetala = "art. 6, alin. (6) din Normele Metodologice din 17 ianuarie 2018 de aplicare a Legii nr. 295/2004 privind regimul armelor şi al muniţiilor, republicată ";

	public static String cadruSuspendareNeletala = "art. 74, alin. (6) din Normele Metodologice din 17 ianuarie 2018 de aplicare a Legii nr. 295/2004 privind regimul armelor şi al muniţiilor, republicată ";

	public static String conditiiAsigurare = "dacă, la domiciliu, îndeplinește condiţiile de păstrare şi de asigurare a securităţii "
			+ "armelor şi muniţiei (dulap sau casetă metalică special amenajată, fixată în podea sau perete, asigurată cu cel puţin "
			+ "două sisteme de închidere independente, cu cheie sau cifru, astfel încât să nu permită accesul persoanelor neautorizate);";
	
	public static String mentiunePV = "Anexăm alăturat model de proces-verbal ce va fi întocmit cu ocazia verificărilor și care va fi anexat raportului întocmit " +
			"de către lucrătorul de poliție. Atât raportul cât și procesul-verbal vor fi înaintate către Serviciul Arme, Explozivi și Substanțe Periculoase.";

	public static String currentFolder = System.getProperty("user.dir");

	public static ArrayList<String> sexStringsTargets = new ArrayList<>(Arrays.asList
			("domnuldoamna", "domiciliatdomiciliata", "sunumituluisusnumitei", "susnumitulsusnumita", "sanctionatsanctionata", "solicitantuluisolicitantei",
					"numituluinumitei", "solicitantulsolicitanta", "domnuluidoamnei", "numitulnumita", "judecatjudecata", "condamnatcondamnata", "invunuitinvinuita",
					"inculpatinculpata", "stapanitstapanita", "implicatimplicata", "acestaaceasta", "aptapta", "Numitulnumita", "Acestaaceasta", "Domnuldoamna"));
	public static ArrayList<String> sexStringsReplacesM = new ArrayList<>(Arrays.asList
			("domnul", "domiciliat", "sunumitului", "susnumitul", "sancționat", "solicitantului", "numitului", "solicitantul", "domnului", "numitul",
					"judecat", "condamnat", "invinuit", "inculpat", "stăpânit", "implicat", "acesta", "apt", "Numitul", "Acesta", "Domnul"));
	public static ArrayList<String> sexStringsReplacesF = new ArrayList<>(Arrays.asList
			("doamna", "domiciliată", "susnumitei", "susnumita", "sancționată", "solicitantei", "numitei", "solicitanta", "doamnei", "numita",
					"judecată", "condamnată", "invinuită", "inculpată", "stăpânită", "implicată", "aceasta", "aptă", "Numita", "Aceasta", "Doamna"));

}

