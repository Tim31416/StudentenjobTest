package main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lagerverwaltung {

	private Set<String> berechtigteMitarbeiter = new HashSet<>();
	private Set<Lagerposten> lagerbestand = new HashSet<>();

	public Lagerverwaltung() {

	}

	/**
	 * Ermöglicht es einem Mitarbeiter, Berechtigungen für die Lagerverwaltung zu
	 * erhalten, indem seine Mitarbeiter-ID hinzugefügt wird.
	 *
	 * @param ma: Der Mitarbeiter, dem Berechtigungen erteilt werden sollen.
	 */

	public void berechtigungErteilen(Mitarbeiter ma) {
		berechtigteMitarbeiter.add(ma.getID());
	}

	/**
	 * Entzieht einem Mitarbeiter die Berechtigung zur Lagerverwaltung, indem seine
	 * Mitarbeiter-ID entfernt wird.
	 *
	 * @param ma: Der Mitarbeiter, dem Berechtigungen entzogen werden sollen.
	 */

	public void berechtigungZuruecksetzen(Mitarbeiter ma) {
		berechtigteMitarbeiter.remove(ma.getID());
	}

	/**
	 * Gibt den aktuellen Lagerbestand aus, indem alle Lagerposten angezeigt werden.
	 */

	public void lagerbestandAusgeben() {
		lagerbestand.forEach(lp -> System.out.println(lp.toString()));
	}

	/**
	 * Bucht einen Wareneingang in das Lager, nachdem die Berechtigung des
	 * Mitarbeiters überprüft wurde.
	 *
	 * @param ma:     Der Mitarbeiter, der den Wareneingang bucht.
	 * @param a:      Der Artikel, der hinzugefügt wird.
	 * @param anzahl: Die Anzahl der hinzugefügten Artikel.
	 * @param preis:  Der Preis pro Artikel.
	 */

	public void wareneingangBuchen(Mitarbeiter ma, Artikel a, int anzahl, double preis) {
		mitarbeiterPruefen(ma);
		Lagerposten neuerPosten = new Lagerposten(a, anzahl, preis);
		lagerbestand.add(neuerPosten);
	}

	/**
	 * Führt eine Bestellung aus, nachdem die Berechtigung des Mitarbeiters
	 * überprüft wurde. Berechnet den Gesamtpreis für die Bestellung und gibt eine
	 * Bestellbestätigung zurück.
	 *
	 * @param ma:         Der Mitarbeiter, der die Bestellung ausführt.
	 * @param bestellung: Die Liste der zu bestellenden Artikel.
	 * @return Eine Bestellbestätigung, die den Erfolg der Bestellung und den
	 *         Gesamtpreis enthält.
	 * @throws IllegalStateException Wenn ein Artikel in der Bestellung nicht im
	 *                               Lagerbestand vorhanden ist.
	 */

	public Bestellbestaetigung bestellungAusfuehren(Mitarbeiter ma, List<Bestellposten> bestellung) {
		mitarbeiterPruefen(ma);
		double gesamtpreis = 0;

		for (Bestellposten bp : bestellung) {

			int anz = bp.getAnzahl();
			String aID = bp.getArtikelID();

			boolean artikelImBestand = lagerbestand.stream().map(Lagerposten::getArtikel)
					.anyMatch(a -> aID.equals(a.getID()));

			if (artikelImBestand == false) {
				throw new IllegalStateException(
						"Artikel mit der ID " + bp.getArtikelID() + " ist aktuell nicht im Lagerbestand.");

			} else {
				lagerbestand.stream().filter(lp -> aID.equals(lp.getArtikel().getID()))
						.forEach(lp -> lp.setLagerbestand(lp.getLagerbestand() - anz));
				Double preis = lagerbestand.stream().filter(lp -> aID.equals(lp.getArtikel().getID()))
						.mapToDouble(Lagerposten::getPreis).reduce(0, Double::sum);
				gesamtpreis = gesamtpreis + preis * anz;
			}
		}

		return new Bestellbestaetigung(true, gesamtpreis);

	}

	/**
	 * Überprüft, ob ein Mitarbeiter autorisiert ist und wirft Ausnahmen, wenn der
	 * Mitarbeiter nicht autorisiert ist oder nicht angegeben wurde.
	 *
	 * @param ma: Der zu überprüfende Mitarbeiter.
	 * @return "true", wenn der Mitarbeiter autorisiert ist, ansonsten Ausnahme
	 *         werfen.
	 * @throws IllegalArgumentException Wenn kein Mitarbeiter angegeben wurde oder
	 *                                  der Mitarbeiter nicht autorisiert ist.
	 */

	private boolean mitarbeiterPruefen(Mitarbeiter ma) {
		if (ma == null) {
			throw new IllegalArgumentException("Kein Mitarbeiter angegeben.");
		} else if (!berechtigteMitarbeiter.contains(ma.getID())) {
			throw new IllegalArgumentException("Der angegebene Mitarbeiter ist nicht berechtigt.");
		} else {
			return true;
		}

	}
}
