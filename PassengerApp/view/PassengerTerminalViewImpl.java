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

    public PassengerTerminalViewImpl(PassengerService passengerService) {
        this.passengerService = passengerService;
        this.scanner = new Scanner(System.in);
    }

    public PassengerTerminalViewImpl(PassengerService passengerService, Scanner scanner) {
        this.passengerService = passengerService;
        this.scanner = scanner;
    }

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

    // Menambahkan menu utama dalam metode run()
    public void run() {
        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Tambah Data Passenger");
            System.out.println("2. Tampilkan Daftar Data Passenger");
            System.out.println("3. Tampilkan Daftar Rute");
            System.out.println("4. Tambah Rute Penerbangan");
            System.out.println("5. Edit Rute Penerbangan");
            System.out.println("6. Hapus Rute Penerbangan");
            System.out.println("7. Edit Informasi Pemesan");
            System.out.println("8. Keluar dari Sistem");
            System.out.println("Sistem ini dirancang oleh Kayla & Lestari");

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
                    System.out.println("Tampilkan Daftar Rute");
                    // Panggil method untuk menampilkan daftar rute
                    break;
                case "4":
                    System.out.println("Tambah Rute Penerbangan");
                    // Panggil method untuk menambah rute penerbangan
                    break;
                case "5":
                    System.out.println("Edit Rute Penerbangan");
                    // Panggil method untuk mengedit rute penerbangan
                    break;
                case "6":
                    System.out.println("Hapus Rute Penerbangan");
                    // Panggil method untuk menghapus rute penerbangan
                    break;
                case "7":
                    editPassenger();
                    break;
                case "8":
                    System.out.println("Keluar dari sistem.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opsi tidak valid, coba lagi.");
            }
        }
    }
}
