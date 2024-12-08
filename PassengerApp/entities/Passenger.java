package PassengerApp.entities;

import java.util.List;

public class Passenger {
    private String name;
    private String age;
    private String gender;
    private String passport;
    private String idCard;

    // Constructor
    public Passenger(String name, int age, String gender, String passport, String idCard) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.passport = passport;
        this.idCard = idCard;
    }

    // Metode indexOf untuk mencari indeks penumpang dalam daftar
    public static int indexOf(List<Passenger> allPassengers, Passenger existingPassenger) {
        for (int i = 0; i < allPassengers.size(); i++) { // Menggunakan size() dari List
            if (allPassengers.get(i).equals(existingPassenger)) { // Menggunakan get() dari List
                return i;
            }
        }
        return -1; // Jika tidak ditemukan, kembalikan -1
    }

    // Getters dan Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", passport='" + passport + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Passenger passenger = (Passenger) obj;
        return idCard.equals(passenger.idCard); // Bandingkan berdasarkan idCard
    }

    // Main method untuk pengujian
    public static void main(String[] args) {
        List<Passenger> passengers = List.of(
                new Passenger("Alice", "25", "Female", "P12345", "ID001"),
                new Passenger("Bob", "30", "Male", "P54321", "ID002")
        );

        Passenger searchPassenger = new Passenger("Bob", "30", "Male", "P54321", "ID002");

        int index = indexOf(passengers, searchPassenger);
        System.out.println("Indeks: " + index); // Output: Indeks: 1
    }

    public void setBirthDate(String newBirthDate) {

    }
}
