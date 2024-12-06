package view;

import entities.FlightRoute;
import services.FlightRouteService;
import java.util.List;
import java.util.Scanner;

public class FlightRouteView {
    private final FlightRouteService flightRouteService;
    private final Scanner scanner;

    public FlightRouteView(FlightRouteService flightRouteService) {
        this.flightRouteService = flightRouteService;
        this.scanner = new Scanner(System.in);
    }

    public void displayFlightRoutes() {
        List<FlightRoute> flightRoutes = flightRouteService.getAllFlightRoutes();
        if (flightRoutes.isEmpty()) {
            System.out.println("Tidak ada rute penerbangan.");
        } else {
            for (int i = 0; i < flightRoutes.size(); i++) {
                FlightRoute route = flightRoutes.get(i);
                System.out.println((i + 1) + ". Rute ID: " + route.getRouteId() + ", Kota Keberangkatan: " + route.getDepartureCity() + ", Kota Tujuan: " + route.getArrivalCity());
            }
        }
    }

    public void addFlightRoute() {
        System.out.println("Masukkan ID Rute: ");
        String routeId = scanner.nextLine();
        System.out.println("Masukkan Kota Keberangkatan: ");
        String departureCity = scanner.nextLine();
        System.out.println("Masukkan Kota Tujuan: ");
        String arrivalCity = scanner.nextLine();
        System.out.println("Masukkan Waktu Keberangkatan: ");
        String departureTime = scanner.nextLine();
        System.out.println("Masukkan Waktu Kedatangan: ");
        String arrivalTime = scanner.nextLine();

        FlightRoute flightRoute = new FlightRoute(departureCity, arrivalCity, departureTime, arrivalTime, routeId);
        flightRouteService.addFlightRoute(flightRoute);
    }

    public void editFlightRoute() {
        displayFlightRoutes();
        System.out.println("Masukkan ID Rute yang akan diedit: ");
        String routeId = scanner.nextLine();
        System.out.println("Masukkan Kota Keberangkatan Baru: ");
        String departureCity = scanner.nextLine();
        System.out.println("Masukkan Kota Tujuan Baru: ");
        String arrivalCity = scanner.nextLine();
        System.out.println("Masukkan Waktu Keberangkatan Baru: ");
        String departureTime = scanner.nextLine();
        System.out.println("Masukkan Waktu Kedatangan Baru: ");
        String arrivalTime = scanner.nextLine();

        FlightRoute flightRoute = new FlightRoute(departureCity, arrivalCity, departureTime, arrivalTime, routeId);
        flightRouteService.editFlightRoute(routeId, flightRoute);
    }

    public void removeFlightRoute() {
        displayFlightRoutes();
        System.out.println("Masukkan ID Rute yang akan dihapus: ");
        String routeId = scanner.nextLine();
        flightRouteService.removeFlightRoute(routeId);
    }
}