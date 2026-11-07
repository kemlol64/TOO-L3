package mobility;

public class HelloMobility {

    private String serviceName;
    private String city;
    private int yearCreated;

    // Constructeur
    public HelloMobility(String serviceName, String city, int yearCreated) {
        this.serviceName = serviceName;
        this.city = city;
        this.yearCreated = yearCreated;
    }

    // Méthode d'instance
    public void greetUser(String userName) {
        System.out.println(
            "Bienvenue sur " + serviceName
            + " (" + city + ", " + yearCreated + "), "
            + userName + " !"
        );
    }

    // Méthode statique d'information
    public static void info() {
        System.out.println("UPPA Mobility - Systeme de demonstration Java.");
    }
}