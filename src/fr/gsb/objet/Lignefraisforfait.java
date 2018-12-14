package fr.gsb.objet;

public class Lignefraisforfait {
	private String id;
	private String mois;
	private String idFraisForfait;
	private int quantite;
	private FraisForfait libelleFraiForfait;
	
	public Lignefraisforfait(String unId, String unmois, String unidFraisForfait,int unquantite,FraisForfait unLibelleFraisForfait){
		this.id = unId;
		this.mois = unmois;
		this.idFraisForfait = unidFraisForfait;
		this.quantite = unquantite;
		this.libelleFraiForfait = unLibelleFraisForfait;
	}
	
	
	/**
	 * M�thode qui permet de retourner l'id de la Ligne frais forfait
	 */
	public String getId() {
		return this.id;
	}
	
	
	/**
	 * M�thode qui permet de retourner le mois de la Ligne frais forfait
	 */
	public String getMois() {
		return this.mois;
	}
	
	
	/**
	 * M�thode qui permet de retourner l'idFraisForfait de la Ligne frais forfait
	 */
	public String getIdFraisForfait() {
		return this.idFraisForfait;
	}
	
	
	/**
	 * M�thode qui permet de retourner la quantiter de la Ligne frais forfait
	 */
	public int getQuantite() {
		return this.quantite;
	}
	
	public FraisForfait getLibelleFraiForfait() {
		return this.libelleFraiForfait;
	}
	/**
	 * M�thode qui permet de retourner le montant de la fiche
	 */
	public void setId(String unId){
		this.id=unId;
	}
	
	
	/**
	 * M�thode qui permet de retourner le montant de la fiche
	 */
	public void setMois(String unMois){
		this.mois=unMois;
	}
	
	
	/**
	 * M�thode qui permet de retourner le montant de la fiche
	 */
	public void setIdFraisForfait(String unIdFraisForfait){
		this.idFraisForfait=unIdFraisForfait;
	}
	
	
	/**
	 * M�thode qui permet de retourner le montant de la fiche
	 */
	public void setQuantite(int unQuantite){
		this.quantite=unQuantite;
	}
}
