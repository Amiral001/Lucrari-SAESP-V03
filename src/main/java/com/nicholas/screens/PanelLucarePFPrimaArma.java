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
		
		PanelDatePersoana panelDatePersoana = new PanelDatePersoana();
		panelDatePersoana.setBounds(0, 11, 1200, 485);
		panelDatePersoana.setLayout(null);
		
		
		PanelDateCererePF panelDateCererePF = new PanelDateCererePF();
		panelDateCererePF.setBounds(0, 495, 1200, 305);
		panelDateCererePF.setLayout(null);
		bigPanel.setLayout(null);
		
		
		bigPanel.add(panelDatePersoana);
		bigPanel.add(panelDateCererePF);
		
		add(bigPanel);
		

	}
}
