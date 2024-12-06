package PassengerApp.repositories;

import PassengerApp.entities.Passenger;
import java.util.List;

public interface PassengerRepository {
    void addPassenger(Passenger passenger);
    void editPassenger(int index, Passenger passenger);
    List<Passenger> getAllPassengers();
}
