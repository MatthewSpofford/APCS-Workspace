#ifndef Shooter_H
#define Shooter_H

#include "Commands/Subsystem.h"
#include "WPILib.h"
#include "CANTalon.h"

class Shooter : public Subsystem {
private:
	// It's desirable that everything possible under private except
	// for methods that implement subsystem capabilities

	std::shared_ptr<CANTalon> upperShooterMotor;
	std::shared_ptr<Spark> lowerShooterMotor;

	const double P = 10;
	const double I = 0;
	const double D = 0;
public:
	Shooter();

	static constexpr double UPPER_MOTOR_SPEED = 3900;

	void InitDefaultCommand();

	void LowerShootFwd();
	void LowerShootStop();
	void LowerShootBwd();
	void UpperShootMotor(double speed);
	void UpperShootStop();
};

#endif  // Shooter_H
