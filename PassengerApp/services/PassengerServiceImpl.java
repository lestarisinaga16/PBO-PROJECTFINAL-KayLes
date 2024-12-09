package PassengerApp.services;

import PassengerApp.entities.FlightRoute;
import PassengerApp.entities.Passenger;
import PassengerApp.repositories.PassengerRepositoryDbImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PassengerServiceImpl implements PassengerService {
    private PassengerRepositoryDbImpl passengerRepositoryDb;
    private Scanner input = new Scanner(System.in);

    public PassengerServiceImpl(PassengerRepositoryDbImpl passengerRepositoryDb) {
        this.passengerRepositoryDb = passengerRepositoryDb;
    }

    @Override
    public void addPassenger(int flightRouteID) {
        System.out.print("Masukan Nama Anda : ");
        String nama = input.nextLine();
        System.out.print("Masukan Usia Anda : ");
        String age = input.nextLine();
        System.out.print("Masukan Kelamin Anda : ");
        String gender = input.nextLine();
        System.out.print("Masukan Passport Anda : ");
        String passport = input.nextLine();
        System.out.print("Masukan Nomor KTP Anda : ");
        String ktpNum = input.nextLine();


        Passenger passenger = new Passenger(nama,age,gender,passport,ktpNum);
        passenger.setFlightRouteID(flightRouteID);
        passengerRepositoryDb.addPassenger(passenger);
    }

    @Override
    public void editPassenger(int flightRouteID) {
        System.out.print("Masukan Nomor KTP Dari Tiket Penerbangan Yang ingin Anda Edit : ");
        String oldIDNum = searchPassenger(input.nextLine()).getIdCard();

        System.out.print("Masukan Nama Baru Anda : ");
        String nama = input.nextLine();
        System.out.print("Masukan Usia Baru Anda : ");
        String age = input.nextLine();
        System.out.print("Masukan Kelamin Baru Anda : ");
        String gender = input.nextLine();
        System.out.print("Masukan Passport Baru Anda : ");
        String passport = input.nextLine();
        System.out.print("Masukan Nomor KTP Baru Anda : ");
        String ktpNum = input.nextLine();

        Passenger passenger = new Passenger(nama,age,gender,passport,ktpNum);
        passenger.setFlightRouteID(flightRouteID);
        passengerRepositoryDb.edit(passenger,oldIDNum);
    }

    private Passenger searchPassenger(String ktpNum){
        List<Passenger> passengerList = getAllPassengers();
        for (Passenger i : passengerList){
            if (i.getIdCard().equals(ktpNum))return i;
        }
        return new Passenger(null,null,null,null,null);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepositoryDb.getAll();
    }

    @Override
    public void removePassenger() {
        System.out.print("Masukan Nomor KTP Dari Tiket Penerbangan Yang ingin Anda Hapus : ");
        passengerRepositoryDb.delete(searchPassenger(input.nextLine()));
    }

}
