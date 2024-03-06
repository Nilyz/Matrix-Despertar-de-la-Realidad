package model;

import java.util.ArrayList;

public class Player extends Character {

	private int level;
	private int energy;
	private int speed;

	private ArrayList<Item> items;

	public Player(String name, int maxHealth, int strength, int energy, int speed, int experience, int level) {
		super(name, maxHealth, strength, experience);
		this.level = level;
		this.energy=energy;
		this.speed=speed;
		this.items = new ArrayList<>();
	}

	// Personaje por defecto
	public Player() {
		this("Neo", 40, 10, 10, 10, 0, 1);// esta llamando al otro constructor con sus parámetros
		this.items = new ArrayList<>();
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public void addItem(Item item) {
		items.add(item);
	}
	public void deleteItem(Item item) {
		items.remove(item);
	}

	public void seePlayerItems() {
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			System.out.print("\n"+(i + 1) + ". ");
			item.seeItem();
		}
	}

	
	@Override
	public String toString() {
		return super.toString()+"level=" + level + ", energy=" + energy + ", speed=" + speed + ", items=" + items + "]";
	}

	public boolean isCriticalAttack() {
		int random = (int) (Math.random() * 25);
		return random < energy;
	}

	
}
