package Data;

import java.util.Scanner;

public class Vehicle {

    // Plate number of the vehicle
    private String plateNumber;

    // Make of the vehicle (e.g., Toyota, Honda)
    private String make;

    // Model of the vehicle (e.g., Corolla, Civic)
    private String model;

    // Year the vehicle was produced
    private int yearOfProduction;

    // Whether the vehicle is leased or not
    private boolean isLeased;

    // Default constructor that initializes the vehicle with default values
    public Vehicle(){
        // Set default make, model, and year for an unknown vehicle
        this.make = "Unknown";

        this.model = "Unknown";

        this.yearOfProduction = 0;

        // Set isLeased to false as default
        isLeased = false;
    }

    // Constructor with specific make, model, and year
    Vehicle(String make, String model, int yearOfProduction){
        // Set the make of the vehicle
        this.make = make;

        // Set the model of the vehicle
        this.model = model;

        // Set the year of production for the vehicle
        this.yearOfProduction = yearOfProduction;

        // Set isLeased to false by default
        isLeased = false;
    }

    // Accessor for plate number
    public String getPlateNumber() {
        // Returns the plate number of the vehicle
        return plateNumber;
    }

    // Accessor for make
    public String getMake() {
        // Returns the make of the vehicle
        return make;
    }

    // Accessor for model
    public String getModel() {
        // Returns the model of the vehicle
        return model;
    }

    // Accessor for year of production
    public int getYearOfProduction() {
        // Returns the year of production for the vehicle
        return yearOfProduction;
    }

    // Accessor to check if the vehicle is leased
    public boolean isLeased() {
        // Returns whether the vehicle is leased
        return isLeased;
    }

    // Mutator for plate number
    public void setPlateNumber(String plateNumber) {
        // Sets the plate number of the vehicle
        this.plateNumber = plateNumber;
    }

    // Mutator for make
    public void setMake(String make) {
        // Sets the make of the vehicle
        this.make = make;
    }

    // Mutator for model
    public void setModel(String model) {
        // Sets the model of the vehicle
        this.model = model;
    }

    // Mutator for year of production
    public void setYearOfProduction(int yearOfProduction) {
        // Sets the year of production for the vehicle
        this.yearOfProduction = yearOfProduction;
    }

    // Mutator for leased status
    public void setLeased(boolean leased) {
        // Sets whether the vehicle is leased
        isLeased = leased;
    }

    // Override toString method to represent the vehicle as a string
    @Override
    public String toString() {
        // Returns a string representation of the vehicle's details
        return "\n\tMake: " + make + "\n\tModel: " + model + "\n\tYear of Production: " + yearOfProduction
                + "\n\tPlate Number: " + plateNumber + "\n\tIs Leased: " + isLeased;
    }

    // Override equals method to compare two vehicles
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vehicle){
            // Compare make, model, and year of production for equality
            return ((Vehicle) obj).getMake().equals(this.make) && ((Vehicle) obj).getModel().equals(this.model)
                    && ((Vehicle) obj).getYearOfProduction() == this.yearOfProduction;
        }
        else{
            // Return false if the object is not an instance of Vehicle
            return false;
        }
    }

    // Method to edit vehicle information not filled as overiedden in all child classes
    public int editInformation(Scanner input){
        return 0;
    }
}
