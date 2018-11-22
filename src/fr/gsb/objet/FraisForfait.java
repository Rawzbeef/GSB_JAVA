package fr.gsb.objet;

public class FraisForfait {

	// Attributs privés
	private String id;
	private String libelle;
	private double montant;

	// Constructeur
	/**
	 * Constructeur de la classe FraisForfait
	 *
	 * @param unId identifiant qui est une chaine de caractères
	 * @param unLibelle libelle qui est une chaine de caractères
	 * @param unMontant montant qui est un nombre décimal
	 */ 
	public FraisForfait(String unId, String unLibelle, double unMontant){
		this.id = unId;
		this.libelle = unLibelle;
		this.montant = unMontant;
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
	 * Méthode qui permet de retourner le libellé 
	 */
	public String getLibelle() {
		return this.libelle;
	}


	/**
	 * Méthode qui permet de retourner le montant de la fiche
	 */
	public double getMontant() {
		return this.montant;
	}

	// SET
	
	/**
	 * Méthode qui permet de changer l'Id 
	 *
	 * @param unId mettre un Id qui est une chaine de caractères
	 */
	public void setId(String unId){
		this.id = unId;
	}


	/**
	 * Méthode qui permet de changer un libelle d'une classe FraisForfait 
	 *
	 * @param unLibelle mettre un Libelle qui est une chaine de caractères
	 */
	public void setLibelle(String unLibelle){
		this.libelle = unLibelle;
	}


	/**
	 * Méthode qui permet de changer un montant d'une classe FraisForfait
	 *
	 * @param unMontant mettre un Libelle qui est un nombre décimal
	 */
	public void setMontant(double unMontant){
		this.montant = unMontant;
	}
}

