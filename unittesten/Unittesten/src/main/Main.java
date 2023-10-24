package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Lagerverwaltung lagerverwaltung = new Lagerverwaltung();
		Mitarbeiter mitarbeiter = new Mitarbeiter(null);
		lagerverwaltung.berechtigungErteilen(mitarbeiter);
		Artikel artikel = new Artikel("1", "Laptops", "Laptops");
		lagerverwaltung.wareneingangBuchen(mitarbeiter, artikel, 50, 100.0);
		lagerverwaltung.lagerbestandAusgeben();
		Bestellposten bestellposten = new Bestellposten("1", 20);
		List<Bestellposten> bestellpostenListe = new ArrayList<>();
		bestellpostenListe.add(bestellposten);
		Bestellbestaetigung bestellbestaetigung = lagerverwaltung.bestellungAusfuehren(mitarbeiter, bestellpostenListe);
		System.out.println("Ausgeführt: " + bestellbestaetigung.isAusgefuehrt() + ", Gesamtpreis: "
				+ bestellbestaetigung.getGesamtpreis());
		lagerverwaltung.lagerbestandAusgeben();
	}
}
