package fr.gsb.objet;

import java.util.ArrayList;

import fr.gsb.modele.ModeleBDD;

public class Gsb {
	// Attributs privés
	private ArrayList<Visiteur> lesVisiteurs;
	
	private String idConnecté;

	private ArrayList<FraisForfait> lesFraisHorsForfaits;
	
	public Gsb() {
		this.setLesVisiteurs(ModeleBDD.initLesVisiteurs());
		this.lesFraisHorsForfaits = ModeleBDD.initLesFraisHorsForfaits(idConnecté);
		this.setIdConnecté(null);
	}

	public ArrayList<Visiteur> getLesVisiteurs() {
		return this.lesVisiteurs;
	}

	public void setLesVisiteurs(ArrayList<Visiteur> lesVisiteurs) {
		this.lesVisiteurs = lesVisiteurs;
	}
	
	public Visiteur getVisiteur(String id) {
		int i = 0;
		while(i < this.lesVisiteurs.size() && !this.lesVisiteurs.get(i).getId().equals(id)) {
			i++;
		}
		if(i < this.lesVisiteurs.size() && this.lesVisiteurs.get(i).getId().equals(id)) {
			return this.lesVisiteurs.get(i);
		}
		else {
			return null;
		}
	}

	public String getIdConnecté() {
		return idConnecté;
	}

	public void setIdConnecté(String idConnecté) {
		this.idConnecté = idConnecté;
	}
}
