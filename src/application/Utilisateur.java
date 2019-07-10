package application;

public abstract class Utilisateur {
	private String nomUtilisateur;
	private String motDePasse;

	public Utilisateur() {
	}

	public Utilisateur(String nomUtilisateur, String mdp) {
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = mdp;
	}

	public Boolean authentifier(String nomUtilisateur, String motPasse) {
		if (this.nomUtilisateur.equals(nomUtilisateur) && this.motDePasse.equals(motPasse))
			return true;
		else
			return false;
	}

	public String getNomUtilisateur() {
		return this.nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String mdp) {
		motDePasse = mdp;
	}
}
