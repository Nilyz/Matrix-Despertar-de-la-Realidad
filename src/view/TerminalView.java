package view;

import model.*;
import model.Zone.Distritos;

public class TerminalView {
	public static final int defaultWidth = 100;
	public int width;

	public TerminalView() {
		this.width = defaultWidth;
	}

	public TerminalView(int width) {
		this.width = width;
	}

	public void printCharacterDialogue(String characterName, String dialogue) {
		System.out.println(DialogueMenu.getFormattedDialogue(characterName, dialogue, width));
	}
	
	public void getBorderedDialogue(String dialogue) {
		System.out.println(DialogueMenu.getBorderedTextBox(width, dialogue));
	}

	public void printCharacterName(String characterName) {
		System.out.println(DialogueMenu.getFormattedCharacterName(characterName, width));
	}

	public void printFightOptions() {
		System.out.println(BattleMenu.getFightOptions(width));
	}

	public void printFightVisualizer(Player player, Enemy enemy) {
		System.out.println(BattleMenu.getFightVisualizer(width, player, enemy));
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
			System.out.println("\nPasando al siguiente agente...");

		} else {
			System.out.println("Has derrotado a todos los enemigos");
		}

	}

	public void printEnemyDrop(Agent agente) {
		if (agente.getDroppableItems().size() > 0) {
			System.out.println("Obtuvistes " + agente.dropItem().getName());
		}

	}

	public void printZoneItemDrop(Zone zone) {
		System.out.println("\nObtuvistes " + zone.getMissionItem().getName());
	}

	public String printGiveUp() {
		return "Has cedido ante el implacable dominio de la Matrix. ¿Volverás a desafiarla?";
	}

	public void printZoneSelector() {
		System.out.println("A qué zona te gustaría adentrarte?");
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

	public void seePlayerItems(Player player) {
	    String itemsString = "";
	    for (int i = 0; i < player.getItems().size(); i++) {
	        Item item =  player.getItems().get(i);
	        System.out.println("<" + (i + 1) + "> " + item.getName() + ": " + item.seeItem() );
	    }
	}

	public void printStartBattle(Agent agent) {
		System.out.println("ENEMIGO: " + agent.getName());
	}

}
