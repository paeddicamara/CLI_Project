package com.amigoscode;

import com.amigoscode.cars.CarBooking;
import com.amigoscode.cars.CarService;
import com.amigoscode.cars.Cars;
import com.amigoscode.users.UserService;
import com.amigoscode.users.Users;

import java.time.LocalDateTime;
import java.util.Scanner;

import java.util.UUID;

public class Main {

    private UserService userService = new UserService();
    private CarService carService = new CarService();

    public Main () {
        UUID uuid = UUID.randomUUID();
        Users user1 = new Users(uuid.toString(), "James");
        userService.addUser(user1);

        uuid = UUID.randomUUID();
        Users user2 = new Users(uuid.toString(), "Jamila");
        userService.addUser(user2);
        
        Cars car1 = new Cars("1234", 89.00,
                "TESLA", true, true);
        carService.addCar(car1);

        Cars car2 = new Cars("5678", 50.00,
                "AUDI", false, true);
        carService.addCar(car2);

        Cars car3 = new Cars("5679", 77.00,
                "MERCEDES", false, true);
        carService.addCar(car3);
    }

    public void allUsers() {
        for (int i = 0; i < userService.getUsers().length; i++) {
            System.out.println(userService.getUsers()[i]);
        }
    }

    public void allAvailableCars() {
        boolean availableCar = false;

        for (int j = 0; j < carService.getCars().length; j++) {
            if (carService.getCars()[j].isAvailable()) {
                availableCar = true;
                System.out.println(carService.getCars()[j]);
            }
        }

        if (!availableCar) {
            String x = Character.toString(100_60);
            System.out.println(x + " No cars available for renting");
        }
    }

    public void allAvailableElectricCars() {
        boolean availableElectricCar = false;
        for (int j = 0; j < carService.getCars().length; j++) {
            if (carService.getCars()[j].isElectric() == true && carService.getCars()[j].isAvailable()) {
                availableElectricCar = true;
                System.out.println(carService.getCars()[j]);
            }
        }

        if (!availableElectricCar) {
            String x = Character.toString(100_60);
            System.out.println(x + " No electric cars available for renting");
        }
    }

    public String searchForUserBookedCar(String userId){
        boolean isCarBooked = false;

        for (int k = 0; k < carService.getCars().length; k++) {
            if (carService.getCars()[k].getUserBookId().equals(userId)) {
                isCarBooked = true;
                return userId;
            }
        }

        if (!isCarBooked) {
            return "";
        }

        return "";
    }

    public void displayUserCarBooked(String userId) {
        for (int m = 0; m < userService.getUsers().length; m++) {
            if (userService.getUsers()[m].getId().equals(userId)) {
                System.out.print("user " + userService.getUsers()[m]);
            }
        }

        for (int k = 0; k < carService.getCars().length; k++) {
            if (carService.getCars()[k].getUserBookId().equals(userId)) {
                System.out.println(" has " + carService.getCars()[k]);
            }
        }
    }

    public void displayUserCarNotBooked(String userId) {
        String x = Character.toString(100_60);

        for (int n = 0; n < userService.getUsers().length; n++) {
            if (userService.getUsers()[n].getId().equals(userId)) {
                System.out.println(x + "user " + userService.getUsers()[n] + " has no cars booked");

            }
        }
    }

    public void bookCar(String regNumber,  String userId) {
        LocalDateTime bookingTime = LocalDateTime.now();

        for (int x = 0; x < carService.getCars().length; x++) {
            if (carService.getCars()[x].getRegNumber().equals(regNumber)) {
                carService.getCars()[x].setUserBookId(userId);
                carService.getCars()[x].setAvailable(false);

                System.out.print("Successfully booked car with reg number " +
                        regNumber + " for user=");

                for (int k = 0; k < userService.getUsers().length; k++) {
                    if (userService.getUsers()[k].getId().equals(userId)) {
                        System.out.print(userService.getUsers()[k]);
                    }
                }
                System.out.print(", car=");

                for (int j = 0; j < carService.getCars().length; j++) {
                    if (carService.getCars()[j].getRegNumber().equals(regNumber)) {
                        System.out.print(carService.getCars()[j]);
                    }
                }
                System.out.print(", bookingTime=" + bookingTime);

                System.out.println(", isCancelled=false}");

                UUID uuid = UUID.randomUUID();
                String bookingRef = uuid.toString();
                System.out.println("Booking ref: " + bookingRef);
                addCarBooking(bookingRef,userId,regNumber, bookingTime,
                        false);

            }
        }
    }

    public void addCarBooking(String bookingId, String userId, String regNumber,
                              LocalDateTime bookingTime, boolean isCanceled){

            CarBooking carBooking1 = new CarBooking(bookingId, userId,regNumber,
                    bookingTime, isCanceled);

        carService.addCarBooking(carBooking1);
    }

    public void allBookings (){
        boolean isBooking = false;

        for (int j = 0; j < carService.getCarBookings().length; j++) {
            if (carService.getCarBookings()[j] != null) {
                isBooking = true;
                System.out.print("booking = CarBooking{bookingId=" +
                        carService.getCarBookings()[j].getBookingId() + ", ");
                for (int k = 0; k < userService.getUsers().length; k++) {
                    if (userService.getUsers()[k].getId().equals(carService.getCarBookings()[j].getUserId())) {
                        System.out.print(userService.getUsers()[k]);
                        break;
                    }
                }
                System.out.print(", ");

                for (int m = 0; m < carService.getCars().length; m++) {
                    if (carService.getCars()[m].getRegNumber().equals(carService.getCarBookings()[j].getRegNumber())) {
                        System.out.print(carService.getCars()[m]);
                        break;
                    }
                }
                System.out.print(", ");

                System.out.print("bookingTime=" + carService.getCarBookings()[j].getBookingTime() +
                        ", isCanceled=" + carService.getCarBookings()[j].getIsCanceled() + "}\n");
            }
        }

        if (!isBooking){
            System.out.println("No bookings available \uD83D\uDE00");
        }
    }
    public static void main(String[] args) {

        Main myMain = new Main();
        int value = 0;
        Scanner myScan = new Scanner(System.in);

        do {

            System.out.println("\n\n");
            System.out.println("1 - Book Car");
            System.out.println("2 - View All User Booked Cars");
            System.out.println("3 - View All Bookings");
            System.out.println("4 - View Available Cars");
            System.out.println("5 - View Available Electric Cars");
            System.out.println("6 - View all users");
            System.out.println("7 - Exit");

            value = myScan.nextInt();

            switch (value) {
                case 1:
                    myMain.allAvailableCars();
                    System.out.println("select car reg number");
                    Scanner scanRegNumber = new Scanner(System.in);
                    String regNumber = scanRegNumber.nextLine();

                    myMain.allUsers();
                    System.out.println("select user id");
                    Scanner scanUserIdValue = new Scanner(System.in);
                    String userIdValue = scanUserIdValue.nextLine();

                    myMain.bookCar(regNumber, userIdValue);
                    break;
                case 2:
                    myMain.allUsers();
                    System.out.println("select user id");
                    Scanner scanUserId = new Scanner(System.in);
                    String userId = scanUserId.nextLine();

                    String resultUserId = myMain.searchForUserBookedCar(userId);
                    if (resultUserId != "") {
                        myMain.displayUserCarBooked(resultUserId);
                    }
                    else {
                        myMain.displayUserCarNotBooked(userId);
                    }
                    break;
                case 3:
                    myMain.allBookings();
                    break;
                case 4:
                    myMain.allAvailableCars();
                    break;
                case 5:
                    myMain.allAvailableElectricCars();
                    break;
                case 6:
                    myMain.allUsers();
                    break;
                case 7:
                    System.out.println("Goodbye");
                    break;
                default:
                    String x = Character.toString(100_60);
                    System.out.println(value + " not a valid option " + x);

            }

        } while (value != 7);
    }
}