package Data;

public class ElectricTruck extends Truck{
    private double maximumRange;
    private static int ElectricTruckCount = 1000;

    ElectricTruck(String make, String model, int yearOfProduction, double maximumWeightCapacity, double maximumRange) {
        super(make, model, yearOfProduction, maximumWeightCapacity);
        this.maximumRange = maximumRange;
        this.setPlateNumber(generatePlateNumber());
    }

    public double getMaximumRange() {
        return maximumRange;
    }

    public void setMaximumRange(double maximumRange) {
        this.maximumRange = maximumRange;
    }

    private String generatePlateNumber(){
        ElectricTruckCount++;
        return "ET" + ElectricTruckCount;
    }
}
