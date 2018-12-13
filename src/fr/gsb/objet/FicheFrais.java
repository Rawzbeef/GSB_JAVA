package fr.gsb.objet;

public class FicheFrais {
	
	// Attributs privés
	private String id;
	private String mois;
	private int nbJustificatifs;
	private double montantValide;
	private String dateModif;
	private String etat;

	
	// Constructeur
	/**
	 * Constructeur de la classe FicheFrais
	 *
	 * @param unMois mettre un mois qui est une chaine de caractères avec comme format aaaamm
	 * @param unNbJustificatifs mettre un nombre de justificatifs qui est un entier
	 * @param unMontantValide mettre un montant valide qui est un nombre décimal
	 * @param uneDateModif mettre une date qui est la date d'aujourd'hui
	 * @param unEtat mettre l'état de la fiche de frais qui se compose de deux caractères
	 */ 
	public FicheFrais(String id, String unMois, int unNbJustificatifs, double unMontantValide, String uneDateModif, String unEtat) {
		this.id = id;
		this.mois = unMois; // Format aaaamm
		this.nbJustificatifs = unNbJustificatifs;
		this.montantValide = unMontantValide;
		this.dateModif = uneDateModif;
		this.etat = unEtat;
	}

	// Méthodes
	// GET

	/**
	 * Méthode qui permet de retourner l'id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Méthode qui permet de retourner le mois 
	 */
	public String getMois() {
		return this.mois;
	}


	/**
	 * Méthode qui permet de retourner le nombre de justificatifs 
	 */
	public int getNbJustificatifs() {
		return this.nbJustificatifs;
	}


	/**
	 * Méthode qui permet de retourner le montant valide de la fiche 
	 */
	public double getMontantValide() {
		return this.montantValide;
	}


	/**
	 * Méthode qui permet de retourner la dateModif
	 */
	public String getDateModif() {
		return this.dateModif;
	}
	
	/**
	 * Méthode qui retourne l'état de la fiche de frais
	 */
	public String getEtat() {
		return this.etat;
	}

	// SET

	/**
	 * Méthode qui permet de changer un mois de la classe FicheFrais 
	 *
	 * @param unMois mettre un mois qui est une chaine de caractères et de format aaaamm
	 */ 
	public void setMois(String unMois) {
		this.mois = unMois;
	}


	/**
	 * Méthode qui permet de changer le nombre de justificatifs de la classe FicheFrais
	 *
	 * @param unNbJustificatifs mettre un nbJustificatifs qui est un entier
	 */ 
	public void setNbJustificatifs(int unNbJustificatifs) {
		this.nbJustificatifs = unNbJustificatifs;
	}


	/**
	 * Méthode qui permet de changer le montant valide de la classe FicheFrais 
	 *
	 * @param unMontantValide mettre un montantValide qui est un nombre décimal
	 */ 
	public void setMontantValide(double unMontantValide) {
		this.montantValide = unMontantValide;
	}


	/**
	 * Méthode qui permet de changer une dateModif de la classe FicheFrais 
	 *
	 * @param uneDate mettre une dateModif de type Date
	 */ 
	public void setDateModif(String uneDate) {
		this.dateModif = uneDate;
	}
}
