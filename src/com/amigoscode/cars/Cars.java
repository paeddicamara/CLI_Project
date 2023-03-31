package com.amigoscode.cars;

public class Cars {
    private String regNumber;
    private double rentalPricePerDay;
    private String brand;
    private boolean isElectric;

    private boolean isAvailable;

    private String userBookId;

    public Cars(String regNumber, double rentalPricePerDay,
                String brand, boolean isElectric, boolean isAvailable) {
        this.regNumber = regNumber;
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.isElectric = isElectric;
        this.isAvailable = isAvailable;
        this.userBookId = "";
    }

    public String getRegNumber() {
        return regNumber;
    }
    public boolean isElectric() {
        return isElectric;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public String getUserBookId() {
        return userBookId;
    }

    public void setUserBookId(String userBookId) {
        this.userBookId = userBookId;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "regNumber='" + regNumber + '\'' +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", brand=" + brand +
                ", isElectric=" + isElectric +
                '}';
    }
}
