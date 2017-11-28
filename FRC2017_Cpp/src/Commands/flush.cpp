#include "flush.h"

flush::flush() {
	// Use Requires() here to declare subsystem dependencies
	// eg. Requires(Robot::chassis.get());
}

// Called just before this Command runs the first time
void flush::Initialize() {

}

// Called repeatedly when this Command is scheduled to run
void flush::Execute() {
	if(!(Robot::intake->intakePressed))
	{
		Robot::intake->flushIntake();
	}
}

// Make this return true when this Command no longer needs to run execute()
bool flush::IsFinished() {
	return Robot::intake->intakePressed;
}

// Called once after isFinished returns true
void flush::End() {
	Robot::intake->stopIntake();
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void flush::Interrupted() {
	Robot::intake->stopIntake();
}
