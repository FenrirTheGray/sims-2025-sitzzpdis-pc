package placanje.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import placanje.model.Kartica;

public class ProzorB extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1572079861650548987L;

	// panel 1
	JPanel centralniPanel = new JPanel();

	// button
	JButton dugme = new JButton("Potvrdi");

	// labele
	JLabel labelaNaziv = new JLabel("Unesite naziv za karticu:");
	JLabel labelaBroj = new JLabel("Unesite broj kartice:");
	JLabel labelaCVV = new JLabel("Unesite cvv:");
	JLabel labelaDatum = new JLabel("Unesite datum isteka (YYYY-MM-DD):");

	// polja
	JTextField poljeZaNaziv = new JTextField();
	JTextField poljeZaBroj = new JTextField();
	JTextField poljeZaCVV = new JTextField();
	JTextField poljeZaDatum = new JTextField();

	public ProzorB(ProzorA parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setTitle("Kreiranje Kartice");
		this.setLayout(new BorderLayout());
		this.setSize(new Dimension(500, 250));
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);	// zatvara samo prozor ukoliko je Yes

		// layout
		centralniPanel.setLayout(new GridLayout(4, 2, 10, 10)); // GridLayout: broj redova, broj kolona, gap horizontalni, gap vertikalni
		centralniPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // uvlačenje komponenti (margine oko grida)

		// povezujemo polja i panel 1
		centralniPanel.add(labelaNaziv);
		centralniPanel.add(poljeZaNaziv);
		centralniPanel.add(labelaBroj);
		centralniPanel.add(poljeZaBroj);
		centralniPanel.add(labelaCVV);
		centralniPanel.add(poljeZaCVV);
		centralniPanel.add(labelaDatum);
		centralniPanel.add(poljeZaDatum);

		// pozicioniramo panel 1 na centar
		this.add(centralniPanel, BorderLayout.CENTER);

		// panel 2
		JPanel juzniPanel = new JPanel();

		// povezujemo dugme i panel 2
		juzniPanel.add(this.dugme);

		// pozicioniramo panel na jug
		this.add(juzniPanel, BorderLayout.SOUTH);

		// akcija na zatvaranje dijaloga
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// akcija kad korisnik pokuša da zatvori dijalog
				int response = JOptionPane.showConfirmDialog(ProzorB.this, "Da li hoćete da zatvorite formu?", // ProzorB.this <- naglašavamo koji this da se koristi (jer sa this on selektuje WindowAdapter)
						"Potvrdi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
//					parent.setVisible(true); // dijalog je modalan, nema potrebe za sakrivanjem
					ProzorB.this.dispose(); // zatvori dijalog
				}
			}
		});
	}
	
	public Kartica dobaviKarticuIzForme() {
		try {
			return new Kartica(this.poljeZaNaziv.getText(), this.poljeZaBroj.getText(), this.poljeZaCVV.getText(), LocalDate.parse(this.poljeZaDatum.getText()));
		} catch (Exception e) {
			return null;
		}
	}
	
	public JButton getDugmeB() {
		return this.dugme;
	}

}
