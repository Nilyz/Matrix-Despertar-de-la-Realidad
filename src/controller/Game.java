package controller;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

import model.Zone.Distritos;
import view.TerminalView;
import view.RepositoryASCII.ARTS;

public class Game {

	// función para seleccionar personaje
	public static void startGame() {
		TerminalView vista = new TerminalView();
		Scanner sc = new Scanner(System.in);
		Player neo = new Player();
		Player personalized = new Player("", 0, 0, 0, 0, 65);
		int playerOption = 1;
		vista.printIntro();

		vista.printCharacterSelectionMenu(playerOption);
		playerOption = sc.nextInt();
		while (playerOption != 1 && playerOption != 2) {

			vista.printCharacterSelectionMenu(playerOption);
			playerOption = sc.nextInt();
		}

		sc.nextLine();
		if (playerOption == 1) {
			firstDialog(neo);

		} else {
			vista.getBorderedDialogue("Por favor, introduce tu nombre:");
			personalized.setName(sc.nextLine());
			vista.getBorderedDialogue("Has recibido 65 puntos de experiencia para distribuir.");
			do {
				vista.printStartExpMenu(personalized.getExperience());
				personalized.useEXP(personalized);
			} while (personalized.getExperience() > 0);

			firstDialog(personalized);

		}

	}

	public static void firstDialog(Player player) {
		Scanner sc = new Scanner(System.in);
		TerminalView vista = new TerminalView();

		vista.getBorderedDialogue(
				"Despiertas en tu apartamento, como en un día cualquiera.Sin embargo, algo está fuera de lugar… Luces parpadeantes y distorsiones en la realidad te hacen cuestionar tu entorno.De repente, un mensaje aparece en tu pantalla:");

		sc.nextLine();

		vista.getBorderedDialogue("Despierta " + player.getName() + "...█");

		sc.nextLine();

		vista.getBorderedDialogue(
				"De repente, una fuerza invisible te envuelve y te transporta a un lugar desconocido. Te encuentras en una habitación bien iluminada, con una figura misteriosa esperándote…");

		sc.nextLine();

		vista.printCharacterDialogBox(ARTS.MORFEO,
				"Hola " + player.getName() + ", como te habrás dado cuenta, las cosas no son lo que parecen.");

		sc.nextLine();

		vista.printCharacterDialogBox(ARTS.MORFEO, "Tengo aquí dos pastillas: una roja y una azul.\n"
				+ "\nLa pastilla roja te abrirá los ojos y te mostrará la verdad, sin filtros ni ilusiones.\n"
				+ "\nLa pastilla azul te devolverá a tu vida normal, donde podrás seguir creyendo lo que quieras creer."
				+ "\nLa elección es tuya. ¿Qué pastilla tomarás?");

		System.out.println("<1> Tomar pastilla Roja");
		System.out.println("<2> Tomar pastilla Azul");
		int option;
		option = sc.nextInt();
		if (option == 2) {
			vista.printCharacterDialogBox(ARTS.HUNTER, "Tomaste la pastilla azul y has decidido seguir viviendo en la ilusión...\n¿Pero cuánto tiempo podrás resistir la curiosidad de conocer la verdad?");
		} else {
			vista.getBorderedDialogue("Tomaste la pastilla roja y has decidido despertar de la ilusión.");
			sc.nextLine();

			vista.printCharacterDialogBox(ARTS.MORFEO, "Has elegido sabiamente " + player.getName()
					+ ". Ahora que has despertado, te revelaré la verdad sobre la Matrix");
			sc.nextLine();

			vista.getBorderedDialogue(
					"“Morfeo te revela la verdad sobre el mundo en el que vives: Todo es una simulación creada por máquinas que han esclavizado a la humanidad..”");
			sc.nextLine();
			vista.getBorderedDialogue(
					"“Después de comprender la verdadera naturaleza de tu realidad, decides unirte a la Resistencia,un grupo de rebeldes que luchan contra las máquinas y buscan liberar a la humanidad de su control”");

			sc.nextLine();

			vista.printCharacterDialogBox(ARTS.MORFEO, player.getName()
					+ ", tu primera misión es obtener tres objetos clave dentro de la Matrix para poder infiltrarte en las instalaciones de seguridad.");
			sc.nextLine();
			vista.getBorderedDialogue(
					"“Los objetos se encuentran en el DISTRITO INDUSTRIAL, el SECTOR RESIDENCIAL, y el NÚCLEO DE LA_CIUDAD...\"");

			game(player);
		}
	}

	// función para empezar las rondas
	public static void game(Player jugador) {
		TerminalView vista = new TerminalView();
		Scanner sc = new Scanner(System.in);
		boolean continuarJugando = true;

		while (continuarJugando) {

			Zone zone1 = new Zone("DISTRITO INDUSTRIAL", new ZoneItem("Disfraz de Técnico de Mantenimiento"));
			Zone zone2 = new Zone("SECTOR RESIDENCIAL", new ZoneItem("Dispositivo de Hacking Avanzado"));
			Zone zone3 = new Zone("NÚCLEO DE LA CIUDAD", new ZoneItem("Tarjeta de Acceso Nivel 5"));
			Zone zone4 = new Zone("INSTALACIÓN DE SEGURIDAD",
					new ZoneItem("Dispositivo de Desactivación de la Matrix"));

			zone1.generateEnemies(Distritos.DISTRITO_INDUSTRIAL, 2, jugador);
			zone2.generateEnemies(Distritos.SECTOR_RESIDENCIAL, 3, jugador);
			zone3.generateEnemies(Distritos.NÚCLEO_DE_LA_CIUDAD, 3, jugador);
			zone4.generateEnemies(Distritos.INSTALACIÓN_DE_SEGURIDAD, 4, jugador);

			// Agregar a Smith al final de cada zona
			zone1.generateSmith(Distritos.DISTRITO_INDUSTRIAL);
			zone2.generateSmith(Distritos.SECTOR_RESIDENCIAL);
			zone3.generateSmith(Distritos.NÚCLEO_DE_LA_CIUDAD);
			zone4.generateSmith(Distritos.INSTALACIÓN_DE_SEGURIDAD);

			vista.printZoneSelector();
			

			int selectZoneOption = sc.nextInt();

			Zone selectedZone = null;
			switch (selectZoneOption) {
			case 1:
				selectedZone = zone1;
				break;
			case 2:
				selectedZone = zone2;
				break;
			case 3:
				selectedZone = zone3;
				break;
			case 4:
			{
				if (jugador.getMissionItems().size() != 3) {
					vista.getBorderedDialogue(
							"Debes obtener los tres Objetos clave antes de infintrarte a las instalaciones de seguridad.");
				} else {
					selectedZone = zone4;
				}
			}
				
				break;
			case 5:
			{				
				jugador.seeMissionItems(jugador);
				sc.nextLine();
				sc.nextLine();
			}
				break;
			case 0:
			{
				continuarJugando = false;
				vista.printCharacterDialogBox(ARTS.HUNTER,
						"Has cedido ante el implacable dominio de la Matrix. ¿Volverás a desafiarla?");
			}
				
				break;
			default:
				vista.getBorderedDialogue("Opción inválida. Por favor, selecciona una opción válida.");
			}
			if (selectedZone != null) {
				vista.getBorderedDialogue("-" + selectedZone.getName() + "-");
				sc.nextLine();
				startBattle(jugador, selectedZone);

				// Verificar si el jugador ha obtenido los cuatro objetos clave
				if (jugador.getMissionItems().size() == 4) {
					System.out.println();
					vista.getBorderedDialogue("\n“La verdad finalmente ha sido revelada, y la libertad, alcanzada”\n");
					continuarJugando = false; // Terminar el juego
				}

			}
		}

		sc.close();
	}

	public static void startBattle(Player jugador, Zone zone) {

		boolean noEnemiesRemaining = false;
		int cont = 0;
		TerminalView vista = new TerminalView();
		Scanner sc = new Scanner(System.in);

		for (Agent currentAgent : zone.getAgents()) {
			Battle lucha = new Battle(jugador, currentAgent);// crea una batalla por cada agente
			if (currentAgent.getName().equals("Smith")) {
				Smith smith = (Smith) currentAgent;
				vista.printCharacterDialogBox(ARTS.SMITH, smith.SmithStartQuote(zone,jugador));
			} // imprimir una frase del señor smith antes de pelear

			while (jugador.getHealth() > 0 && currentAgent.getHealth() > 0) {
				if (currentAgent.getName().equals("Smith")) {
					vista.printFightVisualizer(jugador, currentAgent, ARTS.SMITH);
				} else {
					vista.printFightVisualizer(jugador, currentAgent);
				}
				int option = sc.nextInt();
				handleBattleOption(option, lucha, jugador, vista, currentAgent);
			}
			// Verificar si el jugador sigue con vida antes de imprimir las frases
			if (jugador.getHealth() > 0) {
				vista.printEnemyDropAndExp(currentAgent);
				if (currentAgent.getName().equals("Smith")) {
					Smith smith = (Smith) currentAgent;
					sc.nextLine();
					vista.printCharacterDialogBox(ARTS.SMITH, smith.SmithEndQuote(zone, jugador));
					sc.nextLine();
					vista.printCharacterDialogue(jugador.getName(), jugador.PlayerEndQuote(jugador, zone));
				} // imprimir una frase final del señor smith y el jugador después de pelear
			}
			cont++;
			handleEndBattle(cont, zone, jugador, vista, noEnemiesRemaining);
		}
	}

	
	private static void handleBattleOption(int option, Battle lucha, Player jugador, TerminalView vista, Agent agente) {
		switch (option) {
		case 1:
			// guarda en una variable el daño que va a causar ya que uede ser crítico
			int danoJugador = lucha.calculatePlayerDamage();

			vista.printPlayerAttack(jugador, danoJugador);
			lucha.fightTurn(danoJugador);
			if (agente.getHealth() > 0) {
				vista.printEnemyAttack(agente.getStrength());
			}
			break;
		case 2:
			menuUseItems(jugador);
			break;
		case 3:
			vista.printSeeCharacterMenu(jugador);
			jugador.useEXP(jugador);
			break;
		case 4:
			vista.getBorderedDialogue("Abandonastes la zona");
			game(jugador);
		case 5:
			vista.printCharacterDialogBox(ARTS.HUNTER,
					"Has cedido ante el implacable dominio de la Matrix. ¿Volverás a desafiarla?");
			System.exit(0);
			break;
		default:
			vista.getBorderedDialogue("Opción inválida. Por favor, selecciona una opción válida.");
		}
	}

	
	// funcion para usar los items
	public static void menuUseItems(Player player) {
		Scanner sc = new Scanner(System.in);
		TerminalView vista = new TerminalView();
		ArrayList<Item> playerItems = player.getItems();
		int choice = -1;
		vista.printCharacterName("Elige un ítem para usar:");
		vista.printSeePlayerItems(player);
		choice = sc.nextInt();
		if (choice >= 1 && choice <= playerItems.size()) {
			Item selected = playerItems.get(choice - 1);
			// Usar el ítem seleccionado
			vista.getBorderedDialogue(player.useItem(player, selected));
		} else if (choice != 0) {
			vista.printCharacterName("Selección inválida.");
		}
		if (choice == 0) {
			// Salir del método
			return;
		}
	}

	
	public static void handleEndBattle(int cont, Zone zone, Player jugador, TerminalView vista,
			boolean noEnemiesRemaining) {
		Scanner sc = new Scanner(System.in);

		if (jugador.getHealth() <= 0) {
			vista.printCharacterDialogBox(ARTS.HUNTER,
					"Has cedido ante el implacable dominio de la Matrix. ¿Volverás a desafiarla?");
			System.exit(0); // Salir completamente del programa
		}
		// 50% de que aparezca un dron
		int droneProbAparition = (int) (Math.random() * 10) + 1;
		if (cont < zone.getAgents().size()) {
			if (droneProbAparition < 10) {
				Dron dron = new Dron();
				dron = dron.generateDron(jugador, zone);
				dron.stealExperience(jugador, dron.getStealExp(), dron);

				vista.printDronAparition(dron);

			}
			vista.printEndBattle(noEnemiesRemaining);
			sc.nextLine();
		} else {
			noEnemiesRemaining = true;
			vista.printEndBattle(noEnemiesRemaining);
			sc.nextLine();

			// cuando limpie la zona, se le agregará el item de la misión
			handleMissionItemAssignment(jugador, zone);
		}
	}

	
	private static void handleMissionItemAssignment(Player jugador, Zone zone) {
		TerminalView vista = new TerminalView();
		// Verificar primero si el jugador ya tiene el ítem de misión en su lista
		boolean containsItem = false;
		for (ZoneItem item : jugador.getMissionItems()) {
			if (item.getName().equals(zone.getMissionItem().getName())) {
				containsItem = true;
			}
		}
		// Si el ítem no está en la lista, agrégalo
		if (!containsItem) {
			jugador.setMissionItems(zone.getMissionItem());
			vista.printZoneItemDrop(zone);
		}
	}
}
