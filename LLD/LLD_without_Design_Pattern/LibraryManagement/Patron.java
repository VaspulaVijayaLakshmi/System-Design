package LLD_without_Design_Pattern.LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class Patron{

        String patronId;
        String patronName;
        List<Book> borrowedBooks;

        public Patron(String patronId, String patronName){
            this.patronId = patronId;
            this.patronName = patronName;
            this.borrowedBooks = new ArrayList<Book>();
        }

        String getPatronId(){
            return this.patronId;
        }

        String getPatronName(){
            return this.patronName;
        }

        List<Book> getBorrowedBooks(){
            return this.borrowedBooks;
        }

        //borrow book
         public void borrowBook(Book book){
            if(book.isAvailable()){
                this.borrowedBooks.add(book);
                book.setAvailable(false);
            }

            else{
                System.out.println("Book is not available");
            }

         }

         public void returnBook(Book book){
            //if book is not available only though return, we can add checks
            this.borrowedBooks.remove(book);
             book.setAvailable(true);

         }

}

