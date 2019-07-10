package application;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Quiz {
	private String nomQuiz;
	private Date dateOuverture;
	private Date dateExpiration;
	public HashSet<Question> questions = new HashSet<Question>();

	public Quiz() {
		// TODO Auto-generated constructor stub
	}

	public void evaluationQuiz() {
		float taux = 0;
		for (Question q : questions) {
			taux += q.evaluationReponse() / questions.size();
		}
	}

	public void ajouterQuestion(HashMap<String, HashSet<Question>> listQuestions, String notion)
			throws PasDeQuestionsDisponiblesException {
		HashSet<Question> qsts = new HashSet<Question>(listQuestions.get(notion));
		qsts.removeAll(questions);
		if (qsts.size() <= 0)
			throw new PasDeQuestionsDisponiblesException();
		int rnd = new Random().nextInt(qsts.size()), i = 0;
		for (Question q : qsts) {
			if (i == rnd) {
				questions.add(q);
				break;
			}

			i++;
		}
	}

	public Quiz(String nom, Date dateOuverture, Date dateExpiration) {
		// TODO Auto-generated constructor stub
		this.nomQuiz = nom;
		this.dateOuverture = dateOuverture;
		this.dateExpiration = dateExpiration;
	}

	public String getNomQuiz() {
		return nomQuiz;
	}

	public void setNomQuiz(String nomQuiz) {
		this.nomQuiz = nomQuiz;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

}
