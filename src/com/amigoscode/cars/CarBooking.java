package com.amigoscode.cars;

import java.time.LocalDateTime;

public class CarBooking {

    private String bookingId;

    private String userId;

    private String regNumber;

    private LocalDateTime bookingTime;

    private boolean isCanceled;


    public CarBooking(String bookingId, String userId, String regNumber,
                      LocalDateTime bookingTime, boolean isCanceled) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.regNumber = regNumber;
        this.bookingTime = bookingTime;
        this.isCanceled = isCanceled;
    }

    public String getBookingId(){
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public boolean getIsCanceled () {
        return isCanceled;
    }
}
