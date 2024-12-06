package PassengerApp;

import PassengerApp.config.Database;
import PassengerApp.entities.FlightRoute;
import PassengerApp.entities.Passenger;
import PassengerApp.services.FlightRouteService;
import PassengerApp.services.PassengerService;
import PassengerApp.view.FlightRouteView;
import PassengerApp.view.PassengerView;
import org.springframework.context.annotation.ComponentScan;
import PassengerApp.repositories.PassengerRepositoryImpl;
import PassengerApp.repositories.FlightRouteRepositoryImpl;

import java.util.List;

@ComponentScan(basePackages="PassengerApp")
public class Main {
    public static void main(String[] args) {
        // Initialize the database connection
        Database database = new Database(); // This will automatically connect to the database

        // Initialize PassengerApp.repositories and PassengerApp.services
        PassengerRepositoryImpl passengerRepository = new PassengerRepositoryImpl();
        PassengerService passengerService = new PassengerService() {
            @Override
            public void addPassenger(Passenger passenger) {

            }

            @Override
            public void editPassenger(int index, Passenger passenger) {

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
            public void displayMessage(String message) {

            }

            @Override
            public void displayAllPassengers(List<Passenger> passengers) {

            }

            @Override
            public void displayAddPassengerForm() {

            }

            @Override
            public void displayEditPassengerForm(Passenger passenger) {

            }

            @Override
            public void displayRemovePassengerForm() {

            }

            @Override
            public void displayRemovePassengerConfirmation(String idCard) {

            }

            @Override
            public String getInputName() {
                return "";
            }

            @Override
            public String getInputAge() {
                return "";
            }

            @Override
            public String getInputGender() {
                return "";
            }

            @Override
            public String getInputPassport() {
                return "";
            }

            @Override
            public String getInputIdCard() {
                return "";
            }

            @Override
            public void displayMainMenu() {

            }

            @Override
            public void addPassenger() {

            }

            @Override
            public void displayPassengerInfo() {

            }

            @Override
            public void editPassenger() {

            }
        };

        FlightRouteRepositoryImpl flightRouteRepository = new FlightRouteRepositoryImpl();
        FlightRouteService flightRouteService = new FlightRouteService() {
            @Override
            public void addFlightRoute(FlightRoute flightRoute) {

            }

            @Override
            public void editFlightRoute(String routeId, FlightRoute flightRoute) {

            }

            @Override
            public void removeFlightRoute(String routeId) {

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

            }

            @Override
            public void displayAllFlightRoutes(List<FlightRoute> flightRoutes) {

            }

            @Override
            public void displayAddFlightRouteForm() {

            }

            @Override
            public void displayEditFlightRouteForm(FlightRoute flightRoute) {

            }

            @Override
            public void displayRemoveFlightRouteForm() {

            }

            @Override
            public void displayRemoveFlightRouteConfirmation(String routeId) {

            }

            @Override
            public String getInputRouteId() {
                return "";
            }

            @Override
            public String getInputDeparture() {
                return "";
            }

            @Override
            public String getInputDestination() {
                return "";
            }

            @Override
            public String getInputDepartureTime() {
                return "";
            }

            @Override
            public void displayMainMenu() {

            }

            @Override
            public void addFlightRoute() {

            }

            @Override
            public void displayFlightRoutes() {

            }

            @Override
            public void editFlightRoute() {

            }

            @Override
            public void removeFlightRoute() {

            }
        };

        // PassengerApp.Main loop
        boolean running = true;
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

            int option = new java.util.Scanner(System.in).nextInt();
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

        // Close the database connection once the program ends
        database.closeConnection();  // Ensure the connection is closed after the loop ends
    }
}
