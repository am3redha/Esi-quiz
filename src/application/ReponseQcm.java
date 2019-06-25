package application;

import java.util.ArrayList;

public class ReponseQcm extends Reponse {
	private ArrayList<String> reponses = new ArrayList<String>();

	public ArrayList<String> getReponses() {
		return reponses;
	}

	public void setReponses(ArrayList<String> reponses) {
		this.reponses = reponses;
	}

}
