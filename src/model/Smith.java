package model;

import model.Zone.Distritos;

public class Smith extends Agent {

	int level;

	public Smith(String name, int maxHealth, int strength, int energy, int experience, int aparitionProbability, int level) {
		super(name, maxHealth, strength, energy, experience, aparitionProbability);
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public String printSmithQuote( Zone zone) {
	    if (name.equals("Smith")) {
	        if (zone.getName().equals("DISTRITO INDUSTRIAL")) {
	            return "Smith en el DISTRITO INDUSTRIAL: \"La humanidad es una plaga, Mr. Anderson, y nosotros somos la cura.\"";
	        } else if (zone.getName().equals("SECTOR RESIDENCIAL")) {
	            return "Smith en el SECTOR RESIDENCIAL: \"¿Has oído eso, Mr. Anderson? Es el sonido de la inevitabilidad. Es el sonido de tu muerte.\"";
	        } else if (zone.getName().equals("NÚCLEO DE LA CIUDAD")) {
	            return "Smith en el NÚCLEO DE LA CIUDAD: \"No, Mr. Anderson. Es la libertad la que ha fallado. La humanidad es un desastre, una plaga.\"";
	        } else if (zone.getName().equals("INSTALACIÓN DE SEGURIDAD")) {
	            return "Smith en la INSTALACIÓN DE SEGURIDAD: \"¿Por qué, Sr. Anderson? ¿Por qué? ¿Por qué, por qué, por qué hacemos esto? ¿Por qué seguimos luchando? ¿Sabes por qué estamos aquí? ¿Te has preguntado alguna vez?\"";
	        } else {
	            return "Smith está presente en una zona desconocida.";
	        }
	    } else {
	        return "";
	    }
	}
}
