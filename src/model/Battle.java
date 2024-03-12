package model;

import java.util.ArrayList;
import java.util.Scanner;

import view.*;

public class Battle {

	private Player player;
	private Agent agent;
	private boolean playerDefeated = false;
	private boolean enemyDefeated = false;

	public Battle(Player player, Agent agent) {
		this.player = player;
		this.agent = agent;
	}

	public void fightTurn() {
		if (!playerDefeated && !enemyDefeated) {
			int playerDamage = calculatePlayerDamage(player);
			int enemyDamage = agent.getStrength();
			int enemyHP = Math.max(0, agent.getHealth() - playerDamage);
			agent.setHealth(enemyHP);
			printPlayerAttack(player, playerDamage);
			printEnemyHealth(enemyHP);
			if (enemyHP <= 0) {
				handleEnemyDefeat();
			} else {
				int playerHP = Math.max(0, player.getHealth() - enemyDamage);
				player.setHealth(playerHP);
				printEnemyAttack(enemyDamage);
				if (playerHP <= 0) {
					handlePlayerDefeat();
				}
			}
		}
	}

	public int calculatePlayerDamage(Player player) {
		int randomCriticProb = (int) (Math.random() * 20) + 1;
		if (randomCriticProb < player.getEnergy()) {
			System.out.println("Crítico!!");
			return player.getCritcAttack(true);
		} else {
			return player.getCritcAttack(false);
		}
	}

	public void handleEnemyDefeat() {
		System.out.println("¡El enemigo ha sido derrotado!");
		player.setExperience(player.getExperience() + agent.getExperience());
		if (agent.dropItem() != null) {
			player.addItem(agent.dropItem());
		}
		enemyDefeated = true;
	}

	public void handlePlayerDefeat() {
		System.out.println("¡Has sido derrotado!");
		playerDefeated = true;
	}

	public void printPlayerAttack(Player player, int damage) {
		System.out.println(player.getName() + " ataca al enemigo y causa " + damage + " de daño.");
	}

	public void printEnemyHealth(int health) {
		System.out.println("El enemigo tiene " + health + " de salud.");
	}

	public void printEnemyAttack(int damage) {
		System.out.println("El enemigo te ataca y causa " + damage + " de daño.");
	}

}
