package LLD_without_Design_Pattern.LibraryManagement;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class LibraryManagementSystem{

   Map<Book, Pair<Patron, Date>> borrowedBooks;

  LibraryManagementSystem(){
        borrowedBooks = new HashMap<>();
  }

  //lend book
  void lendBook(Patron patron, Book book){
        Date borrowDate = new Date();
        borrowedBooks.put(book, new Pair<>(patron, borrowDate));

        //add book to patron's borrowed books
         patron.borrowBook(book);
  }


  //return book
  void returnBook(Patron patron, Book book){
      //return Date - currDate + 14 Days
      //charge fine....
        borrowedBooks.remove(book);

        patron.returnBook(book);
  }

}

