#include "ClimberCentric.h"

ClimberCentric::ClimberCentric() {
	// Use Requires() here to declare subsystem dependencies
	// eg. Requires(Robot::chassis.get());
}

// Called just before this Command runs the first time
void ClimberCentric::Initialize() {

}

// Called repeatedly when this Command is scheduled to run
void ClimberCentric::Execute() {
	Robot::drivetrain->climberCentric = true;
}

// Make this return true when this Command no longer needs to run execute()
bool ClimberCentric::IsFinished() {
	return false;
}

// Called once after isFinished returns true
void ClimberCentric::End() {
	Robot::drivetrain->climberCentric = false;
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void ClimberCentric::Interrupted() {
	Robot::drivetrain->climberCentric = false;
}
