package com.nicholas.screens;

import javax.swing.*;
import java.awt.*;

public class PanelLucarePFPrimaArma extends JPanel {
	

	public PanelLucarePFPrimaArma() {

		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		GridLayout gridLayout = new GridLayout(2,1);
		JPanel bigPanel = new JPanel();
		bigPanel.setBounds(0, 10, 1200, 800);
		
		PanelDatePersoanaFizica panelDatePersoanaFizica = new PanelDatePersoanaFizica();
		panelDatePersoanaFizica.setBounds(0, 11, 1200, 485);
		panelDatePersoanaFizica.setLayout(null);
		
		
		PanelDateCererePF panelDateCererePF = new PanelDateCererePF();
		panelDateCererePF.setBounds(0, 495, 1200, 305);
		panelDateCererePF.setLayout(null);
		bigPanel.setLayout(null);
		
		
		bigPanel.add(panelDatePersoanaFizica);
		bigPanel.add(panelDateCererePF);
		
		add(bigPanel);
		

	}
}
