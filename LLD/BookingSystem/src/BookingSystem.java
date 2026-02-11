import models.Booking;
import models.Seat;
import models.Show;
import models.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class BookingSystem {

    private Map<String, Booking> bookings;
    private Map<String, User> users;
    private Map<String, Show> shows;


    private static BookingSystem instance;

    private BookingSystem(){
        bookings = new ConcurrentHashMap<>();
        users= new ConcurrentHashMap<>();
        shows= new ConcurrentHashMap<>();
    }

    public static synchronized BookingSystem getInstance(){
        if(instance==null){
            instance = new BookingSystem();
        }
        return instance;
    }


    //add users
    public void addUser(User user){
        users.put(user.getUserId(), user);
    }

    //remove users
    public void removeUser(String userId){
        users.remove(userId);
    }


    //add shows
    public void addShows(Show show){
        shows.put(show.getShowId(), show);
    }

    //remove shows
    public void removeShows(String showId){
        shows.remove(showId);
    }



    //get seats
    public List<Seat> getSeats(String showId){
        Show show = shows.get(showId);

        if(show!=null){

            List<Seat> seats = show.getSeats();
            return seats.stream().filter(seat -> seat.isAvailable()).collect(Collectors.toList());

        }

        throw new RuntimeException("SHow doesnt ecxist");
    }


    //book tickets
    public Booking book(String userId, String showId, List<Seat> seats){

        User user = users.get(userId);
        Show show = shows.get(showId);

        double totalPrice=0;

        if(user!=null && show!=null) {

            for (Seat seat : seats) {
                if (!seat.isAvailable()) {
                    throw new RuntimeException("Seat is not available");
                }

                totalPrice += seat.getPrice();
                seat.occupy();
            }


            Booking booking = new Booking(userId, showId, seats);
            bookings.put(booking.getBookingId(), booking);
            return booking;
        }

        else  throw new RuntimeException("SHow or movie doesnt ecxist");


    }

}
