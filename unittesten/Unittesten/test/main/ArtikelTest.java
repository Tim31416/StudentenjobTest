package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArtikelTest {
	@Test
	void testSetId() {
		Artikel artikel = new Artikel("1", "produkt", "gut");
		artikel.setID("2");
		assertEquals("2", artikel.getID());
	}

	@Test
	void testSetName() {
		Artikel artikel = new Artikel("1", "produkt", "gut");
		artikel.setName("produkt2");
		assertEquals("produkt2", artikel.getName());
	}

	@Test
	void testSetBeschreibung() {
		Artikel artikel = new Artikel("1", "produkt", "gut");
		artikel.setBeschreibung("sehr gut");
		assertEquals("sehr gut", artikel.getBeschreibung());
	}

	@Test
	void testSetIdExceptionThrownEmtpyStringNull() {
		Artikel artikel = new Artikel("1", "produkt", "gut");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> artikel.setID(null));
		assertTrue(thrown.getMessage().contentEquals("Keine gültige ID angegeben."));
	}

	@Test
	void testSetIdExceptionThrownEmtpyStringEmptyString() {
		Artikel artikel = new Artikel("1", "produkt", "gut");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> artikel.setID(" "));
		assertTrue(thrown.getMessage().contentEquals("Keine gültige ID angegeben."));
	}

	@Test
	void testSetNameExceptionThrownNull() {
		Artikel artikel = new Artikel("1", "produkt", "gut");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> artikel.setName(null));
		assertTrue(thrown.getMessage().contentEquals("Kein gültiger Namen angegeben."));
	}

	@Test
	void testSetNameExceptionThrownEmptyString() {
		Artikel artikel = new Artikel("1", "produkt", "gut");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> artikel.setName(" "));
		assertTrue(thrown.getMessage().contentEquals("Kein gültiger Namen angegeben."));
	}

	@Test
	void testSetBeschreibungExceptionThrownNull() {
		Artikel artikel = new Artikel("1", "produkt", "gut");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> artikel.setBeschreibung(null));
		assertTrue(thrown.getMessage().contentEquals("Keine gültige Beschreibung angegeben."));
	}

	@Test
	void testSetBeschreibungExceptionThrownEmptyString() {
		Artikel artikel = new Artikel("1", "produkt", "gut");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> artikel.setBeschreibung(" "));
		assertTrue(thrown.getMessage().contentEquals("Keine gültige Beschreibung angegeben."));
	}
}
