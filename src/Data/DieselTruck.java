package Data;

import java.util.Scanner;

public class DieselTruck extends Truck {

    // Fuel capacity of the diesel truck
    private double fuelCapacity;

    // Static counter to generate unique DieselTruck plate numbers
    private static int DieselTruckCount = 1000;

    // Default constructor
    DieselTruck(){
        // Call the parent class (Truck) constructor
        super();

        // Set the default value for fuel capacity
        this.fuelCapacity = 0;

        // Generate and set a unique plate number for the DieselTruck
        this.setPlateNumber(generatePlateNumber());
    }

    // Constructor with specific make, model, year, maximum weight capacity, and fuel capacity
    public DieselTruck(String make, String model, int yearOfProduction, double maximumWeightCapacity, double fuelCapacity) {
        // Call the parent class (Truck) constructor to initialize make, model, year, and max weight capacity
        super(make, model, yearOfProduction, maximumWeightCapacity);

        // Set the fuel capacity for the DieselTruck
        this.fuelCapacity = fuelCapacity;

        // Generate and set a unique plate number for the DieselTruck
        this.setPlateNumber(generatePlateNumber());
    }

    // Copy constructor for DieselTruck
    DieselTruck(DieselTruck dieselTruck){
        // Call the parent class (Truck) constructor and initialize its properties
        super(dieselTruck.getMake(), dieselTruck.getModel(), dieselTruck.getYearOfProduction(), dieselTruck.getMaximumWeightCapacity());

        // Set the fuel capacity for the new DieselTruck
        this.fuelCapacity = dieselTruck.getFuelCapacity();

        // Generate and set a unique plate number for the new DieselTruck
        this.setPlateNumber(generatePlateNumber());
    }

    // Accessor method for the fuel capacity
    public double getFuelCapacity() {
        // Returns the fuel capacity of the DieselTruck
        return fuelCapacity;
    }

    // Mutator method for the fuel capacity
    public void setFuelCapacity(double fuelCapacity) {
        // Sets the fuel capacity of the DieselTruck
        this.fuelCapacity = fuelCapacity;
    }

    // Method to generate a unique plate number for each DieselTruck
    private String generatePlateNumber(){
        DieselTruckCount++;
        return "DT" + DieselTruckCount;
    }

    // Override toString method to represent the DieselTruck as a string
    @Override
    public String toString() {
        // Call the parent class toString method and append the fuel capacity
        return super.toString() + "\n\tFuel Capacity: " + fuelCapacity + "L";
    }

    // Override equals method to compare two DieselTruck objects
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DieselTruck){
            // Compare the parent class equality and fuel capacity
            return super.equals(obj) && ((DieselTruck) obj).getFuelCapacity() == this.fuelCapacity;
        }
        else{
            // Return false if the object is not an instance of DieselTruck
            return false;
        }
    }

    // Method to edit the information of the DieselTruck
    public int editInformation(Scanner input){
        // Display options for editing the DieselTruck properties
        System.out.print("\t4. Maximum Weight Capacity: " + getMaximumWeightCapacity() + "kg\n");
        System.out.print("\t5. Fuel Capacity: " + this.fuelCapacity + "L\n");
        System.out.print("--->");

        // Get the user's choice for editing
        int editChoice = input.nextInt();

        // Edit Maximum Weight Capacity if chosen
        if (editChoice == 4){
            System.out.print("Enter the new Maximum Weight Capacity (in kg): ");
            setMaximumWeightCapacity(input.nextDouble());
            return 0;
        }
        // Edit Fuel Capacity if chosen
        else if (editChoice == 5) {
            System.out.print("Enter new Fuel Capacity (in litres): ");
            setFuelCapacity(input.nextDouble());
            return 0;
        }
        // Return the choice if neither option is selected
        else{
            return editChoice;
        }
    }
}
