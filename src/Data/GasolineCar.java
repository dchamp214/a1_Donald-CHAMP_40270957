package Data;

public class GasolineCar extends Car{
    private int GasolineCarCount = 1000;

    GasolineCar(){
        super();
        this.setPlateNumber(generatePlateNumber());
    }

    public GasolineCar(String make, String model, int yearOfProduction, int maximumPassengers) {
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof GasolineCar) {
            return super.equals(obj);
        }
        else{
            return false;
        }
    }
}
