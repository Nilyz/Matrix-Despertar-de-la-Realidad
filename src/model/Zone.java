package model;

import java.util.ArrayList;
import java.util.List;

public class Zone {
	private String name;
	private List<Agent> agents;
	
	
	
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
	public List<Agent> getAgents() {
		return agents;
	}
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	 public void addAgent(Agent agent) {
	        agents.add(agent);
	    }

	@Override
	public String toString() {
		return "Zone [name=" + name + ", agents=" + agents + "]";
	}
	
}
