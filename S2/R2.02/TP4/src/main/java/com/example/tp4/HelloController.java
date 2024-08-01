package com.example.tp4;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
	final Calculatrice calculatrice = new Calculatrice();

	@FXML
	private TextField text;
	@FXML
	private Button zero;
	@FXML
	private Button or;
	@FXML
	private Button one;
	@FXML
	private Button and;
	@FXML
	private Button eqal;

	@FXML
	protected void onAddClicked() {
		calculatrice.setOperation("et");
	}

	@FXML
	protected void onOrClicked(){
		calculatrice.setOperation("ou");
	}

	@FXML
	protected void onEqualClicked(){
		text.setText(String.valueOf(calculatrice.getResultat()));
	}

	@FXML
	protected void onZeroClicked(){
		calculatrice.setOperande(0);
	}

	@FXML
	protected void onOneCliecked(){
		calculatrice.setOperande(1);
	}
}