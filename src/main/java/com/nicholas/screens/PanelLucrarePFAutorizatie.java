package com.nicholas.screens;

import javax.swing.*;
import java.awt.*;

public class PanelLucrarePFAutorizatie extends JPanel {

	
	public PanelLucrarePFAutorizatie() {
		
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
		PanelDatePersoanaFizica.lblLucratorSaesp.setVisible(false); PanelDatePersoanaFizica.tfLucratorSAESP.setVisible(false);
		PanelDatePersoanaFizica.lblSubunitate.setVisible(false); PanelDatePersoanaFizica.tfSubunitateDomiciliu.setVisible(false);
		PanelDatePersoanaFizica.lblUnitate.setVisible(false); PanelDatePersoanaFizica.tfUnitateDomiciliu.setVisible(false);
		PanelDatePersoanaFizica.lblAdresaResedinta.setVisible(false); PanelDatePersoanaFizica.tfResedintaSolicintant.setVisible(false);
		PanelDatePersoanaFizica.lblUnitate_1.setVisible(false); PanelDatePersoanaFizica.tfUnitateResedinta.setVisible(false);
		PanelDatePersoanaFizica.lblSubunitate_1.setVisible(false); PanelDatePersoanaFizica.tfSubunitateresedinta.setVisible(false);
		PanelDatePersoanaFizica.lblTelefon.setVisible(false); PanelDatePersoanaFizica.tfTelefonSolicitant.setVisible(false);
		
		panelDatePersoanaFizica.setBounds(0, 11, 1200, 243);
		panelDatePersoanaFizica.setLayout(null);
		
		
		PanelDateCererePF panelDateCererePF = new PanelDateCererePF();
		PanelDateCererePF.btnFinalizareLucrare.setLocation(10, 199);
		PanelDateCererePF.lblNumarCi_1_1.setVisible(false); PanelDateCererePF.regimCerereComboBox.setVisible(false);
		PanelDateCererePF.lblNumarCi_1_1_1_1.setVisible(false); PanelDateCererePF.armaLaDomiciliuComboBox.setVisible(false);
		PanelDateCererePF.btnSuspendaLucrare.setVisible(false); PanelDateCererePF.btnVerificari.setVisible(false);
		panelDateCererePF.setBounds(0, 265, 1200, 535);
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
