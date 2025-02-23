package Data;

import java.util.Scanner;

public class GasolineCar extends Car {

    // Static counter to generate unique GasolineCar plate numbers
    private int GasolineCarCount = 1000;

    // Default constructor for GasolineCar
    GasolineCar(){
        // Call the parent class (Car) constructor
        super();

        // Generate and set a unique plate number for the GasolineCar
        this.setPlateNumber(generatePlateNumber());
    }

    // Constructor with specific make, model, year, and maximum passengers
    public GasolineCar(String make, String model, int yearOfProduction, int maximumPassengers) {
        // Call the parent class (Car) constructor to initialize make, model, year, and max passengers
        super(make, model, yearOfProduction, maximumPassengers);

        // Generate and set a unique plate number for the GasolineCar
        this.setPlateNumber(generatePlateNumber());
    }

    // Copy constructor for GasolineCar
    GasolineCar(GasolineCar gasolineCar){
        // Call the parent class (Car) constructor and initialize its properties
        super(gasolineCar.getMake(), gasolineCar.getModel(), gasolineCar.getYearOfProduction(), gasolineCar.getMaximumPassengers());

        // Generate and set a unique plate number for the new GasolineCar
        this.setPlateNumber(generatePlateNumber());
    }

    // Method to generate a unique plate number for each GasolineCar
    private String generatePlateNumber(){
        GasolineCarCount++;
        return "GC" + GasolineCarCount;
    }

    // Override toString method to represent the GasolineCar as a string
    @Override
    public String toString() {
        // Call the parent class toString method for basic information
        return super.toString();
    }

    // Override equals method to compare two GasolineCar objects
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof GasolineCar) {
            // Compare the parent class equality
            return super.equals(obj);
        }
        else{
            // Return false if the object is not an instance of GasolineCar
            return false;
        }
    }

    // Method to edit the information of the GasolineCar
    public int editInformation(Scanner input){
        // Display options for editing the GasolineCar properties
        System.out.print("\t4. Maximum Weight Capacity: " + getMaximumPassengers() + "\n");
        System.out.print("--->");

        // Get the user's choice for editing
        int editChoice = input.nextInt();

        // Edit Maximum Passengers if chosen
        if (editChoice == 4) {
            System.out.print("Enter the new Maximum Passengers: ");
            setMaximumPassengers(input.nextInt());
            return 0;
        }
        // Return the choice if no valid option is selected
        else{
            return editChoice;
        }
    }
}
