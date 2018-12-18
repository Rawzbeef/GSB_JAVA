package fr.gsb.vue;
import java.io.File;
import java.io.IOException; 

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class VuePDF {

	public VuePDF() throws InvalidPasswordException, IOException {
		File file = new File("P:/pdfTest/test.pdf"); 
		PDDocument document = PDDocument.load(file); 
		PDPage page = document.getPage(0);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);

		System.out.println("PDF loaded"); 
		contentStream.beginText(); 

		//Setting the font to the Content stream  
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

		//Setting the position for the line 
		contentStream.newLineAtOffset(25, 500);

		String text = "This is the sample document and we are adding content to it.";

		//Adding text in the form of string 
		contentStream.showText(text);      

		//Ending the content stream
		contentStream.endText();

		System.out.println("Content added");

		//Closing the content stream
		contentStream.close();

		//Saving the document
		document.save(new File("P:/pdfTest/test.pdf")); 


	}  
}
