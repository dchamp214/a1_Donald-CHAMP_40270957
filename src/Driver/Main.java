package Driver;


import Data.*;
import Client.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize Scanner for inputs
        Scanner input = new Scanner(System.in);

        //Welcome Message
        System.out.print("Welcome to Donald Champ's (40270957)  RoyalRentals management software!");


        // Initialize Vehicle and Client object arrays
        Vehicle[] vehicles = new Vehicle[100];
        Client[] clients = new Client[100];

        // Set current vehicle and client counts to 0
        int vehicleCount = 0;
        int clientCount = 0;


        // Enter menu loop
        do{
            //Display menu to user
            System.out.print("\nWhat type of operation do you wish to perform?\n");
            System.out.print("\t1. Vehicle Management\n");
            System.out.print("\t2. Client Management\n");
            System.out.print("\t3. Leasing Operations\n");
            System.out.print("\t4. Additional Operations\n -->");

            // Take user menu option using scanner
            int operationChoice = input.nextInt();

            // Switch to differentiate menu options
            switch (operationChoice){
                // Vehicle Management case
                case 1:
                    // Display secondary vehicle management menu
                    System.out.print("Which Vehicle Management operation do you wish to use\n");
                    System.out.print("\t1. Add a vehicle\n");
                    System.out.print("\t2. Delete a vehicle\n");
                    System.out.print("\t3. Update a vehicles information\n");
                    System.out.print("\t4. List all vehicles by category\n -->");

                    // Take user choice for vehicle management operation
                    int vehicleOperationChoice = input.nextInt();

                    // Switch for vehicle management operations
                    switch (vehicleOperationChoice){
                        // Case for add a vehicle
                        case 1:
                            // Prompt user for vehicle type
                            System.out.print("Which type of vehicle would you like to add?\n");
                            System.out.print("\t1. Electric Truck\n");
                            System.out.print("\t2. Diesel Truck\n");
                            System.out.print("\t3. Electric Car\n");
                            System.out.print("\t4. Gasoline Car\n -->");

                            // Take user input for vehicle type
                            int vehicleTypeChoice = input.nextInt();

                            // Instantly breaks switch if input is invalid
                            if(vehicleTypeChoice != 1 && vehicleTypeChoice != 2 && vehicleTypeChoice != 3 && vehicleTypeChoice != 4){
                                System.out.print("Invalid Input!");
                                break;
                            }

                            // Prompt user for new vehicle's make
                            System.out.print("Enter Make: ");
                            String make = input.nextLine();

                            // Prompt user for new vehicle's model
                            System.out.print("Enter Model: ");
                            String model = input.nextLine();

                            // Prompt user for new vehicles year of production
                            System.out.print("Enter Year of Production: ");
                            int yearOfProduction = input.nextInt();

                            // Create a new vehicle object for the added vehicle
                            Vehicle newVehicle = new Vehicle();

                            // Switch used to differentiate vehicle child classes each has unique attributes
                            switch(vehicleTypeChoice) {
                                // Electric Truck
                                case 1:
                                    System.out.print("Enter Maximum Capacity (kg): ");
                                    int maxCapacityET = input.nextInt();
                                    System.out.print("Enter Maximum Autonomy Range (km): ");
                                    int maxRangeET = input.nextInt();

                                    // Assign newVehicle attributes for a electric truck
                                    newVehicle = new ElectricTruck(make, model, yearOfProduction,maxCapacityET, maxRangeET);

                                    break;
                                // Diesel Truck
                                case 2:
                                    System.out.print("Enter Maximum Capacity (kg): ");
                                    int maxCapacityDT = input.nextInt();
                                    System.out.print("Enter Fuel Tank Capacity (liters): ");
                                    int fuelTankCapacityDT = input.nextInt();

                                    // Assign newVehicle attributes for a diesel truck
                                    newVehicle = new DieselTruck(make, model, yearOfProduction, maxCapacityDT, fuelTankCapacityDT);

                                    break;
                                // Electric Car
                                case 3:
                                    System.out.print("Enter Maximum Number of Passengers: ");
                                    int maxPassengersEC = input.nextInt();
                                    System.out.print("Enter Maximum Autonomy Range (km): ");
                                    int maxRangeEC = input.nextInt();

                                    // Assign newVehicle attributes for a electric car
                                    newVehicle = new ElectricCar(make, model, yearOfProduction, maxPassengersEC, maxRangeEC);

                                    break;
                                // Gasoline Car
                                case 4:
                                    System.out.print("Enter Maximum Number of Passengers: ");
                                    int maxPassengersGC = input.nextInt();

                                    // Assign newVehicle attributes for a gasoline car
                                    newVehicle = new GasolineCar(make, model, yearOfProduction, maxPassengersGC);

                                    break;
                            }
                            // Add the newVehicle to the vehicles array and increment the count
                            vehicles[vehicleCount++] = newVehicle;
                            break;
                        // Case for removing a vehicle
                        case 2:
                            // Display all vehicles and their attributes using for loop
                            System.out.print("\nHere are all you vehicles:\n");

                            for(int i = 0; i < vehicleCount; i++){
                                System.out.print("Vehicle " + (i+1) + vehicles[i] + "\n");
                            }

                            // Prompt user for index+1 of vehicle to be removed
                            System.out.print("\nWhich vehicle would you like to remove -->");
                            int removedVehicle = input.nextInt();

                            // Instantly break switch if the user's input does not correspond to a vehicle
                            if(removedVehicle <= 0 || removedVehicle > vehicleCount){
                                System.out.print("\nInvalid input!");
                                break;
                            }

                            // Create new array and copy to hold current vehicles
                            Vehicle[] heldVehicles = new Vehicle[vehicleCount];
                            System.arraycopy(vehicles, 0, heldVehicles, 0, vehicleCount);

                            // Nested for loop used to first find selected vehicle to be removed
                            for (int i = 0; i < vehicleCount; i++) {
                                // If index matches removedVehicle
                                if (i == (removedVehicle - 1)) {
                                    // Shift all remaining vehicles to the left, removing the selected vehicle
                                    for (int j = i; j < vehicleCount - 1; j++) {
                                        vehicles[j] = heldVehicles[j + 1];
                                    }
                                }
                            }
                            // Set end vehicle to null as it is one to the left now in the index
                            vehicles[vehicleCount - 1] = null;

                            // Decrement the count
                            vehicleCount--;
                            break;
                        // Case for editing a vehicles attributes
                        case 3:
                            // Display all existing vehicles using for loop
                            System.out.print("\nHere are all you vehicles:\n");

                            for(int i = 0; i < vehicleCount; i++){
                                System.out.print("Vehicle " + (i+1) + vehicles[i] + "\n");
                            }

                            // Prompt user for vehicle they wish to edit
                            System.out.print("\nWhich vehicle would you like to edit -->");
                            int changedVehicle = input.nextInt();

                            // If vehicle does not exist switch is broken
                            if(changedVehicle <= 0 || changedVehicle > vehicleCount){
                                System.out.print("\nInvalid input!");
                                break;
                            }

                            // Decrement down to align with accurate index
                            changedVehicle--;

                            // Prompt user for  which attribute they wish to edit
                            System.out.print("\nWhich attribute would you like to edit?\n");
                            System.out.print("\t1. Make\n");
                            System.out.print("\t2. Model\n");
                            System.out.print("\t3. Year of Production\n");
                            // editInformation method is overridden for each child displaying proper attributes
                            int changedAttribute = vehicles[changedVehicle].editInformation(input);

                            // If selected attribute is an inherited attribute then enters
                            // corresponding if statement using mutator methods to edit
                            if(changedAttribute == 1){
                                // Prompt user for new make
                                System.out.print("\nEnter your new make: ");
                                vehicles[changedVehicle].setMake(input.next());
                                input.nextLine();
                            } else if (changedAttribute == 2){
                                // Prompt user for new model
                                System.out.print("\nEnter your new model: ");
                                vehicles[changedVehicle].setModel(input.next());
                                input.nextLine();
                            } else if (changedAttribute == 3) {
                                // Prompt user for new year of production
                                System.out.print("\nEnter your new year of production: ");
                                vehicles[changedVehicle].setYearOfProduction(input.nextInt());
                            }
                            System.out.print("\nAttribute updates successfully!");
                            break;
                        // Case for viewing all vehicles of each type
                        case 4:
                            // For loops checks each vehicle object if it is an instance of a Diesel Truck
                            // if so it displays all information using toString
                            System.out.print("All Diesel Trucks:");
                            for(int i = 0; i < vehicleCount; i++){
                                if(vehicles[i] instanceof DieselTruck){
                                    System.out.print(vehicles[i] + "\n");
                                }
                            }

                            // Checks electric truck instantiation
                            System.out.print("\nAll Electric Trucks:");
                            for(int i = 0; i < vehicleCount; i++){
                                if(vehicles[i] instanceof ElectricTruck){
                                    System.out.print(vehicles[i] + "\n");
                                }
                            }

                            // Checks electric gasoline car instantiation
                            System.out.print("\nAll Gasoline Cars:");
                            for(int i = 0; i < vehicleCount; i++){
                                if(vehicles[i] instanceof GasolineCar){
                                    System.out.print(vehicles[i] + "\n");
                                }
                            }

                            // Checks electric car instantiation
                            System.out.print("\nAll Electric Cars:");
                            for(int i = 0; i < vehicleCount; i++){
                                if(vehicles[i] instanceof ElectricCar){
                                    System.out.print(vehicles[i] + "\n");
                                }
                            }
                            break;
                        // Default used to inform user of invalid input
                        default:
                            System.out.print("\nYou have made an invalid choice. Please try again");
                            break;
                    }
                    break;
                // Case for client management operations
                case 2:
                    // Display client management operations
                    System.out.print("Which Client Management operation do you wish to use\n");
                    System.out.print("\t1. Add a client\n");
                    System.out.print("\t2. Edit a client\n");
                    System.out.print("\t3. Delete a client\n -->");

                    // Take user input for operation choice
                    int clientOperationChoice = input.nextInt();

                    switch(clientOperationChoice){
                        // Case for adding a client
                        case 1:
                            // Prompts user for name of client
                            System.out.print("Enter the name of new client: ");
                            // Creates new client in the array
                            clients[clientCount] = new Client(input.next());
                            input.nextLine();
                            // Displays new clients ID and informs of successful process
                            System.out.print("Client successfully created!\nNew Clients ID: " +
                                    clients[clientCount].getClientID());
                            // Increments count
                            clientCount++;
                            break;
                        // Case for editing client
                        case 2:
                            // Displays all clients to user
                            System.out.print("Please see all clients below\n");
                            for(int i = 0; i < clientCount; i++){
                                System.out.print("Client #" + (i + 1) + "\n" + clients[i] + "\n\n");
                            }

                            // Prompts user for client they wish to edit
                            System.out.print("Please enter the client number of the client you wish to edit\n");
                            System.out.print("-->");
                            int editedClient = input.nextInt() - 1;

                            // Prompts user for clients new name
                            System.out.print("Enter client ID " + clients[editedClient].getClientID() +
                                    " new client name\n");
                            System.out.print("-->");

                            // Takes input and updates using mutator method
                            clients[editedClient].setClientName(input.next());
                            input.nextLine();
                            System.out.print("Name Successfully Updated!\n");
                            break;
                        // Case for removing a client
                        case 3:
                            // Display all clients to user
                            System.out.print("Please see all clients below\n");
                            for(int i = 0; i < clientCount; i++){
                                System.out.print("Client #" + (i + 1) + "\n" + clients[i] + "\n\n");
                            }

                            // Prompt user for the client they wish to remove
                            System.out.print("Please enter the client number of the client you wish to remove\n");
                            System.out.print("-->");
                            int removedClient = input.nextInt() - 1;

                            // If there are vehicles leased to this client, they are set to not leased
                            for(int i = 0; i < vehicleCount; i++){
                                if(vehicles[i].isLeased()){
                                    for(int j = 0; j < clients[removedClient].getClientVehicleCount(); j++){
                                        if(vehicles[i].getPlateNumber().equals(clients[removedClient].getClientVehicles(j))){
                                            vehicles[i].setLeased(false);
                                        }
                                    }
                                }
                            }
                            // Sets removed clients index to null
                            clients[removedClient] = null;
                            // Shifts all remaining clients one index to the left
                            for(int i = removedClient; i < clientCount - 1; i++){
                                clients[i] = new Client(clients[i + 1]);
                            }

                            // Set last client added to null as it is one to the left
                            clients[clientCount - 1] = null;

                            // Decrement count
                            clientCount--;
                            System.out.print("\nClient Successfully Removed!");
                            break;
                        // Default for invalid inputs
                        default:
                            System.out.print("\nYou have made an invalid choice. Please try again");
                            break;
                    }
                    break;
                // Case for leasing operations
                case 3:
                    // Display leasing menu to user
                    System.out.print("Which Leasing Operation do you wish to use\n");
                    System.out.print("\t1. Lease a vehicle to a client\n");
                    System.out.print("\t2. Return a vehicle from a client\n");
                    System.out.print("\t3. Show all vehicles leased by a client\n");
                    System.out.print("\t4. Show all leased vehicles (by all clients)\n -->");

                    // Take user menu operation choice
                    int leasingOperationChoice = input.nextInt();


                    switch(leasingOperationChoice){
                        case 1:
                            System.out.print("\nHere are all your unleased vehicles:\n");

                            for(int i = 0; i < vehicleCount; i++){
                                if(vehicles[i].isLeased() == false){
                                    System.out.print("Vehicle " + (i+1) + vehicles[i] + "\n");
                                }
                            }

                            System.out.print("Which vehicle do you want to lease?\n-->");
                            int leasedVehicle = input.nextInt() - 1;

                            if(leasedVehicle >= vehicleCount || leasedVehicle < 0){
                                System.out.print("\nVehicle does not exist");
                                break;
                            }

                            if(vehicles[leasedVehicle].isLeased()){
                                System.out.print("\nThis vehicle has already been leased");
                            }

                            System.out.print("Please see all clients below\n");
                            for(int i = 0; i < clientCount; i++){
                                System.out.print("Client #" + (i + 1) + "\n" + clients[i] + "\n\n");
                            }

                            System.out.print("Enter the number of the client you wish to lease to\n-->");
                            int leaserClient = input.nextInt() - 1;

                            if(leaserClient >= clientCount || leaserClient < 0){
                                System.out.print("\nClient does not exist");
                                break;
                            }

                            clients[leaserClient].addVehicle(vehicles[leasedVehicle]);
                            vehicles[leasedVehicle].setLeased(true);
                            System.out.print("\nVehicle Successfully Leased!");
                            break;
                        case 2:
                            System.out.print("Please see all clients below\n");
                            for(int i = 0; i < clientCount; i++){
                                System.out.print("Client #" + (i + 1) + "\n" + clients[i] + "\n\n");
                            }
                            System.out.print("Which client wants to return a vehicle\n-->");
                            int returningClient = input.nextInt() - 1;

                            if(returningClient >= clientCount || returningClient < 0){
                                System.out.print("\nClient does not exist");
                                break;
                            }

                            if(clients[returningClient].getClientVehicleCount() == 0){
                                System.out.print("\nThis client has no vehicles leased");
                                break;
                            }

                            System.out.print(clients[returningClient].clientVehiclesList(vehicles, vehicleCount));
                            System.out.print("\nEnter the vehicle number that you wish to remove\n-->");
                            int returnedVehicle = input.nextInt() - 1;
                            clients[returningClient].removeVehicle(returnedVehicle);
                            vehicles[returnedVehicle].setLeased(false);
                            break;
                        case 3:
                            System.out.print("Please see all clients below\n");
                            for(int i = 0; i < clientCount; i++){
                                System.out.print("Client #" + (i + 1) + "\n" + clients[i] + "\n\n");
                            }

                            System.out.print("Which client's vehicles do you wish to view\n-->");
                            int viewedClient = input.nextInt() - 1;

                            System.out.print(clients[viewedClient].clientVehiclesList(vehicles, vehicleCount));
                            break;
                        case 4:
                            for(int i = 0; i < vehicleCount; i++){
                                if(vehicles[i].isLeased()){
                                    for(int j = 0; j < clientCount; j++){
                                        clients[j].isLeasedByClient(vehicles[i]);
                                    }
                                }
                            }
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
                            getLargestTruck(vehicles, vehicleCount);
                            break;
                        case 2:
                            ElectricTruck[] electricTruckCopy = copyVehicles(vehicles, vehicleCount);
                            for(int i = 0; i < electricTruckCopy.length; i++){
                                System.out.print(electricTruckCopy[i]);
                            }
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

    public static void getLargestTruck(Vehicle[] vehicles, int vehicleCount){
        double largestCapacity = 0;
        int index = -1;
        for(int i = 0; i < vehicleCount; i++){
            if(vehicles[i] instanceof DieselTruck && ((DieselTruck) vehicles[i]).getMaximumWeightCapacity() > largestCapacity){
                largestCapacity = ((DieselTruck) vehicles[i]).getMaximumWeightCapacity();
                index = i;
            }
        }

        if(index == -1){
            System.out.print("\nYou have no Diesel Trucks\n");
        }
        else {
            System.out.print("\nDiesel Truck with the largest capacity\nVehicle #" + index +
                    vehicles[index]);
        }
    }

    public static ElectricTruck[] copyVehicles(Vehicle[] vehicles, int vehicleCount){
        int electricTruckCount = 0;
        for(int i = 0; i < vehicleCount; i++){
            if(vehicles[i] instanceof ElectricTruck){
                electricTruckCount++;
            }
        }

        ElectricTruck[] electricTrucksCopy = new ElectricTruck[electricTruckCount];
        int currentIndex = 0;

        for(int i = 0; i < vehicleCount; i++){
            if(vehicles[i] instanceof ElectricTruck){
                electricTrucksCopy[currentIndex] = new ElectricTruck((ElectricTruck) vehicles[i]);
                currentIndex++;
            }
        }
        return electricTrucksCopy;
    }
}