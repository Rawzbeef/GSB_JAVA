package fr.gsb.modele;

import java.sql.*;
import java.util.ArrayList;

public class ModeleBDD {
	
	// Attributs privés
	private static Connection connexion;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static ArrayList<String> lesEmployer;
	
	
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
	 * permet de renvoyer une liste de Visiteur.
	 * 
	 * @return true si les identifiants sont corrects
	 */
	//a continuer de faire
	/*public static ArrayList<String> getVisiteur(){
		
		return null;
		
	}*/
}
