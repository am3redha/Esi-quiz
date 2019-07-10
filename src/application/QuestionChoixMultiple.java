package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class QuestionChoixMultiple extends Question {
	private ArrayList<String> propositions;
	private HashSet<String> etudiantReponses = new HashSet<String>();

	public QuestionChoixMultiple() {
		// TODO Auto-generated constructor stub
		setReponseJuste(new ReponseQcm());

	}

	public QuestionChoixMultiple(String contenu, Collection<String> propositions, Collection<String> answers) {
		setQuestion(contenu);
		this.setPropositions((ArrayList<String>) propositions);
		setReponseJuste(new ReponseQcm((ArrayList<String>) answers));

	}

	public ArrayList<String> getPropositions() {
		return propositions;
	}

	public void setPropositions(ArrayList<String> propositions) {
		this.propositions = propositions;
	}

	public HashSet<String> getEtudiantReponses() {
		return etudiantReponses;
	}

	public void setEtudiantReponses(HashSet<String> etudiantReponses) {
		this.etudiantReponses = etudiantReponses;
	}

	@Override
	public float evaluationReponse() {
		float pourcentage = 0;
		HashSet<String> tmp = ((ReponseQcm) super.getReponseJuste()).getReponses();
		for (String p : propositions) {
			if (etudiantReponses.contains(p) && tmp.contains(p))
				pourcentage += 100 / propositions.size();
			else {
				if (etudiantReponses.contains(p) && !tmp.contains(p))
					pourcentage -= 100 / propositions.size();
				else {
					if (!etudiantReponses.contains(p) && tmp.contains(p))
						pourcentage -= 100 / propositions.size();
					else if (!etudiantReponses.contains(p) && !tmp.contains(p))
						pourcentage += 100 / propositions.size();

				}
			}
		}
		if (pourcentage < 0)
			return 0;
		else
			return pourcentage;
	}

}
