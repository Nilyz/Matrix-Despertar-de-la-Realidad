package controller;

import model.*;
import static model.Zone.*;

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
		Item newItem5 = new Item("Energía eléctrica", 0, 0, 8);
		Item newItem6 = new Item("Training Book", 0, 0, 8);
		Item newItem7 = new Item("Mejoras cibernéticas", 0, 0, 8);
		Item newItem8 = new Item("Suministros médicos", 0, 0, 8);
		Item newItem9 = new Item("Mejoras de combate", 0, 0, 8);
		Item newItem10 = new Item("Mejoras genéticas", 0, 0, 8);
		Item newItem11 = new Item("Traje de vestir elegante", 0, 0, 8);
		Item newItem12 = new Item("Disfraz de civil", 0, 0, 8);
		Item newItem13 = new Item("Mochila de supervivencia", 0, 0, 8);
		Item newItem14 = new Item("Armas de alta tecnología", 0, 0, 8);
		Item newItem15 = new Item("Botas de acer", 0, 0, 8);
		//ag1.addDroppableItem(newItem);


	String itemList[]= {"newItem","newItem2","newItem3","newItem4","newItem5","newItem6","newItem7","newItem8","newItem9","newItem10","newItem11","newItem12","newItem13","newItem14","newItem15"};
		Zone zone1 = new Zone("DISTRITO INDUSTRIAL");
		Zone zone2 = new Zone("SECTOR RESIDENCIAL");

		zone1.generateEnemys(Distritos.DISTRITO_INDUSTRIAL,6);
		zone1.verZona();
		
	}

}
