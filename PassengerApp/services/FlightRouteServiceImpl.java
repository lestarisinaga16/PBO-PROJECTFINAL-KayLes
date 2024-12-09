package PassengerApp.services;

import PassengerApp.entities.FlightRoute;
import PassengerApp.entities.Passenger;
import PassengerApp.repositories.FlightRouteRepositoryImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class FlightRouteServiceImpl implements FlightRouteService {
    private FlightRouteRepositoryImpl flightRouteRepository;
    private Scanner input = new Scanner(System.in);


    public FlightRouteServiceImpl(FlightRouteRepositoryImpl flightRouteRepository) {
        this.flightRouteRepository = flightRouteRepository;
    }

    @Override
    public void addFlightRoute() {

        System.out.print("Masukan Kota Keberangkatan : ");
        String departureCity = input.nextLine();
        System.out.print("Masukan Kota Tujuan : ");
        String arrivalCity = input.nextLine();
        System.out.print("Masukan Tanggal Keberangkatan : ");
        String departureTime = input.nextLine();
        System.out.print("Masukan Tanggal Sampai : ");
        String arrivalTime = input.nextLine();




        FlightRoute flightRoute = new FlightRoute(departureCity,arrivalCity,departureTime,arrivalTime,0);
        flightRouteRepository.addRoute(flightRoute);
    }

    @Override
    public void editFlightRoute() {


        System.out.print("Masukan Kota Keberangkatan : ");
        String oldDepartureCity = input.nextLine();
        System.out.print("Masukan Tanggal Keberangkatan : ");
        String oldDepartureTime = input.nextLine();

        int routeID = findFlightRoute(oldDepartureCity,oldDepartureTime).getRouteId();

        System.out.print("Masukan Kota Keberangkatan Baru : ");
        String departureCity = input.nextLine();
        System.out.print("Masukan Kota Tujuan Baru : ");
        String arrivalCity = input.nextLine();
        System.out.print("Masukan Tanggal Keberangkatan Baru : ");
        String departureTime = input.nextLine();
        System.out.print("Masukan Tanggal Sampai Baru : ");
        String arrivalTime = input.nextLine();



        FlightRoute flightRoute = new FlightRoute(departureCity,arrivalCity,departureTime,arrivalTime,routeID);
        flightRouteRepository.edit(flightRoute);
    }

    private FlightRoute findFlightRoute(String departureCity, String departureTime){
        List<FlightRoute> flightRouteList = getAllFlightRoutes();
        for (FlightRoute i : flightRouteList){
            if (i.getDepartureCity().equals(departureCity) && i.getDepartureCity().equals(departureTime))return i;
        }
        return new FlightRoute(null,null,null,null,0);
    }

    @Override
    public void removeFlightRoute() {
        System.out.print("Masukan Kota Keberangkatan : ");
        String oldDepartureCity = input.nextLine();
        System.out.print("Masukan Tanggal Keberangkatan : ");
        String oldDepartureTime = input.nextLine();
        flightRouteRepository.delete(findFlightRoute(oldDepartureCity,oldDepartureTime));
    }

    @Override
    public List<FlightRoute> getAllFlightRoutes() {
        return flightRouteRepository.getAll();
    }

}
