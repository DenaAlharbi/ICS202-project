package com.example.ics202project241;
#hello
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox mainMenu = new VBox(10);
        mainMenu.getStyleClass().add("main-menu");

        Button searchStudentButton = new Button("Search Student");
        Button addStudentButton = new Button("Add New Student");
        Button showStudentsButton = new Button("Show students in an academic level");
        Button exitButton = new Button("Exit");

        searchStudentButton.getStyleClass().add("button");
        addStudentButton.getStyleClass().add("button");
        showStudentsButton.getStyleClass().add("button");
        exitButton.getStyleClass().add("button");

        searchStudentButton.setOnAction(e -> searchStudent());
        addStudentButton.setOnAction(e -> addNewStudent());
        showStudentsButton.setOnAction(e -> showStudentsInAcademicLevel());
        exitButton.setOnAction(e -> stage.close());

        mainMenu.getChildren().addAll(searchStudentButton, addStudentButton, showStudentsButton, exitButton);

        Scene scene = new Scene(mainMenu, 300, 200);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Student Management System");
        stage.setScene(scene);
        stage.show();
    }

    private void searchStudent() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Search Student");
        dialog.setHeaderText("Enter student name or ID to search:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(nameOrId -> {
            // Implement search logic here
            // For demonstration, we'll just show an alert
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Search Result");
            alert.setHeaderText(null);
            alert.setContentText("Student found: " + nameOrId);
            alert.showAndWait();

            // Prompt for further actions
            Alert actionAlert = new Alert(AlertType.CONFIRMATION);
            actionAlert.setTitle("Student Actions");
            actionAlert.setHeaderText("What would you like to do?");
            actionAlert.setContentText("Choose your option.");

            ButtonType editButton = new ButtonType("Edit");
            ButtonType deleteButton = new ButtonType("Delete");
            ButtonType returnButton = new ButtonType("Return to main menu");

            actionAlert.getButtonTypes().setAll(editButton, deleteButton, returnButton);

            Optional<ButtonType> actionResult = actionAlert.showAndWait();
            if (actionResult.isPresent()) {
                if (actionResult.get() == editButton) {
                    // Implement edit logic here
                } else if (actionResult.get() == deleteButton) {
                    // Implement delete logic here
                }
            }
        });
    }

    private void addNewStudent() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add New Student");
        dialog.setHeaderText("Enter student name:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> {
            // Implement add logic here
        });
    }

    private void showStudentsInAcademicLevel() {
        // Implement logic to show students in an academic level
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Students in Academic Level");
        alert.setHeaderText(null);
        alert.setContentText("Displaying students in the selected academic level.");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}

