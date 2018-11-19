//class non fini et a completer
package fr.gsb.objet;

public class FraisForfait {

	//attribut priver
	private String id;
	private String libelle;
	private int montant;

	//-------------------------------------------------------------------
	//--------------------début des methode GET-------------------------------
	/**
	 * methode qui permet de retourner l'id de la classe FraisForfait 
	 */
	public String getId(){
		return id;
	}


	/**
	 * methode qui permet de retourner le libelle de la classe FraisForfait 
	 */
	public String getLibelle(){
		return libelle;
	}


	/**
	 * methode qui permet de retourner le montant de la classe FraisForfait
	 */
	public int getMontant(){
		return montant;
	}

	//-------------------------------------------------------------------
	//--------------------début des methode SET-------------------------------
	/**
	 * methode qui permet de changer un Id de la classe FraisForfait 
	 *
	 * @param unId mettre un Id qui est une chaine de charactère
	 */
	public void setId(String unId){
		this.id=unId;
	}


	/**
	 * methode qui permet de changer un libelle d'une classe FraisForfait 
	 *
	 * @param unLibelle mettre un Libelle qui est une chaine de charactère
	 */
	public void setLibelle(String unLibelle){
		this.libelle=unLibelle;
	}


	/**
	 * methode qui permet de changer un montant d'une classe FraisForfait
	 *
	 * @param unMontant mettre un Libelle qui est un entier
	 */
	public void setMontant(int unMontant){
		this.montant=unMontant;
	}


	/**
	 * constructeur de la classe
	 *
	 * @param unId mettre un Libelle qui est une chaine de charactère
	 * @param unLibelle mettre un Libelle qui est une chaine de charactère
	 * @param unMontant mettre un Libelle qui est un entier
	 */ 
	public FraisForfait(String unId,String unLibelle,int unMontant){
		this.id=unId;
		this.libelle=unLibelle;
		this.montant=unMontant;
	}
}

