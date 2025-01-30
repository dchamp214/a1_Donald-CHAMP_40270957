package Data;

public class ElectricCar extends Car{
    private double maximumRange;
    private int ElectricCarCount = 1000;
    ElectricCar(String make, String model, int yearOfProduction, int maximumPassengers, double maximumRange) {
        super(make, model, yearOfProduction, maximumPassengers);
        this.maximumRange = maximumRange;
        this.setPlateNumber(generatePlateNumber());
    }

    ElectricCar(ElectricCar electricCar){
        super(electricCar.getMake(), electricCar.getModel(), electricCar.getYearOfProduction(), electricCar.getMaximumPassengers());
        this.maximumRange = electricCar.maximumRange;
        setPlateNumber(generatePlateNumber());
    }

    public double getMaximumRange() {
        return maximumRange;
    }

    public void setMaximumRange(double maximumRange) {
        this.maximumRange = maximumRange;
    }

    private String generatePlateNumber(){
        ElectricCarCount++;
        return "EC" + ElectricCarCount;
    }
}
