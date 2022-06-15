package customermanagementgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {

    ObservableList<CustomerObject> customerList = FXCollections.observableArrayList();

    @FXML
    private Label bottomLable;

    @FXML
    private TextField emailTextbox;

    @FXML
    private TextField idTextbox;

    @FXML
    private TextField mobileTextBox;

    @FXML
    private TextField nameTextbox;

    @FXML
    private TextField searchTextbox;

    @FXML
    private TableColumn<CustomerObject, Integer> tableID;

    @FXML
    private TableColumn<CustomerObject, String> tableMobile;

    @FXML
    private TableColumn<CustomerObject, String> tableName;

    @FXML
    private TableColumn<CustomerObject, String> tableEmail;

    @FXML
    private TableView<CustomerObject> tableView;

    @FXML
    void addClicked(MouseEvent event) {
        Add();
        Showdatabase();

    }

    @FXML
    void createnewDataBaseClicked(MouseEvent event) {
        createDataBase();
        Connect();
        Showdatabase();
        Clear();
    }

    @FXML
    void deleteClicked(MouseEvent event) {
        Delete();
        Showdatabase();
        Clear();
    }

    @FXML
    void searchClicked(MouseEvent event) {
        Search();

    }

    @FXML
    void updateClicked(MouseEvent event) {
        Update();
        Clear();
    }

    @FXML
    void clearBoxClicked(MouseEvent event) {
        Clear();
    }

    @FXML
    void connectDBClicked(MouseEvent event) {
        Connect();
        Showdatabase();
        Clear();
    }

    Scanner sc = new Scanner(System.in);
    String url = "jdbc:mysql://localhost:3306/smtbiz";
    String user = "root";
    String password = "";
    Connection con = null;
    Statement stmt = null;
    String query;
    ResultSet result = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        tableID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));

        tableView.setItems(customerList);
        bottomLable.setText("Conncet to a database named smtbiz or Create a new one ");
    }

    public void createDataBase() {

        String crUrl = "jdbc:mysql://localhost:3306/";
        String crUser = "root";
        String crPassword = "";
        Connection con = null;
        Statement stmt = null;
        String query;
        ResultSet result = null;

        try {

            con = DriverManager.getConnection(crUrl, crUser, crPassword);
            stmt = con.createStatement();

            query = "DROP DATABASE IF EXISTS smtbiz;";
            stmt.executeUpdate(query);
            query = "CREATE DATABASE smtbiz;";
            stmt.executeUpdate(query);
            query = "USE smtbiz;";
            stmt.executeUpdate(query);
            query = """
                    CREATE TABLE customer
                    (
                    ID INT PRIMARY KEY NOT NULL,
                    Name VARCHAR (50) NOT NULL,
                    Email VARCHAR (50) NOT NULL,
                    Mobile VARCHAR (50) NOT NULL
                    
                    );
                    """;
            stmt.executeUpdate(query);
            query = """
                    INSERT INTO customer
                        	(ID, Name, Email, Mobile)
                        VALUES
                        	(1234, "Sam", "sam.hall@gmail.com", "42140580"),
                                (2346, "Dam", "dam.brook@gmail.com", "42460554"),
                                (3464, "Pam", "pam.smith@gmail.com", "42140895"),
                                (3897, "Josh", "josh.black@gmail.com", "42934051"),
                                (4554, "Ham", "ham.pork@gmail.com", "41437545");
                    """;
            stmt.executeUpdate(query);

            customerList.add(new CustomerObject(1234, "Sam", "sam.hall@gmail.com", "42140580"));
            customerList.add(new CustomerObject(2346, "Dam", "dam.brook@gmail.com", "42460554"));
            customerList.add(new CustomerObject(3464, "Pam", "pam.smith@gmail.com", "42140895"));
            customerList.add(new CustomerObject(3897, "Josh", "josh.black@gmail.com", "42934051"));
            customerList.add(new CustomerObject(4554, "Ham", "ham.pork@gmail.com", "41437545"));

        } catch (SQLException ex) {
            bottomLable.setText("SQLException on database creation: " + ex.getMessage());
        } finally {
            try {
                if (result != null) {
                    result.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                bottomLable.setText("SQLException caught: " + ex.getMessage());
            }
        }
    }

    public void Connect() {

        try {
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);
            stmt = con.createStatement();

        } catch (SQLException ex) {
            bottomLable.setText("No Data base called smtbiz found");
        }

    }

    public void Showdatabase() {
        customerList.clear();
        try {
            query = "SELECT * FROM customer;";
            result = stmt.executeQuery(query);
            con.commit();

            while (result.next()) {
                int id = result.getInt("ID");
                String name = result.getString("Name");
                String email = result.getString("Email");
                String mobile = result.getString("Mobile");

                customerList.add(new CustomerObject(id, name, email, mobile));
            }

            tableView.setItems(customerList);
        } catch (SQLException ex) {
            bottomLable.setText("Could not open database");
        }

    }

    public void Close() {
        try {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            bottomLable.setText("Could not close datebase");
        } catch (Exception ex) {
            bottomLable.setText("Nothing was open");
        }
    }

    public void Add() {
        try {

            int subId = Integer.parseInt(idTextbox.getText());

            String subName = nameTextbox.getText();

            String subEmail = emailTextbox.getText();

            String subMobile = mobileTextBox.getText();

            stmt = con.createStatement();

            query = "INSERT INTO customer (ID, Name, Email, Mobile) VALUES ("
                    + subId + ", '" + subName + "', '" + subEmail + "', '"
                    + subMobile + "');";

            stmt.executeUpdate(query);
            con.commit();

        } catch (SQLException ex) {
            bottomLable.setText("Could not add to database");
        } catch (InputMismatchException ex) {
            bottomLable.setText("ERROR!!! Please enter correct value");
        } catch (Exception e) {
            bottomLable.setText("ERROR!!! Please fill all boxes and enter correct value");
        }
        Clear();
    }

    public void Update() {
        try {

            int subId = Integer.parseInt(idTextbox.getText());

            String subName = nameTextbox.getText();

            String subEmail = emailTextbox.getText();

            String subMobile = mobileTextBox.getText();

            stmt = con.createStatement();

            query = "UPDATE customer SET Name = '" + subName + "', Email = '" + subEmail + "', Mobile = '" + subMobile + "' WHERE ID = " + subId + ";";

            stmt.executeUpdate(query);
            con.commit();

        } catch (SQLException ex) {
            bottomLable.setText("Could not add to database");
        } catch (InputMismatchException ex) {
            bottomLable.setText("ERROR!!! Please enter correct value");
        } catch (Exception e) {
            bottomLable.setText("ERROR!!! Please fill all boxes and enter correct value");
        }
        Showdatabase();
    }

    public void Delete() {

        try {
            int subId = Integer.parseInt(idTextbox.getText());
            query = "DELETE FROM customer WHERE ID = " + subId + ";";
            stmt.execute(query);
            con.commit();
        } catch (SQLException ex) {
            bottomLable.setText("Could not delete from database");
        } catch (Exception e) {
            bottomLable.setText("ERROR!!! Could not delete value");
        }
    }

    public void Search() {

        try {
            int subId = Integer.parseInt(searchTextbox.getText());
            query = "SELECT * FROM customer WHERE ID = " + subId + ";";
            result = stmt.executeQuery(query);
            con.commit();
            boolean notfound = true;
            while (result.next()) {
                int id = result.getInt("ID");
                String name = result.getString("Name");
                String email = result.getString("Email");
                String mobile = result.getString("Mobile");

                idTextbox.setText(String.valueOf(id));
                nameTextbox.setText(name);
                emailTextbox.setText(email);
                mobileTextBox.setText(mobile);

                notfound = false;
            }

            if (notfound == true) {
                bottomLable.setText("The custmoer with the ID " + subId + " could not be found in the database");
            }

        } catch (SQLException ex) {
            bottomLable.setText("Could not open database");
        } catch (InputMismatchException ex) {
            bottomLable.setText("ERROR!!! Please enter correct value");
        } catch (Exception e) {
            bottomLable.setText("ERROR!!! Please fill search boxes and enter correct value");
        }
    }

    public void Clear() {
        idTextbox.clear();
        nameTextbox.clear();
        emailTextbox.clear();
        mobileTextBox.clear();
        searchTextbox.clear();
        bottomLable.setText("");
    }

}
