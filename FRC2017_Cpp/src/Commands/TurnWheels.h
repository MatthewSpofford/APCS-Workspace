#ifndef TurnWheels_H
#define TurnWheels_H

#include "../Robot.h"
#include "Commands/Subsystem.h"

class TurnWheels : public Command {
public:
	TurnWheels(double angle, double timeout);
	void Initialize();
	void Execute();
	bool IsFinished();
	void End();
	void Interrupted();

	double angle;
	double timeout;
};

#endif  // TurnWheels_H
