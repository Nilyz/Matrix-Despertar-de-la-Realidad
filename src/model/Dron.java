package model;

public class Dron extends Enemy {

	int stealExp;
	
	public Dron(String name, int experience,int aparitionProbability,int stealExp) {
		super(name, 0, 0, experience, aparitionProbability);
		this.stealExp=stealExp;
	}
	

	public int getStealExp() {
		return stealExp;
	}

	public void setStealExp(int stealExp) {
		this.stealExp = stealExp;
	}


	public void stealExperience(Player player) {
		System.out.println("tienes: "+ player.getExperience());
		player.setExperience(player.getExperience() - this.experience);
        System.out.println("¡Un dron apareció y te robó "+ this.experience+" puntos de experiencia!");
        if(player.getExperience()<0) {
        	player.setExperience(0);
        }
        System.out.println("Ahora tienes: "+ player.getExperience());
    }
}
