package com.nicholas.screens;

import javax.swing.*;
import java.awt.*;

public class LucrarePFViza extends JPanel {

	public LucrarePFViza() {
		
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		GridLayout gridLayout = new GridLayout(2,1);
		JPanel bigPanel = new JPanel();
		bigPanel.setBounds(0, 10, 1200, 800);
		
		DatePersoanaPanel datePersoanaPanel = new DatePersoanaPanel();
		DatePersoanaPanel.lblSerieCi.setVisible(false); DatePersoanaPanel.tfSerieCI.setVisible(false);
		DatePersoanaPanel.lblNumarCi.setVisible(false); DatePersoanaPanel.tfNrCI.setVisible(false);
		DatePersoanaPanel.lblLucratorSaesp.setVisible(false); DatePersoanaPanel.tfLucratorSAESP.setVisible(false);
		datePersoanaPanel.setBounds(0, 11, 1200, 383);
		datePersoanaPanel.setLayout(null);
		
		
		DateCererePF dateCererePF = new DateCererePF();
		dateCererePF.btnBack.setSize(91, 83);
		dateCererePF.btnBack.setLocation(1064, 177);
		dateCererePF.btnVerificari.setLocation(10, 177);
		dateCererePF.btnFinalizareLucrare.setLocation(10, 224);
		DateCererePF.lblLetalaNeletala.setVisible(false); DateCererePF.letalaNeletalaComboBox.setVisible(false);
		DateCererePF.lblLungaScurta.setVisible(false); DateCererePF.lungaScurtaComboBox.setVisible(false);
		DateCererePF.lblDestinaieArm.setVisible(false); DateCererePF.destinatieComboBox.setVisible(false);
		DateCererePF.lblNumarCi_1_1.setVisible(false); DateCererePF.regimCerereComboBox.setVisible(false);
		DateCererePF.btnSuspendaLucrare.setVisible(false);
		dateCererePF.setBounds(0, 298, 1200, 502);
		dateCererePF.setLayout(null);
		bigPanel.setLayout(null);
		
		
		bigPanel.add(datePersoanaPanel);
		bigPanel.add(dateCererePF);
		
		add(bigPanel);

	}

}
