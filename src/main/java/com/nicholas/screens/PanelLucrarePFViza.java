package com.nicholas.screens;

import javax.swing.*;
import java.awt.*;

public class PanelLucrarePFViza extends JPanel {

	public PanelLucrarePFViza() {
		
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		GridLayout gridLayout = new GridLayout(2,1);
		JPanel bigPanel = new JPanel();
		bigPanel.setBounds(0, 10, 1200, 800);
		
		PanelDatePersoana panelDatePersoana = new PanelDatePersoana();
		PanelDatePersoana.lblSerieCi.setVisible(false); PanelDatePersoana.tfSerieCI.setVisible(false);
		PanelDatePersoana.lblNumarCi.setVisible(false); PanelDatePersoana.tfNrCI.setVisible(false);
		PanelDatePersoana.lblLucratorSaesp.setVisible(false); PanelDatePersoana.tfLucratorSAESP.setVisible(false);
		panelDatePersoana.setBounds(0, 11, 1200, 383);
		panelDatePersoana.setLayout(null);
		
		
		PanelDateCererePF panelDateCererePF = new PanelDateCererePF();
		panelDateCererePF.btnBack.setSize(91, 83);
		panelDateCererePF.btnBack.setLocation(1064, 177);
		panelDateCererePF.btnVerificari.setLocation(10, 177);
		panelDateCererePF.btnFinalizareLucrare.setLocation(10, 224);
		PanelDateCererePF.lblLetalaNeletala.setVisible(false); PanelDateCererePF.letalaNeletalaComboBox.setVisible(false);
		PanelDateCererePF.lblLungaScurta.setVisible(false); PanelDateCererePF.lungaScurtaComboBox.setVisible(false);
		PanelDateCererePF.lblDestinaieArm.setVisible(false); PanelDateCererePF.destinatieComboBox.setVisible(false);
		PanelDateCererePF.lblNumarCi_1_1.setVisible(false); PanelDateCererePF.regimCerereComboBox.setVisible(false);
		PanelDateCererePF.btnSuspendaLucrare.setVisible(false);
		panelDateCererePF.setBounds(0, 298, 1200, 502);
		panelDateCererePF.setLayout(null);
		bigPanel.setLayout(null);
		
		
		bigPanel.add(panelDatePersoana);
		bigPanel.add(panelDateCererePF);
		
		add(bigPanel);

	}

}
