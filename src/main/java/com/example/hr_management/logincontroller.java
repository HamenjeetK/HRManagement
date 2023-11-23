package com.example.hr_management;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class logincontroller implements Initializable {
    public TextField user;
    public TextField pswd;
    public Label text;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user.getCharacters();
        pswd.getCharacters();
    }

    @FXML
    public Button LButton;

    private int loginAttempts = 0;
    private final int maxLoginAttempts = 5;

    // username Hamen
    // login password hamen123
    
    @FXML
    protected void LoginButtonClick() {
        String a = user.getText();
        String b = pswd.getText();
        if (a.isEmpty() || b.isEmpty()) {
            text.setText("Please provide username or password.");
        } else {
            if (checkCredentials(a, b)) {
                text.setText("Login Success !");
                try {
// Load the FXML file for the second scene
                    Parent secondScene = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
// Create a new stage for the second scene
                    Stage secondStage = new Stage();
                    secondStage.setTitle("Dashboard");
                    secondStage.setScene(new Scene(secondScene));
// Close the first scene's stage
                    Stage firstSceneStage = (Stage)
                            user.getScene().getWindow();
                    firstSceneStage.close();
// Show the second stage
                    secondStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                loginAttempts++;
                if (loginAttempts < maxLoginAttempts) {
                    int attemptsLeft = maxLoginAttempts - loginAttempts;
                    text.setText("Invalid Login Credentials. " + attemptsLeft + " attempts are left.");
                } else {
                    text.setText("Sorry, Your Account is Locked !");
                    LButton.setDisable(true); // Disable login button
                }
            }
        }
    }

    private boolean checkCredentials(String a, String b) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_management";
        String dbUser = "root";
        String dbPassword = "";

            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                String query ="SELECT password FROM tbl_admin WHERE name = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, a);
                ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                return storedPassword.equals(b);
            }
        }
            catch (SQLException e) {
            e.printStackTrace();

            }
        return false;
    }
}
