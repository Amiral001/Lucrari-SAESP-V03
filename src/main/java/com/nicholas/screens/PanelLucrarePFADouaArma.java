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
		
		PanelDatePersoanaFizica panelDatePersoanaFizica = new PanelDatePersoanaFizica();
		PanelDatePersoanaFizica.tfNrCI.setLocation(769, 199);
		PanelDatePersoanaFizica.lblNumarCi.setLocation(608, 199);
		PanelDatePersoanaFizica.tfSerieCI.setLocation(206, 199);
		PanelDatePersoanaFizica.lblSerieCi.setLocation(10, 199);
		PanelDatePersoanaFizica.lblUnitate.setVisible(false); PanelDatePersoanaFizica.tfUnitateDomiciliu.setVisible(false);
		PanelDatePersoanaFizica.lblSubunitate.setVisible(false); PanelDatePersoanaFizica.tfSubunitateDomiciliu.setVisible(false);
		PanelDatePersoanaFizica.lblAdresaResedinta.setVisible(false); PanelDatePersoanaFizica.tfResedintaSolicintant.setVisible(false);
		PanelDatePersoanaFizica.lblUnitate_1.setVisible(false); PanelDatePersoanaFizica.tfUnitateResedinta.setVisible(false);
		PanelDatePersoanaFizica.lblSubunitate_1.setVisible(false); PanelDatePersoanaFizica.tfSubunitateresedinta.setVisible(false);
		PanelDatePersoanaFizica.lblTelefon.setVisible(false); PanelDatePersoanaFizica.tfTelefonSolicitant.setVisible(false);
		PanelDatePersoanaFizica.lblLucratorSaesp.setVisible(false); PanelDatePersoanaFizica.tfLucratorSAESP.setVisible(false);
		
		panelDatePersoanaFizica.setBounds(0, 23, 1200, 244);
		panelDatePersoanaFizica.setLayout(null);
		
		
		PanelDateCererePF panelDateCererePF = new PanelDateCererePF();
		panelDateCererePF.btnBack.setSize(91, 83);
		panelDateCererePF.btnBack.setLocation(1064, 175);
		panelDateCererePF.btnFinalizareLucrare.setLocation(10, 222);
		panelDateCererePF.btnVerificari.setLocation(10, 175);
		panelDateCererePF.regimCerereComboBox.setBounds(773, 60, 375,33);
		panelDateCererePF.lblNumarCi_1_1.setLocation(576, 58);
		panelDateCererePF.destinatieComboBox.setBounds(216,60,301,33);
		PanelDateCererePF.lblNumarCi_1_1_1_1.setVisible(false); PanelDateCererePF.armaLaDomiciliuComboBox.setVisible(false);
		PanelDateCererePF.btnSuspendaLucrare.setVisible(false);
		panelDateCererePF.setBounds(0, 291, 1200, 509);
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
