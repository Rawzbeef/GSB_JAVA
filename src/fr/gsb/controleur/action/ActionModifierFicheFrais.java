package fr.gsb.controleur.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import fr.gsb.modele.Modele;
import fr.gsb.modele.ModeleBDD;
import fr.gsb.objet.Gsb;
import fr.gsb.objet.Visiteur;
import fr.gsb.vue.Vue;
import fr.gsb.vue.VueMessage;

public class ActionModifierFicheFrais implements ActionListener {
	
	private Gsb gsb;
	private Vue vue;
	private VueMessage vueMsg;
	private String code;
	private JComboBox<String> jcbMois;
	private JComboBox<String> jcbVisiteur;
	
	public ActionModifierFicheFrais(Gsb gsb, Vue vue, VueMessage vueMsg, String code, JComboBox<String> jcbMois, JComboBox<String> jcbVisiteur) {
		this.gsb = gsb;
		this.vue = vue;
		this.vueMsg = vueMsg;
		this.code = code;
		this.jcbMois = jcbMois;
		this.jcbVisiteur = jcbVisiteur;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		vueMsg.reset();
		//un switch pour différencier tel bouton selon le code
		switch(this.code) {
		//JComboBox pour les mois
		case "Mois": 
			if(!this.jcbMois.getSelectedItem().equals("AAAAMM")) {
				this.jcbMois.removeItem("AAAAMM");
				ArrayList<String> idVisiteurs = ModeleBDD.getVisiteursMois(this.jcbMois.getSelectedItem().toString());
				this.jcbVisiteur.removeAllItems();
				this.jcbVisiteur.addItem("id - nom prenom");
				Visiteur visiteur;
				for(String id : idVisiteurs) {
					visiteur = this.gsb.getVisiteur(id);
					this.jcbVisiteur.addItem(id + " - " + visiteur.getNom() + " " + visiteur.getPrenom());
				}
				this.jcbVisiteur.setEnabled(true);
			}
			break;
		case "Visiteur":
			if(!this.jcbVisiteur.getSelectedItem().equals("id - nom prenom")) {
				this.jcbVisiteur.removeItem("id - nom prenom");
				String id = Modele.concatPremierMot(this.jcbVisiteur.getSelectedItem().toString());
				
			}
			break;
		}
		
	}

}
