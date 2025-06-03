package placanje.model;

import java.util.ArrayList;

public class Clan extends PrijavljeniKorisnik {
	
	private ArrayList<Kartica> kartice = new ArrayList<Kartica>();
	private ArrayList<Clanarina> clanarina = new ArrayList<Clanarina>();
	
	public Clan(String email, String telefon, QRCode qrcode, Pol pol) {
		super(email, telefon, qrcode, pol);
	}

	public ArrayList<Kartica> getKartice() {
		return kartice;
	}

	public void setKartice(ArrayList<Kartica> kartice) {
		this.kartice = kartice;
	}

	public ArrayList<Clanarina> getClanarina() {
		return clanarina;
	}

	public void setClanarina(ArrayList<Clanarina> clanarina) {
		this.clanarina = clanarina;
	}
	
	public boolean addKartica(Kartica k) {
		this.kartice.add(k);
		return true;
	}
	
	public boolean removeKartica(Kartica k) {
		this.kartice.remove(k);
		return true;
	}
	
	public boolean addClanarina(Clanarina c) {
		this.clanarina.add(c);
		return true;
	}
	
	public boolean removeClanarina(Clanarina c) {
		this.clanarina.remove(c);
		return true;
	}
	
	
}
