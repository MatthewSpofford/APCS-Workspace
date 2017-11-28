#include <Swerve Drive Project/SwerveMath.h>

SwerveMath::SwerveMath(double m_length, double m_width)
{
	LENGTH = m_length;
	WIDTH = m_width;
	R = sqrt((LENGTH*LENGTH) + (WIDTH*WIDTH));
}

FILE* temp = fopen("/tmp/shouldReverse.txt", "w");

void SwerveMath::Calculate(double x, double y, double z, double angle)
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

double SwerveMath::GetFrontLeftSpeed()
{
	return flSpeed;
}
double SwerveMath::GetFrontRightSpeed()
{
	return frSpeed;
}
double SwerveMath::GetRearLeftSpeed()
{
	return rlSpeed;
}
double SwerveMath::GetRearRightSpeed()
{
	return rrSpeed;
}

double SwerveMath::GetFrontLeftRotVal()
{
	return flAngle;
}
double SwerveMath::GetFrontRightRotVal()
{
	return frAngle;
}
double SwerveMath::GetRearLeftRotVal()
{
	return rlAngle;
}
double SwerveMath::GetRearRightRotVal()
{
	return rrAngle;
}
