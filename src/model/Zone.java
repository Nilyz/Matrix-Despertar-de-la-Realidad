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

	// Método para generar enemigos de una zona
	public void generateEnemys(String district, int cant) {
		
		
		if (district.equals("DISTRITO INDUSTRIAL")) {
			String enemyName[] = { "Robots de seguridad", "Obreros digitales","Caminantes de acero","Lanceros industriales" };
			
			for (int i = 0; i <cant; i++) {
				int enemyHP = (int) (Math.random() * 30) + 1;
				int enemyStrenght= (int) (Math.random() * 20) + 1;
				int enemyEnergy= (int) (Math.random() * 20) + 1;
				int enemyVelocity= (int) (Math.random() * 20) + 1;
				int enemyExp= (int) (Math.random() * 5) + 1;
				int eName = (int) (Math.random() * enemyName.length);
				Agent enemy=new Agent(enemyName[eName],enemyHP,enemyStrenght,enemyEnergy,enemyVelocity,enemyExp,0);
				
				enemy.addDroppableItem(new Item("Strength Belt", 5, 0, 0));
				
				agents.add(enemy);
			}
		}else if(district.equals("SECTOR RESIDENCIAL")){
			
		}else if(district.equals("NÚCLEO DE LA CIUDAD")) {
			
		}else if(district.equals("INSTALACIÓN DE SEGURIDAD")) {
			
		}
		
	}
	
	//recuerda eliminar
	public void verZona() {
		 System.out.println("zona: " + name);
		 
		    for (Agent agent : agents) {
		        System.out.println(agent.getName() + " - Salud: " + agent.getMaxHealth() +
		                           ", Fuerza: " + agent.getStrength() +
		                           ", Energía: " + agent.getEnergy() +
		                           ", Velocidad: " + agent.getSpeed()+
		                           ", EXP: " + agent.getExperience()+
		                           ", EXP: " + agent.getDroppableItems()
		                          );
		    }
	}


}
