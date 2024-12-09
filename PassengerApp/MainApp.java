package PassengerApp;

import PassengerApp.config.Database;
import PassengerApp.entities.FlightRoute;
import PassengerApp.entities.Passenger;
import PassengerApp.services.FlightRouteService;
import PassengerApp.services.PassengerService;
import org.springframework.context.annotation.ComponentScan;
import PassengerApp.repositories.PassengerRepositoryImpl;
import PassengerApp.repositories.FlightRouteRepositoryImpl;
import PassengerApp.view.PassengerView;
import PassengerApp.view.FlightRouteView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@ComponentScan(basePackages = "PassengerApp")
public class MainApp {
    public static void main(String[] args) {
        int index = 0;
        // Initialize the database connection
        Database database = new Database(); // This will automatically connect to the database

        // Initialize repositories and services
        PassengerRepositoryImpl passengerRepository = new PassengerRepositoryImpl();
        FlightRouteRepositoryImpl flightRouteRepository = new FlightRouteRepositoryImpl();

        class Application {
            public static void main(String[] args) {
                FlightRouteService flightRouteService = new FlightRouteService() {
                    @Override
                    public void addFlightRoute(FlightRoute flightRoute) {

                    }

                    @Override
                    public void editFlightRoute(String routeId, FlightRoute flightRoute) {

                    }

                    @Override
                    public void removeFlightRoute(String routeId) {

                    }

                    @Override
                    public List<FlightRoute> getAllFlightRoutes() {
                        return List.of();
                    }

                    @Override
                    public FlightRoute[] getFlightRouteList() {
                        return new FlightRoute[0];
                    }
                };
                FlightRouteView flightRouteView = new FlightRouteView() {
                    @Override
                    public void displayMessage(String message) {

                    }

                    @Override
                    public void displayAllFlightRoutes(List<FlightRoute> flightRoutes) {

                    }

                    @Override
                    public void displayAddFlightRouteForm() {

                    }

                    @Override
                    public void displayEditFlightRouteForm(FlightRoute flightRoute) {

                    }

                    @Override
                    public void displayFlightRoute() {

                    }

                    @Override
                    public void displayRemoveFlightRouteForm() {

                    }

                    @Override
                    public void displayRemoveFlightRouteConfirmation(String routeId) {

                    }

                    @Override
                    public String getInputRouteId() {
                        return "";
                    }

                    @Override
                    public String getInputDeparture() {
                        return "";
                    }

                    @Override
                    public String getInputDestination() {
                        return "";
                    }

                    @Override
                    public String getInputDepartureTime() {
                        return "";
                    }

                    @Override
                    public void displayMainMenu() {

                    }

                    @Override
                    public void addFlightRoute() {

                    }

                    @Override
                    public void displayFlightRoutes() {

                    }

                    @Override
                    public void editFlightRoute() {

                    }

                    @Override
                    public void removeFlightRoute() {

                    }

                    @Override
                    public void running() {

                    }
                };

                // Misalnya menambah rute penerbangan melalui menu
                String arrivalTime = "";
                flightRouteService.addFlightRoute(new FlightRoute("1", "Medan", "Jakarta", "10:00"));
                flightRouteService.addFlightRoute(new FlightRoute("2", "Manado", "Jakarta", "14:00"));

                // Menampilkan daftar rute penerbangan
                flightRouteView.displayAllFlightRoutes(flightRouteService.getAllFlightRoutes());
            }
        }


        PassengerService passengerService = new PassengerService() {
            private List<Passenger> passengers = new ArrayList<>();

            @Override
            public void addPassenger(Passenger passenger) {
                passengers.add(passenger);
                System.out.println("Passenger berhasil ditambahkan.");
            }

            @Override
            public void editPassenger(int index, Passenger passenger) {
                if (index >= 0 && index < passengers.size()) {
                    passengers.set(index, passenger);
                    System.out.println("Passenger berhasil diperbarui.");
                } else {
                    System.out.println("Index tidak valid.");
                }
            }


            @Override
            public List<Passenger> getAllPassengers() {
                return passengers;
            }

            @Override
            public Passenger[] getPassengerList() {
                return passengers.toArray(new Passenger[0]);
            }

            @Override
            public int removePassenger(Integer id) {
                return 0;
            }

            @Override
            public Boolean removePassenger(String idCard) {
                return passengers.removeIf(p -> p.getIdCard().equals(idCard));  // Memanggil getIdCard() pada objek p
            }

            @Override
            public int get(int index) {
                return 0;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public void updatePassenger(Passenger passengerToEdit) {

            }


        };

        FlightRouteService flightRouteService = new FlightRouteService() {
            private List<FlightRoute> flightRoutes = new ArrayList<>();

            @Override
            public void addFlightRoute(FlightRoute flightRoute) {
                flightRoutes.add(flightRoute);
                System.out.println("Rute penerbangan berhasil ditambahkan.");
            }

            @Override
            public void editFlightRoute(String routeId, FlightRoute flightRoute) {
                for (int i = 0; i < flightRoutes.size(); i++) {
                    if (flightRoutes.get(i).getRouteId().equals(routeId)) {
                        flightRoutes.set(i, flightRoute);
                        System.out.println("Rute penerbangan berhasil diperbarui.");
                        return;
                    }
                }
                System.out.println("Rute dengan ID tersebut tidak ditemukan.");
            }

            @Override
            public void removeFlightRoute(String routeId) {
                if (flightRoutes.removeIf(route -> route.getRouteId().equals(routeId))) {
                    System.out.println("Rute penerbangan berhasil dihapus.");
                } else {
                    System.out.println("Rute dengan ID tersebut tidak ditemukan.");
                }
            }

            @Override
            public List<FlightRoute> getAllFlightRoutes() {
                return flightRoutes;
            }

            @Override
            public FlightRoute[] getFlightRouteList() {
                return flightRoutes.toArray(new FlightRoute[0]);
            }
        };

        PassengerView passengerView = new PassengerView() {
            @Override
            public void displayMessage(String message) {

            }

            @Override
            public void displayAllPassengers(List<Passenger> passengers) {
                if (passengers.isEmpty()) {
                    System.out.println("Belum ada data penumpang.");
                } else {
                    for (Passenger p : passengers) {
                        System.out.println(p);
                    }
                }
            }

            @Override
            public void displayAddPassengerForm() {
                System.out.println("=== Tambah Data Passenger ===");
            }

            @Override
            public void displayEditPassengerForm(Passenger passenger) {
                System.out.println("=== Edit Data Passenger ===");
            }

            @Override
            public void displayRemovePassengerForm() {
                System.out.println("=== Hapus Data Passenger ===");
            }

            @Override
            public void displayRemovePassengerConfirmation(String idCard) {

            }

            @Override
            public String getInputName() {
                return "";
            }

            @Override
            public String getInputAge() {
                return "";
            }

            @Override
            public String getInputGender() {
                return "";
            }

            @Override
            public String getInputPassport() {
                return "";
            }

            @Override
            public String getInputIdCard() {
                return "";
            }

            @Override
            public void displayMainMenu() {
                System.out.println("Menu:");
                System.out.println("1. Tambah Data Passenger");
                System.out.println("2. Tampilkan Daftar Passenger");
                System.out.println("3. Edit Passenger");
                System.out.println("4. Tambah Rute Penerbangan");
                System.out.println("5. Tampilkan Daftar Rute Penerbangan");
                System.out.println("6. Edit Rute Penerbangan");
                System.out.println("7. Hapus Rute Penerbangan");
                System.out.println("8. Keluar");
            }

            @Override
            public void addPassenger() {

            }

            @Override
            public void displayPassengerInfo() {

            }

            @Override
            public void editPassenger() {

            }

            @Override
            public void running() {

            }

            @Override
            public String getInputBirthDate() {
                return "";
            }
        };

        FlightRouteView flightRouteView = new FlightRouteView() {
            @Override
            public void displayMessage(String message) {

            }

            @Override
            public void displayFlightRoutes() {
                // Ambil semua rute penerbangan
                List<FlightRoute> routes = flightRouteService.getAllFlightRoutes();

                // Periksa apakah ada rute yang tersedia
                if (routes.isEmpty()) {
                    System.out.println("Belum ada rute penerbangan.");
                } else {
                    // Tampilkan daftar rute penerbangan
                    System.out.println("ID Rute | Keberangkatan | Tujuan | Waktu Keberangkatan");
                    System.out.println("--------------------------------------------");
                    for (FlightRoute route : routes) {
                        System.out.println(route);  // Menampilkan informasi rute penerbangan dengan toString()
                    }
                }
            }

            @Override
            public void displayAddFlightRouteForm() {
                System.out.println("=== Tambah Rute Penerbangan ===");
            }

            @Override
            public void displayEditFlightRouteForm(FlightRoute flightRoute) {
                System.out.println("=== Edit Rute Penerbangan ===");
            }

            @Override
            public void displayRemoveFlightRouteForm() {
                System.out.println("=== Hapus Rute Penerbangan ===");
            }

            @Override
            public void displayRemoveFlightRouteConfirmation(String routeId) {

            }

            @Override
            public String getInputRouteId() {
                return "";
            }

            @Override
            public String getInputDeparture() {
                return "";
            }

            @Override
            public String getInputDestination() {
                return "";
            }

            @Override
            public String getInputDepartureTime() {
                return "";
            }

            @Override
            public void displayMainMenu() {
                System.out.println("Menu:");
                System.out.println("1. Tambah Data Passenger");
                System.out.println("2. Tampilkan Daftar Passenger");
                System.out.println("3. Edit Passenger");
                System.out.println("4. Tambah Rute Penerbangan");
                System.out.println("5. Tampilkan Daftar Rute Penerbangan");
                System.out.println("6. Edit Rute Penerbangan");
                System.out.println("7. Hapus Rute Penerbangan");
                System.out.println("8. Keluar");
            }

            @Override
            public void addFlightRoute() {

            }

            @Override
            public void displayFlightRoute() {

            }

            @Override
            public void editFlightRoute() {

            }

            @Override
            public void removeFlightRoute() {

            }

            @Override
            public void running() {

            }
        };

        // Main program
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            passengerView.displayMainMenu(); // Menampilkan menu utama
            System.out.print("Pilih opsi: ");
            int option = 0;

            try {
                option = Integer.parseInt(scanner.nextLine()); // Menghindari kesalahan input
            } catch (NumberFormatException e) {
                System.out.println("Harap masukkan angka yang valid!");
                continue;
            }

                    switch (option) {
                        case 1: // Tambah Data Passenger
                            System.out.println("\n=== Tambah Data Passenger ===");
                            System.out.print("Nama: ");
                            String name = scanner.nextLine();
                            System.out.print("Umur: ");
                            String age = scanner.nextLine();
                            System.out.print("Jenis Kelamin: ");
                            String gender = scanner.nextLine();
                            System.out.println("Nomor Passport: ");
                            String passport = scanner.nextLine();
                            System.out.print("ID Card: ");
                            String idCard = scanner.nextLine();
                            passengerService.addPassenger(new Passenger(name, age, gender, passport, idCard));
                            break;

                        case 2: // Tampilkan Daftar Passenger
                            System.out.println("\n=== Daftar Data Passenger ===");
                            passengerView.displayAllPassengers(passengerService.getAllPassengers());
                            break;

                        case 3: // Edit Passenger
                            System.out.println("\n=== Edit Data Passenger ===");
                            passengerView.displayAllPassengers(passengerService.getAllPassengers());
                            System.out.print("Masukkan indeks passenger yang ingin diubah: ");
                            try {
                                index = Integer.parseInt(scanner.nextLine());
                                // Validasi dan proses lebih lanjut
                            } catch (NumberFormatException e) {
                                System.out.println("Input tidak valid. Harap masukkan angka.");
                            }
                            System.out.print("Nama Baru: ");
                            String newName = scanner.nextLine();
                            System.out.print("Umur Baru: ");
                            String newAge = scanner.nextLine();
                            System.out.print("Jenis Kelamin Baru: ");
                            String newGender = scanner.nextLine();
                            System.out.println("Nomor Passport Baru: ");
                            String newPassport = scanner.nextLine();
                            System.out.print("ID Card Baru: ");
                            String newIdCard = scanner.nextLine();
                            passengerService.editPassenger(index, new Passenger(newName, newAge, newGender, newPassport, newIdCard));
                            break;

                        case 4: // Tambah Rute Penerbangan
                            System.out.println("\n=== Tambah Rute Penerbangan ===");
                            System.out.print("ID Rute: ");
                            String routeId = scanner.nextLine();
                            System.out.print("Keberangkatan: ");
                            String departure = scanner.nextLine();
                            System.out.print("Tujuan: ");
                            String destination = scanner.nextLine();
                            System.out.print("Waktu Keberangkatan: ");
                            String departureTime = scanner.nextLine();
                            flightRouteService.addFlightRoute(new FlightRoute(routeId, departure, destination, departureTime));
                            break;

                        case 5: // Tampilkan Daftar Rute Penerbangan
                            System.out.println("\n=== Daftar Rute Penerbangan ===");
                            flightRouteView.displayFlightRoutes();
                            break;

                        case 6: // Edit Rute Penerbangan
                            System.out.println("\n=== Edit Rute Penerbangan ===");
                            System.out.print("Masukkan ID Rute yang ingin diubah: ");
                            String editRouteId = scanner.nextLine();
                            System.out.print("Keberangkatan Baru: ");
                            String newDeparture = scanner.nextLine();
                            System.out.print("Tujuan Baru: ");
                            String newDestination = scanner.nextLine();
                            System.out.print("Waktu Keberangkatan Baru: ");
                            String newDepartureTime = scanner.nextLine();
                            flightRouteService.editFlightRoute(editRouteId, new FlightRoute(editRouteId, newDeparture, newDestination, newDepartureTime));
                            break;

                        case 7: // Hapus Rute Penerbangan
                            System.out.println("\n=== Hapus Rute Penerbangan ===");
                            System.out.print("Masukkan ID Rute yang ingin dihapus: ");
                            String removeRouteId = scanner.nextLine();
                            flightRouteService.removeFlightRoute(removeRouteId);
                            break;

                        case 8: // Keluar dari Sistem
                            running = false;
                            System.out.println("Terima kasih telah menggunakan sistem!");
                            break;

                        default:
                            System.out.println("Opsi tidak valid. Silakan coba lagi.");
                    }

                }
            }
        }