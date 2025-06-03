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

import placanje.model.Clan;

public class ProzorA extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1633429246335035393L;

	// panel
	JPanel centralniPanel = new JPanel();

	// polja
	JButton pokreni = new JButton("Početak rada");

	// combobox
	JComboBox<Clan> comboZaClanove;

	public ProzorA() {
		this.setTitle("Početni ekran");
	}

	// početna metoda
	public void init(Clan[] clanovi) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(500, 250));
		this.setMinimumSize(new Dimension(500, 250));	// min size
		this.setLocationRelativeTo(null);	// centriraj

		// layout
		centralniPanel.setLayout(new GridLayout(2, 1, 10, 10)); // GridLayout: broj redova, broj kolona, gap horizontalni, gap vertikalni
		centralniPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // uvlačenje komponenti (margine oko grida)
		
		// pripremamo za ubacivanje
		this.comboZaClanove = new JComboBox<>(clanovi);
		
		// prikazuje na ekranu
		comboZaClanove.setRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = -9040698522760007764L;
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				// izvlačimo samo email
				if (value instanceof Clan) {
					value = ((Clan)value).getEmail();
				}
				return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			}
		});

		// povezujemo polja i panel
		centralniPanel.add(comboZaClanove);
		centralniPanel.add(pokreni);

		// pozicioniramo panel
		this.add(centralniPanel, BorderLayout.CENTER);
		
		// prozor se spawnuje na centru
		this.setLocationRelativeTo(null);
		
		// podešavamo vidljivost
		this.setVisible(true);
		
		// naterati redraw
		this.pack();

	}
	
	public JButton getDugmeA() {
		return this.pokreni;
	}
	
	public JComboBox<Clan> getComboZaClanove() {
		return this.comboZaClanove;
	}

}
