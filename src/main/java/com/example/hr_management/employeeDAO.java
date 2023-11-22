package com.example.hr_management;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class employeeDAO {
    ObservableList<employee> list = FXCollections.observableArrayList();

    public ObservableList<employee> populateTable() {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_management";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM tbl_employee";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
// Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("eid");
                String name = resultSet.getString("name");
                String salary = resultSet.getString("salary");
                list.add(new employee(id, name, salary));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void InsertData(String name, Double salary) {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_management";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
// Execute a SQL query to insert data in the database
            String query = "INSERT INTO `tbl_employee`( `name`, `salary`) VALUES ('" + name + "','" + salary + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
// Populate the table with data from the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateData(String name, Double salary, int id) {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_management";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
// Execute a SQL query to Updating data in the database
            String query = "UPDATE `tbl_employee` SET`name`='" + name + "',`salary`='" + salary + "' WHERE eid ='" + id + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
// Populate the table with data from the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteData(int id) {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_management";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
// Execute a SQL query to Updating data in the database
            String query = "DELETE FROM `tbl_employee` WHERE eid ='" + id + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
// Populate the table with data from the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public employee getDataById(int id) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_management";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM tbl_employee WHERE eid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int employeeId = resultSet.getInt("eid");
                String name = resultSet.getString("name");
                String salary = resultSet.getString("salary");
                return new employee(employeeId, name, salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
