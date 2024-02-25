package model;

public class Player extends Character{
	
	private int level;

    public Player(String name, int maxHealth, int strength, int energy, int speed, int experience, int level) {
        super(name, maxHealth, strength, energy, speed, experience);
        this.level = level;
    }

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
    
}
