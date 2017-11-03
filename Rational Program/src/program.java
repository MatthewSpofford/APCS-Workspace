
public class program {
	public static void main(String[] args)
	{
		Rational num1 = new Rational(1, 2);
		Rational num = new Rational(1, 2);
		if(!num1.equals(num))
			System.exit(0);;
		Rational num2 = new Rational(2, 3);
	
		System.out.println(num1.add(num2));
		System.out.println(num1.subtract(num2));
		System.out.println(num1.divide(num2));
		System.out.println(num1.multiply(num2));
		System.out.println(num1.power(2));
		
		System.out.println("\n" + Rational.add(num1, num2));
		System.out.println(Rational.subtract(num1, num2));
		System.out.println(Rational.divide(num1, num2));
		System.out.println(Rational.multiply(num1, num2));
		System.out.println(Rational.power(num1, 2));
		
		
		Rational num3;
		Rational num4;
		
		num3 = num2;
		num4 = num3;
		System.out.println("\n"+num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
				
		num3.numerToOne();
		System.out.println("\n"+num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
	}
}
