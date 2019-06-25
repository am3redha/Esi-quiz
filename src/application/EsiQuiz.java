package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EsiQuiz extends Application {

	private ArrayList<Utilisateur> comptes = new ArrayList<Utilisateur>();

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			// primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		Formateur formateur = new Formateur("moh", "123456");

		Formation formation = new Formation();
		ArrayList<ArrayList<String>> apprenants = new ArrayList<ArrayList<String>>();
		String[][] app = { { "nom", "prenom", "19/01/2000", "adresse" },
				{ "nom2", "prenom2", "19/11/2005", "adresse2" }, { "nom3", "prenom3", "29/07/2009", "adresse3" } };
		formateur.setFormation(formation);

		launch(args);
	}

	public ArrayList<Utilisateur> getComptes() {
		return comptes;
	}

	public void setComptes(ArrayList<Utilisateur> comptes) {
		this.comptes = comptes;
	}

}
