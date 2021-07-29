package com.nicholas.screens;

import com.nicholas.JFrameFactore;
import com.nicholas.data.DataBase;
import com.nicholas.entitys.*;
import com.nicholas.utils.Service;
import com.nicholas.utils.WordDocService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelLucrarePJ extends JPanel {

	public static PersoanaFizica pf; public static PersoanaJuridica pj; public static LucrarePersoanaJuridica lpj;
	

	public PanelLucrarePJ() {

		setLayout(null);
		setBounds(0, 0, 1200, 800);

		JPanel bigPanel = new JPanel();
		bigPanel.setBounds(0, 10, 1200, 800);
		
		PanelDatePersoana panelDatePersoana = new PanelDatePersoana(); panelDatePersoana.setBounds(0, 0, 1200, 383);
		panelDatePersoana.setLayout(null);
		
		
		PanelDatePersoanaJuridica dateSocietatePanel = new PanelDatePersoanaJuridica();
		dateSocietatePanel.setBounds(0, 380, 1200, 420); dateSocietatePanel.setLayout(null);
		bigPanel.setLayout(null);
		
		
		bigPanel.add(panelDatePersoana);
		bigPanel.add(dateSocietatePanel);
		
		JButton btnVerificari = new JButton("Genereaza documentatie verificari");
		btnVerificari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pf = new PersoanaFizica();
				pj = new PersoanaJuridica();
				lpj = new LucrarePersoanaJuridica();

				if (!(PanelDatePersoana.tfNrLucrare.getText().equals("") || PanelDatePersoana.tfDataLucrare.getText().equals("") ||
						PanelDatePersoana.tfNumeSolicitant.getText().equals("") || PanelDatePersoana.tfPrenumeSolicitant.getText().equals("")
						|| PanelDatePersoana.tfCNPSolicitant.getText().equals(""))) {

					pf.setNume(PanelDatePersoana.tfNumeSolicitant.getText()); pf.setPrenume(PanelDatePersoana.tfPrenumeSolicitant.getText());
					pf.setCnp(PanelDatePersoana.tfCNPSolicitant.getText()); pf.setAdresaDomiciliu(PanelDatePersoana.tfDomiciliuSolicitant.getText());
					pf.setUnitate01(PanelDatePersoana.tfUnitateDomiciliu.getText()); pf.setSubunitate01(PanelDatePersoana.tfSubunitateDomiciliu.getText());
					pf.setAdresaResedinta(PanelDatePersoana.tfResedintaSolicintant.getText()); pf.setUnitate02(PanelDatePersoana.tfUnitateResedinta.getText());
					pf.setSubunitate02(PanelDatePersoana.tfSubunitateresedinta.getText()); pf.setNumarTelefon(PanelDatePersoana.tfTelefonSolicitant.getText());
					pf.setEmitentAtestat(PanelDatePersoanaJuridica.tfEmitentAtestat.getText()); pf.setSerieNrAtestat(PanelDatePersoanaJuridica.tfNrSerieAtestat.getText());
					pf.setDataAtestat(PanelDatePersoanaJuridica.tfDataAtestat.getText());pf.setEmitentCurs(PanelDatePersoanaJuridica.tfEmitentCurs.getText());
					pf.setDataCurs(PanelDatePersoanaJuridica.tfEmitentCurs.getText());

					pj.setDenumire(PanelDatePersoanaJuridica.tfDenumireSocietate.getText());
					pj.setSediu(PanelDatePersoanaJuridica.tfSediuSocietate.getText()); pj.setPunctDeLucru(PanelDatePersoanaJuridica.tfPLSocietate.getText());


					lpj.setNrLucrare(PanelDatePersoana.tfNrLucrare.getText()); lpj.setDataLucrare(Service.stringToDate(PanelDatePersoana.tfDataLucrare.getText()));
					lpj.setTipLucrare(PanelMainScreen.tipLucrare); lpj.setPf(pf); lpj.setPj(pj);


					DataBase.addLucrare(lpj); DataBase.addPersoanaFizica(pf); DataBase.addPersoanaJuridica(pj);

					WordDocService.createDocumentsVerificariDG();

				} else {
					JOptionPane.showMessageDialog(null, "Atentie! Nu au fost completate corect campurile din formular");
				}
			}
		});
		btnVerificari.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnVerificari.setBounds(10, 304, 542, 36);
		dateSocietatePanel.add(btnVerificari);

		JButton btnFinalizareLucrare = new JButton("Finalizare lucrare");
		btnFinalizareLucrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WordDocService.createDocumentsFinalizareLucrareDG();
			}
		});
		btnFinalizareLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnFinalizareLucrare.setBounds(10, 351, 542, 36);
		dateSocietatePanel.add(btnFinalizareLucrare);

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
						PanelDatePersoana.tfNumeSolicitant.setText(pfs.getNume());
						PanelDatePersoana.tfPrenumeSolicitant.setText(pfs.getPrenume());
						PanelDatePersoana.tfCNPSolicitant.setText(pfs.getCnp());
						PanelDatePersoana.tfDomiciliuSolicitant.setText(pfs.getAdresaDomiciliu());
						PanelDatePersoana.tfUnitateDomiciliu.setText(pfs.getUnitate01());
						PanelDatePersoana.tfSubunitateDomiciliu.setText(pfs.getSubunitate01());
						PanelDatePersoana.tfResedintaSolicintant.setText(pfs.getAdresaResedinta());
						PanelDatePersoana.tfUnitateResedinta.setText(pfs.getUnitate02());
						PanelDatePersoana.tfSubunitateresedinta.setText(pfs.getSubunitate02());
						PanelDatePersoana.tfTelefonSolicitant.setText(pfs.getNumarTelefon());
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
		btnPreluareDateLucrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!DataBase.getLucrari().isEmpty()) {

					ArrayList<String> optionsArrayList = new ArrayList<>();
					String result = null;
					LucrarePersoanaJuridica lpjs = null;

					for (Lucrare lpj : DataBase.getLucrari()) {
						optionsArrayList.add(lpj.getNrLucrare());
					}
					Object[] optionsArray = optionsArrayList.toArray();
					try {
						result = (String) JOptionPane.showInputDialog(JFrameFactore.getFrame(), "Selecteaza lucrare", "", JOptionPane.PLAIN_MESSAGE, null, optionsArray, optionsArray[0]);
					} catch (ArrayIndexOutOfBoundsException | NullPointerException exeption) {
						exeption.printStackTrace();
					}
					for (Lucrare lpj : DataBase.getLucrari()) {
						if (result != null && result.equals(lpj.getNrLucrare())) {
							lpjs = (LucrarePersoanaJuridica) lpj;
						}
					}
					if (result != null) {
						assert lpj != null;
						PanelDatePersoana.tfNrLucrare.setText(lpjs.getNrLucrare());
						PanelDatePersoana.tfDataLucrare.setText(Service.dateToString(lpjs.getDataLucrare()));
						PanelDatePersoana.tfNumeSolicitant.setText(lpjs.getPf().getNume());
						PanelDatePersoana.tfPrenumeSolicitant.setText(lpjs.getPf().getPrenume());
						PanelDatePersoana.tfCNPSolicitant.setText(lpjs.getPf().getCnp());
						PanelDatePersoana.tfDomiciliuSolicitant.setText(lpjs.getPf().getAdresaDomiciliu());
						PanelDatePersoana.tfUnitateDomiciliu.setText(lpjs.getPf().getUnitate01());
						PanelDatePersoana.tfSubunitateDomiciliu.setText(lpjs.getPf().getSubunitate01());
						PanelDatePersoana.tfResedintaSolicintant.setText(lpjs.getPf().getAdresaResedinta());
						PanelDatePersoana.tfUnitateResedinta.setText(lpjs.getPf().getUnitate02());
						PanelDatePersoana.tfSubunitateresedinta.setText(lpjs.getPf().getSubunitate02());
						PanelDatePersoana.tfTelefonSolicitant.setText(lpjs.getPf().getNumarTelefon());
						PanelDatePersoanaJuridica.tfEmitentAtestat.setText(lpjs.getPf().getEmitentAtestat());
						PanelDatePersoanaJuridica.tfNrSerieAtestat.setText(lpjs.getPf().getSerieNrAtestat());
						PanelDatePersoanaJuridica.tfDataAtestat.setText(lpjs.getPf().getDataAtestat());
						PanelDatePersoanaJuridica.tfEmitentCurs.setText(lpjs.getPf().getEmitentCurs());
						PanelDatePersoanaJuridica.tfDataCurs.setText(lpjs.getPf().getDataCurs());
						PanelDatePersoanaJuridica.tfDenumireSocietate.setText(lpjs.getPj().getDenumire());
						PanelDatePersoanaJuridica.tfSediuSocietate.setText(lpjs.getPj().getSediu());
						PanelDatePersoanaJuridica.tfPLSocietate.setText(lpjs.getPj().getPunctDeLucru());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nu sunt inregistrate informatii in istoric!");
				}

			}
		});
		btnPreluareDateLucrare.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnPreluareDateLucrare.setBounds(590, 351, 448, 36);
		dateSocietatePanel.add(btnPreluareDateLucrare);


		JButton btnBack = new JButton("Back");
		btnBack.setIcon(Service.changeIconSize(new ImageIcon(Service.getPath("iconBack.png")), 100, 100));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jf = JFrameFactore.getFrame();
				jf.getContentPane().removeAll();
				jf.getContentPane().add(PanelMainScreen.getInstance());
				jf.revalidate();
				jf.repaint();
			}
		});
		btnBack.setBounds(1070, 315, 91, 72);dateSocietatePanel.add(btnBack);


		add(bigPanel);


	}
}
