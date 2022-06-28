import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class SpielerAutoTest {

    private PApplet app;

    @Test
    public void bewegeAutoNachLinksTest() {
        SpielerAuto testAuto = new SpielerAuto(app);
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);
        testAuto.bewegeAutoNachLinks();
        assertEquals(startPosition-testAuto.getBewegeObjektUmEinheiten(),testAuto.getPosX());
    }

    @Test
    public void bewegeAutoNachLinksMitVerkehrterSteuerungTest() {
        SpielerAuto testAuto = new SpielerAuto(app);
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);
        testAuto.aendereSteuerung();
        testAuto.bewegeAutoNachLinks();
        assertEquals(startPosition+testAuto.getBewegeObjektUmEinheiten(),testAuto.getPosX());
    }

    @Test
    public void bewegeAutoNachRechtsTest() {
        SpielerAuto testAuto = new SpielerAuto(app);
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);
        testAuto.bewegeAutoNachRechts();
        assertEquals(startPosition+testAuto.getBewegeObjektUmEinheiten(),testAuto.getPosX());
    }

    @Test
    public void bewegeAutoNachRechtsMitVerkehrterSteuerungTest() {
        SpielerAuto testAuto = new SpielerAuto(app);
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);

        testAuto.aendereSteuerung();
        testAuto.bewegeAutoNachRechts();
        assertEquals(startPosition-testAuto.getBewegeObjektUmEinheiten(),testAuto.getPosX());
    }

    @Test
    public void bewegeNachLinksRandTest() {
        SpielerAuto testAuto = new SpielerAuto(app);
        testAuto.setPosX(testAuto.getBegrenzungLinks());
        int startPosition = testAuto.getPosX();
        testAuto.bewegeAutoNachLinks();
        assertEquals(startPosition,testAuto.getPosX());
    }

    @Test
    public void bewegeNachLinksRandTestMitAbstand() {
        SpielerAuto testAuto = new SpielerAuto(app);
        testAuto.setPosX(testAuto.getBegrenzungLinks()+3);
        testAuto.bewegeAutoNachLinks();
        assertEquals(testAuto.getPosX(),testAuto.getBegrenzungLinks());
    }

    @Test
    public void bewegeNachRechtsRandTest() {
        SpielerAuto testAuto = new SpielerAuto(app);
        testAuto.setPosX(testAuto.getBegrenzungRechts());
        int startPosition = testAuto.getPosX();
        testAuto.bewegeAutoNachRechts();
        assertEquals(startPosition,testAuto.getPosX());
    }

    @Test
    public void bewegeNachRechtsRandTestMitAbstand() {
        SpielerAuto testAuto = new SpielerAuto(app);
        testAuto.setPosX(testAuto.getBegrenzungRechts()-3);
        testAuto.bewegeAutoNachRechts();
        assertEquals(testAuto.getPosX(),testAuto.getBegrenzungRechts());
    }

    @Test
    public void andereRichtungAufVerkehrtherumTest() {
        SpielerAuto testAuto = new SpielerAuto(app);
        testAuto.setSteuerungIstVerkehrt(false);
        testAuto.aendereSteuerung();
        assertEquals(testAuto.isSteuerungIstVerkehrt(),true);
    }

    @Test
    public void andereRichtungAufRichtigherumTest() {
        SpielerAuto testAuto = new SpielerAuto(app);
        testAuto.setSteuerungIstVerkehrt(true);
        testAuto.aendereSteuerung();
        assertEquals(testAuto.isSteuerungIstVerkehrt(),false);
    }
}