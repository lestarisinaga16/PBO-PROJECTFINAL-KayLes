package PassengerApp.services;

import PassengerApp.entities.Passenger;
import java.util.List;

public interface PassengerService {
    void addPassenger(Passenger passenger);

    void editPassenger(int index, Passenger passenger);

    List<Passenger> getAllPassengers();

    Passenger[] getPassengerList();

    Boolean removePassenger(Integer id);

    Boolean removePassenger(String idCard);

    // Menambahkan metode untuk mengakses penumpang berdasarkan indeks
    Passenger get(int index);

    // Menambahkan metode untuk mendapatkan jumlah penumpang
    int size();

    void updatePassenger(Passenger passengerToEdit);
}
