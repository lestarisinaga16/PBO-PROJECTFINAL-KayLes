package repositories;

import entities.FlightRoute;
import java.util.List;

public interface FlightRouteRepository {
    void addFlightRoute(FlightRoute flightRoute);
    void editFlightRoute(String routeId, FlightRoute flightRoute);
    void removeFlightRoute(String routeId);
    List<FlightRoute> getAllFlightRoutes();
}
