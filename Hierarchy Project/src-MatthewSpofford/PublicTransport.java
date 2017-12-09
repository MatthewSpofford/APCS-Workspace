
/**
 * Defines the interface for public transport objects
 * @author Matthew Spofford
 * 
 */
public interface PublicTransport {
	
	/**
	 * Calculates the total cost that every passenger spent on transportation,
	 * taking into account the number of passengers and price per passenger
	 * @return Total cost spent on transport
	 */
	public double calculatePrice();
}
