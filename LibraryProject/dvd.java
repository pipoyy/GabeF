public class DVD extends LibraryItem {
    // Variables
    private int id;
    private String title;
    private String director;
    private boolean isCheckedOut;
    private int duration;

    // Constructor
    public DVD(int id, String title, String director, boolean isCheckedOut, String genre, int duration) {
        super(id, title, genre, director, isCheckedOut);

        this.id = id;
        this.title = title;
        this.director = director;
        this.isCheckedOut = false;
        this.duration = duration;
    }

    // Methods
    @Override
    public String displayInfo() {
        return "Dvd{id=" + id + ", title='" + title + "', director='" + director + "', isCheckedOut=" + isCheckedOut + ", duration='" + duration + "'}";
    }
}
