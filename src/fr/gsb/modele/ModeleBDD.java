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
	
	public static ArrayList<FicheFrais> initLesFichesFrais() {
		connexionBDD();
		ArrayList<FicheFrais> lesFicheFrais = new ArrayList<FicheFrais>();
		try {
			String req = "SELECT * FROM gsb_FicheFrais";
			st = connexion.createStatement();
			rs = st.executeQuery(req);
			FicheFrais unFicheFrais;
			while(rs.next()){
				unFicheFrais = new FicheFrais(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6));
				lesFicheFrais.add(unFicheFrais);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		deconnexionBDD();
		return lesFicheFrais;
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
					visiteur.setFicheFrais(new FicheFrais(visiteur.getId(), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
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
	 * id
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
	 * Permet de renvoyer une liste de Visiteur (nom,prenom) selon un mois donnes
	 * 
	 * nom prenom
	 * @return lesVisiteurs
	 */
	public static ArrayList<Visiteur> getVisiteursMoisVue(String unMois){
		connexionBDD();
		ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
		try {
			String req = "SELECT distinct(id),nom,prenom  FROM gsb_employe, gsb_ficheFrais WHERE gsb_employe.id = gsb_ficheFrais.idVisiteur AND gsb_ficheFrais.mois = ? order by(gsb_employe.id)";
			pst = connexion.prepareStatement(req);
			pst.setString(1, unMois);
			rs = pst.executeQuery();
			Visiteur unvisiteur;
			while(rs.next()){
				unvisiteur= new Visiteur(rs.getString(1), rs.getString(2), rs.getString(3),null,null,null,null,null,null);
				lesVisiteurs.add(unvisiteur);
			}
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
				unFrais = new FraisHorsForfait(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getString(7));
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
	 * Met à jour l'état de l'élément hors forfait
	 * 
	 * @param id de l'élément hors forfait
	 * @param etat
	 */
	public static void metAJourEtatHorsForfait(int id, String etat) {
		connexionBDD();
		try {
			String req = "UPDATE gsb_lignefraishorsforfait SET etat = ? WHERE id = ?";
			pst = connexion.prepareStatement(req);
			pst.setString(1, etat);
			pst.setInt(2, id);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		deconnexionBDD();
	}

	/**
	 * Retourne les fiches de frais selon l'id d'un visiteur (Affichage des fiches de frais)
	 * 
	 * @param id
	 * @return lesFichesFrais
	 */
	public static ArrayList<FicheFrais> getLesFicheFrais(String id,String mois) {
		connexionBDD();
		ArrayList<FicheFrais> lesFiches = new ArrayList<FicheFrais>();
		try {
			String req = "SELECT * FROM gsb_fichefrais WHERE idVisiteur = ? and mois = ?";
			pst = connexion.prepareStatement(req);
			pst.setString(1, id);
			pst.setString(2, mois);
			rs = pst.executeQuery();
			FicheFrais uneFiche;
			while(rs.next()){
				uneFiche = new FicheFrais(id, rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6));
				lesFiches.add(uneFiche);
			}

			rs.close();
			pst.close();
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
				liste.add(Modele.dateVersFrancais(rs.getString(1)));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		deconnexionBDD();
		return liste;
	}

	public static ArrayList<String> getLigneFrais(String id, String mois) {
		connexionBDD();
		ArrayList<String> liste = new ArrayList<String>();
		try {
			String req = "SELECT quantite FROM gsb_lignefraisforfait WHERE idVisiteur = ? AND mois = ?";
			pst = connexion.prepareStatement(req);
			pst.setString(1, id);
			pst.setString(2, mois);
			rs = pst.executeQuery();
			while(rs.next()){
				liste.add(rs.getString(1));
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		deconnexionBDD();
		return liste;
	}


	/**
	 * Retourne tous les mois des fiches de frais
	 * 
	 * @return Liste de mois sous format mmaaaa
	 */
	public static ArrayList<Lignefraisforfait> getLesLignefraisforfait(String unidVisiteur,String unMois) {
		connexionBDD();
		ArrayList<Lignefraisforfait> liste2 = new ArrayList<Lignefraisforfait>();
		try {
			String req = "select libelle,quantite from gsb_lignefraisforfait,gsb_fraisforfait where gsb_lignefraisforfait.idFraisForfait = gsb_fraisforfait.id and idVisiteur= ? and mois= ?";
			pst = connexion.prepareStatement(req);
			pst.setString(1, unidVisiteur);
			pst.setString(2, unMois);
			rs = pst.executeQuery();
			while(rs.next()){ 
				FraisForfait unFraiForfait=new FraisForfait(req,rs.getString(1), 0);
				Lignefraisforfait uneFiche = new Lignefraisforfait(null, null, null, rs.getInt(2), unFraiForfait);
				liste2.add(uneFiche);
			}
			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		deconnexionBDD();
		return liste2;
	}

	public static void updateLaFicheFrais(String id, String mois, int etp, int km, int nui, int rep, String etat) {
		connexionBDD();
		try {
			String req1 = "UPDATE gsb_lignefraisforfait SET quantite = ? WHERE idVisiteur = ? AND mois = ? AND idFraisForfait = 'ETP';";
			String req2 = "UPDATE gsb_lignefraisforfait SET quantite = ? WHERE idVisiteur = ? AND mois = ? AND idFraisForfait = 'KM';";
			String req3 = "UPDATE gsb_lignefraisforfait SET quantite = ? WHERE idVisiteur = ? AND mois = ? AND idFraisForfait = 'NUI';";
			String req4 = "UPDATE gsb_lignefraisforfait SET quantite = ? WHERE idVisiteur = ? AND mois = ? AND idFraisForfait = 'REP';";
			String req5 = "UPDATE gsb_fichefrais SET idEtat = ? WHERE idVisiteur = ? AND mois = ?;";
			pst = connexion.prepareStatement(req1);
			pst.setInt(1, etp);
			pst.setString(2, id);
			pst.setString(3, mois);

			pst.executeUpdate();
			pst.close();

			pst = connexion.prepareStatement(req2);
			pst.setInt(1, km);
			pst.setString(2, id);
			pst.setString(3, mois);

			pst.executeUpdate();
			pst.close();

			pst = connexion.prepareStatement(req3);
			pst.setInt(1, nui);
			pst.setString(2, id);
			pst.setString(3, mois);

			pst.executeUpdate();
			pst.close();

			pst = connexion.prepareStatement(req4);
			pst.setInt(1, rep);
			pst.setString(2, id);
			pst.setString(3, mois);

			pst.executeUpdate();
			pst.close();

			pst = connexion.prepareStatement(req5);
			pst.setString(1, etat);
			pst.setString(2, id);
			pst.setString(3, mois);

			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		deconnexionBDD();
	}

}
