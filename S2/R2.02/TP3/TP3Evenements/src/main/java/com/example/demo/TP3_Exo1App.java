package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TP3_Exo1App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Infos");
        VBox vbox = new VBox();
        vbox.setPrefWidth(350);
        vbox.setPrefHeight(300);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(0, 20, 20, 20));
        gridPane.setAlignment(Pos.CENTER);

        Label labelNom = new Label("Nom : ");
        Label labelPrenom = new Label("Prénom : ");
        Label labelLogin = new Label("Login : ");
        Label labelMdP = new Label("Mot de passe : ");

        TextField tfNom = new TextField();
        TextField tfPrenom = new TextField();
        TextField tfLogin = new TextField();
        tfLogin.setEditable(false);
        PasswordField pfMdP = new PasswordField();

        gridPane.add(labelNom, 0, 0);
        gridPane.add(labelPrenom, 0, 1);
        gridPane.add(labelLogin, 0, 2);
        gridPane.add(labelMdP, 0, 3);

        gridPane.add(tfNom, 1, 0);
        gridPane.add(tfPrenom, 1, 1);
        gridPane.add(tfLogin, 1, 2);
        gridPane.add(pfMdP, 1, 3);

        Button btnReset = new Button("Reset");
        Button btnVerifier = new Button("Vérifier");
        Button btnQuitter = new Button("Quitter");

        HBox hboxBoutons = new HBox();
        hboxBoutons.setSpacing(30);
        hboxBoutons.setAlignment(Pos.CENTER);
        hboxBoutons.setPadding(new Insets(0, 0, 20, 0));
        hboxBoutons.getChildren().addAll(btnReset, btnVerifier, btnQuitter);

        TextArea taCachee = new TextArea("Passez la souris ici !");
        taCachee.setEditable(false);

        // Ajoutez vos gestionnaires d'évènements
        btnReset.setOnAction(e -> {
            tfNom.clear();
            tfPrenom.clear();
            pfMdP.clear();
            tfLogin.clear();
        });

        tfNom.setOnKeyTyped(e -> {
            String name = tfNom.getText().replaceAll(" ", "").toLowerCase();
            String login = name.substring(0, Math.min(name.length(), 7));

            int i = 0;
            String prenom = tfPrenom.getText().replaceAll(" ", "").toLowerCase();
            while (login.length() < 8 && i < prenom.length()) {
                login += prenom.charAt(i);
                i++;
            }
            tfLogin.setText(login);
        });

        tfPrenom.setOnKeyTyped(e -> {
            String name = tfNom.getText().replaceAll(" ", "").toLowerCase();
            String login = name.substring(0, Math.min(name.length(), 7));

            int i = 0;
            String prenom = tfPrenom.getText().replaceAll(" ", "").toLowerCase();
            while (login.length() < 8 && i < prenom.length()) {
                login += prenom.charAt(i);
                i++;
            }
            tfLogin.setText(login);
        });

        btnVerifier.setOnAction(e -> {
            if (tfNom.getText().isEmpty())
                tfNom.setStyle("-fx-border-color: red");
            else
                tfNom.setStyle("");

            if (tfPrenom.getText().isEmpty())
                tfPrenom.setStyle("-fx-border-color: red");
            else
                tfPrenom.setStyle("");

            if (pfMdP.getText().length() < 8)
                pfMdP.setStyle("-fx-border-color: red");
            else
                pfMdP.setStyle("");
        });

        btnQuitter.setOnAction(e -> {
            stage.close();
        });

        taCachee.setOnMouseEntered(e -> {
            taCachee.setText("mot de passe : " + pfMdP.getText() + "\n"
                    + "login : " + tfLogin.getText() + "\n"
                    + "nom : " + tfNom.getText() + "\n"
                    + "prenom : " + tfPrenom.getText());

        });

        taCachee.setOnMouseExited(e -> {
            taCachee.setText("Passez la souris ici !");
        });

        vbox.getChildren().addAll(gridPane, hboxBoutons, taCachee);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
