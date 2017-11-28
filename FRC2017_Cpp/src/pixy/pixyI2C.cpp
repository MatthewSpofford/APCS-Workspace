/*
 * pixyI2C.cpp
 *
 *  Created on: Jan 29, 2017
 *      Author: Team 4048
 */
#define PRINT_LINE //printf("%s:%d\n",__FILE__, __LINE__);  fflush(stdout)

#include "pixyI2C.h"
#include "../RobotMap.h"
#include <SmartDashboard/SmartDashboard.h>
#include <DriverStation.h>

PixyI2C::PixyI2C()
{
	pixy = new I2C(I2C::kOnboard, 0x54);
	packets = new PixyPacket[7];
}

int PixyI2C::cvt(uint8_t upper, uint8_t lower) {

	return (((int)upper & 0xff) << 8) | ((int)lower & 0xff);
}

int PixyI2C::readPacket()
{
	int Checksum;
	int Sig;
	int count = 0;
	const int max_buff_size = 64;
	uint8_t rawData[max_buff_size] = {0};

	delete packets;

	packets = new PixyPacket[7];

	if(!pixy->ReadOnly(max_buff_size, rawData))
	{
		DriverStation::ReportError("FAILURE IN READING PIXY\n");
		//return 0;
	}

	for (int i = 0; i < max_buff_size; i++)
	{
		std::printf("  %x ", rawData[i]);
	}
	printf("\n");
	PRINT_LINE;

	/*
	if((std::end(rawData) - std::begin(rawData)) < 64)
	{
		DriverStation::ReportError("STATUS: Bad packet length");
		return 0;
	}
	*/
	//FILE *file;
	//file = fopen("/tmp/4048.log", "a");

	PRINT_LINE;
	PixyPacket temp;
	PRINT_LINE;
	int restartPoint = -1;
	for (int i = 0; i < max_buff_size; i++)
	{
		if(i > max_buff_size - 14)
			break;

		PRINT_LINE;

		int syncWord = cvt(rawData[i+1], rawData[i+0]); //Parse first 2 bytes

		if (syncWord == 0xaa55) //Check is first 2 bytes equal a "sync word", which indicates the start of a packet of valid data
		{
			restartPoint = i + 1;

			/*
			syncWord = cvt(rawData[i+3], rawData[i+2]); //Parse the next 2 bytes
			if (syncWord == 0xaa55) //Shifts everything in the case that one syncword is sent
			{
				i += 2;
			}
			if (!(i+13 <= max_buff_size))
			{
				// don't read past the buffer size
				return false;
			}
			*/

			//This next block parses the rest of the data
			Checksum = cvt(rawData[i+3], rawData[i+2]);
			Sig = cvt(rawData[i+5], rawData[i+4]);
			PRINT_LINE;


			temp.X = cvt(rawData[i+7], rawData[i+6]);
			//fprintf(file, "X value: %d\n", temp.X);
			temp.Y = cvt(rawData[i+9], rawData[i+8]);
			temp.Width = cvt(rawData[i+11], rawData[i+10]);
			temp.Height = cvt(rawData[i+13], rawData[i+12]);
			PRINT_LINE;
			//Checks whether the data is valid using the checksum *This if block should never be entered*
			if (Checksum == Sig + temp.X + temp.Y
				+ temp.Width + temp.Height)
			{
				PRINT_LINE;
				restartPoint = -1;
				packets[count++] = temp;
			}
			else
			{
				PRINT_LINE;
				if(restartPoint > 0)
				{
					i = restartPoint;
					restartPoint = -1;
				}
			}

			/*
			for (i += 13; i <= max_buff_size; i++)
			{
				int syncWord = cvt(rawData[i+1], rawData[i+0]); //Parse first 2 bytes

				if (syncWord == 0xaa55) //Check is first 2 bytes equal a "sync word", which indicates the start of a packet of valid data
				{
					syncWord = cvt(rawData[i+3], rawData[i+2]); //Parse the next 2 bytes
					if (syncWord == 0xaa55) //Shifts everything in the case that one syncword is sent
					{
						i += 2;
					}
					if (!(i+13 <= max_buff_size))
					{
						// don't read past the buffer size
						packets[1] = PixyPacket();
						break;
					}
					//This next block parses the rest of the data
					Checksum = cvt(rawData[i+3], rawData[i+2]);
					Sig = cvt(rawData[i+5], rawData[i+4]);

					packets[1] = PixyPacket();
					packets[1].X = cvt(rawData[i+7], rawData[i+6]);
					packets[1].Y = cvt(rawData[i+9], rawData[i+8]);
					packets[1].Width = cvt(rawData[i+11], rawData[i+10]);
					packets[1].Height = cvt(rawData[i+13], rawData[i+12]);
					//Checks whether the data is valid using the checksum *This if block should never be entered*
					if (Checksum != Sig + packets[1].X + packets[1].Y
						+ packets[1].Width + packets[1].Height)
					{
						packets[1] = PixyPacket();
					}
					break;
				}
			}
			break;
			*/
		}
		if(count == 6)
			break;
	}
	PRINT_LINE;
	//Assigns our packet to a temp packet, then deletes data so that we dont return old data

	return count;
}



