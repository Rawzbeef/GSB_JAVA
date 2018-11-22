package fr.gsb.objet;

public class FraisForfait {

	// Attributs priv�s
	private String id;
	private String libelle;
	private double montant;

	// Constructeur
	/**
	 * Constructeur de la classe FraisForfait
	 *
	 * @param unId identifiant qui est une chaine de caract�res
	 * @param unLibelle libelle qui est une chaine de caract�res
	 * @param unMontant montant qui est un nombre d�cimal
	 */ 
	public FraisForfait(String unId, String unLibelle, double unMontant){
		this.id = unId;
		this.libelle = unLibelle;
		this.montant = unMontant;
	}

	// M�thodes
	// GET
	/**
	 * M�thode qui permet de retourner l'id 
	 */
	public String getId() {
		return this.id;
	}


	/**
	 * M�thode qui permet de retourner le libell� 
	 */
	public String getLibelle() {
		return this.libelle;
	}


	/**
	 * M�thode qui permet de retourner le montant de la fiche
	 */
	public double getMontant() {
		return this.montant;
	}

	// SET
	
	/**
	 * M�thode qui permet de changer l'Id 
	 *
	 * @param unId mettre un Id qui est une chaine de caract�res
	 */
	public void setId(String unId){
		this.id = unId;
	}


	/**
	 * M�thode qui permet de changer un libelle d'une classe FraisForfait 
	 *
	 * @param unLibelle mettre un Libelle qui est une chaine de caract�res
	 */
	public void setLibelle(String unLibelle){
		this.libelle = unLibelle;
	}


	/**
	 * M�thode qui permet de changer un montant d'une classe FraisForfait
	 *
	 * @param unMontant mettre un Libelle qui est un nombre d�cimal
	 */
	public void setMontant(double unMontant){
		this.montant = unMontant;
	}
}

