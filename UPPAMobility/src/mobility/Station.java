package mobility;

import java.util.ArrayList;
import java.util.List;

public class Station {

    private String name;
    private int capacity;
    private List<Bike> bikes;

    public Station(String name, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Argument invalide : capacite doir etre > 0");
        }
        this.name = name;
        this.capacity = capacity;
        this.bikes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isFull() {
        return bikes.size() >=capacity;
    }

    public void addBike(Bike bike) {
        if (isFull()) {
            throw new IllegalStateException("Station remplie");
        }
        if (bikes.contains(bike)) {
            throw new IllegalStateException("Deja dans la station");
        }
        bikes.add(bike);
    }

    public void removeBike(Bike bike) {
        if (!bikes.remove(bike)) {
            throw new IllegalArgumentException("Bike is not in this station");
        }
    }

    public boolean containsBike(Bike bike) {
        return bikes.contains(bike);
    }
}