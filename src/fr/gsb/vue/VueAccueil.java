package fr.gsb.vue;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class VueAccueil extends JPanel {
	
	private JLabel jlTitre;
	
	public VueAccueil() {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		this.jlTitre = new JLabel("Remboursement des frais");
		this.jlTitre.setFont(new Font("Calibri", Font.BOLD, 20));
		
		this.add(jlTitre, c);
	}
}
