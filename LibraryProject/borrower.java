import java.util.ArrayList;
import java.util.List;

public class Borrower {
    // Variables
    private int id;
    private String name;
    private List<LibraryItem> borrowedItems;
    
    // Constructor
    public Borrower(int id, String name, String[] borrowedItems) {
        this.id = id;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    // Methods
    public void borrowItem(LibraryItem item) {
        if (!item.isCheckedOut()) {
            item.lendItem();
            borrowedItems.add(item);
        } else {
            System.out.println("ERROR: This item is checked out.");
        }
    }

    public void returnItem(LibraryItem item) {
        if (borrowedItems.contains(item)) {
            item.returnItem();
            borrowedItems.remove(item);
        } else {
            System.out.println("ERROR: The borrower is currently not borrowing any books.");
        }
    }

    public String toString() {
        return "Borrower{id=" + id + ", name='" + name + "', borrowedItems=" + borrowedItems + "}";
    }

    // Getters
    public int getID() {
        return id;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }
}
