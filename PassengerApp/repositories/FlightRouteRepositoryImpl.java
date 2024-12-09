package PassengerApp.repositories;

import PassengerApp.config.Database;
import PassengerApp.entities.FlightRoute;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightRouteRepositoryImpl implements FlightRouteRepository {

    private Database database;

    public FlightRouteRepositoryImpl(Database database) {
        this.database = database;
    }

    @Override
    public List<FlightRoute> getAll() {
        Connection connection = database.getConnection();
        String sqlStatement = "SELECT * FROM flight";
        List<FlightRoute> flightRoutes = new ArrayList<>() {
        };

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FlightRoute flightRoute = new FlightRoute(resultSet.getString("departure_city"),resultSet.getString("arrival_city"),
                        resultSet.getString("departure_time"),resultSet.getString("arrival_time"),resultSet.getInt("route_id"));

                flightRoutes.add(flightRoute);
            }
        } catch (Exception e) {
            System.out.println("Error fetching menu items: " + e.getMessage());
        }

        return flightRoutes;
    }


    @Override
    public void addRoute(FlightRoute flightRoute) {
        // Pastikan koneksi diambil dari kelas Database
        Connection connection = null;
        try {
            connection = database.getConnection(); // Asumsi ada method getConnection() pada class Database

            String query = "INSERT INTO flight (departure_city, arrival_city, departure_time, arrival_time) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            // Mengisi preparedStatement dengan data dari objek passenger
            statement.setString(1, flightRoute.getDepartureCity());
            statement.setString(2, flightRoute.getArrivalCity());
            statement.setString(3, flightRoute.getDepartureTime());
            statement.setString(4, flightRoute.getArrivalTime());

            // Eksekusi query
            statement.executeUpdate();

            System.out.println("Rute berhasil ditambahkan.");
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
    public void delete(FlightRoute flightRoute) {
        // Pastikan koneksi diambil dari kelas Database
        Connection connection = null;
        try {
            connection = database.getConnection(); // Asumsi ada method getConnection() pada class Database

            String query = "DELETE FROM flight WHERE route_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Mengisi preparedStatement dengan data dari objek passenger
            statement.setInt(1, flightRoute.getRouteId());


            // Eksekusi query
            statement.executeUpdate();

            System.out.println("Rute berhasil Di Hapus.");
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
    public void edit(FlightRoute flightRoute) {
        // Pastikan koneksi diambil dari kelas Database



        Connection connection = null;
        try {
            connection = database.getConnection(); // Asumsi ada method getConnection() pada class Database

            String query = "UPDATE flight SET departure_city = ?, arrival_city = ?, departure_time = ?, arrival_time = ? WHERE route_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Mengisi preparedStatement dengan data dari objek passenger
            statement.setString(1,flightRoute.getDepartureCity());
            statement.setString(2, flightRoute.getArrivalCity());
            statement.setString(3, flightRoute.getDepartureTime());
            statement.setString(4, flightRoute.getArrivalTime());
            statement.setInt(5, flightRoute.getRouteId());

            // Eksekusi query
            statement.executeUpdate();

            System.out.println("Rute berhasil diUpdate.");
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
