package PassengerApp.view;

import PassengerApp.entities.Passenger;
import java.util.List;

public interface PassengerView {

    // Menampilkan pesan atau informasi ke pengguna
    void displayMessage(String message);

    // Menampilkan daftar penumpang
    void displayAllPassengers(List<Passenger> passengers);

    // Menampilkan tampilan untuk menambah penumpang
    void displayAddPassengerForm();

    // Menampilkan tampilan untuk mengedit penumpang
    void displayEditPassengerForm(Passenger passenger);

    // Menampilkan tampilan untuk menghapus penumpang
    void displayRemovePassengerForm();

    // Menampilkan konfirmasi penghapusan penumpang
    void displayRemovePassengerConfirmation(String idCard);

    // Mengambil input nama penumpang
    String getInputName();

    // Mengambil input usia penumpang
    String getInputAge();

    // Mengambil input jenis kelamin penumpang
    String getInputGender();

    // Mengambil input nomor paspor penumpang
    String getInputPassport();

    // Mengambil input nomor KTP penumpang
    String getInputIdCard();

    // Menampilkan menu utama atau pilihan-pilihan lain kepada pengguna
    void displayMainMenu();

    void addPassenger();

    void displayPassengerInfo();

    void editPassenger();

    void running();
}
