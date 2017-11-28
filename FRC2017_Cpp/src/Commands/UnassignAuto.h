#ifndef UnassignAuto_H
#define UnassignAuto_H

#include "Commands/Subsystem.h"
#include "../Robot.h"

class UnassignAuto : public Command {
public:
	UnassignAuto();
	void Initialize();
	void Execute();
	bool IsFinished();
	void End();
	void Interrupted();
};

#endif  // UnassignAuto_H
