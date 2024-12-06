package view;

import entities.Passenger;
import org.springframework.stereotype.Component;
import services.PassengerService;
import java.util.List;
import java.util.Scanner;
@Component
public class PassengerView {
    private final PassengerService passengerService;
    private final Scanner scanner;

    public PassengerView(PassengerService passengerService) {
        this.passengerService = passengerService;
        this.scanner = new Scanner(System.in);
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
}
