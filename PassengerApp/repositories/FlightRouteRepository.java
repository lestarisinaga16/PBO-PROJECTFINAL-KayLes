package PassengerApp.repositories;

import PassengerApp.entities.FlightRoute;
import java.util.List;

public interface FlightRouteRepository {
    void addRoute(FlightRoute flightRoute);
    void edit(FlightRoute flightRoute);
    void delete(FlightRoute flightRoute);
    List<FlightRoute> getAll();
}
