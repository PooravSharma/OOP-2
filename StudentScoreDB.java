package studentscoredb;

import java.sql.*;

public class StudentScoreDB {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bank"; // 3306 is default port
        String user = "root";
        String password = ""; // you set password when MySQL is installed

        Connection con = null; // JDBC connection
        Statement stmt = null; // SQL statement object
        String query; // SQL query string
        ResultSet result = null; // results after SQL execution

        CreateDatabase.createaStudentDB();

        try {
            con = DriverManager.getConnection(url, user, password);
            // Set auto commit as false.
            con.setAutoCommit(false);
            stmt = con.createStatement();

            query = "SELECT * FROM Savings;";
            result = stmt.executeQuery(query);
            System.out.println("Savings...");
            while (result.next()) {
                System.out.println("ID: " + result.getInt("ID") + "\t\tBalance: " + result.getDouble("Balance"));
            }

            query = "SELECT * FROM Checking;";
            result = stmt.executeQuery(query);
            System.out.println("Checking...");
            while (result.next()) {
                System.out.println("ID: " + result.getInt("ID") + "\t\tBalance: " + result.getDouble("Balance"));
            }

            System.out.println();
            System.out.println("##############################################################");
            System.out.println("Transfer $500 from Savings acc: 111111 to Checking acc: 777888");
            System.out.println("##############################################################");
            double savBal = 0;
            double chkBal = 0;
            query = "SELECT * FROM Savings WHERE ID=111111;";
            result = stmt.executeQuery(query);
            while (result.next()) {
                savBal = result.getDouble("Balance"); // get the balance of Savings acc: 111111
            }
            query = "SELECT * FROM Checking WHERE ID=777888;";
            result = stmt.executeQuery(query);
            while (result.next()) {
                chkBal = result.getDouble("Balance"); // get the balance of Checking acc: 777888
            }

            query = "UPDATE Savings SET Balance='" + (savBal - 500) + "' WHERE ID=111111;";
            stmt.executeUpdate(query); // transaction committed.

            query = "UPDATE Checking SET Balance='" + (chkBal + 500) + "' WHERE ID=777888;";
            stmt.executeUpdate(query); // transaction committed.

            // Commit data here.
            System.out.println("Commiting data here....");
            con.commit();
        } catch (Exception ex) {
            System.out.println("SQLException caught: " + ex.getMessage());
        } finally {
            // Close all database objects nicely
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

}
