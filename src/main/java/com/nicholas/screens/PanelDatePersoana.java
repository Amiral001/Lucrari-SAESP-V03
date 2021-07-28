package com.nicholas.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PanelDatePersoana extends JPanel {


	public static JTextField tfNrLucrare, tfDataLucrare, tfNumeSolicitant, tfPrenumeSolicitant, tfCNPSolicitant, tfDomiciliuSolicitant, tfResedintaSolicintant, 
							 tfTelefonSolicitant, tfSerieCI, tfNrCI, tfUnitateDomiciliu, tfSubunitateDomiciliu, tfUnitateResedinta, tfSubunitateresedinta, tfLucratorSAESP;

	public static JLabel lblNumarLucrare, lblDataLucrare, lblNume, lblPrenume, lblCNP, lblAdresaDomiciliu, lblAdresaResedinta, lblTelefon, lblSerieCi, lblNumarCi, lblUnitate,
	lblSubunitate, lblUnitate_1, lblSubunitate_1, lblLucratorSaesp, sexSolicitant;

	public static JComboBox sexSolicitantComboBox; public static JCheckBox chckbxDomAltJud, chckbxResAltJud;


	public PanelDatePersoana() {
		setLayout(null);		
		setBounds(0, 0, 1200, 484);
		

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

		lblAdresaResedinta = new JLabel("Adresa resedinta:"); lblAdresaResedinta.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblAdresaResedinta.setBounds(10, 246, 209, 36); add(lblAdresaResedinta);

		tfResedintaSolicintant = new JTextField(); tfResedintaSolicintant.setHorizontalAlignment(SwingConstants.CENTER);
		tfResedintaSolicintant.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfResedintaSolicintant.setColumns(10);
		tfResedintaSolicintant.setBounds(206, 246, 834, 36); add(tfResedintaSolicintant);

		lblTelefon = new JLabel("Telefon :"); lblTelefon.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTelefon.setBounds(10, 340, 218, 36); add(lblTelefon);

		tfTelefonSolicitant = new JTextField(); tfTelefonSolicitant.setHorizontalAlignment(SwingConstants.CENTER);
		tfTelefonSolicitant.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfTelefonSolicitant.setColumns(10);
		tfTelefonSolicitant.setBounds(206, 340, 955, 36); add(tfTelefonSolicitant);

		lblSerieCi = new JLabel("Serie CI :"); lblSerieCi.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSerieCi.setBounds(10, 387, 218, 36); add(lblSerieCi);

		tfSerieCI = new JTextField(); tfSerieCI.setHorizontalAlignment(SwingConstants.CENTER);
		tfSerieCI.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfSerieCI.setColumns(10);
		tfSerieCI.setBounds(206, 387, 392, 36); add(tfSerieCI);

		lblNumarCi = new JLabel("Numar CI :"); lblNumarCi.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNumarCi.setBounds(608, 387, 123, 36); add(lblNumarCi);

		tfNrCI = new JTextField(); tfNrCI.setHorizontalAlignment(SwingConstants.CENTER);
		tfNrCI.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfNrCI.setColumns(10);
		tfNrCI.setBounds(769, 387, 392, 36); add(tfNrCI);

		lblUnitate = new JLabel("Unitate :"); lblUnitate.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblUnitate.setBounds(10, 199, 218, 36); add(lblUnitate);

		tfUnitateDomiciliu = new JTextField(); tfUnitateDomiciliu.setHorizontalAlignment(SwingConstants.CENTER);
		tfUnitateDomiciliu.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfUnitateDomiciliu.setColumns(10);
		tfUnitateDomiciliu.setBounds(206, 199, 392, 36); add(tfUnitateDomiciliu);

		lblSubunitate = new JLabel("Subunitate :"); lblSubunitate.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSubunitate.setBounds(608, 199, 132, 36); add(lblSubunitate);

		tfSubunitateDomiciliu = new JTextField(); tfSubunitateDomiciliu.setHorizontalAlignment(SwingConstants.CENTER);
		tfSubunitateDomiciliu.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfSubunitateDomiciliu.setColumns(10);
		tfSubunitateDomiciliu.setBounds(769, 199, 392, 36); add(tfSubunitateDomiciliu);

		lblUnitate_1 = new JLabel("Unitate :"); lblUnitate_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblUnitate_1.setBounds(10, 293, 218, 36); add(lblUnitate_1);

		tfUnitateResedinta = new JTextField(); tfUnitateResedinta.setHorizontalAlignment(SwingConstants.CENTER);
		tfUnitateResedinta.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfUnitateResedinta.setColumns(10);
		tfUnitateResedinta.setBounds(206, 293, 392, 36); add(tfUnitateResedinta);

		lblSubunitate_1 = new JLabel("Subunitate :"); lblSubunitate_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSubunitate_1.setBounds(608, 293, 132, 36); add(lblSubunitate_1);

		tfSubunitateresedinta = new JTextField(); tfSubunitateresedinta.setHorizontalAlignment(SwingConstants.CENTER);
		tfSubunitateresedinta.setFont(new Font("Times New Roman", Font.BOLD, 24)); tfSubunitateresedinta.setColumns(10);
		tfSubunitateresedinta.setBounds(769, 293, 392, 36); add(tfSubunitateresedinta);
 
		lblLucratorSaesp = new JLabel("Lucrator SAESP :"); lblLucratorSaesp.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblLucratorSaesp.setBounds(10, 434, 218, 36); add(lblLucratorSaesp);
 
		tfLucratorSAESP = new JTextField(); tfLucratorSAESP.setHorizontalAlignment(SwingConstants.CENTER); tfLucratorSAESP.setFont(new Font("Times New Roman", Font.BOLD, 24));
		tfLucratorSAESP.setColumns(10); tfLucratorSAESP.setBounds(206, 434, 955, 36); add(tfLucratorSAESP);

		chckbxDomAltJud = new JCheckBox("Alt jud.");
		chckbxDomAltJud.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxDomAltJud.setFont(new Font("Times New Roman", Font.BOLD, 24));
		chckbxDomAltJud.setBounds(1046, 152, 115, 36);
		add(chckbxDomAltJud);

		chckbxResAltJud = new JCheckBox("Alt jud.");
		chckbxResAltJud.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxResAltJud.setFont(new Font("Times New Roman", Font.BOLD, 24));
		chckbxResAltJud.setBounds(1046, 246, 115, 36);
		add(chckbxResAltJud);

		JLabel lblSex = new JLabel("Sex :");
		lblSex.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSex.setBounds(988, 105, 62, 36);
		add(lblSex);

		String[] MF = {"M", "F"};
		sexSolicitant = new JLabel("M");
		sexSolicitantComboBox = new JComboBox(MF);
		sexSolicitantComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getSource() == sexSolicitantComboBox) {
					sexSolicitant.setText(sexSolicitantComboBox.getSelectedItem().toString());
				}
			}
		});
		sexSolicitantComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
		sexSolicitantComboBox.setBounds(1060, 105, 101, 33);
		add(sexSolicitantComboBox);

	}
}
