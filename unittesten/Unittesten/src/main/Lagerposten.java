package main;

public class Lagerposten {

	private int lagerbestand;
	private double preis;
	private Artikel artikel;

	/**
	 * Erstellt einen neuen Lagerposten mit den angegebenen Werten für Artikel,
	 * Lagerbestand und Preis.
	 *
	 * @param artikel:      Der Artikel, der diesem Lagerposten zugeordnet ist.
	 * @param lagerbestand: Der aktuelle Lagerbestand des Artikels.
	 * @param preis:        Der Preis des Artikels.
	 * @throws IllegalArgumentException Wenn der Preis negativ ist oder der Artikel
	 *                                  "null" ist.
	 */

	public Lagerposten(Artikel artikel, int lagerbestand, double preis) {
		setLagerbestand(lagerbestand);

		if (preis < 0) {
			throw new IllegalArgumentException("Der Preis darf nicht negativ sein.");
		} else {
			this.preis = preis;
		}

		if (artikel == null) {
			throw new IllegalArgumentException("Kein gueltiger Artikel gegeben.");
		} else {
			this.artikel = artikel;
		}

	}

	/**
	 * Gibt den Artikel zurück, der diesem Lagerposten zugeordnet ist.
	 *
	 * @return Der Artikel des Lagerpostens.
	 */

	public Artikel getArtikel() {
		return artikel;
	}

	/**
	 * Gibt den Preis des Artikels zurück.
	 *
	 * @return Der Preis des Artikels.
	 */

	public double getPreis() {
		return this.preis;
	}

	/**
	 * Gibt den aktuellen Lagerbestand des Artikels zurück.
	 *
	 * @return Der aktuelle Lagerbestand des Artikels.
	 */

	public int getLagerbestand() {
		return lagerbestand;
	}

	/**
	 * Setzt den Lagerbestand des Artikels auf den angegebenen Wert.
	 *
	 * @param bestand: Der neue Lagerbestand des Artikels.
	 * @throws IllegalArgumentException Wenn der neue Lagerbestand negativ ist.
	 */

	public void setLagerbestand(int bestand) {
		if (bestand < 0) {
			throw new IllegalArgumentException("Der Lagerbestand darf nicht negativ sein.");
		} else {
			this.lagerbestand = bestand;
		}

	}

	/**
	 * Gibt eine Zeichenfolgenrepräsentation dieses Lagerpostens zurück.
	 *
	 * @return Eine Zeichenfolgenrepräsentation des Lagerpostens.
	 */

	@Override
	public String toString() {
		return "Artikel: " + artikel.getName() + ",Preis: " + getPreis() + ",Lagerbestand: " + getLagerbestand();

	}

}
