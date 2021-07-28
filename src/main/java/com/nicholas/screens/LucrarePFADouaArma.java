package com.nicholas.screens;

import javax.swing.*;
import java.awt.*;

public class LucrarePFADouaArma extends JPanel {

	public LucrarePFADouaArma() {
		
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		GridLayout gridLayout = new GridLayout(2,1);
		JPanel bigPanel = new JPanel();
		bigPanel.setBounds(0, 10, 1200, 800);
		
		DatePersoanaPanel datePersoanaPanel = new DatePersoanaPanel();
		DatePersoanaPanel.tfNrCI.setLocation(769, 199);
		DatePersoanaPanel.lblNumarCi.setLocation(608, 199);
		DatePersoanaPanel.tfSerieCI.setLocation(206, 199);
		DatePersoanaPanel.lblSerieCi.setLocation(10, 199);
		DatePersoanaPanel.lblUnitate.setVisible(false); DatePersoanaPanel.tfUnitateDomiciliu.setVisible(false);
		DatePersoanaPanel.lblSubunitate.setVisible(false); DatePersoanaPanel.tfSubunitateDomiciliu.setVisible(false);
		DatePersoanaPanel.lblAdresaResedinta.setVisible(false); DatePersoanaPanel.tfResedintaSolicintant.setVisible(false);
		DatePersoanaPanel.lblUnitate_1.setVisible(false); DatePersoanaPanel.tfUnitateResedinta.setVisible(false);
		DatePersoanaPanel.lblSubunitate_1.setVisible(false); DatePersoanaPanel.tfSubunitateresedinta.setVisible(false);
		DatePersoanaPanel.lblTelefon.setVisible(false); DatePersoanaPanel.tfTelefonSolicitant.setVisible(false);
		DatePersoanaPanel.lblLucratorSaesp.setVisible(false); DatePersoanaPanel.tfLucratorSAESP.setVisible(false);
		
		datePersoanaPanel.setBounds(0, 23, 1200, 244);
		datePersoanaPanel.setLayout(null);
		
		
		DateCererePF dateCererePF = new DateCererePF();
		dateCererePF.btnBack.setSize(91, 83);
		dateCererePF.btnBack.setLocation(1064, 175);
		dateCererePF.btnFinalizareLucrare.setLocation(10, 222);
		dateCererePF.btnVerificari.setLocation(10, 175);
		DateCererePF.lblDomiciliuInAlt.setVisible(false); DateCererePF.domiciliuAltJudetComboBox.setVisible(false);
		DateCererePF.lblNumarCi_1_1_1.setVisible(false); DateCererePF.resedintaAltJudetComboBox.setVisible(false);
		DateCererePF.lblNumarCi_1_1_1_1.setVisible(false); DateCererePF.armaLaDomiciliuComboBox.setVisible(false);
		DateCererePF.btnSuspendaLucrare.setVisible(false);
		dateCererePF.setBounds(0, 291, 1200, 509);
		dateCererePF.setLayout(null);
		bigPanel.setLayout(null);
		
		bigPanel.add(datePersoanaPanel);
		bigPanel.add(dateCererePF);
		
		add(bigPanel);
	}
}
