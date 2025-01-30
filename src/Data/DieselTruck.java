package Data;

public class DieselTruck extends Truck{
    private double fuelCapacity;
    private static int DieselTruckCount = 1000;

    DieselTruck(String make, String model, int yearOfProduction, double maximumWeightCapacity, double fuelCapacity) {
        super(make, model, yearOfProduction, maximumWeightCapacity);
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    private String generatePlateNumber(){
        DieselTruckCount++;
        return "DT" + DieselTruckCount;
    }
}
