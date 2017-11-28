#include "Shooter.h"
#include "../RobotMap.h"


Shooter::Shooter() : Subsystem("ExampleSubsystem") {
	upperShooterMotor = RobotMap::shooterUpperShooterMotor;
	lowerShooterMotor = RobotMap::shooterLowerShooterMotor;

	upperShooterMotor->SetFeedbackDevice(CANTalon::QuadEncoder);
	upperShooterMotor->SetControlMode(CANTalon::kSpeed);
	upperShooterMotor->ConfigEncoderCodesPerRev(20);
	upperShooterMotor->ConfigPeakOutputVoltage(+12.0f, -12.0f);
	upperShooterMotor->ConfigNominalOutputVoltage(+0.0f,-0.0f);
	upperShooterMotor->SetPID(P, I, D);
}

void Shooter::InitDefaultCommand() {
	// Set the default command for a subsystem here.
	// SetDefaultCommand(new MySpecialCommand());
}

// Put methods for controlling this subsystem
// here. Call these from Commands.

void Shooter::LowerShootBwd()
{
	lowerShooterMotor->Set(-1.0);
}

void Shooter::LowerShootFwd()
{
	lowerShooterMotor->Set(1);
}

void Shooter::LowerShootStop()
{
	lowerShooterMotor->Set(0.0);
}

void Shooter::UpperShootMotor(double speed)
{
	upperShooterMotor->Set(-speed);
}

void Shooter::UpperShootStop()
{
	upperShooterMotor->Set(0);
}
