import models.*;
import models.enums.SeatType;

import java.util.List;

public class BookingSystemDemo {

    public static void main(String[] args){

        BookingSystem bookingSystem = BookingSystem.getInstance();

        Theater theater1 = new Theater("PVR Cinemas");
        Movie movie1 = new Movie(2*60,"movie1");

        User user1 = new User("John Doe");

        List<Seat> seats = List.of( new Seat(SeatType.REGULAR,10),
                              new Seat(SeatType.VIP,100),
                              new Seat(SeatType.REGULAR,10));

        Show show1 = new Show("show1", movie1.getMovieId(), System.currentTimeMillis(), System.currentTimeMillis() + 2*60*60*1000, theater1.getTheaterId(), seats);

            bookingSystem.addShows(show1);
            bookingSystem.addUser(user1);


        List<Seat> availableSeats = bookingSystem.getSeats(show1.getShowId());

        List<Seat> bookingSeats = List.of( new Seat(SeatType.REGULAR,10),
                new Seat(SeatType.VIP,100));

        Booking booking = bookingSystem.book(user1.getUserId(),show1.getShowId(),bookingSeats);



    }
}
