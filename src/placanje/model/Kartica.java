package placanje.model;

import java.time.LocalDate;

public class Kartica {
	
	private String naziv;
	private String broj;
	private String cvv;
	private LocalDate datumIsteka;
	
	public Kartica(String naziv, String broj, String cvv, LocalDate datumIsteka) {
		super();
		this.naziv = naziv;
		this.broj = broj;
		this.cvv = cvv;
		this.datumIsteka = datumIsteka;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getBroj() {
		return broj;
	}

	public String getCvv() {
		return cvv;
	}

	public LocalDate getDatumIsteka() {
		return datumIsteka;
	}
	
	
}
