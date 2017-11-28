#include "AutoHopperRed.h"
#include "DriveForward.h"
#include "DriveSideways.h"

AutoHopperRed::AutoHopperRed() {
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
	AddSequential(new DriveForward(0.2, 2.0, true));
	AddSequential(new DriveSideways(0.15, 1.5, true));
}
