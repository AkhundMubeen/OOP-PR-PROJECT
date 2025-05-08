public class ElectricFan extends Appliance
{   
    private Motor motor; 
    private Battery battery;
    private int speed; 
    private String brand;

    public ElectricFan(String brand, Battery battery, Motor motor) 
    {
        this.brand = brand;
        this.battery = battery;
        this.motor = motor;
        this.speed = 0;
    }

    public int getSpeed() 
    {
        return speed;
    }

    public void setSpeed(int speed) 
    {
        if (speed >= 0 && speed <= 5) 
        {
            this.speed = speed;
            System.out.println("Fan speed set to " + speed);
        } 
        else 
        {
            System.out.println("Invalid speed! Choose b/w 0 and 5.");
        }
    }

    public String getBrand() 
    {
        return brand;
    }

    @Override
    public synchronized void operate() 
    {
        if (isOn()) 
        {
            motor.rotateBlades(this.speed);
        } 
        else 
        {
            System.out.println("Fan is OFF. Please turn it on first.");
        }
    }

    public synchronized void showStatus() 
    {
        System.out.println();
        System.out.println("Brand: "+brand);
        System.out.println("Battery Capacity: "+battery.getCapacity());
        System.out.print("Fan is ? ");
        if (isOn()) 
        {
            System.out.println("ON");
        } 
        else 
        {
            System.out.println("OFF");
        }
        System.out.println("Current Speed: "+this.speed);
    }
}