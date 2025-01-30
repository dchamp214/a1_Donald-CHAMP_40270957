package Data;

public class GasolineCar extends Car{
    private int GasolineCarCount = 1000;

    GasolineCar(String make, String model, int yearOfProduction, int maximumPassengers) {
        super(make, model, yearOfProduction, maximumPassengers);
        this.setPlateNumber(generatePlateNumber());
    }

    GasolineCar(GasolineCar gasolineCar){
        super(gasolineCar.getMake(), gasolineCar.getModel(), gasolineCar.getYearOfProduction(), gasolineCar.getMaximumPassengers());
        this.setPlateNumber(generatePlateNumber());
    }

    private String generatePlateNumber(){
        GasolineCarCount++;
        return "GC" + GasolineCarCount;
    }
}
