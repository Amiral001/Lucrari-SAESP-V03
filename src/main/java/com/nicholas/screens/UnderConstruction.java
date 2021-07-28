package com.nicholas.screens;

import com.nicholas.JFrameFactore;
import com.nicholas.utils.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnderConstruction extends JPanel {
	

	public UnderConstruction() {

		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		GridLayout gridLayout = new GridLayout(2,1);
		JPanel bigPanel = new JPanel();
		bigPanel.setBounds(0, 10, 1200, 800);


		JButton btnBack = new JButton("Back");
		btnBack.setBounds(1064, 700, 91, 72);
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
		setLayout(null);
		add(btnBack);
		
		add(bigPanel);
		bigPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Under Construction");
		lblNewLabel.setFont(new Font("Script MT Bold", Font.BOLD, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(410, 272, 434, 160);
		bigPanel.add(lblNewLabel);
		bigPanel.add(btnBack);
		

	}
}
