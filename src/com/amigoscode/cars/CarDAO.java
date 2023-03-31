package com.amigoscode.cars;

import com.amigoscode.users.Users;

public class CarDAO {
    private static Cars[] cars;

    private static CarBooking[] carBookingArr;

    private static int nextIndex = 0;
    private static final int size = 3;

    static {
        cars = new Cars[size];
        carBookingArr = new CarBooking[1];
    }

    public void saveCar(Cars car) {

        cars[nextIndex] = car;
        nextIndex++;
    }

    public Cars[] getCars() {
        return cars;
    }

    public void saveCarBooking(CarBooking carBooking) {

        if(carBookingArr.length == 1) {
            carBookingArr[0] = carBooking;
        }
        else {
            int carBookingArrLength = carBookingArr.length;
            CarBooking[] CarBookingNewArr = new CarBooking[carBookingArrLength + 1];

            for (int i = 0; i < carBookingArrLength; i++)  {
                CarBookingNewArr[i] = carBookingArr[i];
            }

            CarBookingNewArr[carBookingArrLength] = carBooking;

            carBookingArr = CarBookingNewArr;
        }
    }

    public CarBooking[] getCarBookings() {
        return carBookingArr;
    }
}
