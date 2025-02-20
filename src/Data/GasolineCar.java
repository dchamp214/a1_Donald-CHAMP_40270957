package Data;

import java.util.Scanner;

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

    public int editInformation(Scanner input){
        System.out.print("\t4. Maximum Weight Capacity: " + getMaximumPassengers() + "\n");
        System.out.print("--->");
        int editChoice = input.nextInt();
        if (editChoice == 4) {
            System.out.print("Enter the new Maximum Passengers: ");
            setMaximumPassengers(input.nextInt());
            return 0;
        }
        else{
            return editChoice;
        }
    }
}
