package PassengerApp.entities;

public class Passenger {
    private String name;
    private String age;
    private String gender;
    private String passport;  // passport_number
    private static String idCard;  // ktp_number

    // Constructor
    public Passenger(String name, String age, String gender, String passport, String idCard) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.passport = passport;
        this.idCard = idCard;
    }

    public static boolean getId() {
        return idCard != null && !idCard.isBlank();
    }


    // Getters
    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPassport() {
        return passport;
    }

    public static String getIdCard() {
        return getIdCard();
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    
}