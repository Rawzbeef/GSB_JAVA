package fr.gsb.modele;

import java.sql.*;
import java.util.ArrayList;

import fr.gsb.objet.Visiteur;
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
	public static ArrayList<String> initLesVisiteur(){
		connexionBDD();
		ArrayList<Visiteur> LesVisiteur=new ArrayList<Visiteur>();
		try {
			String req = "SELECT * FROM gsb_Employe where statut='visiteur'";
			pst = connexion.prepareStatement(req);
			rs = pst.executeQuery();
			Visiteur unVisiteur;
			while(rs.next()){
				unVisiteur=new Visiteur(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		deconnexionBDD();
		return null;

	}
}
