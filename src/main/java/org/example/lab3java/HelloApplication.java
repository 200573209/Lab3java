package org.example.lab3java;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloApplication extends Application{

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("User Form Validation");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);

        // Name Input
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 0);

        // Contact Number Label
        Label contactLabel = new Label("Contact Number:");
        GridPane.setConstraints(contactLabel, 0, 1);

        // Contact Number Input
        TextField contactInput = new TextField();
        GridPane.setConstraints(contactInput, 1, 1);

        // Postal Code Label
        Label postalCodeLabel = new Label("Postal Code:");
        GridPane.setConstraints(postalCodeLabel, 0, 2);

        // Postal Code Input
        TextField postalCodeInput = new TextField();
        GridPane.setConstraints(postalCodeInput, 1, 2);

        // Validate Button
        Button validateButton = new Button("Validate");
        GridPane.setConstraints(validateButton, 1, 3);

        // Validation Message
        Label validationMessage = new Label();
        GridPane.setConstraints(validationMessage, 1, 4);

        validateButton.setOnAction(e -> {
            String name = nameInput.getText();
            String contact = contactInput.getText();
            String postalCode = postalCodeInput.getText();

            if (validateUsername(name) && validateContactNumber(contact) && validatePostalCode(postalCode)) {
                validationMessage.setText("Validation Successful!");
            } else {
                validationMessage.setText("Validation Failed. Please check your inputs.");
            }
        });

        grid.getChildren().addAll(nameLabel, nameInput, contactLabel, contactInput, postalCodeLabel, postalCodeInput, validateButton, validationMessage);

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean validateUsername(String name) {
        String regex = "^[A-Z][a-zA-Z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private boolean validateContactNumber(String contact) {
        String regex1 = "^\\d{3} \\d{3} \\d{4}$";
        String regex2 = "^\\(\\d{3}\\) \\d{3} \\d{4}$";
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher1 = pattern1.matcher(contact);
        Matcher matcher2 = pattern2.matcher(contact);
        return matcher1.matches() || matcher2.matches();
    }

    private boolean validatePostalCode(String postalCode) {
        String regex = "^[A-Za-z]\\d[A-Za-z][ -]?\\d[A-Za-z]\\d$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(postalCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        launch(args);
    }
}