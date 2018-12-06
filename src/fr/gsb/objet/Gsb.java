package fr.gsb.objet;

import java.util.ArrayList;

import fr.gsb.modele.ModeleBDD;

public class Gsb {
	// Attributs priv�s
	private ArrayList<Visiteur> lesVisiteurs;
	private ArrayList<FraisHorsForfait> lesFraisHorsForfaits;
	private String idConnect�;
	
	public Gsb() {
		this.setLesVisiteurs(ModeleBDD.initLesVisiteurs());
		
		this.lesFraisHorsForfaits = ModeleBDD.getLesFraisHorsForfaits(idConnect�);
		
		ModeleBDD.initLienFicheFrais(lesVisiteurs);

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

	public ArrayList<FraisHorsForfait> getLesFraisHorsForfaits() {
		return this.lesFraisHorsForfaits;
	}

	public void setLesFraisHorsForfaits(ArrayList<FraisHorsForfait> lesFraisHorsForfaits) {
		this.lesFraisHorsForfaits = lesFraisHorsForfaits;
	}

	public String getIdConnect�() {
		return idConnect�;
	}

	public void setIdConnect�(String idConnect�) {
		this.idConnect� = idConnect�;
	}
}
