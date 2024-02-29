package model;

import java.util.Scanner;

public class Battle {

	public static void menuBattle() {
		System.out.println("Elige una opción:");
		System.out.println("1. Atacar");
		System.out.println("2. Usar objetos");
		System.out.println("3. Huir");
		System.out.println("4. Ver stats");
		
	}

	
	public static void battleOptions(int option,Player player, Agent agent) {
		
		switch(option) {
		case 1:
			fight(player, agent);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
	}
	
	
	public static void fight(Player player, Agent agent) {

		System.out.println("ENEMIGO: "+agent.getName());

		boolean playerDefeated = false;
		boolean enemyDefeated = false;

		if(!playerDefeated && !enemyDefeated) {
			int playerDamage = player.getStrength();
			int enemyDamage = agent.getStrength();

			// Turno del jugador
			//el Math.max devuelve el valor máximo entre los dos valores, para que no devuelva salud negativa
			int enemyHP = Math.max(0, agent.getHealth() - playerDamage);
			agent.setHealth(enemyHP);
			System.out.println(player.getName() + " ataca al enemigo y causa " + playerDamage + " de daño.");
			System.out.println("El enemigo tiene " + enemyHP + " de salud.");

			// ver si se murió el enemigo
			if (enemyHP <= 0) {
				System.out.println("¡El enemigo ha sido derrotado!");
				enemyDefeated = true;
			} else {
				// Turno del enemigo
				int playerHP = Math.max(0, player.getHealth() - enemyDamage);
				player.setHealth(playerHP);
				System.out.println("El enemigo te ataca y causa " + enemyDamage + " de daño.");
				System.out.println("Tienes " + playerHP + " de salud.");

				// Ver si se murió el jugador
				if (playerHP <= 0) {
					System.out.println("¡Has sido derrotado!");
					playerDefeated = true;
				}
			}
		}
	}
}
