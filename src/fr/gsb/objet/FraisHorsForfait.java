package fr.gsb.objet;

public class FraisHorsForfait {
	
	// Attributs privés
	private int id;
	private String mois;
	private String libelle;
	private String date;
	private double montant;
	private Visiteur unVisiteur;
	
	// Constructeur
	public FraisHorsForfait(int unId, String unMois, String unLib, String uneDate, double unMontant, Visiteur v) {
		this.id = unId;
		this.mois = unMois;
		this.libelle = unLib;
		this.date = uneDate;
		this.montant = unMontant;
		this.unVisiteur = v;
	}
	
	// Méthodes publiques
	public int getId() {
		return this.id;
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
	
	public Visiteur getVisiteur() {
		return this.unVisiteur;
	}
	
}
