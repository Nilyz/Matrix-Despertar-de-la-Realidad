package model;

public abstract class Character {
	protected String name;
	private int maxHealth;
	private int health;
	private int strength;
	private int energy;
	private int speed;
	private int experience;

	public Character() {
	}

	public Character(String name, int maxHealth, int strength, int energy, int speed, int experience) {
		this.name = name;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.strength = strength;
		this.energy = energy;
		this.speed = speed;
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

	public boolean isCriticalAttack() {
		int random = (int) (Math.random() * 25);
		return random < speed;
	}

	@Override
	public String toString() {
		return "Character [name=" + name + ", maxHealth=" + maxHealth + ", health=" + health + ", strength=" + strength
				+ ", energy=" + energy + ", speed=" + speed + ", experience=" + experience + ", getName()=" + getName()
				+ ", getMaxHealth()=" + getMaxHealth() + ", getHealth()=" + getHealth() + ", getStrength()="
				+ getStrength() + ", getEnergy()=" + getEnergy() + ", getSpeed()=" + getSpeed() + ", getExperience()="
				+ getExperience() + ", isCriticalAttack()=" + isCriticalAttack() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	

}
