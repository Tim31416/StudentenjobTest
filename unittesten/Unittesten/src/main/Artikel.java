package main;

public class Artikel {

	private String id;
	private String name;
	private String beschreibung;

	/**
	 * Erstellt eine neue Instanz der Klasse Artikel mit den angegebenen Werten für
	 * id, name und beschreibung.
	 *
	 * @param id:           Die eindeutige ID des Artikels.
	 * @param name:         Der Name des Artikels.
	 * @param beschreibung: Die Beschreibung des Artikels.
	 * @throws IllegalArgumentException Wenn eine der bereitgestellten Eigenschaften
	 *                                  "null" oder leer ist.
	 */

	public Artikel(String id, String name, String beschreibung) {
		setID(id);
		setName(name);
		setBeschreibung(beschreibung);
	}

	/**
	 * Gibt die ID des Artikels zurück.
	 *
	 * @return Die ID des Artikels.
	 */

	public String getID() {
		return id;
	}

	/**
	 * Setzt die ID des Artikels auf den angegebenen Wert, sofern dieser nicht
	 * "null" oder leer ist.
	 *
	 * @param id: Die neue ID für den Artikel.
	 * @throws IllegalArgumentException Wenn die bereitgestellte ID "null" oder leer
	 *                                  ist.
	 */

	public void setID(String id) {
		if (id == null || id.trim().length() == 0) {
			throw new IllegalArgumentException("Keine gültige ID angegeben.");
		} else {
			this.id = id;
		}
	}

	/**
	 * Gibt den Namen des Artikels zurück.
	 *
	 * @return Der Name des Artikels.
	 */

	public String getName() {
		return name;
	}

	/**
	 * Setzt den Namen des Artikels auf den angegebenen Wert, sofern dieser nicht
	 * "null" oder leer ist.
	 *
	 * @param name: Der neue Name für den Artikel.
	 * @throws IllegalArgumentException Wenn der bereitgestellte Name "null" oder
	 *                                  leer ist.
	 */

	public void setName(String name) {
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException("Kein gültiger Namen angegeben.");
		} else {
			this.name = name;
		}
	}

	/**
	 * Gibt die Beschreibung des Artikels zurück.
	 *
	 * @return Die Beschreibung des Artikels.
	 */

	public String getBeschreibung() {
		return beschreibung;
	}

	/**
	 * Setzt die Beschreibung des Artikels auf den angegebenen Wert, sofern dieser
	 * nicht "null" oder leer ist.
	 *
	 * @param beschreibung: Die neue Beschreibung für den Artikel.
	 * @throws IllegalArgumentException Wenn die bereitgestellte Beschreibung "null"
	 *                                  oder leer ist.
	 */

	public void setBeschreibung(String beschreibung) {
		if (beschreibung == null || beschreibung.trim().length() == 0) {
			throw new IllegalArgumentException("Keine gültige Beschreibung angegeben.");
		} else {
			this.beschreibung = beschreibung;
		}
	}
}
