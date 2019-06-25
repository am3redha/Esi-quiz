package application;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Apprenant extends Utilisateur {
	private String prenom;
	private String nom;
	private String adresse;
	private Date dateDeNaissance;
	private Formation formation;

	public Apprenant(String nom, String prenom, Date dateNaissance, String adresse) throws Exception {
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateNaissance;
		this.adresse = adresse;
		generLogin();
	}

	public Apprenant() {
		super();
	}

	public Apprenant(String id, String mdp) {
		super(id, mdp);
	}

	public void generLogin() throws Exception {
		setNomUtilisateur(prenom.charAt(0) + nom);
		setMotDePasse(nom + new SimpleDateFormat("dd/MM/yyyy").parse(dateDeNaissance.toString()));
	}

	public void generMotDePasse() {
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}
