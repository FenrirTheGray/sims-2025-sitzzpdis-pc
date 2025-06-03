package placanje.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import placanje.model.Kartica;

public class ProzorC extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6634110058694824849L;

	// panel
	JPanel centralniPanel = new JPanel();

	// button
	JButton dugme = new JButton("Potvrdi");

	// combobox
	JComboBox<Kartica> comboZaKartice;

	public ProzorC() {
		this.setTitle("Izbor kartice");
	}

	// početna metoda
	public void init(Kartica[] kartice) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(500, 250));
		this.setMinimumSize(new Dimension(500, 250));	// min size
		// this.setLocationRelativeTo(null);	// setovan u odnosu na Prozor A

		// layout
		centralniPanel.setLayout(new GridLayout(2, 1, 10, 10)); // GridLayout: broj redova, broj kolona, gap horizontalni, gap vertikalni
		centralniPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // uvlačenje komponenti (margine oko grida)

		// pripremamo za ubacivanje
		this.comboZaKartice = new JComboBox<>(kartice);

		// prikazuje na ekranu
		comboZaKartice.setRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = -9040698522760007764L;
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				// izvlacimo samo naziv
				if (value instanceof Kartica) {
					value = ((Kartica)value).getNaziv();
				}
				return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			}
		});

		// povezujemo polja i panel
		centralniPanel.add(comboZaKartice);
		centralniPanel.add(dugme);

		// pozicioniramo panel
		this.add(centralniPanel, BorderLayout.CENTER);

		// naterati redraw
		this.pack();

	}
	
	public JButton getDugmeC() {
		return this.dugme;
	}
	
	public JComboBox<Kartica> getComboZaKartice() {
		return this.comboZaKartice;
	}

}