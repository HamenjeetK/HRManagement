package com.example.hr_management;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public TextField iaid;
    public TextField iadmin;
    public TextField iapswd;
    public TextField imail;
    public TableView<Admin> tableView;
    public TableColumn<Admin, Integer> aid;
    public TableColumn<Admin, String> admin;
    public TableColumn<Admin, String> apswd;
    public TableColumn<Admin, String> mail;
    ObservableList<Admin> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        aid.setCellValueFactory(new
                PropertyValueFactory<Admin, Integer>("aid"));
        admin.setCellValueFactory(new
                PropertyValueFactory<Admin, String>("admin"));
        apswd.setCellValueFactory(new
                PropertyValueFactory<Admin, String>("apswd"));
        mail.setCellValueFactory(new
                PropertyValueFactory<Admin, String>("mail"));
        tableView.setItems(list);
    }
    public void InsertClick(ActionEvent actionEvent) {
        String admin = iadmin.getText();
        String mail = imail.getText();
        String apswd = iapswd.getText();
        AdminDAO a = new AdminDAO(); // creating object
        a.InsertData(admin, mail, apswd);
    }

    public void UpdateClick(ActionEvent actionEvent) {
        String admin = iadmin.getText();
        String mail = imail.getText();
        String apswd = iapswd.getText();
        int aid = Integer.parseInt(iaid.getText());
        AdminDAO a = new AdminDAO(); // creating object
        a.UpdateData(admin, mail, apswd,aid);
    }

    public void DeleteClick(ActionEvent actionEvent) {
        int aid = Integer.parseInt(iaid.getText());
        AdminDAO a = new AdminDAO(); // creating object
        a.DeleteData(aid);
    }

    public void ViewClick(ActionEvent actionEvent) {
        AdminDAO a = new AdminDAO(); // creating object
        list = a.populateTable(); // calling method using object of that class
        tableView.setItems(list);
    }

    public void LoadDataClick(ActionEvent actionEvent) {try{
        int aid = Integer.parseInt(iaid.getText());
        AdminDAO a = new AdminDAO();
        Admin Admin = a.getDataById(aid);
        if (Admin != null) {
            iadmin.setText(Admin.getAdmin());
            imail.setText(String.valueOf(Admin.getMail()));
            iapswd.setText(String.valueOf(Admin.getApswd()));
        } else {
            // Handle the case where the ID doesn't exist
            iadmin.clear();
            imail.clear();
            iapswd.clear();
        }
    } catch(NumberFormatException e) {
    }
    }

    public void BackClick(ActionEvent actionEvent) {
        try {
// Load the FXML file for the second scene
            Parent secondScene = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
// Create a new stage for the second scene
            Stage secondStage = new Stage();
            secondStage.setTitle("Login");
            secondStage.setScene(new Scene(secondScene));
// Close the first scene's stage
            Stage firstSceneStage = (Stage)
                    iadmin.getScene().getWindow();
            firstSceneStage.close();
// Show the second stage
            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
