package customermanagement;

import java.util.Scanner;

/**
 *
 * @author Poorav Sharma
 */
public class CustomerManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        DataBaseMethods Method = new DataBaseMethods();
        char userInput;

        boolean loop = true;
        do {
            System.out.println("Enter 'C' to Connect to a data base called smtbiz");
            System.out.println("Enter 'M' to Make a data base called smtbiz");
            userInput = sc.next().toLowerCase().charAt(0);

            switch (userInput) {

                case 'm' -> {
                    Method.createDataBase();
                    Method.Connect();
                    loop = false;
                }
                case 'c' -> {
                    Method.Connect();
                    loop = false;
                }
            }
        } while (loop == true);

        do {
            System.out.println("\nEnter 'V' to view smtbiz database");
            System.out.println("Enter 'A' to add a Customer to the database");
            System.out.println("Enter 'D' to delete a Customer from the database");
            System.out.println("Enter 's' to Search a Customer from the database");
            System.out.println("Enter 'E' to Exit");
            userInput = sc.next().toLowerCase().charAt(0);

            switch (userInput) {
                case 'v' -> {
                    Method.Showdatabase();
                }
                case 'a' -> {
                    Method.Add();
                }
                case 'd' -> {
                    Method.Delete();
                }
                case 's' -> {
                    Method.Search();
                }
            }
        } while (!(userInput == 'e'));
        Method.Close();

    }
}
