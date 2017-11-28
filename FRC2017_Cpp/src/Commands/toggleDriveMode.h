#ifndef toggleDriveMode_H
#define toggleDriveMode_H

#include "../Robot.h"
#include "Commands/Subsystem.h"

class toggleDriveMode : public Command {
public:
	toggleDriveMode();
	void Initialize();
	void Execute();
	bool IsFinished();
	void End();
	void Interrupted();
};

#endif  // toggleDriveMode_H
