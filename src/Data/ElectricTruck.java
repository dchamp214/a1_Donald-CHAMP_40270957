package Data;

import java.util.Scanner;

public class ElectricTruck extends Truck {

    // Maximum range of the electric truck in kilometers
    private double maximumRange;

    // Static counter to generate unique ElectricTruck plate numbers
    private static int ElectricTruckCount = 1000;

    // Default constructor
    ElectricTruck(){
        // Call the parent class (Truck) constructor
        super();

        // Set the default value for maximumRange
        this.maximumRange = 0;

        // Generate and set a unique plate number for the ElectricTruck
        this.setPlateNumber(generatePlateNumber());
    }

    // Constructor with specific make, model, year, maximum weight capacity, and maximum range
    public ElectricTruck(String make, String model, int yearOfProduction, double maximumWeightCapacity, double maximumRange) {
        // Call the parent class (Truck) constructor to initialize make, model, year, and max weight capacity
        super(make, model, yearOfProduction, maximumWeightCapacity);

        // Set the maximum range for the ElectricTruck
        this.maximumRange = maximumRange;

        // Generate and set a unique plate number for the ElectricTruck
        this.setPlateNumber(generatePlateNumber());
    }

    // Copy constructor for ElectricTruck
    public ElectricTruck(ElectricTruck electricTruck){
        // Call the parent class (Truck) constructor and initialize its properties
        super(electricTruck.getMake(), electricTruck.getModel(), electricTruck.getYearOfProduction(), electricTruck.getMaximumWeightCapacity());

        // Set the maximum range for the new ElectricTruck
        this.maximumRange = electricTruck.getMaximumRange();

        // Generate and set a unique plate number for the new ElectricTruck
        this.setPlateNumber(generatePlateNumber());
    }

    // Accessor method for the maximum range
    public double getMaximumRange() {
        // Returns the maximum range of the ElectricTruck
        return maximumRange;
    }

    // Mutator method for the maximum range
    public void setMaximumRange(double maximumRange) {
        // Sets the maximum range of the ElectricTruck
        this.maximumRange = maximumRange;
    }

    // Method to generate a unique plate number for each ElectricTruck
    private String generatePlateNumber(){
        ElectricTruckCount++;
        return "ET" + ElectricTruckCount;
    }

    // Override toString method to represent the ElectricTruck as a string
    @Override
    public String toString() {
        // Call the parent class toString method and append the maximum range
        return super.toString() + "\n\tMax Range: " + maximumRange + "km";
    }

    // Override equals method to compare two ElectricTruck objects
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ElectricTruck){
            // Compare the parent class equality and maximum range
            return super.equals(obj) && ((ElectricTruck) obj).getMaximumRange() == this.maximumRange;
        }
        else{
            // Return false if the object is not an instance of ElectricTruck
            return false;
        }
    }

    // Method to edit the information of the ElectricTruck
    public int editInformation(Scanner input){
        // Display options for editing the ElectricTruck properties
        System.out.print("\t4. Maximum Weight Capacity: " + getMaximumWeightCapacity() + "kg\n");
        System.out.print("\t5. Autonomy Range: " + this.maximumRange + "km\n");
        System.out.print("--->");

        // Get the user's choice for editing
        int editChoice = input.nextInt();

        // Edit Maximum Weight Capacity if chosen
        if (editChoice == 4){
            System.out.print("Enter the new Maximum Weight Capacity (in kg): ");
            setMaximumWeightCapacity(input.nextDouble());
            return 0;
        }
        // Edit Autonomy Range if chosen
        else if (editChoice == 5) {
            System.out.print("Enter the new Autonomy Range (in km): ");
            setMaximumRange(input.nextDouble());
            return 0;
        }
        // Return the choice if neither option is selected
        else{
            return editChoice;
        }
    }
}
