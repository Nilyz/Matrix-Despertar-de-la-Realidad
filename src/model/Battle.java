package model;

import java.util.ArrayList;
import java.util.Scanner;

import view.*;

public class Battle {
	static Scanner sc = new Scanner(System.in);

	public static void battleOptions(int option, Player player, Agent agent) {

		switch (option) {
		case 1:
			fight(player, agent);
			break;
		case 2:
			player.menuUseItems(player);
			break;
		case 3:
			player.useEXP(player);
			break;
		case 4:
			break;
		}
	}

	public static void fight(Player player, Agent agent) {

		System.out.println("ENEMIGO: " + agent.getName());

		boolean playerDefeated = false;
		boolean enemyDefeated = false;

		if (!playerDefeated && !enemyDefeated) {

			int randomCriticProb = (int) (Math.random() * 10) + 1;
			int enemyDamage = agent.getStrength();
			int playerDamage;
			/* calcular prob de hacer critico según la energía */
			if (randomCriticProb < player.getEnergy()) {
				playerDamage = player.getCritcAttack(true);
				System.out.println("Crítico!!");
			} else {
				playerDamage = player.getCritcAttack(false);
			}

			/*
			 * Turno del jugador el Math.max devuelve el valor máximo entre los dos valores,
			 * para que no devuelva salud negativa
			 */

			int enemyHP = Math.max(0, agent.getHealth() - playerDamage);
			agent.setHealth(enemyHP);
			System.out.println(player.getName() + " ataca al enemigo y causa " + playerDamage + " de daño.");
			System.out.println("El enemigo tiene " + enemyHP + " de salud.");

			// ver si se murió el enemigo
			if (enemyHP <= 0) {
				System.out.println("¡El enemigo ha sido derrotado!");
				player.setExperience(player.getExperience() + agent.getExperience());
				if (agent.dropItem() != null) {
					player.addItem(agent.dropItem());
				}

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
