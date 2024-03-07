package controller;

import model.*;
import static model.Zone.*;
import view.*;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		TerminalView vista = new TerminalView();
		Scanner sc = new Scanner(System.in);

		Player jugador = new Player();
		/*// Mis pruebas:
		System.out.println(getCharacterWithTextBox(ARTS.NEO, "probando a esfsdfewf asadf e sdf ae fdsaf ewaf adsf aewf ads aewf adsf ewqr ewrewqreasf ewqfdasd asdfewfdsaf", 20));
		vista.printFightOptions();
		int width = 80;

		System.out.println("Prueba: \n \n");

		String neoArtWithoutLineJump = neoArt.replace("\r\n", "");
		System.out.println(getBinaryTextBox(neoArtWithoutLineJump, 29));
		System.out.println(getBinaryTextBox(neoArtCopy, 29));
		System.out.println(getBinaryTextBox(neoArtCopy.replace("\r\n", "").replace("\n", ""), 27));

		for (int i = 0; i < 10; i++) {
			System.out.println(getRandomBinary());
		}

		System.out.println(DialogueMenu.getFormattedDialogue("Neo", "Ey this is a text of test: texst", width));
		System.out.println(DialogueMenu.getFormattedDialogue("", "Ey this is a text of test: texst, getFormatted CharacterName, getFormatted CharacterName, getFormatted CharacterName, Ey this is a text of test: texst", width));
		String[] prueba = {"Texto de prueba", "Ey this is a text of test: texst", "Ey this is a text of test: texst, getFormatted CharacterName, getFormatted CharacterName, getFormatted CharacterName, Ey this is a text of test: texst", Menu.BLUE + "PRUEBA" };
		System.out.println(Menu.getBinaryTextBox(prueba, width));	
		String[] prueba2 = {"Ey this is a text of test: texst", "Ey this is a text of test: texst, getFormatted CharacterName, getFormatted CharacterName, getFormatted CharacterName, Ey thiss is a text of test: texst"};
		System.out.println(Menu.getBinaryTextBox(prueba2, width, true));	
		*/
		
		System.out.println(jugador.toString());

		Zone zone1 = new Zone("DISTRITO INDUSTRIAL");
		Zone zone2 = new Zone("SECTOR RESIDENCIAL");

		zone1.generateEnemies(Distritos.DISTRITO_INDUSTRIAL, 6);
		zone1.verZona();

		Battle lucha = new Battle();

		/*RepositoryASCII imagen= new RepositoryASCII();
		System.out.println(imagen.neoArt);
		System.out.println(imagen.srSmith);*/

		
		for (Agent currentAgent : zone1.getAgents()) {
			//lucha.menuBattle();
			vista.printFightOptions();
			int option;
			// que me siga preguntando que hacer mientras que el enemigo y jugador sigan vivos
			while (jugador.getHealth() > 0 && currentAgent.getHealth() > 0) {
				option = sc.nextInt();
				vista.printCharacterDialogue("negro", "hola");
				vista.printFightVisualizer(jugador, currentAgent);
				lucha.battleOptions(option, jugador, currentAgent);
				// lucha.menuBattle();
			}
			
			
			System.out.println(jugador.toString());
			System.out.println("\nPasando al siguiente agente...");

		}
		
		sc.close();
		
	}

}
