#ifndef DriveSideways_H
#define DriveSideways_H

#include "Commands/Subsystem.h"
#include "../Robot.h"

class DriveSideways : public Command {
public:
	DriveSideways(double m_speed, double m_distance, bool m_fieldCentric = false, double m_angle = -999);
	void Initialize();
	void Execute();
	bool IsFinished();
	void End();
	void Interrupted();

private:
	double speed;
	double angle;
	double distance;
	bool fieldCentric;
};

#endif  // DriveSideways_H
