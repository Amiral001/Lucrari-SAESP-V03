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

public class PanelRadiereArmaPF extends JPanel {

    public  static PersoanaFizica pf; public static LucrarePersoanaFizica lpf;

    public static JTextField tfNrLucrare, tfDataLucrare, tfNumeSolicitant, tfPrenumeSolicitant, tfCNPSolicitant, tfDomiciliuSolicitant, tfMarcaModelArma,
            tfCalArma, tfSerieArma, tfNumePrenumeCumparator, tfSerieNrFact, tfDataFact, tfEmitentFact;

    public static JLabel lblNumarLucrare, lblDataLucrare, lblNume, lblPrenume, lblCNP, lblAdresaDomiciliu, lblMarcaModelArma, lblCalArma, sexSolicitant,
            tfLetalaNeletala, lblLetalaNeletala, tfDestinatieArma, lblDestinaieArm, lblNumePrenumeCumparator, lblSerieNrFact, lblDataFact, lblEmitentFactura;
    public static JCheckBox chckbxDomAltJud;
    public static FixedJComboBox letalaNeletalaComboBox, destinatieComboBox, sexSolicitantComboBox;
    public static JButton btnBack, btnPreluareDatePersoane, btnPreluareDateLucrare;

    public PanelRadiereArmaPF() {
        setLayout(null);
        setBounds(0, 0, 1200, 683);


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

        lblMarcaModelArma = new JLabel("Marca si model armă :"); lblMarcaModelArma.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblMarcaModelArma.setBounds(10, 199, 243, 36); add(lblMarcaModelArma);

        tfMarcaModelArma = new JTextField(); tfMarcaModelArma.setHorizontalAlignment(SwingConstants.CENTER);
        tfMarcaModelArma.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfMarcaModelArma.setColumns(10);
        tfMarcaModelArma.setBounds(253, 199, 637, 36); add(tfMarcaModelArma);

        lblCalArma = new JLabel("Cal. :"); lblCalArma.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblCalArma.setBounds(900, 199, 62, 36); add(lblCalArma);

        tfCalArma = new JTextField(); tfCalArma.setHorizontalAlignment(SwingConstants.CENTER);
        tfCalArma.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfCalArma.setColumns(10);
        tfCalArma.setBounds(972, 199, 189, 36); add(tfCalArma);


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
        lblLetalaNeletala.setBounds(12, 434, 196, 36);
        lblLetalaNeletala.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblLetalaNeletala);

        String[] letalaNeletala = {"neletală", "letală"};
        tfLetalaNeletala = new JLabel("neletale");
        letalaNeletalaComboBox = new FixedJComboBox(letalaNeletala);
        letalaNeletalaComboBox.setBounds(208, 436, 392, 33);
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
        lblDestinaieArm.setBounds(610, 434, 196, 36);
        lblDestinaieArm.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblDestinaieArm);


        String[] destinatie = {"autoapărare", "vânătoare", "tir sportiv", "apărare și pază", "colecție"};
        tfDestinatieArma = new JLabel("autoapărare");
        destinatieComboBox = new FixedJComboBox(destinatie);
        destinatieComboBox.setBounds(800, 436, 361, 33);
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
        btnBack.setBounds(1068, 591, 91, 72);
        btnBack.setIcon(Service.changeIconSize(new ImageIcon(Service.getPath("iconBack.png")), 100, 100));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = JFrameFactore.getFrame();
                frame.getContentPane().removeAll();
                frame.getContentPane().add(PanelMainScreen.getInstance());
                Service.update (frame);
            }
        });
        setLayout(null);
        add(btnBack);

        JLabel lblSerieArma = new JLabel("Serie armă :");
        lblSerieArma.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblSerieArma.setBounds(10, 246, 234, 36);
        add(lblSerieArma);

        tfSerieArma = new JTextField();
        tfSerieArma.setHorizontalAlignment(SwingConstants.CENTER);
        tfSerieArma.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfSerieArma.setColumns(10);
        tfSerieArma.setBounds(253, 247, 908, 36);
        add(tfSerieArma);

        lblNumePrenumeCumparator = new JLabel("Nume și prenume cumpărător :");
        lblNumePrenumeCumparator.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNumePrenumeCumparator.setBounds(10, 293, 330, 36);
        add(lblNumePrenumeCumparator);

        tfNumePrenumeCumparator = new JTextField();
        tfNumePrenumeCumparator.setHorizontalAlignment(SwingConstants.CENTER);
        tfNumePrenumeCumparator.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfNumePrenumeCumparator.setColumns(10);
        tfNumePrenumeCumparator.setBounds(350, 294, 811, 36);
        add(tfNumePrenumeCumparator);

        lblSerieNrFact = new JLabel("Serie și număr factură :");
        lblSerieNrFact.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblSerieNrFact.setBounds(10, 340, 250, 36);
        add(lblSerieNrFact);

        tfSerieNrFact = new JTextField();
        tfSerieNrFact.setHorizontalAlignment(SwingConstants.CENTER);
        tfSerieNrFact.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfSerieNrFact.setColumns(10);
        tfSerieNrFact.setBounds(253, 340, 491, 36);
        add(tfSerieNrFact);

        lblDataFact = new JLabel("Data fact. :");
        lblDataFact.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblDataFact.setBounds(761, 341, 129, 36);
        add(lblDataFact);

        tfDataFact = new JTextField();
        tfDataFact.setHorizontalAlignment(SwingConstants.CENTER);
        tfDataFact.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfDataFact.setColumns(10);
        tfDataFact.setBounds(896, 342, 265, 36);
        add(tfDataFact);

        lblEmitentFactura = new JLabel("Emitent factura :");
        lblEmitentFactura.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblEmitentFactura.setBounds(10, 387, 181, 36);
        add(lblEmitentFactura);

        tfEmitentFact = new JTextField();
        tfEmitentFact.setHorizontalAlignment(SwingConstants.CENTER);
        tfEmitentFact.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfEmitentFact.setColumns(10);
        tfEmitentFact.setBounds(206, 387, 955, 36);
        add(tfEmitentFact);

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
                        try {
                            PanelRadiereArmaPF.tfNumeSolicitant.setText(pfs.getNume());
                            PanelRadiereArmaPF.tfPrenumeSolicitant.setText(pfs.getPrenume());
                            PanelRadiereArmaPF.tfCNPSolicitant.setText(pfs.getCnp());
                            PanelRadiereArmaPF.tfDomiciliuSolicitant.setText(pfs.getAdresaDomiciliu());
                            if (pfs.getDomAltJud().equals("Da")) {
                                PanelRadiereArmaPF.chckbxDomAltJud.setSelected(true);
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
        btnPreluareDatePersoane.setBounds(606, 537, 448, 36);
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
                            PanelRadiereArmaPF.tfNrLucrare.setText(lpfs.getNrLucrare());
                            PanelRadiereArmaPF.tfDataLucrare.setText(Service.dateToString(lpfs.getDataLucrare()));
                            PanelRadiereArmaPF.tfNumeSolicitant.setText(lpfs.getPersoanaFizica().getNume());
                            PanelRadiereArmaPF.tfPrenumeSolicitant.setText(lpfs.getPersoanaFizica().getPrenume());
                            PanelRadiereArmaPF.tfCNPSolicitant.setText(lpfs.getPersoanaFizica().getCnp());
                            PanelRadiereArmaPF.tfDomiciliuSolicitant.setText(lpfs.getPersoanaFizica().getAdresaDomiciliu());
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
        btnPreluareDateLucrare.setBounds(606, 584, 448, 36);
        add(btnPreluareDateLucrare);

        JButton btnFinalizareLucrare = new JButton("Finalizare lucrare");
        btnFinalizareLucrare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pf = new PersoanaFizica();
                lpf = new LucrarePersoanaFizica();

                if (!(PanelRadiereArmaPF.tfNrLucrare.getText().equals("") || PanelRadiereArmaPF.tfDataLucrare.getText().equals("") ||
                        PanelRadiereArmaPF.tfNumeSolicitant.getText().equals("") || PanelRadiereArmaPF.tfPrenumeSolicitant.getText().equals("")
                        || PanelRadiereArmaPF.tfCNPSolicitant.getText().equals(""))) {

                    pf.setNume(PanelRadiereArmaPF.tfNumeSolicitant.getText()); pf.setPrenume(PanelRadiereArmaPF.tfPrenumeSolicitant.getText());
                    pf.setCnp(PanelRadiereArmaPF.tfCNPSolicitant.getText()); pf.setAdresaDomiciliu(PanelRadiereArmaPF.tfDomiciliuSolicitant.getText());

                    lpf.setTipLucrare(PanelMainScreen.tipLucrare); lpf.setLetalaNeletala(tfLetalaNeletala.getText());
                    lpf.setDestinatieArma(tfDestinatieArma.getText());lpf.setPersoanaFizica(pf);

                    pf.setDomAltJud(PanelRadiereArmaPF.chckbxDomAltJud.isSelected() ? "Da" : "Nu");
                    lpf.setNrLucrare(PanelRadiereArmaPF.tfNrLucrare.getText());
                    lpf.setDataLucrare(Service.stringToDate(PanelRadiereArmaPF.tfDataLucrare.getText()));

                    DataBase.addLucrare(lpf); DataBase.addPersoanaFizica(pf);
                    WordDocService.createDocumentsFinalizareLucrareRadiereArma();
                }
            }});
        btnFinalizareLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
        btnFinalizareLucrare.setBounds(59, 537, 448, 36);
        add(btnFinalizareLucrare);
    }

}
