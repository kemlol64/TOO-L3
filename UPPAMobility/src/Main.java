import java.time.LocalDateTime;

import mobility.Bike;
import mobility.MobilityService;
import mobility.Rental;
import mobility.Station;
import mobility.User;

public class Main {

    public static void main(String[] args) {
        Station campusNord = new Station("Campus Nord", 5);
        Station bibliotheque = new Station("Bibliotheque", 5);

        User alice = new User("U-1", "Alice");
        Bike b104 = new Bike("B-104");

        campusNord.addBike(b104);
        System.out.println(b104.getId() + " initially at " + campusNord.getName()
                + ": " + campusNord.containsBike(b104));

        MobilityService service = new MobilityService();

        LocalDateTime start = LocalDateTime.of(2026, 10, 12, 9, 0);
        LocalDateTime end = LocalDateTime.of(2026, 10, 12, 11, 30);

        Rental rental = service.rentBike(alice, b104, campusNord, start);
        System.out.println(rental.getUser().getName() + " rents "
                + rental.getBike().getId() + " at " + rental.getStartTime().toLocalTime());
        System.out.println(b104.getId() + " available: " + b104.isAvailable());
        System.out.println(b104.getId() + " still at " + campusNord.getName()
                + ": " + campusNord.containsBike(b104));

        service.returnBike(rental, bibliotheque, end);
        System.out.println(rental.getUser().getName() + " returns "
                + rental.getBike().getId() + " at " + bibliotheque.getName()
                + " at " + rental.getReturnTime().toLocalTime());
        System.out.println("Rental active: " + rental.isActive());
        System.out.println(b104.getId() + " now at " + bibliotheque.getName()
                + ": " + bibliotheque.containsBike(b104));
    }
}