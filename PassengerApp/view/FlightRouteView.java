package PassengerApp.view;

import PassengerApp.entities.FlightRoute;
import PassengerApp.services.FlightRouteService;
import PassengerApp.services.FlightRouteServiceImpl;

import java.util.List;
import java.util.Scanner;

public interface FlightRouteView {

    Scanner scanner = new Scanner(System.in);
    FlightRouteService flightRouteService = new FlightRouteServiceImpl();

    public default void displayMessage(String message) {
        System.out.println(message);
    }

    public default void displayAllFlightRoutes(List<FlightRoute> routes) {
        System.out.println("ID Rute | Keberangkatan | Tujuan | Waktu Keberangkatan");
        System.out.println("--------------------------------------------");
        for (FlightRoute route : routes) {
            System.out.printf("%-8s | %-13s | %-8s | %-18s%n",
                    route.getRouteId(),
                    route.getDeparture(),
                    route.getDestination(),
                    route.getDepartureTime());
        }
    }

    public default void displayAddFlightRouteForm() {
        System.out.println("=== Tambah Rute Penerbangan ===");
    }


    public default void displayRemoveFlightRouteForm() {
        System.out.println("=== Hapus Rute Penerbangan ===");
    }

    public default void displayRemoveFlightRouteConfirmation(String routeId) {
        System.out.println("Rute penerbangan dengan ID " + routeId + " telah dihapus.");
    }

    public default String getInputRouteId() {
        System.out.print("Masukkan ID Rute: ");
        return scanner.nextLine();
    }

    public default String getInputDeparture() {
        System.out.print("Masukkan Kota Keberangkatan: ");
        return scanner.nextLine();
    }

    public default String getInputDestination() {
        System.out.print("Masukkan Kota Tujuan: ");
        return scanner.nextLine();
    }

    public default String getInputDepartureTime() {
        System.out.print("Masukkan Waktu Keberangkatan (format: HH:mm): ");
        return scanner.nextLine();
    }

    public default void displayMainMenu() {
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

    public default void addFlightRoute() {
        displayAddFlightRouteForm();
        String routeId = getInputRouteId();
        String departure = getInputDeparture();
        String destination = getInputDestination();
        String departureTime = getInputDepartureTime();

        FlightRoute newRoute = new FlightRoute(routeId, departure, destination, departureTime);
        flightRouteService.addFlightRoute(newRoute);
        System.out.println("Rute penerbangan berhasil ditambahkan!");
    }

    public abstract void displayFlightRoutes();

    void displayFlightRoute();

    public default void editFlightRoute() {
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

            FlightRoute updatedRoute = new FlightRoute(routeId, newDeparture, newDestination, newDepartureTime);
            flightRouteService.editFlightRoute(routeId, updatedRoute);
            System.out.println("Rute penerbangan berhasil diperbarui!");
        } else {
            System.out.println("Rute penerbangan dengan ID tersebut tidak ditemukan.");
        }
    }

    public default void displayEditFlightRouteForm(FlightRoute existingRoute) {
        System.out.println("ID Rute: " + existingRoute.getRouteId());
        System.out.println("Keberangkatan: " + existingRoute.getDeparture());
        System.out.println("Tujuan: " + existingRoute.getDestination());
        System.out.println("Waktu Keberangkatan: " + existingRoute.getDepartureTime());
        System.out.println("Masukkan data baru (kosongkan jika tidak ingin mengubah):");
    }

    public default void removeFlightRoute() {
        displayRemoveFlightRouteForm();
        String getInput = "";
        String routeId = getInput;
    }

    public abstract void running();
}