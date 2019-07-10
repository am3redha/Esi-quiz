package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EsiQuiz extends Application {

	public static HashSet<Utilisateur> comptes = new HashSet<Utilisateur>();

	public static Utilisateur authentifier(String user, String password) {
		for (Utilisateur utilisateur : comptes) {
			if (utilisateur.getNomUtilisateur().equals(user) && utilisateur.getMotDePasse().equals(password)) {
				return utilisateur;
			}
		}
		return null;

	}

	@Override
	public void start(Stage primaryStage) {
		try {

			AnchorPane vbox = FXMLLoader.load(getClass().getResource("/application/UI/Login.fxml"));
			Scene scene = new Scene(vbox, 300, 300);
			scene.getStylesheets().add(getClass().getResource("/application/UI/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void chargerQuestions(Formateur formateur, String nomFichier) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream(nomFichier));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			String[] donnee = scanner.nextLine().split(",");
			Question question = null;
			if (donnee[1].equals("qcm")) {
				question = new QuestionChoixMultiple(donnee[2],
						new ArrayList<String>(Arrays.asList(donnee[3].split("/"))),
						new ArrayList<String>(Arrays.asList(donnee[4].split("/"))));
				;
			} else {
				if (donnee[1].equals("qo")) {

				}
				question = new QuestionOuverte(donnee[2], new HashSet<String>(Arrays.asList(donnee[3].split("/"))));
			}
			formateur.ajouterQuestion(donnee[0], question);
			// apprenants.add(etudiant);
		}

	}

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Formateur formateur = new Formateur("moh", "123456");
		Formation formation = new Formation();
		formateur.setFormation(formation);
		HashMap<String, Integer> choix = new HashMap<String, Integer>();
		choix.put("math", 3);
		chargerQuestions(formateur, "questions.txt");
		formateur.ajouterQuestion("math", new QuestionChoixMultiple("2+2",
				new ArrayList<String>(Arrays.asList("5", "9", "4")), new ArrayList<String>(Arrays.asList("4"))));

		Quiz tmp = formation.genererQuiz("EMD", new SimpleDateFormat("dd/mm/yyyy").parse("27/07/2018"),
				new SimpleDateFormat("dd/mm/yyyy").parse("15/08/2019"), formateur.questions, choix);
		formation.quizs.add(tmp);
		formation.ajoutApprenants("apprenants.txt");
		int i = 0;
		System.out.println("liste des questions");
		for (String s : formateur.questions.keySet()) {
			System.out.println("notion: " + s);
			for (Question w : formateur.questions.get(s)) {
				if (w instanceof QuestionChoixMultiple) {
					System.out.println("question: " + w.getQuestion() + " propositions: "
							+ ((QuestionChoixMultiple) w).getPropositions().toString() + " reponse juste: "
							+ ((ReponseQcm) w.getReponseJuste()).getReponses());
				} else {
					System.out.println("question: " + w.getQuestion() + " mots clés: "
							+ ((ReponseQo) w.getReponseJuste()).getMotsCle().toString());
				}
			}
		}
		System.out.println("\n liste des quizs");
		for (Quiz q : formation.quizs) {
			System.out.println("quiz " + i + "titre: " + q.getNomQuiz());
			System.out.println("date debut: " + new SimpleDateFormat("dd/mm/yyyy").format(q.getDateOuverture())
					+ " date d'expiration: " + new SimpleDateFormat("dd/mm/yyyy").format(q.getDateExpiration()));
			for (Question qst : q.questions) {
				if (qst instanceof QuestionChoixMultiple) {
					System.out.println("question: " + qst.getQuestion() + " propositions: "
							+ ((QuestionChoixMultiple) qst).getPropositions().toString());
				} else {
					System.out.println("question: " + qst.getQuestion());
				}

			}
			i++;
		}
		System.out.println("\nLes apprenants:");
		for (Apprenant a : formation.apprenants) {
			System.out.println("nom: " + a.getNom() + " prenom: " + a.getPrenom() + " login: " + a.getNomUtilisateur()
					+ " mot de passe: " + a.getMotDePasse());
		}
		System.out.println("\nsaisir nom utilisateur: ");
		/*
		 * String user = scanner.nextLine();
		 * System.out.println("\nsaisir mot de passe: "); String pass =
		 * scanner.nextLine(); Utilisateur nouveauApprenants = authentifier(user, pass);
		 * if (nouveauApprenants != null) { System.out.println("bienvenue " +
		 * nouveauApprenants.getNomUtilisateur()); if (nouveauApprenants instanceof
		 * Apprenant) { nouveauApprenants = (Apprenant) nouveauApprenants; for (Quiz q :
		 * ((Apprenant) nouveauApprenants).getFormation().quizs) {
		 * System.out.println("repondre au quiz: " + q.getNomQuiz()); int repondues = 0;
		 * for (Question v : q.questions) { System.out.println("question: " +
		 * v.getQuestion()); if (v instanceof QuestionChoixMultiple) {
		 * System.out.println("propositions: ");
		 * System.out.println(((QuestionChoixMultiple) v).getPropositions().toString());
		 * } String answer = scanner.nextLine();
		 * 
		 * if (!answer.isEmpty()) { if (v instanceof QuestionChoixMultiple) {
		 * ((Apprenant) nouveauApprenants).repondreQcm(v, new
		 * HashSet<String>(Arrays.asList(answer.split(",")))); } else { ((Apprenant)
		 * nouveauApprenants).repondreQo(v, answer); } System.out.println("resultat: " +
		 * v.evaluationReponse() + "%"); repondues++;
		 * 
		 * } if (repondues == q.questions.size()) { System.out.println("quiz répondu");
		 * } }
		 * 
		 * } }
		 * 
		 * else nouveauApprenants = (Formateur) nouveauApprenants;
		 * 
		 * } // scanner.close(); System.out.println("liste des questions"); for (String
		 * s : formateur.questions.keySet()) { System.out.println("notion: " + s); for
		 * (Question w : formateur.questions.get(s)) { if (w instanceof
		 * QuestionChoixMultiple) { System.out.println("question: " + w.getQuestion() +
		 * " propositions: " + ((QuestionChoixMultiple) w).getPropositions().toString()
		 * + " reponse juste: " + ((ReponseQcm) w.getReponseJuste()).getReponses()); }
		 * else { System.out.println("question: " + w.getQuestion() + " mots clés: " +
		 * ((ReponseQo) w.getReponseJuste()).getMotsCle().toString()); } } }
		 */
		launch(args);

	}

}
