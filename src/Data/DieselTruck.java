package Data;

import java.util.Scanner;

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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DieselTruck){
            return super.equals(obj) && ((DieselTruck) obj).getFuelCapacity() == this.fuelCapacity;
        }
        else{
            return false;
        }
    }

    public int editInformation(Scanner input){
        System.out.print("\t4. Maximum Weight Capacity: " + getMaximumWeightCapacity() + "kg\n");
        System.out.print("\t5. Fuel Capacity: " + this.fuelCapacity + "L\n");
        System.out.print("--->");
        int editChoice = input.nextInt();
        if (editChoice == 4){
            System.out.print("Enter the new Maximum Weight Capacity (in kg): ");
            setMaximumWeightCapacity(input.nextDouble());
            return 0;
        } else if (editChoice == 5) {
            System.out.print("Enter new Fuel Capacity (in litres): ");
            setFuelCapacity(input.nextDouble());
            return 0;
        } else{
            return editChoice;
        }
    }
}
