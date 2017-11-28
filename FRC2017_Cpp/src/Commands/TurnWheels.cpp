#include "TurnWheels.h"

TurnWheels::TurnWheels(double m_angle, double m_timeout) {
	// Use Requires() here to declare subsystem dependencies
	// eg. Requires(Robot::chassis.get());

	angle = m_angle;
	timeout = m_timeout;
}

// Called just before this Command runs the first time
void TurnWheels::Initialize() {
	SetTimeout(timeout);
}

// Called repeatedly when this Command is scheduled to run
void TurnWheels::Execute() {
	Robot::drivetrain->turnWheels(0);
}

// Make this return true when this Command no longer needs to run execute()
bool TurnWheels::IsFinished() {
	return IsTimedOut();
}

// Called once after isFinished returns true
void TurnWheels::End() {

}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void TurnWheels::Interrupted() {

}
