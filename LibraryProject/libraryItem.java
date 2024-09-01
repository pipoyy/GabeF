public class LibraryItem {
    // Variables
    private int id;
    private String title;
    private String author;
    private String genre;
    private boolean isCheckedOut;

    // Constructor
    public LibraryItem(int id, String title, String author, String genre, boolean isCheckedOut) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isCheckedOut = false;
    }

    // Methods
    public void lendItem() {
        if (!isCheckedOut) {
            isCheckedOut = true;
            System.out.println("Item successfully loaned!");
        } else {
            System.out.println("ERROR: This item is currently loaned by a borrower.");
        }
    }

    public void returnItem() {
        if (isCheckedOut) {
            isCheckedOut = false;
            System.out.println("Item successfully returned!");
        } else {
            System.out.println("ERROR: This item is not currently loaned by a borrower.");
        }

    }

    public String displayInfo() {
        return "Item{id=" + id + ", title='" + title + "', author='" + author + "', isCheckedOut=" + isCheckedOut + "}";
    }

    // Getters
    public String getGenre() {
        return "Genre:" + genre;
    }

    public int getItemID() {
        return id;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }




}
