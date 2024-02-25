package model;

public class Item {
	private String name;
	private int strength;
	private int energy;
	private int speed;
	
	
	public Item(String name, int strength, int energy, int speed) {
		super();
		this.name = name;
		this.strength = strength;
		this.energy = energy;
		this.speed = speed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
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
	@Override
	public String toString() {
		return "Item [name=" + name + ", strength=" + strength + ", energy=" + energy + ", speed=" + speed + "]";
	}
	
}
