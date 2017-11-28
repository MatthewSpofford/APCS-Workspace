#include "DriveSideways.h"

DriveSideways::DriveSideways(double m_speed, double m_distance, bool m_fieldCentric, double m_angle) : Command() {
	// Use Requires() here to declare subsystem dependencies
	// eg. Requires(Robot::chassis.get());

	fieldCentric = m_fieldCentric;
	speed = m_speed;
	angle = m_angle;
	distance = m_distance;

#ifndef USE_COUNTER
	SetTimeout(m_distance);
#endif
}

// Called just before this Command runs the first time
void DriveSideways::Initialize() {
	Robot::drivetrain->ResetDistEnc();
}

// Called repeatedly when this Command is scheduled to run
void DriveSideways::Execute() {
#ifndef USE_COUNTERR
	if(!(IsTimedOut() && Robot::gearPickup->CompletedWallParallel == FAILURE))
#else
	if(!(IsTimedOut() && Robot::gearPickup->CompletedWallParallel == FAILURE && Robot::drivetrain->GetDistanceTraveled() > distance))
#endif
	{
		if(angle == -999)
			Robot::drivetrain->DriveControl(0.0, -speed, 0.0, fieldCentric, true);
		else
			Robot::drivetrain->DriveControl(0.0, -speed, Robot::drivetrain->TurnToAngle(angle), fieldCentric, true);
	}
}

// Make this return true when this Command no longer needs to run execute()
bool DriveSideways::IsFinished() {
#ifdef USE_COUNTER
	return Robot::drivetrain->GetDistanceTraveled() >= distance|| Robot::gearPickup->CompletedWallParallel == FAILURE;
#else
	return IsTimedOut() || Robot::gearPickup->CompletedWallParallel == FAILURE;
#endif
}

// Called once after isFinished returns true
void DriveSideways::End() {
	Robot::drivetrain->StopDrive();
	Robot::drivetrain->ResetDistEnc();
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void DriveSideways::Interrupted() {
	Robot::drivetrain->StopDrive();
	Robot::drivetrain->ResetDistEnc();
}
