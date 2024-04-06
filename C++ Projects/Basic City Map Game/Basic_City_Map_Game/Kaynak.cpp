#include<iostream>
#include<iomanip>
#include "building.h"
#include "map.h"
using namespace std;

int main() {
	char type;
	int money = 1000;
	int turn = 1;
	bool gamestate = true;
	bool sufficient = true;
	Map Map1;
	basebuilding meta;
	house hap;

	while (gamestate) {
		for (int action = 5; action > 0; action--) {
			bool valid0 = true;
			bool valid1 = true;
			bool valid2 = true;

			meta.showCount(turn, action); // Shows buildings, turns and actions.
			cout << money << "$" << endl;
			hap.totalHappines(Map1); // Calculate happiness.
			hap.showHappines();
			hap.totalMoney(&money, Map1); // Calculate money.
			cout << "Percentance of happiness: " << hap.percentHappines(meta) << "%" << endl;

			Map1.mapStatus(); // Show map status.

			cout << "What do you want to build (House = e (300$), Hospital = h (500$), School = s (400$), Lumberjack = l (400$), \nMine = m (700$), To pass action = a, To quit game = q)" << endl;

			cin >> type;

			if (type == 'q') { // End the program if press q.
				gamestate = false;
				break;
			}

			cout << "enter x" << endl;
			while (valid1) { // Check if  Map1.x is valid.
				cin >> Map1.x;
				if (Map1.x <= 0 || Map1.x > 60) {
					cout << "Outside of map " << endl;
					cin.clear();
					cin.ignore();
				}
				else
					valid1 = false;
			}
			cout << "enter y" << endl;
			while (valid2) { // Check if  Map1.y is valid.
				cin >> Map1.y;
				if (Map1.x <= 0 || Map1.y > 20) {
					cout << "Outside of map " << endl;
					cin.clear();
					cin.ignore();
				}
				else
					valid2 = false;
			}

			
			meta.build(&money, type, Map1.x, Map1.y, Map1); // Check if prerequisites are met.
			system("cls");
			Map1.setMap(Map1.x, Map1.y, type); // Making changes on the map.
			

			meta.scan(Map1.x, Map1.y, Map1); // Scans the map for the number of buildings.
		}
		turn++;
	}
}