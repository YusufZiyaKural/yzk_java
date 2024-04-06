#include <iostream>
#include <cmath>
#include "building.h"
using namespace std;

void basebuilding::build(int* money, char type, int x, int y, Map s) { // Check if prerequisites are met.
	bool command = true;
	while (command) {
		switch (type) {

		case 'e': {
			if (*money >= 300) {
				*money -= 300;
				command = false;
			}
			else {
				cout << "Insufficient money. " << endl;
				cin >> type;
			}
			break;

		}
		case 'h': {
			if (*money >= 500) {
				*money -= 500;
				command = false;
				
			}
			else {
				cout << "Insufficient money. " << endl;
				cin >> type;
			}
			break;
		}
		case 's': {
			if (*money >= 400) {
				*money -= 400;
				command = false;
			}
			else {
				cout << "Insufficient money. " << endl;
				cin >> type;
			}
			break;
		}
		case 'l': {
			if (*money >= 400) {
				*money -= 400;
				command = false;
			}
			else {
				cout << "Insufficient money. " << endl;
				cin >> type;
			}
			break;
		}
		case 'm': {
			if (*money >= 700) {
				*money -= 700;
				command = false;
			}
			else {
				cout << "Insufficient money. " << endl;
				cin >> type;
			}
			break;
		}
		case 'a': {
			command = false;
			break;
		}
		case 'q': {
			command = false;
			break;
		}
		default: {
			cout << "Invalid command. " << endl;
			cin >> type;
			break;
		}
		}
	}
}

void basebuilding::showCount(int turn, int action) { // Shows buildings, turns and actions.
	
	cout << "Turn: " << turn << " Action: " << action << endl;
	cout << "House:" << counte << " Hospital:" << counth << " School:" << counts << " Lumberjack:" << countl << " Mine:" << countm << endl;
}

void basebuilding::gainMoney(int* money, int x, int y) {

}

void basebuilding::totalMoney(int* money, Map t) { // Calculate money.

	house h;
	lumberjack l;
	mine m;
	for (int i = 0; i < 20; i++) {
		for (int j = 0; j < 60; j++) {
			if (t.mapShow(i, j) == 'e') {
				h.gainMoney(money, t);
			}
			if (t.mapShow(i, j) == 'l') {
				l.gainMoney(money, i, j, t);
			}
			if (t.mapShow(i, j) == 'm') {
				m.gainMoney(money, i, j, t);
			}
		}
	}
}

int basebuilding::getCountE() { // The private variable in basebuilding is used to access percentHappines in the class house.
	return counte;
}

void basebuilding::scan(int x, int y, Map s) { // Scans the map for the number of buildings.

	counte = 0;
	counth = 0;
	counts = 0;
	countl = 0;
	countm = 0;

	for (int i = 0; i < 20; i++) {
		for (int j = 0; j < 60; j++) {
			if (s.mapShow(i, j) == 'e') {

				counte++;
			}
			if (s.mapShow(i, j) == 'l') {

				countl++;
			}
			if (s.mapShow(i, j) == 'm') {

				countm++;
			}
			if (s.mapShow(i, j) == 's') {

				counts++;
			}
			if (s.mapShow(i, j) == 'h') {

				counth++;
			}
		}
	}
}

void house::gainMoney(int* money, Map e) { // To gain money form houses.
	for (int i = 1; i <= 20; i++) {
		for (int j = 1; j <= 60; j++) {
			if (e.mapShow(i - 1, j - 1) == 'e') {
				*money += 100;
			}
		}
	}
}

void house::gainHappines(int x, int y, Map m) { // To gain happiness.
	bool schoola = false;
	bool hospitala = false;
	for (int i = -5; i < 5; i++) {
		for (int j = -5; j < 5; j++) {
			int distance = sqrt(pow(i, 2) + pow(j, 2));
			if (x + i >= 0 && y + j >= 0 && x + i < 20 && y + j < 60 && distance <= 5) {
				if (!hospitala && m.mapShow(x + i, y + j) == 'h') {
					hospitala = true;
					if (distance < 1) {
						distance = 1;
					}
					happines += 5 / distance;
				}
				if (!schoola && m.mapShow(x + i, y + j) == 's') {
					schoola = true;
					if (distance < 1) {
						distance = 1;
					}
					happines += 5 / distance;
				}
			}
		}
	}
}

void house::totalHappines(Map t) { // Calculate happiness.
	happines = 0;
	for (int i = 0; i < 20; i++) {
		for (int j = 0; j < 60; j++) {
			if (t.mapShow(i, j) == 'e') {
				gainHappines(i,j,t);
			}
		}
	}
}

void house::showHappines() { // To show happiness.
	cout << "Total happines is " << happines << endl;
}

double house::percentHappines(basebuilding h) { // For calculating happiness percentences. 
	if (h.getCountE() != 0) {
		return (happines / h.getCountE()) * 10;
	}
	else
		return 0;
}

void lumberjack::gainMoney(int* money, int x, int y, Map w) { // To gain money form lumberjacks.
	
	bool wood = false;
	for (int i = -5; i < 5; i++) {
		for (int j = -5; j < 5; j++) {
			if (x + i >= 0 && y + j >= 0 && x + i < 20 && y + j < 60 && sqrt(pow(i, 2) + pow(j, 2)) <= 3) {
				if (!wood && w.mapShow(x + i, y + j) == 'T') {
					wood = true;
					*money += 200;
				}
			}
		}
	}
}

void mine::gainMoney(int* money, int x, int y, Map r) { // To gain money form mines.
	
	bool iron = false;
	for (int i = -5; i < 5; i++) {
		for (int j = -5; j < 5; j++) {
			if (x + i >= 0 && y + j >= 0 && x + i < 20 && y + j < 60 && sqrt(pow(i, 2) + pow(j, 2)) <= 3) {
				if (!iron && r.mapShow(x + i, y + j) == 'I') {
					iron = true;
					*money += 300;
				}
			}
		}
	}
}