package models;

import models.enums.BookingStatus;

import java.util.List;
import java.util.UUID;

public class Booking {

    String bookingId;
    String userId;
    String showId;
    List<Seat> seats;
    BookingStatus bookingStatus;
    double price;

    public Booking(String userId, String showId, List<Seat> seats) {
        bookingId = UUID.randomUUID().toString();
        this.userId = userId;
        this.showId = showId;
        this.seats = seats;
        this.bookingStatus = BookingStatus.INITIATED;

    }

    public String getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getShowId() {
        return showId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public double getPrice() {
        return price;
    }


}
