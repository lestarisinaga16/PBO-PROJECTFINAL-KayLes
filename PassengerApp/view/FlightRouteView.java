package PassengerApp.view;

import PassengerApp.entities.FlightRoute;
import PassengerApp.services.FlightRouteService;
import PassengerApp.services.FlightRouteServiceImpl;

import java.util.List;
import java.util.Scanner;

public abstract class FlightRouteView {

    // Membuat objek Scanner di sini
    private Scanner scanner = new Scanner(System.in);
    private FlightRouteService flightRouteService = new FlightRouteServiceImpl();

    public abstract void displayMessage(String message);

    public void displayAllFlightRoutes(List<FlightRoute> routes) {
        System.out.println("ID Rute | Keberangkatan | Tujuan | Waktu Keberangkatan");
        System.out.println("--------------------------------------------");
        for (FlightRoute route : routes) {
            System.out.println(route); // Memanggil toString() untuk menampilkan informasi rute
        }
    }

    public void displayAddFlightRouteForm() {
        // Menampilkan form untuk menambahkan rute penerbangan
        System.out.println("Masukkan ID Rute:");
        // Lanjutkan inputan lainnya...
    }

    public abstract void displayRemoveFlightRouteForm();

    public abstract void displayRemoveFlightRouteConfirmation(String routeId);

    public String getInputRouteId() {
        // Mendapatkan input ID Rute dari pengguna
        return scanner.nextLine();  // Membaca input dari pengguna
    }

    public String getInputDeparture() {
        // Mendapatkan input Keberangkatan dari pengguna
        return scanner.nextLine();  // Membaca input dari pengguna
    }

    public String getInputDestination() {
        // Mendapatkan input Tujuan dari pengguna
        return scanner.nextLine();  // Membaca input dari pengguna
    }

    public String getInputDepartureTime() {
        // Mendapatkan input Waktu Keberangkatan dari pengguna
        return scanner.nextLine();  // Membaca input dari pengguna
    }

    public abstract void displayMainMenu();

    public abstract void addFlightRoute();

    public void displayFlightRoutes() {
    }

    public void displayEditFlightRouteForm(FlightRoute existingRoute) {

    }

    public abstract void displayFlightRoute();

    public abstract void editFlightRoute();

    public abstract void removeFlightRoute();

    public abstract void running();
}
