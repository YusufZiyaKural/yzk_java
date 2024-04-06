#include <stdlib.h>
#include <ctime>
#include "Map.h"
#include <iostream>
using std::cout;
using std::endl;

Map::Map() { // Make the map;
	Mapsize[60][20];
	x = 0;
	y = 0;
	srand(time(0));

	for (int i = 0; i <= 19; i++) {
		for (int j = 0; j <= 59; j++) {
			int rnd = rand() % 100 + 1;
			if (rnd <= 2) {
				Mapsize[j][i] = 'T';
			}
			else if (rnd <= 4) {
				Mapsize[j][i] = 'I';
			}
			else
				Mapsize[j][i] = '-';
		}
	}
}

int Map::mapShow(int x, int y) { // Show value of map.
	
	return Mapsize[y][x];
}

void Map::setMap(int x, int y, int z) { // Making changes on the map.
	bool command = true;
	while (command) {
		if (z != 'e' && z != 'h' && z != 's' && z != 'l' && z != 'm' && z != 'a' && z != 'q') {
			cout << "Invalid command " << endl;
		}
		else if (z == 'a') {
			command = false;
		}
		else {
			Mapsize[x - 1][y - 1] = z;
			command = false;
		}
	}
}

void Map::mapStatus() { // Shows the  map.
	for (int i = 0; i <= 19; i++) {
		for (int j = 0; j <= 59; j++) {
			cout << (char)Mapsize[j][i];

			cout << " ";
		}
		cout << "\n";
	}

}