package application;

import java.util.HashSet;

public class QuestionOuverte extends Question {
	private String etudiantReponse;

	public QuestionOuverte() {
		// TODO Auto-generated constructor stub
	}

	public QuestionOuverte(String contenu, HashSet<String> motsCle) {
		setReponseJuste(new ReponseQo(motsCle));
		setQuestion(contenu);
	}

	public String getEtudiantReponse() {
		return etudiantReponse;
	}

	public void setEtudiantReponse(String etudiantReponse) {
		this.etudiantReponse = etudiantReponse;
	}

	@Override
	public float evaluationReponse() {
		// TODO Auto-generated method stub
		boolean stat = true;
		if (((ReponseQo) super.getReponseJuste()).getMotsCle().contains(etudiantReponse))
			return 100;
		else
			return 0;
	}

}
