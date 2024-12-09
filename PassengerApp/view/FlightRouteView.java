package PassengerApp.view;

import PassengerApp.entities.FlightRoute;
import PassengerApp.services.FlightRouteService;
import PassengerApp.services.FlightRouteServiceImpl;

import java.util.List;
import java.util.Scanner;

public interface FlightRouteView {

    Scanner scanner = new Scanner(System.in);
    FlightRouteService flightRouteService = new FlightRouteServiceImpl();

    // Menampilkan pesan kepada pengguna
    default void displayMessage(String message) {
        System.out.println(message);
    }

    // Menampilkan daftar semua rute penerbangan
    default void displayAllFlightRoutes(List<FlightRoute> routes) {
        if (routes.isEmpty()) {
            System.out.println("Belum ada rute penerbangan yang ditambahkan.");
            return;
        }
        System.out.println("ID Rute | Keberangkatan  | Tujuan       | Waktu Keberangkatan");
        System.out.println("------------------------------------------------------------");
        for (FlightRoute route : routes) {
            System.out.printf("%-8s | %-14s | %-12s | %-20s%n",
                    route.getRouteId(),
                    route.getDeparture(),
                    route.getDestination(),
                    route.getDepartureTime());
        }
    }

    // Form untuk menambahkan rute penerbangan
    default void displayAddFlightRouteForm() {
        System.out.println("=== Tambah Rute Penerbangan ===");
        String routeId = getInputRouteId();
        String departure = getInputDeparture();
        String destination = getInputDestination();
        String departureTime = getInputDepartureTime();

        FlightRoute newRoute = new FlightRoute(routeId, departure, destination, departureTime);
        flightRouteService.addFlightRoute(newRoute);
        displayMessage("Rute penerbangan berhasil ditambahkan!");
    }

    // Form untuk menghapus rute penerbangan
    default void displayRemoveFlightRouteForm() {
        System.out.println("=== Hapus Rute Penerbangan ===");
        String routeId = getInputRouteId();

        // Hapus rute dari service
        flightRouteService.removeFlightRoute(routeId);
        displayRemoveFlightRouteConfirmation(routeId);
    }

    // Konfirmasi penghapusan rute
    default void displayRemoveFlightRouteConfirmation(String routeId) {
        displayMessage("Rute penerbangan dengan ID " + routeId + " telah dihapus.");
    }

    // Menampilkan menu utama
    default void displayMainMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Data Passenger");
        System.out.println("2. Tampilkan Daftar Passenger");
        System.out.println("3. Edit Passenger");
        System.out.println("4. Tambah Rute Penerbangan");
        System.out.println("5. Tampilkan Daftar Rute Penerbangan");
        System.out.println("6. Edit Rute Penerbangan");
        System.out.println("7. Hapus Rute Penerbangan");
        System.out.println("8. Keluar");
    }

    // Menambahkan rute penerbangan
    default void addFlightRoute() {
        displayAddFlightRouteForm();
    }

    // Menampilkan daftar rute penerbangan
    default void displayFlightRoutes() {
        List<FlightRoute> routes = flightRouteService.getAllFlightRoutes();
        displayAllFlightRoutes(routes);
    }

    void displayFlightRoute();

    // Mengedit rute penerbangan
    default void editFlightRoute() {
        System.out.println("=== Edit Rute Penerbangan ===");
        String routeId = getInputRouteId();
        FlightRoute existingRoute = flightRouteService.getAllFlightRoutes().stream()
                .filter(route -> route.getRouteId().equals(routeId))
                .findFirst()
                .orElse(null);

        if (existingRoute != null) {
            displayEditFlightRouteForm(existingRoute);
            String newDeparture = getInputDeparture();
            String newDestination = getInputDestination();
            String newDepartureTime = getInputDepartureTime();

            // Jika input kosong, gunakan nilai lama
            String updatedDeparture = newDeparture.isEmpty() ? existingRoute.getDeparture() : newDeparture;
            String updatedDestination = newDestination.isEmpty() ? existingRoute.getDestination() : newDestination;
            String updatedDepartureTime = newDepartureTime.isEmpty() ? existingRoute.getDepartureTime() : newDepartureTime;

            FlightRoute updatedRoute = new FlightRoute(routeId, updatedDeparture, updatedDestination, updatedDepartureTime);
            flightRouteService.editFlightRoute(routeId, updatedRoute);
            System.out.println("Rute penerbangan berhasil diperbarui!");
        } else {
            System.out.println("Rute penerbangan dengan ID tersebut tidak ditemukan.");
        }
    }

    // Form untuk mengedit rute penerbangan
    default void displayEditFlightRouteForm(FlightRoute existingRoute) {
        System.out.println("ID Rute: " + existingRoute.getRouteId());
        System.out.println("Keberangkatan: " + existingRoute.getDeparture());
        System.out.println("Tujuan: " + existingRoute.getDestination());
        System.out.println("Waktu Keberangkatan: " + existingRoute.getDepartureTime());
        System.out.println("Masukkan data baru (kosongkan jika tidak ingin mengubah):");
    }

    // Menghapus rute penerbangan
    default void removeFlightRoute() {
        displayRemoveFlightRouteForm();
    }

    // Input untuk ID rute
    default String getInputRouteId() {
        System.out.print("Masukkan ID Rute: ");
        return scanner.nextLine().trim();
    }

    // Input untuk kota keberangkatan
    default String getInputDeparture() {
        System.out.print("Masukkan Kota Keberangkatan: ");
        return scanner.nextLine().trim();
    }

    // Input untuk kota tujuan
    default String getInputDestination() {
        System.out.print("Masukkan Kota Tujuan: ");
        return scanner.nextLine().trim();
    }

    // Input untuk waktu keberangkatan
    default String getInputDepartureTime() {
        System.out.print("Masukkan Waktu Keberangkatan (format: HH:mm): ");
        return scanner.nextLine().trim();
    }


    // Metode abstrak untuk implementasi menu utama
    void running();
}