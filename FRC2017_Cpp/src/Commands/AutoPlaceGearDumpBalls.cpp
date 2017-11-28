#include "AutoPlaceGearDumpBalls.h"
#include "DriveForward.h"
#include "DriveSideways.h"
#include "AutoGearMiddle.h"
#include "DumpBalls.h"

AutoPlaceGearDumpBalls::AutoPlaceGearDumpBalls() {
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
	AddSequential(new AutoGearMiddle());
	AddSequential(new DriveSideways(0.12, 1.5, true, Robot::alliance ? -135.0 : 135.0));
	AddSequential(new DriveForward(-0.2, 1.5, true));
	AddSequential(new DumpBalls(true));
}
