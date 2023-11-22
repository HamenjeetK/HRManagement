package com.example.hr_management;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class AdminDAO {
    ObservableList<Admin> list = FXCollections.observableArrayList();

    public ObservableList<Admin> populateTable() {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_management";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM tbl_admin";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
// Populate the table with data from the database
            while (resultSet.next()) {
                int aid = resultSet.getInt("aid");
                String admin = resultSet.getString("name");
                String apswd = resultSet.getString("password");
                String mail = resultSet.getString("email");
                list.add(new Admin(aid, admin, apswd, mail));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void InsertData(String admin, String apswd, String mail) {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_management";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl,
                dbUser,
                dbPassword)) {
// Execute a SQL query to insert data in the database
            String query = "INSERT INTO `tbl_admin`( `name`, `email`,`password`) VALUES ('" + admin + "','" + mail + "','" + apswd + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
// Populate the table with data from the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateData(String admin, String mail, String apswd, int aid) {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_management";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl,
                dbUser,
                dbPassword)) {
// Execute a SQL query to Updating data in the database
            String query = "UPDATE `tbl_admin` SET`name`='" + admin + "',`email`='" + mail + "',`password`='" + apswd + "' WHERE aid ='" + aid + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
// Populate the table with data from the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteData(int aid) {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_management";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
// Execute a SQL query to Updating data in the database
            String query = "DELETE FROM `tbl_admin` WHERE aid ='" + aid + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
// Populate the table with data from the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Admin getDataById(int aid) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_management";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM tbl_admin WHERE aid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, aid);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int adminId = resultSet.getInt("aid");
                String admin = resultSet.getString("name");
                String mail = resultSet.getString("email");
                String apswd= resultSet.getString("password");
                return new Admin(adminId, admin, mail, apswd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
