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
	//JPanel
	private JPanel JPNorth;
	private JPanel JPdown;

	public VueAfficherFrais(){
		this.setLayout(new BorderLayout());
		JPNorth = new JPanel();

		//listAnnees 
		String[] tabAnnees = {"2018", "2017", "2016", "2015","2014","2013","2012","2011","2010","2009","2008","2007"};
		listeAnnees = new JComboBox<String>(tabAnnees);
		listeAnnees.setPreferredSize(new Dimension(100,20));
		JPNorth.add(this.listeAnnees);
		
		//listMois 
		listeMois = new JComboBox<String>();
		listeMois.setPreferredSize(new Dimension(100,20));
		listeMois.setEnabled(false);
		JPNorth.add(this.listeMois);



		//listeVisiteur
		listeVisiteur = new JComboBox();
		listeVisiteur.setPreferredSize(new Dimension(100,20));
		listeVisiteur.setEnabled(false);
		JPNorth.add(this.listeVisiteur);

		listeMois.addActionListener(new ActionVueAfficherFrais(listeMois,listeAnnees,listeVisiteur,"Mois"));
		listeAnnees.addActionListener(new ActionVueAfficherFrais(listeMois,listeAnnees,listeVisiteur,"Annees"));
		listeVisiteur.addActionListener(new ActionVueAfficherFrais(listeMois,listeAnnees,listeVisiteur,"Visiteur"));
		//ajout dans le PanelPrinciapl
		this.add(JPNorth, BorderLayout.NORTH);
	}
}

