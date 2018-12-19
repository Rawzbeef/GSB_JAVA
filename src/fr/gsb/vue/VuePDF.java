package fr.gsb.vue;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException; 
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFPage;

import fr.gsb.modele.Modele;
import fr.gsb.modele.ModeleBDD;
import fr.gsb.objet.FicheFrais;
import fr.gsb.objet.FraisHorsForfait;

public class VuePDF {


	public VuePDF(String mois, String id, ArrayList<FraisHorsForfait> fraisHorsForfait, ArrayList<String> ligneFrais) {
		
		
		
		try {
			//Création du document PDF
			PDFDocument pdfDoc = new PDFDocument();
			//Création d'une page PDF
			PDFPage page = pdfDoc.createPage(null);
			
			//Demande au PDF d'utiliser l'objet Graphics2D pour positionner les éléments dans le PDF
			Graphics2D g2d = page.createGraphics();
			
			//Création et Mise en forme des éléments du document PDF
			g2d.setFont(new Font("Arial", Font.BOLD, 18));
			g2d.drawString("FICHE DE FRAIS", 235, 40);
			
			//Ajout de la page au document PDF
			pdfDoc.addPage(page);

			//Infos de la fiche de frais
			g2d.setFont(new Font("Arial", Font.PLAIN, 11));
			g2d.drawString("Fiche de frais du", 30, 60);
			g2d.drawString(":", 120, 60);
			g2d.drawString(Modele.dateVersFrancais(mois), 130, 60);

			//Nom du visiteur
			g2d.drawString("Nom du visiteur", 30, 75);
			g2d.drawString(":", 120, 75);
			g2d.drawString(Modele.getGsb().getVisiteur(id).getNom().toUpperCase() + " " + Modele.getGsb().getVisiteur(id).getPrenom(), 130, 75);
			
			//Etat de la fiche
			g2d.drawString("Etat de la fiche", 30, 90);
			g2d.drawString(":", 120, 90);
			if(Modele.getGsb().getUneFicheFrais(mois, id)!=null)
			switch(Modele.getGsb().getUneFicheFrais(mois, id).getEtat()){
				case "RB":
					g2d.drawString("Remboursée", 130, 90);
					break;
				case "CL":
					g2d.drawString("Saisie clôturée", 130, 90);
					break;
				case "CR":
					g2d.drawString("Fiche créée, saisie en cours", 130, 90);
					break;
				case "VA":
					g2d.drawString("Validée et mise en paiement", 130, 90);
					break;
			}
			
			//Montant validé
			g2d.drawString("Montant validé", 30, 105);
			g2d.drawString(":", 120, 105);
			g2d.drawString(Modele.getGsb().getUneFicheFrais(mois, id).getMontantValide() + "€", 130, 105);
			
			//Nombre de justificatifs
			g2d.drawString("Nb de justificatifs", 30, 120);
			g2d.drawString(":", 120, 120);
			g2d.drawString("" + Modele.getGsb().getUneFicheFrais(mois, id).getNbJustificatifs(), 130, 120);
			
			//Ligne
			g2d.drawLine(30, 135, 585, 135);
			//Titre frais forfait
			g2d.drawString("Frais forfait", 30, 155);
			//Ligne
			g2d.drawLine(30, 165, 585, 165);

			int y = 175;
			
			//Affichage des frais forfait
			y += 15;
			g2d.drawString("Forfait Etape", 50, y);
			g2d.drawString(" : ", 130, y);
			g2d.drawString(""+ligneFrais.get(0), 160, y);
			
			y += 15;
			g2d.drawString("Frais Kilométrique", 50, y);
			g2d.drawString(" : ", 130, y);
			g2d.drawString(""+ligneFrais.get(1), 160, y);
			
			y += 15;
			g2d.drawString("Nuitée Hôtel", 50, y);
			g2d.drawString(" : ", 130, y);
			g2d.drawString(""+ligneFrais.get(2), 160, y);
			
			y += 15;
			g2d.drawString("Repas Restaurant", 50, y);
			g2d.drawString(" : ", 130, y);
			g2d.drawString(""+ligneFrais.get(3), 160, y);
			
			y += 15;
			
			//Ligne
			g2d.drawLine(30, y, 585, y);
			y += 20;
			
			//Affichage titre frais hors forfait
			g2d.drawString("Frais hors forfait", 30, y);
			y += 10;
			
			//Ligne
			g2d.drawLine(30, y, 585, y);
			
			for (FraisHorsForfait ligneFraisHorsForfait : fraisHorsForfait) {
				y += 15;
				g2d.drawString("Date : " + ligneFraisHorsForfait.getDate(), 50, y);
				g2d.drawString("Libellé : " + ligneFraisHorsForfait.getLibelle(), 250, y);
				g2d.drawString("Montant : " + ligneFraisHorsForfait.getMontant()+"€", 450, y);
			}
			
			y += 15;		
			
			//Instanciation de la frame permettant d'afficher l'explorateur
			JFrame parentFrame = new JFrame();
			
			//Création de l'explorateur
			JFileChooser fileChooser = new JFileChooser();
			
			//Définition du titre de l'explorateur
			fileChooser.setDialogTitle("Choisissez où vous souhaitez enregistrer votre PDF");
			
			//Nous appliquons un filtre pour enregistrer en pdf
			FileFilter filter = new FileNameExtensionFilter("Fichier PDF","pdf");
		    fileChooser.setFileFilter(filter);
		    
		    //Booléen qui permet de vérifier si le comptable a validé l'enregistrement
			int userSelection = fileChooser.showSaveDialog(parentFrame);
			 
			//Le comptable a choisis son emplacement de sauvegarde
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				//On récupère le chemin absolu de l'emplacement de sauvegarde du PDF
				String path = fileChooser.getSelectedFile().getAbsolutePath();
				//On vérifie si le nom du PDF donné par le comptale ne contient pas de ".pdf"
				if (path.substring(path.length()-4, path.length()).equals(".pdf")) {
					//Si il contient le ".pdf", nous laissons tel quel
					path = fileChooser.getSelectedFile().getAbsolutePath();
					pdfDoc.saveDocument(fileChooser.getSelectedFile().getAbsolutePath());
				} else {
					//Sinon nous le rajoutons
					path = fileChooser.getSelectedFile().getAbsolutePath()+".pdf";
					pdfDoc.saveDocument(fileChooser.getSelectedFile().getAbsolutePath()+".pdf");
				}
				//Un message s'affiche et demande au comptable s'il veut ouvrir le PDF
				int option = JOptionPane.showConfirmDialog(null, "La fiche de frais au format PDF a bien été enregistrée ! Voulez-vous l'ouvrir ?", "Enregistrement du fichier PDF", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.OK_OPTION){
					//Le comptable veut ouvrir le PDF donc nous ouvrons le PDF
					Desktop.getDesktop().open(new File(path));
				}
			} else {//Enregistrement annulé ou fermé
				JOptionPane.showMessageDialog(null, "Enregistrement annulé !", "Enregistrement du fichier PDF", JOptionPane.ERROR_MESSAGE);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
}
}
