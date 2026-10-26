package com.pluralsight;

import java.sql.SQLOutput;
import java.util.Scanner;

public class VehicleInventoryApp {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Vehicle[] myVehicles = new Vehicle[20];

        myVehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        myVehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        myVehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        myVehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        myVehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        myVehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        int command = 0;
        do {
            System.out.println("What do you want to do?");
            System.out.println(" 1 - List all vehicles");
            System.out.println(" 2 - Search by make/model");
            System.out.println(" 3 - Search by price range");
            System.out.println(" 4 - Search by color");
            System.out.println(" 5 - Add a vehicle");
            System.out.println(" 6 - Quit");
            System.out.println("Enter your command: ");

            command = Integer.parseInt(myScanner.nextLine());

            switch (command) {
                case 1 -> {
                    listAllVehicles(myVehicles);
                    break;
                }
                case 2 -> {
                    findVehiclesByMakeModel(myVehicles);
                    break;
                }
                case 3 -> {
                    findVehiclesByPrice(myVehicles);
                    break;
                }
                case 4 -> {
                    findVehicleByColor(myVehicles);
                    break;
                }
                case 5 -> {
                    addVehicle(myVehicles, myScanner);
                    break;
                }
                case 6 -> {
                    System.out.println("GoodBye");
                    System.exit(0);
                }
            }

        } while (command != 6);


    }

    public static void listAllVehicles(Vehicle[] vehicles) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) { //only sout if the array has a car
                System.out.println(
                        "_______________________________ \n" +
                                "Vehicle ID: " + vehicle.getVehicleId() + "\n" +
                                "Model: " + vehicle.getMakeModel() + "\n" +
                                "Color: " + vehicle.getColor() + "\n" +
                                "Odometer: " + vehicle.getOdometerReading() + "\n" +
                                "Price: $" + vehicle.getPrice() + "\n"
                        + "_______________________________ "
                );

            }
        }
    }

    public static void findVehiclesByMakeModel(Vehicle[] vehicles) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                System.out.println(vehicle.getMakeModel());
            }
        }
    }

    public static void findVehiclesByPrice(Vehicle[] vehicles) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                System.out.println(vehicle.getPrice());
            }
        }
    }

    public static void findVehicleByColor(Vehicle[] vehicles) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                System.out.println(vehicle.getColor());
            }
        }
    }

    public static void addVehicle(Vehicle[] vehicles, Scanner methodScanner) {
        //update list
        String userInput;

        //Input
        System.out.print("What is the vehicleId?: ");
        userInput = methodScanner.nextLine();
        long vehicleId = Long.parseLong(userInput);

        System.out.print("What is the make model of the car?: ");
        userInput = methodScanner.nextLine();
        String vehicleModel = userInput;

        System.out.print("What is the color of the car?: ");
        userInput = methodScanner.nextLine();
        String vehicleColor = userInput;

        System.out.print("What is the odometer reading of the car?: ");
        userInput = methodScanner.nextLine();
        int vehicleOdometer = Integer.parseInt(userInput);

        System.out.print("Name your price brother/sister: ");
        userInput = methodScanner.nextLine();
        double vehiclePrice = Double.parseDouble(userInput);


        //loop through the list
        //if no car in list, append the vehicle, and sys exit
        int place = 0;
        for (int i = 0; vehicles.length > i; i++) {
            if (vehicles[i] == null) {
                place = i;
                vehicles[i] = new Vehicle(vehicleId, vehicleModel, vehicleColor, vehicleOdometer, vehiclePrice);
                break;
            }
        }
        System.out.println("Added: " + vehicles[place].getVehicleInfo());
    }
}
