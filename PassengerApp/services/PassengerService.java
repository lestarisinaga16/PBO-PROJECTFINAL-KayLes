package PassengerApp.services;

import PassengerApp.entities.Passenger;
import PassengerApp.repositories.PassengerRepository;
import java.util.List;

public class PassengerService {
    private final PassengerRepository repository;

    public PassengerService(PassengerRepository repository) {
        this.repository = repository;
    }

    public void addPassenger(Passenger passenger) {
        repository.addPassenger(passenger);
    }

    public void editPassenger(int index, Passenger passenger) {
        repository.editPassenger(index, passenger);
    }

    public List<Passenger> getAllPassengers() {
        return repository.getAllPassengers();
    }
}
