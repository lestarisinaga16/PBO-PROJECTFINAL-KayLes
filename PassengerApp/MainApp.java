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
            public Boolean removePassenger(Integer id) {
                return null;
            }

            @Override
            public Boolean removePassenger(String idCard) {
                return passengers.removeIf(p -> p.getIdCard().equals(idCard));  // Memanggil getIdCard() pada objek p
            }

            @Override
            public Passenger get(int index) {
                return null;
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

                    // Meminta input data penumpang
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();

                    System.out.print("Masukkan Umur: ");
                    int umur = Integer.parseInt(scanner.nextLine());

                    System.out.print("Masukkan Jenis Kelamin (L/P): ");
                    String gender = scanner.nextLine();

                    System.out.print("Masukkan Tanggal Lahir (format: DD-MM-YYYY): ");
                    String tanggalLahir = scanner.nextLine();

                    System.out.print("Masukkan Nomor Paspor (7 digit): ");
                    String noPaspor = scanner.nextLine();

                    System.out.print("Masukkan Nomor KTP: ");
                    String noKTP = scanner.nextLine();

                    // Membuat objek penumpang baru dengan data yang dimasukkan
                    Passenger newPassenger = new Passenger(nama, gender, tanggalLahir, noPaspor, noKTP);

                    // Menambahkan data penumpang ke layanan
                    passengerService.addPassenger(newPassenger);

                    System.out.println("Data Passenger berhasil ditambahkan!");
                    break;


                case 2: // Tampilkan Daftar Data Passenger
                    System.out.println("\n=== Daftar Data Passenger ===");
                    List<Passenger> passengers = passengerService.getAllPassengers();
                    if (passengers.isEmpty()) {
                        System.out.println("Belum ada data penumpang.");
                    } else {
                        passengerView.displayAllPassengers(passengers);
                    }
                    break;

                case 3: // Edit Data Passenger
                    System.out.println("\n=== Edit Data Passenger ===");

                    // Menampilkan daftar data penumpang
                    List<Passenger> Passengers = passengerService.getAllPassengers();
                    if (Passengers.isEmpty()) {
                        System.out.println("Belum ada data penumpang.");
                    } else {
                        passengerView.displayAllPassengers(Passengers);

                        // Meminta ID KTP untuk memilih penumpang yang akan diedit
                        System.out.print("Masukkan Nomor KTP penumpang yang ingin diedit: ");
                        String editKTP = scanner.nextLine();

                        // Mencari penumpang berdasarkan nomor KTP
                        Passenger passengerToEdit = Passengers.stream()
                                .filter(p -> p.getIdCard().equals(editKTP))
                                .findFirst()
                                .orElse(null);

                        if (passengerToEdit != null) {
                            // Menampilkan data saat ini dan meminta input untuk pembaruan
                            System.out.println("Data saat ini:");
                            System.out.println(passengerToEdit);

                            System.out.println("Masukkan data baru (kosongkan jika tidak ingin mengubah):");
                            System.out.print("Nama baru: ");
                            String newName = scanner.nextLine();
                            System.out.print("Umur baru: ");
                            String newAgeInput = scanner.nextLine();
                            System.out.print("Jenis Kelamin baru (L/P): ");
                            String newGender = scanner.nextLine();
                            System.out.print("Tanggal Lahir baru (format: DD-MM-YYYY): ");
                            String newBirthDate = scanner.nextLine();
                            System.out.print("Nomor Paspor baru (7 digit): ");
                            String newPassport = scanner.nextLine();

                            // Memperbarui data penumpang
                            if (!newName.isEmpty()) passengerToEdit.setName(newName);
                            if (!newAgeInput.isEmpty())
                                passengerToEdit.setAge(String.valueOf(Integer.parseInt(newAgeInput)));
                            if (!newGender.isEmpty()) passengerToEdit.setGender(newGender);
                            if (!newBirthDate.isEmpty()) passengerToEdit.setBirthDate(newBirthDate);
                            if (!newPassport.isEmpty()) passengerToEdit.setPassport(newPassport);

                            passengerService.updatePassenger(passengerToEdit);
                            System.out.println("Data Passenger berhasil diperbarui!");
                        } else {
                            System.out.println("Penumpang dengan Nomor KTP tersebut tidak ditemukan.");
                        }
                    }
                    break;


                case 4: // Tambah Rute Penerbangan
                    System.out.println("\n=== Tambah Rute Penerbangan ===");

                    // Meminta input data rute penerbangan
                    System.out.print("Masukkan ID Rute: ");
                    String routeId = scanner.nextLine();

                    System.out.print("Masukkan Kota Keberangkatan: ");
                    String departure = scanner.nextLine();

                    System.out.print("Masukkan Kota Tujuan: ");
                    String destination = scanner.nextLine();

                    System.out.print("Masukkan Waktu Keberangkatan (format: HH:mm): ");
                    String departureTime = scanner.nextLine();

                    // Validasi input (opsional, bisa disesuaikan)
                    if (routeId.isEmpty() || departure.isEmpty() || destination.isEmpty() || departureTime.isEmpty()) {
                        System.out.println("Semua data harus diisi. Rute penerbangan tidak dapat ditambahkan.");
                        break;
                    }

                    // Membuat objek FlightRoute baru dengan data yang dimasukkan
                    FlightRoute newRoute = new FlightRoute(routeId, departure, destination, departureTime);

                    // Menambahkan rute ke dalam sistem
                    flightRouteService.addFlightRoute(newRoute);

                    System.out.println("Rute penerbangan berhasil ditambahkan!");
                    break;




                // Membuat objek FlightRoute baru dengan data yang dimasukkan

                // Menambahkan rute ke dalam sistem

                case 5: // Tampilkan Daftar Rute Penerbangan
                    System.out.println("\n=== Daftar Rute Penerbangan ===");

                    List<FlightRoute> routesToDisplay = flightRouteService.getAllFlightRoutes(); // Ambil semua rute penerbangan

                    if (routesToDisplay.isEmpty()) {
                        System.out.println("Belum ada rute penerbangan.");
                    } else {
                        flightRouteView.displayAllFlightRoutes(routesToDisplay); // Tampilkan daftar rute penerbangan
                    }
                    break;




                case 6: // Edit Rute Penerbangan
                    System.out.println("\n=== Edit Rute Penerbangan ===");

                    // Tampilkan daftar rute penerbangan yang ada
                    flightRouteView.displayFlightRoutes();  // Menampilkan daftar rute penerbangan

                    // Minta input ID rute yang akan diedit
                    String editRouteId = flightRouteView.getInputRouteId();  // Input ID rute yang ingin diedit

                    // Cari rute berdasarkan ID yang dimasukkan oleh pengguna
                    FlightRoute existingRoute = flightRouteService.getAllFlightRoutes().stream()
                            .filter(r -> r.getRouteId().equals(editRouteId))  // Mencocokkan berdasarkan routeId
                            .findFirst().orElse(null);  // Jika rute tidak ditemukan, kembalikan null

                    if (existingRoute != null) {
                        // Jika rute ditemukan, tampilkan informasi rute yang ingin diedit
                        flightRouteView.displayEditFlightRouteForm(existingRoute);

                        // Ambil data baru untuk update rute
                        String newDeparture = flightRouteView.getInputDeparture();  // Ambil input keberangkatan baru
                        String newDestination = flightRouteView.getInputDestination();  // Ambil input tujuan baru
                        String newDepartureTime = flightRouteView.getInputDepartureTime();  // Ambil input waktu keberangkatan baru

                        // Buat objek FlightRoute baru dengan data yang diubah
                        FlightRoute updatedRoute = new FlightRoute(editRouteId, newDeparture, newDestination, newDepartureTime);

                        // Perbarui rute yang ada menggunakan service
                        flightRouteService.editFlightRoute(editRouteId, updatedRoute);

                        // Berikan konfirmasi bahwa rute berhasil diperbarui
                        System.out.println("Rute penerbangan berhasil diupdate!");
                    } else {
                        // Jika rute tidak ditemukan, beri tahu pengguna
                        System.out.println("Rute penerbangan dengan ID tersebut tidak ditemukan.");
                    }
                    break;

                case 7: // Hapus Rute Penerbangan
                    System.out.println("\n=== Hapus Rute Penerbangan ===");

                    // Menampilkan daftar rute penerbangan untuk mempermudah pemilihan
                    List<FlightRoute> routesToDelete = flightRouteService.getAllFlightRoutes();
                    if (routesToDelete.isEmpty()) {
                        System.out.println("Belum ada rute penerbangan yang tersedia untuk dihapus.");
                        break;
                    } else {
                        System.out.println("ID Rute | Keberangkatan | Tujuan   | Waktu Keberangkatan");
                        System.out.println("------------------------------------------------------");
                        for (FlightRoute routes : routesToDelete) {
                            System.out.printf("%-8s | %-13s | %-8s | %-18s%n",
                                    routes.getRouteId(),
                                    routes.getDeparture(),
                                    routes.getDestination(),
                                    routes.getDepartureTime());
                        }
                    }

                    // Meminta input ID rute yang ingin dihapus
                    System.out.print("\nMasukkan ID Rute yang ingin dihapus: ");
                    String deleteRouteId = scanner.nextLine();

                    // Mencari rute berdasarkan ID
                    FlightRoute routeToDelete = routesToDelete.stream()
                            .filter(r -> r.getRouteId().equals(deleteRouteId))
                            .findFirst()
                            .orElse(null);

                    if (routeToDelete != null) {
                        // Menghapus rute melalui layanan
                        flightRouteService.removeFlightRoute(deleteRouteId);
                        System.out.println("Rute penerbangan dengan ID " + deleteRouteId + " berhasil dihapus!");
                    } else {
                        System.out.println("Rute penerbangan dengan ID tersebut tidak ditemukan!");
                    }
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