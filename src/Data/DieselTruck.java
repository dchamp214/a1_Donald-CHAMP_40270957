package Data;

public class DieselTruck extends Truck{
    private double fuelCapacity;
    private static int DieselTruckCount = 1000;

    DieselTruck(){
        super();
        this.fuelCapacity = 0;
        this.setPlateNumber(generatePlateNumber());
    }

    public DieselTruck(String make, String model, int yearOfProduction, double maximumWeightCapacity, double fuelCapacity) {
        super(make, model, yearOfProduction, maximumWeightCapacity);
        this.fuelCapacity = fuelCapacity;
        this.setPlateNumber(generatePlateNumber());
    }

    DieselTruck(DieselTruck dieselTruck){
        super(dieselTruck.getMake(), dieselTruck.getModel(), dieselTruck.getYearOfProduction(), dieselTruck.getMaximumWeightCapacity());
        this.fuelCapacity = dieselTruck.getFuelCapacity();
        this.setPlateNumber(generatePlateNumber());
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
