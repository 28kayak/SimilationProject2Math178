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
public class Clients
{
    private int arrvalTime;
    private int serviceTime;
    
    public Clients(int arrival)
    {
        arrvalTime = arrival;
        Random rand = new Random();
        serviceTime = rand.nextInt(3)+1; 
    }
    public void setArrivalTime(int arrival)
    {
        arrvalTime = arrival;
    }
    public int getArraivalTime()
    {
        return arrvalTime;
    }
    public void setServiceTime(int ser)
    {
        serviceTime = ser;
    }
    public int getServiceTime()
    {
        return serviceTime;
    }
    
}
