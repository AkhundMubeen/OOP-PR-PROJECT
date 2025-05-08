public class FanOperationThread extends Thread
{
    private ElectricFan fan;

    public FanOperationThread(ElectricFan fan) 
    {
        this.fan = fan;
    }

    @Override
    public void run() 
    {
        fan.operate();
    }
}