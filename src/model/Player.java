package model;

import java.util.ArrayList;
import java.util.Scanner;

import view.BattleMenu;

public class Player extends Character {
	static Scanner sc = new Scanner(System.in);
	
	private int energy;
	private int speed;

	private ArrayList<Item> items;

	public Player(String name, int maxHealth, int strength, int energy, int speed, int experience) {
		super(name, maxHealth, strength, experience);
		this.energy=energy;
		this.speed=speed;
		this.items = new ArrayList<>();
	}

	// Personaje por defecto
	public Player() {
		this("Neo", 40, 10, 3, 10, 0);// esta llamando al otro constructor con sus parámetros
		this.items = new ArrayList<>();
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public void addItem(Item item) {
		items.add(item);
	}
	public void deleteItem(Item item) {
		items.remove(item);
	}



	
	@Override
	public String toString() {
		return super.toString()+ " energy=" + energy + ", speed=" + speed + ", items=" + items + "]";
	}

	

	// funcion para gastar la exp obtenida y poder elegir cuánto y en dónde gastarla
		public static void useEXP(Player player) {
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
	            setTheExpOption(player, "velocidad");
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
		        System.out.println("Cuánto quieres subir?");
		        int cant = sc.nextInt();
		        if (player.getExperience() >= cant) {
		            switch (stat) {
		                case "vida":
		                    player.maxHealth += cant;
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
		                case "velocidad":
		                    player.speed += cant;
		                    System.out.println("Tu velocidad: " + player.speed);
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
				System.out.print("\n<"+(i + 1) + "> ");
				item.seeItem();
			}
		}
		//funcion para usar los items
		public static void menuUseItems(Player player,int option) {
			ArrayList<Item> playerItems = player.getItems();
			// Pide al usuario que elija un ítem
			System.out.println("Elige un ítem para usar:");
			

			if (option!=0) {
				// Mostrar los ítems disponibles

				player.seePlayerItems();

				// Pedir al jugador que elija un ítem
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
			System.out.println("<0> Salir");
		}

		
		public static void useItem(Player player, Item item) {
			System.out.println("Usaste el ítem: " + item.getName());
			item.useItemStats(player, item);
		}
		
		public int getCritcAttack(boolean isCritical) {
			int attack = strength;
			if (isCritical) {
				attack *= 1.5;
			}
			return attack;
		}
		
		public static void scapeZone() {
			
		}
}
