package view;

public class DialogueMenu extends Menu {
	public static String getFormattedCharacterName(String characterName, int width) {
		if (characterName.equals("")) {
			return getColoredString(getBinaryLine(width));
		}
		StringBuilder textBox = new StringBuilder();
		int padding = width - characterName.length() - 2;
		int leftPadding = 2;
		int rightPadding = padding - leftPadding;

		textBox.append(getColoredString(getBinaryLine(leftPadding), BLACK_BACKGROUND + GREEN + BOLD));
		textBox.append(getColoredString(" " + characterName + " ", BLACK_BACKGROUND + WHITE + BOLD + UNDERLINE));
		textBox.append(getColoredString(getBinaryLine(rightPadding), BLACK_BACKGROUND + GREEN + BOLD));

		return textBox.toString();
	}

	public static String getFormattedDialogue(String characterName, String dialogue, int width) {
		StringBuilder textBox = new StringBuilder();

		textBox.append(getColoredString(getBinaryLine(width))).append("\n");
		textBox.append(getFormattedCharacterName(characterName, width)).append("\n");

		textBox.append(getColoredString(getBinaryTextBox(width, dialogue))).append("\n");

		textBox.append(getColoredString(getBinaryLine(width))).append("\n");
		textBox.append(getColoredString(getBinaryLine(width)));

		return textBox.toString();
	}
}
