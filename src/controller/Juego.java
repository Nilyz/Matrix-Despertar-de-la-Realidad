package controller;

import java.util.Scanner;

import model.Agent;
import model.Battle;
import model.Player;
import model.Zone;
import model.Zone.Distritos;
import view.TerminalView;

public class Juego {

	public static void game() {
		TerminalView vista = new TerminalView();
		Scanner sc = new Scanner(System.in);

		Player jugador = new Player();
		boolean continuarJugando = true;

		while (continuarJugando) {

			Zone zone1 = new Zone("DISTRITO INDUSTRIAL");
			Zone zone2 = new Zone("SECTOR RESIDENCIAL");
			Zone zone3 = new Zone("NÚCLEO DE LA CIUDAD");
			Zone zone4 = new Zone("INSTALACIÓN DE SEGURIDAD");

			zone1.generateEnemies(Distritos.DISTRITO_INDUSTRIAL, 2);
			zone2.generateEnemies(Distritos.SECTOR_RESIDENCIAL, 2);
			zone3.generateEnemies(Distritos.NÚCLEO_DE_LA_CIUDAD, 2);
			zone4.generateEnemies(Distritos.INSTALACIÓN_DE_SEGURIDAD, 2);

			vista.printZoneSelector();
			int selectZoneOption = sc.nextInt();

			Zone selectedZone = null;
			switch (selectZoneOption) {
			case 1:

				zone1.verZona();
				selectedZone = zone1;
				break;
			case 2:
				selectedZone = zone2;
				break;
			case 3:
				selectedZone = zone3;
				break;
			case 4:
				selectedZone = zone4;
				break;
			case 5:
				continuarJugando = false;
				System.out.println("Abandonastes la partida...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
			}

			if (selectedZone != null) {
				System.out.println("Te has adentrado en -" + selectedZone.getName() + "-");
				startBattle(jugador, selectedZone);
			}
		}

		sc.close(); // Cerrar el scanner al salir del juego
	}

	public static void startBattle(Player jugador, Zone zone) {
		boolean noEnemiesRemaining = false;
		int cont = 0;
		TerminalView vista = new TerminalView();
		Scanner sc = new Scanner(System.in);

		for (Agent currentAgent : zone.getAgents()) {
			Battle lucha = new Battle(jugador, currentAgent);
			lucha.startBattle();

			while (jugador.getHealth() > 0 && currentAgent.getHealth() > 0) {
				vista.printFightVisualizer(jugador, currentAgent);
				int option = sc.nextInt();

				switch (option) {
				case 1:
					lucha.fightTurn();
					break;
				case 2:
					int itemMenuOption = 0;
					jugador.menuUseItems(jugador, itemMenuOption);
					itemMenuOption = sc.nextInt();
					break;
				case 3:
					vista.printSeeCharacterMenu(jugador);
					jugador.useEXP(jugador);
					break;
				case 4:
					//falta prob de escapar de la zona
					System.out.println("Abandonastes la zona");
					return;
				case 5:
					vista.printGiveUp();
					System.exit(0); // Salir completamente del programa
					break;
				default:
					System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
				}
			}

			vista.printEnemyDrop(currentAgent);
			cont++;
			if (cont < zone.getAgents().size()) {
				vista.printEndBattle(noEnemiesRemaining);
			} else {
				noEnemiesRemaining = true;
				vista.printEndBattle(noEnemiesRemaining);

			}

		}
	}
}
