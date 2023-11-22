package com.example.hr_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    public Label Hamen;

    public void emp(ActionEvent actionEvent) {
        try {
// Load the FXML file for the second scene
            Parent secondScene = FXMLLoader.load(getClass().getResource("employee.fxml"));
// Create a new stage for the second scene
            Stage secondStage = new Stage();
            secondStage.setTitle("Employee");
            secondStage.setScene(new Scene(secondScene));
// Close the first scene's stage
            Stage firstSceneStage = (Stage)
                   Hamen.getScene().getWindow();
            firstSceneStage.close();
// Show the second stage
            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void admin(ActionEvent actionEvent) {
        try {
// Load the FXML file for the second scene
            Parent secondScene = FXMLLoader.load(getClass().getResource("Admin.fxml"));
// Create a new stage for the second scene
            Stage secondStage = new Stage();
            secondStage.setTitle("Admin");
            secondStage.setScene(new Scene(secondScene));
// Close the first scene's stage
            Stage firstSceneStage = (Stage)
                    Hamen.getScene().getWindow();
            firstSceneStage.close();
// Show the second stage
            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logout(ActionEvent actionEvent) {
        try {
// Load the FXML file for the second scene
            Parent secondScene = FXMLLoader.load(getClass().getResource("login.fxml"));
// Create a new stage for the second scene
            Stage secondStage = new Stage();
            secondStage.setTitle("Login");
            secondStage.setScene(new Scene(secondScene));
// Close the first scene's stage
            Stage firstSceneStage = (Stage)
                    Hamen.getScene().getWindow();
            firstSceneStage.close();
// Show the second stage
            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit(ActionEvent actionEvent) {
        Stage firstSceneStage = (Stage)
                Hamen.getScene().getWindow();
        firstSceneStage.close();
    }
}
