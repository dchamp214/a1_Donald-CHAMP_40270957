package Data;

public class Vehicle {
    private String plateNumber;
    private String make;
    private String model;
    private int yearOfProduction;

    public Vehicle(){
        this.make = "Unknown";
        this.model = "Unknown";
        this.yearOfProduction = 0;
    }

    Vehicle(String make, String model, int yearOfProduction){
        this.make = make;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
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

}
