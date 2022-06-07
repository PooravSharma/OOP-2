/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraylistobjectdemo;

import Vehicle.Car;
import java.util.*;
import java.io.*;

/**
 *
 * @author 30045900
 */
public class ArrayListObjectDemo {

    static ArrayList<Car> carList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char userInput;

        carList.add(new Car("high", "toyota", "2010", 3223));
        carList.add(new Car("low", "Audi", "2007", 435435));
        carList.add(new Car("fast", "Cadillac", "2008", 24334));
        carList.add(new Car("transport", "Tesla", "2012", 2131));
        carList.add(new Car("apple", "Chevrolet", "1999", 876587));

        do {
            System.out.println("\nEnter 'V' to view Car List");
            System.out.println("Enter 'A' to Add a Car into the Car List");
            System.out.println("Enter 'O' to Sort the car list");
            System.out.println("Enter 'S' to Save the car list");
            System.out.println("Enter 'L' to Load a car List");
            System.out.println("Enter 'E' to Search a car by by its make");
            System.out.println("Enter 'W' to Exit");
            System.out.print("=>");
            userInput = sc.next().toLowerCase().charAt(0);

            switch (userInput) {
                case 'v' -> {
                    DisplayList();
                }
                case 'a' -> {
                    addCar();
                }
                case 'o' -> {
                    Sort(carList);
                }
                case 's' -> {
                    SaveFile();
                }
                case 'l' -> {
                    LoadFile();
                }
                case 'e' -> {
                    Search();
                }
            }
        } while (!(userInput == 'w'));

    }

    /**
     * Displays the Car List
     */
    public static void DisplayList() {

        for (Car c : carList) {
            System.out.println(c.getMake() + " " + c.getModel() + "\tYear: " + c.getYear());
            System.out.println("Total Km travelled: " + c.getOdometer());
            System.out.println();
        }
    }

    /**
     * Adds more Cars into the List
     */
    public static void addCar() {
        sc.nextLine();

        System.out.println("What is the make of the car?");
        String urMake = sc.nextLine();

        System.out.println();

        System.out.println("What is the model of the car?");
        String urModel = sc.nextLine();

        System.out.println();

        System.out.println("What is the year of the car?");
        String urYear = sc.nextLine();

        System.out.println();

        int urODOMeter = -1;
        while (urODOMeter < 0) {
            System.out.println("What is the total ODO meter of the car?");
            String input = sc.nextLine();
            try {
                urODOMeter = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct integer input");
                urODOMeter = -1;
            }
        }

        System.out.println();
        carList.add(new Car(urMake, urModel, urYear, urODOMeter));
    }

    /**
     * Save the list into a binary file
     */
    public static void SaveFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("carList.bin");
            ObjectOutputStream carOut = new ObjectOutputStream(fileOut);
            for (int x = 0; x < carList.size(); x++) {
                carOut.writeObject(carList.get(x));
                System.out.println("Saving...");
            }
            System.out.println("Completed!! Saved file in result.bin");
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    /**
     * Loads the list into a binary file
     */
    public static void LoadFile() {
        carList.clear();
        try {
            try (FileInputStream fileIn = new FileInputStream("carList.bin"); ObjectInputStream carIn = new ObjectInputStream(fileIn)) {
                while (carIn.available() != -1) {
                    Car car = (Car) carIn.readObject();
                    carList.add(car);
                    System.out.println("Loading...");
                }
                System.out.print("Successfully loaded carList");
            }

        } catch (IOException err) {
            System.out.println("Loading...");
        } catch (ClassNotFoundException err) {
            System.err.println("Cannot find class");
        }

    }

    /**
     * Searches for the make of the car
     */
    public static void Search() {
        boolean found = false;
        sc.nextLine();
        System.out.println("What make are you searching for?");
        String srMake = sc.nextLine();
        Collections.sort(carList);
        for (Car car : carList) {
            if (car.getMake().equals(srMake)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Car with that make is found in the carList");
        } else {
            System.out.println("Car with that make is not found in the carList ");
        }
    }

    /**
     * Sorts the list by the car's make alphabetical order
     */
    public static void Sort(ArrayList<Car> list) {
        Collections.sort(list);
        System.out.println("Car list has been sorted");
    }

}