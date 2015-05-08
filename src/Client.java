import java.util.Random;
public class Client
{   
    private int arrivalMin;
    private int durationAccess;
    Random rand = new Random();
    public Client()
    {
        setArrivalMin(0);   //client arrives at minute 0
        setDurationAccess(rand.nextInt(3) + 2);  //client spends either 2,3,or 4 minutes at ATM
         

    }
    public Client(int arrivalTime)
    {
        setArrivalMin(arrivalTime);
        setDurationAccess(rand.nextInt(3)+2); //client spends either 2,3, or 4 minutes at ATM
    }
    public int getArrivalMin() 
    {
		return arrivalMin;
    }
    public void setArrivalMin(int arrivalMin)
    {
		this.arrivalMin = arrivalMin;
    }
    public int getDurationAccess() 
    {	
        return durationAccess;
    }
    public void setDurationAccess(int durationAccess)
    {
		this.durationAccess = durationAccess;
    }

}


	
	

	

    

