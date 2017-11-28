#include "toggleDriveMode.h"

toggleDriveMode::toggleDriveMode() {
	// Use Requires() here to declare subsystem dependencies
	// eg. Requires(Robot::chassis.get());
}

// Called just before this Command runs the first time
void toggleDriveMode::Initialize() {
	if(Robot::drivetrain->fieldCentric)
		Robot::drivetrain->climberCentric = true;
	else
		Robot::drivetrain->climberCentric = false;
}

// Called repeatedly when this Command is scheduled to run
void toggleDriveMode::Execute() {

}

// Make this return true when this Command no longer needs to run execute()
bool toggleDriveMode::IsFinished() {
	return true;
}

// Called once after isFinished returns true
void toggleDriveMode::End() {

}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void toggleDriveMode::Interrupted() {

}
