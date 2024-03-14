package model;

public abstract class Character {
	protected String name;
	protected int maxHealth;
	protected int health;
	protected int strength;
	protected int experience;

	public Character() {
	}

	public Character(String name, int maxHealth, int strength, int experience) {
		this.name = name;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.strength = strength;
		this.experience = experience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if (health < 0) {
			health = 0;
		} else if (health > maxHealth) {
			health = maxHealth;
		}
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}


	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}



	

	

}
