package model;

public abstract class Enemy extends Character {

	protected int aparitionProbability;

	public Enemy(String name, int maxHealth, int strength, int experience, int aparitionProbability) {
		super(name, maxHealth, strength, experience);
		this.aparitionProbability = aparitionProbability;
	}

	public int getAparitionProbability() {
		return aparitionProbability;
	}

	public void setAparitionProbability(int aparitionProbability) {
		this.aparitionProbability = aparitionProbability;
	}

}
