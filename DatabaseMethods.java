package studentscoredb;

import java.sql.*;
import java.util.Scanner;

public class DatabaseMethods {

    Scanner sc = new Scanner(System.in);
    String url = "jdbc:mysql://localhost:3306/student_management";
    String user = "root";
    String password = "";
    Connection con = null;
    Statement stmt = null;
    String query;
    ResultSet result = null;

    public void Connect() {
        try {
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);
            stmt = con.createStatement();

        } catch (SQLException ex) {
            System.out.println("SQLException caught: " + ex.getMessage());
        }

    }

    public void Showdatabase() {
        try {
            query = "SELECT * FROM student_score;";
            result = stmt.executeQuery(query);
            con.commit();
            System.out.printf("%-35s%-12s  \n",
                    "Subject", "Score");
            while (result.next()) {
                String Subject = result.getString("Subject");
                int Score = result.getInt("Score");
                System.out.printf("%-35s %10d \n",
                        Subject, Score);
            }
        } catch (SQLException ex) {
            System.out.println("Could not open database");
        }
    }

    public void Add() {
        System.out.println("What Subject do you want to add?");
        String subName = sc.next();
        System.out.println("What Score did you get?");
        int subScore = sc.nextInt();
        try {
            stmt = con.createStatement();

            query = "INSERT INTO student_score (Subject, Score)"
                    + "VALUES ('" + subName + "', " + subScore + ");";
            stmt.executeUpdate(query);
            con.commit();
        } catch (SQLException ex) {
            System.out.println("Could not add to database");
        }
    }

    public void Delete() {
        System.out.println("What Subject do you want to delete?");
        String subName = sc.next();
        System.out.println("What is it's Score?");
        int subScore = sc.nextInt();
        try {
            query = "DELETE FROM student_score WHERE Subject = '" + subName + "'"
                    + "AND Score = " + subScore + ";";
            stmt.execute(query);
            con.commit();
        } catch (SQLException ex) {
            System.out.println("Could not delete from database");
        }
    }

    public void Update() {
        System.out.println("What Subject do you want to update?");
        String subName = sc.next();
        System.out.println("What is old Score?");
        int oldScore = sc.nextInt();
        System.out.println("What is new Score you want to change to?");
        int newScore = sc.nextInt();
        try {
            query = "UPDATE student_score "
                    + "SET Score = " + newScore + ", Subject = '"+ subName+"'"
                    + "WHERE Subject = '" + subName + "'"
                    + "AND Score = " + oldScore + ";";
            stmt.executeUpdate(query);
            con.commit();
        } catch (SQLException ex) {
            System.out.println("Could not update the database");
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

}
