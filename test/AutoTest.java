import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class AutoTest{

    private PApplet app;

    @Test
    public void bewegeAutoNachLinksTest() {
        Auto testAuto = new Auto(app);
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);
        testAuto.bewegeAutoNachLinks();
        assertEquals(startPosition-testAuto.getBewegeObjektUmEinheiten(),testAuto.getPosX());
    }

    @Test
    public void bewegeAutoNachLinksMitVerkehrterSteuerungTest() {
        Auto testAuto = new Auto(app);
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);
        testAuto.aendereSteuerung();
        testAuto.bewegeAutoNachLinks();
        assertEquals(startPosition+testAuto.getBewegeObjektUmEinheiten(),testAuto.getPosX());
    }

    @Test
    public void bewegeAutoNachRechtsTest() {
        Auto testAuto = new Auto(app);
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);
        testAuto.bewegeAutoNachRechts();
        assertEquals(startPosition+testAuto.getBewegeObjektUmEinheiten(),testAuto.getPosX());
    }

    @Test
    public void bewegeAutoNachRechtsMitVerkehrterSteuerungTest() {
        Auto testAuto = new Auto(app);
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);

        testAuto.aendereSteuerung();
        testAuto.bewegeAutoNachRechts();
        assertEquals(startPosition-testAuto.getBewegeObjektUmEinheiten(),testAuto.getPosX());
    }

    @Test
    public void bewegeNachLinksRandTest() {
        Auto testAuto = new Auto(app);
        testAuto.setPosX(testAuto.getBegrenzungLinks());
        int startPosition = testAuto.getPosX();
        testAuto.bewegeAutoNachLinks();
        assertEquals(startPosition,testAuto.getPosX());
    }

    @Test
    public void bewegeNachLinksRandTestMitAbstand() {
        Auto testAuto = new Auto(app);
        testAuto.setPosX(testAuto.getBegrenzungLinks()+3);
        testAuto.bewegeAutoNachLinks();
        assertEquals(testAuto.getPosX(),testAuto.getBegrenzungLinks());
    }

    @Test
    public void bewegeNachRechtsRandTest() {
        Auto testAuto = new Auto(app);
        testAuto.setPosX(testAuto.getBegrenzungRechts());
        int startPosition = testAuto.getPosX();
        testAuto.bewegeAutoNachRechts();
        assertEquals(startPosition,testAuto.getPosX());
    }

    @Test
    public void bewegeNachRechtsRandTestMitAbstand() {
        Auto testAuto = new Auto(app);
        testAuto.setPosX(testAuto.getBegrenzungRechts()-3);
        testAuto.bewegeAutoNachRechts();
        assertEquals(testAuto.getPosX(),testAuto.getBegrenzungRechts());
    }

    @Test
    public void andereRichtungAufVerkehrtherumTest() {
        Auto testAuto = new Auto(app);
        testAuto.setSteuerungIstVerkehrt(false);
        testAuto.aendereSteuerung();
        assertEquals(testAuto.isSteuerungIstVerkehrt(),true);
    }

    @Test
    public void andereRichtungAufRichtigherumTest() {
        Auto testAuto = new Auto(app);
        testAuto.setSteuerungIstVerkehrt(true);
        testAuto.aendereSteuerung();
        assertEquals(testAuto.isSteuerungIstVerkehrt(),false);
    }
}