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
	    if (expOption == 1) {
	        setTheExpOption(player, "vida");
	    } else if (expOption == 2) {
	        setTheExpOption(player, "energia");
	    } else if (expOption == 3) {
	        setTheExpOption(player, "fuerza");
	    } else if (expOption == 4) {
	        setTheExpOption(player, "suerte");
	    } else if (expOption == 0) {
	        //sale del método
	    } else {
	        System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
	        useEXP(player);
	    }
	}

	public static void setTheExpOption(Player player, String stat) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Cuánto quieres subir?");
	    int cant = sc.nextInt();
	    if (player.getExperience() >= cant) {
	        if (stat.equals("vida")) {
	            player.health += cant;
	            System.out.println("Tu vida: " + player.health);
	        } else if (stat.equals("energia")) {
	            player.energy += cant;
	            System.out.println("Tu energía: " + player.energy);
	        } else if (stat.equals("fuerza")) {
	            player.strength += cant;
	            System.out.println("Tu fuerza: " + player.strength);
	        } else if (stat.equals("suerte")) {
	            player.luck += cant;
	            System.out.println("Tu Suerte: " + player.luck);
	        }
	        player.experience -= cant;
	        System.out.println("Te quedan " + player.experience + " de experiencia");
	    } else {
	        System.out.println("Cantidad de experiencia insuficiente");
	    }
	}

	//devuelve una cadena que contenga todos los elementos concatenados
	public String seePlayerItems() {
	    String itemsString = "";
	    for (int i = 0; i < items.size(); i++) {
	        Item item = items.get(i);
	        itemsString += "<" + (i + 1) + "> " + item.getName() + ": " + item.seeItem() + "\n";
	    }
	    return itemsString;
	}

	
	public static String useItem(Player player, Item item) {
		item.useItemStats(player, item);
		return "Usaste el ítem: " + item.getName();
		
	}

	public void seeMissionItems(Player player) {
	    System.out.println("Ítems de Misiones:");
	    for (int i = 0; i < player.getMissionItems().size(); i++) {
	        ZoneItem item = player.getMissionItems().get(i);
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
