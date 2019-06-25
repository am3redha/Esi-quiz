package application;

import java.util.HashMap;

public class Formateur extends Utilisateur {
	private Formation formation;
	public HashMap<String, Question> questions = new HashMap<String, Question>();

	public Formateur(String nomUtilisateur, String mdp) {
		super(nomUtilisateur, mdp);

	}

	public void ajouterQuestion(String notion, Question question) {
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}
