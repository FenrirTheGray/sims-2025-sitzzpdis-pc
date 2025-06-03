package placanje.view;

public class AppView {
	
	private ProzorA prozorA = new ProzorA();
	private ProzorB prozorB = new ProzorB(this.prozorA, "Tekst", true);
	private ProzorC prozorC = new ProzorC();
	private ProzorD prozorD = new ProzorD();

	public AppView() {
		super();
	}

	public ProzorA getProzorA() {
		return prozorA;
	}

	public void setProzorA(ProzorA prozorA) {
		this.prozorA = prozorA;
	}

	public ProzorB getProzorB() {
		return prozorB;
	}

	public void setProzorB(ProzorB prozorB) {
		this.prozorB = prozorB;
	}

	public ProzorC getProzorC() {
		return prozorC;
	}

	public void setProzorC(ProzorC prozorC) {
		this.prozorC = prozorC;
	}

	public ProzorD getProzorD() {
		return prozorD;
	}

	public void setProzorD(ProzorD prozorD) {
		this.prozorD = prozorD;
	}
	
}
