package controller;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

import model.Zone.Distritos;
import view.TerminalView;
import view.RepositoryASCII.ARTS;

public class Juego {

	// función para seleccionar personaje
	public static void startGame() {
		TerminalView vista = new TerminalView();
		Scanner sc = new Scanner(System.in);
		Player neo = new Player();
		Player personalized = new Player("", 0, 0, 0, 0, 65);

		System.out
				.println("╔═══════════════════════════════════════════════════════════════════════════════════════╗\r\n"
						+ "║                                                                                       ║\r\n"
						+ "║      _____         _                           _                        _             ║\r\n"
						+ "║     | ____| _ __  | |_  _ __  __ _  _ __    __| |  ___        __ _     | |  __ _      ║\r\n"
						+ "║     |  _|  | '_ \\ | __|| '__|/ _` || '_ \\  / _` | / _ \\      / _` |    | | / _` |     ║\r\n"
						+ "║     | |___ | | | || |_ | |  | (_| || | | || (_| || (_) |    | (_| |    | || (_| |     ║\r\n"
						+ "║     |_____||_| |_| \\__||_|   \\__,_||_| |_| \\__,_| \\___/      \\__,_|    |_| \\__,_|     ║\r\n"
						+ "║     |  \\/  |  __ _ | |_  _ __ (_)__  __                                               ║\r\n"
						+ "║     | |\\/| | / _` || __|| '__|| |\\ \\/ /                                               ║\r\n"
						+ "║     | |  | || (_| || |_ | |   | | >  <  _  _  _                                       ║\r\n"
						+ "║     |_|  |_| \\__,_| \\__||_|   |_|/_/\\_\\(_)(_)(_)                                      ║\r\n"
						+ "║                                                                                       ║\r\n"
						+ "╚═══════════════════════════════════════════════════════════════════════════════════════╝");

		System.out.println("Eres...");
		System.out.println("<1> Neo");
		System.out.println("<2> Otro");
		int playerOption = sc.nextInt();
		while (playerOption != 1 && playerOption != 2) {
			System.out.println("opción inválida, vuelva a intentar");
			System.out.println("Eres...");
			System.out.println("<1> Neo");
			System.out.println("<2> Personalizar");
			playerOption = sc.nextInt();
		}

		sc.nextLine();
		if (playerOption == 1) {
			firstDialog(neo.getName(), neo);

		} else {
			System.out.println("Por favor, introduce tu nombre:");
			personalized.setName(sc.nextLine());
			System.out.println("Has recibido 65 puntos de experiencia para distribuir.");
			do {
				vista.printSeeCharacterMenu(personalized);
				personalized.useEXP(personalized);
			} while (personalized.getExperience() > 0);

			firstDialog(personalized.getName(), personalized);

		}

	}

	public static void firstDialog(String name, Player player) {
		Scanner sc = new Scanner(System.in);
		TerminalView vista = new TerminalView();
		String enter; // solo sirve para hacer enter para que aparezca el siguiente texto

		vista.getBorderedDialogue("Despiertas en tu apartamento, como en un día cualquiera.Sin embargo, algo está fuera de lugar… Luces parpadeantes y distorsiones en la realidad te hacen cuestionar tu entorno.De repente, un mensaje aparece en tu pantalla:");
		
		enter = sc.nextLine();

		vista.getBorderedDialogue( "Despierta " + name + "...█");

		enter = sc.nextLine();

		vista.getBorderedDialogue(
				"De repente, una fuerza invisible te envuelve y te transporta a un lugar desconocido. Te encuentras en una habitación bien iluminada, con una figura misteriosa esperándote…");

		enter = sc.nextLine();

		vista.printCharacterDialogue("Morfeo",
				"Hola " + name + ", como te habrás dado cuenta, las cosas no son lo que parecen.");
		enter = sc.nextLine();

		vista.printCharacterDialogue("Morfeo", "Tengo aquí dos pastillas: una roja y una azul."
				+ "\"La pastilla roja te abrirá los ojos y te mostrará la verdad, sin filtros ni ilusiones."
				+ "La pastilla azul te devolverá a tu vida normal, donde podrás seguir creyendo lo que quieras creer."
				+ "La elección es tuya. ¿Qué pastilla tomarás?");

		System.out.println("<1> Tomar pastilla Roja");
		System.out.println("<2> Tomar pastilla Azul");
		int option;
		option = sc.nextInt();
		if (option == 2) {
			System.out.println("Tomaste la pastilla azul y has decidido seguir viviendo en la ilusión..");
			System.out.println("¿Pero cuánto tiempo podrás resistir la curiosidad de conocer la verdad?");
		} else {
			vista.getBorderedDialogue(
					"Tomaste la pastilla roja y has decidido despertar de la ilusión.");
			sc.nextLine();
			enter = sc.nextLine();
			vista.printCharacterDialogue("Morfeo",
					"Has elegido sabiamente, Neo. Ahora que has despertado, te revelaré la verdad sobre la Matrix");
			enter = sc.nextLine();

			vista.getBorderedDialogue(
					"“Morfeo te revela la verdad sobre el mundo en el que vives: Todo es una simulación creada por máquinas que han esclavizado a la humanidad..”");
			enter = sc.nextLine();
			vista.getBorderedDialogue(
					"“Después de comprender la verdadera naturaleza de tu realidad, decides unirte a la Resistencia,un grupo de rebeldes que luchan contra las máquinas y buscan liberar a la humanidad de su control”");

			enter = sc.nextLine();

			vista.printCharacterDialogue("Morfeo", name
					+ " , tu primera misión es obtener tres objetos clave dentro de la Matrix para poder infiltrarte en las instalaciones de seguridad.");
			enter = sc.nextLine();
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

			/* fondo negro */vista.printZoneSelector();
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
				if (jugador.getMissionItems().size() != 3) {
					/* fondo negro */vista.printCharacterDialogue("",
							"Debes obtener los tres Objetos clave antes de infintrarte a las instalaciones de seguridad.");
				} else {
					selectedZone = zone4;
				}
				break;
			case 5:
				jugador.seeMissionItens();
				break;
			case 0:
				continuarJugando = false;
				/* fondo negro */System.out.println("Abandonastes la partida...");
				/* fondo negro */vista.printCharacterDialogue("", vista.printGiveUp());
				break;
			default:
				/* fondo negro */vista.printCharacterDialogue("",
						"Opción inválida. Por favor, selecciona una opción válida.");
			}
			if (selectedZone != null) {
				vista.printCharacterName("-" + selectedZone.getName() + "-");
				startBattle(jugador, selectedZone);

				// Verificar si el jugador ha obtenido los cuatro objetos clave
				if (jugador.getMissionItems().size() == 4) {
					vista.printCharacterDialogue("",
							" “La verdad finalmente ha sido revelada, y la libertad, alcanzada”");
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
				String smithStartQuote = smith.SmithStartQuote(zone);
				vista.printCharacterDialogue("Agente Smith", smithStartQuote);
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
				vista.getBorderedDialogue(vista.printEnemyDropAndExp(currentAgent));
				if (currentAgent.getName().equals("Smith")) {
					Smith smith = (Smith) currentAgent;
					String smithEndQuote = smith.SmithEndQuote(zone);
					String palyerEndQuote = jugador.PlayerEndQuote(jugador, zone);
					vista.printCharacterDialogue("Agente Smith", smithEndQuote);
					vista.printCharacterDialogue(jugador.getName(), palyerEndQuote);
				} // imprimir una frase final del señor smith y el jugador después de pelear
			}

			cont++;
			handleEndBattle(cont, zone, jugador, vista, noEnemiesRemaining);

		}
	}

	private static void handleBattleOption(int option, Battle lucha, Player jugador, TerminalView vista, Agent agente) {
		switch (option) {
		case 1:
			//guarda en una variable el daño que va a causar ya que uede ser crítico
			int danoJugador = lucha.calculatePlayerDamage();
			System.out.println("Daño del jugador " + danoJugador);
			lucha.printEnemyHealth(agente.getHealth());
			lucha.fightTurn(danoJugador);
			if (agente.getHealth() > 0) {
				System.out.println("Daño del enemigo " + agente.getStrength());
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
			vista.getBorderedDialogue( "Abandonastes la zona");
			game(jugador);
		case 5:
			vista.printCharacterDialogue("", vista.printGiveUp());
			System.exit(0); // Salir completamente del programa
			break;
		default:
			System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
		}
	}

	// funcion para usar los items
	public static void menuUseItems(Player player) {
		Scanner sc = new Scanner(System.in);
		TerminalView vista = new TerminalView();
		ArrayList<Item> playerItems = player.getItems();
		int choice = -1;
		/* negro */vista.printCharacterName("Elige un ítem para usar:");

		if (!playerItems.isEmpty()) {
			while (choice != 0) {
				// Mostrar los ítems disponibles
				// System.out.println(player.seePlayerItems()); esto es lo mismo que lo de vista
				vista.seePlayerItems(player);
				System.out.println("<0> Salir");

				choice = sc.nextInt();
				if (choice >= 1 && choice <= playerItems.size()) {
					Item selected = playerItems.get(choice - 1);
					// Usar el ítem seleccionado
					/*fondo negro*/vista.printCharacterDialogue("", player.useItem(player, selected));
					/* negro */vista.printCharacterName("Elige un ítem para usar:");
				} else if (choice != 0) {
					vista.printCharacterName("Selección inválida.");
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

	public static void handleEndBattle(int cont, Zone zone, Player jugador, TerminalView vista,
			boolean noEnemiesRemaining) {
		if (jugador.getHealth() <= 0) {
			vista.printCharacterDialogue("", vista.printGiveUp());
			System.exit(0); // Salir completamente del programa
		}
		// 50% de que aparezca un dron
		int droneProbAparition = (int) (Math.random() * 10) + 1;
		if (cont < zone.getAgents().size()) {
			if (droneProbAparition < 10) {
				Dron dron = new Dron();
				dron = dron.generateDron(jugador, zone);
				dron.stealExperience(jugador, dron.getStealExp(), dron);
				vista.printCharacterDialogue("", dron.dronAparitionString(dron));
				
			}
			vista.printEndBattle(noEnemiesRemaining);
		} else {
			noEnemiesRemaining = true;
			vista.printEndBattle(noEnemiesRemaining);

			// cuando limpie la zona, se le agregará el item de la misión
			handleMissionItemAssignment(jugador, zone);
		}
	}

	private static void handleMissionItemAssignment(Player jugador, Zone zone) {
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
			System.out.println("Agregando ítem de misión: " + zone.getMissionItem().getName());
		}
	}
}
