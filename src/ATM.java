public class ATM {

	private int id;
	int timeAvailable;

	public ATM(int myID)
	{
		id = myID;
		timeAvailable = 0;
	}
	
	public int getId() {
		return id;
	}
	
	public void setAvailable(int value)
	{
		timeAvailable = value;
	}
	
	public int getAvailable()
	{
		return timeAvailable;
	}

	
	
}










