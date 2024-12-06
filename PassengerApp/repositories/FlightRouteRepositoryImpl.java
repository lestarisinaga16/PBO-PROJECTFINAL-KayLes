package PassengerApp.repositories;

import PassengerApp.entities.FlightRoute;
import java.util.ArrayList;
import java.util.List;

public class FlightRouteRepositoryImpl implements FlightRouteRepository {
    private List<FlightRoute> flightRoutes = new ArrayList<>();

    @Override
    public void addFlightRoute(FlightRoute flightRoute) {
        flightRoutes.add(flightRoute);
    }

    @Override
    public void editFlightRoute(String routeId, FlightRoute flightRoute) {
        for (int i = 0; i < flightRoutes.size(); i++) {
            if (flightRoutes.get(i).getRouteId().equals(routeId)) {
                flightRoutes.set(i, flightRoute);
                break;
            }
        }
    }

    @Override
    public void removeFlightRoute(String routeId) {
        flightRoutes.removeIf(route -> route.getRouteId().equals(routeId));
    }

    @Override
    public List<FlightRoute> getAllFlightRoutes() {
        return flightRoutes;
    }
}
