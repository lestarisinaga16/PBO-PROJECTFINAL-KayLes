package PassengerApp.services;

import PassengerApp.entities.FlightRoute;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightRouteServiceImpl implements FlightRouteService {

    // List untuk menyimpan data rute penerbangan
    private List<FlightRoute> flightRoutes = new ArrayList<>();

    @Override
    public void addFlightRoute(FlightRoute flightRoute) {
        flightRoutes.add(flightRoute);
    }

    @Override
    public void editFlightRoute(String routeId, FlightRoute updatedRoute) {
        // Mencari rute berdasarkan routeId
        Optional<FlightRoute> existingRouteOpt = flightRoutes.stream()
                .filter(route -> route.getRouteId().equals(routeId))
                .findFirst();

        if (existingRouteOpt.isPresent()) {
            FlightRoute existingRoute = existingRouteOpt.get();
            existingRoute.setDeparture(updatedRoute.getDeparture());
            existingRoute.setDestination(updatedRoute.getDestination());
            existingRoute.setDepartureTime(updatedRoute.getDepartureTime());
        }
    }

    @Override
    public void removeFlightRoute(String routeId) {
        // Mencari rute berdasarkan routeId dan menghapusnya
        flightRoutes.removeIf(route -> route.getRouteId().equals(routeId));
    }

    @Override
    public List<FlightRoute> getAllFlightRoutes() {
        return new ArrayList<>(flightRoutes);  // Mengembalikan salinan daftar rute penerbangan
    }

    @Override
    public FlightRoute[] getFlightRouteList() {
        return flightRoutes.toArray(new FlightRoute[0]); // Mengembalikan array dari daftar rute
    }
}
