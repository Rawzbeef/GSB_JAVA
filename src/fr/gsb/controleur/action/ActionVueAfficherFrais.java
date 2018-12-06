//a completer
package fr.gsb.controleur.action;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JComboBox;

public class ActionVueAfficherFrais implements ActionListener{
	private JComboBox<String> listeVisiteur;
	private JComboBox<String> listeMois;
	private String mot;
	public ActionVueAfficherFrais(JComboBox<String> unelisteMois , JComboBox<String> unelisteVisiteur,String unMot) {
		this.listeMois=unelisteMois;
		this.listeVisiteur=unelisteVisiteur;
		this.mot=unMot;
	}

	@Override
	//action performed utiliser par VueAfficherFrais
	public void actionPerformed(ActionEvent event) {
		
		switch(mot){
			case "Mois":
				listeVisiteur.removeAllItems();
				String[] tab2 = {"","janne", "ferier", "marie", "michel"};
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
