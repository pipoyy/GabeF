import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> items;
    private List<Borrower> borrowers;

    // Constructor
    public Library() {
        this.items = new ArrayList<>();
        this.borrowers = new ArrayList<>();
    }

    // Methods
    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void checkOutItem(int itemID, int borrowerID) {
        LibraryItem item = null;
        for (LibraryItem i : items) {
            if (i.getItemID() == itemID) {
                item = i;
                break;
            }
        }

        Borrower borrower = null;
        for (Borrower bor : borrowers) {
            if (bor.getID() == borrowerID) {
                borrower = bor;
                break;
            }
        }
    }

    public void returnItem(int itemID, int borrowerID) {
        LibraryItem item = null;
        for (LibraryItem i : items) {
            if (i.getItemID() == itemID) {
                item = i;
                break;
            }
        }

        Borrower borrower = null;
        for (Borrower bor : borrowers) {
            if (bor.getID() == borrowerID) {
                borrower = bor;
                break;
            }
        }
    }

    public void allItems() {
        for (LibraryItem item : items) {
            System.out.println(item);
        }
    }

    public void allBorrowers() {
        for (Borrower borrower : borrowers) {
            System.out.println(borrower);
        }
    }

    public void displayGenre(String genre) {
        List<String> genres = new ArrayList<>();
            if (!genres.contains(genre)) {
                System.out.println("Genre:" + genre);
                for (LibraryItem i : items) {
                    if (i.getGenre().equalsIgnoreCase(genre)) {
                        System.out.println("" + i);
                    }
                }
            }
        }
    }

    public void displayItemsByGenre() {
        List<String> genres = new ArrayList<>();
        for (LibraryItem item : items) {
            String genre = item.getGenre();
            if (!genres.contains(genre)) {
                System.out.println("Genre:" + genre);
                for (LibraryItem i : items) {
                    if (i.getGenre().equalsIgnoreCase(genre)) {
                        System.out.println(" " + i);
                    }
                }
                genres.add(genre);
            }

        }
    }
}
