package PassengerApp.services;

import PassengerApp.entities.Passenger;
import PassengerApp.repositories.PassengerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public void addPassenger(final Passenger passenger) {
        if (passenger == null || passenger.getName() == null || passenger.getName().isBlank()) {
            System.out.println("Masukkan data penumpang dengan benar.");
            return;
        }
        passengerRepository.addPassenger(passenger);
    }

    @Override
    public void editPassenger(int index, Passenger passenger) {
        if (passenger == null || passenger.getName() == null || passenger.getName().isBlank()) {
            System.out.println("Data penumpang tidak valid.");
            return;
        }

        List<Passenger> passengers = passengerRepository.getAllPassengers();

        // Validasi apakah index valid
        if (index < 0 || index >= passengers.size()) {
            System.out.println("Index tidak valid.");
            return;
        }

        // Update data penumpang pada repository
        passengerRepository.editPassenger(index, passenger);
        System.out.println("Data penumpang berhasil diperbarui.");
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.getAllPassengers();
    }

    @Override
    public Passenger[] getPassengerList() {
        List<Passenger> passengers = passengerRepository.getAllPassengers();
        return passengers.toArray(new Passenger[0]); // Konversi List ke Array
    }



    @Override
    public Boolean removePassenger(Integer id) {
        if (id == null || id < 0) {
            System.out.println("ID tidak valid.");
            return false;
        }

        List<Passenger> passengers = passengerRepository.getAllPassengers();

        // Cari penumpang berdasarkan ID
        Passenger passengerToRemove = null;
        for (Passenger passenger : passengers) {
            if (passenger.getId()) {  // ID dalam bentuk Integer
                passengerToRemove = passenger;
                break;
            }
        }

        if (passengerToRemove != null) {
            passengers.remove(passengerToRemove);  // Hapus penumpang
            System.out.println("Penumpang berhasil dihapus.");
            return true;
        } else {
            System.out.println("Penumpang tidak ditemukan.");
            return false;
        }
    }

    @Override
    public Boolean removePassenger(String idCard) {
        return null;
    }
}