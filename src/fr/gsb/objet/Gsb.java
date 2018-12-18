package fr.gsb.objet;

import java.util.ArrayList;

import fr.gsb.modele.ModeleBDD;

public class Gsb {
	// Attributs privés
	private ArrayList<Visiteur> lesVisiteurs;
	private ArrayList<FicheFrais> lesFichesFrais;
	private String idConnecté;
	
	public Gsb() {
		this.setLesVisiteurs(ModeleBDD.initLesVisiteurs());
		
		this.lesFichesFrais = ModeleBDD.initLesFichesFrais();
		
		ModeleBDD.initLienFicheFrais(lesVisiteurs);

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

	public ArrayList<FraisHorsForfait> getLesFraisHorsForfaits(String mois, String idV) {
		return ModeleBDD.getLesFraisHorsForfaits(mois, idV);
	}
	
	public ArrayList<FicheFrais> getLesFichesFrais(String mois) {
		ArrayList<FicheFrais> liste = new ArrayList<FicheFrais>();
		for(FicheFrais fiche : this.lesFichesFrais) {
			if(fiche.getMois() == mois) {
				liste.add(fiche);
			}
		}
		return liste;
	}
	
	public FicheFrais getUneFicheFrais(String mois, String id) {
		int i = 0;
		FicheFrais fiche = null;
		System.out.println("Fournis : " + mois + " " + id );
		while(i < this.lesFichesFrais.size() && this.lesFichesFrais.get(i).getMois() != mois && this.lesFichesFrais.get(i).getId() != id) {
			i++;
			System.out.println(i + " - " + this.lesFichesFrais.get(i).getMois() + " " + this.lesFichesFrais.get(i).getId());
		}
		if(i < this.lesFichesFrais.size() && this.lesFichesFrais.get(i).getMois() == mois && this.lesFichesFrais.get(i).getId() == id) {
			fiche = this.lesFichesFrais.get(i);
		}
		return fiche;
	}

	public String getIdConnecté() {
		return idConnecté;
	}

	public void setIdConnecté(String idConnecté) {
		this.idConnecté = idConnecté;
	}
}
