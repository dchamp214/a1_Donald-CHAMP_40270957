package Data;

import java.util.Scanner;

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

    public ElectricTruck(ElectricTruck electricTruck){
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ElectricTruck){
            return super.equals(obj) && ((ElectricTruck) obj).getMaximumRange() == this.maximumRange;
        }
        else{
            return false;
        }
    }

    public int editInformation(Scanner input){
        System.out.print("\t4. Maximum Weight Capacity: " + getMaximumWeightCapacity() + "kg\n");
        System.out.print("\t5. Autonomy Range: " + this.maximumRange + "km\n");
        System.out.print("--->");
        int editChoice = input.nextInt();
        if (editChoice == 4){
            System.out.print("Enter the new Maximum Weight Capacity (in kg): ");
            setMaximumWeightCapacity(input.nextDouble());
            return 0;
        } else if (editChoice == 5) {
            System.out.print("Enter the new Autonomy Range (in km): ");
            setMaximumRange(input.nextDouble());
            return 0;
        } else{
            return editChoice;
        }
    }
}
