package PassengerApp.repositories;

import PassengerApp.config.Database;
import PassengerApp.entities.Passenger;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Component
public class PassengerRepositoryDbImpl {
    public void addPassenger(Passenger passenger) {
        // Pastikan koneksi diambil dari kelas Database
        Connection connection = null;
        try {
            connection = Database.getConnection(); // Asumsi ada method getConnection() pada class Database

            String query = "INSERT INTO passengers (name, age, gender, passport_number, ktp_number) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            // Mengisi preparedStatement dengan data dari objek passenger
            statement.setString(1, passenger.getName());
            statement.setInt(2, Integer.parseInt(passenger.getAge()));  // Pastikan umur adalah angka
            statement.setString(3, passenger.getGender());
            statement.setString(4, passenger.getPassport());  // passport_number
            statement.setString(5, passenger.getIdCard());  // ktp_number

            // Eksekusi query
            statement.executeUpdate();

            System.out.println("Penumpang berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Pastikan koneksi ditutup setelah selesai
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
