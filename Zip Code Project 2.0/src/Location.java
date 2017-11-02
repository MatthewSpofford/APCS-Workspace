/**
 * Location Class
 * @author Matthew Spofford
 *
 * Stores location information, including a locations state and city
 */
public class Location {

	String city, state;	//Stores the city and state as a string
	
	/**
	 * Constructs an empty location
	 */
	public Location()
	{
		city = "";
		state = "";
	}
	
	/**
	 * Constructs a location using the given  city and state information
	 * @param city - String representation of the city being stored
	 * @param state - String representation of the state being stored
	 */
	public Location(String city, String state)
	{
		this.city = city;
		this.state = state;
	}
	
	/**
	 * Outputs the corresponding city information
	 * @return String representation of the city being stored
	 */
	public String getCity()
	{
		return city;
	}
	/**
	 * Outputs the corresponding state information
	 * @return String representation of the state being stored
	 */
	public String getState()
	{
		return state;
	}
	
	/**
	 * Changes the city information to the data given
	 * @param city - String representation of the city being stored
	 */
	public void setCity(String city)
	{
		this.city = city;
	}
	
	/**
	 * Changes the state information to the data given
	 * @param state - String representation of the state being stored
	 */
	public void setState(String state)
	{
		this.state = state;
	}
	
	/**
	 * Outputs the city information and state information, separated by spaces
	 */
	public String toString()
	{
		return getCity() + " " + getState();
	}
}
