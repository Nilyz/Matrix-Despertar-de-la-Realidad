package model;

import java.util.ArrayList;
import java.util.Random;

public class Zone {
	private String name;
	private ArrayList<Agent> agents;

	public Zone(String name) {
		this.name = name;
		this.agents = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Agent> getAgents() {
		return agents;
	}

	public void setAgents(ArrayList<Agent> agents) {
		this.agents = agents;
	}

	public void addAgent(Agent agent) {
		agents.add(agent);
	}

	@Override
	public String toString() {
		return "Zone [name=" + name + ", agents=" + agents + "]";
	}

	public static enum Distritos {
		DISTRITO_INDUSTRIAL, SECTOR_RESIDENCIAL, NÚCLEO_DE_LA_CIUDAD, INSTALACIÓN_DE_SEGURIDAD

	}

	// Método para generar enemigos de una zona
	public void generateEnemies(Distritos district, int cant) {

		if (district == district.DISTRITO_INDUSTRIAL) {
			String enemyName[] = { "Robots de seguridad", "Obreros digitales", "Caminantes de acero",
					"Lanceros industriales" };

			for (int i = 0; i < cant; i++) {
				int enemyHP = (int) (Math.random() * 20) + 1;
				int enemyStrenght = (int) (Math.random() * 15) + 1;
				int enemyEnergy = (int) (Math.random() * 20) + 1;
				int enemyExp = (int) (Math.random() * 5) + 1;
				int eName = (int) (Math.random() * enemyName.length);
				int dropProb = (int) (Math.random() * 10) + 1;
				Agent agente = new Agent(enemyName[eName], enemyHP, enemyStrenght, enemyEnergy, enemyExp,
						0);

				//hay un 30% de que haya drop
				if (dropProb <= 3) {
					agente.addDroppableItem(generateItem());
				} 
				agents.add(agente);
			}
		} else if (district == district.SECTOR_RESIDENCIAL) {

		} else if (district == district.NÚCLEO_DE_LA_CIUDAD) {

		} else if (district == district.INSTALACIÓN_DE_SEGURIDAD) {

		}
		
	}

	//recuerda cambiar luego los stats de los items
	public static Item generateItem() {
		Item newItem = new Item("Strength Belt", 5, 0, 0,0);
		Item newItem2 = new Item("Enhancement Chips", 0, 10, 0,0);
		Item newItem3 = new Item("Speed Boots", 3, 0, 0,0);
		Item newItem4 = new Item("Training Book", 0, 0, 8,0);
		Item newItem5 = new Item("Energía eléctrica", 0, 0, 0,9);
		Item newItem6 = new Item("Training Book", 0, 0, 8,0);
		Item newItem7 = new Item("Mejoras cibernéticas", 0, 0, 8,0);
		Item newItem8 = new Item("Suministros médicos", 0, 0, 5,0);
		Item newItem9 = new Item("Mejoras de combate", 0, 0, 8,0);
		Item newItem10 = new Item("Mejoras genéticas", 1, 0, 0,0);
		Item newItem11 = new Item("Traje de vestir elegante", 0, 0, 8,0);
		Item newItem12 = new Item("Disfraz de civil", 6, 0, 0,0);
		Item newItem13 = new Item("Mochila de supervivencia", 0, 4, 0,0);
		Item newItem14 = new Item("Armas de alta tecnología", 0, 0, 0,5);
		Item newItem15 = new Item("Botas de acer", 3, 0, 0,0);
		Item itemList[] = { newItem, newItem2, newItem3, newItem4, newItem5, newItem6, newItem7,
				newItem8, newItem9, newItem10, newItem11, newItem12, newItem13, newItem14, newItem15 };
		int randomItem = (int) (Math.random() * itemList.length);
		return itemList[randomItem];
	}

	
	
	
	// recuerda eliminar
	public void verZona() {
		System.out.println("zona: " + name);

		for (Agent agent : agents) {
			System.out.println(agent.getName() + " - Salud: " + agent.getMaxHealth() + ", Fuerza: "
					+ agent.getStrength() 
					+ ", EXP: " + agent.getExperience() + ", drop: " + agent.getDroppableItems());
		}
	}

}
