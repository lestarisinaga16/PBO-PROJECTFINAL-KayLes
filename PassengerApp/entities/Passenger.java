package PassengerApp.entities;

import java.util.List;

public class Passenger {
    private String name;
    private String age;
    private String gender;
    private String passport;
    private int flightRouteID;
    private String idCard;

    // Constructor
    public Passenger(String name, String age, String gender, String passport, String idCard) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.passport = passport;
        this.idCard = idCard;
    }

    public int getFlightRouteID() {
        return flightRouteID;
    }

    public void setFlightRouteID(int flightRouteID) {
        this.flightRouteID = flightRouteID;
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


    public void setBirthDate(String newBirthDate) {

    }
}
