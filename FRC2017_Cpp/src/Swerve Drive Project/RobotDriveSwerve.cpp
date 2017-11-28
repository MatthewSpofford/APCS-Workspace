#include "RobotDriveSwerve.h"

RobotDriveSwerve::RobotDriveSwerve(std::shared_ptr<SpeedController> frontLeftMotor,
					 std::shared_ptr<SpeedController> frontRightMotor,
					 std::shared_ptr<SpeedController> rearLeftMotor,
					 std::shared_ptr<SpeedController> rearRightMotor,

					 std::shared_ptr<SpeedController> frontLeftTurnMotor,
					 std::shared_ptr<SpeedController> frontRightTurnMotor,
					 std::shared_ptr<SpeedController> rearLeftTurnMotor,
					 std::shared_ptr<SpeedController> rearRightTurnMotor,

					 std::shared_ptr<Encoder> frontLeftEncoder,
					 std::shared_ptr<Encoder> frontRightEncoder,
					 std::shared_ptr<Encoder> rearLeftEncoder,
					 std::shared_ptr<Encoder> rearRightEncoder,	double width, double length) :

					 RobotDrive::RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor)
{
	this->m_safetyHelper->SetSafetyEnabled(false);

	frontLeftWheel.reset(new SwerveWheels(frontLeftMotor, frontLeftTurnMotor, frontLeftEncoder));
	frontRightWheel.reset(new SwerveWheels(frontRightMotor, frontRightTurnMotor, frontRightEncoder));
	rearLeftWheel.reset(new SwerveWheels(rearLeftMotor, rearLeftTurnMotor, rearLeftEncoder));
	rearRightWheel.reset(new SwerveWheels(rearRightMotor, rearRightTurnMotor, rearRightEncoder));

	mathSystem.reset(new SwerveMath(length, width));
}
RobotDriveSwerve::RobotDriveSwerve(std::shared_ptr<SpeedController> frontLeftMotor,
					 std::shared_ptr<SpeedController> frontRightMotor,
					 std::shared_ptr<SpeedController> rearLeftMotor,
					 std::shared_ptr<SpeedController> rearRightMotor,

					 std::shared_ptr<CANTalon> frontLeftTurnMotor,
					 std::shared_ptr<CANTalon> frontRightTurnMotor,
					 std::shared_ptr<CANTalon> rearLeftTurnMotor,
					 std::shared_ptr<CANTalon> rearRightTurnMotor, double width, double length) :

					RobotDrive::RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor)
{
	this->m_safetyHelper->SetSafetyEnabled(false);

	frontLeftWheel.reset(new SwerveWheels(frontLeftMotor, frontLeftTurnMotor));
	frontRightWheel.reset(new SwerveWheels(frontRightMotor, frontRightTurnMotor));
	rearLeftWheel.reset(new SwerveWheels(rearLeftMotor, rearLeftTurnMotor));
	rearRightWheel.reset(new SwerveWheels(rearRightMotor, rearRightTurnMotor));

	mathSystem.reset(new SwerveMath(length, width));
}

void RobotDriveSwerve::SwerveDrive(double x, double y, double rotation, double angle)
{
	if(GetMode() == kFieldCentric)
		mathSystem->Calculate(x, y, rotation, angle);
	else
		mathSystem->Calculate(x, y, rotation);

	SmartDashboard::PutNumber("FL Speed", mathSystem->GetFrontLeftSpeed());
	SmartDashboard::PutNumber("FL Angle", mathSystem->GetFrontLeftRotVal());

	SmartDashboard::PutNumber("FR Speed", mathSystem->GetFrontRightSpeed());
	SmartDashboard::PutNumber("FR Angle", mathSystem->GetFrontRightRotVal());

	SmartDashboard::PutNumber("RL Speed", mathSystem->GetRearLeftSpeed());
	SmartDashboard::PutNumber("RL Angle", mathSystem->GetRearLeftRotVal());

	SmartDashboard::PutNumber("RR Speed", mathSystem->GetRearRightSpeed());
	SmartDashboard::PutNumber("RR Angle", mathSystem->GetRearRightRotVal());

	frontLeftWheel->MoveWheel(mathSystem->GetFrontLeftSpeed(), mathSystem->GetFrontLeftRotVal());
	frontRightWheel->MoveWheel(mathSystem->GetFrontRightSpeed(), mathSystem->GetFrontRightRotVal());
	rearLeftWheel->MoveWheel(mathSystem->GetRearLeftSpeed(), mathSystem->GetRearLeftRotVal());
	rearRightWheel->MoveWheel(mathSystem->GetRearRightSpeed(), mathSystem->GetRearRightRotVal());
}
void RobotDriveSwerve::SwerveDrive(double x, double y, double rotation)
{
	if(GetMode() == kFieldCentric)
	{
		SwerveDrive(x, y, rotation, 0.0);
		throw std::invalid_argument("Using incorrect SwerveDrive method used in fieldcentric mode");
	}

	mathSystem->Calculate(x, y, rotation);

//	SmartDashboard::PutNumber("FL Speed", mathSystem->GetFrontLeftSpeed());
//	SmartDashboard::PutNumber("FL Angle", mathSystem->GetFrontLeftRotVal());
//
//	SmartDashboard::PutNumber("FR Speed", mathSystem->GetFrontRightSpeed());
//	SmartDashboard::PutNumber("FR Angle", mathSystem->GetFrontRightRotVal());
//
//	SmartDashboard::PutNumber("RL Speed", mathSystem->GetRearLeftSpeed());
//	SmartDashboard::PutNumber("RL Angle", mathSystem->GetRearLeftRotVal());
//
//	SmartDashboard::PutNumber("RR Speed", mathSystem->GetRearRightSpeed());
//	SmartDashboard::PutNumber("RR Angle", mathSystem->GetRearRightRotVal());

	frontLeftWheel->MoveWheel(mathSystem->GetFrontLeftSpeed(), mathSystem->GetFrontLeftRotVal());
	frontRightWheel->MoveWheel(mathSystem->GetFrontRightSpeed(), mathSystem->GetFrontRightRotVal());
	rearLeftWheel->MoveWheel(mathSystem->GetRearLeftSpeed(), mathSystem->GetRearLeftRotVal());
	rearRightWheel->MoveWheel(mathSystem->GetRearRightSpeed(), mathSystem->GetRearRightRotVal());
}

/*
void RobotDriveSwerve::ResetWheelAngle(double flEncoderAngle, double frEncoderAngle, double rlEncoderAngle, double rrEncoderAngle)
{
	double flTemp = (flEncoderAngle - m_flResetVal) / (4000);
	double frTemp = (frEncoderAngle - m_frResetVal) / (4000);
	double rlTemp = (rlEncoderAngle - m_rlResetVal) / (4000);
	double rrTemp = (rrEncoderAngle - m_rrResetVal) / (4000);

	if(m_useCANTalons)
	{
		m_frontLeftTurnMotorTalon->SetEncPosition((int)flTemp * m_gearRatio);
		m_frontRightTurnMotorTalon->SetEncPosition((int)frTemp * m_gearRatio);
		m_rearLeftTurnMotorTalon->SetEncPosition((int)rlTemp * m_gearRatio);
		m_rearRightTurnMotorTalon->SetEncPosition((int)rrTemp * m_gearRatio);
	}
	else
	{
		double flAngle = m_flResetVal / 4000;
		double frAngle = m_frResetVal / 4000;
		double rlAngle = m_rlResetVal / 4000;
		double rrAngle = m_rrResetVal / 4000;

		if(ShouldReverse(flAngle, flTemp))
		{
			if(flAngle<0) flAngle+=0.5;
			else flAngle -= 0.5;
		}
		if(ShouldReverse(frAngle, frTemp))
		{
			if(frAngle<0) frAngle+=0.5;
			else frAngle -= 0.5;
		}
		if(ShouldReverse(rlAngle, rlTemp))
		{
			if(rlAngle<0) rlAngle+=0.5;
			else rlAngle -= 0.5;
		}
		if(ShouldReverse(rrAngle, rrTemp))
		{
			if(rrAngle<0) rrAngle+=0.5;
			else rrAngle -= 0.5;
		}

		SetAngle(flAngle, frAngle, rlAngle, rrAngle);
		m_frontLeftEncoder->Reset();
		m_frontRightEncoder->Reset();
		m_rearLeftEncoder->Reset();
		m_rearRightEncoder->Reset();
	}
}
void RobotDriveSwerve::SetResetWheelValues(double frontLeftVal, double frontRightVal, double rearLeftVal, double rearRightVal)
{
	m_flResetVal = frontLeftVal;
	m_frResetVal = frontRightVal;
	m_rlResetVal = rearLeftVal;
	m_rrResetVal = rearRightVal;
}
*/
void RobotDriveSwerve::StopMotor()
{
	frontLeftWheel->StopWheel();
	frontRightWheel->StopWheel();
	rearLeftWheel->StopWheel();
	rearRightWheel->StopWheel();
}
void RobotDriveSwerve::SetInvertedMotor(MotorType motor, bool isInverted)
{
	switch(motor)
	{
	case(kFrontLeftMotor):
		frontLeftWheel->SetInverted(SwerveWheels::MoveMotor, isInverted);
		break;
	case(kFrontRightMotor):
		frontRightWheel->SetInverted(SwerveWheels::MoveMotor, isInverted);
		break;
	case(kRearLeftMotor):
		rearLeftWheel->SetInverted(SwerveWheels::MoveMotor, isInverted);
		break;
	case(kRearRightMotor):
		rearRightWheel->SetInverted(SwerveWheels::MoveMotor, isInverted);
		break;
	case(kFrontLeftTurnMotor):
		frontLeftWheel->SetInverted(SwerveWheels::TurnMotor, isInverted);
		break;
	case(kFrontRightTurnMotor):
		frontRightWheel->SetInverted(SwerveWheels::TurnMotor, isInverted);
		break;
	case(kRearLeftTurnMotor):
		rearLeftWheel->SetInverted(SwerveWheels::TurnMotor, isInverted);break;
	case(kRearRightTurnMotor):
		rearRightWheel->SetInverted(SwerveWheels::TurnMotor, isInverted);
		break;
	}
}

int RobotDriveSwerve::GetMode()
{
	return m_mode;
}
void RobotDriveSwerve::SetMode(DriveMode mode)
{
	switch(mode)
	{
	case(kFieldCentric):
		m_mode = kFieldCentric;
		break;
	case(kRobotCentric):
		m_mode = kRobotCentric;
		break;
	default:
		DriverStation::ReportError("ERROR: Invalid drivetrain mode input");
	}
}

void RobotDriveSwerve::SetPID(double P, double I, double D, double F)
{
	frontLeftWheel->SetPID(P, I, D, F);
	frontRightWheel->SetPID(P, I, D, F);
	rearLeftWheel->SetPID(P, I, D, F);
	rearRightWheel->SetPID(P, I, D, F);
}
/*
void RobotDriveSwerve::SetGearRatio(double val)
{
	m_gearRatio = val;
}
void RobotDriveSwerve::SetPulsePerRot(double val)
{
	if(m_useCANTalons)
	{
		m_frontLeftTurnMotorTalon->ConfigEncoderCodesPerRev((int)val);
		m_frontRightTurnMotorTalon->ConfigEncoderCodesPerRev((int)val);
		m_rearLeftTurnMotorTalon->ConfigEncoderCodesPerRev((int)val);
		m_rearRightTurnMotorTalon->ConfigEncoderCodesPerRev((int)val);
	}
	else
	{
		m_frontLeftEncoder->SetSamplesToAverage(val);
		m_frontRightEncoder->SetSamplesToAverage(val);
		m_rearLeftEncoder->SetSamplesToAverage(val);
		m_rearRightEncoder->SetSamplesToAverage(val);
	}
}
*/

