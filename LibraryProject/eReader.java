public class eReader extends LibraryItem {
    // Variables
    private int id;
    private String name;
    private String creator;
    private boolean isCheckedOut;
    private String make;
    private String model;

    // Constructor
    public eReader(int id, String name, String creator, boolean isCheckedOut, String genre, String make, String model) {
        super(id, name, creator, genre, isCheckedOut);

        this.id = id;
        this.name = name;
        this.creator = creator;
        this.isCheckedOut = false;
        this.make = make;
        this.model = model;
    }

    // Methods
    @Override
    public String displayInfo() {
        return "Ereader{id=" + id + ", name='" + name + "', creator='" + creator + "', isCheckedOut=" + isCheckedOut + ", make='" + make + "', model=" + model + "'}";
    }

}
