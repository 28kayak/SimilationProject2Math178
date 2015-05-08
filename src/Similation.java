/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kaya
 */
import java.util.*;
import java.util.Queue;
public class Similation
{
    Clients clients;
    int ATMisAvaialbe;
    int numArrivals;
    Queue<Clients> queue;
    //statistics 
    int totalWaitingTime;
    int numClientsServes; 
    public Similation()
    {
        ATMisAvaialbe = 0;
        numArrivals = 0;
        totalWaitingTime = 0;
        queue = new LinkedList<Clients>();
    }
    private int getArrivals()
    {
        Random rand = new Random();
        int randInt = rand.nextInt(10);
        if(randInt <= 4)
        {
            return 0; //50% chance of a single arrival
        }
        if(randInt <= 8)
        {
            return 1;//40%
        }
        else
        {
            return 2;//10%
        }
    }
    public void displayStatistics()
    {
        System.out.println("Number of customers served "+ numClientsServes);
        System.out.println("Average wait is about   " + totalWaitingTime/numClientsServes + "         min");
        System.out.println("Customers left in Q = " + queue.size() );
        
        
    }
    public void simulate()
    {
        int timeperiod = 60;
        int min = 0;
        for(min = 0; min < timeperiod; min++)
        {
            numArrivals = getArrivals();
            for(int i = 1; i <= numArrivals; i++)
            {
                queue.add(new Clients(min));
                
            }
            if(!queue.isEmpty()&& ATMisAvaialbe <= min)
            {
                clients = queue.remove();
                ATMisAvaialbe = min + clients.getServiceTime();
                int timeClientWaited = min - clients.getArraivalTime();
                totalWaitingTime += timeClientWaited;
                numClientsServes++;    
            }
            else
            {
                //System.out.println("queue is empty");
            }
        }//for-time
        displayStatistics();
    }
    public static void main(String[] args)
    {
        
        
        int i = 0;
        while(i <=10)
        {
            Similation simulator = new Similation();
            simulator.simulate();
            i ++;
        }
    }
    
    
}//class