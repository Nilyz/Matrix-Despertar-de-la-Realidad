package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle {
	static Scanner sc = new Scanner(System.in);

	public static void menuBattle() {
		System.out.println("\nElige una opción:");
		System.out.println("1. Atacar");
		System.out.println("2. Usar objetos");
		System.out.println("3. Huir");
		System.out.println("4. Ver stats");

	}

	public static void menuUseItems(Player player) {

		// Pide al usuario que elija un ítem
		System.out.println("Elige un ítem para usar:");
		ArrayList<Item> playerItems = player.getItems();
		
		   if (playerItems != null && !playerItems.isEmpty()) {
		        // Mostrar los ítems disponibles
		        
		            player.seePlayerItems();
		        

		        // Pedir al jugador que elija un ítem
		        System.out.print("Selecciona el número del ítem: ");
		        int choice = sc.nextInt();

		        // Verificar si la opción elegida es válida
		        if (choice >= 1 && choice <= playerItems.size()) {
		            Item selected = playerItems.get(choice - 1);
		            // Usar el ítem seleccionado
		            useItem(player, selected);
		        } else {
		            System.out.println("Selección inválida.");
		        }
		    } else {
		        System.out.println("El inventario del jugador está vacío.");
		    }
	}
	public static void useItem(Player player, Item item) { 
	    System.out.println("Usaste el ítem: " + item.getName());
	}

	public static void battleOptions(int option, Player player, Agent agent) {

		switch (option) {
		case 1:
			fight(player, agent);
			break;
		case 2:
			menuUseItems(player);
			break;
		case 3:
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
			int playerDamage = player.getStrength();
			int enemyDamage = agent.getStrength();

			// Turno del jugador
			// el Math.max devuelve el valor máximo entre los dos valores, para que no
			// devuelva salud negativa
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
