package model;

public class Dron extends Enemy {

	int stealExp;
	int level;


	

	public Dron(String name, int experience, int aparitionProbability, int stealExp, int level) {
		super(name, 0, 0, experience, aparitionProbability);
		this.stealExp = stealExp;
		this.level = level;
	}
	
	public Dron() {
		this("Dron de Vigilancia de nivel ", 5, 10, 0,0);
	}

	public int getStealExp() {
		return stealExp;
	}

	public void setStealExp(int stealExp) {
		this.stealExp = stealExp;
	}
	

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	//instancia un drón con stats diferentes según la zona
	public Dron generateDron(Player jugador, Zone zone) {
	    int droneLevel = 0;
	    if (zone.getName().equals("DISTRITO INDUSTRIAL")) {
	        droneLevel = (int) (Math.random() * 3) + 1;
	    } else if (zone.getName().equals("SECTOR RESIDENCIAL")) {
	        droneLevel = (int) (Math.random() * 6) + 3;
	    } else if (zone.getName().equals("NÚCLEO DE LA CIUDAD")) {
	        droneLevel = (int) (Math.random() * 10) + 6;
	    } else if (zone.getName().equals("INSTALACIÓN DE SEGURIDAD")) {
	        droneLevel = (int) (Math.random() * 15) + 10;
	    }
	    stealExp = calculateHowMuchExp(droneLevel);
	    return new Dron("Dron de Vigilancia de nivel ", 5, 10, stealExp, droneLevel);
	}

	public int calculateHowMuchExp(int droneLevel) {
		return this.stealExp = 2 * droneLevel;
	}

	public void stealExperience(Player player, int stealExp, Dron dron) {
	    player.setExperience(player.getExperience() - stealExp);	   
	    if (player.getExperience() < 0) {
	        player.setExperience(0);
	    }
	    
	}
	
}
