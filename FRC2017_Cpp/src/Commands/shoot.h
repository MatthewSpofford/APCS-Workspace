#ifndef shoot_H
#define shoot_H

#include "../Robot.h"
#include "Commands/Subsystem.h"

class shoot : public Command {
public:
	shoot();
	void Initialize();
	void Execute();
	bool IsFinished();
	void End();
	void Interrupted();
};

#endif  // shoot_H
