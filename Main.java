import entities.Passenger;
import entities.FlightRoute;
import repositories.PassengerRepositoryImpl;
import repositories.FlightRouteRepository;
import repositories.FlightRouteRepositoryImpl;  // Assuming you have this class
import services.PassengerService;
import services.FlightRouteService;
import view.PassengerView;
import view.FlightRouteView;

public class Main {
    public static void main(String[] args) {
        // Setup dependency injection for Passenger
        PassengerRepositoryImpl passengerRepository = new PassengerRepositoryImpl();
        PassengerService passengerService = new PassengerService(passengerRepository);
        PassengerView passengerView = new PassengerView(passengerService);

        // Setup dependency injection for FlightRoute
        FlightRouteRepository flightRouteRepository = new FlightRouteRepositoryImpl();  // Use correct FlightRoute repository
        FlightRouteService flightRouteService = new FlightRouteService(flightRouteRepository);
        FlightRouteView flightRouteView = new FlightRouteView(flightRouteService);

        // Main loop
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
    }
}
