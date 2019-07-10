package application;

import java.util.ArrayList;
import java.util.HashSet;

public class ReponseQcm extends Reponse {
	private HashSet<String> reponses = new HashSet<String>();

	public ReponseQcm(ArrayList<String> r) {
		// TODO Auto-generated constructor stub
		reponses.addAll(r);

	}

	public ReponseQcm() {
		// TODO Auto-generated constructor stub
	}

	public HashSet<String> getReponses() {
		return reponses;
	}

	public void setReponses(HashSet<String> reponses) {
		this.reponses = reponses;
	}

}
