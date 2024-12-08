package PassengerApp.services;

import PassengerApp.entities.FlightRoute;
import java.util.List;

public interface FlightRouteService {
    void addFlightRoute(FlightRoute flightRoute);

    void editFlightRoute(String routeId, FlightRoute flightRoute);

    void removeFlightRoute(String routeId);

    List<FlightRoute> getAllFlightRoutes();

    FlightRoute[] getFlightRouteList();

    public List<FlightRoute> getAllFlightRoutes() {
        // Pastikan ini mengembalikan daftar rute penerbangan yang sudah ditambahkan
        List<FlightRoute> flightRoutes = List.of();
        return flightRoutes;  // flightRoutes adalah koleksi yang menyimpan data rute penerbangan
    }

}
