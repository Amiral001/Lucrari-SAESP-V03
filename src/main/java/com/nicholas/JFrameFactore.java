package com.nicholas;

import com.nicholas.data.DataBase;
import com.nicholas.screens.PanelMainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JFrameFactore extends JPanel {

	private static JFrame frame = null;

	public static JFrame getFrame() {
		if (frame == null) {
			return new JFrame();
		} else {
			return frame;
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameFactore window = new JFrameFactore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JFrameFactore() {
		initialize();
	}

	private void initialize() {

		frame = getFrame();
		frame.setSize(1200, 900);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				DataBase.writeJson();
			}
		});
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		frame.getContentPane().add(new PanelMainScreen());

	}

}
