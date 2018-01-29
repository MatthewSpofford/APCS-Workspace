
public class Plane extends Vehicle{

	public Plane(String name)
	{
		super(name);
	}
	
	@Override
	public void move()
	{
		System.out.println(name+": "+"Woosh!!!");
	}
}
