package PassengerApp.services;

import PassengerApp.entities.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerServiceImpl implements PassengerService {
    private List<Passenger> passengers = new ArrayList<>();

    @Override
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    @Override
    public void editPassenger(int index, Passenger passenger) {
        if (index >= 0 && index < passengers.size()) {
            passengers.set(index, passenger);
        } else {
            System.out.println("Index tidak valid!");
        }
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengers;
    }

    @Override
    public Passenger[] getPassengerList() {
        return passengers.toArray(new Passenger[0]);
    }

    @Override
    public int removePassenger(Integer id) {
        // Tidak ada id dalam class Passenger, kita menggunakan idCard
        return 0;
    }

    @Override
    public Boolean removePassenger(String idCard) {
        return passengers.removeIf(passenger -> passenger.getIdCard().equals(idCard));
    }

    @Override
    public int get(int index) {
        if (index >= 0 && index < passengers.size()) {
            return 0;
        }
        return 0; // Jika indeks tidak valid
    }

    @Override
    public int size() {
        return passengers.size(); // Mengembalikan jumlah penumpang
    }

    @Override
    public void updatePassenger(Passenger passengerToEdit) {

    }
}
