package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Apprenant extends Utilisateur {
	private String prenom;
	private String nom;
	private String adresse;
	private Date dateDeNaissance;
	private Formation formation;

	public Apprenant(String nom, String prenom, Date dateNaissance, String adresse) throws Exception {
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateNaissance;
		this.setAdresse(adresse);
		generLogin();
	}

	public void repondreQcm(Question question, HashSet<String> reponses) {
		((QuestionChoixMultiple) question).setEtudiantReponses(reponses);
	}

	public void repondreQo(Question question, String reponse) {
		((QuestionOuverte) question).setEtudiantReponse(reponse);
	}

	public ArrayList<Float> evaluation() {
		ArrayList<Float> resultat = new ArrayList<Float>();
		for (Quiz q : formation.quizs) {
			float rate = 0;
			if (q.getDateExpiration().before(new Date())) {
				rate = 0;
				for (Question qst : q.questions) {
					rate += qst.evaluationReponse();
				}
			}
			resultat.add(new Float(rate));
		}
		return resultat;
	}

	public Apprenant() {
		super();
	}

	public Apprenant(String[] infos) {
		this.nom = infos[0];
		this.prenom = infos[1];

		try {
			this.dateDeNaissance = new SimpleDateFormat("dd/mm/yyyy").parse(infos[2]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setAdresse(infos[3]);
		try {
			generLogin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Apprenant(String id, String mdp) {
		super(id, mdp);
	}

	public void generLogin() throws Exception {
		setNomUtilisateur(prenom.charAt(0) + nom);

		setMotDePasse(nom + new SimpleDateFormat("dd/mm/yyyy").format(dateDeNaissance));
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
