package PassengerApp.services;

import PassengerApp.entities.FlightRoute;
import java.util.ArrayList;
import java.util.List;

public class FlightRouteServiceImpl implements FlightRouteService {
    // Gunakan koleksi untuk menyimpan daftar rute penerbangan
    private final List<FlightRoute> flightRoutes = new ArrayList<>();

    @Override
    public void addFlightRoute(FlightRoute flightRoute) {
        flightRoutes.add(flightRoute);
        System.out.println("Rute penerbangan berhasil ditambahkan: " + flightRoute.getRouteId());
    }

    @Override
    public void editFlightRoute(String routeId, FlightRoute updatedRoute) {
        for (int i = 0; i < flightRoutes.size(); i++) {
            if (flightRoutes.get(i).getRouteId().equals(routeId)) {
                flightRoutes.set(i, updatedRoute);
                System.out.println("Rute penerbangan berhasil diperbarui: " + routeId);
                return;
            }
        }
        System.out.println("Rute penerbangan dengan ID " + routeId + " tidak ditemukan.");
    }

    @Override
    public void removeFlightRoute(String routeId) {
        flightRoutes.removeIf(route -> route.getRouteId().equals(routeId));
        System.out.println("Rute penerbangan berhasil dihapus: " + routeId);
    }

    @Override
    public FlightRoute[] getFlightRouteList() {
        return flightRoutes.toArray(new FlightRoute[0]);
    }

    @Override
    public List<FlightRoute> getAllFlightRoutes() {
        return new ArrayList<>(flightRoutes); // Mengembalikan salinan daftar untuk keamanan
    }
}
