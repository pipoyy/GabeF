public class Book extends LibraryItem {
    // Variables
    private int id;
    private String title;
    private String author;
    private boolean isCheckedOut;
    private int numberPages;

    // Constructor
    public Book(int id, String title, String author, int numberPages, String genre, boolean isCheckedOut)  {
        super(id, title, author, genre, isCheckedOut);
        
        this.id = id;
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
        this.numberPages = numberPages;
    }

    // Methods
    public void lendBook() {
        if (!isCheckedOut) {
            isCheckedOut = true;
        } else {
            System.out.println("ERROR: This book is checked out.");
        }
        
    }

    public void returnBook() {
        if (isCheckedOut) {
            isCheckedOut = false;
        } else {
            System.out.println("ERROR: This book is not checked out.");
        }
    }

    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', author='" + author + "', numberPages=" + numberPages + "', isCheckedOut=" + isCheckedOut + "}";
    }

    // Getters
    public int getID() {
        return id;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }
}
