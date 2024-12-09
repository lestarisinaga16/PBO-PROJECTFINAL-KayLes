package PassengerApp.repositories;

import PassengerApp.entities.Passenger;
import java.util.List;

public interface PassengerRepository {
    void addPassenger(Passenger passenger);
    void delete(Passenger passenger);
    void edit(Passenger passenger, String oldIDCard);
    List<Passenger> getAll();
}
