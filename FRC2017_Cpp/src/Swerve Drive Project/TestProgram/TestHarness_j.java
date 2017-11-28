/*
 * TestHarness.cpp
 *
 *  Created on: Nov 21, 2017
 *      Author: Team 4048
 */

//using namespace std;

public class program
{
	public static void main(String[] args)
	{
		SwerveMath tempCalc;
		tempCalc.Calculate(0.0, 0.0, 0.0);
		mathTester(tempCalc, 0.01, -0.01, 0.01, -0.01,
					0.01, -0.01, 0.01, -0.01,
					0.01, -0.01, 0.01, -0.01,
					0.01, -0.01, 0.01, -0.01);

		return 0;
	}

	void mathTester(SwerveMath* input, double fls_max, double fls_min, double fla_max, double fla_min,
			 	 	 	 	 	 	   double frs_max, double frs_min, double fra_max, double fra_min,
									   double rls_max, double rls_min, double rla_max, double rla_min,
									   double rrs_max, double rrs_min, double rra_max, double rra_min)
	{
		compareToExpected(input->GetFrontLeftSpeed(), fls_max, fls_min, "FLS");
		compareToExpected(input->GetFrontLeftRotVal(), fla_max, fla_min, "FLA");

		compareToExpected(input->GetFrontRightSpeed(), frs_max, frs_min, "FRS");
		compareToExpected(input->GetFrontRightRotVal(), fra_max, fra_min, "FRA");

		compareToExpected(input->GetRearLeftSpeed(), rls_max, rls_min, "RLS");
		compareToExpected(input->GetRearLeftRotVal(), rla_max, rla_min, "RLA");

		compareToExpected(input->GetRearRightSpeed(), rrs_max, rrs_min, "RRS");
		compareToExpected(input->GetRearRightRotVal(), rra_max, rra_min, "RRA");
	}

	void compareToExpected(double input, double min, double max, char* tag)
	{
		bool value = !(max <= input && min >= input);

		if(value)
			cout << "ERROR: " + tag + " - " + input + " not between "
			+ min + " and " + max + "\n";
	}

};