package PassengerApp.view;

import PassengerApp.entities.Passenger;
import java.util.List;

public interface PassengerView {

    // Menampilkan daftar penumpang
    void displayAllPassengers(List<Passenger> passengers);

    // Menampilkan menu utama atau pilihan-pilihan lain kepada pengguna
    void displayMainMenu();
}
