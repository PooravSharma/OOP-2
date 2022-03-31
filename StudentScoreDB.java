package studentscoredb;

import java.util.Scanner;

public class StudentScoreDB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DatabaseMethods Method = new DatabaseMethods();
        char userInput;

        CreateDatabase.createaStudentDB();
        Method.Connect();
        do {
            System.out.println("\nEnter 'W' to view Student score database");
            System.out.println("Enter 'A' to add a score from student database");
            System.out.println("Enter 'S' to delete a score from student database");
            System.out.println("Enter 'D' to edit a score from student database");
            System.out.println("Enter 'E' to Exit");
            userInput = sc.next().toLowerCase().charAt(0);

            switch (userInput) {
                case 'w' -> {
                    Method.Showdatabase();
                }
                case 'a' -> {
                    Method.Add();
                }
                case 's' -> {
                    Method.Delete();
                }
                case 'd' -> {
                    Method.Update();
                }
            }
        } while (!(userInput == 'e'));
        Method.Close();

    }
}
