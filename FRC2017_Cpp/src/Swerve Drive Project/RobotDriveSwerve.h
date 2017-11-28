/*
 * Matthew Spofford, Team 4048 Redshift
 * RobotDrive with SwerveDrive Modification
 */

#pragma once

#include "Commands/Subsystem.h"
#include "WPILib.h"
#include "CANTalon.h"
#include "SwerveWheels.h"
#include "Swerve Drive Project/SwerveMath.h"

class RobotDriveSwerve : public RobotDrive
{
public:
	enum MotorType {
	    kFrontLeftMotor = 0,
	    kFrontRightMotor = 1,
	    kRearLeftMotor = 2,
	    kRearRightMotor = 3,

		kFrontLeftTurnMotor = 4,
		kFrontRightTurnMotor = 5,
		kRearLeftTurnMotor = 6,
		kRearRightTurnMotor = 7
	  };
	enum DriveMode{
		kFieldCentric = 0,
		kRobotCentric = 1
	};

	/*
	 * Defines the RobotDriveSwerve object
	 * This version of the object uses WPILib encoders,
	 * as well as PIDControllers for controlling movement
	 */
	RobotDriveSwerve(std::shared_ptr<SpeedController> frontLeftMotor,
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
					 std::shared_ptr<Encoder> rearRightEncoder,
					 double width, double length);
	/*
	 * Defines the RobotDriveSwerve object
	 * This version of the object uses CANTalons to use encoders,
	 * as well as using them to do PID calcultions for controlling movement
	 */
	RobotDriveSwerve(std::shared_ptr<SpeedController> frontLeftMotor,
					 std::shared_ptr<SpeedController> frontRightMotor,
					 std::shared_ptr<SpeedController> rearLeftMotor,
					 std::shared_ptr<SpeedController> rearRightMotor,

					 std::shared_ptr<CANTalon> frontLeftTurnMotor,
					 std::shared_ptr<CANTalon> frontRightTurnMotor,
					 std::shared_ptr<CANTalon> rearLeftTurnMotor,
					 std::shared_ptr<CANTalon> rearRightTurnMotor,
					 double width, double length);
	virtual ~RobotDriveSwerve() = default;

	/*
	 *Allows the drivetrain to function as a swerve drive
	 *Requires the input of a forward, directional, and rotation value,
	 *Along with the current angle of a gyro
	 */
	void SwerveDrive(double forwardMovement, double directionalMovement, double rotationMovement, double angle);
	/*
	 *Allows the drivetrain to function as a swerve drive
	 *Requires the input of a forward, directional, and rotation value
	 */
	void SwerveDrive(double forwardMovement, double directionalMovement, double rotationMovement);
	
	//Resets the encoders if drifting is occurring, requires the current absolute encoder or potentiometer positions
	void ResetWheelAngle(double flEncoderAngle, double frEncoderAngle, double rlEncoderAngle, double rrEncoderAngle);		//Resets the angles of the wheels to their zero position
	//Sets the reset positions of the wheels for using an absolute encoder or potentiometer
	void SetResetWheelValues(double frontLeftVal, double frontRightVal, double rearLeftVal, double rearRightVal);
	void StopMotor() override;
	//Inverts the direction of a motor (Requires MotorType as input)
	void SetInvertedMotor(MotorType motor, bool isInverted);

	//Gets the swerve drive mode (kFieldCentric - 0, kRobotCentric - 1))
	int GetMode();
	/*
	 * Sets the swerve drive mode (kFieldCentric - 0, kRobotCentric - 1)
	 * Returns an error if the value given is incorrect
	 */
	void SetMode(DriveMode mode);

	//Sets new PIDF values to be used by the swerve drive (Default: 10, 0, 0, 0)
	void SetPID(double P, double I, double D, double F);
	//Sets a new gear ratio value to be used by the swerve drive (Default: 1656.6666666666)
	void SetGearRatio(double val);
	//Sets a new pulse per rotation to be used by the swerve drive (Default:
	void SetPulsePerRot(double val);

private:
	//Calculates if reversing the turning directions is more efficient for a certain wheel
	bool ShouldReverse(double wheelAngle, double encoderPos);

	//Outputs encoder values for the corresponding motor
	double GetFrontLeftEncoder();
	double GetFrontRightEncoder();
	double GetRearLeftEncoder();
	double GetRearRightEncoder();

	//Stores the calculated values used by each wheel of the swerve drive
	std::shared_ptr<SwerveMath> mathSystem;

	std::shared_ptr<SwerveWheels> frontLeftWheel;
	std::shared_ptr<SwerveWheels> frontRightWheel;
	std::shared_ptr<SwerveWheels> rearLeftWheel;
	std::shared_ptr<SwerveWheels> rearRightWheel;

	DriveMode m_mode = kRobotCentric;
};
