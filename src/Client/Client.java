package Client;
import Data.*;

public class Client {

    private String clientName;
    private String[] clientVehicles;
    private int clientID;

    private int clientVehicleCount;
    static  int clientCount = 0;



    Client(){
        clientName = "Unknown";
        clientVehicles = new String[100];
        clientVehicleCount = 0;
        clientID = 1000 + clientCount;
        clientCount++;
    }

    Client(String clientName){
        this.clientName = clientName;
        clientVehicles = new String[100];
        clientVehicleCount = 0;
        clientID = 1000 + clientCount;
        clientCount++;
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

    public String clientVehiclesList(Vehicle[] vehicles) {
        String returnedString = this.clientName + "'s Vehicles";
        for (int i = 0; i < vehicles.length; i++){
            for(int j = 0; j < clientVehicleCount; j++) {
                if(vehicles[i].getPlateNumber() == clientVehicles[j]){
                    returnedString = returnedString + "Vehicle " + (j+1) + ":" + vehicles[i];
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
        for(int i = index; i < clientVehicleCount; i++){
            clientVehicles[i] = clientVehicles[i+1];
        }
        clientVehicleCount--;
    }

}
