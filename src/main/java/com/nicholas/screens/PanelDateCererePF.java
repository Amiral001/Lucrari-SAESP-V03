package com.nicholas.screens;

import com.nicholas.JFrameFactore;
import com.nicholas.data.DataBase;
import com.nicholas.entitys.Lucrare;
import com.nicholas.entitys.LucrarePersoanaFizica;
import com.nicholas.entitys.PersoanaFizica;
import com.nicholas.utils.FixedJComboBox;
import com.nicholas.utils.ModifiableJOptionPane;
import com.nicholas.utils.Service;
import com.nicholas.utils.WordDocService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Objects;

public class PanelDateCererePF extends JPanel {

    public  static PersoanaFizica pf; public static LucrarePersoanaFizica lpf;

    public static JLabel lblLetalaNeletala, lblLungaScurta, lblDestinaieArm, lblNumarCi_1_1, lblNumarCi_1_1_1_1, tfLetalaNeletala,
            tfScurtaLunga, tfDestinatieArma, tfRegimCerere, tfArmaLaDomiciliu;

    public static JComboBox letalaNeletalaComboBox, lungaScurtaComboBox, destinatieComboBox, regimCerereComboBox, armaLaDomiciliuComboBox;

    public static JButton btnSuspendaLucrare, btnFinalizareLucrare, btnVerificari, btnPreluareDatePersoane, btnPreluareDateLucrare;

    public static String motivSuspendareLucrare; public static JButton btnBack;


    public PanelDateCererePF() {
        setBounds(0, 0, 1200, 310);

        btnBack = new JButton("Back");
        btnBack.setBounds(1064, 210, 91, 72);
        btnBack.setIcon(Service.changeIconSize(new ImageIcon(Service.getPath("iconBack.png")), 100, 100));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame jf = JFrameFactore.getFrame();
                jf.getContentPane().removeAll();
                jf.getContentPane().add(PanelMainScreen.getInstance());
                jf.revalidate();
                jf.repaint();
            }
        });
        setLayout(null);
        add(btnBack);

        lblLetalaNeletala = new JLabel("Letala / Neletala :");
        lblLetalaNeletala.setBounds(10, 11, 196, 36);
        lblLetalaNeletala.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblLetalaNeletala);

        lblLungaScurta = new JLabel("Lungă / scurtă :");
        lblLungaScurta.setBounds(576, 11, 187, 36);
        lblLungaScurta.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblLungaScurta);

        lblDestinaieArm = new JLabel("Destinatie arma :");
        lblDestinaieArm.setBounds(10, 58, 196, 36);
        lblDestinaieArm.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblDestinaieArm);

        lblNumarCi_1_1 = new JLabel("Regim cerere :");
        lblNumarCi_1_1.setBounds(483, 58, 162, 36);
        lblNumarCi_1_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblNumarCi_1_1);

        lblNumarCi_1_1_1_1 = new JLabel("Arma la domiciliu :");
        lblNumarCi_1_1_1_1.setBounds(848, 58, 206, 36);
        lblNumarCi_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblNumarCi_1_1_1_1);


        String[] letalaNeletala = {"neletală", "letală"};
        tfLetalaNeletala = new JLabel("neletală");
        letalaNeletalaComboBox = new FixedJComboBox(letalaNeletala);
        letalaNeletalaComboBox.setBounds(216, 13, 301, 33);
        letalaNeletalaComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(letalaNeletalaComboBox);
        letalaNeletalaComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == letalaNeletalaComboBox) {
                    tfLetalaNeletala.setText(Objects.requireNonNull(letalaNeletalaComboBox.getSelectedItem()).toString());
                }
            }
        });


        String[] lungaScurtaArray = {"scurtă", "lungă"};
        tfScurtaLunga = new JLabel("scurtă");
        lungaScurtaComboBox = new FixedJComboBox(lungaScurtaArray);
        lungaScurtaComboBox.setBounds(773, 13, 375, 33);
        lungaScurtaComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lungaScurtaComboBox);
        lungaScurtaComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == lungaScurtaComboBox) {
                    tfScurtaLunga.setText(Objects.requireNonNull(lungaScurtaComboBox.getSelectedItem()).toString());
                }
            }
        });


        String[] destinatie = {"autoapărare", "vânătoare", "tir sportiv", "apărare și pază", "colecție"};
        tfDestinatieArma = new JLabel("autoapărare");
        destinatieComboBox = new FixedJComboBox(destinatie);
        destinatieComboBox.setBounds(216, 60, 206, 33);
        destinatieComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(destinatieComboBox);
        destinatieComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == destinatieComboBox) {
                    tfDestinatieArma.setText(destinatieComboBox.getSelectedItem().toString());
                }
            }
        });


        String[] regimCerere = {"normal", "urgență"};
        tfRegimCerere = new JLabel("normal");
        regimCerereComboBox = new FixedJComboBox(regimCerere);
        regimCerereComboBox.setBounds(655, 60, 121, 33);
        regimCerereComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(regimCerereComboBox);
        regimCerereComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == regimCerereComboBox) {
                    tfRegimCerere.setText(Objects.requireNonNull(regimCerereComboBox.getSelectedItem()).toString());
                }
            }
        });

        String[] DaNu2 = {"Da", "Nu"};
		tfArmaLaDomiciliu = new JLabel("Da");
        armaLaDomiciliuComboBox = new FixedJComboBox(DaNu2);
        armaLaDomiciliuComboBox.setBounds(1084, 60, 65, 33);
        armaLaDomiciliuComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(armaLaDomiciliuComboBox);
        armaLaDomiciliuComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == armaLaDomiciliuComboBox) {
                    tfArmaLaDomiciliu.setText(armaLaDomiciliuComboBox.getSelectedItem().toString());
                }
            }
        });


        btnVerificari = new JButton("Genereaza documentatie verificari");
        btnVerificari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pf = new PersoanaFizica();
                lpf = new LucrarePersoanaFizica();

                if (!(PanelDatePersoanaFizica.tfNrLucrare.getText().equals("") || PanelDatePersoanaFizica.tfDataLucrare.getText().equals("") ||
                        PanelDatePersoanaFizica.tfNumeSolicitant.getText().equals("") || PanelDatePersoanaFizica.tfPrenumeSolicitant.getText().equals("")
                        || PanelDatePersoanaFizica.tfCNPSolicitant.getText().equals(""))) {

                    pf.setNume(PanelDatePersoanaFizica.tfNumeSolicitant.getText()); pf.setPrenume(PanelDatePersoanaFizica.tfPrenumeSolicitant.getText());
                    pf.setCnp(PanelDatePersoanaFizica.tfCNPSolicitant.getText()); pf.setAdresaDomiciliu(PanelDatePersoanaFizica.tfDomiciliuSolicitant.getText());
                    pf.setUnitate01(PanelDatePersoanaFizica.tfUnitateDomiciliu.getText()); pf.setSubunitate01(PanelDatePersoanaFizica.tfSubunitateDomiciliu.getText());
                    pf.setAdresaResedinta(PanelDatePersoanaFizica.tfResedintaSolicintant.getText()); pf.setUnitate02(PanelDatePersoanaFizica.tfUnitateResedinta.getText());
                    pf.setSubunitate02(PanelDatePersoanaFizica.tfSubunitateresedinta.getText()); pf.setNumarTelefon(PanelDatePersoanaFizica.tfTelefonSolicitant.getText());
                    pf.setSerieCI(PanelDatePersoanaFizica.tfSerieCI.getText()); pf.setNrCI(PanelDatePersoanaFizica.tfNrCI.getText());

                    lpf.setTipLucrare(PanelMainScreen.tipLucrare); lpf.setLetalaNeletala(tfLetalaNeletala.getText());
                    lpf.setLungaScurta(tfScurtaLunga.getText()); lpf.setDestinatieArma(tfDestinatieArma.getText());
                    lpf.setRegimCerere(tfRegimCerere.getText()); lpf.setPersoanaFizica(pf);

                    pf.setDomAltJud(PanelDatePersoanaFizica.chckbxDomAltJud.isSelected() ? "Da" : "Nu");
                    pf.setResAltJud(PanelDatePersoanaFizica.chckbxResAltJud.isSelected() ? "Da" : "Nu");
                    lpf.setArmaLaDomiciliu(tfArmaLaDomiciliu.getText()); lpf.setNrLucrare(PanelDatePersoanaFizica.tfNrLucrare.getText());
                    lpf.setDataLucrare(Service.stringToDate(PanelDatePersoanaFizica.tfDataLucrare.getText()));
                    lpf.setLucratorSAESP(PanelDatePersoanaFizica.tfLucratorSAESP.getText());

                    DataBase.addLucrare(lpf); DataBase.addPersoanaFizica(pf);

                    switch (PanelMainScreen.tipLucrare) {
                        case "PA":
                            WordDocService.createDocumentsVerificariPA();
                            break;
                        case "ADA":
                            WordDocService.createDocumentsVerificariADA();
                            break;
                        case "V":
                            WordDocService.createDocumentsVerificariViza();
                            break;
                        case "D":
                        case "R":
                            WordDocService.createDocumentsVerificariDR();
                            break;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Atentie! Nu au fost completate corect campurile din formular");
                }
            }
        });
        btnVerificari.setBounds(10, 152, 570, 36);
        btnVerificari.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(btnVerificari);

        btnSuspendaLucrare = new JButton("Suspenda lucrarea");
        btnSuspendaLucrare.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    motivSuspendareLucrare = ModifiableJOptionPane.showInputDialog(JFrameFactore.getFrame(),"Introduceți motivul!");
                WordDocService.createRaportSuspendareLucrare();
        	}
        });
        btnSuspendaLucrare.setBounds(10, 199, 570, 36);
        btnSuspendaLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(btnSuspendaLucrare);

        btnFinalizareLucrare = new JButton("Finalizare lucrare");
        btnFinalizareLucrare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (PanelMainScreen.tipLucrare) {
                    case "PA":
                    case "ADA":
                        WordDocService.createRaportFinalizareLucrarePAsiADA();
                        break;
                    case "V":
                    case "D":
                    case "R":
                        WordDocService.createDocumentsFinalizareLucrareVDR();
                        break;
                }
            }
        });
        btnFinalizareLucrare.setBounds(10, 246, 570, 36);
        btnFinalizareLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(btnFinalizareLucrare);


        btnPreluareDatePersoane = new JButton("Date privind persoana");
        btnPreluareDatePersoane.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!DataBase.getPersoaneFizice().isEmpty()) {
                    ArrayList<String> optionsArrayList = new ArrayList<>();
                    String result = null;
                    PersoanaFizica pfs = null;
                    for (PersoanaFizica pf : DataBase.getPersoaneFizice()) {
                        optionsArrayList.add(pf.getNume() + " " + pf.getPrenume());
                    }
                    Object[] optionsArray = optionsArrayList.toArray();
                    try {
                        result = (String) JOptionPane.showInputDialog(JFrameFactore.getFrame(), "Selecteaza persoana", "", JOptionPane.PLAIN_MESSAGE, null, optionsArray, optionsArray[0]);
                        for (PersoanaFizica pf : DataBase.getPersoaneFizice()) {
                            if (result != null && result.equals(pf.getNume() + " " + pf.getPrenume())) {
                                pfs = pf;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException | NullPointerException exeption) {
                        exeption.printStackTrace();
                    }
                    if (result != null) {
                        assert pfs != null;
                        PanelDatePersoanaFizica.tfNumeSolicitant.setText(pfs.getNume());
                        PanelDatePersoanaFizica.tfPrenumeSolicitant.setText(pfs.getPrenume());
                        PanelDatePersoanaFizica.tfCNPSolicitant.setText(pfs.getCnp());
                        PanelDatePersoanaFizica.tfDomiciliuSolicitant.setText(pfs.getAdresaDomiciliu());
                        PanelDatePersoanaFizica.tfUnitateDomiciliu.setText(pfs.getUnitate01());
                        PanelDatePersoanaFizica.tfSubunitateDomiciliu.setText(pfs.getSubunitate01());
                        PanelDatePersoanaFizica.tfResedintaSolicintant.setText(pfs.getAdresaResedinta());
                        PanelDatePersoanaFizica.tfUnitateResedinta.setText(pfs.getUnitate02());
                        PanelDatePersoanaFizica.tfSubunitateresedinta.setText(pfs.getSubunitate02());
                        PanelDatePersoanaFizica.tfTelefonSolicitant.setText(pfs.getNumarTelefon());
                        PanelDatePersoanaFizica.tfSerieCI.setText(pfs.getSerieCI());
                        PanelDatePersoanaFizica.tfNrCI.setText(pfs.getNrCI());
                        if (pfs.getDomAltJud().equals("Da")) {
                            PanelDatePersoanaFizica.chckbxDomAltJud.setSelected(true);
                        } else if (pfs.getResAltJud().equals("Da")){
                            PanelDatePersoanaFizica.chckbxResAltJud.setSelected(true);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nu sunt inregistrate informatii in istoric!");
                }
            }
        });
        btnPreluareDatePersoane.setFont(new Font("Times New Roman", Font.BOLD, 24));
        btnPreluareDatePersoane.setBounds(606, 175, 448, 36);
        add(btnPreluareDatePersoane);


        btnPreluareDateLucrare = new JButton("Date privind lucrarea");
        btnPreluareDateLucrare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!DataBase.getLucrari().isEmpty()) {

                    ArrayList<String> optionsArrayList = new ArrayList<>();
                    String result = null;
                    LucrarePersoanaFizica lpfs = null;

                    for (Lucrare lpf : DataBase.getLucrari()) {
                        optionsArrayList.add(lpf.getNrLucrare());
                    }
                    Object[] optionsArray = optionsArrayList.toArray();
                    try {
                        result = (String) JOptionPane.showInputDialog(JFrameFactore.getFrame(), "Selecteaza lucrare", "", JOptionPane.PLAIN_MESSAGE, null, optionsArray, optionsArray[0]);
                    } catch (ArrayIndexOutOfBoundsException | NullPointerException exeption) {
                        exeption.printStackTrace();
                    }
                    for (Lucrare lpf : DataBase.getLucrari()) {
                        if (result != null && result.equals(lpf.getNrLucrare())) {
                            try{
                            lpfs = (LucrarePersoanaFizica) lpf;} catch (ClassCastException exception){
                                exception.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Eroare: Lucrarea selectată este din rândul celor pentru persoane juridice și nu fizice!");
                            }
                        }
                    }
                    if (result != null) {
                        assert lpfs != null;
                        PanelDatePersoanaFizica.tfNrLucrare.setText(lpfs.getNrLucrare());
                        PanelDatePersoanaFizica.tfDataLucrare.setText(Service.dateToString(lpfs.getDataLucrare()));
                        PanelDatePersoanaFizica.tfLucratorSAESP.setText(lpfs.getLucratorSAESP());
                        PanelDatePersoanaFizica.tfNumeSolicitant.setText(lpfs.getPersoanaFizica().getNume());
                        PanelDatePersoanaFizica.tfPrenumeSolicitant.setText(lpfs.getPersoanaFizica().getPrenume());
                        PanelDatePersoanaFizica.tfCNPSolicitant.setText(lpfs.getPersoanaFizica().getCnp());
                        PanelDatePersoanaFizica.tfDomiciliuSolicitant.setText(lpfs.getPersoanaFizica().getAdresaDomiciliu());
                        PanelDatePersoanaFizica.tfUnitateDomiciliu.setText(lpfs.getPersoanaFizica().getUnitate01());
                        PanelDatePersoanaFizica.tfSubunitateDomiciliu.setText(lpfs.getPersoanaFizica().getSubunitate01());
                        PanelDatePersoanaFizica.tfResedintaSolicintant.setText(lpfs.getPersoanaFizica().getAdresaResedinta());
                        PanelDatePersoanaFizica.tfUnitateResedinta.setText(lpfs.getPersoanaFizica().getUnitate02());
                        PanelDatePersoanaFizica.tfSubunitateresedinta.setText(lpfs.getPersoanaFizica().getSubunitate02());
                        PanelDatePersoanaFizica.tfTelefonSolicitant.setText(lpfs.getPersoanaFizica().getNumarTelefon());
                        PanelDatePersoanaFizica.tfSerieCI.setText(lpfs.getPersoanaFizica().getSerieCI());
                        PanelDatePersoanaFizica.tfNrCI.setText(lpfs.getPersoanaFizica().getNrCI());
                        if (lpfs.getPersoanaFizica().getDomAltJud().equals("Da")) {
                            PanelDatePersoanaFizica.chckbxDomAltJud.setSelected(true);
                        } else if (lpfs.getPersoanaFizica().getResAltJud().equals("Da")){
                            PanelDatePersoanaFizica.chckbxResAltJud.setSelected(true);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nu sunt inregistrate informatii in istoric!");
                }
            }
        });
        btnPreluareDateLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
        btnPreluareDateLucrare.setBounds(606, 222, 448, 36);
        add(btnPreluareDateLucrare);
        
        revalidate();
        repaint();

    }

}
