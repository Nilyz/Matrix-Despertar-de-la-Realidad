package view;

import java.util.ArrayList;

public class Menu {
	public static final String RESET = "\u001B[0m";

	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";

	public static final String BLACK_BACKGROUND = "\u001B[40m";
	public static final String RED_BACKGROUND = "\u001B[41m";
	public static final String GREEN_BACKGROUND = "\u001B[42m";
	public static final String YELLOW_BACKGROUND = "\u001B[43m";
	public static final String BLUE_BACKGROUND = "\u001B[44m";
	public static final String PURPLE_BACKGROUND = "\u001B[45m";
	public static final String CYAN_BACKGROUND = "\u001B[46m";
	public static final String WHITE_BACKGROUND = "\u001B[47m";

	public static final String BOLD = "\u001B[1m";
	public static final String UNDERLINE = "\u001B[4m";

	// TODO: Change all the methods to order the parameters in the same way (width, text, other parameters)
	public static boolean isTerminalCode(String text) {
		if (text.contains(RESET) || text.contains(BLACK) || text.contains(RED) || text.contains(GREEN) || text.contains(YELLOW) || text.contains(BLUE) || text.contains(PURPLE) || text.contains(CYAN) || text.contains(WHITE) || text.contains(BLACK_BACKGROUND) || text.contains(RED_BACKGROUND) || text.contains(GREEN_BACKGROUND) || text.contains(YELLOW_BACKGROUND) || text.contains(BLUE_BACKGROUND) || text.contains(PURPLE_BACKGROUND) || text.contains(CYAN_BACKGROUND) || text.contains(WHITE_BACKGROUND) || text.contains(BOLD) || text.contains(UNDERLINE)) {
			return true;
		}
		return false;
	}
	public static String getColoredString(String text, String color) {
		return color + text + RESET;
	}

	public static String getColoredString(String text) {
		return getColoredString(text, GREEN + BOLD + BLACK_BACKGROUND);
	}

	public static char getRandomBinary() {
		int random = (int) (Math.random() * 2);
		return random == 0 ? '0' : '1';
	}

	public static String getCharLine(int width, char charForLine) {
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < width; i++) {
			line.append(charForLine);
		}
		return line.toString();
	}

	public static String getSpaceLine(int width) {
		return getCharLine(width, ' ');
	}

	public static String getBinaryLine(int width) {
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < width; i++) {
			line.append(getRandomBinary());
		}
		return line.toString();
	}

	public static String getBinaryLineText(int width, String text) {
		if (isTerminalCode(text)) {
			width += 5;
		} 
		int linePadding = width - text.length();
		int leftPadding = linePadding / 2;
		int rightPadding = linePadding - leftPadding;

		StringBuilder lineText = new StringBuilder();

		lineText.append(getColoredString(getBinaryLine(leftPadding)));

		lineText.append(RESET).append(BLACK_BACKGROUND + WHITE);

		if (isTerminalCode(text)) {
			lineText.append(" " + text + " ");
		} else {
			lineText.append(text);
		}

		lineText.append(BLACK_BACKGROUND + GREEN + BOLD);
		lineText.append(getBinaryLine(rightPadding));

		lineText.append(RESET);

		return lineText.toString();
	}

	public static String getSpaceLineText(int width, String text) {
		if (isTerminalCode(text)) {
			width += 5;
		}

		int linePadding = width - text.length();
		int leftPadding = linePadding / 2;
		int rightPadding = linePadding - leftPadding;

		StringBuilder lineText = new StringBuilder();

		lineText.append(RESET).append(BLACK_BACKGROUND + WHITE);
		lineText.append(getSpaceLine(leftPadding));
		lineText.append(text);
		lineText.append(getSpaceLine(rightPadding));

		return lineText.toString();
	}

	public static enum TEXT_ORIGIN {
		TOP, CENTER, BOTTOM
	}

	public static String getBinaryTextBox(int width, String text) {
		String[] texts = { text };
		return getBinaryTextBox(width, texts);
	}

	public static String getBinaryTextBox(int width, String[] texts) {
		return getBinaryTextBox(width, texts, TEXT_ORIGIN.TOP);
	}

	public static String getBinaryTextBox(int width, String[] texts, TEXT_ORIGIN direction) {
		int padding = 4;
		int widthForEachText = (width - padding) / texts.length;

		StringBuilder textBox = new StringBuilder();

		@SuppressWarnings("unchecked") // El compilador genera un warning por el cast de un array de ArrayList
		ArrayList<String>[] lines = new ArrayList[texts.length];

		int maxLines = -1;
		for (int i = 0; i < texts.length; i++) {
			lines[i] = new ArrayList<>();
			if (texts[i].equals("")) {
				lines[i].add("");
			} else {
				String[] words = texts[i].split(" ");
				StringBuilder lineText = new StringBuilder(" ");
				int widthForThisText = widthForEachText;
				for (String word : words) {
					if (isTerminalCode(word)) {
						lines[i].add(" " + word + " ");
						widthForThisText += word.length();
					} else if (lineText.length() + word.length() < widthForThisText) {
						lineText.append(word + " ");
					} else {
						lines[i].add(lineText.toString());
						lineText.setLength(0);
						lineText.append(" " + word + " ");
					}
				}
				lines[i].add(lineText.toString());
				if (lines[i].size() > maxLines) {
					maxLines = lines[i].size();
				}
			}
		}

		if (direction == TEXT_ORIGIN.BOTTOM) {
			for (ArrayList<String> line : lines) {
				while (line.size() < maxLines) {
					line.add(0, "");
				}
			}
		} else if (direction == TEXT_ORIGIN.CENTER) {
			for (ArrayList<String> line : lines) {
				line.add(0, "");
				if (line.size() < maxLines) {
					line.add("");
				}
			}
		}


		int extraPadding = (width - padding) - (widthForEachText * texts.length);

		for (int i = 0; i < maxLines; i++) {
			textBox.append(getColoredString(getBinaryLine(padding / 2)));
			for (int j = 0; j < texts.length; j++) {
				if (i < lines[j].size()) {
					textBox.append(getColoredString(getBinaryLineText(widthForEachText, lines[j].get(i))));
				} else {
					textBox.append(getColoredString(getBinaryLine(widthForEachText)));
				}
			}
			textBox.append(getColoredString(getBinaryLine((padding / 2) + extraPadding)));
			if (i < maxLines - 1) {
				textBox.append("\n");
			}
		}

		return textBox.toString();
	}

	public static String getBorderedTextBox(int width, String text) {
		String[] texts = { text };
		return getBorderedTextBox(width, texts, ' ');
	}

	public static String getBorderedTextBox(int width, String text, char charForLine) {
		String[] texts = { text };
		return getBorderedTextBox(width, texts, charForLine);
	}

	public static String getBorderedTextBox(int width, String[] texts, char charForLine) {
		return getBorderedTextBox(width, texts, charForLine, TEXT_ORIGIN.TOP);
	}

	public static String getBorderedTextBox(int width, String[] texts, TEXT_ORIGIN direction) {
		return getBorderedTextBox(width, texts, ' ', direction);
	}

	public static String getBorderedTextBox(int width, String[] texts, char charForLine, TEXT_ORIGIN direction) {
		int padding = 4;
		int widthForEachText = (width - padding) / texts.length;

		StringBuilder textBox = new StringBuilder();
		
		@SuppressWarnings("unchecked") // El compilador genera un warning por el cast de un array de ArrayList
		ArrayList<String>[] lines = new ArrayList[texts.length];

		int maxLines = -1;
		for (int i = 0; i < texts.length; i++) {
			lines[i] = new ArrayList<>();
			if (texts[i].equals("")) {
				lines[i].add("");
			} else {
				String[] splitText = texts[i].split("\\r?\\n");
				for (String text : splitText) {
					String[] words = text.split(" ");
					StringBuilder lineText = new StringBuilder("");

					int widthForThisText = widthForEachText;
					for (String word : words) {
						if (isTerminalCode(word)) {
							lines[i].add(word);
							widthForThisText += word.length();
						} else if (lineText.length() + word.length() < widthForThisText) {
							lineText.append(word + " ");
						} else {
							lines[i].add(lineText.toString());
							lineText.setLength(0);
							lineText.append(word + " ");
						}
					}
					lines[i].add(lineText.toString());
					if (lines[i].size() > maxLines) {
						maxLines = lines[i].size();
					}
				}
			}
		}

		if (direction == TEXT_ORIGIN.BOTTOM || direction == TEXT_ORIGIN.CENTER) {
			for (ArrayList<String> line : lines) {
				while (line.size() < maxLines) {
					line.add(0, "");
					if (direction == TEXT_ORIGIN.CENTER && line.size() < maxLines) {
						line.add("");
					}
				}
			}
		}

		int extraPadding = (width - padding) - (widthForEachText * texts.length);

		textBox.append(getColoredString(getBinaryLine(width))).append("\n");

		for (int i = 0; i < maxLines; i++) {
			textBox.append(getColoredString(getRandomBinary() + getSpaceLine(1)));
			for (int j = 0; j < texts.length; j++) {
				if (i < lines[j].size()) {
					textBox.append(getColoredString(getSpaceLineText(widthForEachText, lines[j].get(i))));
				} else {
					textBox.append(getColoredString(getSpaceLine(widthForEachText)));
				}
			}

			textBox.append(getColoredString(getSpaceLine(1 + extraPadding) + getRandomBinary()));

			textBox.append("\n");
		}

		textBox.append(getColoredString(getBinaryLine(width)));
		return textBox.toString();
	}
}
