package model;

import java.util.ArrayList;
import java.util.Random;

public class Zone {
	private String name;
	private ArrayList<Agent> agents;
	private ZoneItem missionItem;

	public Zone(String name, ZoneItem missionItem) {
		this.name = name;
		this.agents = new ArrayList<>();
		this.missionItem = missionItem;
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

	public ZoneItem getMissionItem() {
		return missionItem;
	}

	public void setMissionItem(ZoneItem missionItem) {
		this.missionItem = missionItem;
	}

	public static enum Distritos {
		DISTRITO_INDUSTRIAL, SECTOR_RESIDENCIAL, NÚCLEO_DE_LA_CIUDAD, INSTALACIÓN_DE_SEGURIDAD

	}

	// Método para generar enemigos de una zona
	public void generateEnemies(Distritos district, int cant, Player player) {
		String[] enemyNames = null;
		switch (district) {
		case DISTRITO_INDUSTRIAL:
			enemyNames = new String[] { "Robots de seguridad", "Obreros digitales", "Caminantes de acero",
					"Lanceros industriales" };
			break;
		case SECTOR_RESIDENCIAL:
			enemyNames = new String[] { "Agentes del sistema", "Ilusionistas", "Guardias de élite", "Ladrones Urbanos",
					"Vigilantes Cibernéticos" };
			break;
		case NÚCLEO_DE_LA_CIUDAD:
			enemyNames = new String[] { "Entidades de corrupción", "Programas de seguridad avanzados",
					"Agentes especiales", "Sistemas de Defensa Avanzados" };
			break;
		case INSTALACIÓN_DE_SEGURIDAD:
			enemyNames = new String[] { "Guardianes de la Instalación", "Perros de Guardia Virtuales",
					"Sistemas de Seguridad Autónomos", "Programas de Rastreo y Detección" };
			break;

		}

		// Generar enemigos normales según el distrito
		for (int i = 0; i < cant; i++) {
			String enemyName = enemyNames[(int) (Math.random() * enemyNames.length)];
			int enemyHP = (int) (Math.random() * 20) + 1;
			int enemyStrength = (int) (Math.random() * 15) + 1;
			int enemyEnergy = (int) (Math.random() * 20) + 1;
			int enemyExp = (int) (Math.random() * 10) + 1;
			int dropProb = (int) (Math.random() * 15) + 1;
			Agent agente = new Agent(enemyName, enemyHP, enemyStrength, enemyEnergy, enemyExp, 0);

			if (dropProb <= player.getLuck()) {
				agente.addDroppableItem(generateItem());
			}
			agents.add(agente);
		}
	}

	public void generateSmith(Distritos district) {
		Smith smithBoss = null;
		if (district == Distritos.DISTRITO_INDUSTRIAL) {
			smithBoss = new Smith("Smith", 30, 10, 20, 15, 100, 10);
		} else if (district == Distritos.SECTOR_RESIDENCIAL) {
			smithBoss = new Smith("Smith", 50, 15, 20, 25, 100, 20);
		} else if (district == Distritos.NÚCLEO_DE_LA_CIUDAD) {
			smithBoss = new Smith("Smith", 70, 20, 20, 35, 100, 30);
		} else if (district == Distritos.INSTALACIÓN_DE_SEGURIDAD) {
			smithBoss = new Smith("Smith", 100, 30, 20, 45, 100, 40);
		}
		agents.add(smithBoss); // Agregar smithBoss a la lista de Agent
	}

	public static Item generateItem() {
		Item newItem = new Item("Cinturón de fuerza", 3, 0, 0, 0);
		Item newItem2 = new Item("Chip de mejora", 0, 0, 3, 0);
		Item newItem3 = new Item("Botas para correr", 0, 5, 0, 0);
		Item newItem4 = new Item("Gafas de sol", 0, 4, 0, 0);
		Item newItem5 = new Item("Energía eléctrica", 0, 0, 3, 0);
		Item newItem6 = new Item("Libro de entrenamientp", 0, 3, 0, 0);
		Item newItem7 = new Item("Mejoras cibernéticas", 0, 0, 2, 0);
		Item newItem8 = new Item("Suministros médicos", 0, 0, 0, 10);
		Item newItem9 = new Item("Mejoras de combate", 6, 0, 0, 0);
		Item newItem10 = new Item("Mejoras genéticas", 5, 0, 0, 0);
		Item newItem11 = new Item("Traje de vestir elegante", 0, 0, 5, 0);
		Item newItem12 = new Item("Disfraz de civil", 0, 3, 0, 0);
		Item newItem13 = new Item("Mochila de supervivencia", 0, 0, 0, 7);
		Item newItem14 = new Item("Armas de alta tecnología", 6, 0, 0, 0);
		Item newItem15 = new Item("Botas de acero", 4, 0, 0, 0);

		Item itemList[] = { newItem, newItem2, newItem3, newItem4, newItem5, newItem6, newItem7, newItem8, newItem9,
				newItem10, newItem11, newItem12, newItem13, newItem14, newItem15 };
		int randomItem = (int) (Math.random() * itemList.length);
		return itemList[randomItem];
	}

}
