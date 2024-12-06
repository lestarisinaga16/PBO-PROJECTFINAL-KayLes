package repositories;

import entities.Passenger;
import java.util.ArrayList;
import java.util.List;

public class PassengerRepositoryImpl implements PassengerRepository {
    private List<Passenger> passengers = new ArrayList<>();

    @Override
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    @Override
    public void editPassenger(int index, Passenger passenger) {
        passengers.set(index, passenger);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengers;
    }
}
