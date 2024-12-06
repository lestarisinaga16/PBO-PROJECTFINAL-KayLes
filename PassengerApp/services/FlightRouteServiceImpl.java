package PassengerApp.services;

import PassengerApp.entities.FlightRoute;
import PassengerApp.repositories.FlightRouteRepository;
import java.util.List;

public class FlightRouteServiceImpl implements FlightRouteService {
    private final FlightRouteRepository repository;

    // Constructor untuk inisialisasi repository
    public FlightRouteServiceImpl(FlightRouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addFlightRoute(FlightRoute flightRoute) {
        if (flightRoute == null) {
            System.out.println("Data rute penerbangan tidak valid.");
            return;
        }
        repository.addFlightRoute(flightRoute);
        System.out.println("Rute penerbangan berhasil ditambahkan.");
    }

    @Override
    public void editFlightRoute(String routeId, FlightRoute flightRoute) {
        if (routeId == null || routeId.isBlank()) {
            System.out.println("ID rute penerbangan tidak valid.");
            return;
        }

        List<FlightRoute> flightRoutes = repository.getAllFlightRoutes();
        FlightRoute routeToEdit = null;
        for (FlightRoute route : flightRoutes) {
            if (route.getRouteId().equals(routeId)) {
                routeToEdit = route;
                break;
            }
        }

        if (routeToEdit != null) {
            repository.editFlightRoute(routeId, flightRoute);
            System.out.println("Rute penerbangan berhasil diperbarui.");
        } else {
            System.out.println("Rute penerbangan tidak ditemukan.");
        }
    }

    @Override
    public void removeFlightRoute(String routeId) {
        if (routeId == null || routeId.isBlank()) {
            System.out.println("ID rute penerbangan tidak valid.");
            return;
        }

        List<FlightRoute> flightRoutes = repository.getAllFlightRoutes();
        FlightRoute routeToRemove = null;
        for (FlightRoute route : flightRoutes) {
            if (route.getRouteId().equals(routeId)) {
                routeToRemove = route;
                break;
            }
        }

        if (routeToRemove != null) {
            repository.removeFlightRoute(routeId);
            System.out.println("Rute penerbangan berhasil dihapus.");
        } else {
            System.out.println("Rute penerbangan tidak ditemukan.");
        }
    }

    @Override
    public List<FlightRoute> getAllFlightRoutes() {
        return repository.getAllFlightRoutes();
    }

    @Override
    public FlightRoute[] getFlightRouteList() {
        List<FlightRoute> flightRoutes = repository.getAllFlightRoutes();
        return flightRoutes.toArray(new FlightRoute[0]); // Konversi List ke Array
    }
}
