//a completer
package fr.gsb.controleur.action;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JComboBox;

public class ActionVueAfficherFrais implements ActionListener{
	private JComboBox<String> listeVisiteur;
	private JComboBox<String> listeMois;
	private JComboBox<String> listeAnnees;
	private String annees;
	private String mois;
	private String mot;
	public ActionVueAfficherFrais(JComboBox<String> unelisteMois ,JComboBox<String> unelisteAnnees ,JComboBox<String> unelisteVisiteur,String unMot) {
		this.listeMois=unelisteMois;
		this.listeAnnees=unelisteAnnees;
		this.listeVisiteur=unelisteVisiteur;
		this.mot=unMot;
	}

	@Override
	//action performed utiliser par VueAfficherFrais
	public void actionPerformed(ActionEvent event) {
		//switch qui prend en compte l'attribue mot qui est donnée en paramettre
		switch(mot){
		case "Mois":
			String[] tabAnnees = {"2018", "2017", "2016", "2015","2014","2013","2012","2011","2010","2009","2008","2007"};
			listeAnnees.removeAllItems();
			for(int i=0;i<12;i++){
				listeAnnees.addItem(tabAnnees[i]);	
			}
			listeAnnees.setEnabled(true);
			listeAnnees.revalidate();
			break;

			case "Annees":
				String[] tab2 = {"janne", "ferier", "marie", "michel"};
				for(int i=0;i<4;i++){
					listeVisiteur.addItem(tab2[i]);	
				}
				listeVisiteur.setEnabled(true);
				listeVisiteur.revalidate();
				break;
				
			
			case "Visiteur":
				break;
		}
	}
}
