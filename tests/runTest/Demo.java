package runTest;

import java.util.ArrayList;
import java.util.List;

import com.sun.research.ws.wadl.Response;

import app.modele.CSVFiles;
import app.modele.Praticien;
import app.modele.ResponseOfRest;

public class Demo {

	public static void main(String[] args) {
		List<Praticien> lesPraticiens = new ArrayList<Praticien>();
		//Praticien praticien0 = new Praticien(1, "NIHIM", "Sol", "7 Rue de la Tour", "56200", "St Hervé", 123.50, "Médecin de campagne");
		//Praticien praticien1 = new Praticien(1, "FIRST", "Eins", "7 Rue du Moulin", "56200", "Silla", 123.50, "Médecin de ville");
		//Praticien praticien2 = new Praticien(1, "SECOND", "Zwei", "7 Rue du Moulin", "56200", "Ergo", 123.50, "Pharmacie");
		//lesPraticiens.add(praticien0);
		
		ResponseOfRest responseOfRest = new ResponseOfRest();
		lesPraticiens = responseOfRest.getXmlToObjects();
		
		
		
		
		CSVFiles csvFiles = new CSVFiles("a131");
		csvFiles.createCSVFiles(lesPraticiens);
		
	}

}
