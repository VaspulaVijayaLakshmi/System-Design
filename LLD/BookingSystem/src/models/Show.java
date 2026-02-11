package models;

import java.util.List;

public class Show {

    String showId;
    String MovieId;
    long startTime;
    long EndTime;
    String theaterId;
    List<Seat> seats;

    //builder pattern
        public Show(String showId, String movieId, long startTime, long endTime, String theaterId, List<Seat> seats) {
            this.showId = showId;
            MovieId = movieId;
            this.startTime = startTime;
            EndTime = endTime;
            this.theaterId = theaterId;
            this.seats= seats;
        }

        public String getShowId() {
            return showId;
        }


        public void setShowId(String showId) {
            this.showId = showId;
        }

        public String getMovieId() {
            return MovieId;
        }

        public void setMovieId(String movieId) {
            MovieId = movieId;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getEndTime() {
            return EndTime;
        }

        public void setEndTime(long endTime) {
            EndTime = endTime;
        }

        public String getTheaterId() {
            return theaterId;
        }

        public void setTheaterId(String theaterId) {
            this.theaterId = theaterId;
        }

        public List<Seat> getSeats() {
            return seats;
        }

        public void setSeats(List<Seat> seats) {
            this.seats = seats;
        }

}
