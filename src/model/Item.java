package model;

public class Item {
	private String name;
	private int strength;
	private int energy;
	private int luck;
	private int health;

	public Item(String name, int strength, int energy, int luck, int health) {
		this.name = name;
		this.strength = strength;
		this.energy = energy;
		this.luck = luck;
		this.health = health;
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

	public int getLuck() {
		return luck;
	}

	public void setLuck(int speed) {
		this.luck = speed;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String seeItem() {
		System.out.print(name + ": ");
		if (strength != 0) {
			return "+" + strength + " Fuerza";
		} else if (energy != 0) {
			return "+" + energy + " Energia";
		} else if (luck != 0) {
			return "+" + luck + " Suerte";
		} else if (health != 0) {
			return "+" + health + " Vida";
		}
		return "";
	}

	// para que retorne el stat que tiene
	public void useItemStats(Player player, Item item) {
		if (strength != 0) {
			player.setStrength(player.getStrength() + item.getStrength());
		} else if (energy != 0) {
			player.setEnergy(player.getEnergy() + item.getEnergy());
		} else if (luck != 0) {
			player.setLuck(player.getLuck() + item.getLuck());
		} else if (health != 0) {
			player.setHealth(player.getHealth() + item.getHealth());

		}
		player.deleteItem(item);
	}

}
