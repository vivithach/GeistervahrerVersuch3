import org.junit.Test;
import processing.core.PApplet;
import static org.junit.Assert.assertEquals;

public class ModellTest{

    @Test
    public void fuegeGegenerAutoHinzuTest() {
        Modell testModell = new Modell(new PApplet());
        int anzahl = 1;
        testModell.fuegeGegeneAutosHinzu(anzahl);
        assertEquals(anzahl,testModell.gegenerAutos.size());
    }

    @Test
    public void loescheGegnerAutoTest() {
        Modell testModell = new Modell(new PApplet());
        int anzahl = 2;
        testModell.fuegeGegeneAutosHinzu(anzahl);
        testModell.gegenerAutos.get(0).setPosY(1000);
        testModell.loescheGegnerAuto();
        assertEquals(anzahl-1,testModell.gegenerAutos.size());
    }

    @Test
    public void fuegeHerzItemsHinzuTest() {
        Modell testModell = new Modell(new PApplet());
        int anzahl = 1;
        testModell.feugeHerzItemsHinzu(anzahl);
        assertEquals(anzahl,testModell.herzItems.size());
    }

    @Test
    public void loescheHerzItemsTest() {
        Modell testModell = new Modell(new PApplet());
        int anzahl = 1;
        testModell.feugeHerzItemsHinzu(anzahl);
        testModell.feugeHerzItemsHinzu(anzahl);
        testModell.herzItems.get(0).setPosY(1000);
        testModell.loescheHerzItem();
        assertEquals(anzahl,testModell.herzItems.size());
    }

    @Test
    public void fuegeMuenzItemsHinzuTest() {
        Modell testModell = new Modell(new PApplet());
        int wert = 0;
        testModell.fuegeMuenzenItemsHinzu(wert);
        assertEquals(1,testModell.muenzItems.size());
    }

    @Test
    public void loescheHMuenzItemsTest() {
        Modell testModell = new Modell(new PApplet());
        int wert = 0;
        testModell.fuegeMuenzenItemsHinzu(wert);
        testModell.fuegeMuenzenItemsHinzu(wert);
        testModell.muenzItems.get(0).setPosY(1000);
        testModell.loescheMuenzeItems();
        assertEquals(1,testModell.muenzItems.size());
    }

    @Test
    public void fuegeSpeedwayItemsHinzuTest() {
        Modell testModell = new Modell(new PApplet());
        int wert = 1;
        testModell.fuegeSpeedwayItemsHinzu(wert);
        assertEquals(1,testModell.speedwayItems.size());
    }

    @Test
    public void loescheSpeedwayItemsTest() {
        Modell testModell = new Modell(new PApplet());
        int wert = 1;
        testModell.fuegeSpeedwayItemsHinzu(wert);
        testModell.fuegeSpeedwayItemsHinzu(wert);
        testModell.speedwayItems.get(0).setPosY(2000);
        testModell.loescheSpeedwayItems();
        assertEquals(1, testModell.speedwayItems.size());
    }

    @Test
    public void fuegeSchraubenschluesselItemsHinzuTest() {
        Modell testModell = new Modell(new PApplet());
        int wert = 1;
        testModell.fuegeSchraubenschuesselItemsHinzu(wert);
        assertEquals(1,testModell.schraubenschluesselItems.size());
    }

    @Test
    public void loescheSchraubenschluesseItemsTest() {
        Modell testModell = new Modell(new PApplet());
        int wert = 1;
        testModell.fuegeSchraubenschuesselItemsHinzu(wert);
        testModell.fuegeSchraubenschuesselItemsHinzu(wert);
        testModell.schraubenschluesselItems.get(0).setPosY(1000);
        testModell.loescheSchraubenschluesselItems();
        assertEquals(1, testModell.schraubenschluesselItems.size());
    }





}

