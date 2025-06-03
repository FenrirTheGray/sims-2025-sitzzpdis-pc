package placanje.model;

import java.time.LocalDate;

public class Clanarina {
	
	private LocalDate pocetniDatum;
	private LocalDate krajnjiDatum;
	
	public Clanarina(LocalDate pocetniDatum, LocalDate krajnjiDatum) {
		super();
		this.pocetniDatum = pocetniDatum;
		this.krajnjiDatum = krajnjiDatum;
	}

	public LocalDate getPocetniDatum() {
		return pocetniDatum;
	}

	public LocalDate getKrajnjiDatum() {
		return krajnjiDatum;
	}
	
	
}
