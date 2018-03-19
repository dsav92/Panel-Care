package iText;

import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.Desktop;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class textToPdf {

	 private static String FILE = "C:/Test.pdf";
	 private static Font bigFont  = new Font(Font.FontFamily.TIMES_ROMAN, 18,  Font.BOLD);
	 private static Font redFont  = new Font(Font.FontFamily.TIMES_ROMAN, 12,  Font.NORMAL, BaseColor.RED);
	 private static Font subFont  = new Font(Font.FontFamily.TIMES_ROMAN, 16,  Font.BOLD);
	 private static Font smallBold  = new Font(Font.FontFamily.TIMES_ROMAN, 12,  Font.BOLD);
	 
	 /* iText permette di aggiungere metadati al pdf che possono essere 
	  * visualizzati in Adobe Reader da File -> Proprietà */
	 private static void aggiungiMetaDati(Document document) {
	  document.addTitle("Report");
	  document.addSubject("Uso di iText");
	  document.addKeywords("Java, PDF, iText");
	  document.addAuthor("Administrator");
	  document.addCreator("Administrator");
	 }
	 
	 private static void aggiungiPrefazione(Document document) throws DocumentException {
	  Paragraph prefazione = new Paragraph();
	   
	  // Aggiungiamo una linea vuota
	  aggiungiLineaVuota(prefazione, 1);
	   
	  // Aggiungiamo il titolo
	  prefazione.add(new Paragraph("Report pannelli danneggiati", bigFont));
	  
	  //Chapter chapter = new Chapter(new Paragraph("Tabella report", bigFont), 1);
	  Chapter chapter = new Chapter(prefazione,1);
	  Paragraph sectionParagraph = new Paragraph("Tabella", subFont);
	  Section section = chapter.addSection(sectionParagraph);
	  section.add(sectionParagraph);
	  
	  //Section section = chapter.addSection(prefazione);
	  
	  creaTabella(section);
	  
	 // aggiungiLineaVuota(prefazione, 1);
	   
	  // Questa linea scrive "Documento generato da: nome utente, data"
	  //prefazione.add(new Paragraph("Documento generato da: " + System.getProperty("user.name") + ", " + new Date(), smallBold));
	   
	  aggiungiLineaVuota(prefazione, 3);
	   
	 // prefazione.add(new Paragraph("Prova1", smallBold));
	 
	 // aggiungiLineaVuota(prefazione, 3);
	   
	 // prefazione.add(new Paragraph("Prova2", redFont));
	 
	 // aggiungiLineaVuota(prefazione, 3);
	   
	 /* Anchor anchor = new Anchor("Questo è un link");
	  anchor.setName("LINK");
	  anchor.setReference("http://www.lowagie.com");
	  prefazione.add(anchor); */
	 
	  // Aggiunta al documento
	  document.add(prefazione);
	   
	  // Nuova pagina
	  //document.newPage();
	 }
	 
	 public static void aggiungiContenutoParam(Document document, Triple[] param) {
		 Paragraph prefazione = new Paragraph();
		   
		  // Aggiungiamo una linea vuota
		  aggiungiLineaVuota(prefazione, 1);
		   
		  // Aggiungiamo il titolo
		  prefazione.add(new Paragraph("Report pannelli danneggiati", bigFont));
		  // Il secondo parametro è il numero di capitolo
		  Chapter chapter = new Chapter(new Paragraph("Tabella report", bigFont), 1);
		 
		  Paragraph sectionParagraph = new Paragraph("Tabella", subFont);
		  Section section = chapter.addSection(sectionParagraph);
		  section.add(new Paragraph(""));
		  aggiungiLineaVuota(sectionParagraph,1);
		  creaTabellaParam(section, param);
	 }
	 
	 private static void aggiungiContenuto(Document document) throws DocumentException {
		 Paragraph prefazione = new Paragraph();
		   
		  // Aggiungiamo una linea vuota
		  aggiungiLineaVuota(prefazione, 1);
		   
		  // Aggiungiamo il titolo
		  prefazione.add(new Paragraph("Report pannelli danneggiati", bigFont));
		  // Il secondo parametro è il numero di capitolo
		  Chapter chapter = new Chapter(new Paragraph("Tabella report", bigFont), 1);
		 
		  Paragraph sectionParagraph = new Paragraph("Tabella", subFont);
		  Section section = chapter.addSection(sectionParagraph);
		  section.add(new Paragraph(""));
		  aggiungiLineaVuota(sectionParagraph,1);
		  
		  // Aggiungiamo una tabella
		  creaTabella(section);
		 
		  // Aggiunta al documento
		  document.add(chapter);
		 
	 }
	 
	 public static void creaTabellaParam(Section section, Triple[] param){
		 
		  PdfPTable tabella = new PdfPTable(param.length);
		  PdfPCell c1 = new PdfPCell(new Phrase("Riga"));
		  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		  c1.setGrayFill(0.8f);
		  tabella.addCell(c1);
		 
		  c1 = new PdfPCell(new Phrase("Colonna"));
		  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		  c1.setGrayFill(0.8f);
		  tabella.addCell(c1);
		 
		  c1 = new PdfPCell(new Phrase("N.Pannello"));
		  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		  c1.setGrayFill(0.8f);
		  tabella.addCell(c1);
		  tabella.setHeaderRows(1);
		  
		  for(int i=0; i<param.length; i++) {
			  
			  tabella.addCell(String.valueOf(param[i].getRiga()));
			  tabella.addCell(String.valueOf(param[i].getColonna()));
			  tabella.addCell(String.valueOf(param[i].getPannello()));
			  
		  }
		 
	 }
	 
	 private static void creaTabella(Section section) throws BadElementException {
	  PdfPTable tabella = new PdfPTable(3);
	 
	  // tabella.setBorderColor(BaseColor.GRAY);
	  // tabella.setPadding(4);
	  // tabella.setSpacing(4);
	  // tabella.setBorderWidth(1);
	 
	  PdfPCell c1 = new PdfPCell(new Phrase("Riga"));
	  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	  c1.setGrayFill(0.8f);
	  tabella.addCell(c1);
	 
	  c1 = new PdfPCell(new Phrase("Colonna"));
	  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	  c1.setGrayFill(0.8f);
	  tabella.addCell(c1);
	 
	  c1 = new PdfPCell(new Phrase("N.Pannello"));
	  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	  c1.setGrayFill(0.8f);
	  tabella.addCell(c1);
	  tabella.setHeaderRows(1);
	 
	  tabella.addCell("1");
	  tabella.addCell("2");
	  tabella.addCell("6");
	  tabella.addCell("4");
	  tabella.addCell("5");
	  tabella.addCell("2");
	 
	  section.add(tabella);
	 
	 }
	 
	 
	 private static void aggiungiLineaVuota(Paragraph paragraph, int number) {
	  for (int i = 0; i < number; i++) {
	   paragraph.add(new Paragraph(" "));
	  }
	 }
	 
	 
	 public static void main(String[] args) {
		  try {
		   Document document = new Document();
		   PdfWriter.getInstance(document, new FileOutputStream(FILE));
		   document.open();
		   aggiungiMetaDati(document);
		   //aggiungiPrefazione(document);
		   aggiungiContenuto(document);
		   document.close();
		   java.io.File file = new java.io.File(FILE);
		   Desktop d = Desktop.getDesktop();
		   d.open(file);
		   } catch (Exception e) {
		   e.printStackTrace();
		  }
		 }
	
}
