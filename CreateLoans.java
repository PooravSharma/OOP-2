package createloans;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import myloan.*;

/**
 * An application that creates an ArrayList object that contains five Loans.
 * Prompt the user for the current prime interest rate. Then, in a loop, prompt
 * the user for a loan type and all relevant information for that loan. Store
 * the created Loan objects in the array. When data entry is complete, store the
 * ArrayList object in a binary file (save this file as loans.bin) and display
 * all the loans. S
 *
 * @author Poorav Sharma
 */
public class CreateLoans {

    public static double primeRate = -1;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Loan> loans = new ArrayList<>();

    public static void main(String[] args) {

        char userInput;
        while (getPrimeRate() <= 0) {
            System.out.println("What is the prime interest rate?");
            String input = sc.nextLine();
            try {
                primeRate = Double.valueOf(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct interest rate\n");
                primeRate = -1;
            }
        }

        loans.add(new PersonalLoan(1, "Test1", 2000, getPrimeRate(), 1));

        loans.add(new BusinessLoan(2, "Test2", 10000, getPrimeRate(), 3));

        loans.add(new PersonalLoan(3, "Test3", 7500, getPrimeRate(), 1));

        loans.add(new BusinessLoan(4, "Test4", 140000.20, getPrimeRate(), 5));

        do {
            System.out.println("\nEnter 'A' to take a loan out");
            System.out.println("Enter 'D' to display your loan information");
            System.out.println("Enter 'S' to Save the loans");
            System.out.println("Enter 'L' to Load a car List");
            System.out.println("Enter 'W' to Exit");
            System.out.print("=>");
            userInput = sc.next().toLowerCase().charAt(0);

            switch (userInput) {
                case 'a' -> {
                    getLoan();
                }
                case 'd' -> {
                    displayLoans();
                }
                case 's' -> {
                    saveLoans();
                }
                case 'l' -> {
                    loadLoans();
                }
            }
        } while (!(userInput == 'w'));

    }

    /**
     *
     * A method that utilizes while loop, try and catch statements to get the
     * information from the user. After receiving all the information it creates
     * the load
     */
    public static void getLoan() {
        Loan loan = new Loan();
        Random rn = new Random();
        sc.nextLine();
        boolean looping = true;
        int loanType = -1;

        System.out.println("What is your last name?");
        String urLastName = sc.nextLine();

        System.out.println();

        while (looping == true) {
            System.out.println("Enter '1' if you are taking a personal Loan \nEnter '2' if you are taking a business loan");
            String input = sc.nextLine();
            try {
                loanType = Integer.valueOf(input);
                if (loanType == 1 || loanType == 2) {

                    looping = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct integer input\n");
                looping = true;
            }
        }
        System.out.println();

        looping = true;
        double loanAmount = -1;
        while (looping == true) {
            System.out.println("how much do you want to borrow?");
            String input = sc.nextLine();
            try {
                loanAmount = Double.valueOf(input);
                if (0 < loanAmount && loanAmount < loan.getMaxLoan()) {

                    looping = false;
                } else if (loanAmount > loan.getMaxLoan()) {
                    System.out.println("You cannot take out a loan more than " + loan.getMaxLoan() + "\n");
                } else if (loanAmount <= 0) {
                    System.out.println("Loan cannot be zero or lower\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct integer input\n");
                looping = true;
            }
        }
        System.out.println();
        looping = true;
        int loanTerm = -1;
        while (looping == true) {
            System.out.println("We have three terms you can choose from.");
            System.out.println("Enter '1' for a short term (1 year)");
            System.out.println("Enter '2' for a medium term (3 year)");
            System.out.println("Enter '3' for a long term (5 year)");

            String input = sc.nextLine();
            try {
                loanTerm = Integer.valueOf(input);
                switch (loanTerm) {
                    case 1 -> {
                        loanTerm = loan.getShortTerm();
                        looping = false;
                    }
                    case 2 -> {
                        loanTerm = loan.getMediumTerm();
                        looping = false;

                    }
                    case 3 -> {
                        loanTerm = loan.getLongTerm();
                        looping = false;
                    }
                    default ->
                        loanTerm = loan.getShortTerm();
                    //System.out.println("Please enter the the correct number\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct integer input\n");
                looping = true;
            }
        }
        System.out.println();
        int loanNumber = rn.nextInt(999999);

        if (loanType == 1) {
            loans.add(new PersonalLoan(loanNumber, urLastName, loanAmount, getPrimeRate(), loanTerm));
        } else {
            loans.add(new BusinessLoan(loanNumber, urLastName, loanAmount, getPrimeRate(), loanTerm));
        }
        System.out.println("The loan has has created for you");

    }

    /**
     *
     * This method is used to displays all the loans created. It displays the
     * loan number, customer last name, amount of loan, interest rate, term and
     * amount owed. it uses for loop and toString to display the information.
     */
    public static void displayLoans() {

        for (Loan loan : loans) {

            System.out.println(loan.toString());
            System.out.println();
        }
        if (loans.isEmpty()) {
            System.out.println("No loan was taken out");
        }
    }

    /**
     *
     * This method is used to save the loan array list into a binary file.
     *
     */
    public static void saveLoans() {
        try {
            FileOutputStream fileOut = new FileOutputStream("loanList.bin");
            ObjectOutputStream streamOut = new ObjectOutputStream(fileOut);
            for (int x = 0; x < loans.size(); x++) {
                streamOut.writeObject(loans.get(x));
                System.out.println("Saving...");
            }
            System.out.println("Completed!! Saved file in result.bin");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     *
     * This method is used to load the loan array list from a binary file into
     * the application.
     *
     */
    public static void loadLoans() {
        loans.clear();
        try {
            try ( FileInputStream fileIn = new FileInputStream("loanList.bin");  ObjectInputStream streamIn = new ObjectInputStream(fileIn)) {
                while (streamIn.available() != -1) {
                    Loan loan = (Loan) streamIn.readObject();
                    loans.add(loan);
                    System.out.println("Loading...");
                }
                System.out.print("Successfully loaded loans");
            }

        } catch (IOException err) {
            System.out.println("Loading...");
        } catch (ClassNotFoundException err) {
            System.err.println("Cannot find class");
        }
    }

    /**
     * @return the primeRate
     */
    public static double getPrimeRate() {
        return primeRate;
    }

}
