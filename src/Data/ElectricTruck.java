package Data;

public class ElectricTruck extends Truck{
    private double maximumRange;
    private static int ElectricTruckCount = 1000;

    ElectricTruck(){
        super();
        this.maximumRange = 0;
        this.setPlateNumber(generatePlateNumber());
    }

    public ElectricTruck(String make, String model, int yearOfProduction, double maximumWeightCapacity, double maximumRange) {
        super(make, model, yearOfProduction, maximumWeightCapacity);
        this.maximumRange = maximumRange;
        this.setPlateNumber(generatePlateNumber());
    }

    ElectricTruck(ElectricTruck electricTruck){
        super(electricTruck.getMake(), electricTruck.getModel(), electricTruck.getYearOfProduction(), electricTruck.getMaximumWeightCapacity());
        this.maximumRange = electricTruck.getMaximumRange();
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
