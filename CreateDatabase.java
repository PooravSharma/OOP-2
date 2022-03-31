package studentscoredb;

import java.sql.*;

/**
 *
 * @author 30045900
 */
public class CreateDatabase {

    public static void createaStudentDB() {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        Connection con = null;
        Statement stmt = null;
        String query;
        ResultSet result = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();

            System.out.println("\n##############################");
            System.out.println(" Database is being created...");
            System.out.println("##############################\n");
            query = "DROP DATABASE IF EXISTS student_management;";
            stmt.executeUpdate(query);
            query = "CREATE DATABASE student_management;";
            stmt.executeUpdate(query);
            query = "USE student_management;";
            stmt.executeUpdate(query);
            query = """
                    CREATE TABLE student_score
                    (
                    Subject VARCHAR (50) NOT NULL,
                    Score INT NOT NULL
                    );
                    """;
            stmt.executeUpdate(query);
            query = """
                    INSERT INTO student_score
                        	(Subject, Score)
                        VALUES
                        	("English", 95),
                        	("Math", 100),
                        	("Science", 89);
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
}
