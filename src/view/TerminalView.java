package view;

import model.Enemy;
import model.Player;

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

	public void printCharacterName(String characterName) {
		System.out.println(DialogueMenu.getFormattedCharacterName(characterName, width));
	}

	public void printFightOptions() {
		System.out.println(BattleMenu.getFightOptions(width));
	}

	public void printFightVisualizer(Player player, Enemy enemy) {
		System.out.println(BattleMenu.getFightVisualizer(width, player, enemy));
	}
}
