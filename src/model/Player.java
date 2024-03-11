package model;

import java.util.ArrayList;
import java.util.Scanner;

import view.BattleMenu;

public class Player extends Character {

	private int energy;
	private int luck;

	private ArrayList<Item> items;
	private ArrayList<ZoneItem> missionItems;

	public Player(String name, int maxHealth, int strength, int energy, int luck, int experience) {
		super(name, maxHealth, strength, experience);
		this.energy = energy;
		this.luck = luck;
		this.items = new ArrayList<>();
		this.missionItems = new ArrayList<>();
	}

	// Personaje por defecto
	public Player() {
		this("Neo", 40, 10, 10, 5, 0);// esta llamando al otro constructor con sus parámetros
		this.items = new ArrayList<>();
		this.missionItems = new ArrayList<>();
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int speed) {
		this.luck = speed;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void deleteItem(Item item) {
		this.items.remove(item);
	}

	public ArrayList<ZoneItem> getMissionItems() {
		return missionItems;
	}

	public void setMissionItems(ZoneItem missionItems) {
		this.missionItems.add(missionItems);
	}

	// funcion para gastar la exp obtenida y poder elegir cuánto y en dónde gastarla
	public static void useEXP(Player player) {
		Scanner sc = new Scanner(System.in);
		int expOption = sc.nextInt();

		switch (expOption) {
		case 1:
			setTheExpOption(player, "vida");
			break;
		case 2:
			setTheExpOption(player, "energia");
			break;
		case 3:
			setTheExpOption(player, "fuerza");
			break;
		case 4:
			setTheExpOption(player, "suerte");
			break;
		case 0:
			break;
		default:
			System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
			useEXP(player);
			break;
		}

	}

	public static void setTheExpOption(Player player, String stat) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuánto quieres subir?");
		int cant = sc.nextInt();
		if (player.getExperience() >= cant) {
			switch (stat) {
			case "vida":
				player.health += cant;
				System.out.println("Tu vida: " + player.health);
				break;
			case "energia":
				player.energy += cant;
				System.out.println("Tu energía: " + player.energy);
				break;
			case "fuerza":
				player.strength += cant;
				System.out.println("Tu fuerza: " + player.strength);
				break;
			case "suerte":
				player.luck += cant;
				System.out.println("Tu Suerte: " + player.luck);
				break;
			}
			player.experience -= cant;
			System.out.println("Te quedan " + player.experience + " de experiencia");
		} else {
			System.out.println("Cantidad de experiencia insuficiente");
		}

	}

	public void seePlayerItems() {
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			System.out.print("\n<" + (i + 1) + "> ");
			item.seeItem();
		}

	}

	// funcion para usar los items
	public static void menuUseItems(Player player) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Item> playerItems = player.getItems();
		int choice = -1;
		System.out.println("Elige un ítem para usar:");

		if (!playerItems.isEmpty()) {
			while (choice != 0) {
				// Mostrar los ítems disponibles
				player.seePlayerItems();
				System.out.println("\n<0> Salir");

				choice = sc.nextInt();

				if (choice >= 1 && choice <= playerItems.size()) {
					Item selected = playerItems.get(choice - 1);
					// Usar el ítem seleccionado
					useItem(player, selected);
				} else if (choice != 0) {
					System.out.println("Selección inválida.");
				}
			}
		} else {
			System.out.println("No hay ítems disponibles para usar en el inventario del jugador.");
			System.out.println("<0> Salir");

			choice = sc.nextInt();

		}
		if (choice == 0) {
			// Salir del método
			return;
		}
	}

	public static void useItem(Player player, Item item) {
		System.out.println("Usaste el ítem: " + item.getName());
		item.useItemStats(player, item);
	}

	public void seeMissionItens() {
		System.out.println("Ítems de Misión:");
		for (int i = 0; i < missionItems.size(); i++) {
			ZoneItem item = missionItems.get(i);
			System.out.println((i + 1) + ". " + item.getName());
		}
	}

	// calcular el crítico
	public int getCritcAttack(boolean isCritical) {
		int attack = strength;
		if (isCritical) {
			attack *= 1.5;

		}
		return attack;
	}

	public String PlayerEndQuote(Player player, Zone zone) {

		if (zone.getName().equals("DISTRITO INDUSTRIAL")) {
			return "No me detendrás, Smith. La verdad prevalecerá sobre tus mentiras.";
		} else if (zone.getName().equals("SECTOR RESIDENCIAL")) {
			return "La libertad siempre triunfará sobre la opresión, Smith";
		} else if (zone.getName().equals("NÚCLEO DE LA CIUDAD")) {
			return "\"La libertad siempre triunfará sobre la opresión, Smith.";
		} else if (zone.getName().equals("INSTALACIÓN DE SEGURIDAD")) {
			return "La verdad ha sido revelada, Smith. La humanidad está libre..";
		} else {
			return "";
		}

	}

}
