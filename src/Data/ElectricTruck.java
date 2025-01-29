package Data;

public class ElectricTruck extends Truck{
    private double maximumRange;
    static int ElectricTruckCount = 1000;

    ElectricTruck(String make, String model, int yearOfProduction, double maximumWeightCapacity, double maximumRange) {
        super(make, model, yearOfProduction, maximumWeightCapacity);
        this.maximumRange = maximumRange;
        this.setPlateNumber(generatePlateNumber());
    }

    private String generatePlateNumber(){
        ElectricTruckCount++;
        return "ET" + ElectricTruckCount;
    }
}
