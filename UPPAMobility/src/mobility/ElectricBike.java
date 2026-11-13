package mobility;

public class ElectricBike extends Bike{
    private int batteryLevel;
    public ElectricBike ( String id , int batteryLevel ) {
        super(id);
        if(batteryLevel>100 ||batteryLevel<0)
          throw new IllegalArgumentException (" Invalid battery level ") ;  
        this.batteryLevel=100;
    }
    public int getBatteryLevel(){
        return this.batteryLevel;
    }
    @Override 
    public boolean canBeRented () {
        //return (this.isAvailable() && this.batteryLevel>=10); en ecrivant direct sans heriter
        return super.canBeRented() && this.batteryLevel>=10;
    }
}