package app.modele;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import com.opencsv.bean.CsvBindByPosition;

public class Praticien {
	
	//@CsvIgnore //pour ignorer l'attribut (redéfinir l'ordre)
	@CsvBindByPosition(position = 0)
	@JsonProperty(value = "PRA_NUM")
	private int id;
	
	@CsvBindByPosition(position = 1)
	@JsonProperty(value = "PRA_PRENOM")
	private String nom;
	
	@CsvBindByPosition(position = 2)
	@JsonProperty(value = "PRA_NUM")
	private String prenom;
	
	@CsvBindByPosition(position = 3)
	@JsonProperty(value = "PRA_ADRESSE")
	private String adresse;
	
	@CsvBindByPosition(position = 4)
	@JsonProperty(value = "PRA_CP")
	private String codePostal;
	
	@CsvBindByPosition(position = 5)
	@JsonProperty(value = "PRA_VILLE")
	private String ville;
	
	@CsvBindByPosition(position = 6)
	@JsonProperty(value = "PRA_COEFNOTORIETE")
	private double coefNotoriete;
	
	@CsvBindByPosition(position = 7)
	@JsonProperty(value = "TYP_CODE")
	private String type;
	
//————————CONTRUCTORS——————————————————————————————————————————————————————————————————
	public Praticien() {
		
	}
	
	public Praticien(int id, String nom, String prenom, String adresse, String codePostal, String ville,
			double coefNotoriete, String type) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.coefNotoriete = coefNotoriete;
		this.type = type;
	}
//————————METHODS————————————————————————————————————————————————————————————————————————
	/**
	 * @return un tableau contenant les informations du praticien
	 */
	public String[] allStrings() {
		String[] infos = {
				String.valueOf(getId()),
				getNom(),
				getPrenom(),
				getAdresse(),
				getCodePostal(),
				getVille(),
				String.valueOf(getCoefNotoriete()),
				getType()
		};
		return infos;
	}
	
//————————GETTERS AND SETTERS————————————————————————————————————————————————————————————
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public double getCoefNotoriete() {
		return coefNotoriete;
	}

	public void setCoefNotoriete(double coefNotoriete) {
		this.coefNotoriete = coefNotoriete;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
