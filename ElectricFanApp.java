import java.util.Scanner;

public class ElectricFanApp 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        Battery battery = new Battery(5000);
        ElectricFan fan = new ElectricFan("Khurshid FANS", battery, new Motor());

        boolean exit = false;

        try
        {
        while (!exit) 
        {
            System.out.println("\n=== Electric Fan Console ===");
            System.out.println("1. Turn ON Fan");
            System.out.println("2. Turn OFF Fan");
            System.out.println("3. Set Fan Speed (0-5)");
            System.out.println("4. Operate Fan");
            System.out.println("5. Show Status");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            if(choice==1) 
            {
                fan.turnOn();
            } 
            else if(choice==2) 
            {
                fan.turnOff();
            } 
            else if (choice==3) 
            {
                System.out.print("Enter speed (0-5): ");
                int speed = sc.nextInt();
                fan.setSpeed(speed);
            } 
            else if (choice==4) 
            {
                Thread t1 = new FanOperationThread(fan);
                t1.start();
                t1.join(); 
            } 
            else if (choice==5) 
            {
                Thread t2 = new FanMonitoringThread(fan);
                t2.start();
                t2.join();
            } 
            else if (choice==6) 
            {
                System.out.println("Exiting...");
                exit = true;
            } 
            else 
            {
                System.out.println("Invalid option.");
            }
        }
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }

        sc.close();
    }    
}
