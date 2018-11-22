//commencement de la vueAfficherFrais
package fr.gsb.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
/*
import utiliser:
-import javax.swing.JComboBox;
-import javax.swing.JPanel;
-import javax.swing.JScrollPane;
-import javax.swing.JTable;
 */
@SuppressWarnings("serial")

public class VueAfficherFrais extends JPanel {
	private JComboBox listeVisiteur;
	private JPanel North;
	private JPanel middle;
	private JPanel down;

	public VueAfficherFrais(){
		this.setLayout(new BorderLayout());
		North = new JPanel();
		listeVisiteur = new JComboBox();
		String[] tab = {"Option 1", "Option 2", "Option 3", "…"};
		listeVisiteur = new JComboBox(tab);
		listeVisiteur.setPreferredSize(new Dimension(100,20));
		North.add(this.listeVisiteur, BorderLayout.NORTH);
		
	}
}
