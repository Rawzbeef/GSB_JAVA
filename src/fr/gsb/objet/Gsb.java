package fr.gsb.objet;

import java.util.ArrayList;

import fr.gsb.modele.ModeleBDD;

public class Gsb {
	// Attributs priv�s
	private ArrayList<Visiteur> lesVisiteurs;
	
	private String idConnect�;

	private ArrayList<FraisForfait> lesFraisHorsForfaits;
	
	public Gsb() {
		this.setLesVisiteurs(ModeleBDD.initLesVisiteurs());
		this.lesFraisHorsForfaits = ModeleBDD.initLesFraisHorsForfaits(idConnect�);
		this.setIdConnect�(null);
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

	public String getIdConnect�() {
		return idConnect�;
	}

	public void setIdConnect�(String idConnect�) {
		this.idConnect� = idConnect�;
	}
}
