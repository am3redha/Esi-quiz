package application;

import java.util.ArrayList;

public class QuestionChoixMultiple extends Question {
	private ArrayList<String> propositions;

	public QuestionChoixMultiple() {
		setReponse(new ReponseQcm());

	}

}
