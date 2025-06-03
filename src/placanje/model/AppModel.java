package placanje.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class AppModel {

	private ArrayList<Clan> clanovi = new ArrayList<Clan>();

	public AppModel() {
		super();
		
		// Član sa Karticom
		Clan c1 = new Clan("clan1@mail.com", "123-456", new QRCode("11111"), Pol.MUSKO);
		c1.addKartica(new Kartica("Kartica 1", "000001", "123", LocalDate.of(2026, 1, 1)));
		// Član bez Kartice
		Clan c2 = new Clan("clan2@mail.com", "654-321", new QRCode("22222"), Pol.ZENSKO);
		
		this.clanovi.add(c1);
		this.clanovi.add(c2);
	}

	public ArrayList<Clan> getClanovi() {
		return clanovi;
	}

	public void dodajClana(Clan c) {
		this.clanovi.add(c);
	}

	public void obrisiClana(Clan c) {
		this.clanovi.remove(c);
	}

}
