package placanje.controller;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import placanje.model.AppModel;
import placanje.model.Clan;
import placanje.model.Clanarina;
import placanje.model.Kartica;
import placanje.view.AppView;

public class AppController {

	private AppModel model = new AppModel();
	private AppView view = new AppView();

	public AppController(AppModel model, AppView view) {
		super();
		this.model = model;
		this.view = view;
	}

	public AppModel getModel() {
		return model;
	}

	public void setModel(AppModel model) {
		this.model = model;
	}

	public AppView getView() {
		return view;
	}

	public void setView(AppView view) {
		this.view = view;
	}

	public void produzenjeClanarine() {
		this.view.getProzorA().init(this.model.getClanovi().toArray(Clan[]::new));

		this.view.getProzorA().getDugmeA().addActionListener(_ -> {	
			Clan c = ((Clan)this.view.getProzorA().getComboZaClanove().getSelectedItem());
			if (c.getKartice().size() > 0) {
				this.view.getProzorC().init(c.getKartice().toArray(Kartica[]::new));
				this.view.getProzorC().setLocationRelativeTo(this.view.getProzorA()); // prati kretanje (poziciju) prethodnog prozora
				this.view.getProzorA().setVisible(false);
				this.view.getProzorC().setVisible(true);
			} else {
				this.view.getProzorB().setLocationRelativeTo(this.view.getProzorA());
				this.view.getProzorB().setVisible(true);
			}	
		});

		this.view.getProzorB().getDugmeB().addActionListener(_ -> {
			Clan c = ((Clan)this.view.getProzorA().getComboZaClanove().getSelectedItem());
			Kartica k = this.view.getProzorB().dobaviKarticuIzForme();
			if (k != null) {
				c.addKartica(k);
				this.view.getProzorC().init(c.getKartice().toArray(Kartica[]::new));
				this.view.getProzorC().setLocationRelativeTo(this.view.getProzorB());
				this.view.getProzorA().setVisible(false);
				this.view.getProzorC().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this.view.getProzorA(), 
						"Pogrešan format datuma. Ponovite unos.", 
						"Greška!", 
						JOptionPane.ERROR_MESSAGE);
			}
		});

		this.view.getProzorC().getDugmeC().addActionListener(_ -> {
//			Clan c = ((Clan)this.view.getProzorA().getComboZaClanove().getSelectedItem());
//			Kartica k = ((Kartica)this.view.getProzorC().getComboZaKartice().getSelectedItem());
			this.view.getProzorC().setVisible(false);
			this.view.getProzorD().setVisible(true);
		});

		this.view.getProzorD().getDugmeD().addActionListener(_ -> {
			if (this.view.getProzorD().getDugmeDnevno().isSelected()) {
				if (this.prikazUspesnosti()) {
					Clan c = ((Clan)this.view.getProzorA().getComboZaClanove().getSelectedItem());
					c.addClanarina(new Clanarina(LocalDate.now(), LocalDate.now().plusDays(1)));
					System.exit(0);
				} else {
					this.view.getProzorD().setVisible(false);
					this.view.getProzorC().setVisible(true);
				}	
				//				Clanarina cl = new Clanarina();
				//				cl.dodajDnevno(); // uvećaj za +1 dan	
			} //else if (this.view.getProzorD().getDugmeMesecno().isSelected()) {
			//				String unetiDatum = this.view.getProzorD().getPoljeZaDatum().trim();
			//				if (unetiDatum.isEmpty()) {
			//					Clanarina cl = new Clanarina();
			//					if (clanarinaPostoji()) {
			//						produziOdDatumaPrethodne()
			//					} else {
			//						produziOdDanasnjegDatuma()
			//					}
			//				} else {
			//					LocalDate datum = xxx;
			//					cl.add(datum)
			//					JOptionPane.showMessageDialog(this.view.getProzorA(), 
			//            		"Pogrešan format datuma. Ponovite unos.", 
			//            		"Greška!", 
			//            		JOptionPane.ERROR_MESSAGE);
			//				}
			//			}

		});
	}
	
	// Metoda za simulaciju uspešnosti produženja članarine
	public boolean prikazUspesnosti() {
		// Generiši nasumičan broj između 0.0 i 1.0
		double random = Math.random();
		if (random < 0.5) {
			// Uspešno
			JOptionPane.showMessageDialog(null, "Uspešno!", "Result", JOptionPane.INFORMATION_MESSAGE);
			// Tajmer za zatvaranje dijaloga posle 3 sekunde
//			new Timer(3000, new ActionListener() {
//			    @Override
//			    public void actionPerformed(ActionEvent e) {
//			        this.dispose();  // Zatvori dijalog
//			    }
//			}).start();
			return true;
		} else {
			// Bezuspešno
			JOptionPane.showMessageDialog(null, "Greška!", "Result", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	

}
