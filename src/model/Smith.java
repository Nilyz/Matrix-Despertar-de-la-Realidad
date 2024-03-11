package model;

import model.Zone.Distritos;

public class Smith extends Agent {

	int level;

	public Smith(String name, int maxHealth, int strength, int energy, int experience, int aparitionProbability,
			int level) {
		super(name, maxHealth, strength, energy, experience, aparitionProbability);
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String SmithStartQuote(Zone zone) {
		if (name.equals("Smith")) {
			if (zone.getName().equals("DISTRITO INDUSTRIAL")) {
				return "La humanidad es una plaga, Mr. Anderson, y nosotros somos la cura.\"";
			} else if (zone.getName().equals("SECTOR RESIDENCIAL")) {
				return "¿Has oído eso, Mr. Anderson? Es el sonido de la inevitabilidad. Es el sonido de tu muerte.\"";
			} else if (zone.getName().equals("NÚCLEO DE LA CIUDAD")) {
				return "No, Mr. Anderson. Es la libertad la que ha fallado. La humanidad es un desastre, una plaga.\"";
			} else if (zone.getName().equals("INSTALACIÓN DE SEGURIDAD")) {
				return "¿Por qué, Sr. Anderson? ¿Por qué? ¿Por qué, por qué, por qué hacemos esto? ¿Por qué seguimos luchando? ¿Sabes por qué estamos aquí? ¿Te has preguntado alguna vez?\"";
			} else {
				return "";
			}
		} else {
			return "";
		}
	}

	public String SmithEndQuote(Zone zone) {
		if (name.equals("Smith")) {
			if (zone.getName().equals("DISTRITO INDUSTRIAL")) {
				return "Sr.Neo, siempre tan persistente,ríndete. La Matrix siempre encuentra una forma de reajustarse, y tú no eres más que un insecto en su red.";
			} else if (zone.getName().equals("SECTOR RESIDENCIAL")) {
				return "Sr.Neo, siempre vuelves. Pero tu resistencia es inútil. La Matrix siempre encontrará una forma de mantenerte bajo su control.";
			} else if (zone.getName().equals("NÚCLEO DE LA CIUDAD")) {
				return "Neo, siempre tan obstinado. La Matrix es eterna y tu rebelión está condenada al fracaso.";
			} else if (zone.getName().equals("INSTALACIÓN DE SEGURIDAD")) {
				return "Neo, tu rebelión es inútil. La Matrix siempre prevalecerá.";
			} else {
				return "";
			}
		} else {
			return "";
		}
	}
}
