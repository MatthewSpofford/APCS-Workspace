/*
 * test.cpp

 *
 *  Created on: Jan 17, 2017
 *      Author: Team 4048
 */

/**
Test Code for the Swerve Drive Equations, see forum posts for more information.
Author: Vanshika Chowdhary
Date Finished: 1/14/2017
Complete
**/

#include<iostream>
#include<stdio.h>
#include<math.h>
using namespace std;

void swerveDrive(double results[4][2], double values[3])
{
    double PI = acos(-1);
    //all inputs are in the range of -1 to 1
    double rotation = values[0];
    double joystickX = values[1];
    double joystickY = values[2];

    const int L = 30;
    const int W = 24;
    //length and width of chassis, since we're using the center as a reference point
    const int R = (sqrt(L*L + W*W))/2;

    double A = joystickX - rotation*L/R;
    double B = joystickX + rotation*L/R;
    double C = joystickY - rotation*W/R;
    double D = joystickY + rotation*W/R;//makes the wheel calculations easier


    /** I commented out code for changing the angle based on the quadrant that the vector is in. Right now, the angles are returned within
    a range of - 180 to 180. If we want, we can change that range to be from 0 to 360, but I don't see any benefit as turning counterclockwise can
    be done without changing the angle range**/
    double wSpeed1 = sqrt(B*B + C*C);
    double wAngle1 = atan2(C,B) * 180/PI;
    //if(B<0) wAngle1+=0;

    double wSpeed2 = sqrt(B*B + D*D);
    double wAngle2 = atan2(D,B) * 180/PI;
    //if(B<0) wAngle2+=180;

    double wSpeed3 = sqrt(A*A + D*D);
    double wAngle3 = atan2(D,A) * 180/PI;
    //if(A<0) wAngle3+=180;

    double wSpeed4 = sqrt(A*A + C*C);
    double wAngle4 = atan2(C,A) * 180/PI;
    //if(A<0) wAngle4 += 180;

    //normalizes speeds so they're within the ranges of -1 to 1
    double maxSpeed = wSpeed1;
    if(wSpeed2 > maxSpeed) maxSpeed = wSpeed2;
    if(wSpeed3 > maxSpeed) maxSpeed = wSpeed3;
    if(wSpeed4 > maxSpeed) maxSpeed = wSpeed4;

    if(maxSpeed > 1)
    {
        wSpeed1/=maxSpeed;
        wSpeed2/=maxSpeed;
        wSpeed3/=maxSpeed;
        wSpeed4/=maxSpeed;
    }


    double newResults[4][2] = {{wSpeed1, wAngle1}, {wSpeed2, wAngle2}, {wSpeed3, wAngle3}, {wSpeed4, wAngle4}};
    results = newResults;

    for(int i = 1; i < 5; i++)
    {
        printf("Wheel %d %s %f", i, " speed: ", results[i-1][0]);
        printf("\n");
        printf("Wheel %d %s %f", i, " direction: ", results[i-1][1]);
        printf("\n");
    }
}

void printValues(double values[3])
{
    printf("Direction: %f\n", values[0]);
    printf("Joystick X: %f\n", values[1]);
    printf("Joystick Y: %f\n", values[2]);
}
/*
int main()
{

    double testValues[3] = {-0.5, 0.96, 0.01};//[rotation, joystickX, joystickY];
    printValues(testValues);
    double results[4][2] = {{0}};
    swerveDrive(results, testValues);
    return 0;
}
*/




