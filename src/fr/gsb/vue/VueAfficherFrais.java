//commencement de la vueAfficherFrais
package fr.gsb.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import fr.gsb.controleur.action.ActionVueAfficherFrais;
/*
import utiliser:
-import javax.swing.JComboBox;
-import javax.swing.JPanel;
-import javax.swing.JScrollPane;
-import javax.swing.JTable;
 */
@SuppressWarnings("serial")

public class VueAfficherFrais extends JPanel {
	//JComboBox
	private JComboBox<String> listeVisiteur;
	private JComboBox<String> listeMois;
	//JPanel
	private JPanel JPNorth;
	private JPanel JPdown;

	// mettre private ArrayList<Visiteur> lesVisiteurs

	public VueAfficherFrais(){
		this.setLayout(new BorderLayout());
		JPNorth = new JPanel();

		//listeVisiteur
		String[] tab = {"Option 1", "Option 2", "Option 3", "…"};
		listeVisiteur = new JComboBox<String>(tab);
		
		listeVisiteur.addActionListener(new ActionVueAfficherFrais(listeVisiteur));
		listeVisiteur.setPreferredSize(new Dimension(100,20));
		JPNorth.add(this.listeVisiteur);
		
		/*//listMois
		String[] tab2 = {"Option 1", "Option 2", "Option 3", "…"};
		listeMois = new JComboBox(tab);
		listeMois.setPreferredSize(new Dimension(100,20));
		JPNorth.add(this.listeMois);
		 */

		//ajout dans le PanelPrinciapl
		this.add(JPNorth, BorderLayout.NORTH);
	}
}

