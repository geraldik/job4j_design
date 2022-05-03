package ru.job4j.design.srp;

public class CarManager {
    private String carName;
    private String carNumber;
    private String driverName;
    private String driverLicense;
    private double price;
    private int rentTime;


    public CarManager(String carName, String carNumber, String driverName, String driverLicense, double price, int rentTime) {
        this.carName = carName;
        this.carNumber = carNumber;
        this.driverName = driverName;
        this.driverLicense = driverLicense;
        this.price = price;
        this.rentTime = rentTime;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public double rentPrice() {
        return price * rentTime;
    }

    public void saveToDBDriver() {
    }

    public void loadFromDBDriver() {

    }
}
