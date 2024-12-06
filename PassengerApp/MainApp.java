package PassengerApp;

import PassengerApp.config.Database;
import PassengerApp.entities.FlightRoute;
import PassengerApp.entities.Passenger;
import PassengerApp.services.FlightRouteService;
import PassengerApp.services.PassengerService;
import org.springframework.context.annotation.ComponentScan;
import PassengerApp.repositories.PassengerRepositoryImpl;
import PassengerApp.repositories.FlightRouteRepositoryImpl;
import PassengerApp.view.PassengerView;
import PassengerApp.view.FlightRouteView;

import java.util.List;
import java.util.Scanner;

@ComponentScan(basePackages="PassengerApp")
public class MainApp {
    public static void main(String[] args) {
        // Initialize the database connection
        Database database = new Database(); // This will automatically connect to the database

        // Initialize PassengerApp.repositories and PassengerApp.services
        PassengerRepositoryImpl passengerRepository = new PassengerRepositoryImpl();
        PassengerService passengerService = new PassengerService() {
            @Override
            public void addPassenger(Passenger passenger) {
                // Implement add passenger logic
            }

            @Override
            public void editPassenger(int index, Passenger passenger) {
                // Implement edit passenger logic
            }

            @Override
            public List<Passenger> getAllPassengers() {
                return List.of();
            }

            @Override
            public Passenger[] getPassengerList() {
                return new Passenger[0];
            }

            @Override
            public Boolean removePassenger(Integer id) {
                return null;
            }

            @Override
            public Boolean removePassenger(String idCard) {
                return null;
            }
        };

        PassengerView passengerView = new PassengerView() {
            @Override
            public void running() {
                System.out.println("metode running() dijalankan");
            }

            @Override
            public void displayMessage(String message) {

            }

            @Override
            public void displayAllPassengers(List<Passenger> passengers) {
                // Implement the logic to display all passengers
            }

            @Override
            public void displayAddPassengerForm() {
                // Implement the logic for displaying the add passenger form
            }

            @Override
            public void displayEditPassengerForm(Passenger passenger) {
                // Implement the logic for editing passenger
            }

            @Override
            public void displayRemovePassengerForm() {
                // Implement the logic for removing passenger
            }

            @Override
            public void displayRemovePassengerConfirmation(String idCard) {
                // Implement confirmation of removing passenger
            }

            @Override
            public String getInputName() {
                return "John Doe";  // Example
            }

            @Override
            public String getInputAge() {
                return "30";  // Example
            }

            @Override
            public String getInputGender() {
                return "Male";  // Example
            }

            @Override
            public String getInputPassport() {
                return "X123456";  // Example
            }

            @Override
            public String getInputIdCard() {
                return "ID123456";  // Example
            }

            @Override
            public void displayMainMenu() {
                // Implement main menu display logic
            }

            @Override
            public void addPassenger() {
                // Implement add passenger functionality
            }

            @Override
            public void displayPassengerInfo() {
                // Implement displaying passenger info
            }

            @Override
            public void editPassenger() {
                // Implement editing passenger functionality
            }
        };

        FlightRouteRepositoryImpl flightRouteRepository = new FlightRouteRepositoryImpl();
        FlightRouteService flightRouteService = new FlightRouteService() {
            @Override
            public void addFlightRoute(FlightRoute flightRoute) {
                // Implement add flight route logic
            }

            @Override
            public void editFlightRoute(String routeId, FlightRoute flightRoute) {
                // Implement edit flight route logic
            }

            @Override
            public void removeFlightRoute(String routeId) {
                // Implement remove flight route logic
            }

            @Override
            public List<FlightRoute> getAllFlightRoutes() {
                return List.of();
            }

            @Override
            public FlightRoute[] getFlightRouteList() {
                return new FlightRoute[0];
            }
        };

        FlightRouteView flightRouteView = new FlightRouteView() {
            @Override
            public void displayMessage(String message) {
                System.out.println(message);
            }

            @Override
            public void displayAllFlightRoutes(List<FlightRoute> flightRoutes) {
                // Implement displaying all flight routes
            }

            @Override
            public void displayAddFlightRouteForm() {
                // Implement add flight route form
            }

            @Override
            public void displayEditFlightRouteForm(FlightRoute flightRoute) {
                // Implement edit flight route form
            }

            @Override
            public void displayRemoveFlightRouteForm() {
                // Implement remove flight route form
            }

            @Override
            public void displayRemoveFlightRouteConfirmation(String routeId) {
                // Implement remove flight route confirmation
            }

            @Override
            public String getInputRouteId() {
                return "R001";  // Example
            }

            @Override
            public String getInputDeparture() {
                return "JFK";  // Example
            }

            @Override
            public String getInputDestination() {
                return "LAX";  // Example
            }

            @Override
            public String getInputDepartureTime() {
                return "2024-12-12 10:00";  // Example
            }

            @Override
            public void displayMainMenu() {
                // Implement the main menu display logic
            }

            @Override
            public void addFlightRoute() {
                // Implement add flight route functionality
            }

            @Override
            public void displayFlightRoutes() {
                // Implement displaying flight routes
            }

            @Override
            public void editFlightRoute() {
                // Implement editing flight route
            }

            @Override
            public void removeFlightRoute() {
                // Implement removing flight route
            }

            @Override
            public void running() {

            }
        };

        // Main loop
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("Menu: ");
            System.out.println("1. Tambah Data Passenger");
            System.out.println("2. Tampilkan Daftar Passenger");
            System.out.println("3. Edit Passenger");
            System.out.println("4. Tambah Rute Penerbangan");
            System.out.println("5. Tampilkan Daftar Rute Penerbangan");
            System.out.println("6. Edit Rute Penerbangan");
            System.out.println("7. Hapus Rute Penerbangan");
            System.out.println("8. Keluar");
            System.out.print("Pilih opsi: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    passengerView.addPassenger();
                    break;
                case 2:
                    passengerView.displayPassengerInfo();
                    break;
                case 3:
                    passengerView.editPassenger();
                    break;
                case 4:
                    flightRouteView.addFlightRoute();
                    break;
                case 5:
                    flightRouteView.displayFlightRoutes();
                    break;
                case 6:
                    flightRouteView.editFlightRoute();
                    break;
                case 7:
                    flightRouteView.removeFlightRoute();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }

    passengerView.running();
        // Close the database connection once the program ends
        database.closeConnection();  // Ensure the connection is closed after the loop ends
    }
}
