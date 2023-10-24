package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BestellbestaetigungTest {
	@Test
	void testSetAusgefuehrt() {
		Bestellbestaetigung bestellbestaetigung = new Bestellbestaetigung(false, 100);
		bestellbestaetigung.setAusgefuehrt(true);
		assertTrue(bestellbestaetigung.isAusgefuehrt());
	}

	@Test
	void testSetGesamtpreis() {
		Bestellbestaetigung bestellbestaetigung = new Bestellbestaetigung(false, 100);
		bestellbestaetigung.setGesamtpreis(200);
		assertEquals(200, bestellbestaetigung.getGesamtpreis());
	}

	@Test
	void testSetGesamtpreisExceptionThrown() {
		Bestellbestaetigung bestellbestaetigung = new Bestellbestaetigung(false, 100);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> bestellbestaetigung.setGesamtpreis(-1));
		assertTrue(thrown.getMessage().contentEquals("Der Gesamtpreis darf nicht negativ sein."));
	}
}
