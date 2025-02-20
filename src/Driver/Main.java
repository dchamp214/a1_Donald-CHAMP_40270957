package Driver;


import Data.*;
import Client.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Welcome to the RoyalRentals management software!");

        Vehicle[] vehicles = new Vehicle[100];
        int vehicleCount = 0;


        do{
            System.out.print("\nWhat type of operation do you wish to perform?\n");
            System.out.print("\t1. Vehicle Management\n");
            System.out.print("\t2. Client.Client Management\n");
            System.out.print("\t3. Leasing Operations\n");
            System.out.print("\t4. Additional Operations\n -->");

            int operationChoice = input.nextInt();

            switch (operationChoice){
                case 1:
                    System.out.print("Which Vehicle Management operation do you wish to use\n");
                    System.out.print("\t1. Add a vehicle\n");
                    System.out.print("\t2. Delete a vehicle\n");
                    System.out.print("\t3. Update a vehicles information\n");
                    System.out.print("\t4. List all vehicles by category\n -->");

                    int vehicleOperationChoice = input.nextInt();

                    switch (vehicleOperationChoice){
                        case 1:
                            System.out.print("Which type of vehicle would you like to add?\n");
                            System.out.print("\t1. Electric Truck\n");
                            System.out.print("\t2. Diesel Truck\n");
                            System.out.print("\t3. Electric Car\n");
                            System.out.print("\t4. Gasoline Car\n -->");

                            int vehicleTypeChoice = input.nextInt();
                            input.nextLine();  // Consume newline

                            if(vehicleTypeChoice != 1 && vehicleTypeChoice != 2 && vehicleTypeChoice != 3 && vehicleTypeChoice != 4){
                                System.out.print("Invalid Input!");
                                break;
                            }

                            System.out.print("Enter Make: ");
                            String make = input.nextLine();

                            System.out.print("Enter Model: ");
                            String model = input.nextLine();

                            System.out.print("Enter Year of Production: ");
                            int yearOfProduction = input.nextInt();

                            Vehicle newVehicle = new Vehicle();

                            switch(vehicleTypeChoice) {
                                case 1: // Electric Truck
                                    System.out.print("Enter Maximum Capacity (kg): ");
                                    int maxCapacityET = input.nextInt();
                                    System.out.print("Enter Maximum Autonomy Range (km): ");
                                    int maxRangeET = input.nextInt();
                                    newVehicle = new ElectricTruck(make, model, yearOfProduction,maxCapacityET, maxRangeET);
                                    break;
                                case 2: // Diesel Truck
                                    System.out.print("Enter Maximum Capacity (kg): ");
                                    int maxCapacityDT = input.nextInt();
                                    System.out.print("Enter Fuel Tank Capacity (liters): ");
                                    int fuelTankCapacityDT = input.nextInt();
                                    newVehicle = new DieselTruck(make, model, yearOfProduction, maxCapacityDT, fuelTankCapacityDT);
                                    break;
                                case 3: // Electric Car
                                    System.out.print("Enter Maximum Number of Passengers: ");
                                    int maxPassengersEC = input.nextInt();
                                    System.out.print("Enter Maximum Autonomy Range (km): ");
                                    int maxRangeEC = input.nextInt();
                                    newVehicle = new ElectricCar(make, model, yearOfProduction, maxPassengersEC, maxRangeEC);
                                    break;
                                case 4: // Gasoline Car
                                    System.out.print("Enter Maximum Number of Passengers: ");
                                    int maxPassengersGC = input.nextInt();
                                    newVehicle = new GasolineCar(make, model, yearOfProduction, maxPassengersGC);
                                    break;
                            }
                            vehicles[vehicleCount++] = newVehicle;
                            break;
                        case 2:
                            System.out.print("\nHere are all you vehicles:\n");

                            for(int i = 0; i < vehicleCount; i++){
                                System.out.print("Vehicle " + (i+1) + vehicles[i] + "\n");
                            }

                            System.out.print("\nWhich vehicle would you like to remove -->");
                            int removedVehicle = input.nextInt();

                            if(removedVehicle < 0 || removedVehicle > vehicleCount){
                                System.out.print("\nInvalid input!");
                                break;
                            }

                            Vehicle[] heldVehicles = new Vehicle[vehicleCount];
                            System.arraycopy(vehicles, 0, heldVehicles, 0, vehicleCount);

                            for (int i = 0; i < vehicleCount; i++) {
                                if (i == (removedVehicle - 1)) {
                                    for (int j = i; j < vehicleCount - 1; j++) {
                                        vehicles[j] = heldVehicles[j + 1];
                                    }
                                }
                            }

                            vehicles[vehicleCount - 1] = null;
                            vehicleCount--;
                            break;
                        case 3:
                            System.out.print("\nHere are all you vehicles:\n");

                            for(int i = 0; i < vehicleCount; i++){
                                System.out.print("Vehicle " + (i+1) + vehicles[i] + "\n");
                            }

                            System.out.print("\nWhich vehicle would you like to edit -->");
                            int changedVehicle = input.nextInt();

                            if(changedVehicle <= 0 || changedVehicle > vehicleCount){
                                System.out.print("\nInvalid input!");
                                break;
                            }

                            changedVehicle--;

                            System.out.print("\nWhich attribute would you like to edit?\n");
                            System.out.print("\t1. Make\n");
                            System.out.print("\t2. Model\n");
                            System.out.print("\t3. Year of Production\n");
                            int changedAttribute = vehicles[changedVehicle].editInformation(input);

                            if(changedAttribute == 1){
                                System.out.print("\nEnter your new make: ");
                                vehicles[changedVehicle].setMake(input.next());
                                input.nextLine();
                            } else if (changedAttribute == 2){
                                System.out.print("\nEnter your new model: ");
                                vehicles[changedVehicle].setModel(input.next());
                                input.nextLine();
                            } else if (changedAttribute == 3) {
                                System.out.print("\nEnter your new year of production: ");
                                vehicles[changedVehicle].setYearOfProduction(input.nextInt());
                            }
                            System.out.print("\nAttribute updates successfully!");
                            break;
                        case 4:
                            System.out.print("All Diesel Trucks:");
                            for(int i = 0; i < vehicleCount; i++){
                                if(vehicles[i] instanceof DieselTruck){
                                    System.out.print(vehicles[i] + "\n");
                                }
                            }

                            System.out.print("\nAll Electric Trucks:");
                            for(int i = 0; i < vehicleCount; i++){
                                if(vehicles[i] instanceof ElectricTruck){
                                    System.out.print(vehicles[i] + "\n");
                                }
                            }

                            System.out.print("\nAll Gasoline Cars:");
                            for(int i = 0; i < vehicleCount; i++){
                                if(vehicles[i] instanceof GasolineCar){
                                    System.out.print(vehicles[i] + "\n");
                                }
                            }

                            System.out.print("\nAll Electric Cars:");
                            for(int i = 0; i < vehicleCount; i++){
                                if(vehicles[i] instanceof ElectricCar){
                                    System.out.print(vehicles[i] + "\n");
                                }
                            }
                            break;
                        default:
                            System.out.print("\nYou have made an invalid choice. Please try again");
                            break;
                    }
                    break;
                case 2:

                    System.out.print("Which Client.Client Management operation do you wish to use\n");
                    System.out.print("\t1. Add a client\n");
                    System.out.print("\t2. Edit a client\n");
                    System.out.print("\t3. Delete a client\n -->");

                    int clientOperationChoice = input.nextInt();

                    switch(clientOperationChoice){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            System.out.print("\nYou have made an invalid choice. Please try again");
                            break;
                    }
                    break;
                case 3:
                    System.out.print("Which Leasing Operation do you wish to use\n");
                    System.out.print("\t1. Lease a vehicle to a client\n");
                    System.out.print("\t2. Return a vehicle from a client\n");
                    System.out.print("\t3. Show all vehicles leased by a client\n");
                    System.out.print("\t4. Show all leased vehicles (by all clients)\n -->");

                    int leasingOperationChoice = input.nextInt();

                    switch(leasingOperationChoice){
                        case 1:
                            // Logic for leasing a vehicle to a client
                            break;
                        case 2:
                            // Logic for returning a vehicle from a client
                            break;
                        case 3:
                            // Logic for showing all vehicles leased by a client
                            break;
                        case 4:
                            // Logic for showing all leased vehicles (by all clients)
                            break;
                        default:
                            System.out.print("\nYou have made an invalid choice. Please try again");
                            break;
                    }

                    break;
                case 4:
                    System.out.print("Which Additional Operation do you wish to use\n");
                    System.out.print("\t1. Display the truck with the largest capacity\n");
                    System.out.print("\t2. Create a copy of the electric trucks array\n -->");

                    int additionalOperationChoice = input.nextInt();

                    switch(additionalOperationChoice){
                        case 1:
                            // Logic for displaying the truck with the largest capacity
                            break;
                        case 2:
                            // Logic for creating a copy of the electric trucks array
                            break;
                        default:
                            System.out.print("\nYou have made an invalid choice. Please try again");
                            break;
                    }

                    break;
                default:
                    System.out.print("\nYou have made an invalid choice. Please try again");
                    break;
            }

        }
        while(true);

    }
}