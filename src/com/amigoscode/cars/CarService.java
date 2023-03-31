package com.amigoscode.cars;

import com.amigoscode.users.Users;

public class CarService {
    private CarDAO carDAO;

    public CarService() {
        this.carDAO = new CarDAO();
    }

    public void addCar(Cars car) {

        carDAO.saveCar(car);
    }

    public Cars[] getCars() {
        return carDAO.getCars();
    }

    public void addCarBooking(CarBooking carBooking) {
        carDAO.saveCarBooking(carBooking);
    }

    public CarBooking[] getCarBookings() {
        return carDAO.getCarBookings();
    }
}
