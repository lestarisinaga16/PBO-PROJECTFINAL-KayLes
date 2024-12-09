package PassengerApp.repositories;

import PassengerApp.config.Database;
import PassengerApp.entities.Passenger;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PassengerRepositoryDbImpl implements PassengerRepository{
    private Database database;

    public PassengerRepositoryDbImpl(Database database) {
        this.database = database;
    }

    @Override
    public List<Passenger> getAll() {
        Connection connection = database.getConnection();
        String sqlStatement = "SELECT * FROM passengers";
        List<Passenger> passengerList = new ArrayList<>() {
        };

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Passenger penumpang = new Passenger(resultSet.getString("name"),resultSet.getString("age"),
                        resultSet.getString("gender"),resultSet.getString("passport_number"),resultSet.getString("ktp_number"));

                penumpang.setFlightRouteID(resultSet.getInt("flight_route_id"));

                passengerList.add(penumpang);
            }
        } catch (Exception e) {
            System.out.println("Error fetching menu items: " + e.getMessage());
        }

        return passengerList;
    }


    @Override
    public void addPassenger(Passenger passenger) {
        // Pastikan koneksi diambil dari kelas Database
        Connection connection = null;
        try {
            connection = database.getConnection(); // Asumsi ada method getConnection() pada class Database

            String query = "INSERT INTO passengers (name, age, gender, passport_number, flight_route_id, ktp_number) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            // Mengisi preparedStatement dengan data dari objek passenger
            statement.setString(1, passenger.getName());
            statement.setInt(2, Integer.parseInt(passenger.getAge()));  // Pastikan umur adalah angka
            statement.setString(3, passenger.getGender());
            statement.setString(4, passenger.getPassport());// passport_number
            statement.setInt(5, passenger.getFlightRouteID());
            statement.setString(6, passenger.getIdCard());  // ktp_number

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
    @Override
    public void delete(Passenger passenger) {
        // Pastikan koneksi diambil dari kelas Database
        Connection connection = null;
        try {
            connection = database.getConnection(); // Asumsi ada method getConnection() pada class Database

            String query = "DELETE FROM passengers WHERE ktp_number = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Mengisi preparedStatement dengan data dari objek passenger
            statement.setString(1, passenger.getIdCard());


            // Eksekusi query
            statement.executeUpdate();

            System.out.println("Penumpang berhasil Di Hapus.");
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

    @Override
    public void edit(Passenger passenger, String oldIDCard) {
        // Pastikan koneksi diambil dari kelas Database

        Connection connection = null;
        try {
            connection = database.getConnection(); // Asumsi ada method getConnection() pada class Database

            String query = "UPDATE passengers SET name = ?, age = ?, gender = ?, passport_number = ?, flight_route_id = ?, ktp_number = ? WHERE ktp_number = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Mengisi preparedStatement dengan data dari objek passenger
            statement.setString(1, passenger.getName());
            statement.setString(2, passenger.getAge());
            statement.setString(3, passenger.getGender());
            statement.setString(4, passenger.getPassport());
            statement.setInt(5, passenger.getFlightRouteID());
            statement.setString(6, passenger.getIdCard());
            statement.setString(7, oldIDCard);

            // Eksekusi query
            statement.executeUpdate();

            System.out.println("Penumpang berhasil diUpdate.");
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
