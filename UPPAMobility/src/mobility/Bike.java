package mobility;

public class Bike {

    private final String id;
    private boolean available;

    public Bike(String id) {
        this.id = id;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    void markRented() {
        this.available = false;
    }

    void markReturned() {
        this.available = true;
    }
}