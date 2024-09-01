public class Magazine extends LibraryItem {
    // Variables
    private int id;
    private String name;
    private String publisher;
    private boolean isCheckedOut;
    private int volumeNumber;
    private int issueNumber;

    // Constructor
    public Magazine(int id, String name, String publisher, boolean isCheckedOut, String genre, int volumeNumber, int issueNumber) {
        super(id, name, genre, publisher, isCheckedOut);

        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.isCheckedOut = false;
        this.volumeNumber = volumeNumber;
        this.issueNumber = issueNumber;
    }

    // Methods
    @Override
    public String displayInfo() {
        return "Magazine{id=" + id + ", name='" + name + "', publisher='" + publisher + "', isCheckedOut=" + isCheckedOut + ", volumeNumber='" + volumeNumber + "', issueNumber=" + issueNumber + "'}";
    }
}
