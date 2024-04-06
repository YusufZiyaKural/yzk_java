#ifndef MAP_H
#define MAP_H

class Map {
private:
	int Mapsize[60][20];
	
public:
	Map(); //CONSTRUCTOR
	
	void mapStatus(); // Show map status.
	int mapShow(int x, int y); // Show value of map.
	void setMap(int x, int y, int z); // Making changes on the map.
	
	int x;
	int y;
};

#endif;
