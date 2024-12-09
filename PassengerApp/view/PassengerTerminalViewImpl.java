package PassengerApp.view;

import PassengerApp.entities.Passenger;
import PassengerApp.entities.FlightRoute;
import PassengerApp.services.PassengerService;
import PassengerApp.services.FlightRouteService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class PassengerTerminalViewImpl {
    private final PassengerService passengerService;
    private final FlightRouteService flightRouteService;
    private final Scanner scanner;

    // Constructor
    public PassengerTerminalViewImpl(PassengerService passengerService, FlightRouteService flightRouteService) {
        this.passengerService = passengerService;
        this.flightRouteService = flightRouteService;
        this.scanner = new Scanner(System.in);
    }

    // Menampilkan info penumpang
    public void displayPassengerInfo() {
        List<Passenger> passengers = passengerService.getAllPassengers();
        if (passengers.isEmpty()) {
            System.out.println("Tidak ada data penumpang.");
        } else {
            for (int i = 0; i < passengers.size(); i++) {
                Passenger passenger = passengers.get(i);
                System.out.println((i + 1) + ". Nama: " + passenger.getName() + ", Umur: " + passenger.getAge() + ", Jenis Kelamin: " + passenger.getGender());
            }
        }
    }

    // Menambahkan penumpang
    public void addPassenger() {
        // Implementasi code untuk menambahkan penumpang
    }

    //menampilkan penumpanh
    public void displayPassenger(){

    }

    // Mengedit penumpang
    public void editPassenger() {
        // Implementasi code untuk mengedit penumpang
    }

    // Menambahkan rute penerbangan
    public void addFlightRoute() {
        // Implementasi code untuk menambahkan rute penerbangan
    }


    // Menampilkan daftar rute penerbangan
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


    // Mengedit rute penerbangan
    public void editFlightRoute() {
        // Implementasi code untuk mengedit rute penerbangan
    }

    // Menghapus rute penerbangan
    public void removeFlightRoute() {
        // Implementasi code untuk menghapus rute penerbangan
    }

    // Menampilkan menu dan menjalankan aplikasi
    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Passenger");
            System.out.println("2. Tampilkan Daftar Passenger");
            System.out.println("3. Edit Passenger");
            System.out.println("4. Tambah Rute Penerbangan");
            System.out.println("5. Tampilkan Daftar Rute Penerbangan");
            System.out.println("6. Edit Rute Penerbangan");
            System.out.println("7. Hapus Rute Penerbangan");
            System.out.println("8. Keluar");
            System.out.print("Pilih opsi: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addPassenger();
                    break;
                case "2":
                    displayPassengerInfo();
                    break;
                case "3":
                    editPassenger();
                    break;
                case "4":
                    addFlightRoute();
                    break;
                case "5":
                    displayFlightRoutes();
                    break;
                case "6":
                    editFlightRoute();
                    break;
                case "7":
                    removeFlightRoute();
                    break;
                case "8":
                    System.out.println("Keluar dari aplikasi.");
                    running = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid, coba lagi.");
            }
        }
    }
}