package fr.gsb.objet;

import java.util.ArrayList;

public class Visiteur {
	
	private String id;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private String adresse;
	private String cp;
	private String ville;
	private String dateEmbauche;
	
	private ArrayList<FicheFrais> lesFicheFrais;

	public Visiteur(String id, String nom, String prenom, String login, String mdp, String adresse, String cp, String ville, String date) {
		this.setId(id);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setLogin(login);
		this.setMdp(mdp);
		this.setAdresse(adresse);
		this.setCp(cp);
		this.setVille(ville);
		this.setDateEmbauche(date);
		this.setLesFicheFrais(new ArrayList<FicheFrais>());
		
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDateEmbauche() {
		return this.dateEmbauche;
	}

	public void setDateEmbauche(String date) {
		this.dateEmbauche = date;
	}

	public ArrayList<FicheFrais> getLesFicheFrais() {
		return this.lesFicheFrais;
	}

	public void setLesFicheFrais(ArrayList<FicheFrais> lesFicheFrais) {
		this.lesFicheFrais = lesFicheFrais;
	}

	public void setFicheFrais(FicheFrais ficheFrais) {
		this.lesFicheFrais.add(ficheFrais);
		
	}

}
