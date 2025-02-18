package Data;

import Data.Vehicle;

public class Car extends Vehicle {
    private int maximumPassengers;

    Car(){
        super();
        this.maximumPassengers = 0;
    }

    Car(String make, String model, int yearOfProduction, int maximumPassengers) {
        super(make, model, yearOfProduction);
        this.maximumPassengers = maximumPassengers;
    }

    public int getMaximumPassengers(){
        return maximumPassengers;
    }

    public void setMaximumPassengers(int maximumPassengers) {
        this.maximumPassengers = maximumPassengers;
    }
}
