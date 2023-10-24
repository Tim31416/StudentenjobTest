package main;

public class Bestellposten {
	private String artikelID;
	private int anzahl;

	/**
	 * Erzeugt einen neuen Bestellposten mit der angegebenen Artikel-ID und Anzahl.
	 *
	 * @param artikelID: Die Artikel-ID des Bestellpostens.
	 * @param anzahl:    Die Anzahl der Artikel in diesem Posten.
	 * @throws IllegalArgumentException Wenn die Artikel-ID null oder leer ist oder
	 *                                  wenn die Anzahl negativ ist.
	 */

	public Bestellposten(String artikelID, int anzahl) {
		setArtikelID(artikelID);
		setAnzahl(anzahl);
	}

	/**
	 * Gibt die Artikel-ID dieses Bestellpostens zurück.
	 *
	 * @return Die Artikel-ID dieses Bestellpostens.
	 */

	public String getArtikelID() {
		return artikelID;
	}

	/**
	 * Setzt die Artikel-ID dieses Bestellpostens.
	 *
	 * @param artikelID Die Artikel-ID, die gesetzt werden soll.
	 * @throws IllegalArgumentException Wenn die übergebene Artikel-ID "null" oder
	 *                                  leer ist.
	 */

	public void setArtikelID(String artikelID) {
		if (artikelID == null || artikelID.trim().length() == 0) {
			throw new IllegalArgumentException("Die ArtikelID darf nicht null sein.");
		} else {
			this.artikelID = artikelID;
		}
	}

	/**
	 * Gibt die Anzahl der Artikel dieses Bestellpostens zurück.
	 *
	 * @return Die Anzahl der Artikel dieses Bestellpostens.
	 */

	public int getAnzahl() {
		return anzahl;
	}

	/**
	 * Setzt die Anzahl der Artikel dieses Bestellpostens.
	 *
	 * @param anzahl: Die Anzahl, die gesetzt werden soll.
	 * @throws IllegalArgumentException Wenn die übergebene Anzahl negativ ist.
	 */

	public void setAnzahl(int anzahl) {
		if (anzahl < 0) {
			throw new IllegalArgumentException("Die Anzahl darf nicht negativ sein.");
		} else {
			this.anzahl = anzahl;
		}
	}
}
