package PassengerApp.view;

import PassengerApp.entities.FlightRoute;
import PassengerApp.services.FlightRouteService;

import java.util.List;
import java.util.Scanner;

public class FlightRouteViewImpl {
    private final FlightRouteService flightRouteService;
    private final Scanner scanner;

    // Constructor
    public FlightRouteViewImpl(FlightRouteService flightRouteService) {
        this.flightRouteService = flightRouteService;
        this.scanner = new Scanner(System.in);
    }

    // Constructor dengan scanner untuk testing atau kebutuhan lain
    public FlightRouteViewImpl(FlightRouteService flightRouteService, Scanner scanner) {
        this.flightRouteService = flightRouteService;
        this.scanner = scanner;
    }

    // Menampilkan semua rute penerbangan
    public void displayFlightRoutes() {
        List<FlightRoute> flightRoutes = flightRouteService.getAllFlightRoutes();
        if (flightRoutes.isEmpty()) {
            System.out.println("Tidak ada rute penerbangan.");
        } else {
            for (int i = 0; i < flightRoutes.size(); i++) {
                FlightRoute route = flightRoutes.get(i);
                System.out.println((i + 1) + ". Rute ID: " + route.getRouteId() + ", Kota Keberangkatan: " + route.getDepartureCity() + ", Kota Tujuan: " + route.getArrivalCity());
            }
        }
    }

    // Menambahkan rute penerbangan baru
    public void addFlightRoute() {
        System.out.println("Masukkan ID Rute: ");
        String routeId = scanner.nextLine();
        System.out.println("Masukkan Kota Keberangkatan: ");
        String departureCity = scanner.nextLine();
        System.out.println("Masukkan Kota Tujuan: ");
        String arrivalCity = scanner.nextLine();
        System.out.println("Masukkan Waktu Keberangkatan: ");
        String departureTime = scanner.nextLine();
        System.out.println("Masukkan Waktu Kedatangan: ");
        String arrivalTime = scanner.nextLine();

        FlightRoute flightRoute = new FlightRoute(departureCity, arrivalCity, departureTime, arrivalTime);
        System.out.println("Rute perbangan baru akan di tambahkan: " + flightRoute.getRouteId());
        flightRouteService.addFlightRoute(flightRoute);
    }

    // Mengedit rute penerbangan yang ada
    public void editFlightRoute() {
        displayFlightRoutes();
        System.out.println("Masukkan ID Rute yang akan diedit: ");
        String routeId = scanner.nextLine();
        System.out.println("Masukkan Kota Keberangkatan Baru: ");
        String departureCity = scanner.nextLine();
        System.out.println("Masukkan Kota Tujuan Baru: ");
        String arrivalCity = scanner.nextLine();
        System.out.println("Masukkan Waktu Keberangkatan Baru: ");
        String departureTime = scanner.nextLine();
        System.out.println("Masukkan Waktu Kedatangan Baru: ");
        String arrivalTime = scanner.nextLine();

        FlightRoute flightRoute = new FlightRoute(departureCity, arrivalCity, departureTime, arrivalTime);
        flightRouteService.editFlightRoute(routeId, flightRoute);
    }

    // Menghapus rute penerbangan
    public void removeFlightRoute() {
        displayFlightRoutes();
        System.out.println("Masukkan ID Rute yang akan dihapus: ");
        String routeId = scanner.nextLine();
        flightRouteService.removeFlightRoute(routeId);
    }

    // Menampilkan menu dan menjalankan aplikasi
    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\nMENU RUTE PENERBANGAN:");
            System.out.println("1. Tambah Data Passenger");
            System.out.println("2. Tampilkan Daftar Passenger");
            System.out.println("3. Edit Passenger");
            System.out.println("4. Tambah Rute Penerbangan");
            System.out.println("5. Tampilkan Daftar Rute Penerbangan");
            System.out.println("6. Edit Rute Penerbangan");
            System.out.println("7. Hapus Rute Penerbangan");
            System.out.println("8. Keluar");

            System.out.print("Pilih opsi: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addPassenger();  // Menambahkan data passenger
                    break;
                case "2":
                    displayPassengerInfo();  // Menampilkan daftar passenger
                    break;
                case "3":
                    editPassenger();  // Mengedit data passenger
                    break;
                case "4":
                    addFlightRoute();  // Menambahkan rute penerbangan
                    break;
                case "5":
                    displayFlightRoutes();  // Menampilkan daftar rute penerbangan
                    break;
                case "6":
                    editFlightRoute();  // Mengedit rute penerbangan
                    break;
                case "7":
                    removeFlightRoute();  // Menghapus rute penerbangan
                    break;
                case "8":
                    System.out.println("Keluar dari aplikasi.");  // Keluar dari aplikasi
                    running = false;  // Menghentikan loop dan keluar dari aplikasi
                    break;
                default:
                    System.out.println("Opsi tidak valid, coba lagi.");  // Menangani input yang tidak valid
            }

        }
    }

    private void addPassenger() {
    }

    private void displayPassengerInfo() {
    }

    private void editPassenger() {
    }

}
