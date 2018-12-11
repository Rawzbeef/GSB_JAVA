package fr.gsb.objet;

public class FraisHorsForfait {
	
	// Attributs privés
	private int id;
	private String idV;
	private String mois;
	private String libelle;
	private String date;
	private double montant;
	private String etat;
	
	// Constructeur
	public FraisHorsForfait(int unId, String unIdV, String unMois, String unLib, String uneDate, double unMontant, String unEtat) {
		this.id = unId;
		this.idV = unIdV;
		this.mois = unMois;
		this.libelle = unLib;
		this.date = uneDate;
		this.montant = unMontant;
		this.etat = unEtat;
		 
	}
	
	// Méthodes publiques
	public int getId() {
		return this.id;
	}
	
	public String getIdVisiteur() {
		return this.idV;
	}
	
	public String getMois() {
		return this.mois;
	}
	
	public String getLibelle() {
		return this.libelle;
	}
	
	public String getDate() { 
		return this.date;
	}
	
	public double getMontant() {
		return this.montant;
	}
	
	public String getEtat() {
		return this.etat;
	}
	
	public String getLibelleEtat(String lEtat) {
		String libEtat = "En attente";
		if (lEtat.equals("1")) {
			libEtat = "Validé";
		}
		else if (lEtat.equals("2")) {
			libEtat = "Refusé";
		}
		return libEtat;
	}
	
}
