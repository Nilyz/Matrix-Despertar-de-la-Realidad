package controller;

import model.*;
import static model.Zone.*;

public class Main {
	public static void main(String[] args) {
		
		
		
		Player jugador= new Player();
		System.out.println(jugador.toString());
		

	
		Zone zone1 = new Zone("DISTRITO INDUSTRIAL");
		Zone zone2 = new Zone("SECTOR RESIDENCIAL");

		zone1.generateEnemys(Distritos.DISTRITO_INDUSTRIAL,6);
		zone1.verZona();
		
		Battle lucha= new Battle();
		lucha.fight(jugador, zone1.getAgents().get(0));
		
	
	}

}
