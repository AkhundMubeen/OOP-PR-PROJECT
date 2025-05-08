public abstract class Appliance
{
    private boolean isOn;

    public void turnOn() 
    {
        isOn = true;
        System.out.println("FAN turned ON.");
    }

    public void turnOff() 
    {
        isOn = false;
        System.out.println("FAN turned OFF.");
    }

    public boolean isOn() 
    {
        return isOn;
    }

    public abstract void operate();

}