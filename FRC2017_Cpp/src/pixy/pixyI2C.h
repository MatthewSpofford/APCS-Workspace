/*
 * pixyI2C.h
 *
 *  Created on: Jan 29, 2017
 *      Author: Team 4048
 */

#ifndef SRC_PIXY_PIXYI2C_H_
#define SRC_PIXY_PIXYI2C_H_

#include "I2C.h"
#include "pixyPacket.h"

/**
 *
 * @author 2B || !2B from https://www.chiefdelphi.com/forums/showpost.php?p=1443536&postcount=7
 * This class stores values into the PixyPacket class through the Serial port on the RoboRIO
 *
 * Pixy packet structure:
 * bytes       description
 * -------------------------------
 * 0, 1        sync (0xaa55)
 * 2, 3        checksum
 * 4, 5        signature
 * 6, 7        x center of object
 * 8, 9        y center of object
 * 10, 11      width
 * 12, 13      height
 *
 * all words are in Little Endian
 *
 *
 * Pixy should be connected to the I2C on the RoboRio (pin 10 = ground, pin 9 = data, pin 6 = clock
 *
 *
 */
//Warning: if the pixy is plugged in through mini usb, this code WILL NOT WORK b/c the pixy is smart and detects where it should send data
class PixyI2C
{
private:
	I2C *pixy;

public:
	PixyI2C();
private:
	//This method swaps 2 bytes from LE to normal world.....
	int cvt(uint8_t upper, uint8_t lower);
public:
	PixyPacket *packets;
	//Gather data, parses it, and assigns to global variables
	int readPacket(); //The signature should be which number object in
};
#endif /* SRC_PIXY_PIXYI2C_H_ */
