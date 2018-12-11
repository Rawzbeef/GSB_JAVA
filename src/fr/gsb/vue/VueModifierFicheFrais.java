package fr.gsb.vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.gsb.modele.Modele;
import fr.gsb.modele.ModeleBDD;

@SuppressWarnings("serial")
public class VueModifierFicheFrais extends JPanel {
	
	private JLabel jlMois;
	private JComboBox<String> jcbMois;
	
	private JLabel jlVisiteur;
	private JComboBox<String> jcbVisiteur;
	

	public VueModifierFicheFrais() {
		this.setLayout(new GridBagLayout());
		
		this.jlMois = new JLabel("Mois : ");
		
		ArrayList<String> list = ModeleBDD.getLesMois();
		String[] tab = Modele.toTab(list);
		this.jcbMois = new JComboBox<String>(tab);
		
		this.jlVisiteur = new JLabel("Visiteurs : ");
		this.jcbVisiteur = new JComboBox<String>();
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		this.add(this.jlMois, c);
		c.gridx++;
		this.add(this.jcbMois, c);
		c.gridx = 0;
		c.gridy++;
		this.add(this.jlVisiteur, c);
		c.gridx++;
		this.add(this.jcbVisiteur, c);
	}
}
