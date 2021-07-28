package com.nicholas.screens;

import com.nicholas.JFrameFactore;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JPanel {
	
	public static String tipLucrare;

	private static final MainScreen ms = null;

	public static MainScreen getInstance() {
		if (ms == null) {
			return new MainScreen();
		} else {
			return ms;
		}
	}

	public MainScreen() {

		JFrame frame = JFrameFactore.getFrame();

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1150, 850);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JPanel panelTitle = new JPanel();
		panelTitle.setBounds(0, 27, 1150, 65);
		mainPanel.add(panelTitle);

		Label label = new Label("Lucrari S.A.E.S.P.");
		panelTitle.add(label, BorderLayout.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 40));

		// persoane fizice

		Panel panelPersoaneFizice = new Panel();
		panelPersoaneFizice.setSize(591, 623);
		panelPersoaneFizice.setLocation(0, 129);
		mainPanel.add(panelPersoaneFizice);

		Label jLabelPersoaneFizice = new Label("Persoane fizice");
		jLabelPersoaneFizice.setFont(new Font("Times New Roman", Font.BOLD, 24));
		jLabelPersoaneFizice.setPreferredSize(new Dimension(400, 50));
		jLabelPersoaneFizice.setAlignment(Label.CENTER);
		panelPersoaneFizice.add(jLabelPersoaneFizice, BorderLayout.CENTER);

		panelPersoaneFizice.add(Box.createRigidArea(new Dimension(300, 5)));

		JButton button_prima_arma = new JButton("Prima arma");
		button_prima_arma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new LucarePFPrimaArma());
				tipLucrare = "PA";
			}
		});
		
		
		button_prima_arma.setFont(new Font("Times New Roman", Font.BOLD, 24));
		button_prima_arma.setPreferredSize(new Dimension(400, 50));
		button_prima_arma.setBorder(new LineBorder(Color.BLACK));
		panelPersoaneFizice.add(button_prima_arma, BorderLayout.CENTER);

		panelPersoaneFizice.add(Box.createRigidArea(new Dimension(300, 25)));

		JButton button_a_doua_arma = new JButton("A doua arma");
		button_a_doua_arma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				tipLucrare = "ADA";
				frame.getContentPane().add(new LucrarePFADouaArma());
			}
		});
		button_a_doua_arma.setFont(new Font("Times New Roman", Font.BOLD, 24));
		button_a_doua_arma.setPreferredSize(new Dimension(400, 50));
		button_a_doua_arma.setBorder(new LineBorder(Color.BLACK));
		panelPersoaneFizice.add(button_a_doua_arma, BorderLayout.CENTER);

		panelPersoaneFizice.add(Box.createRigidArea(new Dimension(300, 25)));

		JButton button_viza = new JButton("Prelungire valabilitate permis");
		button_viza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				tipLucrare = "V";
				frame.getContentPane().add(new LucrarePFViza());
			}
		});
		button_viza.setFont(new Font("Times New Roman", Font.BOLD, 24));
		button_viza.setPreferredSize(new Dimension(400, 50));
		button_viza.setBorder(new LineBorder(Color.BLACK));
		panelPersoaneFizice.add(button_viza, BorderLayout.CENTER);

		panelPersoaneFizice.add(Box.createRigidArea(new Dimension(300, 25)));

		JButton button_domiciliu = new JButton("Schimbare domiciliu in permis");
		button_domiciliu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				tipLucrare = "D";
				frame.getContentPane().add(new LucrarePFDomiciliu());
			}
		});
		button_domiciliu.setFont(new Font("Times New Roman", Font.BOLD, 24));
		button_domiciliu.setPreferredSize(new Dimension(400, 50));
		button_domiciliu.setBorder(new LineBorder(Color.BLACK));
		panelPersoaneFizice.add(button_domiciliu, BorderLayout.CENTER);

		panelPersoaneFizice.add(Box.createRigidArea(new Dimension(300, 25)));

		JButton button_resedinta = new JButton("Inscriere resedinta in permis");
		button_resedinta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				tipLucrare = "R";
				frame.getContentPane().add(new LucrarePFResedinta());
			}
		});
		button_resedinta.setFont(new Font("Times New Roman", Font.BOLD, 24));
		button_resedinta.setPreferredSize(new Dimension(400, 50));
		button_resedinta.setBorder(new LineBorder(Color.BLACK));
		panelPersoaneFizice.add(button_resedinta, BorderLayout.CENTER);

		panelPersoaneFizice.add(Box.createRigidArea(new Dimension(300, 25)));

		JButton button_autorizatie = new JButton("Autorizatie");
		button_autorizatie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				tipLucrare = "A";
				frame.getContentPane().add(new UnderConstruction());
			}
		});
		button_autorizatie.setFont(new Font("Times New Roman", Font.BOLD, 24));
		button_autorizatie.setPreferredSize(new Dimension(400, 50));
		button_autorizatie.setBorder(new LineBorder(Color.BLACK));
		panelPersoaneFizice.add(button_autorizatie, BorderLayout.CENTER);

		// persoane juridice

		Panel panelPersoaneJuridice = new Panel();
		panelPersoaneJuridice.setBounds(597, 129, 553, 623);
		mainPanel.add(panelPersoaneJuridice);

		Label jLabelPersoaneJuridice = new Label("Persoane juridice");
		jLabelPersoaneJuridice.setFont(new Font("Times New Roman", Font.BOLD, 24));
		jLabelPersoaneJuridice.setPreferredSize(new Dimension(400, 50));
		jLabelPersoaneJuridice.setAlignment(Label.CENTER);
		panelPersoaneJuridice.add(jLabelPersoaneJuridice, BorderLayout.CENTER);

		panelPersoaneJuridice.add(Box.createRigidArea(new Dimension(300, 5)));

		JButton button_dotare = new JButton("Avizare doatare cu armament");
		button_dotare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				tipLucrare = "DOT";
				frame.getContentPane().add(new LucrarePJ());
			}
		});
		button_dotare.setFont(new Font("Times New Roman", Font.BOLD, 24));
		button_dotare.setPreferredSize(new Dimension(400, 50));
		button_dotare.setBorder(new LineBorder(Color.BLACK));
		panelPersoaneJuridice.add(button_dotare, BorderLayout.CENTER);

		panelPersoaneJuridice.add(Box.createRigidArea(new Dimension(300, 25)));

		JButton button_gestionar = new JButton("Avizare gestionar");
		button_gestionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				tipLucrare = "G";
				frame.getContentPane().add(new LucrarePJ());
			}
		});
		button_gestionar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		button_gestionar.setPreferredSize(new Dimension(400, 50));
		button_gestionar.setBorder(new LineBorder(Color.BLACK));
		panelPersoaneJuridice.add(button_gestionar, BorderLayout.CENTER);

		panelPersoaneJuridice.add(Box.createRigidArea(new Dimension(300, 25)));

		JButton button_autorizatie2 = new JButton("Autorizatie");
		button_autorizatie2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				tipLucrare = "APJ";
				frame.getContentPane().add(new UnderConstruction());
			}
		});
		button_autorizatie2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		button_autorizatie2.setPreferredSize(new Dimension(400, 50));
		button_autorizatie2.setBorder(new LineBorder(Color.BLACK));
		panelPersoaneJuridice.add(button_autorizatie2, BorderLayout.CENTER);

		Panel panelButtom = new Panel();
		panelButtom.setBounds(0, 758, 1150, 82);
		mainPanel.add(panelButtom);
		panelButtom.setLayout(null);

		JLabel lblByNicholas = new JLabel("@By Nicholas");
		lblByNicholas.setBounds(971, 28, 169, 43);
		panelButtom.add(lblByNicholas);
		lblByNicholas.setFont(new Font("Brush Script MT", Font.PLAIN, 34));

	}

}
