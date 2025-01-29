package Data;

import Data.Vehicle;

public class Car extends Vehicle {
    private int maximumPassengers;

    Car(String make, String model, int yearOfProduction, int maximumPassengers) {
        super(make, model, yearOfProduction);
        this.maximumPassengers = maximumPassengers;
    }
}
