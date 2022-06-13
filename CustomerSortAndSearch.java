/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package customersortandsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Poorav Sharma
 */
public class CustomerSortAndSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> collectionObject = new ArrayList<>();

        collectionObject.add(new Customer(6404, "Sam", "sam.hall@gmail.com", "042140580"));
        collectionObject.add(new Customer(9348, "Dam", "dam.brook@gmail.com", "042460554"));
        collectionObject.add(new Customer(2846, "Pam", "pam.smith@gmail.com", "042140895"));
        collectionObject.add(new Customer(9542, "Josh", "josh.black@gmail.com", "042340510"));
        collectionObject.add(new Customer(3845, "Ham", "ham.pork@gmail.com", "0421437456"));

        System.out.println("Unsorted customer information");
        for (Customer cus : collectionObject) {
            System.out.println(cus.toString());
            System.out.println();
        }
        char userInput;
        do {
            System.out.println("\nEnter 'O' to Sort Customer information");
            System.out.println("Enter 'S' to Search for customer information using their ID");
            System.out.println("Enter 'W' to Exit");
            System.out.print("=>");
            userInput = sc.next().toLowerCase().charAt(0);

            switch (userInput) {
                case 'o' -> {
                    Collections.sort(collectionObject);
                    for (Customer cus : collectionObject) {
                        System.out.println(cus.toString());
                        System.out.println();
                    }
                    System.out.print("Customer information has been sorted");
                }
                case 's' -> {
                    boolean found = false;
                    sc.nextLine();
                    int urId = -1;

                    while (urId == -1) {
                        System.out.println("Enter the ID for the custumoer you are searching for:");
                        String input = sc.nextLine();
                        try {
                            urId = Integer.valueOf(input);
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter correct Id rate\n");
                            urId = -1;
                        }
                    }
                    Collections.sort(collectionObject);
                    int index = 0;
                    for (Customer cus : collectionObject) {

                        if (cus.getId() == urId) {
                            found = true;
                            break;

                        }
                        index++;
                    }
                    if (found) {

                        System.out.println("The customer information has been found");
                        System.out.println(collectionObject.get(index).toString());
                        System.out.println();
                    } else {
                        System.out.println("Customer with that Id is not found in the list ");
                    }
                }
            }

        } while (!(userInput == 'w'));
    }
}
