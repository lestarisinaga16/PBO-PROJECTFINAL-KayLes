package PassengerApp.services;

import PassengerApp.entities.FlightRoute;
import java.util.List;

public interface FlightRouteService {
    void addFlightRoute();

    void editFlightRoute();

    void removeFlightRoute();

    List<FlightRoute> getAllFlightRoutes();

}
