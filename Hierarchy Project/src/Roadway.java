
/**
 * Is the client class of this program, which creates and uses all of the vehicle objects
 * @author Matthew Spofford
 *
 */
public class Roadway {

	public static void main(String[] args) {
		Vehicles[] vehicleObjs = initArray();	//Creates an array of vehicle objects
		
		System.out.println("Vehicles Made: " + Vehicles.getNumVehiclesMade() + "\n");
		//Loop through the vehicle objects and print their information
		for(Vehicles vehicle : vehicleObjs)
		{
			System.out.println(vehicle);
		}
		
		GasCar temp = new GasCar("", "", 0, 0);	//Used as a blank gas car to compare classes against
		GasCar[] gasCarArray = new GasCar[3];
		int index = 0;
		
		//Loop through the vehicle array to find three gas cars
		for(Vehicles vehicle : vehicleObjs)
		{
			if(temp.getClass() == vehicle.getClass())
				gasCarArray[index++] = (GasCar)vehicle;
		}
		
		GasCar car1 = gasCarArray[0];	//Create an alias of the gas car in the 0 index
		//Loop through the gas car array to compare the cars
		for(GasCar car2 : gasCarArray)
		{
			if(car1.compareTo(car2) == 0)
				System.out.println("Car 1 (" + car1.getName() + ") is equal to Car 2 (" + car2.getName() +")\n");
			else if(car1.compareTo(car2) > 0)
				System.out.println("Car 1 (" + car1.getName() + ") is greater than Car 2 (" + car2.getName() +")\n");
			else
				System.out.println("Car 1 (" + car1.getName() + ") is less than Car 2 (" + car2.getName() +")\n");
		}
	}
	
	/**
	 * Initializes a new vehicle array
	 * @return Outputs an array of vehicles
	 */
	private static Vehicles[] initArray()
	{
		Vehicles[] output = new Vehicles[13];
		
		//Initializes the vehicles to be output
		output[0]  = new Motorbike("Harley Davidson", "Black", 120.0);
		output[1]  = new GasCar("Chevy Traverse", "White", 175.5, 6);
		output[2]  = new Train("Bullet Train", "Grey, Blue", 375.5, 60.00, 136);
		output[3]  = new Plane("Boeing 747", "White, Blue", 125.00, 366);
		output[4]  = new Taxi("Toyota Prius", 115, 22.56, 3, 4);
		output[5]  = new Bike("Trek Bike", "Red, Black");
		output[6]  = new ElectricCar("Tesla Model S", "Silver", 190.0, 60);
		output[7]  = new HybridCar("Ford Fusion", "Blue", 110, 4, 35.0);
		output[8]  = output[4]; //Creates an alias of the previous taxi in the array
		output[9]  = new Bus("School Bus", "Yellow", 105.7, 0.00, 64, 8);
		output[10] = new GasCar("Nissan Maxima", "Red", 165.6, 4);
		output[11] = new Train("Monorail", "White", 198.8, 25.00, 87);
		output[12] = new GasCar("Chevy Traverse", "White", 175.5, 6);

		return output;
	}

}
