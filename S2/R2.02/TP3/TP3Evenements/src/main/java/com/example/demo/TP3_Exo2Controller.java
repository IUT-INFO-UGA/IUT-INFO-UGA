package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TP3_Exo2Controller {
	@FXML
	public TextField prenom;
	@FXML
	public RadioButton femme;
	@FXML
	public RadioButton homme;
	@FXML
	public RadioButton autre;
	@FXML
	public TextField nom;
	@FXML
	public CheckBox voiture;
	@FXML
	public CheckBox train;
	@FXML
	public CheckBox tram;
	@FXML
	public CheckBox velo;
	@FXML
	public ComboBox<String> lieu;
	@FXML
	public Button valider;
	@FXML
	public Button annuler;
	@FXML
	public Label s2nom;
	@FXML
	public Label s2prenom;
	@FXML
	public Label genre;
	@FXML
	public Label transport;
	@FXML
	public Label emplacement;
	@FXML
	public Button retour;

	@FXML
	public void annuler(ActionEvent event) {
		prenom.setText("");
		nom.setText("");
		femme.setSelected(false);
		homme.setSelected(false);
		autre.setSelected(false);
		voiture.setSelected(false);
		train.setSelected(false);
		tram.setSelected(false);
		velo.setSelected(false);
		lieu.setValue(null);
	}

	@FXML
	public void valider(ActionEvent event) {
		Stage stage = (Stage) valider.getScene().getWindow();
		stage.setScene(retour.getScene());
		stage.show();
		s2nom.setText("nom " + nom.getText());
		s2prenom.setText("prenom" + prenom.getText());
		if (femme.isSelected()) {
			genre.setText("genre Femme");
		} else if (homme.isSelected()) {
			genre.setText("genre Homme");
		} else if (autre.isSelected()) {
			genre.setText("genre Autre");
		}
		if (voiture.isSelected()) {
			transport.setText("transport Voiture");
		} else if (train.isSelected()) {
			transport.setText("transport Train");
		} else if (tram.isSelected()) {
			transport.setText("transport Tram");
		} else if (velo.isSelected()) {
			transport.setText("transport Vélo");
		}
		emplacement.setText("lieu" + lieu.getValue());
	}

	public void retour(ActionEvent event) {
		Stage stage = (Stage) retour.getScene().getWindow();
		stage.setScene(valider.getScene());
		stage.show();
	}
}