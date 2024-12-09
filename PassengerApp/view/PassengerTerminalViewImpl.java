package PassengerApp.view;

import PassengerApp.entities.FlightRoute;
import PassengerApp.entities.Passenger;
import PassengerApp.services.FlightRouteServiceImpl;
import PassengerApp.services.PassengerServiceImpl;

import java.util.List;
import java.util.Scanner;

public class TerminalView {
    FlightRouteServiceImpl flightRouteService;
    PassengerServiceImpl passengerService;

    public TerminalView(FlightRouteServiceImpl flightRouteService, PassengerServiceImpl passengerService) {
        this.flightRouteService = flightRouteService;
        this.passengerService = passengerService;
    }

    Scanner input = new Scanner(System.in);
    @Override
    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Welcome to the Flight Ticket Ordering App\n");
            System.out.println("1. Passenger Menu");
            System.out.println("2. Admin Menu");
            System.out.println("3. Exit");
            System.out.print ("Select an option: ");
            int selectedMenu = input.nextInt();
            switch (selectedMenu) {
                case 1:
                    customerMenu();
                    break;
                case 2:
                    adminMenu();
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }

    private void customerMenu(){
        boolean isRunning = true;
        while (isRunning) {
            int flightID = -1;
            System.out.println("Welcome to the Flight Ticket Ordering Passenger Menu\n");
            System.out.println("1. Order Flight Ticket");
            System.out.println("2. Edit Order Flight Ticket");
            System.out.println("3. Delete Order Flight Ticket");
            System.out.println("4. Exit");
            System.out.print ("Select an option: ");
            int selectedMenu = input.nextInt();
            switch (selectedMenu) {
                case 1:
                    viewFlightRoute();
                    System.out.print("Select Flight ID : ");
                    flightID = input.nextInt();
                    passengerService.addPassenger(flightID);
                    break;
                case 2:
                    viewFlightRoute();
                    System.out.print("Select Flight ID : ");
                    flightID = input.nextInt();
                    passengerService.editPassenger(flightID);
                    break;
                case 4:
                    passengerService.removePassenger();
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }

    private void adminMenu(){
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Welcome to the Flight Ticket Ordering Admin Menu\n");
            System.out.println("1. Add Flight Route");
            System.out.println("2. Edit Flight Route");
            System.out.println("3. Delete Flight Route");
            System.out.println("4. View Flight Route");
            System.out.println("5. View Passenger");
            System.out.println("6. Exit");
            System.out.print ("Select an option: ");
            int selectedMenu = input.nextInt();
            switch (selectedMenu) {
                case 1:
                    flightRouteService.addFlightRoute();
                    break;
                case 2:
                    flightRouteService.editFlightRoute();
                    break;
                case 3:
                    flightRouteService.removeFlightRoute();
                    break;
                case 4:
                    viewFlightRoute();
                    break;
                case 5:
                    viewPassenger();
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }

    void viewFlightRoute(){
        int nums = 1;
        List<FlightRoute>flightRouteList = flightRouteService.getAllFlightRoutes();
        System.out.println("no.\tdeparture city\tarrival city\tdeparture time\tarrival time\t route id");
        for (FlightRoute i : flightRouteList){
            System.out.println(nums + ".\t" + i.getDepartureCity() + "\t" + i.getArrivalCity() + "\t" + i.getDepartureTime() + "\t" + i.getArrivalTime() + "\t" + i.getRouteId());
            nums++;
        }
    }

    void viewPassenger(){
        int nums = 1;
        List<Passenger>passengerList = passengerService.getAllPassengers();
        System.out.println("no.\tname\tage\tgender\tpassport\t route id\tno KTP");
        for (Passenger i : passengerList){
            System.out.println(nums + ".\t" + i.getName() + "\t" + i.getAge() + "\t" + i.getGender() + "\t" + i.getPassport() + "\t" + i.getFlightRouteID() + "\t" + i.getIdCard());
            nums++;
        }
    }



}
