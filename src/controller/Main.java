package controller;

import model.*;

public class Main {
	public static void main(String[] args) {

		/*Enemigos*/
		
		//Distrito industrial
		Agent robotsSeguridad = new Agent("Robots de seguridad", 0, 0, 0, 0, 0, 40);
		Agent obreroDigital = new Agent("Obreros digitales", 0, 4, 0, 0, 6, 20);
		
		//sector residencial
		Agent agSistema = new Agent("Agentes del sistema", 0, 0, 0, 0, 0, 40);
		Agent ilusionista = new Agent("Ilusionistas", 0, 4, 0, 0, 6, 20);
		Agent guardiasElite = new Agent("Guardias de élite", 0, 4, 0, 0, 6, 20);
		
		//Nucleo de ciudad
		Agent seguridadAvanzada = new Agent("Programas de seguridad avanzados", 0, 0, 0, 0, 0, 40);
		Agent corruptos = new Agent("Entidades de corrupción", 0, 4, 0, 0, 6, 20);
		Agent agEspecial = new Agent("Agentes especiales", 0, 4, 0, 0, 6, 20);
		
		//programas de defensa
		Agent torretas = new Agent("Torretas de defensa", 0, 4, 0, 0, 6, 20);
		Agent jefeSeguridad = new Agent("Jefes de seguridad:", 0, 4, 0, 0, 6, 20);
		Agent agÉlite = new Agent("Agentes de élite", 0, 4, 0, 0, 6, 20);
		
		
		
		/*items*/
		Item newItem = new Item("Strength Belt", 5, 0, 0);
		Item newItem2 = new Item("Enhancement Chips", 0, 10, 0);
		Item newItem3 = new Item("Speed Boots", 0, 0, 2);
		Item newItem4 = new Item("Training Book", 0, 0, 8);

		
		//ag1.addDroppableItem(newItem);


		Zone zone1 = new Zone("DISTRITO INDUSTRIAL");
		Zone zone2 = new Zone("SECTOR RESIDENCIAL");
		Zone zone3 = new Zone("NÚCLEO DE LA CIUDAD");
		Zone zone4 = new Zone("INSTALACIÓN DE SEGURIDAD");
		
		zone1.generateEnemys("DISTRITO INDUSTRIAL",4);
		zone1.verZona();
	}

}
