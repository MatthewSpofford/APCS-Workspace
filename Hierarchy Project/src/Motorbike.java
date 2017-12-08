
public class Motorbike extends Bike{

	public Motorbike(String name, int year, String color, double maxSpeed) {
		super(name, color);
		setMaxSpeed(maxSpeed);
	}
	
	@Override
	public void info()
	{
		System.out.println("~Like a bike, but powered with gas!\n"
						 + "Vehicle: Motorbike\n"
						 + "Model: " + getName() + "\n"
						 + "Color: " + getColor() + "\n"
						 + "Max. Speed: " + getMaxSpeed() + "\n");
	}

}
