package com.nicholas.utils;

import com.nicholas.screens.PanelDateCererePF;
import com.nicholas.screens.PanelDatePersoanaFizica;
import com.nicholas.screens.PanelDatePersoanaJuridica;
import com.nicholas.screens.PanelMainScreen;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class WordDocService {

    public static void deleteParagraph (String docPath, ArrayList<String> paragraphs){
       if(paragraphs.size()!=0){
           for (String s : paragraphs){
               deleteParagraph(docPath, s);
           }
       }
    }

    public static void deleteParagraph (String docPath, String paragraph){
        try {
            FileInputStream fis = new FileInputStream(docPath);
            XWPFDocument doc = new XWPFDocument(fis);
            fis.close();
            XWPFParagraph toDelete = doc.getParagraphs().stream().filter(p -> StringUtils.equalsIgnoreCase(paragraph, p.getParagraphText())).findFirst().orElse(null);
                if (toDelete != null) {
                doc.removeBodyElement(doc.getPosOfParagraph(toDelete));
                OutputStream fos = new FileOutputStream(docPath);
                doc.write(fos);
                fos.close();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
    }

    public static void replace(String sourceDoc, String finalDoc, ArrayList<String> target, ArrayList<String> replacement) {
        try {
            /**
             * if uploaded doc then use HWPF else if uploaded Docx file use XWPFDocument
             */
            FileInputStream fis = new FileInputStream(sourceDoc);
            XWPFDocument doc = new XWPFDocument(fis);
            fis.close();
            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        for (String x : target) {
                            if (text != null && text.contains(x)) {
                                text = text.replace(x, replacement.get(target.indexOf(x)));
                                r.setText(text, 0);
                            }
                        }
                    }
                }
            }

            for (XWPFTable tbl : doc.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                String text = r.getText(0);
                                for (String x : target) {
                                    if (text != null && text.contains(x)) {
                                        text = text.replace(x, replacement.get(target.indexOf(x)));
                                        r.setText(text, 0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            FileOutputStream fos = new FileOutputStream(finalDoc);
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void replace(String path, ArrayList<String> target, ArrayList<String> replacement) {
        try {
            /**
             * if uploaded doc then use HWPF else if uploaded Docx file use XWPFDocument
             */
            FileInputStream fis = new FileInputStream(path);
            XWPFDocument doc = new XWPFDocument(fis);
            fis.close();
            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        for (String x : target) {
                            if (text != null && text.contains(x)) {
                                text = text.replace(x, replacement.get(target.indexOf(x)));
                                r.setText(text, 0);
                            }
                        }
                    }
                }
            }

            for (XWPFTable tbl : doc.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                String text = r.getText(0);
                                for (String x : target) {
                                    if (text != null && text.contains(x)) {
                                        text = text.replace(x, replacement.get(target.indexOf(x)));
                                        r.setText(text, 0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            FileOutputStream fos = new FileOutputStream(path);
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createDocumentsVerificariPA() {

        createDocumentsVerificariADA();
        if (PanelDateCererePF.tfLetalaNeletala.getText().equals("neletală")) {
            if (PanelDatePersoanaFizica.tfResedintaSolicintant.getText().equals("")) {
                createSubunitate(Service.getPath("adresaSubunitateV01.docx"), "D");
            } else {
                if (PanelDateCererePF.tfArmaLaDomiciliu.getText().equals("Da")) {
                    if (!PanelDatePersoanaFizica.chckbxDomAltJud.isSelected()) {
                        createSubunitate(Service.getPath("adresaSubunitateV01.docx"), "D");
                    } else {
                        createSubunitate(Service.getPath("adresaSubunitateV02.docx"), "D");
                    }
                    if (!PanelDatePersoanaFizica.chckbxResAltJud.isSelected()) {
                        createSubunitate(Service.getPath("adresaSubunitateV01.docx"), "R");
                        WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.conditiiAsigurare);
                        WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.mentiunePV);
                    } else {
                        createSubunitate(Service.getPath("adresaSubunitateV02.docx"), "R");
                        WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.conditiiAsigurare);
                        WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.mentiunePV);
                    }
                } else {
                    if (!PanelDatePersoanaFizica.chckbxDomAltJud.isSelected()) {
                        createSubunitate(Service.getPath("adresaSubunitateV01.docx"), "D");
                        WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.conditiiAsigurare);
                        WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.mentiunePV);
                    } else {
                        createSubunitate(Service.getPath("adresaSubunitateV02.docx"), "D");
                        WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.conditiiAsigurare);
                        WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.mentiunePV);
                    }
                    if (!PanelDatePersoanaFizica.chckbxResAltJud.isSelected()) {
                        createSubunitate(Service.getPath("adresaSubunitateV01.docx"), "R");
                    } else {
                        createSubunitate(Service.getPath("adresaSubunitateV02.docx"), "R");
                    }
                }
            }
        } else {
            if (PanelDatePersoanaFizica.tfResedintaSolicintant.getText().equals("")) {
                createSubunitate(Service.getPath("adresaSubunitateV01.docx"), "D");
                WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.conditiiAsigurare);
                WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.mentiunePV);
            } else {
                if (!PanelDatePersoanaFizica.chckbxDomAltJud.isSelected()) {
                    createSubunitate(Service.getPath("adresaSubunitateV01.docx"), "D");
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.conditiiAsigurare);
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.mentiunePV);
                } else {
                    createSubunitate(Service.getPath("adresaSubunitateV02.docx"), "D");
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.conditiiAsigurare);
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.mentiunePV);
                }
                if (!PanelDatePersoanaFizica.chckbxResAltJud.isSelected()) {
                    createSubunitate(Service.getPath("adresaSubunitateV01.docx"), "R");
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.conditiiAsigurare);
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.mentiunePV);
                } else {
                    createSubunitate(Service.getPath("adresaSubunitateV02.docx"), "R");
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.conditiiAsigurare);
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.mentiunePV);
                }
            }
            createSubunitate();
        }
    }

    public static void createDocumentsVerificariADA() {
        createUTAI();
        createPVBd();
    }

    public static void createDocumentsVerificariViza() {

        createDocumentsVerificariADA();
        if (!PanelDatePersoanaFizica.tfResedintaSolicintant.getText().equals("")) {
            if (PanelDateCererePF.tfArmaLaDomiciliu.getText().equals("Da")) {
                if (!PanelDatePersoanaFizica.chckbxResAltJud.isSelected()) {
                    createSubunitate(Service.getPath("adresaSubunitateVV01.docx"), "R");
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.conditiiAsigurare);
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.mentiunePV);
                } else {
                    createSubunitate(Service.getPath("adresaSubunitateVV02.docx"), "R");
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.conditiiAsigurare);
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.mentiunePV);
                }
                if (!PanelDatePersoanaFizica.chckbxDomAltJud.isSelected()) {
                    createSubunitate(Service.getPath("adresaSubunitateVV01.docx"), "D");
                } else {
                    createSubunitate(Service.getPath("adresaSubunitateVV02.docx"), "D");
                }
            } else {
                if (!PanelDatePersoanaFizica.chckbxResAltJud.isSelected()) {
                    createSubunitate(Service.getPath("adresaSubunitateVV01.docx"), "R");
                } else {
                    createSubunitate(Service.getPath("adresaSubunitateVV02.docx"), "R");
                }
                if (!PanelDatePersoanaFizica.chckbxDomAltJud.isSelected()) {
                    createSubunitate(Service.getPath("adresaSubunitateVV01.docx"), "D");
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.conditiiAsigurare);
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.mentiunePV);
                } else {
                    createSubunitate(Service.getPath("adresaSubunitateVV02.docx"), "D");
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.conditiiAsigurare);
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.mentiunePV);
                }
            }
        } else {
            createSubunitate(Service.getPath("adresaSubunitateVV01.docx"), "D");
        }
    }

    public static void createDocumentsVerificariDR() {
        createDocumentsVerificariADA();
        if (!PanelDatePersoanaFizica.tfResedintaSolicintant.getText().equals("")) {
            if (PanelDateCererePF.tfArmaLaDomiciliu.getText().equals("Da")) {
                if (!PanelDatePersoanaFizica.chckbxResAltJud.isSelected()) {
                    createSubunitate(Service.getPath("adresaSubunitateDRV01.docx"), "R");
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.conditiiAsigurare);
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.mentiunePV);
                } else {
                    createSubunitate(Service.getPath("adresaSubunitateDRV02.docx"), "R");
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.conditiiAsigurare);
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateR.docx", StringsValue.mentiunePV);
                }
                if (!PanelDatePersoanaFizica.chckbxDomAltJud.isSelected()) {
                    createSubunitate(Service.getPath("adresaSubunitateDRV01.docx"), "D");
                } else {
                    createSubunitate(Service.getPath("adresaSubunitateDRV02.docx"), "D");
                }
            } else {
                if (!PanelDatePersoanaFizica.chckbxResAltJud.isSelected()) {
                    createSubunitate(Service.getPath("adresaSubunitateDRV01.docx"), "R");
                } else {
                    createSubunitate(Service.getPath("adresaSubunitateDRV02.docx"), "R");
                }
                if (!PanelDatePersoanaFizica.chckbxDomAltJud.isSelected()) {
                    createSubunitate(Service.getPath("adresaSubunitateDRV01.docx"), "D");
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.conditiiAsigurare);
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.mentiunePV);
                } else {
                    createSubunitate(Service.getPath("adresaSubunitateDRV02.docx"), "D");
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.conditiiAsigurare);
                    WordDocService.deleteParagraph(StringsValue.currentFolder + "/Adresa_subunitateD.docx", StringsValue.mentiunePV);
                }
            }
        } else {
            createSubunitate(Service.getPath("adresaSubunitateDRV01.docx"), "D");
        }
    }

    private static void createSubunitate() {
        //creaza adresa catre lucratorul SAESP
        ArrayList <String> toReplace = new ArrayList<>();
        toReplace.add("numarlucrare");
        toReplace.add("datacurenta");
        toReplace.add("unitate01");
        toReplace.add("datalucrare");
        toReplace.add("nume01");
        toReplace.add("nume02");
        toReplace.add("adresadomiciliu");
        toReplace.add("cnpsolicitant");
        toReplace.add("telefonsolicitant");
        toReplace.add("letalaneletala");
        toReplace.add("destinatiearma");
        toReplace.add("datalimitaraspuns");

        ArrayList <String> newValues = new ArrayList<>();
        newValues.add(PanelDatePersoanaFizica.tfNrLucrare.getText());
        newValues.add(Service.currentDateValue());


        newValues.add(PanelDatePersoanaFizica.tfLucratorSAESP.getText());

        newValues.add(PanelDatePersoanaFizica.tfDataLucrare.getText());
        newValues.add(PanelDatePersoanaFizica.tfNumeSolicitant.getText());
        newValues.add(PanelDatePersoanaFizica.tfPrenumeSolicitant.getText());

        if (PanelDatePersoanaFizica.tfResedintaSolicintant.getText().equals("")) {
            newValues.add(PanelDatePersoanaFizica.tfDomiciliuSolicitant.getText());
        } else {
            newValues.add(PanelDatePersoanaFizica.tfDomiciliuSolicitant.getText() + " și reședință în " + PanelDatePersoanaFizica.tfResedintaSolicintant.getText());
        }

        newValues.add(PanelDatePersoanaFizica.tfCNPSolicitant.getText());
        newValues.add(PanelDatePersoanaFizica.tfTelefonSolicitant.getText());
        newValues.add(PanelDateCererePF.tfLetalaNeletala.getText());
        newValues.add(PanelDateCererePF.tfDestinatieArma.getText());
        newValues.add(Service.getLimitDate());

        WordDocService.replace(Service.getPath("adresaSubunitateV01.docx"),
                StringsValue.currentFolder+"/Adresa_subunitate_"+ PanelDatePersoanaFizica.tfLucratorSAESP.getText() +".docx", toReplace, newValues);
        WordDocService.deleteParagraph(StringsValue.currentFolder+"/Adresa_subunitate_"+ PanelDatePersoanaFizica.tfLucratorSAESP.getText() +".docx", "unitate02");
        correctDocForSexWords(StringsValue.currentFolder+"/Adresa_subunitate_"+ PanelDatePersoanaFizica.tfLucratorSAESP.getText() +".docx");
    }

    private static void createSubunitate(String path, @org.jetbrains.annotations.NotNull String RD) {
        ArrayList <String> toReplace = new ArrayList<>();
        toReplace.add("numarlucrare");
        toReplace.add("datacurenta");
        toReplace.add("unitate01");
        toReplace.add("unitate02");
        toReplace.add("datalucrare");
        toReplace.add("nume01");
        toReplace.add("nume02");
        toReplace.add("adresadomiciliu");
        toReplace.add("cnpsolicitant");
        toReplace.add("telefonsolicitant");
        toReplace.add("motivcerere");
        toReplace.add("datalimitaraspuns");
        toReplace.add("letalaneletala");
        toReplace.add("destinatiearma");

        ArrayList <String> newValues = new ArrayList<>();
        newValues.add(PanelDatePersoanaFizica.tfNrLucrare.getText());
        newValues.add(Service.currentDateValue());

        if (RD.equals("D")) {
            newValues.add(PanelDatePersoanaFizica.tfUnitateDomiciliu.getText());
            newValues.add(PanelDatePersoanaFizica.tfSubunitateDomiciliu.getText());
        } else if (RD.equals("R")) {
            newValues.add(PanelDatePersoanaFizica.tfUnitateResedinta.getText());
            newValues.add(PanelDatePersoanaFizica.tfSubunitateresedinta.getText());
        }
        newValues.add(PanelDatePersoanaFizica.tfDataLucrare.getText());
        newValues.add(PanelDatePersoanaFizica.tfNumeSolicitant.getText());
        newValues.add(PanelDatePersoanaFizica.tfPrenumeSolicitant.getText());
        if (PanelDatePersoanaFizica.tfResedintaSolicintant.getText().equals("")) {
            newValues.add(PanelDatePersoanaFizica.tfDomiciliuSolicitant.getText());
        } else {
            newValues.add(PanelDatePersoanaFizica.tfDomiciliuSolicitant.getText() + " și reședință în " + PanelDatePersoanaFizica.tfResedintaSolicintant.getText());
        }
        newValues.add(PanelDatePersoanaFizica.tfCNPSolicitant.getText());
        newValues.add(PanelDatePersoanaFizica.tfTelefonSolicitant.getText());
        if (PanelMainScreen.tipLucrare.equals("D")) {
            newValues.add("schimbarea domiciliului în permisul de armă");
        } else  {
            newValues.add("înscrierea reședinței în permisul de armă");

        }
        newValues.add(Service.getLimitDate());
        newValues.add(PanelDateCererePF.tfLetalaNeletala.getText());
        newValues.add(PanelDateCererePF.tfDestinatieArma.getText());

        WordDocService.replace(path, StringsValue.currentFolder+"/Adresa_subunitate"+RD+".docx", toReplace, newValues);
        correctDocForSexWords(StringsValue.currentFolder+"/Adresa_subunitate"+RD+".docx");

    }

    private static void createPVBd() {
        ArrayList <String> toReplace = new ArrayList<>();
        toReplace.add("numarlucrare");
        toReplace.add("datacurenta");
        toReplace.add("ancurent");
        toReplace.add("lunacurenta");
        toReplace.add("ziuacurenta");
        toReplace.add("nume01");
        toReplace.add("nume02");
        toReplace.add("cnpsolicitant");
        toReplace.add("tiplucrare");
        toReplace.add("adresadomiciliu");
        toReplace.add("datalucrare");


        ArrayList <String> newValues = new ArrayList<>();
        newValues.add(PanelDatePersoanaFizica.tfNrLucrare.getText());
        newValues.add(Service.currentDateValue());
        newValues.add(Service.currentYearValue());
        newValues.add(Service.currentMounthValue());
        newValues.add(Service.currentDayValue());
        newValues.add(PanelDatePersoanaFizica.tfNumeSolicitant.getText());
        newValues.add(PanelDatePersoanaFizica.tfPrenumeSolicitant.getText());
        newValues.add(PanelDatePersoanaFizica.tfCNPSolicitant.getText());
        newValues.add(generateTipLucrare());
        newValues.add(PanelDatePersoanaFizica.tfDomiciliuSolicitant.getText());
        newValues.add(PanelDatePersoanaFizica.tfDataLucrare.getText());

        WordDocService.replace(Service.getPath("PvBD.docx"), StringsValue.currentFolder+"/PvBD.docx", toReplace, newValues);
        correctDocForSexWords(StringsValue.currentFolder+"/PvBD.docx");
    }

    private static void createUTAI() {
        ArrayList<String> toReplace = new ArrayList<>();
        toReplace.add("numarlucrare");
        toReplace.add("datacurenta");
        toReplace.add("nume01");
        toReplace.add("nume02");
        toReplace.add("cnpsolicitant");
        toReplace.add("motivsolicitare");
        toReplace.add("perioadasolicitata");

        ArrayList<String> newValues = new ArrayList<>();
        newValues.add(PanelDatePersoanaFizica.tfNrLucrare.getText());
        newValues.add(Service.currentDateValue());
        newValues.add(PanelDatePersoanaFizica.tfNumeSolicitant.getText());
        newValues.add(PanelDatePersoanaFizica.tfPrenumeSolicitant.getText());
        newValues.add(PanelDatePersoanaFizica.tfCNPSolicitant.getText());
        newValues.add(generateTipLucrare());
        newValues.add(generarePerioadaUTAI());

        WordDocService.replace(Service.getPath("UTAI.docx"), StringsValue.currentFolder + "/UTAI.docx", toReplace, newValues);
    }

    private static String generarePerioadaUTAI() {
        String perioada = "ultimii 5 ani";
        if (PanelMainScreen.tipLucrare.equals("PA")) {
            perioada = "ultimii 5 ani";
        } else if (PanelMainScreen.tipLucrare.equals("ADA")|| PanelMainScreen.tipLucrare.equals("V")|| PanelMainScreen.tipLucrare.equals("D")|| PanelMainScreen.tipLucrare.equals("R")) {
            perioada = "de la ultima verificare";
        }
        return perioada;
    }

    private static String generateTipLucrare() {
        String tipLucrare = "verificări specifice arme";
        switch (PanelMainScreen.tipLucrare) {
            case "PA":
            case "ADA":
                tipLucrare = "autorizare deținere armă";
                break;
            case "V":
                tipLucrare = "prelungire valabilitate permis de armă";
                break;
            case "D":
                tipLucrare = "schimbare domiciliu în permisul de armă";
                break;
            case "R":
                tipLucrare = "înscriere reședință în permisul de armă";
                break;
            case "DOT":
                tipLucrare = "avizare dotare cu armament";
                break;
            case "GES":
                tipLucrare = "avizare gestionar arme și muniții";
                break;
        }
        return tipLucrare;
    }

    public static void correctDocForSexWords(String path) {
        ArrayList<String> t = StringsValue.sexStringsTargets;
        ArrayList<String> m = StringsValue.sexStringsReplacesM;
        ArrayList<String> f = StringsValue.sexStringsReplacesF;

        if (PanelDatePersoanaFizica.sexSolicitant.getText().equals("M")) {
            replace(path, t, m);
        } else if (PanelDatePersoanaFizica.sexSolicitant.getText().equals("F")) {
            replace(path, t, f);
        }
    }

    public static void createRaportSuspendareLucrare() {
        ArrayList<String> toReplace = new ArrayList<>();
        toReplace.add("numarlucrare");
        toReplace.add("datacurenta");
        toReplace.add("datalucrare");
        toReplace.add("nume01");
        toReplace.add("nume02");
        toReplace.add("cnpsolicitant");
        toReplace.add("letalaneletala");
        toReplace.add("destinatiearma");
        toReplace.add("motivsuspendare");
        toReplace.add("cadrullegalsuspendare");

        ArrayList<String> newValues = new ArrayList<>();
        try {
            newValues.add(PanelDatePersoanaFizica.tfNrLucrare.getText());
            newValues.add(Service.currentDateValue());
            newValues.add(PanelDatePersoanaFizica.tfDataLucrare.getText());
            newValues.add(PanelDatePersoanaFizica.tfNumeSolicitant.getText());
            newValues.add(PanelDatePersoanaFizica.tfPrenumeSolicitant.getText());
            newValues.add(PanelDatePersoanaFizica.tfCNPSolicitant.getText());
            newValues.add(PanelDateCererePF.tfLetalaNeletala.getText());
            newValues.add(PanelDateCererePF.tfDestinatieArma.getText());
            newValues.add(PanelDateCererePF.motivSuspendareLucrare);
            if (PanelDateCererePF.tfLetalaNeletala.getText().equals("letală")) {
                newValues.add(StringsValue.cadruSuspendareLetala);
            } else {
                newValues.add(StringsValue.cadruSuspendareNeletala);
            }
            WordDocService.replace(Service.getPath("RaportSuspendare.docx"), StringsValue.currentFolder + "/Raport_Suspendare.docx", toReplace, newValues);
            correctDocForSexWords(StringsValue.currentFolder + "/Raport_Suspendare.docx");
            JOptionPane.showMessageDialog(null, "Raportul de suspendare a lucrării a fost generat cu succes");
        } catch (NullPointerException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    public static void createRaportFinalizareLucrarePAsiADA() {
        ArrayList<String> toReplace = new ArrayList<>();
        toReplace.add("numarlucrare");
        toReplace.add("datacurenta");
        toReplace.add("datalucrare");
        toReplace.add("nume01");
        toReplace.add("nume02");
        toReplace.add("cnpsolicitant");
        toReplace.add("letalaneletala");
        toReplace.add("destinatiearma");

        ArrayList<String> newValues = new ArrayList<>();
        try {
            newValues.add(PanelDatePersoanaFizica.tfNrLucrare.getText());
            newValues.add(Service.currentDateValue());
            newValues.add(PanelDatePersoanaFizica.tfDataLucrare.getText());
            newValues.add(PanelDatePersoanaFizica.tfNumeSolicitant.getText());
            newValues.add(PanelDatePersoanaFizica.tfPrenumeSolicitant.getText());
            newValues.add(PanelDatePersoanaFizica.tfCNPSolicitant.getText());
            newValues.add(PanelDateCererePF.tfLetalaNeletala.getText());
            newValues.add(PanelDateCererePF.tfDestinatieArma.getText());

            WordDocService.replace(Service.getPath("RaportFinalAutorizatie.docx"), StringsValue.currentFolder + "/Raport_Final.docx", toReplace, newValues);
            correctDocForSexWords(StringsValue.currentFolder + "/Raport_Final.docx");
            JOptionPane.showMessageDialog(null, "Raportul de finalizare a lucrării a fost generat cu succes");
        } catch (NullPointerException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: "+ e);
        }
    }

    public static void createDocumentsFinalizareLucrareVDR() {
        ArrayList<String> toReplace = new ArrayList<>();
        toReplace.add("numarlucrare");
        toReplace.add("datacurenta");
        toReplace.add("datalucrare");
        toReplace.add("nume01");
        toReplace.add("nume02");
        toReplace.add("cnpsolicitant");
        toReplace.add("felsolicitare");

        ArrayList<String> newValues = new ArrayList<>();
        try {
            newValues.add(PanelDatePersoanaFizica.tfNrLucrare.getText());
            newValues.add(Service.currentDateValue());
            newValues.add(PanelDatePersoanaFizica.tfDataLucrare.getText());
            newValues.add(PanelDatePersoanaFizica.tfNumeSolicitant.getText());
            newValues.add(PanelDatePersoanaFizica.tfPrenumeSolicitant.getText());
            newValues.add(PanelDatePersoanaFizica.tfCNPSolicitant.getText());
            switch (PanelMainScreen.tipLucrare) {
                case "V":
                    newValues.add("prelungirea valabilității permisului/permiselor de armă");
                    break;
                case "D":
                    newValues.add("înscrirea unui nou domiciliu în permisul de armă");
                    break;
                case "R":
                    newValues.add("înscrirea reședinței în permisul de armă");
                    break;
            }
            WordDocService.replace(Service.getPath("RaportFinal2.docx"), StringsValue.currentFolder + "/Raport_Final.docx", toReplace, newValues);
            JOptionPane.showMessageDialog(null, "Raportul de finalizare a lucrării a fost generat cu succes");
            correctDocForSexWords(StringsValue.currentFolder + "/Raport_Final.docx");
        } catch (NullPointerException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: "+ e);
        }

    }

    public static void createDocumentsVerificariDG() {
        // Casuta de dialog pentru confirmare este creata la adaugarea lucrarii in ArrayList -> DataBase Class
        createUTAI();
        createPVBd();
        if (PanelDatePersoanaFizica.tfResedintaSolicintant.getText().equals(""))
        createSubunitateDG("D");
        else {
            createSubunitateDG("D");
            createSubunitateDG("R");
        }
    }

    private static void createSubunitateDG(@NotNull String RD) {
        ArrayList <String> toReplace = new ArrayList<>();
        toReplace.add("numarlucrare");
        toReplace.add("datacurenta");
        toReplace.add("unitate01");
        toReplace.add("unitate02");
        toReplace.add("datalucrare");
        toReplace.add("denumiresocietate");
        toReplace.add("sediusocietate");
        toReplace.add("motivsolicitarepj");
        toReplace.add("nume01");
        toReplace.add("nume02");
        toReplace.add("adresadomiciliu");
        toReplace.add("cnpsolicitant");
        toReplace.add("telefonsolicitant");
        toReplace.add("datalimitaraspuns");

        ArrayList <String> newValues = new ArrayList<>();
        newValues.add(PanelDatePersoanaFizica.tfNrLucrare.getText());
        newValues.add(Service.currentDateValue());

        if (RD.equals("D")) {
            newValues.add(PanelDatePersoanaFizica.tfUnitateDomiciliu.getText());
            newValues.add(PanelDatePersoanaFizica.tfSubunitateDomiciliu.getText());
        } else if (RD.equals("R")) {
            newValues.add(PanelDatePersoanaFizica.tfUnitateResedinta.getText());
            newValues.add(PanelDatePersoanaFizica.tfSubunitateresedinta.getText());
        }
        newValues.add(PanelDatePersoanaFizica.tfDataLucrare.getText());
        newValues.add(PanelDatePersoanaJuridica.tfDenumireSocietate.getText());
        if (!PanelDatePersoanaJuridica.tfPLSocietate.getText().equals("")){
            newValues.add(PanelDatePersoanaJuridica.tfSediuSocietate.getText());
        } else {
            newValues.add(PanelDatePersoanaJuridica.tfSediuSocietate.getText()+" și punct de lucru în " + PanelDatePersoanaJuridica.tfPLSocietate.getText());
        }
        if(PanelMainScreen.tipLucrare.equals("DOT")){
            newValues.add("dotării cu armament letal / neletal");
        } else {
            newValues.add("ca gestionar armament și muniție");
        }
        newValues.add(PanelDatePersoanaFizica.tfNumeSolicitant.getText());
        newValues.add(PanelDatePersoanaFizica.tfPrenumeSolicitant.getText());
        if (PanelDatePersoanaFizica.tfResedintaSolicintant.getText().equals("")) {
            newValues.add(PanelDatePersoanaFizica.tfDomiciliuSolicitant.getText());
        } else {
            newValues.add(PanelDatePersoanaFizica.tfDomiciliuSolicitant.getText() + " și reședință în " + PanelDatePersoanaFizica.tfResedintaSolicintant.getText());
        }
        newValues.add(PanelDatePersoanaFizica.tfCNPSolicitant.getText());
        newValues.add(PanelDatePersoanaFizica.tfTelefonSolicitant.getText());
        newValues.add(Service.getLimitDate());

        if (RD.equals("D")) {
            if(!PanelDatePersoanaFizica.chckbxDomAltJud.isSelected()){
                WordDocService.replace(Service.getPath("adresaSubunitateGDV01.docx"), StringsValue.currentFolder+"/Adresa_subunitate"+RD+".docx", toReplace, newValues);
            } else {
                WordDocService.replace(Service.getPath("adresaSubunitateGDV02.docx"), StringsValue.currentFolder+"/Adresa_subunitate"+RD+".docx", toReplace, newValues);
            }
        } else if (RD.equals("R")) {
            if(!PanelDatePersoanaFizica.chckbxResAltJud.isSelected()){
                WordDocService.replace(Service.getPath("adresaSubunitateGDV01.docx"), StringsValue.currentFolder+"/Adresa_subunitate"+RD+".docx", toReplace, newValues);
            } else {
                WordDocService.replace(Service.getPath("adresaSubunitateGDV02.docx"), StringsValue.currentFolder+"/Adresa_subunitate"+RD+".docx", toReplace, newValues);
            }
        }

        correctDocForSexWords(StringsValue.currentFolder+"/Adresa_subunitate"+RD+".docx");
    }

    public static void createDocumentsFinalizareLucrareDG() {

        ArrayList <String> toReplace = new ArrayList<>();
        toReplace.add("numarlucrare");
        toReplace.add("datacurenta");
        toReplace.add("nume01");
        toReplace.add("nume02");
        toReplace.add("motivsolicitarepj");
        toReplace.add("datalucrare");
        toReplace.add("denumiresocietate");
        toReplace.add("sediusocietate");
        toReplace.add("adresadomiciliu");
        toReplace.add("cnpsolicitant");
        toReplace.add("emitentatestat");
        toReplace.add("dataatestat");
        toReplace.add("serienratestat");
        toReplace.add("datacurs");
        toReplace.add("emitentcurs");
        toReplace.add("unitate01");
        toReplace.add("unitate02");
        toReplace.add("cadrullegalgd");
        toReplace.add("motsolpjrasp");


        ArrayList<String> newValues = new ArrayList<>();
        try {
            newValues.add(PanelDatePersoanaFizica.tfNrLucrare.getText());
            newValues.add(Service.currentDateValue());
            newValues.add(PanelDatePersoanaFizica.tfNumeSolicitant.getText());
            newValues.add(PanelDatePersoanaFizica.tfPrenumeSolicitant.getText());
            if(PanelMainScreen.tipLucrare.equals("DOT")){
                newValues.add("dotării cu armament letal / neletal");
            } else {
                newValues.add("ca gestionar armament și muniție");
            }
            newValues.add(PanelDatePersoanaFizica.tfDataLucrare.getText());
            newValues.add(PanelDatePersoanaJuridica.tfDenumireSocietate.getText());
            if (!PanelDatePersoanaJuridica.tfPLSocietate.getText().equals("")){
                newValues.add(PanelDatePersoanaJuridica.tfSediuSocietate.getText());
            } else {
                newValues.add(PanelDatePersoanaJuridica.tfSediuSocietate.getText()+" și punct de lucru în " + PanelDatePersoanaJuridica.tfPLSocietate.getText());
            }
            newValues.add(PanelDatePersoanaFizica.tfDomiciliuSolicitant.getText());
            newValues.add(PanelDatePersoanaFizica.tfCNPSolicitant.getText());
            newValues.add(PanelDatePersoanaJuridica.tfEmitentAtestat.getText());
            newValues.add(PanelDatePersoanaJuridica.tfDataAtestat.getText());
            newValues.add(PanelDatePersoanaJuridica.tfNrSerieAtestat.getText());
            newValues.add(PanelDatePersoanaJuridica.tfDataCurs.getText());
            newValues.add(PanelDatePersoanaJuridica.tfEmitentCurs.getText());
            newValues.add(PanelDatePersoanaFizica.tfUnitateDomiciliu.getText());
            newValues.add(PanelDatePersoanaFizica.tfSubunitateDomiciliu.getText());
            if(PanelMainScreen.tipLucrare.equals("DOT")){
                newValues.add(StringsValue.cadruLegalDotare);
            } else {
                newValues.add(StringsValue.cadruLegalGestionar);
            }
            if(PanelMainScreen.tipLucrare.equals("DOT")){
                newValues.add("dotarea cu armament letal / neletal");
            } else {
                newValues.add("ca gestionar armament și muniție");
            }

            if(PanelMainScreen.tipLucrare.equals("DOT")){
                WordDocService.replace(Service.getPath("RaportFinalDotare.docx"), StringsValue.currentFolder + "/Raport_Final.docx", toReplace, newValues);
            }else {
                WordDocService.replace(Service.getPath("RaportFinalGestionar.docx"), StringsValue.currentFolder + "/Raport_Final.docx", toReplace, newValues);
            }


            WordDocService.replace(Service.getPath("adresaRaspunsDG.docx"), StringsValue.currentFolder + "/Adresa_Raspuns.docx", toReplace, newValues);

            if(PanelMainScreen.tipLucrare.equals("GES")){
                WordDocService.deleteParagraph(StringsValue.currentFolder + "/Raport_Final.docx", StringsValue.mentiuneAtestat);
            }
            correctDocForSexWords(StringsValue.currentFolder + "/Raport_Final.docx");
            correctDocForSexWords(StringsValue.currentFolder + "/Adresa_Raspuns.docx");

            JOptionPane.showMessageDialog(null, "Raportul de finalizare a lucrării a fost generat cu succes");
        } catch (NullPointerException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: "+ e);
        }

    }
}
