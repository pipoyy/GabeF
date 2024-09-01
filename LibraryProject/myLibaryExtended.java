public class MyLibraryExtended {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books!
        Book book1 = new Book(451234, "The Catcher in the Rye", "J.D. Salinger", 124, "Drama", false);
        Book book2 = new Book(987867, "To Kill a Mockingbird", "", 352, "Drama", false);
        Book book3 = new Book(458713, "1984", "George Orwell", 452, "Dystopia", false);

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);

        // Adding DVDs!
        DVD dvd1 = new DVD(849471, "Office Space", "Mike Judge", false, "Comedy", 187);
        DVD dvd2 = new DVD(648503, "Titanic", "James Cameron", false, "Drama", 97);
        DVD dvd3 = new DVD(047473, "Hunger Games", "Gary Ross", false, "Dystopia", 134);

        // Adding magazines!
        Magazine magazine1 = new Magazine(28474, "Life", "Time Warner", false, "Contemporary", 34, 24001);
        Magazine magazine2 = new Magazine(464017, "People", "Time Inc.", false, "Contemporary", 36, 121);
        Magazine magazine3 = new Magazine(474917, "Field and Stream", "Time Warner", false, "Sports", 56, 8982);

        // Adding eReaders!
        eReader eReader1 = new eReader(745750, "Nook", "Barnes and Noble", false, "Device", "Nook", "GlowLight 4 Plus");
        eReader eReader2 = new eReader(474911, "Kindle", "Amazon", false, "Device", "Paperwhite", "2021");

        // Adding borrowers!
        Borrower borrower1 = new Borrower(1122014, "Cora Smith", args);
        Borrower borrower2 = new Borrower(192520109, "Tyler Hamaguchi", args);

        library.addBorrower(borrower1);
        library.addBorrower(borrower2);

        // Displaying all items in my library!
        library.allItems();
        System.out.println("");

        // Displaying items by genre in my library!
        library.displayItemsByGenre();
        System.out.println("");

        // Displaying borrowers!
        library.allBorrowers();
        System.out.println("");

        // Loaning a book to Cora!
        borrower1.borrowItem(book1);
        library.allItems();
        System.out.println("");

        // Loaning a DVD to Tyler!
        borrower2.borrowItem(dvd2);
        library.allItems();
        System.out.println("");

        // Loaning an eReader to Cora!
        borrower1.borrowItem(eReader2);
        library.allItems();
        System.out.println("");

        // Loaning a magazine to Tyler!
        borrower2.borrowItem(magazine3);
        library.allItems();
        System.out.println("");

        // Returning the book Cora borrowed!
        borrower1.returnItem(book1);
        library.allItems();
        System.out.println("");

        // Displaying Comedy items in my library!
        library.displayGenre("Comedy");

        // Displaying Drama items in my library!
        library.displayGenre("Drama");

        // Returning the DVD Tyler borrowed!
        borrower2.returnItem(dvd2);
        library.allItems();
    }
}
