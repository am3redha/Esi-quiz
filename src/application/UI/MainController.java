package application.UI;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
	@FXML
	private Label mohs;

	public void generateRandom(ActionEvent event) {
		int v = new Random().nextInt(100);
		mohs.setText(Integer.toString(v));
		System.out.println(v);

	}
}
