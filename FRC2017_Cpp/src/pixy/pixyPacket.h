/*
 * pixyPacket.h
 *
 *  Created on: Jan 29, 2017
 *      Author: Team 4048
 */

#ifndef SRC_PIXY_PIXYPACKET_H_
#define SRC_PIXY_PIXYPACKET_H_

#include <iostream>
#include <exception>

class PixyPacket
{
private:

public:
	PixyPacket()
	{
		X = 0;
		Y = 0;
		Width = 0;
		Height = 0;
	}

	double getRatio()
	{
		return Height / Width;
	}

	double area()
	{
		return Height * Width;
	}

	void Print(std::string id)
	{
		std::cout << "PixyPacket:" << id <<", " << X <<", " << Y <<", " << Width <<", " << Height << "\n";
	}

	bool isSame(PixyPacket other)
	{
		if(X == other.X && Y == other.Y && Width == other.Width && Height == other.Height)
			return true;
		else
			return false;
	}

	bool isLeftOf(PixyPacket other)
	{
		if(X > other.X)
			return false;
		else
			return true;
	}

	bool isNull()
	{
		if(X == 0 && Y == 0 && Width == 0 && Height ==0)
			return true;
		else
			return false;
	}

	int X;
	int Y;
	int Width;
	int Height;
};


#endif /* SRC_PIXY_PIXYPACKET_H_ */
