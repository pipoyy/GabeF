public class Genre {
    // Variables
    private String name;

    // Constructor
    public Genre(String name) {
        this.name = name;
    }

    // Methods
    public String getName() {
        return name;
    }

    public String toString() {
        return "Genre" + getName();
    }
}
