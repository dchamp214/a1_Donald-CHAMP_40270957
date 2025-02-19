package Data;

public class ElectricCar extends Car{
    private double maximumRange;
    private int ElectricCarCount = 1000;

    ElectricCar(){
        super();
        this.maximumRange = 0;
        this.setPlateNumber(generatePlateNumber());
    }

    public ElectricCar(String make, String model, int yearOfProduction, int maximumPassengers, double maximumRange) {
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ElectricCar){
            return super.equals(obj) && ((ElectricCar) obj).getMaximumRange() == this.maximumRange;
        }
        else{
            return false;
        }
    }
}
