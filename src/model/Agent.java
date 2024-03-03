package model;

import java.util.ArrayList;

public class Agent extends Enemy {
	private ArrayList<Item> droppableItems;

	
	public Agent(String name, int maxHealth, int strength, int energy, int speed, int experience,int aparitionProbability) {
		super(name, maxHealth, strength, energy, speed, experience, aparitionProbability);
		this.droppableItems = new ArrayList<>();

	}

	public ArrayList<Item> getDroppableItems() {
		return droppableItems;
	}

	public void setDroppableItems(ArrayList<Item> droppableItems) {
		this.droppableItems = droppableItems;
	}

	public void addDroppableItem(Item item) {
		droppableItems.add(item);
	}
	
	//el enemigo solo tiene 1 item
	 public Item dropItem() { 
		 if (droppableItems.isEmpty()) {
		        return null; // Devuelve null si no hay ningún ítem dropeable
		    }
		 return droppableItems.get(0);
	    }

	@Override
	public String toString() {
		return name + "[droppableItems=" + droppableItems + "]aparitionProbability=" + aparitionProbability;
	}
	
	
}