package app.modele;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CSVFiles {
	
	private static final Logger LOGGER = LogManager.getLogger(CSVFiles.class);
	
	private String path = "resources/csvFiles/";
	private String nameFile;
	
	private Writer writer;
	
//————————CONTRUCTORS——————————————————————————————————————————————————————————————————
	/**
	 * Constructeur par défaut
	 * @default path = "resources/csvFiles/"
	 */
	public CSVFiles() 
	{
		
	}
	
	/**
	 * Constructeur avec le chemin de la création du fichier en argument
	 * 
	 * @param identifiant du visiteur
	 * @default path = "resources/csvFiles/"
	 */
	public CSVFiles(String identifiant) {
		this.nameFile = nameFiles(identifiant);
	}
	
	/**
	 * Constructeur avec le chemin de la création du fichier en argument
	 * 
	 * @param identifiant du visiteur
	 * @param path ou le fichier csv sera crée
	 */
	public CSVFiles(String identifiant, String path) {
		this.path = path;
		this.nameFile = nameFiles(identifiant);
		
	}
	
//————————METHODS————————————————————————————————————————————————————————————————————————
	/**
	 * 
	 * @param lesPraticiens liste des praticiens
	 * 
	 * Crée un fichier csv avec la liste
	 */
	public void createCSVFiles(List<Praticien> lesPraticiens)
	{
		LOGGER.info("Création du fichier en cours...");
		
		try {
			writer = Files.newBufferedWriter(Paths.get(nameFile));
		
			StatefulBeanToCsv<Praticien> beanToCsv = new StatefulBeanToCsvBuilder<Praticien>(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
		
			beanToCsv.write(lesPraticiens);
			writer.close();
		} 
		catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) 
		{
			LOGGER.fatal(e.getMessage());
		}
			
		LOGGER.info("Fichier crée en : " + getNameFile());
	}
	
	/**
	 * 
	 * @param identifiant du visiteur
	 * @return une chaine comportant le chemin et le nom du fichier csv
	 */
	private String nameFiles(String identifiant)
	{
		DateFormat dateAndHour = new SimpleDateFormat("-yyyy.MM.dd-HH.mm.ss");
		Calendar calendar = Calendar.getInstance();
		
		return path + identifiant + dateAndHour.format(calendar.getTime()) + ".csv";
	}

	
//————————GETTERS AND SETTERS————————————————————————————————————————————————————————————	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
}
