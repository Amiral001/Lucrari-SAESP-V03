package com.nicholas.screens;

import javax.swing.*;
import java.awt.*;

public class PanelLucrarePFADouaArma extends JPanel {

	public PanelLucrarePFADouaArma() {
		
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		GridLayout gridLayout = new GridLayout(2,1);
		JPanel bigPanel = new JPanel();
		bigPanel.setBounds(0, 10, 1200, 800);
		
		PanelDatePersoana panelDatePersoana = new PanelDatePersoana();
		PanelDatePersoana.tfNrCI.setLocation(769, 199);
		PanelDatePersoana.lblNumarCi.setLocation(608, 199);
		PanelDatePersoana.tfSerieCI.setLocation(206, 199);
		PanelDatePersoana.lblSerieCi.setLocation(10, 199);
		PanelDatePersoana.lblUnitate.setVisible(false); PanelDatePersoana.tfUnitateDomiciliu.setVisible(false);
		PanelDatePersoana.lblSubunitate.setVisible(false); PanelDatePersoana.tfSubunitateDomiciliu.setVisible(false);
		PanelDatePersoana.lblAdresaResedinta.setVisible(false); PanelDatePersoana.tfResedintaSolicintant.setVisible(false);
		PanelDatePersoana.lblUnitate_1.setVisible(false); PanelDatePersoana.tfUnitateResedinta.setVisible(false);
		PanelDatePersoana.lblSubunitate_1.setVisible(false); PanelDatePersoana.tfSubunitateresedinta.setVisible(false);
		PanelDatePersoana.lblTelefon.setVisible(false); PanelDatePersoana.tfTelefonSolicitant.setVisible(false);
		PanelDatePersoana.lblLucratorSaesp.setVisible(false); PanelDatePersoana.tfLucratorSAESP.setVisible(false);
		
		panelDatePersoana.setBounds(0, 23, 1200, 244);
		panelDatePersoana.setLayout(null);
		
		
		PanelDateCererePF panelDateCererePF = new PanelDateCererePF();
		panelDateCererePF.btnBack.setSize(91, 83);
		panelDateCererePF.btnBack.setLocation(1064, 175);
		panelDateCererePF.btnFinalizareLucrare.setLocation(10, 222);
		panelDateCererePF.btnVerificari.setLocation(10, 175);
		PanelDateCererePF.lblDomiciliuInAlt.setVisible(false); PanelDateCererePF.domiciliuAltJudetComboBox.setVisible(false);
		PanelDateCererePF.lblNumarCi_1_1_1.setVisible(false); PanelDateCererePF.resedintaAltJudetComboBox.setVisible(false);
		PanelDateCererePF.lblNumarCi_1_1_1_1.setVisible(false); PanelDateCererePF.armaLaDomiciliuComboBox.setVisible(false);
		PanelDateCererePF.btnSuspendaLucrare.setVisible(false);
		panelDateCererePF.setBounds(0, 291, 1200, 509);
		panelDateCererePF.setLayout(null);
		bigPanel.setLayout(null);
		
		bigPanel.add(panelDatePersoana);
		bigPanel.add(panelDateCererePF);
		
		add(bigPanel);
	}
}
