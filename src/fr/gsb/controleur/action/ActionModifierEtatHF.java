package fr.gsb.controleur.action;

import java.awt.event.*;

import javax.swing.*;

import fr.gsb.vue.*;

public class ActionModifierEtatHF implements ActionListener {
	
	private Vue vue;
	private VueModifierFicheFrais vueM;
	private VueMessage vueMsg;
	private JTable tableau;
	
	public ActionModifierEtatHF(Vue vue, VueModifierFicheFrais vueM, VueMessage vueMsg, JTable tableauFrais) {
		this.vue = vue;
		this.vueM = vueM;
		this.vueMsg = vueMsg;
		this.tableau = tableauFrais;
	}
	
	public void actionPerformed(ActionEvent e) {
		int selection = this.tableau.getSelectedRow();
		// Vérification si une ligne est sélectionnée
		if (selection == -1) {
			vue.getContentPane().removeAll();
			vue.getContentPane().add(vueM).revalidate();
			vueMsg.addLabelErreur("Aucune ligne sélectionnée.");
			vue.getContentPane().revalidate();
		}
		else {
			// Affichage d'une fenetre permettant la modification de la situation/etat de la ligne hors forfait
			String num = String.valueOf(this.tableau.getValueAt(selection, 0));
			String date = (String)this.tableau.getValueAt(selection, 1);
			String lib = (String)this.tableau.getValueAt(selection, 2);
			String montant = String.valueOf(this.tableau.getValueAt(selection, 3));
			String etat = (String)this.tableau.getValueAt(selection, 4);
			new VueModifierEtatHF(vueMsg, num, date, lib, montant, etat);
		}
	}
	
}
