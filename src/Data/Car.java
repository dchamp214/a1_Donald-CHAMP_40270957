package Data;

import Data.Vehicle;

public class Car extends Vehicle {

    // Maximum number of passengers the car can hold
    private int maximumPassengers;

    // Default constructor
    Car(){
        // Call the parent class (Vehicle) constructor
        super();

        // Set the default value for maximumPassengers
        this.maximumPassengers = 0;
    }

    // Constructor with specific make, model, year, and maximum passengers
    Car(String make, String model, int yearOfProduction, int maximumPassengers) {
        // Call the parent class (Vehicle) constructor to initialize make, model, and year
        super(make, model, yearOfProduction);

        // Set the maximum number of passengers for the car
        this.maximumPassengers = maximumPassengers;
    }

    // Accessor method for the maximum number of passengers
    public int getMaximumPassengers(){
        // Returns the maximum number of passengers
        return maximumPassengers;
    }

    // Mutator method for the maximum number of passengers
    public void setMaximumPassengers(int maximumPassengers) {
        // Sets the maximum number of passengers
        this.maximumPassengers = maximumPassengers;
    }

    // Override toString method to represent the car as a string
    @Override
    public String toString() {
        // Call the parent class toString method and append the maximum passengers
        return super.toString() + "\n\tMaximum passengers: " + maximumPassengers;
    }

    // Override equals method to compare two cars
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Car){
            // Compare the parent class equality and maximum passengers
            return super.equals(obj) && ((Car) obj).getMaximumPassengers() == this.maximumPassengers;
        }
        else{
            // Return false if the object is not an instance of Car
            return false;
        }
    }
}
