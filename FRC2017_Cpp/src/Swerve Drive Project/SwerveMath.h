
#pragma once

#include "Commands/Subsystem.h"
#include "WPILib.h"

class SwerveMath {

public:
	SwerveMath(double length, double width);

	void Calculate(double x, double y, double z, double angle = NO_ANGLE);

	double GetFrontLeftSpeed();
	double GetFrontRightSpeed();
	double GetRearLeftSpeed();
	double GetRearRightSpeed();

	double GetFrontLeftRotVal();
	double GetFrontRightRotVal();
	double GetRearLeftRotVal();
	double GetRearRightRotVal();

private:
	static constexpr double NO_ANGLE = -999;
	static constexpr double PI = acos(-1);

	double flSpeed = 0.0;
	double frSpeed = 0.0;
	double rlSpeed = 0.0;
	double rrSpeed = 0.0;

	double flAngle = 0.0;
	double frAngle = 0.0;
	double rlAngle = 0.0;
	double rrAngle = 0.0;

	double LENGTH, WIDTH;
	double R;
};
