package model;

import java.util.ArrayList;
import java.util.List;

public class Agent extends Enemy {
    private List<Item> droppableItems;

    public Agent(String name, int maxHealth, int strength, int energy, int speed, int experience, int aparitionProbability) {
        super(name, maxHealth, strength, energy, speed, experience, aparitionProbability);
        this.droppableItems = new ArrayList<>(); 
      
       
    }

   
	public List<Item> getDroppableItems() {
		return droppableItems;
	}


	public void setDroppableItems(List<Item> droppableItems) {
		this.droppableItems = droppableItems;
	}
	public void addDroppableItem(Item item) {
        droppableItems.add(item);
    }


	@Override
	public String toString() {
		return name+"[droppableItems=" + droppableItems + "]aparitionProbability=" + aparitionProbability;
	}

	

	

    
}