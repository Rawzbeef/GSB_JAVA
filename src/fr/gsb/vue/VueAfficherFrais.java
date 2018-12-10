//commencement de la vueAfficherFrais
package fr.gsb.vue;

//import
import fr.gsb.controleur.action.ActionVueAfficherFrais;

import java.awt.*;

import javax.swing.*;


/*
import utiliser:
-import javax.swing.JComboBox;
-import javax.swing.JPanel;
-import javax.swing.JScrollPane;
-import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ItemSelectable;
 */
@SuppressWarnings("serial")

public class VueAfficherFrais extends JPanel {
	//JComboBox
	private JComboBox<String> listeVisiteur;
	private JComboBox<String> listeMois;
	private JComboBox<String> listeAnnees;
	private JLabel barre;
	//JPanel
	private JPanel JPNorth;
	private JPanel JPdown;

	public VueAfficherFrais(){
		this.setLayout(new BorderLayout());
		JPNorth = new JPanel();
		barre = new JLabel ("/");
		//listAnnees 
		listeAnnees = new JComboBox<String>();
		listeAnnees.setPreferredSize(new Dimension(100,20));
		listeAnnees.setEnabled(false);
		
		//listMois 
		String[] tabMois = {"01", "02", "03", "04","05","06","07","08","09","10","11","12"};
		listeMois = new JComboBox<String>(tabMois);
		listeMois.setPreferredSize(new Dimension(100,20));
		

		//listeVisiteur
		listeVisiteur = new JComboBox();
		listeVisiteur.setPreferredSize(new Dimension(100,20));
		listeVisiteur.setEnabled(false);
		
		//ajout dans leJPNorth
		JPNorth.add(this.listeMois);
		JPNorth.add(this.barre);
		JPNorth.add(this.listeAnnees);
		JPNorth.add(this.listeVisiteur);
		
		// ajout action listener
		listeMois.addActionListener(new ActionVueAfficherFrais(listeMois,listeAnnees,listeVisiteur,"Mois"));
		listeAnnees.addActionListener(new ActionVueAfficherFrais(listeMois,listeAnnees,listeVisiteur,"Annees"));
		listeVisiteur.addActionListener(new ActionVueAfficherFrais(listeMois,listeAnnees,listeVisiteur,"Visiteur"));
		//ajout dans le PanelPrinciapl
		this.add(JPNorth, BorderLayout.NORTH);
	}
}

