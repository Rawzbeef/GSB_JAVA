package fr.gsb.objet;

public class FraisHorsForfait {
	
	// Attributs privés
	private int id;
	private String idV;
	private String mois;
	private String libelle;
	private String date;
	private double montant;
	
	// Constructeur
	public FraisHorsForfait(int unId, String unIdV, String unMois, String unLib, String uneDate, double unMontant) {
		this.id = unId;
		this.idV = unIdV;
		this.mois = unMois;
		this.libelle = unLib;
		this.date = uneDate;
		this.montant = unMontant;
		 
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
	
}
