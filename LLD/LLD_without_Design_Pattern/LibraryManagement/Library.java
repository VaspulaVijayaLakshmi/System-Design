package LLD_without_Design_Pattern.LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> books;
    List<Patron> patrons;

     public Library(){
        this.books= new ArrayList<Book>();
        this.patrons=new ArrayList<Patron>();
     }

     public void addBook(Book book){
        this.books.add(book);
     }

     public void removeBook(Book book){
        this.books.remove(book);
     }



     //display books
     public List<Book> displayBooks(){
            return this.books;
    }

    public List<Book> displayAvailableBooks() {
        return this.books.stream()
                .filter(Book::isAvailable)
                .toList();
    }


    //search books
    public List<Book> searchBookByTitle(String title){
        List<Book> result = new ArrayList<Book>();
        for(Book book : this.books){
            if(book.getTitle().equals(title)){
                result.add(book);
            }
        }
        return result;
    }

    List<Book> searchBookByAuthor(String author){
        List<Book> result = new ArrayList<Book>();
        for(Book book : this.books){
            if(book.getAuthor().equals(author)){
                result.add(book);
            }
        }
        return result;
    }

    Book searchBookByIsbn(String isbn){
        for(Book book : this.books){
            if(book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }



    //add/remove patrons
    public void addPatron(Patron patron){
        this.patrons.add(patron);
    }

    public void removePatron(Patron patron){
         this.patrons.remove(patron);
    }

}