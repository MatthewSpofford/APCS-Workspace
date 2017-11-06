
public class Complex {
	
	private double a;
	private double b;
	
	public Complex(double a, double b)
	{
		this.a = a;
		this.b = b;
	}
	
	public double getA()
	{
		return a;
	}
	
	public double getB()
	{
		return b;
	}
	
	public Complex add(Complex num)
	{
		Complex temp = new Complex(this.a + num.a, this.b + num.b);
		return temp;
	}
	
	public Complex multiply(Complex num)
	{
		double tempA = (this.a * num.a) + (this.b * num.b) * -1.0;
		double tempB = (this.a * this.b) + (this.b * num.a);
		Complex temp = new Complex(tempA, tempB);
		return temp;
	}
	
	public Complex divide(Complex num)
	{
		double tempDenom = (this.b * num.b) + (this.b * num.b);
		double tempA = ( (this.a * num.a) + (this.b * num.b) ) / tempDenom;
		double tempB = ( (this.a * this.b) + (this.b * num.a)) / tempDenom;
		Complex tempNum = new Complex(tempA, tempB);
		return tempNum;
	}
}
