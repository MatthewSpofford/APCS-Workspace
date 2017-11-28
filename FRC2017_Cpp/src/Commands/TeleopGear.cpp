#include "closeGate.h"
#include "TeleopGear.h"
#include "openGate.h"
#include "ParallelToWallWithGyro.h"
#include "pushGear.h"
#include "DriveForward.h"
#include "DriveSideways.h"
#include "UnassignAuto.h"
#include "TurnWheels.h"

TeleopGear::TeleopGear() {
	// Add Commands here:
	// e.g. AddSequential(new Command1());
	//      AddSequential(new Command2());
	// these will run in order.

	// To run multiple commands at the same time,
	// use AddParallel()
	// e.g. AddParallel(new Command1());
	//      AddSequential(new Command2());
	// Command1 and Command2 will run in parallel.

	// A command group will require all of the subsystems that each member
	// would require.
	// e.g. if Command1 requires chassis, and Command2 requires arm,
	// a CommandGroup containing them would require both the chassis and the
	// arm.
	AddSequential(new closeGate(true));
	AddSequential(new closeGate(true));
	AddSequential(new openGate(true));
	AddSequential(new ParallelToWallWithGyro(16, true));
	AddSequential(new DriveSideways(0.2, 0.25, false));
	AddSequential(new openGate(true));
	AddSequential(new pushGear(true));
	AddSequential(new TurnWheels(0, 0.5));
	AddSequential(new DriveSideways(-0.3, 0.75, false));
	AddSequential(new closeGate(true));
	AddSequential(new closeGate(true));
	AddSequential(new UnassignAuto());
}

