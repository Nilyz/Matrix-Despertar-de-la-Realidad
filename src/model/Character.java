package model;

public abstract class Character {
	protected String name;
	private int maxHealth;
	private int health;
	private int strength;
	private int experience;

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

	/* Metodos especificos */

	public int getAttack(boolean isCritical) {
		int attack = strength;
		if (isCritical) {
			attack *= 1.3;
		}
		return attack;
	}


	@Override
	public String toString() {
		return "Character [name=" + name + ", maxHealth=" + maxHealth + ", health=" + health + ", strength=" + strength
				+ ", experience=" + experience + "]";
	}



	

	

}
