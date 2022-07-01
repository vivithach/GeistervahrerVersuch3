import org.junit.Test;
import processing.core.PApplet;
import static org.junit.Assert.assertEquals;

public class ModellTest{

    @Test
    public void fuegeGegenerAutoHinzuTest() {
        Modell testModell = new Modell(new PApplet());
        int anzahl = 1;
        testModell.hinzufuegeGegnerautos(anzahl);
        assertEquals(anzahl,testModell.gegnerAutos.size());
    }

    @Test
    public void loescheGegnerAutoTest() {
        Modell testModell = new Modell(new PApplet());
        int anzahl = 2;
        testModell.hinzufuegeGegnerautos(anzahl);
        testModell.gegnerAutos.get(0).setPosY(1000);
        testModell.loescheGegnerAutos();
        assertEquals(anzahl-1,testModell.gegnerAutos.size());
    }

    @Test
    public void fuegeHerzItemsHinzuTest() {
        Modell testModell = new Modell(new PApplet());
        int anzahl = 1;
        testModell.hinzufuegeHerzItems(anzahl);
        assertEquals(anzahl,testModell.herzItems.size());
    }

    @Test
    public void loescheHerzItemsTest() {
        Modell testModell = new Modell(new PApplet());
        int anzahl = 1;
        testModell.hinzufuegeHerzItems(anzahl);
        testModell.hinzufuegeHerzItems(anzahl);
        testModell.herzItems.get(0).setPosY(1000);
        testModell.loescheHerzItems();
        assertEquals(anzahl,testModell.herzItems.size());
    }

    @Test
    public void fuegeMuenzItemsHinzuTest() {
        Modell testModell = new Modell(new PApplet());
        int wert = 0;
        testModell.hinzufuegeMuenzItems(wert);
        assertEquals(1,testModell.muenzItems.size());
    }

    @Test
    public void loescheHMuenzItemsTest() {
        Modell testModell = new Modell(new PApplet());
        int wert = 0;
        testModell.hinzufuegeMuenzItems(wert);
        testModell.hinzufuegeMuenzItems(wert);
        testModell.muenzItems.get(0).setPosY(1000);
        testModell.loescheMuenzItems();
        assertEquals(1,testModell.muenzItems.size());
    }

    @Test
    public void fuegeSpeedwayItemsHinzuTest() {
        Modell testModell = new Modell(new PApplet());
        int wert = 1;
        testModell.hinzufuegeSpeedwayItems(wert);
        assertEquals(1,testModell.speedwayItems.size());
    }

    @Test
    public void loescheSpeedwayItemsTest() {
        Modell testModell = new Modell(new PApplet());
        int wert = 1;
        testModell.hinzufuegeSpeedwayItems(wert);
        testModell.hinzufuegeSpeedwayItems(wert);
        testModell.speedwayItems.get(0).setPosY(2000);
        testModell.loescheSpeedwayItems();
        assertEquals(1, testModell.speedwayItems.size());
    }

    @Test
    public void fuegeSchraubenschluesselItemsHinzuTest() {
        Modell testModell = new Modell(new PApplet());
        int wert = 1;
        testModell.hinzufuegeSchraubenschuesselItems(wert);
        assertEquals(1,testModell.schraubenschluesselItems.size());
    }

    @Test
    public void loescheSchraubenschluesseItemsTest() {
        Modell testModell = new Modell(new PApplet());
        int wert = 1;
        testModell.hinzufuegeSchraubenschuesselItems(wert);
        testModell.hinzufuegeSchraubenschuesselItems(wert);
        testModell.schraubenschluesselItems.get(0).setPosY(1000);
        testModell.loescheSchraubenschluesselItems();
        assertEquals(1, testModell.schraubenschluesselItems.size());
    }





}

