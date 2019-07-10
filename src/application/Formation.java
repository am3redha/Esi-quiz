package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Formation {
	private String nom;
	private String description;

	private Date dateDebut;
	private Date dateFin;
	public ArrayList<Quiz> quizs = new ArrayList<Quiz>();
	public ArrayList<String> notions = new ArrayList<String>();
	public ArrayList<Apprenant> apprenants = new ArrayList<Apprenant>();

	public void ajoutApprenants(String nomFichier) {

		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream(nomFichier));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			Apprenant etudiant = new Apprenant(scanner.nextLine().split(","));
			etudiant.setFormation(this);
			apprenants.add(etudiant);
			EsiQuiz.comptes.add(etudiant);

		}

	}

	public void ajoutApprenants(ArrayList<String> noms) {

	}

	public Quiz genererQuiz(String titre, Date dateOuverture, Date dateExpiration,
			HashMap<String, HashSet<Question>> listQuestions, HashMap<String, Integer> nbParNotion)
			throws NombreSuperierureException {
		Quiz quiz = new Quiz(titre, dateOuverture, dateExpiration);

		for (String n : nbParNotion.keySet()) {
			if (listQuestions.get(n).size() < nbParNotion.get(n)) {
				throw new NombreSuperierureException();

			}

			HashSet<Question> tmp = new HashSet<Question>(listQuestions.get(n));

			for (int k = 0; k < listQuestions.get(n).size() - nbParNotion.get(n); k++) {
				int rnd = (int) new Random().nextInt(tmp.size()), j = 0;

				Question p = null;
				for (Question q : tmp) {
					if (j == rnd) {
						p = q;
						break;
					}
					j++;
				}
				tmp.remove(p);

			}
			quiz.questions.addAll(tmp);

		}
		return quiz;
	}

	public Formation() {
	}

	public Formation(String nom, String description, ArrayList<ArrayList<String>> apprenants) {

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
