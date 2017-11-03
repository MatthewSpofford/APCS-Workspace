
//********************************************************************
//  Rational.java       Author: Lewis/Loftus/Cocking
//
//  Represents one rational number with a numerator and denominator.
//********************************************************************

public class Rational implements Comparable<Rational>, DoubleValue
{
   private int numerator, denominator;

   //-----------------------------------------------------------------
   //  Sets up the rational number by ensuring a nonzero denominator
   //  and making only the numerator signed.
   //-----------------------------------------------------------------
   public Rational (int numer, int denom)
   {
      if (denom == 0)
      denom = 1;

      // Make the numerator "store" the sign
      if (denom < 0)
      {
      numer = numer * -1;
      denom = denom * -1;
      }

      numerator = numer;
      denominator = denom;
      reduce();
   }

   //-----------------------------------------------------------------
   //  Returns the numerator of this rational number.
   //-----------------------------------------------------------------
   public int getNumerator ()
   {
      return numerator;
   }

   //-----------------------------------------------------------------
   //  Returns the denominator of this rational number.
   //-----------------------------------------------------------------
   public int getDenominator ()
   {
      return denominator;
   }

   //-----------------------------------------------------------------
   //  Returns the reciprocal of this rational number.
   //-----------------------------------------------------------------
   public Rational reciprocal ()
   {
      return new Rational (denominator, numerator);
   }

   public static Rational add(Rational num1, Rational num2)
	{
		return num1.add(num2);
	}
	
	public static Rational subtract(Rational num1, Rational num2)
	{
		return num1.subtract(num2);
	}
	
	public static Rational divide(Rational num1, Rational num2)
	{
		return num1.divide(num2);
	}
	
	public static Rational multiply(Rational num1, Rational num2)
	{
		return num1.multiply(num2);
	}
   
	public static Rational power(Rational num, int power)
	{
		return num.power(power);
	}
	
   //-----------------------------------------------------------------
   //  Adds this rational number to the one passed as a parameter.
   //  A common denominator is found by multiplying the individual
   //  denominators.
   //-----------------------------------------------------------------
   public Rational add (Rational op2)
   {
      int commonDenominator = denominator * op2.getDenominator();
      int numerator1 = numerator * op2.getDenominator();
      int numerator2 = op2.getNumerator() * denominator;
      int sum = numerator1 + numerator2;

      return new Rational (sum, commonDenominator);
   }

   //-----------------------------------------------------------------
   //  Subtracts the rational number passed as a parameter from this
   //  rational number.
   //-----------------------------------------------------------------
   public Rational subtract (Rational op2)
   {
      int commonDenominator = denominator * op2.getDenominator();
      int numerator1 = numerator * op2.getDenominator();
      int numerator2 = op2.getNumerator() * denominator;
      int difference = numerator1 - numerator2;

      return new Rational (difference, commonDenominator);
   }

   //-----------------------------------------------------------------
   //  Multiplies this rational number by the one passed as a
   //  parameter.
   //-----------------------------------------------------------------
   public Rational multiply (Rational op2)
   {
      int numer = numerator * op2.getNumerator();
      int denom = denominator * op2.getDenominator();
      return new Rational (numer, denom);
   }

   //-----------------------------------------------------------------
   //  Divides this rational number by the one passed as a parameter
   //  by multiplying by the reciprocal of the second rational.
   //-----------------------------------------------------------------
   public Rational divide (Rational op2)
   {
      return multiply (op2.reciprocal());
   }

   public Rational power (int power)
   {
	   Rational temp = new Rational(numerator, denominator);
	   
	   if(power > 1)
	   for(int i = 1; i < power; i++)
		   temp = temp.multiply(this);
	   
	   return temp;
   }

   //-----------------------------------------------------------------
   //  Returns this rational number as a string.
   //-----------------------------------------------------------------
   public String toString ()
   {
      String result;

      if (numerator == 0)
         result = "0";
      else
         if (denominator == 1)
            result = numerator + "";
         else
            result = numerator + "/" + denominator;
      return result;
   }

   //-----------------------------------------------------------------
   //  Reduces this rational number by dividing both the numerator
   //  and the denominator by their greatest common divisor.
   //-----------------------------------------------------------------
   private void reduce ()
   {
      if (numerator != 0)
      {
         int common = gcd (Math.abs(numerator), denominator);

         numerator = numerator / common;
         denominator = denominator / common;
      }
   }

   //-----------------------------------------------------------------
   //  Computes and returns the greatest common divisor of the two
   //  positive parameters. Uses Euclid's algorithm.
   //-----------------------------------------------------------------
   private int gcd (int num1, int num2)
   {
      while (num1 != num2)
         if (num1 > num2)
            num1 = num1 - num2;
         else
            num2 = num2 - num1;

      return num1;
   }
   
   public void numerToOne()
   {
	   this.numerator = 1;
   }
   
   @Override
   public boolean equals(Object obj)
   {
	   if(obj == this)
		   return true;
	   
	   if (obj instanceof Rational) 
	   {
		   Rational new_name = (Rational) obj;
		   if(this.numerator == new_name.numerator && 
			  this.denominator == new_name.denominator)
			   return true;
		   else
			   return false;
	   }
	   else
		   return false;
   }

   @Override
   public int compareTo(Rational o) {
	   double obj1 = this.toDouble();
	   double obj2 = o.toDouble();
	   
	   if(obj1 == obj2)
		   return 0;
	   else if(obj1 < obj2)
		   return 1;
	   else
		   return -1;
   }
   

	@Override
	public double toDouble() {
		return (double) numerator / (double) denominator;
	}
}
