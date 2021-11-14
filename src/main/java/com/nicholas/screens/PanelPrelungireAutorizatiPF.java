package com.nicholas.screens;

import com.nicholas.JFrameFactore;
import com.nicholas.data.DataBase;
import com.nicholas.entitys.Lucrare;
import com.nicholas.entitys.LucrarePersoanaFizica;
import com.nicholas.entitys.PersoanaFizica;
import com.nicholas.utils.FixedJComboBox;
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

public class PanelPrelungireAutorizatiPF extends JPanel {

    public  static PersoanaFizica pf; public static LucrarePersoanaFizica lpf;

    public static JTextField tfNrLucrare, tfDataLucrare, tfNumeSolicitant, tfPrenumeSolicitant, tfCNPSolicitant, tfDomiciliuSolicitant, tfSerieCI, tfNrCI, tfDataAutorizatie, tfNrSerieAutorizatie;

    public static JLabel lblNumarLucrare, lblDataLucrare, lblNume, lblPrenume, lblCNP, lblAdresaDomiciliu, lblSerieCi, lblNumarCi, sexSolicitant,
            tfLetalaNeletala, lblLetalaNeletala, tfDestinatieArma, lblDestinaieArm, lblDataAutorizatie;

    public static JCheckBox chckbxDomAltJud;
    public static FixedJComboBox letalaNeletalaComboBox, destinatieComboBox, sexSolicitantComboBox;
    public static JButton btnBack, btnPreluareDatePersoane, btnPreluareDateLucrare;


    public PanelPrelungireAutorizatiPF() {
        setLayout(null);
        setBounds(0, 0, 1200, 512);


        lblNumarLucrare = new JLabel("Numar lucrare :"); lblNumarLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNumarLucrare.setBounds(10, 11, 218, 36); add(lblNumarLucrare);

        tfNrLucrare = new JTextField(); tfNrLucrare.setBounds(206, 11, 392, 36); tfNrLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfNrLucrare.setHorizontalAlignment(SwingConstants.CENTER); add(tfNrLucrare); tfNrLucrare.setColumns(10);

        lblDataLucrare = new JLabel("Data lucrare :"); lblDataLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblDataLucrare.setBounds(608, 11, 151, 36); add(lblDataLucrare);

        tfDataLucrare = new JTextField(); tfDataLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfDataLucrare.setHorizontalAlignment(SwingConstants.CENTER); tfDataLucrare.setColumns(10); tfDataLucrare.setBounds(769, 12, 392, 36); add(tfDataLucrare);

        lblNume = new JLabel("Nume :"); lblNume.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNume.setBounds(10, 58, 181, 36); add(lblNume);

        tfNumeSolicitant = new JTextField(); tfNumeSolicitant.setHorizontalAlignment(SwingConstants.CENTER);
        tfNumeSolicitant.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfNumeSolicitant.setColumns(10);
        tfNumeSolicitant.setBounds(206, 58, 392, 36); add(tfNumeSolicitant);

        lblPrenume = new JLabel("Prenume :"); lblPrenume.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblPrenume.setBounds(608, 58, 123, 36); add(lblPrenume);

        tfPrenumeSolicitant = new JTextField(); tfPrenumeSolicitant.setHorizontalAlignment(SwingConstants.CENTER);
        tfPrenumeSolicitant.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfPrenumeSolicitant.setColumns(10);
        tfPrenumeSolicitant.setBounds(769, 58, 392, 36); add(tfPrenumeSolicitant);

        lblCNP = new JLabel("C N P :"); lblCNP.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblCNP.setBounds(10, 105, 218, 36); add(lblCNP);

        tfCNPSolicitant = new JTextField(); tfCNPSolicitant.setHorizontalAlignment(SwingConstants.CENTER);
        tfCNPSolicitant.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfCNPSolicitant.setColumns(10);
        tfCNPSolicitant.setBounds(206, 105, 772, 36); add(tfCNPSolicitant);

        lblAdresaDomiciliu = new JLabel("Adresa domiciliu :"); lblAdresaDomiciliu.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblAdresaDomiciliu.setBounds(10, 152, 209, 36); add(lblAdresaDomiciliu);

        tfDomiciliuSolicitant = new JTextField(); tfDomiciliuSolicitant.setHorizontalAlignment(SwingConstants.CENTER);
        tfDomiciliuSolicitant.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfDomiciliuSolicitant.setColumns(10);
        tfDomiciliuSolicitant.setBounds(206, 152, 834, 36); add(tfDomiciliuSolicitant);

        lblSerieCi = new JLabel("Serie CI :"); lblSerieCi.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblSerieCi.setBounds(10, 199, 218, 36); add(lblSerieCi);

        tfSerieCI = new JTextField(); tfSerieCI.setHorizontalAlignment(SwingConstants.CENTER);
        tfSerieCI.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfSerieCI.setColumns(10);
        tfSerieCI.setBounds(206, 199, 392, 36); add(tfSerieCI);

        lblNumarCi = new JLabel("Numar CI :"); lblNumarCi.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNumarCi.setBounds(608, 199, 123, 36); add(lblNumarCi);

        tfNrCI = new JTextField(); tfNrCI.setHorizontalAlignment(SwingConstants.CENTER);
        tfNrCI.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfNrCI.setColumns(10);
        tfNrCI.setBounds(769, 199, 392, 36); add(tfNrCI);


        chckbxDomAltJud = new JCheckBox("Alt jud.");
        chckbxDomAltJud.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxDomAltJud.setFont(new Font("Times New Roman", Font.BOLD, 24));
        chckbxDomAltJud.setBounds(1046, 152, 115, 36);
        add(chckbxDomAltJud);

        JLabel lblSex = new JLabel("Sex :");
        lblSex.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblSex.setBounds(988, 105, 62, 36);
        add(lblSex);

        String[] MF = {"M", "F"};
        sexSolicitant = new JLabel("M");
        sexSolicitantComboBox = new FixedJComboBox(MF);
        sexSolicitantComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == sexSolicitantComboBox) {
                    sexSolicitant.setText(sexSolicitantComboBox.getSelectedItem().toString());
                }
            }
        });
        sexSolicitantComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        sexSolicitantComboBox.setBounds(1080, 105, 70, 33);
        add(sexSolicitantComboBox);

        lblLetalaNeletala = new JLabel("Letala / Neletala :");
        lblLetalaNeletala.setBounds(10, 293, 196, 36);
        lblLetalaNeletala.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblLetalaNeletala);

        String[] letalaNeletala = {"neletală", "letală"};
        tfLetalaNeletala = new JLabel("neletale");
        letalaNeletalaComboBox = new FixedJComboBox(letalaNeletala);
        letalaNeletalaComboBox.setBounds(206, 295, 392, 33);
        letalaNeletalaComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(letalaNeletalaComboBox);
        letalaNeletalaComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (Objects.requireNonNull(letalaNeletalaComboBox.getSelectedItem()).toString().equals("neletală")) {
                    tfLetalaNeletala.setText("neletale");
                } else {
                    tfLetalaNeletala.setText("letale");
                }
            }
        });

        lblDestinaieArm = new JLabel("Destinatie arma :");
        lblDestinaieArm.setBounds(608, 293, 196, 36);
        lblDestinaieArm.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblDestinaieArm);


        String[] destinatie = {"autoapărare", "vânătoare", "tir sportiv", "apărare și pază", "colecție"};
        tfDestinatieArma = new JLabel("autoapărare");
        destinatieComboBox = new FixedJComboBox(destinatie);
        destinatieComboBox.setBounds(798, 295, 361, 33);
        destinatieComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(destinatieComboBox);
        destinatieComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == destinatieComboBox) {
                    tfDestinatieArma.setText(destinatieComboBox.getSelectedItem().toString());
                }
            }
        });

        btnBack = new JButton("Back");
        btnBack.setBounds(1070, 429, 91, 72);
        btnBack.setIcon(Service.changeIconSize(new ImageIcon(Service.getPath("iconBack.png")), 100, 100));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = JFrameFactore.getFrame();
                frame.getContentPane().removeAll();
                frame.getContentPane().add(PanelMainScreen.getInstance());
                frame.setTitle("Pagina principală");
                Service.update (frame);
            }
        });
        setLayout(null);
        add(btnBack);

        JLabel lblSerieAut = new JLabel("Nr./Serie Autorizație :");
        lblSerieAut.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblSerieAut.setBounds(10, 246, 234, 36);
        add(lblSerieAut);

        tfNrSerieAutorizatie = new JTextField();
        tfNrSerieAutorizatie.setHorizontalAlignment(SwingConstants.CENTER);
        tfNrSerieAutorizatie.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfNrSerieAutorizatie.setColumns(10);
        tfNrSerieAutorizatie.setBounds(253, 247, 345, 36);
        add(tfNrSerieAutorizatie);

        lblDataAutorizatie = new JLabel("Data autorizație :");
        lblDataAutorizatie.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblDataAutorizatie.setBounds(608, 246, 189, 36);
        add(lblDataAutorizatie);

        tfDataAutorizatie = new JTextField();
        tfDataAutorizatie.setHorizontalAlignment(SwingConstants.CENTER);
        tfDataAutorizatie.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfDataAutorizatie.setColumns(10);
        tfDataAutorizatie.setBounds(798, 246, 363, 36);
        add(tfDataAutorizatie);

        JButton btnFinalizareLucrare = new JButton("Finalizare lucrare");
        btnFinalizareLucrare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pf = new PersoanaFizica();
                lpf = new LucrarePersoanaFizica();

                if (!(PanelPrelungireAutorizatiPF.tfNrLucrare.getText().equals("") || PanelPrelungireAutorizatiPF.tfDataLucrare.getText().equals("") ||
                        PanelPrelungireAutorizatiPF.tfNumeSolicitant.getText().equals("") || PanelPrelungireAutorizatiPF.tfPrenumeSolicitant.getText().equals("")
                        || PanelPrelungireAutorizatiPF.tfCNPSolicitant.getText().equals(""))) {

                    pf.setNume(PanelPrelungireAutorizatiPF.tfNumeSolicitant.getText()); pf.setPrenume(PanelPrelungireAutorizatiPF.tfPrenumeSolicitant.getText());
                    pf.setCnp(PanelPrelungireAutorizatiPF.tfCNPSolicitant.getText()); pf.setAdresaDomiciliu(PanelPrelungireAutorizatiPF.tfDomiciliuSolicitant.getText());
                    pf.setSerieCI(PanelPrelungireAutorizatiPF.tfSerieCI.getText()); pf.setNrCI(PanelPrelungireAutorizatiPF.tfNrCI.getText());

                    lpf.setTipLucrare(PanelMainScreen.tipLucrare); lpf.setLetalaNeletala(tfLetalaNeletala.getText());
                    lpf.setDestinatieArma(tfDestinatieArma.getText());lpf.setPersoanaFizica(pf);

                    pf.setDomAltJud(PanelPrelungireAutorizatiPF.chckbxDomAltJud.isSelected() ? "Da" : "Nu");
                    lpf.setNrLucrare(PanelPrelungireAutorizatiPF.tfNrLucrare.getText());
                    lpf.setDataLucrare(Service.stringToDate(PanelPrelungireAutorizatiPF.tfDataLucrare.getText()));

                    DataBase.addLucrare(lpf); DataBase.addPersoanaFizica(pf);
                    WordDocService.createDocumentsFinalizareLucrarePrelungireAutorizatie();
            }
        }});
        btnFinalizareLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
        btnFinalizareLucrare.setBounds(34, 375, 501, 36);
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
                        result = (String) JOptionPane.showInputDialog(JFrameFactore.getFrame(), "Selecteaza persoana", "", JOptionPane.QUESTION_MESSAGE, null, optionsArray, optionsArray[0]);
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
                        try {
                            PanelPrelungireAutorizatiPF.tfNumeSolicitant.setText(pfs.getNume());
                            PanelPrelungireAutorizatiPF.tfPrenumeSolicitant.setText(pfs.getPrenume());
                            PanelPrelungireAutorizatiPF.tfCNPSolicitant.setText(pfs.getCnp());
                            PanelPrelungireAutorizatiPF.tfDomiciliuSolicitant.setText(pfs.getAdresaDomiciliu());
                            PanelDatePersoanaFizica.tfSerieCI.setText(pfs.getSerieCI());
                            PanelDatePersoanaFizica.tfNrCI.setText(pfs.getNrCI());
                            if (pfs.getDomAltJud().equals("Da")) {
                                PanelDatePersoanaFizica.chckbxDomAltJud.setSelected(true);
                            }
                        } catch (NullPointerException exception) {
                            exception.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nu sunt inregistrate informatii in istoric!");
                }
            }
        });
        btnPreluareDatePersoane.setFont(new Font("Times New Roman", Font.BOLD, 24));
        btnPreluareDatePersoane.setBounds(608, 375, 448, 36);
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
                        result = (String) JOptionPane.showInputDialog(JFrameFactore.getFrame(), "Selecteaza lucrare", "", JOptionPane.QUESTION_MESSAGE, null, optionsArray, optionsArray[0]);
                    } catch (ArrayIndexOutOfBoundsException | NullPointerException exeption) {
                        exeption.printStackTrace();
                    }
                    for (Lucrare lpf : DataBase.getLucrari()) {
                        if (result != null && result.equals(lpf.getNrLucrare())) {
                            try {
                                lpfs = (LucrarePersoanaFizica) lpf;
                            } catch (ClassCastException exception) {
                                exception.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Eroare: Lucrarea selectată este din rândul celor pentru persoane juridice și nu fizice!");
                            }
                        }
                    }
                    if (result != null) {
                        assert lpfs != null;
                        try {
                            PanelPrelungireAutorizatiPF.tfNrLucrare.setText(lpfs.getNrLucrare());
                            PanelPrelungireAutorizatiPF.tfDataLucrare.setText(Service.dateToString(lpfs.getDataLucrare()));
                            PanelPrelungireAutorizatiPF.tfNumeSolicitant.setText(lpfs.getPersoanaFizica().getNume());
                            PanelPrelungireAutorizatiPF.tfPrenumeSolicitant.setText(lpfs.getPersoanaFizica().getPrenume());
                            PanelPrelungireAutorizatiPF.tfCNPSolicitant.setText(lpfs.getPersoanaFizica().getCnp());
                            PanelPrelungireAutorizatiPF.tfDomiciliuSolicitant.setText(lpfs.getPersoanaFizica().getAdresaDomiciliu());
                            PanelPrelungireAutorizatiPF.tfSerieCI.setText(lpfs.getPersoanaFizica().getSerieCI());
                            PanelPrelungireAutorizatiPF.tfNrCI.setText(lpfs.getPersoanaFizica().getNrCI());
                            if (lpfs.getPersoanaFizica().getDomAltJud().equals("Da")) {
                                PanelPrelungireAutorizatiPF.chckbxDomAltJud.setSelected(true);
                            }
                        } catch (NullPointerException exception) {
                            exception.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nu sunt inregistrate informatii in istoric!");
                }
            }
        });
        btnPreluareDateLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
        btnPreluareDateLucrare.setBounds(608, 422, 448, 36);
        add(btnPreluareDateLucrare);

    }

}
