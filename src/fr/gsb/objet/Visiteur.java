package fr.gsb.objet;

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
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(String date) {
		this.dateEmbauche = date;
	}

}
