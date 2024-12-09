package PassengerApp.services;

import PassengerApp.entities.FlightRoute;
import PassengerApp.entities.Passenger;
import java.util.List;

public interface PassengerService {
    void addPassenger(int flightRouteID);

    List<Passenger> getAllPassengers();

    void editPassenger(int flightRouteID);

    void removePassenger();


}
