package Data;

import Data.Vehicle;

public class Truck extends Vehicle {
    private double maximumWeightCapacity;

    Truck(){
        super();
        this.maximumWeightCapacity = 0;
    }

    Truck(String make, String model, int yearOfProduction, double maximumWeightCapacity) {
        super(make, model, yearOfProduction);
        this.maximumWeightCapacity = maximumWeightCapacity;
    }

    public double getMaximumWeightCapacity() {
        return maximumWeightCapacity;
    }

    public void setMaximumWeightCapacity(double maximumWeightCapacity){
        this.maximumWeightCapacity = maximumWeightCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Truck){
            return super.equals(obj) && ((Truck) obj).getMaximumWeightCapacity() == this.maximumWeightCapacity;
        }
        else{
            return false;
        }
    }
}
