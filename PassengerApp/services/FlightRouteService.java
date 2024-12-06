package PassengerApp.services;

import PassengerApp.entities.FlightRoute;
import java.util.List;

public interface FlightRouteService {
    void addFlightRoute(FlightRoute flightRoute);

    void editFlightRoute(String routeId, FlightRoute flightRoute);

    void removeFlightRoute(String routeId);

    List<FlightRoute> getAllFlightRoutes();

    FlightRoute[] getFlightRouteList();
}
