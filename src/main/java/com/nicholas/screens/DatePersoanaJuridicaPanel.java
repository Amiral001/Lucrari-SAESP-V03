package com.nicholas.screens;

import javax.swing.*;
import java.awt.*;

public class DatePersoanaJuridicaPanel extends JPanel {


    public static JTextField tfDenumireSocietate, tfSediuSocietate, tfPLSocietate;

    public static JLabel lblNumarLucrare, lblAdresaDomiciliu, lblAdresaResedinta, sexSolicitant;
    private JTextField tfEmitentCurs;
    private JTextField tfDataCurs;
    private JTextField tfEmitentAtestat;
    private JTextField tfDataAtestat;
    private JTextField tfNrSerieAtestat;


    public DatePersoanaJuridicaPanel() {
        setLayout(null);
        setBounds(0, 0, 1200, 297);


        lblNumarLucrare = new JLabel("Denumire societate :");
        lblNumarLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNumarLucrare.setBounds(10, 152, 218, 36);
        add(lblNumarLucrare);

        tfDenumireSocietate = new JTextField();
        tfDenumireSocietate.setBounds(248, 153, 913, 36);
        tfDenumireSocietate.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfDenumireSocietate.setHorizontalAlignment(SwingConstants.CENTER);
        add(tfDenumireSocietate);
        tfDenumireSocietate.setColumns(10);

        lblAdresaDomiciliu = new JLabel("Adresa sediu :");
        lblAdresaDomiciliu.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblAdresaDomiciliu.setBounds(10, 199, 209, 36);
        add(lblAdresaDomiciliu);

        tfSediuSocietate = new JTextField();
        tfSediuSocietate.setHorizontalAlignment(SwingConstants.CENTER);
        tfSediuSocietate.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfSediuSocietate.setColumns(10);
        tfSediuSocietate.setBounds(248, 200, 913, 36);
        add(tfSediuSocietate);

        lblAdresaResedinta = new JLabel("Adresa punct de lucru:");
        lblAdresaResedinta.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblAdresaResedinta.setBounds(10, 246, 244, 36);
        add(lblAdresaResedinta);

        tfPLSocietate = new JTextField();
        tfPLSocietate.setHorizontalAlignment(SwingConstants.CENTER);
        tfPLSocietate.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfPLSocietate.setColumns(10);
        tfPLSocietate.setBounds(248, 247, 913, 36);
        add(tfPLSocietate);

        JLabel lblCertificatCursArme = new JLabel("Certificat curs arme :");
        lblCertificatCursArme.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblCertificatCursArme.setBounds(10, 105, 238, 36);
        add(lblCertificatCursArme);

        tfEmitentCurs = new JTextField();
        tfEmitentCurs.setHorizontalAlignment(SwingConstants.CENTER);
        tfEmitentCurs.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfEmitentCurs.setColumns(10);
        tfEmitentCurs.setBounds(376, 106, 516, 36);
        add(tfEmitentCurs);

        JLabel lblEmitent = new JLabel("Emitent :");
        lblEmitent.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblEmitent.setBounds(248, 105, 109, 36);
        add(lblEmitent);

        JLabel lblData = new JLabel("Data :");
        lblData.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblData.setBounds(902, 105, 77, 36);
        add(lblData);

        tfDataCurs = new JTextField();
        tfDataCurs.setHorizontalAlignment(SwingConstants.CENTER);
        tfDataCurs.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfDataCurs.setColumns(10);
        tfDataCurs.setBounds(989, 106, 172, 36);
        add(tfDataCurs);

        JLabel lblAtestatAgentSecuritate = new JLabel("Atestat ag. securitate :");
        lblAtestatAgentSecuritate.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblAtestatAgentSecuritate.setBounds(10, 11, 238, 36);
        add(lblAtestatAgentSecuritate);

        tfEmitentAtestat = new JTextField();
        tfEmitentAtestat.setHorizontalAlignment(SwingConstants.CENTER);
        tfEmitentAtestat.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfEmitentAtestat.setColumns(10);
        tfEmitentAtestat.setBounds(376, 12, 785, 36);
        add(tfEmitentAtestat);

        JLabel lblEmitent_1 = new JLabel("Emitent :");
        lblEmitent_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblEmitent_1.setBounds(248, 11, 103, 36);
        add(lblEmitent_1);

        JLabel lblData_1 = new JLabel("Data :");
        lblData_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblData_1.setBounds(902, 59, 77, 36);
        add(lblData_1);

        tfDataAtestat = new JTextField();
        tfDataAtestat.setHorizontalAlignment(SwingConstants.CENTER);
        tfDataAtestat.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfDataAtestat.setColumns(10);
        tfDataAtestat.setBounds(989, 59, 172, 36);
        add(tfDataAtestat);

        JLabel lblEmitent_1_1 = new JLabel("Nr. și serie :");
        lblEmitent_1_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblEmitent_1_1.setBounds(248, 58, 137, 36);
        add(lblEmitent_1_1);

        tfNrSerieAtestat = new JTextField();
        tfNrSerieAtestat.setHorizontalAlignment(SwingConstants.CENTER);
        tfNrSerieAtestat.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tfNrSerieAtestat.setColumns(10);
        tfNrSerieAtestat.setBounds(376, 59, 516, 36);
        add(tfNrSerieAtestat);

        String[] MF = {"M", "F"};
        sexSolicitant = new JLabel("M");

    }
}
