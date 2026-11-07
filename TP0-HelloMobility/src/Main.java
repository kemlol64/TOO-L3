import mobility.HelloMobility;

public class Main {

    public static void main(String[] args) {
        HelloMobility.info();

        HelloMobility service = new HelloMobility("UPPA Mobility", "Pau", 2026);
        service.greetUser("Alice");

        HelloMobility secondService = new HelloMobility("Campus Mobility", "Bayonne", 2026);
        secondService.greetUser("Bob");
    }
}