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
	//JPanel
	private JPanel JPNorth;
	private JPanel JPdown;
	// mettre private ArrayList<Visiteur> lesVisiteurs
	
	public VueAfficherFrais(){
		this.setLayout(new BorderLayout());
		JPNorth = new JPanel();

		//listMois 
		String[] tab = {"janvier", "fevrier", "mars", "avril","mai","juin","juillet","aout","septembre","octobre","novembre","decembre"};
		listeMois = new JComboBox<String>(tab);//listeMois
		listeMois.setPreferredSize(new Dimension(100,20));//listeMois
		JPNorth.add(this.listeMois);//listeMois
		
		//listeVisiteur
		listeVisiteur = new JComboBox();//listeVisiteur
		listeVisiteur.setPreferredSize(new Dimension(100,20));//listeVisiteur
		listeVisiteur.setEnabled(false);
		JPNorth.add(this.listeVisiteur);
		 
		listeMois.addActionListener(new ActionVueAfficherFrais(listeMois,listeVisiteur));
		//ajout dans le PanelPrinciapl
		this.add(JPNorth, BorderLayout.NORTH);
	}
}

