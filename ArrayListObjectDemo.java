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

        carList.add(new Car("hi", "lol", "ha", 3223));

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
                    Collections.sort(carList);
                }
                case 's' -> {
                    Save();
                }
                case 'l' -> {
                    Load();
                }
                case 'e' -> {
                    Search();
                }
            }
        } while (!(userInput == 'e'));

    }

    static public void DisplayList() {

        for (Car c : carList) {
            System.out.println(c.getMake() + " " + c.getModel() + "\tYear: " + c.getYear());
            System.out.println("Total Km travelled: " + c.getOdometer());
            System.out.println();
        }
    }

    static public void addCar() {
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
        System.out.println("What is the total ODO meter of the car?");
        int urOdoMeter = sc.nextInt();
        System.out.println();
        carList.add(new Car(urMake, urModel, urYear, urOdoMeter));
    }

    static public void Save() {
        try {
            FileOutputStream fileOut = new FileOutputStream("carLIst.bin");
            ObjectOutputStream carOut = new ObjectOutputStream(fileOut);
            carOut.writeObject(carList);
            System.out.println("Completed!! Saved file in result.bin");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static public void Load() {

        try {
            FileInputStream fileIn = new FileInputStream("carList.bin");
            ObjectInputStream carIn = new ObjectInputStream(fileIn);
            Vehicle.Car c = (Car) carIn.readObject();
            while (c != null) {
                carList.add(c);
            }
            fileIn.close();
            System.out.print("Successfully loaded carList");
        } catch (IOException err) {
            System.err.println(err);
        } catch (ClassNotFoundException err) {
            System.err.println(err);
        }
    }

    static public void Search() {
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
}
