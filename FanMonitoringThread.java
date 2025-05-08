public class FanMonitoringThread extends Thread
{
    private ElectricFan fan;

    public FanMonitoringThread(ElectricFan fan) 
    {
        this.fan = fan;
    }

    @Override
    public void run() 
    {
        fan.showStatus();
    }    
}
