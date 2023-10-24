package main;

public class Bestellbestaetigung {
	private boolean ausgefuehrt;
	private double gesamtpreis;

	/**
	 * Konstruktor für die Klasse Bestellbestaetigung.
	 *
	 * @param ausgefuehrt: Gibt an, ob die Bestellung ausgeführt wurde (true) oder
	 *                     nicht (false).
	 * @param gesamtpreis: Der Gesamtpreis der Bestellung.
	 * @throws IllegalArgumentException Wenn der Gesamtpreis negativ ist.
	 */

	public Bestellbestaetigung(boolean ausgefuehrt, double gesamtpreis) {
		setAusgefuehrt(ausgefuehrt);
		setGesamtpreis(gesamtpreis);
	}

	/**
	 * Gibt zurück, ob die Bestellung ausgeführt wurde.
	 *
	 * @return "true", wenn die Bestellung ausgeführt wurde, andernfalls "false".
	 */

	public boolean isAusgefuehrt() {
		return ausgefuehrt;
	}

	/**
	 * Legt fest, ob die Bestellung ausgeführt wurde oder nicht.
	 *
	 * @param ausgefuehrt "true", wenn die Bestellung ausgeführt wurde, andernfalls
	 *                    "false".
	 */

	public void setAusgefuehrt(boolean ausgefuehrt) {
		this.ausgefuehrt = ausgefuehrt;
	}

	/**
	 * Gibt den Gesamtpreis der Bestellung zurück.
	 *
	 * @return Der Gesamtpreis der Bestellung.
	 */

	public double getGesamtpreis() {
		return gesamtpreis;
	}

	/**
	 * Legt den Gesamtpreis der Bestellung fest.
	 *
	 * @param gesamtpreis: Der Gesamtpreis der Bestellung.
	 * @throws IllegalArgumentException Wenn der Gesamtpreis negativ ist.
	 */

	public void setGesamtpreis(double gesamtpreis) {
		if (gesamtpreis < 0) {
			throw new IllegalArgumentException("Der Gesamtpreis darf nicht negativ sein.");
		} else {
			this.gesamtpreis = gesamtpreis;
		}
	}
}
