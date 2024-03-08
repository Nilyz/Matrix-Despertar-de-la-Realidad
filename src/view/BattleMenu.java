package view;

import model.Enemy;
import model.Player;

public class BattleMenu extends Menu {
	public static String getFightVisualizer(int width, Player player, Enemy enemy) {
		StringBuilder visualizer = new StringBuilder();
		// TODO: Enemy image and stats
		/*String[] enemyVisualizer = {RepositoryASCII.neoArt, getBinaryTextBox("NEO", width/3)};
		visualizer.append(getColoredString(getBinaryTextBox(enemyVisualizer, width, true))).append("\n");*/

		visualizer.append(getColoredString(getSpaceLine(width))).append("\n");
		visualizer.append(getColoredString(getBinaryLine(width))).append("\n");
		visualizer.append(getPlayerInlineStats(width, player)).append("\n");
		visualizer.append(getColoredString(getBinaryLine(width))).append("\n");
		visualizer.append(getColoredString(getSpaceLine(width))).append("\n");
		visualizer.append(getColoredString(getFightOptions(width))).append("\n");
		String text = " Seleccione una opción: ";
		visualizer.append(getColoredString(getBinaryLine(2)));
		visualizer.append(getColoredString(text, BLACK_BACKGROUND + WHITE + UNDERLINE));
		visualizer.append(getColoredString(getSpaceLine(width - text.length() - 4)));
		visualizer.append(getColoredString(getBinaryLine(2)));

		return visualizer.toString();
	}

	public static String getFightOptions(int width) {
		StringBuilder options = new StringBuilder();

		options.append(getColoredString(getBinaryLine(width))).append("\n");
		String texto = " Opciones ";
		int linePadding = width - texto.length();
		int leftPadding = linePadding / 2;
		int rightPadding = linePadding - leftPadding;
		options.append(getColoredString(getBinaryLine(leftPadding)));
		options.append(getColoredString(texto, BLACK_BACKGROUND + WHITE + UNDERLINE + BOLD));
		options.append(getColoredString(getBinaryLine(rightPadding))).append("\n");

		String[] firstLineOptions = { "<1> Atacar", "<2> Usar objetos" };
		options.append(getBinaryTextBox(firstLineOptions, width)).append("\n");

		String[] secondLineOptions = { "<3> Ver personaje", "<4> Huir" };
		options.append(getBinaryTextBox(secondLineOptions, width)).append("\n");

		String[] thirdLineOptions = { "<5> Rendirse", "" };
		options.append(getBinaryTextBox(thirdLineOptions, width)).append("\n");

		options.append(getColoredString(getBinaryLine(width)));

		return options.toString();
	}

	public static String getPlayerInlineStats(int width, Player player) {
		String health = "Vida: " + player.getHealth();
		String attack = "Fuerza: " + player.getStrength();
		String speed = "Velocidad: " + player.getSpeed();
		String energy = "Energia: " + player.getEnergy();

		StringBuilder textBox = new StringBuilder();

		String[] stats = { health, attack, speed, energy };
		textBox.append(getBinaryTextBox(stats, width));

		return textBox.toString();
	}
	
	

}

	