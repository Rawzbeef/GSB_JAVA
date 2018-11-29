//a completer
package fr.gsb.controleur.action;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JComboBox;

public class ActionVueAfficherFrais implements ActionListener{
	private JComboBox<String> listeVisiteur;
	private JComboBox<String> listeMois;
	public ActionVueAfficherFrais(JComboBox<String> unelisteVisiteur, JComboBox<String> unelisteMois) {
		listeVisiteur=unelisteVisiteur;
		listeMois=unelisteMois;
		}
	
	@Override
	//action performed utiliser par VueAfficherFrais
	public void actionPerformed(ActionEvent event) {		
		listeVisiteur=(JComboBox<String>)event.getSource();
		System.out.println(listeVisiteur.getSelectedItem());//afficher l'item selectionner
		listeMois.setEditable(true);
	}
}
