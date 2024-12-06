package PassengerApp;

import PassengerApp.config.Database;
import PassengerApp.view.PassengerTerminalViewImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "PassengerApp")  // Pastikan basePackages sesuai dengan paket aplikasi Anda
public class Main {

    public static void main(String[] args) {
        // Membuat ApplicationContext Spring
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        // Mendapatkan bean PassengerTerminalViewImpl dari konteks Spring
        PassengerTerminalViewImpl passengerTerminalViewImpl = context.getBean(PassengerTerminalViewImpl.class);

        // Menangani input di dalam passengerTerminalViewImpl
        passengerTerminalViewImpl.run();  // Memanggil metode run() pada objek passengerTerminalViewImpl
    }

    // Mendeklarasikan bean Database
    @Bean
    Database database() {
        // Menyiapkan database dengan parameter yang sesuai
        Database database = new Database("databasekeyles", "root", "", "localhost", "3306");
        database.setup();  // Pastikan setup() sensual dengan implementasi Anda
        return database;
    }
}