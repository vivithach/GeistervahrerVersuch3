import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class AutoTest{

    PApplet app;

    @Test
    public void bewegeLinksTest() {
        Auto testAuto = new Auto(app);
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);
        testAuto.bewegeAutoNachLinks();
        assertEquals(startPosition-testAuto.getBewegeObjektUmEinheiten(),testAuto.getPosX());
    }

    @Test
    public void bewegeLinksMitSchlüsselTest() {
        Auto testAuto = new Auto(app);
        testAuto.aendereSteuerung();
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);
        testAuto.bewegeAutoNachLinks();
        assertEquals(startPosition+testAuto.getBewegeObjektUmEinheiten(),testAuto.getPosX());
    }

    @Test
    public void bewegeRechtsTest() {
        Auto testAuto = new Auto(app);
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);
        testAuto.bewegeAutoNachRechts();
        assertEquals(startPosition+testAuto.getBewegeObjektUmEinheiten(),testAuto.getPosX());
    }

    @Test
    public void bewegeRechtsMitSchlüsselTest() {
        Auto testAuto = new Auto(app);
        testAuto.aendereSteuerung();
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);
        testAuto.bewegeAutoNachRechts();
        assertEquals(startPosition-testAuto.getBewegeObjektUmEinheiten(),testAuto.getPosX());
    }

    @Test
    public void rechterRandTest() {
        Auto testAuto = new Auto(app);
        testAuto.setPosX(testAuto.getBegrenzungRechts());
        int startPosition = testAuto.getPosX();
        testAuto.bewegeAutoNachRechts();
        assertEquals(startPosition,testAuto.getPosX());

        testAuto.setPosX(testAuto.getBegrenzungRechts()-3);
        testAuto.bewegeAutoNachRechts();
        assertEquals(testAuto.getPosX(),testAuto.getBegrenzungRechts());
    }

    @Test
    public void linkerRandTest() {
        Auto testAuto = new Auto(app);
        testAuto.setPosX(testAuto.getBegrenzungLinks());
        int startPosition = testAuto.getPosX();
        testAuto.bewegeAutoNachLinks();
        assertEquals(startPosition,testAuto.getPosX());

        testAuto.setPosX(testAuto.getBegrenzungRechts()+3);
        testAuto.bewegeAutoNachRechts();
        assertEquals(testAuto.getPosX(),testAuto.getBegrenzungRechts());
    }

    @Test
    public void andereRichtungTest() {
        Auto testAuto = new Auto(app);
        testAuto.setSteuerungIstVerkehrt(false);
        testAuto.aendereSteuerung();
        assertEquals(testAuto.isSteuerungIstVerkehrt(),true);
        testAuto.aendereSteuerung();
        assertEquals(testAuto.isSteuerungIstVerkehrt(),false);
        testAuto.aendereSteuerung();
        assertEquals(testAuto.isSteuerungIstVerkehrt(),true);
    }
}