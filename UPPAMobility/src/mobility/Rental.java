package mobility;
import java.time.LocalDateTime;
public class Rental {
    private User user;
    private Bike bike;
    private LocalDateTime startTime;
    private LocalDateTime endtTime;
    public Rental (User user,Bike bike,LocalDateTime starTime){
        this.user=user;
        this.bike=bike;
        this.startTime=starTime;
    }
    public User getUser (){
        return user;
    }
    public Bike getBike () {
        return bike;
    }
    public LocalDateTime getStartTime () {
        return startTime;
    }
    public LocalDateTime getReturnTime () {
        return endtTime;
    }
    
    public boolean isActive () {
        return endtTime==null;
    }
    public void finish ( LocalDateTime returnTime ) {
        if(!isActive()){
           throw new IllegalStateException("Rental deja finie"); 
        }
        if (returnTime.isBefore(startTime)) {
            throw new IllegalArgumentException("Return time before start time");
        }
        this.endtTime = returnTime;
    }
}
