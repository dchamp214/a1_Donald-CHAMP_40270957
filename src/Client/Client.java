package Client;
import Data.*;

public class Client {

    private String clientName;
    private String[] clientVehicles;
    private int clientID;

    private int clientVehicleCount;
    static  int clientCount = 1;



    public Client(){
        clientName = "Unknown";
        clientVehicles = new String[100];
        clientVehicleCount = 0;
        clientID = 1000 + clientCount;
        clientCount++;
    }

    public Client(String clientName){
        this.clientName = clientName;
        clientVehicles = new String[100];
        clientVehicleCount = 0;
        clientID = 1000 + clientCount;
        clientCount++;
    }

    public Client(Client copiedClient){
        this.clientName = copiedClient.getClientName();
        this.clientID = copiedClient.getClientID();
        this.clientVehicles = new String[copiedClient.clientVehicles.length];
        System.arraycopy(copiedClient.clientVehicles, 0, this.clientVehicles,
                0, copiedClient.clientVehicles.length);
        this.clientVehicleCount = copiedClient.getClientVehicleCount();
    }

    public String getClientName() {
        return clientName;
    }

    public int getClientID() {
        return clientID;
    }

    public int getClientVehicleCount() {
        return clientVehicleCount;
    }

    public String getClientVehicles(int index) {
        return clientVehicles[index];
    }

    public static int getClientCount() {
        return clientCount;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "Client Name: " + clientName + "\nClient ID: " + clientID + "\nNumber of Leased Vehicles: " + clientVehicleCount;
    }

    public String clientVehiclesList(Vehicle[] vehicles, int vehicleCount) {
        String returnedString = this.clientName + "'s Vehicles\n";
        for (int i = 0; i < vehicleCount; i++){
            for(int j = 0; j < clientVehicleCount; j++) {
                if(vehicles[i].getPlateNumber().equals(clientVehicles[j])){
                    returnedString = returnedString + "Vehicle " + (j+1) + ":" + vehicles[i] + "\n";
                }
            }
        }
        return returnedString;
    }

    public void addVehicle(Vehicle vehicle){
        this.clientVehicles[clientVehicleCount] = vehicle.getPlateNumber();
        clientVehicleCount++;
    }

    public void removeVehicle(int index){
        if(index < clientVehicleCount && index > -1){
            for(int i = index; i < clientVehicleCount; i++){
                clientVehicles[i] = clientVehicles[i+1];
            }
            clientVehicleCount--;
            System.out.print("\nVehicle Successfully Returned!\n");
        }
        else{
            System.out.print("\nVehicle Unsuccessfully Returned!\n");
        }
    }

    public void isLeasedByClient(Vehicle vehicle){
        for(int i = 0; i < clientVehicleCount; i++){
            if(clientVehicles[i].equals(vehicle.getPlateNumber())){
                System.out.print(vehicle + "\nLeased by: " + clientName + "\n");
            }
        }
    }

}
