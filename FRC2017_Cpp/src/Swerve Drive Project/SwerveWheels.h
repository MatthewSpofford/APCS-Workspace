#pragma once

#include "Commands/Subsystem.h"
#include "WPILib.h"
#include "CANTalon.h"
#include "SwerveMath.h"

class SwerveWheels {

public:
	enum MotorType{
		MoveMotor,
		TurnMotor
	};

	SwerveWheels(	std::shared_ptr<SpeedController> m_moveMotor,
					std::shared_ptr<SpeedController> m_turnMotor,
					std::shared_ptr<Encoder> m_encoder);

	SwerveWheels(	std::shared_ptr<SpeedController> m_moveMotor,
					std::shared_ptr<CANTalon> m_turnMotor);

	void MoveWheel(double speedVal, double rotationVal);
	void StopWheel();
	void SetInverted(MotorType type, bool val);
	void SetPID(double P, double I, double D, double F);

private:
	bool ShouldReverse(double desiredPos);

	//Outputs encoder values for the corresponding motor
	double GetEncoderVal();

	void SetSpeed(double speedVal);
	void SetAngle(double rotationVal);

	std::shared_ptr<SpeedController> moveMotor;
	std::shared_ptr<SpeedController> turnMotor;
	std::shared_ptr<CANTalon> turnMotor_CANTalon;
	std::unique_ptr<PIDController> controlPID;
	std::shared_ptr<Encoder> encoder;

	bool useCANTalon;
	double gearRatio = 1988/1.2;
};

