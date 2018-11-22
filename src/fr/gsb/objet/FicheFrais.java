package fr.gsb.objet;

public class FicheFrais {
	
	// Attributs priv�s
	private String mois;
	private int nbJustificatifs;
	private double montantValide;
	private Date dateModif;

	
	// Constructeur
	/**
	 * Constructeur de la classe FicheFrais
	 *
	 * @param unMois mettre un mois qui est une chaine de caract�res avec comme format aaaamm
	 * @param unNbJustificatifs mettre un nombre de justificatifs qui est un entier
	 * @param unMontantValide mettre un montant valide qui est un nombre d�cimal
	 * @param uneDateModif mettre une date qui est la date d'aujourd'hui
	 */ 
	public FicheFrais(String unMois, int unNbJustificatifs, double unMontantValide, Date uneDateModif) {
		this.mois = unMois; // Format aaaamm
		this.nbJustificatifs = unNbJustificatifs;
		this.montantValide = unMontantValide;
		this.dateModif = uneDateModif;
	}

	// M�thodes
	// GET

	/**
	 * M�thode qui permet de retourner le mois 
	 */
	public String getMois() {
		return this.mois;
	}


	/**
	 * M�thode qui permet de retourner le nombre de justificatifs 
	 */
	public int getNbJustificatifs() {
		return this.nbJustificatifs;
	}


	/**
	 * M�thode qui permet de retourner le montant valide de la fiche 
	 */
	public double getMontantValide() {
		return this.montantValide;
	}


	/**
	 * M�thode qui permet de retourner la dateModif
	 */
	public Date getDateModif() {
		return this.dateModif;
	}

	// SET

	/**
	 * M�thode qui permet de changer un mois de la classe FicheFrais 
	 *
	 * @param unMois mettre un mois qui est une chaine de caract�res et de format aaaamm
	 */ 
	public void setMois(String unMois) {
		this.mois = unMois;
	}


	/**
	 * M�thode qui permet de changer le nombre de justificatifs de la classe FicheFrais
	 *
	 * @param unNbJustificatifs mettre un nbJustificatifs qui est un entier
	 */ 
	public void setNbJustificatifs(int unNbJustificatifs) {
		this.nbJustificatifs = unNbJustificatifs;
	}


	/**
	 * M�thode qui permet de changer le montant valide de la classe FicheFrais 
	 *
	 * @param unMontantValide mettre un montantValide qui est un nombre d�cimal
	 */ 
	public void setMontantValide(double unMontantValide) {
		this.montantValide = unMontantValide;
	}


	/**
	 * M�thode qui permet de changer une dateModif de la classe FicheFrais 
	 *
	 * @param uneDate mettre une dateModif de type Date
	 */ 
	public void setDateModif(Date uneDate) {
		this.dateModif = uneDate;
	}
}
