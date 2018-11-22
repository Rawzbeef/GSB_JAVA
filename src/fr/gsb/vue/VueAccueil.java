package fr.gsb.vue;

import javax.swing.*;

public class VueAccueil extends JPanel {
	
	private JLabel jlTitre;
	
	public VueAccueil() {
		
		jlTitre = new JLabel("Remboursement des frais");
		
		this.add(jlTitre);
	}
}
