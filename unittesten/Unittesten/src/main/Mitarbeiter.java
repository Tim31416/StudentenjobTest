package main;

import java.util.UUID;

public class Mitarbeiter {

	final private String id = UUID.randomUUID().toString();
	private String name;

	/**
	 * Erstellt einen neuen Mitarbeiter mit dem angegebenen Namen.
	 *
	 * @param name: Der Name des Mitarbeiters. Darf nicht "null" oder leer sein.
	 * @throws IllegalArgumentException Wenn der Name null oder leer ist.
	 */

	public Mitarbeiter(String name) {
		setName(name);
	}

	/**
	 * Gibt die eindeutige ID des Mitarbeiters zurück.
	 *
	 * @return Die eindeutige ID des Mitarbeiters.
	 */

	public String getID() {
		return id;
	}

	/**
	 * Gibt den Namen des Mitarbeiters zurück.
	 *
	 * @return Der Name des Mitarbeiters.
	 */

	public String getName() {
		return name;
	}

	/**
	 * Setzt den Namen des Mitarbeiters nach der Validierung.
	 *
	 * @param name: Der Name des Mitarbeiters. Darf nicht "null" oder leer sein.
	 * @throws IllegalArgumentException Wenn der Name null oder leer ist.
	 */

	public void setName(String name) {
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException("Keinen Namen angegeben.");
		} else {
			this.name = name;
		}
	}
}
