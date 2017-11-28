#include "ToggleGear.h"
#include "TeleopGear.h"

ToggleGear::ToggleGear() {
	// Use Requires() here to declare subsystem dependencies
	// eg. Requires(Robot::chassis.get());
	Requires(Robot::gearPickup.get());

	teleopGear.reset(new TeleopGear());
	prevState = false;
	running = false;
}

// Called just before this Command runs the first time
void ToggleGear::Initialize() {

}

// Called repeatedly when this Command is scheduled to run
void ToggleGear::Execute() {

	if(prevState == false && Robot::oi->GetRightTriggerPressed() && running == false)
	{
		teleopGear->Start();
		Robot::drivetrain->IgnoreJoystickInput(true);
		Robot::gearPickup->CompletedWallParallel = RUNNING;
		running = true;
		Robot::gearPickup->autoPlaceTriggered = true;
	}
	else if((prevState == false && Robot::oi->GetRightTriggerPressed() && running) || ( (Robot::gearPickup->CompletedWallParallel == UNASSIGNED
			 || Robot::gearPickup->CompletedWallParallel == FAILURE) && running))
	{
		teleopGear->Cancel();
		Robot::drivetrain->IgnoreJoystickInput(false);
		Robot::gearPickup->CompletedWallParallel = UNASSIGNED;
		running = false;
		Robot::gearPickup->autoPlaceTriggered = false;
	}

	SmartDashboard::PutBoolean("running", running);
	SmartDashboard::PutBoolean("PrevState", prevState);
	SmartDashboard::PutNumber("Complete Wall", Robot::gearPickup->CompletedWallParallel);
	prevState = Robot::oi->GetRightTriggerPressed();
}

// Make this return true when this Command no longer needs to run execute()
bool ToggleGear::IsFinished() {
	return Robot::StopCommands || Robot::gearPickup->CompletedWallParallel == FAILURE;
}

// Called once after isFinished returns true
void ToggleGear::End() {
	teleopGear->Cancel();
	Robot::drivetrain->IgnoreJoystickInput(false);
	running = false;
	Robot::gearPickup->autoPlaceTriggered = false;
	Robot::gearPickup->CompletedWallParallel = UNASSIGNED;
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void ToggleGear::Interrupted() {
	teleopGear->Cancel();
	Robot::drivetrain->IgnoreJoystickInput(false);
	running = false;
	Robot::gearPickup->autoPlaceTriggered = false;
	Robot::gearPickup->CompletedWallParallel = UNASSIGNED;
}
