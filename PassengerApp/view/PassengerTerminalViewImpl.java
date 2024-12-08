package PassengerApp.view;

import PassengerApp.entities.Passenger;
import PassengerApp.services.PassengerService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class PassengerTerminalViewImpl {
    private final PassengerService passengerService;
    private final Scanner scanner;

    // Constructor
    public PassengerTerminalViewImpl(PassengerService passengerService) {
        this.passengerService = passengerService;
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
        System.out.println("Masukkan Nama: ");
        String name = scanner.nextLine();
        System.out.println("Masukkan Umur: ");
        String age = scanner.nextLine();
        System.out.println("Masukkan Jenis Kelamin: ");
        String gender = scanner.nextLine();
        System.out.println("Masukkan Nomor Paspor: ");
        String passportNumber = scanner.nextLine();
        System.out.println("Masukkan Nomor KTP: ");
        String idCardNumber = scanner.nextLine();

        int umur = 0;
        Passenger passenger = new Passenger(name, age, gender, passportNumber, idCardNumber);
        System.out.println("Penumpang baru akan ditambahkan: " + passenger.getName());
        passengerService.addPassenger(passenger);
    }

    // Mengedit penumpang
    public void editPassenger() {
        displayPassengerInfo();
        System.out.println("Pilih nomor penumpang yang akan diedit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline

        if (index < 0 || index >= passengerService.getAllPassengers().size()) {
            System.out.println("Data tidak valid.");
            return;
        }

        System.out.println("Masukkan Nama Baru: ");
        String name = scanner.nextLine();
        System.out.println("Masukkan Umur Baru: ");
        String age = scanner.nextLine();
        System.out.println("Masukkan Jenis Kelamin Baru: ");
        String gender = scanner.nextLine();
        System.out.println("Masukkan Nomor Paspor Baru: ");
        String passportNumber = scanner.nextLine();
        System.out.println("Masukkan Nomor KTP Baru: ");
        String idCardNumber = scanner.nextLine();

        Passenger passenger = new Passenger(name, age, gender, passportNumber, idCardNumber);
        passengerService.editPassenger(index, passenger);
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
                    addPassenger();  // Menambahkan passenger
                    break;
                case "2":
                    displayPassengerInfo();  // Menampilkan daftar passenger
                    break;
                case "3":
                    editPassenger();  // Mengedit data passenger
                    break;
                case "4":
                    addRoutePassenger();  // Menambahkan rute penerbangan
                    break;
                case "5":
                    displayFlightRoutes();  // Menampilkan daftar rute penerbangan
                    break;
                case "6":
                    editFlightRoute();  // Mengedit rute penerbangan
                    break;
                case "7":
                    removeFlightRoute();  // Menghapus rute penerbangan
                    break;
                case "8":
                    System.out.println("Keluar dari aplikasi.");
                    running = false;  // Keluar dari loop
                    break;
                default:
                    System.out.println("Opsi tidak valid, coba lagi.");
            }
        }
    }

    private void addRoutePassenger() {
    }

    private void displayFlightRoutes() {
    }

    private void editFlightRoute() {
    }

    private void removeFlightRoute() {
    }
}