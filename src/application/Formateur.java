package application;

import java.util.HashMap;
import java.util.HashSet;

public class Formateur extends Utilisateur {
	private Formation formation;
	public HashMap<String, HashSet<Question>> questions = new HashMap<String, HashSet<Question>>();

	public Formateur(String nomUtilisateur, String mdp) {
		super(nomUtilisateur, mdp);

	}

	public void ajouterQuestion(String notion, Question question) {
		if (!questions.containsKey(notion))
			questions.put(notion, new HashSet<Question>());
		questions.get(notion).add(question);
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}
