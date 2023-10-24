package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LagerpostenTest {

	@Test
	void testToString() {
		Artikel artikel = new Artikel("123", "laptop", "asus");
		Lagerposten lagerposten = new Lagerposten(artikel, 10, 2.0);
		assertTrue(lagerposten.toString().trim().equals("Artikel: laptop,Preis: 2.0,Lagerbestand: 10"));
	}

	@Test
	void testSetLagerbestand() {
		Artikel artikel = new Artikel("123", "laptop", "asus");
		Lagerposten lagerposten = new Lagerposten(artikel, 100, 2.0);
		lagerposten.setLagerbestand(200);
		assertEquals(200, lagerposten.getLagerbestand());
	}

	@Test
	void testSetLagerbestandExceptionThrown() {
		Artikel artikel = new Artikel("123", "laptop", "asus");
		Lagerposten lagerposten = new Lagerposten(artikel, 100, 2.0);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> lagerposten.setLagerbestand(-200));
		assertTrue(thrown.getMessage().contentEquals("Der Lagerbestand darf nicht negativ sein."));
	}

	@Test
	void testArtikelNullInstanziierung() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Lagerposten(null, 100, 2.0));
		assertTrue(thrown.getMessage().contentEquals("Kein gueltiger Artikel gegeben."));
	}

	@Test
	void testPreisNegativInstanziierung() {
		Artikel artikel = new Artikel("123", "laptop", "asus");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Lagerposten(artikel, 100, -2.0));
		assertTrue(thrown.getMessage().contentEquals("Der Preis darf nicht negativ sein."));
	}

}
