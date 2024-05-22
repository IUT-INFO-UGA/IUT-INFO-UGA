package com.example.tp6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button EndButton;
    @FXML
    private Button _0;
    @FXML
    private Button _1;
    @FXML
    private Button _2;
    @FXML
    private Button _3;
    @FXML
    private Button _4;
    @FXML
    private Button _5;
    @FXML
    private Button _6;
    @FXML
    private Button _7;
    @FXML
    private Button _8;
    final Morpion morpion = new Morpion();

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onEndButtonClick() {
        System.exit(0);
    }

    @FXML
    protected void onButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        int x = Character.getNumericValue(button.getId().charAt(1));
        final boolean end = morpion.jouer(x);
        button.setText(morpion.getJoueurCourant() == 0 ? "X" : "O");
        button.setDisable(true);
        if (end) {
            _0.setDisable(true);
            _1.setDisable(true);
            _2.setDisable(true);
            _3.setDisable(true);
            _4.setDisable(true);
            _5.setDisable(true);
            _6.setDisable(true);
            _7.setDisable(true);
            _8.setDisable(true);
            welcomeText.setText("Joueur " + (morpion.getJoueurCourant() + 1) + " a gagné");
        } else {
            welcomeText.setText("Joueur " + (morpion.getJoueurCourant() + 1) + " à toi de jouer");
        }

    }
}
