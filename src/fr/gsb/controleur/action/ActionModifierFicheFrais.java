package fr.gsb.controleur.action;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import fr.gsb.modele.Modele;
import fr.gsb.modele.ModeleBDD;
import fr.gsb.objet.FraisHorsForfait;
import fr.gsb.objet.Gsb;
import fr.gsb.objet.Visiteur;
import fr.gsb.vue.VueMessage;
import fr.gsb.vue.VueModifierFicheFrais;

public class ActionModifierFicheFrais implements ActionListener {

	private Gsb gsb;
	private VueModifierFicheFrais vueModifierFicheFrais;
	private VueMessage vueMsg;
	private String code;
	private JComboBox<String> jcbMois;
	private JComboBox<String> jcbVisiteur;

	public ActionModifierFicheFrais(Gsb gsb, VueModifierFicheFrais vueModifierFicheFrais, VueMessage vueMsg, String code, JComboBox<String> jcbMois, JComboBox<String> jcbVisiteur) {
		this.gsb = gsb;
		this.vueModifierFicheFrais = vueModifierFicheFrais;
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
			ArrayList<String> idVisiteurs = ModeleBDD.getVisiteursMois(Modele.dateFrancaisVersNormal(this.jcbMois.getSelectedItem().toString()));
			this.jcbVisiteur.removeAllItems();
			Visiteur visiteur;
			for(String id : idVisiteurs) {
				visiteur = this.gsb.getVisiteur(id);
				this.jcbVisiteur.addItem(id + " - " + visiteur.getNom() + " " + visiteur.getPrenom());
			}
			this.jcbVisiteur.setEnabled(true);
			break;
		case "Visiteur":

			if(this.jcbVisiteur.getSelectedItem() != null) {
				String id = Modele.concatPremierMot(this.jcbVisiteur.getSelectedItem().toString());
				JTable tableau = this.vueModifierFicheFrais.getVueValiderHorsForfait().getTableau();
				String[] title = {"Num", "Date", "Libellé", "Montant", "Situation"};
				DefaultTableModel tableModel = new DefaultTableModel(title, 0);

				ArrayList<FraisHorsForfait> lesFrais = ModeleBDD.getLesFraisHorsForfaits(Modele.dateFrancaisVersNormal(this.jcbMois.getSelectedItem().toString()), id);
				int i = 0;
				for (FraisHorsForfait f : lesFrais) {
					int idF = f.getId();
					String date = Modele.dateAnglaisVersFrancais(f.getDate());
					String libelle = f.getLibelle();
					double montant = f.getMontant();
					String situation = f.getLibelleEtat(f.getEtat());
					Object[] data = {idF ,date, libelle, montant, situation};
					tableModel.addRow(data);
					i++;
				}
				if (lesFrais.size() < 5) {
					tableau.setPreferredScrollableViewportSize(new Dimension(600, 16*i));
				}
				else {
					tableau.setPreferredScrollableViewportSize(new Dimension(600, 80));
				}
				tableau.setModel(tableModel);
				tableau.revalidate();
				
				vueModifierFicheFrais.afficheFrais();
			}
			break;
		case "Valider":
			if(this.vueModifierFicheFrais.getETP() != null && this.vueModifierFicheFrais.getKM() != null && this.vueModifierFicheFrais.getNUI() != null && this.vueModifierFicheFrais.getREP() != null) {
			String id = Modele.concatPremierMot(this.jcbVisiteur.getSelectedItem().toString());
			String mois = Modele.dateFrancaisVersNormal(this.jcbMois.getSelectedItem().toString());
			ModeleBDD.updateLaFicheFrais(id, mois, this.vueModifierFicheFrais.getETP(), this.vueModifierFicheFrais.getKM(), this.vueModifierFicheFrais.getNUI(), this.vueModifierFicheFrais.getREP(), this.vueModifierFicheFrais.getEtat());
			}
			else {
				this.vueMsg.addLabelErreur("Un champ est incorrect");
			}
		}
	}
}
