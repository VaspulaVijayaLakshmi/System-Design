package LLD_without_Design_Pattern.LibraryManagement;

import java.util.List;

class LibraryManagementSystemDemo {
    public static void main(String[] args) {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        Library libraryCatalog = new Library();

        // Adding books
        Book book1 = new Book("1984", "George Orwell", "1234567890");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "0987654321");

        libraryCatalog.addBook(book1);
        libraryCatalog.addBook(book2);

        // Registering Patrons
        Patron member1 = new Patron( "M001","Alice");
        Patron member2 = new Patron("M002","Bob");

        libraryCatalog.addPatron(member1);
        libraryCatalog.addPatron(member2);


        // Displaying  books
        System.out.println("Books:");
        for (Book book : libraryCatalog.displayBooks()) {
            System.out.println(book);
        }

//        ---------------------------------

        // Borrowing books
        libraryManagementSystem.lendBook(member1, book1);
        libraryManagementSystem.lendBook(member2, book2);

        // Displaying available books

        //available books should be empty as both ar elent to some users
        System.out.println("Available Books:");
        for (Book book : libraryCatalog.displayAvailableBooks()) {
            System.out.println(book);
        }

//        ---------------------------------


        // Returning books
        libraryManagementSystem.returnBook(member2,book1);

        // Displaying available books
        System.out.println("Available Books:");
        for (Book book : libraryCatalog.displayAvailableBooks()) {
            System.out.println(book);
        }

//        ---------------------------------


        //search books
        List<Book> books = libraryCatalog.searchBookByTitle("1984");
        for(Book b: books){
            System.out.println("Books with Title :  "  + b.getTitle() + "  " + b.getAuthor() + "  " + b.getIsbn() );
        }


    }
}