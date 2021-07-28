package com.nicholas.screens;

import com.nicholas.JFrameFactore;
import com.nicholas.data.DataBase;
import com.nicholas.entitys.Lucrare;
import com.nicholas.entitys.LucrarePersoanaFizica;
import com.nicholas.entitys.PersoanaFizica;
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

public class DateCererePF extends JPanel {

    public  static PersoanaFizica pf; public static Lucrare lucrare; public static LucrarePersoanaFizica lpf;

    public static JLabel lblLetalaNeletala, lblLungaScurta, lblDestinaieArm, lblNumarCi_1_1, lblDomiciliuInAlt, lblNumarCi_1_1_1, lblNumarCi_1_1_1_1, labelLetala,
            labelLunga, labelDestinatie, labelCerere, labelDomiciliuAltJudet, labelResedintaAltJudet, labelArmaLaDomiciliu;

    public static JComboBox letalaNeletalaComboBox, lungaScurtaComboBox, destinatieComboBox, regimCerereComboBox, domiciliuAltJudetComboBox, resedintaAltJudetComboBox, armaLaDomiciliuComboBox;

    public static JButton btnSuspendaLucrare, btnFinalizareLucrare, btnVerificari, btnPreluareDatePersoane, btnPreluareDateLucrare;

    public static String motivSuspendareLucrare; public static JButton btnBack;


    public DateCererePF() {
        setBounds(0, 0, 1200, 310);

        btnBack = new JButton("Back");
        btnBack.setBounds(1064, 210, 91, 72);
        btnBack.setIcon(Service.changeIconSize(new ImageIcon(Service.getPath("iconBack.png")), 100, 100));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame jf = JFrameFactore.getFrame();
                jf.getContentPane().removeAll();
                jf.getContentPane().add(MainScreen.getInstance());
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
        lblDestinaieArm.setBounds(10, 58, 218, 36);
        lblDestinaieArm.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblDestinaieArm);

        lblNumarCi_1_1 = new JLabel("Regim cerere :");
        lblNumarCi_1_1.setBounds(576, 58, 187, 36);
        lblNumarCi_1_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblNumarCi_1_1);

        lblDomiciliuInAlt = new JLabel("Domiciliu in alt județ:");
        lblDomiciliuInAlt.setBounds(10, 105, 236, 36);
        lblDomiciliuInAlt.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblDomiciliuInAlt);

        lblNumarCi_1_1_1 = new JLabel("Reședință în alt județ :");
        lblNumarCi_1_1_1.setBounds(390, 105, 236, 36);
        lblNumarCi_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblNumarCi_1_1_1);

        lblNumarCi_1_1_1_1 = new JLabel("Arma pastrata la domiciliu :");
        lblNumarCi_1_1_1_1.setBounds(769, 105, 301, 36);
        lblNumarCi_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblNumarCi_1_1_1_1);


        String[] letalaNeletala = {"letală", "neletală"};
        labelLetala = new JLabel("letală");
        letalaNeletalaComboBox = new JComboBox(letalaNeletala);
        letalaNeletalaComboBox.setBounds(216, 13, 301, 33);
        letalaNeletalaComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == letalaNeletalaComboBox) {
                    labelLetala.setText(Objects.requireNonNull(letalaNeletalaComboBox.getSelectedItem()).toString());
                }
            }
        });
        letalaNeletalaComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(letalaNeletalaComboBox);


        String[] lungaScurtaArray = {"scurtă", "lungă"};
        labelLunga = new JLabel("scurtă");
        lungaScurtaComboBox = new JComboBox(lungaScurtaArray);
        lungaScurtaComboBox.setBounds(773, 13, 382, 33);
        lungaScurtaComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == lungaScurtaComboBox) {
                    labelLetala.setText(Objects.requireNonNull(lungaScurtaComboBox.getSelectedItem()).toString());
                }
            }
        });
        lungaScurtaComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lungaScurtaComboBox);


        String[] destinatie = {"autoapărare", "vânătoare", "tir sportiv", "apărare și pază", "colecție"};
        labelDestinatie = new JLabel("autoapărare");
        destinatieComboBox = new JComboBox(destinatie);
        destinatieComboBox.setBounds(216, 60, 301, 33);
        destinatieComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == destinatieComboBox) {
                    labelDestinatie.setText(destinatieComboBox.getSelectedItem().toString());
                }
            }
        });
        destinatieComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(destinatieComboBox);


        String[] regimCerere = {"normal", "urgență"};
        labelCerere = new JLabel("normal");
        regimCerereComboBox = new JComboBox(regimCerere);
        regimCerereComboBox.setBounds(773, 60, 382, 33);
        regimCerereComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == regimCerereComboBox) {
                    labelCerere.setText(Objects.requireNonNull(regimCerereComboBox.getSelectedItem()).toString());
                }
            }
        });
        regimCerereComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(regimCerereComboBox);


        String[] DaNu = {"Nu", "Da"};
        labelDomiciliuAltJudet = new JLabel("Nu");
        domiciliuAltJudetComboBox = new JComboBox(DaNu);
        domiciliuAltJudetComboBox.setBounds(256, 107, 75, 33);
        domiciliuAltJudetComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == domiciliuAltJudetComboBox) {
                    labelDomiciliuAltJudet.setText(Objects.requireNonNull(domiciliuAltJudetComboBox.getSelectedItem()).toString());
                }
            }
        });
        domiciliuAltJudetComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(domiciliuAltJudetComboBox);

        labelResedintaAltJudet = new JLabel("Nu");
        resedintaAltJudetComboBox = new JComboBox(DaNu);
        resedintaAltJudetComboBox.setBounds(636, 105, 75, 33);
        resedintaAltJudetComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == resedintaAltJudetComboBox) {
                    labelResedintaAltJudet.setText(Objects.requireNonNull(resedintaAltJudetComboBox.getSelectedItem()).toString());
                }
            }
        });
        resedintaAltJudetComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(resedintaAltJudetComboBox);

        String[] DaNu2 = {"Da", "Nu"};
		labelArmaLaDomiciliu = new JLabel("Da");
        armaLaDomiciliuComboBox = new JComboBox(DaNu2);
        armaLaDomiciliuComboBox.setBounds(1080, 107, 75, 33);
        armaLaDomiciliuComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == armaLaDomiciliuComboBox) {
                    labelArmaLaDomiciliu.setText(armaLaDomiciliuComboBox.getSelectedItem().toString());
                }
            }
        });
        armaLaDomiciliuComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(armaLaDomiciliuComboBox);


        btnVerificari = new JButton("Genereaza documentatie verificari");
        btnVerificari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pf = new PersoanaFizica();
                lpf = new LucrarePersoanaFizica();

                if (!(DatePersoanaPanel.tfNrLucrare.getText().equals("") || DatePersoanaPanel.tfDataLucrare.getText().equals("") ||
                        DatePersoanaPanel.tfNumeSolicitant.getText().equals("") || DatePersoanaPanel.tfPrenumeSolicitant.getText().equals("")
                        || DatePersoanaPanel.tfCNPSolicitant.getText().equals(""))) {

                    pf.setNume(DatePersoanaPanel.tfNumeSolicitant.getText()); pf.setPrenume(DatePersoanaPanel.tfPrenumeSolicitant.getText());
                    pf.setCnp(DatePersoanaPanel.tfCNPSolicitant.getText()); pf.setAdresaDomiciliu(DatePersoanaPanel.tfDomiciliuSolicitant.getText());
                    pf.setUnitate01(DatePersoanaPanel.tfUnitateDomiciliu.getText()); pf.setSubunitate01(DatePersoanaPanel.tfSubunitateDomiciliu.getText());
                    pf.setAdresaResedinta(DatePersoanaPanel.tfResedintaSolicintant.getText()); pf.setUnitate02(DatePersoanaPanel.tfUnitateResedinta.getText());
                    pf.setSubunitate02(DatePersoanaPanel.tfSubunitateresedinta.getText()); pf.setNumarTelefon(DatePersoanaPanel.tfTelefonSolicitant.getText());
                    pf.setSerieCI(DatePersoanaPanel.tfSerieCI.getText()); pf.setNrCI(DatePersoanaPanel.tfNrCI.getText());

                    lpf.setTipLucrare(MainScreen.tipLucrare); lpf.setLetalaNeletala(labelLetala.getText());
                    lpf.setLungaScurta(labelLunga.getText()); lpf.setDestinatieArma(labelDestinatie.getText());
                    lpf.setRegimCerere(labelCerere.getText()); lpf.setPersoanaFizica(pf);
                    lpf.setDomiciliulAltJudet(labelDomiciliuAltJudet.getText()); lpf.setResedintaAltJudet(labelResedintaAltJudet.getText());
                    lpf.setArmaLaDomiciliu(labelArmaLaDomiciliu.getText()); lpf.setNrLucrare(DatePersoanaPanel.tfNrLucrare.getText());
                    lpf.setDataLucrare(Service.stringToDate(DatePersoanaPanel.tfDataLucrare.getText()));
                    lpf.setLucratorSAESP(DatePersoanaPanel.tfLucratorSAESP.getText());

                    DataBase.addLucrare(lpf); DataBase.addPersoanaFizica(pf);

                    switch (MainScreen.tipLucrare) {
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
                WordDocService.createDocumentsSuspendareLucrare();
        	}
        });
        btnSuspendaLucrare.setBounds(10, 199, 570, 36);
        btnSuspendaLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(btnSuspendaLucrare);

        btnFinalizareLucrare = new JButton("Finalizare lucrare");
        btnFinalizareLucrare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (MainScreen.tipLucrare) {
                    case "PA":
                    case "ADA":
                        WordDocService.createDocumentsFinalizareLucrarePAsiADA();
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
                        DatePersoanaPanel.tfNumeSolicitant.setText(pfs.getNume());
                        DatePersoanaPanel.tfPrenumeSolicitant.setText(pfs.getPrenume());
                        DatePersoanaPanel.tfCNPSolicitant.setText(pfs.getCnp());
                        DatePersoanaPanel.tfDomiciliuSolicitant.setText(pfs.getAdresaDomiciliu());
                        DatePersoanaPanel.tfUnitateDomiciliu.setText(pfs.getUnitate01());
                        DatePersoanaPanel.tfSubunitateDomiciliu.setText(pfs.getSubunitate01());
                        DatePersoanaPanel.tfResedintaSolicintant.setText(pfs.getAdresaResedinta());
                        DatePersoanaPanel.tfUnitateResedinta.setText(pfs.getUnitate02());
                        DatePersoanaPanel.tfSubunitateresedinta.setText(pfs.getSubunitate02());
                        DatePersoanaPanel.tfTelefonSolicitant.setText(pfs.getNumarTelefon());
                        DatePersoanaPanel.tfSerieCI.setText(pfs.getSerieCI());
                        DatePersoanaPanel.tfNrCI.setText(pfs.getNrCI());
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
                    } catch (ArrayIndexOutOfBoundsException exeption) {
                        exeption.printStackTrace();
                    }
                    for (Lucrare lpf : DataBase.getLucrari()) {
                        if (result != null && result.equals(lpf.getNrLucrare())) {
                            lpfs = (LucrarePersoanaFizica) lpf;
                        }
                    }
                    if (result != null) {
                        assert lpfs != null;
                        DatePersoanaPanel.tfNrLucrare.setText(lpfs.getNrLucrare());
                        DatePersoanaPanel.tfDataLucrare.setText(Service.dateToString(lpfs.getDataLucrare()));
                        DatePersoanaPanel.tfLucratorSAESP.setText(lpfs.getLucratorSAESP());
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
