package fr.gsb.objet;

public class FicheFrais {
	
	// Attributs privés
	private String mois;
	private int nbJustificatifs;
	private double montantValide;
	private Date dateModif;

	
	// Constructeur
	/**
	 * Constructeur de la classe FicheFrais
	 *
	 * @param unMois mettre un mois qui est une chaine de caractères avec comme format aaaamm
	 * @param unNbJustificatifs mettre un nombre de justificatifs qui est un entier
	 * @param unMontantValide mettre un montant valide qui est un nombre décimal
	 * @param uneDateModif mettre une date qui est la date d'aujourd'hui
	 */ 
	public FicheFrais(String unMois, int unNbJustificatifs, double unMontantValide, Date uneDateModif) {
		this.mois = unMois; // Format aaaamm
		this.nbJustificatifs = unNbJustificatifs;
		this.montantValide = unMontantValide;
		this.dateModif = uneDateModif;
	}

	// Méthodes
	// GET

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
	public Date getDateModif() {
		return this.dateModif;
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
	public void setDateModif(Date uneDate) {
		this.dateModif = uneDate;
	}
}
