package application;

import java.util.ArrayList;
import java.util.Date;

public class Formation {
	private String nom;
	private String description;
	private Date dateDebut;
	private Date dateFin;
	public ArrayList<String> notions = new ArrayList<String>();
	public ArrayList<Apprenant> apprenants = new ArrayList<Apprenant>();

	public Formation() {
	}

	public Formation(String nom, String description, ArrayList<ArrayList<String>> apprenants) {

	}

	public void genererQuiz(int[] nbQnotion) {

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
