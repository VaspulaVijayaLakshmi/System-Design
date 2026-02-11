
Design and implement a Movie Ticket Booking System that allows users to book movie tickets, select seats, and manage shows.
The system should handle movie schedules, theater management, and seat reservations.


FR : 

Book Tickets
Select Seats
Manage SHows
Handle Movie Schedules
Theater management


NFR :

High Availability - user should check the shows/movies and book tickets
Reliable
No double booking - constsiuncy strong


Core ENtities:

Show
Movie
Theater
User
Seat
Booking


______

DB: 

Show - show Id - PK
       movie ID - FK
      theater ID - FK
      show start Time
        show end Time

Movie - MovieId
        Title
        Duration
       Language
      
Seat - SeatId - PK
       Show Id - FK
       Theater Id - FK
       

Booking - Booking Id - PK
          User Id - FK
          Show Id - FK
          Seat Id - FK
          BookingStatus
          CreatedAt
          

Theater - Theater Id - PK
          Name
          Location
          Capacity

User - User Id - PK
       Name
       Email
       Phone Number


__________       
   

APIs

/POST   booking/book
       {
            "userId": 123,
            "showId": 456,
            "theaterId": 123
            "seatIds": [1, 2, 3]
        }


/POST   booking/cancel
         {
                "bookingId": 123
         }

__________



Design Pattern :

Singleton Pattern - threater managemnet
STartegy Pattern - paymnet
Observer pattern - notify users








