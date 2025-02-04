package Driver;

import Data.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("Welcome to the RoyalRentals management software!");

        DieselTruck[] dieselTrucks = new DieselTruck[0];
        ElectricTruck[] electricTrucks = new ElectricTruck[0];
        GasolineCar[] gasolineCars = new GasolineCar[0];
        ElectricCar[] electricCars = new ElectricCar[0];

        do{
            System.out.print("\nWhat type of operation do you wish to perform?\n");
            System.out.print("\t1. Vehicle Management\n");
            System.out.print("\t2. Client Management\n");
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
                            System.out.print("Which car");
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            System.out.print("\nYou have made an invalid choice. Please try again");
                            break;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.print("\nYou have made an invalid choice. Please try again");
                    break;
            }

        }
        while(true);

    }
}