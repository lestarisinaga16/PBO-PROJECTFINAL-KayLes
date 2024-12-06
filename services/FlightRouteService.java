package services;

import entities.FlightRoute;
import repositories.FlightRouteRepository;
import java.util.List;

public class FlightRouteService {
    private final FlightRouteRepository repository;

    public FlightRouteService(FlightRouteRepository repository) {
        this.repository = repository;
    }

    public void addFlightRoute(FlightRoute flightRoute) {
        repository.addFlightRoute(flightRoute);
    }

    public void editFlightRoute(String routeId, FlightRoute flightRoute) {
        repository.editFlightRoute(routeId, flightRoute);
    }

    public void removeFlightRoute(String routeId) {
        repository.removeFlightRoute(routeId);
    }

    public List<FlightRoute> getAllFlightRoutes() {
        return repository.getAllFlightRoutes();
    }
}
