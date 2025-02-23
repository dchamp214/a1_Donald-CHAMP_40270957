package Data;

import java.util.Scanner;

public class ElectricCar extends Car {
    // Instance variable to store the maximum range of the ElectricCar
    private double maximumRange;

    // Static counter to generate unique ElectricCar plate numbers
    private int ElectricCarCount = 1000;

    // Default constructor for ElectricCar
    ElectricCar(){
        // Call the parent class (Car) constructor
        super();

        // Initialize maximum range to 0
        this.maximumRange = 0;

        // Generate and set a unique plate number for the ElectricCar
        this.setPlateNumber(generatePlateNumber());
    }

    // Constructor with specific make, model, year, maximum passengers, and maximum range
    public ElectricCar(String make, String model, int yearOfProduction, int maximumPassengers, double maximumRange) {
        // Call the parent class (Car) constructor to initialize make, model, year, and max passengers
        super(make, model, yearOfProduction, maximumPassengers);

        // Set the maximum range for the ElectricCar
        this.maximumRange = maximumRange;

        // Generate and set a unique plate number for the ElectricCar
        this.setPlateNumber(generatePlateNumber());
    }

    // Copy constructor for ElectricCar
    ElectricCar(ElectricCar electricCar){
        // Call the parent class (Car) constructor and initialize its properties
        super(electricCar.getMake(), electricCar.getModel(), electricCar.getYearOfProduction(), electricCar.getMaximumPassengers());

        // Copy the maximum range from the provided ElectricCar
        this.maximumRange = electricCar.maximumRange;

        // Generate and set a unique plate number for the ElectricCar
        setPlateNumber(generatePlateNumber());
    }

    // Accessor method to get the maximum range of the ElectricCar
    public double getMaximumRange() {
        return maximumRange;
    }

    // Mutator method to set the maximum range of the ElectricCar
    public void setMaximumRange(double maximumRange) {
        this.maximumRange = maximumRange;
    }

    // Method to generate a unique plate number for each ElectricCar
    private String generatePlateNumber(){
        ElectricCarCount++;
        return "EC" + ElectricCarCount;
    }

    // Override toString method to represent the ElectricCar as a string
    @Override
    public String toString() {
        // Call the parent class toString method for basic information and append maximum range
        return super.toString() + "\n\tMax Range: " + maximumRange + "km";
    }

    // Override equals method to compare two ElectricCar objects
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ElectricCar){
            // Compare the parent class equality and also check if the maximum range is equal
            return super.equals(obj) && ((ElectricCar) obj).getMaximumRange() == this.maximumRange;
        }
        else{
            // Return false if the object is not an instance of ElectricCar
            return false;
        }
    }

    // Method to edit the information of the ElectricCar
    public int editInformation(Scanner input){
        // Display options for editing the ElectricCar properties
        System.out.print("\t4. Maximum Passengers: " + getMaximumPassengers() + "\n");
        System.out.print("\t5. Autonomy Range: " + this.maximumRange + "km\n");
        System.out.print("\n--->");

        // Get the user's choice for editing
        int editChoice = input.nextInt();

        // Edit Maximum Passengers if chosen
        if (editChoice == 4){
            System.out.print("Enter the new Maximum Passengers: ");
            setMaximumPassengers(input.nextInt());
            return 0;
        }
        // Edit Maximum Range if chosen
        else if (editChoice == 5) {
            System.out.print("Enter the new Autonomy Range (in km): ");
            setMaximumRange(input.nextDouble());
            return 0;
        }
        // Return the choice if no valid option is selected
        else{
            return editChoice;
        }
    }
}
