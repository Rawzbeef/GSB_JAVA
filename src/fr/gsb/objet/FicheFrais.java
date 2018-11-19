package fr.gsb.objet;

public class FicheFrais {
	private String mois;
	private int nbJustificatifs;
	private double montantValide;
	private Date dateModif;
	
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
	public Date getDateModif(){
		return dateModif;
	}
	/**
	* constructeur de la classe
	*
	* @param unmois mettre un mois qui est une chaine de charactère
	* @param unbJustificatifs mettre un bJustificatifs qui est un entier
	* @param unmontantValide mettre un montantValide qui est un nopmbre avec virgule
	* @param unedateModif mettre une dateModif qui est la date d'aujourd'huit
	*/ 
	public FicheFrais(String unmois, int unbJustificatifs,double unmontantValide, Date unedateModif){
		mois=unmois;
		nbJustificatifs=unbJustificatifs;
		montantValide=unmontantValide;
		dateModif=unedateModif;
	}
}
