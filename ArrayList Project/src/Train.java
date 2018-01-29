
public class Train extends Vehicle{

	public Train(String name)
	{
		super(name);
	}
	
	@Override
	public void move()
	{
		System.out.println(name+": "+"Choo Choo!!!");
	}
}
