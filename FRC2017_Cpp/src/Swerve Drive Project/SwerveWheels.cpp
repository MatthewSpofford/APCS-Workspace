#include <Swerve Drive Project/SwerveWheels.h>

SwerveWheels::SwerveWheels(	std::shared_ptr<SpeedController> m_moveMotor,
							std::shared_ptr<SpeedController> m_turnMotor,
							std::shared_ptr<Encoder> m_encoder)
{
	moveMotor = m_moveMotor;
	turnMotor = m_turnMotor;

	encoder = m_encoder;
	controlPID.reset(new PIDController(10.0, 0.0, 0.0, encoder.get(), turnMotor.get()));
	controlPID->SetSetpoint(0.0);
	encoder->Reset();

	useCANTalon = true;
}
SwerveWheels::SwerveWheels(	std::shared_ptr<SpeedController> m_moveMotor,
							std::shared_ptr<CANTalon> m_turnMotor)
{
	moveMotor = m_moveMotor;

	turnMotor_CANTalon = m_turnMotor;
//	turnMotor_CANTalon->SetPID(10.0, 0.0, 0.0, 0.0);
//	turnMotor_CANTalon->SetControlMode(CANTalon::kPosition);
//	turnMotor_CANTalon->SetSetpoint(0);
//	turnMotor_CANTalon->SetFeedbackDevice(CANTalon::QuadEncoder);
//	turnMotor_CANTalon->ConfigEncoderCodesPerRev(414);
//	turnMotor_CANTalon->ConfigPeakOutputVoltage(12, -12);
//	turnMotor_CANTalon->ConfigNominalOutputVoltage(0, 0);
//	turnMotor_CANTalon->SetAllowableClosedLoopErr(4);
//	turnMotor_CANTalon->SetEncPosition(0);

	useCANTalon = true;
}

void SwerveWheels::MoveWheel(double speedVal, double rotationVal)
{
	if(ShouldReverse(rotationVal))
	{
		if(rotationVal < 0)
			rotationVal += 0.5;
		else
			rotationVal -= 0.5;

		speedVal *= 1;
	}

	SetSpeed(speedVal);
	if(speedVal != 0)
		SetAngle(rotationVal);
}

void SwerveWheels::StopWheel()
{
	moveMotor->StopMotor();
	if(useCANTalon)
		turnMotor_CANTalon->StopMotor();
	else
		turnMotor->StopMotor();
}

void SwerveWheels::SetInverted(SwerveWheels::MotorType type, bool val)
{
	if(type == MotorType::TurnMotor)
	{
		if(useCANTalon)
			turnMotor_CANTalon->SetInverted(val);
		else
			turnMotor->SetInverted(val);
	}
	else if(type == MotorType::MoveMotor)
		moveMotor->SetInverted(val);
}

void SwerveWheels::SetPID(double P, double I, double D, double F)
{
	if(useCANTalon)
		turnMotor_CANTalon->SetPID(P, I, D, F);
	else
		controlPID->SetPID(P, I, D, F);
}

bool SwerveWheels::ShouldReverse(double wa)
{
	double encPos = GetEncoderVal();
	encPos /= gearRatio;
	encPos = fmod(encPos, 1);

	//Convert the next wheel angle, which is from -.5 to .5, to 0 to 1
	if (wa < 0) wa += 1;

	//Find the difference between the two (not sure if the conversion from (-0.5 to 0.5) to (0 to 1) above is needed)
	//Difference between the two points. May be anything between -1 to 1, but we are looking for a number between -.5 to .5
	double longDifference = fabs(wa - encPos);

	//finds shortest distance (0 to 0.5), always positive though (which is what we want)
	double difference = fmin(longDifference, 1.0-longDifference);

	//If the sum is greater than 1/4, then return true (aka it is easier for them to turn around and go backwards than go forward)
	if (difference > 0.25) return true;
	else return false;
}

double SwerveWheels::GetEncoderVal()
{
	if(useCANTalon)
		return turnMotor_CANTalon->GetEncPosition();
	else
		return encoder->Get();
}

void SwerveWheels::SetSpeed(double speedVal)
{
	moveMotor->Set(speedVal);
}

void SwerveWheels::SetAngle(double desiredAngle)
{
	double encoderPos = GetEncoderVal() / gearRatio;

	double temp = desiredAngle;
	temp += (int) encoderPos;

	encoderPos = encoderPos - (int)encoderPos;

	if((desiredAngle - encoderPos) > 0.5)
		temp -= 1;

	if((desiredAngle - encoderPos) < -0.5)
		temp += 1;

	if(useCANTalon)
	{
		turnMotor_CANTalon->SetSetpoint(temp);
		turnMotor_CANTalon->Enable();
	}
	else
	{
		controlPID->SetSetpoint(temp);
		controlPID->Enable();
	}
}
