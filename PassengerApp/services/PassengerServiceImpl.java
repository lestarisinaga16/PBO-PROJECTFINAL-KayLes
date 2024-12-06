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
        return null;
    }

    @Override
    public Boolean removePassenger(final String idCard) {  // Menggunakan String idCard sebagai parameter
        if (idCard == null || idCard.isBlank()) {  // Cek ID Card valid
            System.out.println("ID tidak valid.");
            return false;
        }

        List<Passenger> passengers = passengerRepository.getAllPassengers();

        // Cari penumpang berdasarkan ID Card
        Passenger passengerToRemove = null;
        for (Passenger passenger : passengers) {
            // Memanggil getIdCard() pada objek passenger yang ada dalam loop
            if (passenger.getIdCard().equals(idCard)) {  // Menggunakan idCard (parameter method)
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
}
