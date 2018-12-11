package fr.gsb.modele;

import java.sql.*;
import java.util.ArrayList;

import fr.gsb.objet.*;

public class ModeleBDD {

	// Attributs priv�s
	private static Connection connexion;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;


	// M�thodes statiques

	/**
	 * Permet la connexion � la base de donn�es
	 */
	public static void connexionBDD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.100/2018lys", "jllys", "123456");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Driver non charg�" + e);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * D�connexion de la BDD
	 */
	public static void deconnexionBDD() {
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * V�rification de la connexion comptable
	 * 
	 * @param login
	 * @param mdp
	 * @return true si les identifiants sont corrects
	 */
	public static boolean connexionComptable(String login, String mdp) {
		boolean trouver = false;
		connexionBDD();
		try {
			String req = "SELECT COUNT('login') FROM gsb_Employe WHERE statut = 'Comptable' AND login = ? AND Mdp = ?";
			pst = connexion.prepareStatement(req);
			pst.setString(1, login);
			pst.setString(2, mdp);
			rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 1) {
				trouver = true;
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		deconnexionBDD();
		return trouver;
	}


	/**
	 * Permet de renvoyer la liste des Visiteur
	 * 
	 * @return lesVisiteurs
	 */
	public static ArrayList<Visiteur> initLesVisiteurs(){
		connexionBDD();
		ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
		try {
			String req = "SELECT * FROM gsb_Employe WHERE statut = 'visiteur'";
			st = connexion.createStatement();
			rs = st.executeQuery(req);
			Visiteur unVisiteur;
			while(rs.next()){
				unVisiteur = new Visiteur(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				lesVisiteurs.add(unVisiteur);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		deconnexionBDD();
		return lesVisiteurs;
	}
	
	/**
	 * Permet d'effectuer les liens objet entre les fiches frais et les visiteurs
	 * 
	 * @return lesVisiteurs
	 */
	public static ArrayList<Visiteur> initLienFicheFrais(ArrayList<Visiteur> lesVisiteurs) {
		connexionBDD();
		for(Visiteur visiteur : lesVisiteurs) {
			try {
				String req = "SELECT * FROM gsb_fichefrais WHERE idVisiteur = ?";
				pst = connexion.prepareStatement(req);
				pst.setString(1, visiteur.getId());
				rs = pst.executeQuery();
				while(rs.next()){
					visiteur.setFicheFrais(new FicheFrais(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
				}
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		deconnexionBDD();
		return lesVisiteurs;
	}
	
	/**
	 * Permet de renvoyer une liste de Visiteur selon un mois donn�
	 * 
	 * id-nom prenom
	 * @return lesVisiteurs
	 */
	public static ArrayList<String> getVisiteursMois(String unMois){
		connexionBDD();
		ArrayList<String> lesIds = new ArrayList<String>();
		try {
			String req = "SELECT id FROM gsb_employe, gsb_ficheFrais WHERE gsb_employe.id = gsb_ficheFrais.idVisiteur AND gsb_ficheFrais.mois = ?";
			pst = connexion.prepareStatement(req);
			pst.setString(1, unMois);
			rs = pst.executeQuery();
			while(rs.next()) {
				lesIds.add(rs.getString(1));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		deconnexionBDD();
		return lesIds;
	}
	
	/**
	 * Permet d'afficher la liste des frais hors forfaits pour un visiteur donn� � un mois donn�
	 * 
	 * @return lesFrais qui sont hors forfaits
	 */
	public static ArrayList<FraisHorsForfait> getLesFraisHorsForfaits(String mois, String idV){
		connexionBDD();
		ArrayList<FraisHorsForfait> lesFrais = new ArrayList<FraisHorsForfait>();
		try {
			String req = "SELECT * FROM gsb_lignefraishorsforfait WHERE idVisiteur = ? AND mois = ?";
			pst = connexion.prepareStatement(req);
			pst.setString(1, idV);
			pst.setString(2, mois);
			rs = pst.executeQuery();
			FraisHorsForfait unFrais;
			while(rs.next()){
				unFrais = new FraisHorsForfait(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
				lesFrais.add(unFrais);
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		deconnexionBDD();
		return lesFrais;

	}
	
	/**
	 * Retourne les fiches de frais selon l'id d'un visiteur (Affichage des fiches de frais)
	 * 
	 * @param id
	 * @return lesFichesFrais
	 */
	public static ArrayList<FicheFrais> getLesFicheFrais(String id) {
		connexionBDD();
		ArrayList<FicheFrais> lesFiches = new ArrayList<FicheFrais>();
		try {
			String req = "SELECT * FROM gsb_fichefrais";
			st = connexion.createStatement();
			rs = st.executeQuery(req);
			FicheFrais uneFiche;
			while(rs.next()){
				uneFiche = new FicheFrais(id, rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getString(5));
				lesFiches.add(uneFiche);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		deconnexionBDD();
		return lesFiches;
	}
	
	/**
	 * Retourne tous les mois des fiches de frais
	 * 
	 * @return Liste de mois sous format mmaaaa
	 */
	public static ArrayList<String> getLesMois() {
		connexionBDD();
		ArrayList<String> liste = new ArrayList<String>();
		try {
			String req = "SELECT DISTINCT mois FROM gsb_fichefrais WHERE idEtat != 'CR'";
			st = connexion.createStatement();
			rs = st.executeQuery(req);
			while(rs.next()){
				liste.add(rs.getString(1));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		deconnexionBDD();
		return liste;
	}
}
