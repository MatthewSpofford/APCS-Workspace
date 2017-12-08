
public class Roadway {

	public static void main(String[] args) {
		Vehicles[] vehicleObjs;	//Creates an array of vehicle objects
		
		
	}
	
	private static Vehicles[] initArray()
	{
		Vehicles[] output = new Vehicles[10];
		
		output[0] = new Motorbike("Harley Davidson", "Black", 120.0);
		output[1] = new GasCar("Chevy Traverse", "White", 175.5, 8);
		output[2] = new Train("Bullet Train", "Grey, Blue", 198.9, 60.00, 136);
		output[3] = new Plane("Boeing 747", "White, Blue", 550.0, 125.00, 366);
		output[4] = new Taxi("Toyota Prius", 115, 22.56, 3, 4);
		output[5] = ;
		output[6] = ;
		output[7] = ;
		output[8] = ;
		output[9] = ;

		return output;
	}

}
