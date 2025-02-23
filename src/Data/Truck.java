package Data;

import Data.Vehicle;

public class Truck extends Vehicle {

    // Maximum weight capacity of the truck
    private double maximumWeightCapacity;

    // Default constructor
    Truck(){
        // Call the parent class (Vehicle) constructor
        super();

        // Set the default value for maximumWeightCapacity
        this.maximumWeightCapacity = 0;
    }

    // Constructor with specific make, model, year, and maximum weight capacity
    Truck(String make, String model, int yearOfProduction, double maximumWeightCapacity) {
        // Call the parent class (Vehicle) constructor to initialize make, model, and year
        super(make, model, yearOfProduction);

        // Set the maximum weight capacity for the truck
        this.maximumWeightCapacity = maximumWeightCapacity;
    }

    // Accessor method for the maximum weight capacity
    public double getMaximumWeightCapacity() {
        return maximumWeightCapacity;
    }

    // Mutator method for the maximum weight capacity
    public void setMaximumWeightCapacity(double maximumWeightCapacity){
        this.maximumWeightCapacity = maximumWeightCapacity;
    }

    // Override toString method to represent the truck as a string
    @Override
    public String toString() {
        // Call the parent class toString method and append the maximum weight capacity
        return super.toString() + "\n\tMax Weight Capacity: " + maximumWeightCapacity + "kg";
    }

    // Override equals method to compare two trucks
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Truck){
            // Compare the parent class equality and maximum weight capacity
            return super.equals(obj) && ((Truck) obj).getMaximumWeightCapacity() == this.maximumWeightCapacity;
        }
        else{
            // Return false if the object is not an instance of Truck
            return false;
        }
    }
}
