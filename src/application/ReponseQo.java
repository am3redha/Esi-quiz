package application;

import java.util.HashSet;

public class ReponseQo extends Reponse {
	private HashSet<String> motsCle;

	public ReponseQo(HashSet<String> mots) {
		// TODO Auto-generated constructor stub
		this.motsCle = mots;
	}

	public HashSet<String> getMotsCle() {
		return motsCle;
	}

	public void setMotsCle(HashSet<String> motsCle) {
		this.motsCle = motsCle;
	}

}
