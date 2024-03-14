package view;

import java.util.ArrayList;

import model.*;
import model.Zone.Distritos;
import view.Menu.TEXT_ORIGIN;
import view.RepositoryASCII.ARTS;

public class TerminalView {
	public static final int defaultWidth = 100;
	private int width;

	public TerminalView() {
		this.width = defaultWidth;
	}

	public TerminalView(int width) {
		this.width = width;
	}

	public void printCharacterDialogue(String characterName, String dialogue) {
		System.out.println();
		System.out.println(DialogueMenu.getFormattedDialogue(characterName, dialogue, width));

	}

	public void getBorderedDialogue(String dialogue) {
		System.out.println(DialogueMenu.getBorderedTextBox(width, dialogue));
		System.out.println();
	}

	public void printCharacterName(String characterName) {
		System.out.println(DialogueMenu.getFormattedCharacterName(characterName, width));

	}

	public void printFightOptions() {
		System.out.println(BattleMenu.getFightOptions(width));
	}

	public void printFightVisualizer(Player player, Enemy enemy) {
		System.out.println(BattleMenu.getFightVisualizer(width, player, enemy, RepositoryASCII.getArt(ARTS.AGENT)));
	}

	public void printFightVisualizer(Player player, Enemy enemy, String enemyImage) {
		System.out.println(BattleMenu.getFightVisualizer(width, player, enemy, enemyImage));
	}

	public void printFightVisualizer(Player player, Agent agent, ARTS enemyImage) {
		System.out.println(BattleMenu.getFightVisualizer(width, player, agent, RepositoryASCII.getArt(enemyImage)));
	}

	public void printCharacterSelectionMenu(int playerOption) {
		if (playerOption != 1 && playerOption != 2) {
			System.out.println("Opción inválida, vuelva a intentar");
		}

		System.out.println("Eres...");
		System.out.println("<1> Neo");
		System.out.println("<2> Otro");
	}

	public void printCharacterDialogBox(ARTS CharacterImage, String text) {
		System.out.println();
		String[] texts = { (RepositoryASCII.getArt(CharacterImage)), text };
		System.out
				.println(BattleMenu.getColoredString(BattleMenu.getBorderedTextBox(width, texts, TEXT_ORIGIN.CENTER)));
		System.out.println();
	}
	public void printIntro() {
		System.out.println(DialogueMenu.getBorderedTextBox(width,
				"╔═══════════════════════════════════════════════════════════════════════════════════════╗\r\n"
						+ "║                                                                                       ║\r\n"
						+ "║      _____         _                           _                        _             ║\r\n"
						+ "║     | ____| _ __  | |_  _ __  __ _  _ __    __| |  ___        __ _     | |  __ _      ║\r\n"
						+ "║     |  _|  | '_ \\ | __|| '__|/ _` || '_ \\  / _` | / _ \\      / _` |    | | / _` |     ║\r\n"
						+ "║     | |___ | | | || |_ | |  | (_| || | | || (_| || (_) |    | (_| |    | || (_| |     ║\r\n"
						+ "║     |_____||_| |_| \\__||_|   \\__,_||_| |_| \\__,_| \\___/      \\__,_|    |_| \\__,_|     ║\r\n"
						+ "║     |  \\/  |  __ _ | |_  _ __ (_)__  __                                               ║\r\n"
						+ "║     | |\\/| | / _` || __|| '__|| |\\ \\/ /                                               ║\r\n"
						+ "║     | |  | || (_| || |_ | |   | | >  <  _  _  _                                       ║\r\n"
						+ "║     |_|  |_| \\__,_| \\__||_|   |_|/_/\\_\\(_)(_)(_)                                      ║\r\n"
						+ "║                                                                                       ║\r\n"
						+ "╚═══════════════════════════════════════════════════════════════════════════════════════╝"));
	}

	

	public void printSeeCharacterMenu(Player player) {
		System.out.println("Exp: " + player.getExperience());
		System.out.println("Qué te gustaría subir?");
		System.out.println("<1> Vida");
		System.out.println("<2> Energía");
		System.out.println("<3> Fuerza");
		System.out.println("<4> Suerte");
		System.out.println("<0> Salir");

	}

	public void printEndBattle(boolean noEnemiesRemaining) {
		if (!noEnemiesRemaining) {
			System.out.println();
			System.out.println(BattleMenu.getBorderedTextBox(width, "Pasando al siguiente agente..."));
			System.out.println();

		} else {
			System.out.println();
			System.out.println(BattleMenu.getBorderedTextBox(width, "Has derrotado a todos los enemigos"));
			System.out.println();
		}

	}

	public void printEnemyDropAndExp(Agent agente) {
		if (agente.getDroppableItems().size() > 0) {
			System.out.println();
			System.out.println(BattleMenu.getBorderedTextBox(width,
					"Obtuviste " + agente.dropItem().getName() + " y +" + agente.getExperience() + " de EXP"));

		} else {
			System.out.println();
			System.out
					.println(BattleMenu.getBorderedTextBox(width, "Obtuviste +" + agente.getExperience() + " de EXP"));
		}
	}

	public void printZoneItemDrop(Zone zone) {
		System.out.println(BattleMenu.getBorderedTextBox(width,"\nLa misión fue todo un éxito, has conseguido: " + zone.getMissionItem().getName()));
	}

	

	public void printZoneSelector() {
		System.out.println("\nA qué zona te gustaría adentrarte?");
		System.out.println("<1> DISTRITO INDUSTRIAL");
		System.out.println("<2> SECTOR RESIDENCIAL");
		System.out.println("<3> NÚCLEO DE LA_CIUDAD");
		System.out.println("<4> INSTALACIÓN DE SEGURIDAD");
		System.out.println("<5> Ver items de las misiones");
		System.out.println("<0> Abandonar el juego");
	}

	public void printStartExpMenu(int exp) {
		System.out.println("Experiencia disponible: " + exp + " exp, repártela entre tus estadísticas");
		System.out.println("<1> Vida");
		System.out.println("<2> Fuerza");
		System.out.println("<3> Energía");
		System.out.println("<4> Velocidad");
	}

	public void printSeePlayerItems(Player player) {
	    
	    if (!player.getItems().isEmpty()) {
	        for (int i = 0; i < player.getItems().size(); i++) {
	            Item item = player.getItems().get(i);
	            System.out.println("<" + (i + 1) + "> " + item.getName() + ": " + item.seeItem());
	        }
	    } else {
	        System.out.println("El inventario del jugador está vacío.");
	    }
	    System.out.println("<0> Salir");
	}

	public void printDronAparition(Dron dron) {
		System.out.println();
		System.out.println(BattleMenu.getBorderedTextBox(width, dron.getName() + " " + dron.getLevel()
				+ " te descubrió, has perdido " + dron.getStealExp() + " puntos de experiencia!"));

	}
	
	public void printPlayerAttack(Player player,int playerDamage) {
		System.out.println(player.getName() + " ataca al enemigo y causa " + playerDamage + " de daño.");
	}

	public void printEnemyAttack(int damage) {
		System.out.println("El enemigo te ataca y causa " + damage + " de daño.");
	}

}
