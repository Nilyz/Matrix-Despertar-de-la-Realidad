package model;

public class Item {
	private String name;
	private int strength;
	private int energy;
	private int speed;
	private int health;

	public Item(String name, int strength, int energy, int speed, int health) {
		this.name = name;
		this.strength = strength;
		this.energy = energy;
		this.speed = speed;
		this.health=health;
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
	
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void seeItem() {
		System.out.print(name+": ");
		if(strength!=0) {
			System.out.print(" Fuerza = "+ strength);
		}else if(energy!=0) {
			System.out.print(" Energia = "+energy);
		}else if(speed!=0) {
			System.out.print(" Velocidad = "+ speed);
		}else if(health!=0) {
			System.out.print(" Vida = "+ health);
		}
	}
	
	//para que retorne el stat que tiene
	public void useItemStats(Player player,Item item) {
		if(strength!=0) {
			player.setStrength(player.getStrength()+item.getStrength());
		}else if(energy!=0) {
			player.setEnergy(player.getEnergy()+item.getEnergy());
		}else if(speed!=0) {
			player.setSpeed(player.getSpeed()+item.getSpeed());
		}else if(health!=0) {
			player.setHealth(player.getHealth()+item.getHealth());
			
		}
		player.deleteItem(item);
	}
	
	@Override
	public String toString() {
		return "Item [name=" + name + ", strength=" + strength + ", energy=" + energy + ", speed=" + speed + "]";
	}

}
