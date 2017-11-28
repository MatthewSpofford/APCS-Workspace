
public class SwerveMath {

	private final double NO_ANGLE = -999;
	private final double PI = Math.PI;
	
	public SwerveMath(double length, double width)
	{
		LENGTH = length;
		WIDTH = width;
		R = Math.sqrt((LENGTH*LENGTH) + (WIDTH*WIDTH));
	}
	
	public void Calculate(double x, double y, double z, double angle = NO_ANGLE)
	{
		if(angle != NO_ANGLE)
		{
			angle = angle * PI / 180;
			double temp = x * cos(angle) + y * sin(angle);
			y = -x * sin(angle) + y * cos(angle);
			x = temp;
		}

		double A = y - z*(LENGTH/R);
		double B = y + z*(LENGTH/R);
		double C = x - z*(WIDTH/R);
		double D = x + z*(WIDTH/R);

		double wSpeed1 = sqrt(B*B + C*C);
		double wAngle1 = atan2(B,C) * 180/PI;

		double wSpeed2 = sqrt(B*B + D*D);
		double wAngle2 = atan2(B,D) * 180/PI;

		double wSpeed3 = sqrt(A*A + D*D);
		double wAngle3 = atan2(A,D) * 180/PI;

		double wSpeed4 = sqrt(A*A + C*C);
		double wAngle4 = atan2(A,C) * 180/PI;

		//normalizes speeds so they're within the ranges of -1 to 1
		double maxSpeed = wSpeed1;
		if(wSpeed2 > maxSpeed) maxSpeed = wSpeed2;
		if(wSpeed3 > maxSpeed) maxSpeed = wSpeed3;
		if(wSpeed4 > maxSpeed) maxSpeed = wSpeed4;

		if(maxSpeed > 1)
		{
			wSpeed1/=maxSpeed;
			wSpeed2/=maxSpeed;
			wSpeed3/=maxSpeed;
			wSpeed4/=maxSpeed;
		}

		//Normalizes angles so they are within -1 to 1
		wAngle1 = wAngle1 / 360.0;
		wAngle2 = wAngle2 / 360.0;
		wAngle3 = wAngle3 / 360.0;
		wAngle4 = wAngle4 / 360.0;

		frSpeed = wSpeed2;
		frAngle = wAngle2;

		flSpeed = wSpeed1;
		flAngle = wAngle1;

		rlSpeed = wSpeed4;
		rlAngle = wAngle4;

		rrSpeed = wSpeed3;
		rrAngle = wAngle3;
	}

	public double GetFrontLeftSpeed()
	{
		return flSpeed;
	}
	public double GetFrontRightSpeed()
	{
		return frSpeed;
	}
	public double GetRearLeftSpeed()
	{
		return rlSpeed;
	}
	public double GetRearRightSpeed()
	{
		return rrSpeed;
	}

	public double GetFrontLeftRotVal()
	{
		return flAngle;
	}
	public double GetFrontRightRotVal()
	{
		return frAngle;
	}
	public double GetRearLeftRotVal()
	{
		return rlAngle;
	}
	public double GetRearRightRotVal()
	{
		return rrAngle;
	}


	private double flSpeed = 0.0;
	private double frSpeed = 0.0;
	private double rlSpeed = 0.0;
	private double rrSpeed = 0.0;

	private double flAngle = 0.0;
	private double frAngle = 0.0;
	private double rlAngle = 0.0;
	private double rrAngle = 0.0;

	private double LENGTH, WIDTH;
	private double R;
}
