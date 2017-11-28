#ifndef ToggleGear_H
#define ToggleGear_H

#include "Commands/Subsystem.h"
#include "../Robot.h"

class ToggleGear : public Command {
public:
	ToggleGear();
	void Initialize();
	void Execute();
	bool IsFinished();
	void End();
	void Interrupted();

private:
	std::unique_ptr<Command> teleopGear;
	bool prevState;
	bool running;
};

#endif  // ToggleGear_H
