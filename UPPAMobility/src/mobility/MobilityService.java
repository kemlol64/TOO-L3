package mobility;
import java.time.LocalDateTime;
public class MobilityService {

    public Rental rentBike(User user, Bike bike, Station station, LocalDateTime startTime) {
        if (!bike.isAvailable()) {
            throw new IllegalStateException("Bike is not available");
        }
        if (!station.containsBike(bike)) {
            throw new IllegalArgumentException("bike does not belong to this station");
        }

        Rental rental = new Rental(user, bike, startTime);
        station.removeBike(bike);
        bike.markRented();
        return rental;
    }

    public void returnBike(Rental rental, Station station, LocalDateTime returnTime) {
        if (!rental.isActive()) {
            throw new IllegalStateException("Rental is not active");
        }
        if (station.isFull()) {
            throw new IllegalStateException("Station is full");
        }
        if (returnTime.isBefore(rental.getStartTime())) {
            throw new IllegalArgumentException("Return time < start time");
        }
        rental.finish(returnTime);
        station.addBike(rental.getBike());
        rental.getBike().markReturned();
    }
}