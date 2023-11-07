package main;




import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({MitarbeiterTest.class, ArtikelTest.class, BestellbestaetigungTest.class, BestellpostenTest.class, LagerpostenTest.class, LagerverwaltungTest.class}) // Hier alle Testklassen auflisten
public class AllTests {
    // Diese Klasse enthält keine Implementierung, da sie nur als Suite fungiert
}