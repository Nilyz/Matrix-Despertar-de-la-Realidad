package model;

import java.util.ArrayList;

public class Player extends Character{
	
	private int level;
	private int luck;
	private ArrayList<Item>items;
	
	
    public Player(String name, int maxHealth, int strength, int energy, int speed, int experience, int level) {
        super(name, maxHealth, strength, energy, speed, experience);
		this.level = level;
    }
  //Personaje por defecto
  	public Player() {
  		this("Neo",40,10,10,10,0,1);//esta llamando al otro constructor con sus parámetros
      }

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return super.toString() + "Player [level=" + level + ", luck=" + luck + ", items=" + items +"]";
	}
	
	
}
