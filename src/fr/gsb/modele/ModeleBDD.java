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

		} catch (SQLException e) {
			e.printStackTrace();
		}
		deconnexionBDD();
		return trouver;
	}


	/**
	 * Permet de renvoyer une liste de Visiteur
	 * 
	 * @return lesVisiteurs
	 */
	public static ArrayList<Visiteur> initLesVisiteurs(){
		connexionBDD();
		ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
		try {
			String req = "SELECT * FROM gsb_Employe WHERE statut ='visiteur'";
			st = connexion.createStatement();
			rs = st.executeQuery(req);
			Visiteur unVisiteur;
			while(rs.next()){
				unVisiteur=new Visiteur(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				lesVisiteurs.add(unVisiteur);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		deconnexionBDD();
		return lesVisiteurs;
	}
	
	/**
	 * Permet d'afficher la liste des frais hors forfaits pour un visiteur donné
	 * @return
	 */
	public static ArrayList<String> initLesFraisHorsForfaits(String idV){
		connexionBDD();
		ArrayList<FraisHorsForfait> lesFrais = new ArrayList<FraisHorsForfait>();
		try {
			String req = "SELECT * FROM gsb_lignefraishorsforfait WHERE idVisiteur = ?";
			pst = connexion.prepareStatement(req);
			pst.setString(1, idV);
			rs = pst.executeQuery();
			FraisHorsForfait unFrais;
			while(rs.next()){
				unFrais = new FraisHorsForfait(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getString(2));
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
}
