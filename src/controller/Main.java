package controller;

import model.*;
import static model.Zone.*;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		
		
		Player jugador= new Player();
		System.out.println(jugador.toString());
		

	
		Zone zone1 = new Zone("DISTRITO INDUSTRIAL");
		Zone zone2 = new Zone("SECTOR RESIDENCIAL");

		zone1.generateEnemys(Distritos.DISTRITO_INDUSTRIAL,6);
		zone1.verZona();
		
		Battle lucha= new Battle();
		lucha.menuBattle();
		for(int i=0;i<zone1.getAgents().size();i++) {
			int option;
			//que me siga preguntando que hacer mientars que el enemigo o jugador sigan vivos
			while(jugador.getHealth()>0 && zone1.getAgents().get(i).getHealth()>0) {
				option=sc.nextInt();
				lucha.battleOptions(option,jugador, zone1.getAgents().get(i));
			}
			
		}
		
		
	}

}
