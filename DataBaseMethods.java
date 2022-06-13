package customermanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Poorav Sharma
 */
public class DataBaseMethods {

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

            System.out.println("\n##############################");
            System.out.println(" Database is being created...");
            System.out.println("##############################\n");
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
        } catch (SQLException ex) {
            System.out.println("SQLException on database creation: " + ex.getMessage());
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
                System.out.println("SQLException caught: " + ex.getMessage());
            }
        }
    }

    Scanner sc = new Scanner(System.in);
    String url = "jdbc:mysql://localhost:3306/smtbiz";
    String user = "root";
    String password = "";
    Connection con = null;
    Statement stmt = null;
    String query;
    ResultSet result = null;

    public void Connect() {
        System.out.println("\n##############################");
        System.out.println(" Connecting to DataBase...");
        System.out.println("##############################\n");
        try {
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);
            stmt = con.createStatement();

        } catch (SQLException ex) {
            System.out.println("No Data base called smtbiz found");
        }

    }

    public void Showdatabase() {
        try {
            query = "SELECT * FROM customer;";
            result = stmt.executeQuery(query);
            con.commit();
            System.out.println("ID\tName\tEmail\t\t\tMobile");
            while (result.next()) {
                int id = result.getInt("ID");
                String name = result.getString("Name");
                String email = result.getString("Email");
                String mobile = result.getString("Mobile");
                System.out.println(id + "\t" + name + "\t" + email + "\t" + mobile);

            }
        } catch (SQLException ex) {
            System.out.println("Could not open database");
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
            System.out.println("Could not close datebase");
        }
    }

    public void Add() {
        try {
            System.out.println("What is the Customer ID?");
            int subId = sc.nextInt();
            sc.nextLine();
            System.out.println("What the Customer's Name?");
            String subName = sc.next();

            System.out.println("What the Customer's Email?");
            String subEmail = sc.next();

            System.out.println("What the Customer's number?");
            String subMobile = sc.next();

            stmt = con.createStatement();

            query = "INSERT INTO customer (ID, Name, Email, Mobile) VALUES ("
                    + subId + ", '" + subName + "', '" + subEmail + "', '"
                    + subMobile + "');";

            stmt.executeUpdate(query);
            con.commit();
        } catch (SQLException ex) {
            System.out.println("Could not add to database");
        } catch (InputMismatchException ex) {
            System.out.println("ERROR!!! Please enter correct value");
        }
    }

    public void Delete() {
        System.out.println("What is the ID of the customer you want to delete from the database?");
        int subId = sc.nextInt();
        try {
            query = "DELETE FROM customer WHERE ID = " + subId + ";";
            stmt.execute(query);
            con.commit();
        } catch (SQLException ex) {
            System.out.println("Could not delete from database");
        }
    }

    public void Search() {
        System.out.println("What is the ID of the customer you search for in the database?");
        int subId = sc.nextInt();
        try {
            query = "SELECT * FROM customer WHERE ID = " + subId + ";";
            result = stmt.executeQuery(query);
            con.commit();
            System.out.println("ID\tName\tEmail\t\t\tMobile");
            int index = 0;
            while (result.next()) {
                int id = result.getInt("ID");
                String name = result.getString("Name");
                String email = result.getString("Email");
                String mobile = result.getString("Mobile");
                System.out.println(id + "\t" + name + "\t" + email + "\t" + mobile);
                index++;
            }
            if (index == 0) {
                System.out.println("\nThe custmoer with the ID " + subId + " could not be found in the database");
            }
        } catch (SQLException ex) {
            System.out.println("Could not open database");
        } catch (InputMismatchException ex) {
            System.out.println("ERROR!!! Please enter correct value");
        }
    }

}
