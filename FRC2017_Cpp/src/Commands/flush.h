#ifndef flush_H
#define flush_H

#include "../Robot.h"
#include "Commands/Subsystem.h"

class flush : public Command {
public:
	flush();
	void Initialize();
	void Execute();
	bool IsFinished();
	void End();
	void Interrupted();
};

#endif  // flush_H
