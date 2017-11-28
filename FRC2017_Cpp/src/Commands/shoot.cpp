#include "shoot.h"

shoot::shoot() {
	// Use Requires() here to declare subsystem dependencies
	// eg. Requires(Robot::chassis.get());
}

// Called just before this Command runs the first time
void shoot::Initialize() {
	SetTimeout(0.3);
}

// Called repeatedly when this Command is scheduled to run
void shoot::Execute() {
	Robot::shooter->UpperShootMotor(Shooter::UPPER_MOTOR_SPEED);
	if(IsTimedOut())
		Robot::shooter->LowerShootFwd();
}

// Make this return true when this Command no longer needs to run execute()
bool shoot::IsFinished() {
	return false;
}

// Called once after isFinished returns true
void shoot::End() {
	Robot::shooter->UpperShootStop();
	Robot::shooter->LowerShootStop();
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void shoot::Interrupted() {
	Robot::shooter->UpperShootStop();
	Robot::shooter->LowerShootStop();
}
