package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BestellpostenTest {
	@Test
	void testSetArtikelId() {
		Bestellposten bestellposten = new Bestellposten("1", 100);
		bestellposten.setArtikelID("2");
		assertEquals("2", bestellposten.getArtikelID());
	}

	@Test
	void testSetAnzahl() {
		Bestellposten bestellposten = new Bestellposten("1", 100);
		bestellposten.setAnzahl(50);
		assertEquals(50, bestellposten.getAnzahl());
	}

	@Test
	void testSetArtikelIdExceptionThrownNull() {
		Bestellposten bestellposten = new Bestellposten("1", 100);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> bestellposten.setArtikelID(null));
		assertTrue(thrown.getMessage().contentEquals("Die ArtikelID darf nicht null sein."));
	}

	@Test
	void testSetArtikelIdExceptionThrownEmptyString() {
		Bestellposten bestellposten = new Bestellposten("1", 100);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> bestellposten.setArtikelID(" "));
		assertTrue(thrown.getMessage().contentEquals("Die ArtikelID darf nicht null sein."));
	}

	@Test
	void testSetAnzahlExceptionThrown() {
		Bestellposten bestellposten = new Bestellposten("1", 100);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> bestellposten.setAnzahl(-1));
		assertTrue(thrown.getMessage().contentEquals("Die Anzahl darf nicht negativ sein."));
	}
}
