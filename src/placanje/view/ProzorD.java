package placanje.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ProzorD extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5695305432935951034L;

	// elementi
	JButton dugme = new JButton("Potvrdi");
	JLabel labelaDatum = new JLabel("Unesite datum (YYYY-MM-DD):");
	JTextField poljeZaDatum = new JTextField();

	// radio button
	JRadioButton dnevna = new JRadioButton("Dnevna");
	JRadioButton mesecna = new JRadioButton("Mesečna");

	// grupa radio button
	ButtonGroup grupa = new ButtonGroup();

	public ProzorD() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(500, 250));
		this.setMinimumSize(new Dimension(500, 250));	// min size
		this.setLocationRelativeTo(null);	// centriraj

		// panel 1
		JPanel centralniPanel = new JPanel();

		// radio button
//		JRadioButton dnevna = new JRadioButton("Dnevna"); // mora van konstruktora
//		JRadioButton mesecna = new JRadioButton("Mesečna");

		// grupa radio button
//		ButtonGroup grupa = new ButtonGroup(); // mora van konstruktora
		grupa.add(dnevna);
		grupa.add(mesecna);

		// labele
		this.labelaDatum.setVisible(false);

		// polja
		this.poljeZaDatum.setVisible(false);

		// layout
		centralniPanel.setLayout(new GridLayout(2, 2, 10, 10)); // GridLayout: broj redova, broj kolona, gap horizontalni, gap vertikalni
		centralniPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // uvlačenje komponenti (margine oko grida)

		// povezujemo panel i combobox i button
		centralniPanel.add(dnevna);
		centralniPanel.add(mesecna);

		centralniPanel.add(labelaDatum);
		centralniPanel.add(poljeZaDatum);

		// pozicioniramo panel na centar
		this.add(centralniPanel, BorderLayout.CENTER);

		// panel 2
		JPanel juzniPanel = new JPanel();

		// dugme
		this.dugme.setVisible(false);

		// povezujemo dugme i panel 2
		juzniPanel.add(dugme);

		// pozicioniramo panel na jug
		this.add(juzniPanel, BorderLayout.SOUTH);

		// eventovi
		dnevna.addActionListener(_ -> {
			this.labelaDatum.setVisible(false);
			this.poljeZaDatum.setVisible(false);
			this.pokaziDugme();
		});

		mesecna.addActionListener(_ -> {
			this.labelaDatum.setVisible(true);
			this.poljeZaDatum.setVisible(true);
			this.pokaziDugme();
		});

	}

	private void pokaziDugme() {
		this.dugme.setVisible(true);
	}

	public JButton getDugmeD() {
		return this.dugme;
	}

	public JTextField getPoljeZaDatum() {
		return this.poljeZaDatum;
	}
	
	public JRadioButton getDugmeDnevno() {
		return this.dnevna;
	}
	
	public JRadioButton getDugmeMesecno() {
		return this.mesecna;
	}

}
