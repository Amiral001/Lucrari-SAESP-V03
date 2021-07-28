package com.nicholas.screens;

import com.nicholas.JFrameFactore;
import com.nicholas.data.DataBase;
import com.nicholas.entitys.PersoanaFizica;
import com.nicholas.utils.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class LucrarePJ extends JPanel {
	

	public LucrarePJ() {

		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		GridLayout gridLayout = new GridLayout(2,1);
		JPanel bigPanel = new JPanel();
		bigPanel.setBounds(0, 10, 1200, 800);
		
		DatePersoanaPanel datePersoanaPanel = new DatePersoanaPanel();
		datePersoanaPanel.setBounds(0, 0, 1200, 383);
		datePersoanaPanel.setLayout(null);
		
		
		DatePersoanaJuridicaPanel dateSocietatePanel = new DatePersoanaJuridicaPanel();
		dateSocietatePanel.setBounds(0, 380, 1200, 420);
		dateSocietatePanel.setLayout(null);
		bigPanel.setLayout(null);
		
		
		bigPanel.add(datePersoanaPanel);
		bigPanel.add(dateSocietatePanel);
		
		JButton btnVerificari = new JButton("Genereaza documentatie verificari");
		btnVerificari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//generare documentelor UTAI si adresa subunitate dom sau res
			}
		});
		btnVerificari.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnVerificari.setBounds(10, 304, 542, 36);
		dateSocietatePanel.add(btnVerificari);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(Service.changeIconSize(new ImageIcon(Service.getPath("iconBack.png")), 100, 100));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jf = JFrameFactore.getFrame();
				jf.getContentPane().removeAll();
				jf.getContentPane().add(MainScreen.getInstance());
				jf.revalidate();
				jf.repaint();
			}
		});
		btnBack.setBounds(1070, 315, 91, 72);
		dateSocietatePanel.add(btnBack);
		
		JButton btnPreluareDatePersoane = new JButton("Date privind persoana");
		btnPreluareDatePersoane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!DataBase.getPersoaneFizice().isEmpty()) {
					ArrayList<String> optionsArrayList = new ArrayList<>();
					String result = null;
					PersoanaFizica pfs = null;
					for (PersoanaFizica pf : DataBase.getPersoaneFizice()) {
						optionsArrayList.add(pf.getNume() + " " + pf.getPrenume());
					}
					Object[] optionsArray = optionsArrayList.toArray();
					try {
						result = (String) JOptionPane.showInputDialog(JFrameFactore.getFrame(), "Selecteaza persoana", "", JOptionPane.PLAIN_MESSAGE, null, optionsArray, optionsArray[0]);
						for (PersoanaFizica pf : DataBase.getPersoaneFizice()) {
							if (result != null && result.equals(pf.getNume() + " " + pf.getPrenume())) {
								pfs = pf;
							}
						}
					} catch (ArrayIndexOutOfBoundsException | NullPointerException exeption) {
						exeption.printStackTrace();
					}
					if (result != null) {
						assert pfs != null;
						DatePersoanaPanel.tfNumeSolicitant.setText(pfs.getNume());
						DatePersoanaPanel.tfPrenumeSolicitant.setText(pfs.getPrenume());
						DatePersoanaPanel.tfCNPSolicitant.setText(pfs.getCnp());
						DatePersoanaPanel.tfDomiciliuSolicitant.setText(pfs.getAdresaDomiciliu());
						DatePersoanaPanel.tfUnitateDomiciliu.setText(pfs.getUnitate01());
						DatePersoanaPanel.tfSubunitateDomiciliu.setText(pfs.getSubunitate01());
						DatePersoanaPanel.tfResedintaSolicintant.setText(pfs.getAdresaResedinta());
						DatePersoanaPanel.tfUnitateResedinta.setText(pfs.getUnitate02());
						DatePersoanaPanel.tfSubunitateresedinta.setText(pfs.getSubunitate02());
						DatePersoanaPanel.tfTelefonSolicitant.setText(pfs.getNumarTelefon());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nu sunt inregistrate informatii in istoric!");
				}
			}
		});
		btnPreluareDatePersoane.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnPreluareDatePersoane.setBounds(590, 304, 448, 36);
		dateSocietatePanel.add(btnPreluareDatePersoane);
		
		JButton btnPreluareDateLucrare = new JButton("Date privind lucrarea");
		//implementarea pentru preluarea datelor de lucrare PJ
		btnPreluareDateLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnPreluareDateLucrare.setBounds(590, 351, 448, 36);
		dateSocietatePanel.add(btnPreluareDateLucrare);
		
		JButton btnFinalizareLucrare = new JButton("Finalizare lucrare");
		//generare Raport final verificari
		btnFinalizareLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnFinalizareLucrare.setBounds(10, 351, 542, 36);
		dateSocietatePanel.add(btnFinalizareLucrare);
		
		add(bigPanel);
		

	}
}
