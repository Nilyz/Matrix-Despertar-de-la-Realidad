package model;

public class Enemy extends Character{
	
	 protected int aparitionProbability;

	    public Enemy(String name, int maxHealth, int strength, int energy, int speed, int experience, int aparitionProbability) {
	        super(name, maxHealth, strength, energy, speed, experience);
	        this.aparitionProbability = aparitionProbability;
	    }

		public int getAparitionProbability() {
			return aparitionProbability;
		}

		public void setAparitionProbability(int aparitionProbability) {
			this.aparitionProbability = aparitionProbability;
		}

		@Override
		public String toString() {
			return "Enemy [aparitionProbability=" + aparitionProbability + "]";
		}

	
}
