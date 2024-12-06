package PassengerApp.view;

import PassengerApp.entities.FlightRoute;
import java.util.List;

public interface FlightRouteView {

    // Menampilkan pesan atau informasi kepada pengguna
    void displayMessage(String message);

    // Menampilkan daftar rute penerbangan
    void displayAllFlightRoutes(List<FlightRoute> flightRoutes);

    // Menampilkan form untuk menambahkan rute penerbangan
    void displayAddFlightRouteForm();

    // Menampilkan form untuk mengedit rute penerbangan yang ada
    void displayEditFlightRouteForm(FlightRoute flightRoute);

    // Menampilkan form untuk menghapus rute penerbangan
    void displayRemoveFlightRouteForm();

    // Mengonfirmasi penghapusan rute penerbangan
    void displayRemoveFlightRouteConfirmation(String routeId);

    // Mengambil input ID rute penerbangan dari pengguna
    String getInputRouteId();

    // Mengambil input asal (departure) rute penerbangan
    String getInputDeparture();

    // Mengambil input tujuan (destination) rute penerbangan
    String getInputDestination();

    // Mengambil input waktu keberangkatan (departure time) rute penerbangan
    String getInputDepartureTime();

    // Menampilkan menu utama atau pilihan-pilihan lain untuk pengelolaan rute penerbangan
    void displayMainMenu();

    void addFlightRoute();

    void displayFlightRoutes();

    void editFlightRoute();

    void removeFlightRoute();

    void running();
}
