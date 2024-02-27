package controller;

import model.*;

public class Main {
	public static void main(String[] args) {

		Agent ag1 = new Agent("Agente 1", 0, 0, 0, 0, 0, 40);
		Agent ag2 = new Agent("Agente ASSASDSA", 0, 4, 0, 0, 6, 20);
		Item newItem = new Item("Strength Belt", 5, 0, 0);
		Item newItem2 = new Item("Enhancement Chips", 0, 10, 0);
		Item newItem3 = new Item("Speed Boots", 0, 0, 2);
		Item newItem4 = new Item("Training Book", 0, 0, 8);

		ag1.addDroppableItem(newItem);

		System.out.println(ag1.toString());
		System.out.println(ag2.toString());

		Zone zone1 = new Zone("Zone 1");
		zone1.addAgent(ag2);
		System.out.println(zone1.toString());

	}

}
