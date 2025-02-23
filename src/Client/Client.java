package Client;
import Data.*;

public class Client {

    // Stores the name of the client
    private String clientName;

    // Array to store the vehicles leased by the client
    private String[] clientVehicles;

    // Unique ID for the client
    private int clientID;

    // Tracks the number of vehicles leased by the client
    private int clientVehicleCount;

    // Static counter to generate unique client IDs
    static int clientCount = 1;

    // Default constructor
    public Client(){
        // Default name for the client
        clientName = "Unknown";

        // Initialize the vehicles array with a capacity of 100
        clientVehicles = new String[100];

        // Initialize the vehicle count to 0
        clientVehicleCount = 0;

        // Generate a unique client ID
        clientID = 1000 + clientCount;

        // Increment the client count for the next client
        clientCount++;
    }

    // Constructor with client name parameter
    public Client(String clientName){
        // Set the client name
        this.clientName = clientName;

        // Initialize the vehicles array with a capacity of 100
        clientVehicles = new String[100];

        // Initialize the vehicle count to 0
        clientVehicleCount = 0;

        // Generate a unique client ID
        clientID = 1000 + clientCount;

        // Increment the client count for the next client
        clientCount++;
    }

    // Copy constructor
    public Client(Client copiedClient){
        // Copy the client name
        this.clientName = copiedClient.getClientName();

        // Copy the client ID
        this.clientID = copiedClient.getClientID();

        // Initialize the vehicles array with the same length
        this.clientVehicles = new String[copiedClient.clientVehicles.length];

        // Copy the vehicles array
        System.arraycopy(copiedClient.clientVehicles, 0, this.clientVehicles, 0, copiedClient.clientVehicles.length);

        // Copy the vehicle count
        this.clientVehicleCount = copiedClient.getClientVehicleCount();
    }

    // Accessor for client name
    public String getClientName() {
        // Returns the name of the client
        return clientName;
    }

    // Accessor for client ID
    public int getClientID() {
        // Returns the unique client ID
        return clientID;
    }

    // Accessor for client vehicle count
    public int getClientVehicleCount() {
        // Returns the number of vehicles leased by the client
        return clientVehicleCount;
    }

    // Accessor for a specific vehicle by index
    public String getClientVehicles(int index) {
        // Returns the plate number of the vehicle at the given index
        return clientVehicles[index];
    }

    // Accessor for the total client count
    public static int getClientCount() {
        // Returns the total count of clients created
        return clientCount;
    }

    // Mutator for client name
    public void setClientName(String clientName) {
        // Sets the name of the client
        this.clientName = clientName;
    }

    // Override toString method to provide a string representation of the client
    @Override
    public String toString() {
        // Returns a string representation of the client details
        return "Client Name: " + clientName + "\nClient ID: " + clientID + "\nNumber of Leased Vehicles: " + clientVehicleCount;
    }

    // Override equals method to compare two clients
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Client){
            // Compares the client name and ID to determine equality
            return clientName.equals(((Client) obj).getClientName()) && clientID == ((Client) obj).getClientID();
        }
        else{
            return false;
        }
    }

    // Method to list all vehicles leased by the client
    public String clientVehiclesList(Vehicle[] vehicles, int vehicleCount) {
        // String to hold the list of leased vehicles
        String returnedString = this.clientName + "'s Vehicles\n";

        for (int i = 0; i < vehicleCount; i++){
            for(int j = 0; j < clientVehicleCount; j++) {
                // Check if the vehicle plate number matches the leased vehicles
                if(vehicles[i].getPlateNumber().equals(clientVehicles[j])){
                    // Add the vehicle details to the returned string
                    returnedString = returnedString + "Vehicle " + (j+1) + ":" + vehicles[i] + "\n";
                }
            }
        }
        return returnedString;
    }

    // Method to add a vehicle to the client's leased vehicles
    public void addVehicle(Vehicle vehicle){
        // Add the vehicle plate number to the client's leased vehicles array
        this.clientVehicles[clientVehicleCount] = vehicle.getPlateNumber();

        // Increment the vehicle count
        clientVehicleCount++;
    }

    // Method to remove a vehicle from the client's leased vehicles
    public void removeVehicle(int index){
        if(index < clientVehicleCount && index > -1){
            for(int i = index; i < clientVehicleCount; i++){
                // Shift the remaining vehicles in the array to fill the gap
                clientVehicles[i] = clientVehicles[i+1];
            }
            // Decrement the vehicle count
            clientVehicleCount--;

            // Confirmation message
            System.out.print("\nVehicle Successfully Returned!\n");
        }
        else{
            // Error message if index is invalid
            System.out.print("\nVehicle Unsuccessfully Returned!\n");
        }
    }

    // Method to check if a vehicle is leased by the client
    public void isLeasedByClient(Vehicle vehicle){
        for(int i = 0; i < clientVehicleCount; i++){
            // If the vehicle plate number matches, print details
            if(clientVehicles[i].equals(vehicle.getPlateNumber())){
                System.out.print(vehicle + "\nLeased by: " + clientName + "\n");
            }
        }
    }

}
