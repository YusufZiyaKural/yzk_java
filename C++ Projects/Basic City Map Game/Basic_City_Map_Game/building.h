#ifndef BUILDINGS_H
#define BUILDINGS_H
#include "map.h"

class basebuilding { // Base class for buildings.

private:
	int counte = 0;
	int counth = 0;
	int counts = 0;
	int countl = 0;
	int countm = 0;
public:
	void build(int*, char, int, int, Map); // Check if prerequisites are met.
	void showCount(int, int); // Shows buildings, turns and actions.
	int getCountE(); // The private variable in basebuilding is used to access percentHappines in the class house.
	void gainMoney(int*,int,int);
	void totalMoney(int*,Map); // Calculate money.
	void scan(int, int, Map); // Scans the map for the number of buildings.
	friend class Map;
};

class house :public basebuilding { // Subclass for houses.

private:
	int happines = 0;
	bool hospital = false;
	bool school = false;

public:
	void gainMoney(int*, Map); // To gain money form houses.
	void gainHappines(int,int,Map); // To gain happiness.
	void totalHappines(Map); // Calculate happiness.
	void showHappines(); // To show happiness.
	double percentHappines(basebuilding); // For calculating happiness.

};

class lumberjack :public basebuilding { //  subclass for lumberjacks.

private:

public:
	void gainMoney(int*,int,int,Map); // To gain money form lumberjacks.
	
};

class mine :public basebuilding { // subclass for mines.

private:

public:
	void gainMoney(int*,int,int,Map); // To gain money form mines.
	
};

#endif