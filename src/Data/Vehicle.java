package Data;

import java.util.Scanner;

public class Vehicle {
    private String plateNumber;
    private String make;
    private String model;
    private int yearOfProduction;
    private boolean isLeased;

    public Vehicle(){
        this.make = "Unknown";
        this.model = "Unknown";
        this.yearOfProduction = 0;
        isLeased = false;
    }

    Vehicle(String make, String model, int yearOfProduction){
        this.make = make;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        isLeased = false;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public boolean isLeased() {
        return isLeased;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void setLeased(boolean leased) {
        isLeased = leased;
    }

    @Override
    public String toString() {
        return "\n\tMake: " + make + "\n\tModel: " + model + "\n\tYear of Production: " + yearOfProduction
                + "\n\tPlate Number: " + plateNumber + "\n\tIs Leased: " + isLeased;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vehicle){
            return ((Vehicle) obj).getMake().equals(this.make) && ((Vehicle) obj).getModel().equals(this.model)
                    && ((Vehicle) obj).getYearOfProduction() == this.yearOfProduction;
        }
        else{
            return false;
        }
    }

    public int editInformation(Scanner input){
        return 0;
    }
}
