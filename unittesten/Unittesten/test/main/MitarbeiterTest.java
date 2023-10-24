package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MitarbeiterTest {
	@Test
	void testSetName() {
		Mitarbeiter mitarbeiter = new Mitarbeiter("Klaus");
		mitarbeiter.setName("Michael");
		assertEquals("Michael", mitarbeiter.getName());
	}

	@Test
	void testSetNameIdExceptionThrownNull() {
		Mitarbeiter mitarbeiter = new Mitarbeiter("Klaus");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> mitarbeiter.setName(null));
		assertTrue(thrown.getMessage().contentEquals("Keinen Namen angegeben."));
	}

	@Test
	void testSetNameIdExceptionThrownEmptyString() {
		Mitarbeiter mitarbeiter = new Mitarbeiter("Klaus");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> mitarbeiter.setName(" "));
		assertTrue(thrown.getMessage().contentEquals("Keinen Namen angegeben."));
	}
}
