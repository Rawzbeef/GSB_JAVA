package fr.gsb.vue;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class VueAccueil extends JPanel {
	
	private JLabel jlTitre;
	private JLabel jlLogo;
	
	public VueAccueil() {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		this.jlTitre = new JLabel("Remboursement des frais");
		this.jlTitre.setFont(new Font("Calibri", Font.BOLD, 20));
		
		this.jlLogo = new JLabel(new ImageIcon("img/logo.jpg"));
		
		c.gridx = 0;
		c.gridy = 0;
		this.add(jlTitre, c);
		c.gridy++;
		this.add(jlLogo, c);
	}
}
