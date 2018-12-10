package fr.gsb.modele;

import java.sql.*;
import java.util.ArrayList;

import fr.gsb.objet.*;
public class ModeleBDD {

	// Attributs privés
	private static Connection connexion;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;


	// Méthodes statiques

	/**
	 * Permet la connexion à la base de données
	 */
	public static void connexionBDD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.100/2018lys", "jllys", "123456");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Driver non chargé" + e);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Déconnexion de la BDD
	 */
	public static void deconnexionBDD() {
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Vérification de la connexion comptable
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
	 * Permet de renvoyer une liste de Visiteur selon un mois donné
	 * 
	 * id-nom prenom
	 * @return lesVisiteurs
	 */
	public static ArrayList<String> GetVisiteursMois(String unMois){
		connexionBDD();
		ArrayList<String> lesVisiteurs = new ArrayList<String>();
		try {
			String req = "SELECT id FROM gsb_employe, gsb_ficheFrais WHERE gsb_employe.id = gsb_ficheFrais.idVisiteur AND ficheFrais.mois = ?";
			pst = connexion.prepareStatement(req);
			pst.setString(1, unMois);
			rs = pst.executeQuery();
			
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		deconnexionBDD();
		return lesVisiteurs;
	}
	/**
	 * Permet d'afficher la liste des frais hors forfaits pour un visiteur donné à un mois donné
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
}
