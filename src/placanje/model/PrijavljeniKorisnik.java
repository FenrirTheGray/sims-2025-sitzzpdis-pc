package placanje.model;

public abstract class PrijavljeniKorisnik {
	
	private String email;
	private String telefon;
	private QRCode qrcode;
	private Pol pol;
	
	public PrijavljeniKorisnik(String email, String telefon, QRCode qrcode, Pol pol) {
		super();
		this.email = email;
		this.telefon = telefon;
		this.qrcode = qrcode;
		this.pol = pol;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public QRCode getQrcode() {
		return qrcode;
	}

	public void setQrcode(QRCode qrcode) {
		this.qrcode = qrcode;
	}

	public Pol getPol() {
		return pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}
	
	
}
