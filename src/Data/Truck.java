package Data;

import Data.Vehicle;

public class Truck extends Vehicle {
    private double maximumWeightCapacity;

    Truck(String make, String model, int yearOfProduction, double maximumWeightCapacity) {
        super(make, model, yearOfProduction);
        this.maximumWeightCapacity = maximumWeightCapacity;
    }
}
