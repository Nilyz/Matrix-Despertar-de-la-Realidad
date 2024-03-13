package view;

import model.Enemy;
import model.Player;

public class BattleMenu extends Menu {
	public static String getFightVisualizer(int width, Player player, Enemy enemy) {
		return getFightVisualizer(width, player, enemy, "");
	}

	public static String getFightVisualizer(int width, Player player, Enemy enemy, String enemyImage) {
		StringBuilder visualizer = new StringBuilder();

		String[] enemyInfo = { 
			enemyImage != "" ? enemyImage : "", 
			enemy.getName() + "\n" + "\n" +
			"Vida: " + enemy.getHealth() + "\n" +
			"Fuerza: " + enemy.getStrength() + "\n"
		};

		visualizer.append(getColoredString(getBorderedTextBox(width, enemyInfo, TEXT_ORIGIN.CENTER))).append("\n");

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
		options.append(getBinaryTextBox(width, firstLineOptions)).append("\n");

		String[] secondLineOptions = { "<3> Ver personaje", "<4> Huir" };
		options.append(getBinaryTextBox(width, secondLineOptions)).append("\n");

		String[] thirdLineOptions = { "<5> Rendirse", "" };
		options.append(getBinaryTextBox(width, thirdLineOptions)).append("\n");

		options.append(getColoredString(getBinaryLine(width)));

		return options.toString();
	}

	public static String getPlayerInlineStats(int width, Player player) {
		String health = "Vida: " + player.getHealth();
		String attack = "Fuerza: " + player.getStrength();
		String energy = "Energia: " + player.getEnergy();
		String speed = "Suerte: " + player.getLuck();
		String exp = "EXP: " + player.getExperience();


		StringBuilder textBox = new StringBuilder();

		String[] stats = { health, attack, speed, energy };
		textBox.append(getBinaryTextBox(width, stats));

		return textBox.toString();
	}
	
	

}

	