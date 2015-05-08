import java.util.*;


public class Simulation
{
    private Queue<Client> queue;
    private Client client;
    private ATM[] atmList;
    //int ATMisAvaialbe;
    private int numberOfATM;
    private int totalWaitingTime;
    private int currentNumArrivals;
    private int numClientsServed; 
    
    public Simulation(int numOfATM)
    {
    	numberOfATM = numOfATM;
        currentNumArrivals = 0;
        totalWaitingTime = 0;
        queue = new LinkedList<Client>();
        atmList = new ATM[numberOfATM];
        
        for(int i= 0; i < atmList.length; i++)
        {
        	atmList[i] = new ATM(i);
        }
    }
    private int getNumArrivals()
    {
        Random rand = new Random();
        int randInt = rand.nextInt(100) + 1;
        if(randInt <= 40)
        {
            return 0; //40% chance of no arrival
        }
        if(randInt <= 75)
        {
            return 1;//35% chance of 1 arrival
        }
        else
        {
            return 2;//25% chance of 2 arrivals
        }
    }
    public void displayStatistics()
    {
        System.out.println("Number of customers served "+ numClientsServed);
        System.out.println("Average wait is about   " + totalWaitingTime/numClientsServed + "         min");
        System.out.println("Customers left in Q = " + queue.size() );
        
    }
    public void simulate()
    {
        int timeperiod = 60;
        for(int min = 0; min < timeperiod; min++)
        {
            currentNumArrivals = getNumArrivals();
            for(int i = 1; i <= currentNumArrivals; i++)
            {
                queue.add(new Client(min));
                
            }
            
            
            if(!queue.isEmpty()&& getATMAvailable(min))
            {               
                numClientsServed++;    
            }
        }//for-time
        displayStatistics();
    }
    
    public boolean getATMAvailable(int t)    //check if there is available ATM at time t
    {
    	for(int i = 0; i < atmList.length; i++)
    	{
    		if(atmList[i].getAvailable() <= t)
    			{
    	    	client = queue.remove();
    			atmList[i].setAvailable(t + client.getDurationAccess());
                int timeClientWaited = t - client.getArrivalMin();
                totalWaitingTime += timeClientWaited;
    			return true;
    			}
    	}
    	return false;
    	
    	
    }
    public static void main(String[] args)
    {
        
        System.out.println("===================");
        System.out.println("With one ATM:");
        System.out.println("===================");
        int i = 0;
        while(i <=10)
        {
            Simulation simulator = new Simulation(1);
            simulator.simulate();
            i ++;
        }
        System.out.println("===================");
        System.out.println("With two ATMs:");
        System.out.println("===================");
        i = 0;
        while(i <=10)
        {
            Simulation simulator = new Simulation(2);
            simulator.simulate();
            i ++;
        }
         System.out.println("===================");
        System.out.println("With three ATMs:");
        System.out.println("===================");
        i = 0;
        while(i <=10)
        {
            Simulation simulator = new Simulation(3);
            simulator.simulate();
            i ++;
        }
    }
    
    
}//class
