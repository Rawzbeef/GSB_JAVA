package fr.gsb.objet;

public class FicheFrais {
	
	// Attributs privés
	private String mois;
	private int nbJustificatifs;
	private double montantValide;
	private String dateModif;


	// Constructeur
	/**
	 * Constructeur de la classe FicheFrais
	 *
	 * @param unMois mettre un mois qui est une chaine de charactère
	 * @param unbJustificatifs mettre un bJustificatifs qui est un entier
	 * @param unmontantValide mettre un montantValide qui est un nombre avec virgule
	 * @param unedateModif mettre une dateModif qui est la date d'aujourd'huit
	 */ 
	public FicheFrais(String unmois, int unbJustificatifs,double unmontantValide, String unedateModif){
		mois=unmois;
		nbJustificatifs=unbJustificatifs;
		montantValide=unmontantValide;
		dateModif=unedateModif;
	}

	//-------------------------------------------------------------------
	//--------------------début des methodes GET-------------------------------

	/**
	 * methode qui permet de retourner le mois de la classe FicheFrais 
	 */
	public String getMois(){
		return mois;
	}


	/**
	 * methode qui permet de retourner le nombre de Justificatifs de la classe FicheFrais 
	 */
	public int getNbJustificatifs(){
		return nbJustificatifs;
	}


	/**
	 * methode qui permet de retourner le montantValide de la classe FicheFrais 
	 */
	public double getMontantValide(){
		return montantValide;
	}


	/**
	 * methode qui permet de retourner la dateModif de la classe FicheFrais
	 */
	public String getDateModif(){
		return dateModif;
	}

	//-------------------------------------------------------------------
	//--------------------début des methodes SET-------------------------------

	/**
	 * methode qui permet de changer un mois de la classe FicheFrais 
	 *
	 * @param unMois mettre un mois qui est une chaine de charactère et espacer par "-" apres chaque chiffre
	 */ 
	public void setMois(String unMois){
		this.mois=unMois;
	}


	/**
	 * methode qui permet de changer un nombre de Justificatifs de la classe FicheFrais
	 *
	 * @param unNbJustificatifs mettre un nbJustificatifs qui est un entier
	 */ 
	public void setNbJustificatifs(int unNbJustificatifs){
		this.nbJustificatifs=unNbJustificatifs;
	}


	/**
	 * methode qui permet de changer un montantValide de la classe FicheFrais 
	 *
	 * @param unMontantValide mettre un montantValide qui est un chiffre avec une virgule
	 */ 
	public void setMontantValide(double unMontantValide){
		this.montantValide=unMontantValide;
	}


	/**
	 * methode qui permet de changer une dateModif de la classe FicheFrais 
	 *
	 * @param uneDate mettre un dateModif qui est provient de la classe date
	 */ 
	public void setDateModif(String uneDate){
		this.dateModif=uneDate;
	}
}
