#ifndef ClimberCentric_H
#define ClimberCentric_H

#include "Commands/Subsystem.h"
#include "../Robot.h"

class ClimberCentric : public Command {
public:
	ClimberCentric();
	void Initialize();
	void Execute();
	bool IsFinished();
	void End();
	void Interrupted();
};

#endif  // ClimberCentric_H
