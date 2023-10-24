package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class LagerverwaltungTest {
	private PrintStream out = System.out;
	private ByteArrayOutputStream outcontent = new ByteArrayOutputStream();

	@BeforeEach
	void before() {
		System.setOut(new PrintStream(outcontent));
	}

	@AfterEach
	void after() {
		System.setOut(out);
	}

	@Test
	void testWareneingangBuchenBerechtigterMItarbeiter() {
		Lagerverwaltung lagerverwaltung = new Lagerverwaltung();
		Mitarbeiter mitarbeiter = new Mitarbeiter("Klaus");
		Artikel artikel = new Artikel("123", "laptop", "asus");
		lagerverwaltung.berechtigungErteilen(mitarbeiter);
		lagerverwaltung.wareneingangBuchen(mitarbeiter, artikel, 10, 2.0);
		lagerverwaltung.lagerbestandAusgeben();
		assertTrue(outcontent.toString().trim().equals("Artikel: laptop,Preis: 2.0,Lagerbestand: 10"));
	}

	@Test
	void testWareneingangBuchenNICHTBerechtigterMItarbeiter() {
		Lagerverwaltung lagerverwaltung = new Lagerverwaltung();
		Mitarbeiter mitarbeiter = new Mitarbeiter("Klaus");
		Artikel artikel = new Artikel("123", "laptop", "asus");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> lagerverwaltung.wareneingangBuchen(mitarbeiter, artikel, 10, 2.0));
		assertTrue(thrown.getMessage().contentEquals("Der angegebene Mitarbeiter ist nicht berechtigt."));

	}

	@Test
	void testWareneingangBuchenNICHTBerechtigterMItarbeiterNull() {
		Lagerverwaltung lagerverwaltung = new Lagerverwaltung();
		Mitarbeiter mitarbeiter = new Mitarbeiter("Klaus");
		Artikel artikel = new Artikel("123", "laptop", "asus");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> lagerverwaltung.wareneingangBuchen(null, artikel, 10, 2.0));
		assertTrue(thrown.getMessage().contentEquals("Kein Mitarbeiter angegeben."));

	}

	@Test
	void testBestellungAusfuehrenEinBestellposten() {
		Lagerverwaltung lagerverwaltung = new Lagerverwaltung();
		Mitarbeiter mitarbeiter = new Mitarbeiter("Klaus");
		Artikel artikel = new Artikel("123", "laptop", "asus");
		lagerverwaltung.berechtigungErteilen(mitarbeiter);
		lagerverwaltung.wareneingangBuchen(mitarbeiter, artikel, 10, 2.0);
		Bestellposten bestellposten = new Bestellposten("123", 5);
		List<Bestellposten> bestellpostenListe = new ArrayList<>();
		bestellpostenListe.add(bestellposten);
		Bestellbestaetigung bestellbestaetigung = lagerverwaltung.bestellungAusfuehren(mitarbeiter, bestellpostenListe);
		assertTrue(bestellbestaetigung.isAusgefuehrt() == true && bestellbestaetigung.getGesamtpreis() == 10.0);
	}

	@Test
	void testBestellungAusfuehrenArtikelNichtImBestand() {
		Lagerverwaltung lagerverwaltung = new Lagerverwaltung();
		Mitarbeiter mitarbeiter = new Mitarbeiter("Klaus");
		Artikel artikel = new Artikel("123", "laptop", "asus");
		lagerverwaltung.berechtigungErteilen(mitarbeiter);
		Bestellposten bestellposten = new Bestellposten("123", 5);
		List<Bestellposten> bestellpostenListe = new ArrayList<>();
		bestellpostenListe.add(bestellposten);
		IllegalStateException thrown = assertThrows(IllegalStateException.class,
				() -> lagerverwaltung.bestellungAusfuehren(mitarbeiter, bestellpostenListe));
		assertTrue(thrown.getMessage().contentEquals("Artikel mit der ID 123 ist aktuell nicht im Lagerbestand."));
	}

	@Test
	void testBestellungAusfuehrenMehrereBestellposten() {
		Lagerverwaltung lagerverwaltung = new Lagerverwaltung();
		Mitarbeiter mitarbeiter = new Mitarbeiter("Klaus");
		Artikel artikel1 = new Artikel("123", "laptop", "asus");
		Artikel artikel2 = new Artikel("124", "tastatur", "asus");
		Artikel artikel3 = new Artikel("125", "monitor", "asus");
		lagerverwaltung.berechtigungErteilen(mitarbeiter);
		lagerverwaltung.wareneingangBuchen(mitarbeiter, artikel1, 10, 2.0);
		lagerverwaltung.wareneingangBuchen(mitarbeiter, artikel2, 10, 0.1);
		lagerverwaltung.wareneingangBuchen(mitarbeiter, artikel3, 10, 1.0);
		Bestellposten bestellposten1 = new Bestellposten("123", 5);
		Bestellposten bestellposten2 = new Bestellposten("124", 2);
		Bestellposten bestellposten3 = new Bestellposten("125", 1);
		List<Bestellposten> bestellpostenListe = new ArrayList<>();
		bestellpostenListe.add(bestellposten1);
		bestellpostenListe.add(bestellposten2);
		bestellpostenListe.add(bestellposten3);
		Bestellbestaetigung bestellbestaetigung = lagerverwaltung.bestellungAusfuehren(mitarbeiter, bestellpostenListe);
		assertTrue(bestellbestaetigung.isAusgefuehrt() == true && bestellbestaetigung.getGesamtpreis() == 11.2);
	}

	@Test
	void testBestellungAusfuehrenNICHTBerechtigterMitarbeiter() {
		Lagerverwaltung lagerverwaltung = new Lagerverwaltung();
		Mitarbeiter mitarbeiter = new Mitarbeiter("Klaus");
		Artikel artikel = new Artikel("123", "laptop", "asus");
		lagerverwaltung.berechtigungErteilen(mitarbeiter);
		lagerverwaltung.wareneingangBuchen(mitarbeiter, artikel, 10, 2.0);
		Bestellposten bestellposten = new Bestellposten("123", 5);
		List<Bestellposten> bestellpostenListe = new ArrayList<>();
		bestellpostenListe.add(bestellposten);
		lagerverwaltung.berechtigungZuruecksetzen(mitarbeiter);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> lagerverwaltung.bestellungAusfuehren(mitarbeiter, bestellpostenListe));
		assertTrue(thrown.getMessage().contentEquals("Der angegebene Mitarbeiter ist nicht berechtigt."));

	}

	@Test
	void testMitarbeiterPruefenNull() {
		Lagerverwaltung lagerverwaltung = new Lagerverwaltung();
		Artikel artikel = new Artikel("123", "laptop", "asus");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> lagerverwaltung.wareneingangBuchen(null, artikel, 10, 2.0));
		assertTrue(thrown.getMessage().contentEquals("Kein Mitarbeiter angegeben."));

	}

}
