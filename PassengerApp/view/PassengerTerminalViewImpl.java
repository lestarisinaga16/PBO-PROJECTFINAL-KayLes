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

        Passenger passenger = new Passenger(name, age, gender, passportNumber, idCardNumber);
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
            System.out.println("\nMENU:");
            System.out.println("1. Tambah Data Penumpang");
            System.out.println("2. Tampilkan Daftar Penumpang");
            System.out.println("3. Edit Data Penumpang");
            System.out.println("4. Keluar");

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
                    System.out.println("Keluar dari aplikasi.");
                    running = false;  // Keluar dari loop
                    break;
                default:
                    System.out.println("Opsi tidak valid, coba lagi.");
            }
        }
    }
}
