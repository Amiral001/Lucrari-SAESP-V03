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

public class PanelDateCererePF extends JPanel {

    public  static PersoanaFizica pf; public static LucrarePersoanaFizica lpf;

    public static JLabel lblLetalaNeletala, lblLungaScurta, lblDestinaieArm, lblNumarCi_1_1, lblDomiciliuInAlt, lblNumarCi_1_1_1, lblNumarCi_1_1_1_1, tfLetalaNeletala,
            tfScurtaLunga, tfDestinatieArma, tfRegimCerere, tfDomInAltJud, tfResInAltJud, tfArmaLaDomiciliu;

    public static JComboBox letalaNeletalaComboBox, lungaScurtaComboBox, destinatieComboBox, regimCerereComboBox, domiciliuAltJudetComboBox, resedintaAltJudetComboBox, armaLaDomiciliuComboBox;

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
        tfLetalaNeletala = new JLabel("letală");
        letalaNeletalaComboBox = new JComboBox(letalaNeletala);
        letalaNeletalaComboBox.setBounds(216, 13, 301, 33);
        letalaNeletalaComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == letalaNeletalaComboBox) {
                    tfLetalaNeletala.setText(Objects.requireNonNull(letalaNeletalaComboBox.getSelectedItem()).toString());
                }
            }
        });
        letalaNeletalaComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(letalaNeletalaComboBox);


        String[] lungaScurtaArray = {"scurtă", "lungă"};
        tfScurtaLunga = new JLabel("scurtă");
        lungaScurtaComboBox = new JComboBox(lungaScurtaArray);
        lungaScurtaComboBox.setBounds(773, 13, 382, 33);
        lungaScurtaComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == lungaScurtaComboBox) {
                    tfLetalaNeletala.setText(Objects.requireNonNull(lungaScurtaComboBox.getSelectedItem()).toString());
                }
            }
        });
        lungaScurtaComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lungaScurtaComboBox);


        String[] destinatie = {"autoapărare", "vânătoare", "tir sportiv", "apărare și pază", "colecție"};
        tfDestinatieArma = new JLabel("autoapărare");
        destinatieComboBox = new JComboBox(destinatie);
        destinatieComboBox.setBounds(216, 60, 301, 33);
        destinatieComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == destinatieComboBox) {
                    tfDestinatieArma.setText(destinatieComboBox.getSelectedItem().toString());
                }
            }
        });
        destinatieComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(destinatieComboBox);


        String[] regimCerere = {"normal", "urgență"};
        tfRegimCerere = new JLabel("normal");
        regimCerereComboBox = new JComboBox(regimCerere);
        regimCerereComboBox.setBounds(773, 60, 382, 33);
        regimCerereComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == regimCerereComboBox) {
                    tfRegimCerere.setText(Objects.requireNonNull(regimCerereComboBox.getSelectedItem()).toString());
                }
            }
        });
        regimCerereComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(regimCerereComboBox);


        String[] DaNu = {"Nu", "Da"};
        tfDomInAltJud = new JLabel("Nu");
        domiciliuAltJudetComboBox = new JComboBox(DaNu);
        domiciliuAltJudetComboBox.setBounds(256, 107, 75, 33);
        domiciliuAltJudetComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == domiciliuAltJudetComboBox) {
                    tfDomInAltJud.setText(Objects.requireNonNull(domiciliuAltJudetComboBox.getSelectedItem()).toString());
                }
            }
        });
        domiciliuAltJudetComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(domiciliuAltJudetComboBox);

        tfResInAltJud = new JLabel("Nu");
        resedintaAltJudetComboBox = new JComboBox(DaNu);
        resedintaAltJudetComboBox.setBounds(636, 105, 75, 33);
        resedintaAltJudetComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == resedintaAltJudetComboBox) {
                    tfResInAltJud.setText(Objects.requireNonNull(resedintaAltJudetComboBox.getSelectedItem()).toString());
                }
            }
        });
        resedintaAltJudetComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(resedintaAltJudetComboBox);

        String[] DaNu2 = {"Da", "Nu"};
		tfArmaLaDomiciliu = new JLabel("Da");
        armaLaDomiciliuComboBox = new JComboBox(DaNu2);
        armaLaDomiciliuComboBox.setBounds(1080, 107, 75, 33);
        armaLaDomiciliuComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == armaLaDomiciliuComboBox) {
                    tfArmaLaDomiciliu.setText(armaLaDomiciliuComboBox.getSelectedItem().toString());
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

                if (!(PanelDatePersoana.tfNrLucrare.getText().equals("") || PanelDatePersoana.tfDataLucrare.getText().equals("") ||
                        PanelDatePersoana.tfNumeSolicitant.getText().equals("") || PanelDatePersoana.tfPrenumeSolicitant.getText().equals("")
                        || PanelDatePersoana.tfCNPSolicitant.getText().equals(""))) {

                    pf.setNume(PanelDatePersoana.tfNumeSolicitant.getText()); pf.setPrenume(PanelDatePersoana.tfPrenumeSolicitant.getText());
                    pf.setCnp(PanelDatePersoana.tfCNPSolicitant.getText()); pf.setAdresaDomiciliu(PanelDatePersoana.tfDomiciliuSolicitant.getText());
                    pf.setUnitate01(PanelDatePersoana.tfUnitateDomiciliu.getText()); pf.setSubunitate01(PanelDatePersoana.tfSubunitateDomiciliu.getText());
                    pf.setAdresaResedinta(PanelDatePersoana.tfResedintaSolicintant.getText()); pf.setUnitate02(PanelDatePersoana.tfUnitateResedinta.getText());
                    pf.setSubunitate02(PanelDatePersoana.tfSubunitateresedinta.getText()); pf.setNumarTelefon(PanelDatePersoana.tfTelefonSolicitant.getText());
                    pf.setSerieCI(PanelDatePersoana.tfSerieCI.getText()); pf.setNrCI(PanelDatePersoana.tfNrCI.getText());

                    lpf.setTipLucrare(PanelMainScreen.tipLucrare); lpf.setLetalaNeletala(tfLetalaNeletala.getText());
                    lpf.setLungaScurta(tfScurtaLunga.getText()); lpf.setDestinatieArma(tfDestinatieArma.getText());
                    lpf.setRegimCerere(tfRegimCerere.getText()); lpf.setPersoanaFizica(pf);
                    lpf.setDomiciliulAltJudet(tfDomInAltJud.getText()); lpf.setResedintaAltJudet(tfResInAltJud.getText());
                    lpf.setArmaLaDomiciliu(tfArmaLaDomiciliu.getText()); lpf.setNrLucrare(PanelDatePersoana.tfNrLucrare.getText());
                    lpf.setDataLucrare(Service.stringToDate(PanelDatePersoana.tfDataLucrare.getText()));
                    lpf.setLucratorSAESP(PanelDatePersoana.tfLucratorSAESP.getText());

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
                        PanelDatePersoana.tfNumeSolicitant.setText(pfs.getNume());
                        PanelDatePersoana.tfPrenumeSolicitant.setText(pfs.getPrenume());
                        PanelDatePersoana.tfCNPSolicitant.setText(pfs.getCnp());
                        PanelDatePersoana.tfDomiciliuSolicitant.setText(pfs.getAdresaDomiciliu());
                        PanelDatePersoana.tfUnitateDomiciliu.setText(pfs.getUnitate01());
                        PanelDatePersoana.tfSubunitateDomiciliu.setText(pfs.getSubunitate01());
                        PanelDatePersoana.tfResedintaSolicintant.setText(pfs.getAdresaResedinta());
                        PanelDatePersoana.tfUnitateResedinta.setText(pfs.getUnitate02());
                        PanelDatePersoana.tfSubunitateresedinta.setText(pfs.getSubunitate02());
                        PanelDatePersoana.tfTelefonSolicitant.setText(pfs.getNumarTelefon());
                        PanelDatePersoana.tfSerieCI.setText(pfs.getSerieCI());
                        PanelDatePersoana.tfNrCI.setText(pfs.getNrCI());
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
                            lpfs = (LucrarePersoanaFizica) lpf;
                        }
                    }
                    if (result != null) {
                        assert lpfs != null;
                        PanelDatePersoana.tfNrLucrare.setText(lpfs.getNrLucrare());
                        PanelDatePersoana.tfDataLucrare.setText(Service.dateToString(lpfs.getDataLucrare()));
                        PanelDatePersoana.tfLucratorSAESP.setText(lpfs.getLucratorSAESP());
                        PanelDatePersoana.tfNumeSolicitant.setText(lpfs.getPersoanaFizica().getNume());
                        PanelDatePersoana.tfPrenumeSolicitant.setText(lpfs.getPersoanaFizica().getPrenume());
                        PanelDatePersoana.tfCNPSolicitant.setText(lpfs.getPersoanaFizica().getCnp());
                        PanelDatePersoana.tfDomiciliuSolicitant.setText(lpfs.getPersoanaFizica().getAdresaDomiciliu());
                        PanelDatePersoana.tfUnitateDomiciliu.setText(lpfs.getPersoanaFizica().getUnitate01());
                        PanelDatePersoana.tfSubunitateDomiciliu.setText(lpfs.getPersoanaFizica().getSubunitate01());
                        PanelDatePersoana.tfResedintaSolicintant.setText(lpfs.getPersoanaFizica().getAdresaResedinta());
                        PanelDatePersoana.tfUnitateResedinta.setText(lpfs.getPersoanaFizica().getUnitate02());
                        PanelDatePersoana.tfSubunitateresedinta.setText(lpfs.getPersoanaFizica().getSubunitate02());
                        PanelDatePersoana.tfTelefonSolicitant.setText(lpfs.getPersoanaFizica().getNumarTelefon());
                        PanelDatePersoana.tfSerieCI.setText(lpfs.getPersoanaFizica().getSerieCI());
                        PanelDatePersoana.tfNrCI.setText(lpfs.getPersoanaFizica().getNrCI());
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
