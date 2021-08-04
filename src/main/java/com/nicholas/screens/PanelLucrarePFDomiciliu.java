package com.nicholas.screens;

import javax.swing.*;
import java.awt.*;

public class PanelLucrarePFDomiciliu extends JPanel {

	public PanelLucrarePFDomiciliu() {
		
		
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		GridLayout gridLayout = new GridLayout(2,1);
		JPanel bigPanel = new JPanel();
		bigPanel.setBounds(0, 10, 1200, 800);
		
		PanelDatePersoanaFizica panelDatePersoanaFizica = new PanelDatePersoanaFizica();

		PanelDatePersoanaFizica.lblSerieCi.setVisible(false); PanelDatePersoanaFizica.tfSerieCI.setVisible(false);
		PanelDatePersoanaFizica.lblNumarCi.setVisible(false); PanelDatePersoanaFizica.tfNrCI.setVisible(false);
		PanelDatePersoanaFizica.lblLucratorSaesp.setVisible(false); PanelDatePersoanaFizica.tfLucratorSAESP.setVisible(false);
		panelDatePersoanaFizica.setBounds(0, 11, 1200, 383);
		panelDatePersoanaFizica.setLayout(null);
		
		
		PanelDateCererePF panelDateCererePF = new PanelDateCererePF();
		panelDateCererePF.btnBack.setSize(91, 85);
		panelDateCererePF.btnBack.setLocation(1064, 175);
		panelDateCererePF.btnFinalizareLucrare.setLocation(10, 224);
		panelDateCererePF.btnVerificari.setLocation(10, 175);
		panelDateCererePF.armaLaDomiciliuComboBox.setLocation(1084,110);
		panelDateCererePF.lblNumarCi_1_1_1_1.setLocation(848,110);
		PanelDateCererePF.lblLetalaNeletala.setVisible(false); PanelDateCererePF.letalaNeletalaComboBox.setVisible(false);
		PanelDateCererePF.lblLungaScurta.setVisible(false); PanelDateCererePF.lungaScurtaComboBox.setVisible(false);
		PanelDateCererePF.lblDestinaieArm.setVisible(false); PanelDateCererePF.destinatieComboBox.setVisible(false);
		PanelDateCererePF.lblNumarCi_1_1.setVisible(false); PanelDateCererePF.regimCerereComboBox.setVisible(false);
		PanelDateCererePF.btnSuspendaLucrare.setVisible(false);
		panelDateCererePF.setBounds(0, 298, 1200, 502);
		panelDateCererePF.setLayout(null);
		bigPanel.setLayout(null);
		
		
		bigPanel.add(panelDatePersoanaFizica);
		bigPanel.add(panelDateCererePF);
		
		add(bigPanel);
		bigPanel.repaint();
		bigPanel.revalidate();
		bigPanel.setVisible(true);

	}

}
