package entities;

public class Passenger {
    private String name;
    private String age;
    private String gender;
    private String birthDate;
    private String passportNumber;
    private String idCardNumber;

    // Constructor
    public Passenger(String name, String age, String gender, String birthDate, String passportNumber, String idCardNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
        this.idCardNumber = idCardNumber;
    }

    // Getters and Setters
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }
}
