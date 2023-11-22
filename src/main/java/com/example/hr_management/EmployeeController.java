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

public class EmployeeController implements Initializable {
    public TextField iid;
    public TextField iname;
    public TextField isalary;
    public TableView<employee> TableView;

    public TableColumn<employee, Integer> id;
    public TableColumn<employee, String> name;
    public TableColumn<employee, Double> salary;

    ObservableList<employee> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new
                PropertyValueFactory<employee, Integer>("id"));
        name.setCellValueFactory(new
                PropertyValueFactory<employee, String>("name"));
        salary.setCellValueFactory(new
                PropertyValueFactory<employee, Double>("salary"));
        TableView.setItems(list);
    }

    public double yearlysalary(Double salary) {
        return salary*12;
    }

    public void InsertClick(ActionEvent actionEvent) {
        String name = iname.getText();
        Double salary = Double.valueOf(isalary.getText());
        employeeDAO a = new employeeDAO(); // creating object
        a.InsertData(name, salary);
    }

    public void UpdateClick(ActionEvent actionEvent) {
        String name = iname.getText();
        Double salary = Double.valueOf(isalary.getText());
        int id = Integer.parseInt(iid.getText());
        employeeDAO a = new employeeDAO(); // creating object
        a.UpdateData(name, salary, id);
    }

    public void DeleteClick(ActionEvent actionEvent) {
        int id = Integer.parseInt(iid.getText());
        employeeDAO a = new employeeDAO(); // creating object
        a.DeleteData(id);
    }

    public void ViewClick(ActionEvent actionEvent) {
        employeeDAO a = new employeeDAO(); // creating object
        list = a.populateTable(); // calling method using object of that class
        TableView.setItems(list);
    }

    public void LoadDataClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(iid.getText());
            employeeDAO a = new employeeDAO();
            employee employee = a.getDataById(id);
            if (employee != null) {
                iname.setText(employee.getName());
                isalary.setText(employee.getSalary());
            } else {
                // Handle the case where the ID doesn't exist
                iname.clear();
                isalary.clear();
            }
        } catch (NumberFormatException e) {
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
                    iid.getScene().getWindow();
            firstSceneStage.close();
// Show the second stage
            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
