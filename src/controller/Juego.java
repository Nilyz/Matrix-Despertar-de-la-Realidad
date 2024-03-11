package controller;

import model.*;
import java.util.Scanner;

import model.Agent;
import model.Battle;
import model.Player;
import model.Zone;
import model.Zone.Distritos;
import view.TerminalView;

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

		System.out.println("Despiertas en tu apartamento, como en un día cualquiera.\r\n"
				+ "Sin embargo, algo está fuera de lugar…\r\n"
				+ "Luces parpadeantes y distorsiones en la realidad te hacen cuestionar tu entorno.\r\n"
				+ "De repente, un mensaje aparece en tu pantalla:\r\n" + "");

		System.out.println("Despierta " + name + "...█");
		enter = sc.nextLine();

		System.out.println("De repente, una fuerza invisible te envuelve y te transporta a un lugar desconocido.\r\n"
				+ "Te encuentras en una habitación bien iluminada, con una figura misteriosa esperándote…\r\n" + "");
		enter = sc.nextLine();

		vista.printCharacterDialogue("Morfeo",
				"Hola " + name + ", como te habrás dado cuenta, las cosas no son lo que parecen.");
		enter = sc.nextLine();

		vista.printCharacterDialogue("Morfeo", "\"Tengo aquí dos pastillas: una roja y una azul."
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
			System.out.println("Tomaste la pastilla roja y has decidido despertar de la ilusión.");
			enter = sc.nextLine();

			vista.printCharacterDialogue("Morfeo",
					"Has elegido sabiamente, Neo. Ahora que has despertado, te revelaré la verdad sobre la Matrix");
			enter = sc.nextLine();

			System.out.println(
					"“Morfeo te revela la verdad sobre el mundo en el que vives:\n todo es una simulación creada por máquinas que han esclavizado a la humanidad..”");
			System.out.println(
					"“Después de comprender la verdadera naturaleza de tu realidad, decides unirte a la Resistencia,\nun grupo de rebeldes que luchan contra las máquinas y buscan liberar a la humanidad de su control”");
			enter = sc.nextLine();

			vista.printCharacterDialogue("Morfeo", name
					+ " , tu primera misión es obtener tres objetos clave dentro de la Matrix para poder infiltrarse en las instalaciones de seguridad.");
			System.out.println(
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
				if (jugador.getMissionItems().size() != 3) {
					System.out.println(
							"Debes obtener los tres ítems clave antes de acceder a las instalaciones de seguridad.");
				} else {
					selectedZone = zone4;
				}
				break;
			case 5:
				jugador.seeMissionItens();
				break;
			case 0:
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

			vista.printStartBattle(currentAgent);
			;

			while (jugador.getHealth() > 0 && currentAgent.getHealth() > 0) {
				vista.printFightVisualizer(jugador, currentAgent);
				int option = sc.nextInt();
				handleBattleOption(option, lucha, jugador, vista);

			}

			vista.printEnemyDrop(currentAgent);
			if (currentAgent.getName().equals("Smith")) {
				Smith smith = (Smith) currentAgent;
				String smithEndQuote = smith.SmithEndQuote(zone);
				String palyerEndQuote = jugador.PlayerEndQuote(jugador, zone);
				vista.printCharacterDialogue("Agente Smith", smithEndQuote);
				vista.printCharacterDialogue(jugador.getName(), palyerEndQuote);

			} // imprimir una frase del señor smith y el jugador despues de pelear

			cont++;
			handleEndBattle(cont, zone, jugador, vista, noEnemiesRemaining);

		}
	}

	private static void handleBattleOption(int option, Battle lucha, Player jugador, TerminalView vista) {
		switch (option) {
		case 1:
			lucha.fightTurn();
			break;
		case 2:
			jugador.menuUseItems(jugador);
			break;
		case 3:
			vista.printSeeCharacterMenu(jugador);
			System.out.println("<0> Salir");
			jugador.useEXP(jugador);
			break;
		case 4:
			System.out.println("Abandonastes la zona");
			game(jugador);
		case 5:
			vista.printGiveUp();
			System.exit(0); // Salir completamente del programa
			break;
		default:
			System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
		}
	}

	private static void handleEndBattle(int cont, Zone zone, Player jugador, TerminalView vista,
			boolean noEnemiesRemaining) {
		if (jugador.getHealth() <= 0) {
			System.out.println("Has perdido toda tu vida. ¡Game Over!");
			System.exit(0); // Salir completamente del programa
		}
		int droneProbAparition = (int) (Math.random() * 10) + 1;
		if (cont < zone.getAgents().size()) {
			if (droneProbAparition < 6) {
				Dron dron = new Dron();
				dron = dron.generateDron(jugador, zone);
				dron.stealExperience(jugador, dron.getStealExp(), dron);
			}
			vista.printEndBattle(noEnemiesRemaining);
		} else {
			noEnemiesRemaining = true;
			vista.printEndBattle(noEnemiesRemaining);
			// cuando limpie la zona, se le agregará el item de la misión

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
}
