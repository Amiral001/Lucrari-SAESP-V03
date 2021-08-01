package com.nicholas.screens;

import com.nicholas.JFrameFactore;
import com.nicholas.data.DataBase;
import com.nicholas.entitys.Lucrare;
import com.nicholas.entitys.LucrarePersoanaJuridica;
import com.nicholas.entitys.PersoanaFizica;
import com.nicholas.entitys.PersoanaJuridica;
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
		
		PanelDatePersoanaFizica panelDatePersoanaFizica = new PanelDatePersoanaFizica(); panelDatePersoanaFizica.setBounds(0, 0, 1200, 383);
		panelDatePersoanaFizica.setLayout(null);
		
		
		PanelDatePersoanaJuridica dateSocietatePanel = new PanelDatePersoanaJuridica();
		dateSocietatePanel.setBounds(0, 380, 1200, 420); dateSocietatePanel.setLayout(null);
		bigPanel.setLayout(null);
		
		
		bigPanel.add(panelDatePersoanaFizica);
		bigPanel.add(dateSocietatePanel);
		
		JButton btnVerificari = new JButton("Genereaza documentatie verificari");
		btnVerificari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pf = new PersoanaFizica();
				pj = new PersoanaJuridica();
				lpj = new LucrarePersoanaJuridica();

				if (!(PanelDatePersoanaFizica.tfNrLucrare.getText().equals("") || PanelDatePersoanaFizica.tfDataLucrare.getText().equals("") ||
						PanelDatePersoanaFizica.tfNumeSolicitant.getText().equals("") || PanelDatePersoanaFizica.tfPrenumeSolicitant.getText().equals("")
						|| PanelDatePersoanaFizica.tfCNPSolicitant.getText().equals(""))) {

					pf.setNume(PanelDatePersoanaFizica.tfNumeSolicitant.getText()); pf.setPrenume(PanelDatePersoanaFizica.tfPrenumeSolicitant.getText());
					pf.setCnp(PanelDatePersoanaFizica.tfCNPSolicitant.getText()); pf.setAdresaDomiciliu(PanelDatePersoanaFizica.tfDomiciliuSolicitant.getText());
					pf.setUnitate01(PanelDatePersoanaFizica.tfUnitateDomiciliu.getText()); pf.setSubunitate01(PanelDatePersoanaFizica.tfSubunitateDomiciliu.getText());
					pf.setAdresaResedinta(PanelDatePersoanaFizica.tfResedintaSolicintant.getText()); pf.setUnitate02(PanelDatePersoanaFizica.tfUnitateResedinta.getText());
					pf.setSubunitate02(PanelDatePersoanaFizica.tfSubunitateresedinta.getText()); pf.setNumarTelefon(PanelDatePersoanaFizica.tfTelefonSolicitant.getText());
					pf.setEmitentAtestat(PanelDatePersoanaJuridica.tfEmitentAtestat.getText()); pf.setSerieNrAtestat(PanelDatePersoanaJuridica.tfNrSerieAtestat.getText());
					pf.setDataAtestat(PanelDatePersoanaJuridica.tfDataAtestat.getText());pf.setEmitentCurs(PanelDatePersoanaJuridica.tfEmitentCurs.getText());
					pf.setDataCurs(PanelDatePersoanaJuridica.tfDataCurs.getText());
					pf.setDomAltJud(PanelDatePersoanaFizica.chckbxDomAltJud.isSelected() ? "Da" : "Nu");
					pf.setResAltJud(PanelDatePersoanaFizica.chckbxResAltJud.isSelected() ? "Da" : "Nu");

					pj.setDenumire(PanelDatePersoanaJuridica.tfDenumireSocietate.getText());
					pj.setSediu(PanelDatePersoanaJuridica.tfSediuSocietate.getText()); pj.setPunctDeLucru(PanelDatePersoanaJuridica.tfPLSocietate.getText());


					lpj.setNrLucrare(PanelDatePersoanaFizica.tfNrLucrare.getText()); lpj.setDataLucrare(Service.stringToDate(PanelDatePersoanaFizica.tfDataLucrare.getText()));
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
						PanelDatePersoanaFizica.tfNumeSolicitant.setText(pfs.getNume());
						PanelDatePersoanaFizica.tfPrenumeSolicitant.setText(pfs.getPrenume());
						PanelDatePersoanaFizica.tfCNPSolicitant.setText(pfs.getCnp());
						PanelDatePersoanaFizica.tfDomiciliuSolicitant.setText(pfs.getAdresaDomiciliu());
						PanelDatePersoanaFizica.tfUnitateDomiciliu.setText(pfs.getUnitate01());
						PanelDatePersoanaFizica.tfSubunitateDomiciliu.setText(pfs.getSubunitate01());
						PanelDatePersoanaFizica.tfResedintaSolicintant.setText(pfs.getAdresaResedinta());
						PanelDatePersoanaFizica.tfUnitateResedinta.setText(pfs.getUnitate02());
						PanelDatePersoanaFizica.tfSubunitateresedinta.setText(pfs.getSubunitate02());
						PanelDatePersoanaFizica.tfTelefonSolicitant.setText(pfs.getNumarTelefon());
						if (pfs.getDomAltJud().equals("Da")) {
							PanelDatePersoanaFizica.chckbxDomAltJud.setSelected(true);
						} else if (pfs.getResAltJud().equals("Da")){
							PanelDatePersoanaFizica.chckbxResAltJud.setSelected(true);
						}
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
							try {
								lpjs = (LucrarePersoanaJuridica) lpj;
							} catch (ClassCastException exception) {
								exception.printStackTrace();
								JOptionPane.showMessageDialog(null, "Eroare: Lucrarea selectată este din rândul celor pentru persoane fizice și nu juridice!");
							}
						}
					}
					if (result != null) {
						assert lpj != null;
							PanelDatePersoanaFizica.tfNrLucrare.setText(lpjs.getNrLucrare());
							PanelDatePersoanaFizica.tfDataLucrare.setText(Service.dateToString(lpjs.getDataLucrare()));
							PanelDatePersoanaFizica.tfNumeSolicitant.setText(lpjs.getPf().getNume());
							PanelDatePersoanaFizica.tfPrenumeSolicitant.setText(lpjs.getPf().getPrenume());
							PanelDatePersoanaFizica.tfCNPSolicitant.setText(lpjs.getPf().getCnp());
							PanelDatePersoanaFizica.tfDomiciliuSolicitant.setText(lpjs.getPf().getAdresaDomiciliu());
							PanelDatePersoanaFizica.tfUnitateDomiciliu.setText(lpjs.getPf().getUnitate01());
							PanelDatePersoanaFizica.tfSubunitateDomiciliu.setText(lpjs.getPf().getSubunitate01());
							PanelDatePersoanaFizica.tfResedintaSolicintant.setText(lpjs.getPf().getAdresaResedinta());
							PanelDatePersoanaFizica.tfUnitateResedinta.setText(lpjs.getPf().getUnitate02());
							PanelDatePersoanaFizica.tfSubunitateresedinta.setText(lpjs.getPf().getSubunitate02());
							PanelDatePersoanaFizica.tfTelefonSolicitant.setText(lpjs.getPf().getNumarTelefon());
							PanelDatePersoanaJuridica.tfEmitentAtestat.setText(lpjs.getPf().getEmitentAtestat());
							PanelDatePersoanaJuridica.tfNrSerieAtestat.setText(lpjs.getPf().getSerieNrAtestat());
							PanelDatePersoanaJuridica.tfDataAtestat.setText(lpjs.getPf().getDataAtestat());
							PanelDatePersoanaJuridica.tfEmitentCurs.setText(lpjs.getPf().getEmitentCurs());
							PanelDatePersoanaJuridica.tfDataCurs.setText(lpjs.getPf().getDataCurs());
							PanelDatePersoanaJuridica.tfDenumireSocietate.setText(lpjs.getPj().getDenumire());
							PanelDatePersoanaJuridica.tfSediuSocietate.setText(lpjs.getPj().getSediu());
							PanelDatePersoanaJuridica.tfPLSocietate.setText(lpjs.getPj().getPunctDeLucru());
						if (lpj.getPf().getDomAltJud().equals("Da")) {
							PanelDatePersoanaFizica.chckbxDomAltJud.setSelected(true);
						} else if (lpj.getPf().getResAltJud().equals("Da")){
							PanelDatePersoanaFizica.chckbxResAltJud.setSelected(true);
						}
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
