
public interface PublicTransport {
	
	/**
	 * Sets the sale price for each person in a vehicle
	 * @param price Sets sale price to value input
	 */
	public void setSalePrice(double price);
	/**
	 * Outputs the sale price for each person in a vehicle
	 * @return Outputs sale price
	 */
	public double getSalePrice();
	
	/**
	 * Sets the maximum capacity of people
	 * @param price Sets the maximum capacity to value input
	 */
	public void setMaxCapacity(int maxNum);
	/**
	 * Outputs the maximum capacity of people
	 * @return Outputs the maximum capacity
	 */
	public int getMaxCapacity();
	
	/**
	 * Sets the number of occupants in a vehicle
	 * @param price Sets number of occupants to value input
	 */
	public void setNumOcc(int num);
	/**
	 * Outputs the number of occupants in a vehicle
	 * @return Outputs number of occupants
	 */
	public int getNumOcc();
}
