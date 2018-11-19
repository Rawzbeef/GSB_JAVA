package fr.gsb.modele;

import java.sql.*;

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
}